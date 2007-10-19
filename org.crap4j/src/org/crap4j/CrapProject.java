package org.crap4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.crap4j.util.FileUtil;
import org.crap4j.util.MyStringBuilder;


public class CrapProject {
	
	private String projectDir;
	private List<String> libClasspaths;
	private List<String> testClassDirs;
	private List<String> classDirs;
	private List<String> sourceDirs;
  private String outputDir;
	
	public List<String> classDirs() {
		return classDirs;
	}

	public List<String> libClasspaths() {
		return libClasspaths;
	}

	public List<String> testClassDirs() {
		return testClassDirs;
	}
  
  public String outputDir() {
    return outputDir;
  }

	public CrapProject(String projectDir, 
			List<String> libClasspath, 
			List<String> testClassDirs,
			List<String> projectClassDirs,
			List<String> sourceDirs, String outputDir) {
		this.projectDir = projectDir;
		this.libClasspaths = makeAbsolute(libClasspath);
		this.testClassDirs = makeAbsolute(testClassDirs);
		this.classDirs = makeAbsolute(projectClassDirs);
		this.sourceDirs = makeAbsolute(sourceDirs);
		if (outputDir == null || outputDir.equals("")) {
			outputDir = projectDir + File.separator + "agitar" + File.separator
					+ "reports" + File.separator + "crap4j";			
			this.outputDir = outputDir;
		} else {
			if (FileUtil.isAbsolute(outputDir)) {
				this.outputDir = outputDir;
			} else {
				this.outputDir = makeFilePathAbsoluteWithProject(outputDir);
			}
		}
    FileUtil.ensureDirectory(outputDir);
	}	

  private List<String> makeAbsolute(List<String> sourceDirs2) {
    List<String> absolutePaths = new ArrayList<String>();
    for (String path : sourceDirs2) {
      if (path == null)
    	continue;
      if (FileUtil.isAbsolute(path))
        absolutePaths.add(path);
      else {
        absolutePaths.add(makeFilePathAbsoluteWithProject(path));
      }
    }
    return absolutePaths;
  }

  private String makeFilePathAbsoluteWithProject(String path) {
    return FileUtil.joinPath(projectDir, path);
  }

  public String projectDir() {
		return projectDir;
	}

	public List<String> sourceDirs() {
		return sourceDirs;
	}

	public List<String> allClasspaths() {
		List<String> all = new ArrayList<String>();
		all.addAll(classDirs());
		all.addAll(testClassDirs());
		all.addAll(libClasspaths());
		return all;
	}

	public List<File> getAllProjectClasses() {
		List<File> classNames = new ArrayList<File>();
		for (String dirName : classDirs) {
			classNames.addAll(getClassesIn(dirName));
		}
		return classNames;
	}

	private List<File> getClassesIn(String dirName) {
		List<File> classNames = new ArrayList<File>();
		for (String classDir : classDirs) {
			classNames.addAll(FileUtil.getAllFilesInDirMatchingPattern(classDir, ".*.class", false));	
		}		
		return classNames;
	}

	public String getCoverageDir() throws IOException {
		return new File(projectDir + File.separator + "agitar" + File.separator + ".results").getCanonicalPath();
	}

	public String getProjectName() {
		return new File(projectDir).getName();
	}

  public void toXml(MyStringBuilder s) {
    itemToXml(s, "project", projectDir);
    collectionToXml(s, "classDirectories", "classDirectory", classDirs);
    collectionToXml(s, "testClassDirectories", "testClassDirectory", testClassDirs);
    collectionToXml(s, "sourceDirectories", "sourceDirectory", sourceDirs);
    collectionToXml(s, "libClasspaths", "libClasspath", libClasspaths);
  }

  public static void collectionToXml(MyStringBuilder s, String collectionName, String itemName, List<String> collection) {
    s.start("<"+collectionName+">");
    for (String item : collection) {      
      itemToXml(s, itemName, item);
    }
    s.end("</"+collectionName+">");
  }

  public static void itemToXml(MyStringBuilder s, String itemName, String item) {
    s.start("<"+itemName+">").append(item).end("</"+itemName+">");
  }

  public File getReportFile() {
    return new File(outputDir(), "report.xml");
  }

  public File getReportHtmlFile() {
    return new File(outputDir(), "index.html");  
  }

}
