package com.xagitarlabs.crap4jeclipse.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crap4j.CrapProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;


public class EclipseCrapProjectBuilder {

  private static final String TEST_FOLDER_PATTERN = "test";
  private CrapProject crapProject;

  public EclipseCrapProjectBuilder(IJavaProject project, String outputDir) {
    List<String> allClasspaths = fullyResolveClasspaths(project, getResolvedClasspathEntries(project));
    List<String> classDirs = getAllClassDirs_FullyResolved(project);
    
    List<String> testClassDirs = selectTestDirsFromClassDirs(classDirs);
    List<String> projectClassDirs = filterTestDirs(classDirs);
    List<String> libClasspath = filterTestAndProjectClassesFrom(allClasspaths, testClassDirs, projectClassDirs);    
    
    crapProject = new CrapProject(getProjectAbsolutePathString(project), 
                                  libClasspath, 
                                  testClassDirs,
                                  projectClassDirs, 
                                  getSrcDirs(project), 
                                  outputDir);
  }
  
  public CrapProject getCrapProject() {
    return crapProject;
  }

  private List<String> filterTestAndProjectClassesFrom(List<String> allClasspaths, 
                                                       List<String> testClassDirs, 
                                                       List<String> projectClassDirs) {
    List<String> libPath = new ArrayList<String>(allClasspaths);
    filterItems(testClassDirs, libPath);
    filterItems(projectClassDirs, libPath);
    return libPath;
  }

  private void filterItems(List<String> items, List<String> target) {
    for (String path : items) {
      if (target.contains(path))
        target.remove(path);
    }
  }


  /**
   * This method retrieves all the children of the project that are packagefragmentroots
   * and returns those that are source fragments. 
   * @param project
   * @return
   */
  private List<String> getSrcDirs(IJavaProject project) {
    ArrayList<String> srcFolders = new ArrayList<String>();
    try {
      IPackageFragmentRoot[] roots = project.getPackageFragmentRoots();
      for (IPackageFragmentRoot root : roots) {
        if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
          srcFolders.add(makeResourceAbsolute(root.getResource()));
        }
      }
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return srcFolders;
  }

  private ArrayList<String> getAllClassDirs_FullyResolved(IJavaProject project) {
    ArrayList<String> classFolders = new ArrayList<String>();
      try {
        for (IClasspathEntry entry : project.getResolvedClasspath(true)) {
          if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
            addToList(classFolders, 
                      getAbsoluteFilePath(getOutputLocation(entry, 
                                                            project.getOutputLocation())));
          }
        }
      } catch (JavaModelException e) {
        e.printStackTrace();
      }
    return classFolders;
  }

  private void addToList(ArrayList<String> list, String path) {
    if (path != null && (!list.contains(path))) {
      list.add(path);
    }
  }

  private IPath getOutputLocation(IClasspathEntry entry, IPath defaultOutputLocation) {
    IPath outputLocation = entry.getOutputLocation();
    if (outputLocation != null)
      return outputLocation;
    return defaultOutputLocation;
  }

  private String getProjectAbsolutePathString(IJavaProject project) {
    return makeResourceAbsolute(project.getResource());
  }

  private String getAbsoluteFilePath(IPath outputLocation) {
    IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(outputLocation);
    if (resource != null) 
      return makeResourceAbsolute(resource);
    return null;
  }

  private String makeResourceAbsolute(IResource resource) {
    return resource.getLocation().toFile().getAbsolutePath();
  }

  private boolean isTestFolder(String location) {
    return false;//location.indexOf(TEST_FOLDER_PATTERN) != -1;
  }

  private ArrayList<String> filterTestDirs(List<String> classFolders) {
    ArrayList<String> testDirs = new ArrayList<String>();
    for (String folder : classFolders) {
      if (!isTestFolder(folder)) {
        addToList(testDirs, folder);
      }
    }
    return testDirs;
  }

  /**
   * All class folders could have tests, so check all of them.
   * @param resolvedClasspath
   * @return
   */
  private List<String> selectTestDirsFromClassDirs(List<String> resolvedClasspath) {
    return resolvedClasspath;
    
    // NO FILTERING NECESSARY -- SEE JAVADOC
//    ArrayList<String> testDirs = new ArrayList<String>();
//    for (String folder : resolvedClasspath) {
//      if (isTestFolder(folder)) {
//        addToList(testDirs, folder);
//      }
//    }
//    return testDirs;
  }

  private List<IRuntimeClasspathEntry> getResolvedClasspathEntries(IJavaProject project) {
    List<IRuntimeClasspathEntry> resolvedEntries = new ArrayList<IRuntimeClasspathEntry>();
    try {
      IRuntimeClasspathEntry[] unresolved = JavaRuntime.computeUnresolvedRuntimeClasspath(project);
      for (int i = 0; i < unresolved.length; i++) {
        IRuntimeClasspathEntry classPathEntry = unresolved[i];
        if (classPathEntry.getClasspathProperty() != IRuntimeClasspathEntry.STANDARD_CLASSES) {
          IRuntimeClasspathEntry[] entries = JavaRuntime.resolveRuntimeClasspathEntry(classPathEntry, project);
          for (int j = 0; j < entries.length; j++) {
            resolvedEntries.add(entries[j]);
          }
        }
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return resolvedEntries;
  }

  private List<String> fullyResolveClasspaths(IJavaProject project,
                                                     List<IRuntimeClasspathEntry> resolvedClasspath) {
    List<String> libClasspath = new ArrayList<String>();
    for (IRuntimeClasspathEntry entry : resolvedClasspath) {
      int entryKind = entry.getClasspathEntry().getEntryKind();
      if (entryKind != IClasspathEntry.CPE_SOURCE && entryKind != IClasspathEntry.CPE_CONTAINER) {
          IPath path = entry.getPath();
          String absoluteFilePath;
          if (path.isAbsolute())
            absoluteFilePath = path.toFile().getAbsolutePath();
          else  
            absoluteFilePath = getAbsoluteFilePath(path);
          libClasspath.add(absoluteFilePath);
      }
    }
    return libClasspath;
  }

}
