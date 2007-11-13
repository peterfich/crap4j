package org.crap4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.crap4j.util.FileUtil;
import org.crap4j.util.MyStringBuilder;


public class CrapProject {
	
	private static final String PROJECT_ID_FILE = ".crap4j_project_id";
  private String projectDir;
	private List<String> libClasspaths;
	private List<String> testClassDirs;
	private List<String> classDirs;
	private List<String> sourceDirs;
  private String outputDir;
  private Long projectId;
	
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
    FileUtil.ensureDirectory(this.outputDir);
    projectId = ensureProjectId();
	}	

  private Long ensureProjectId() {
    Long projectId = loadProjectId();
    if (projectId == null) {
      projectId = makeProjectId();
      writeProjectId(projectId);
    }
    return projectId;    
  }

  private void writeProjectId(Long projectId2) {
    File f = getProjectIdFile();
    DataOutputStream out = null;
    try {
      out = new DataOutputStream(new FileOutputStream(f));
      try {
        out.writeLong(projectId2);
      } catch (IOException e1) {
        e1.printStackTrace();
      } finally {
        if (out != null) {
          try {
            out.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    } catch (FileNotFoundException e2) {
      e2.printStackTrace();
    }
  }

  private Long loadProjectId() {
    Long id = null;
    File f = getProjectIdFile();
    if (f.exists()) {
      DataInputStream io = null;
      try {
        io = new DataInputStream(new FileInputStream(f));
        try {
          id = io.readLong();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (io != null) {
            try {
              io.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return id;
  }

  private File getProjectIdFile() {
    File f = new File(outputDir(), PROJECT_ID_FILE);
    return f;
  }

  private Long makeProjectId() {
    return System.currentTimeMillis();
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
		classNames.addAll(FileUtil.getAllFilesInDirMatchingPattern(dirName, ".*.class", false));	
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
    itemToXml(s, "project_id", projectId.toString());
    itemToXml(s, "timestamp", SimpleDateFormat.getInstance().format(Calendar.getInstance().getTime()));
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

  public Long getProjectId() {
    return projectId;
  }

//  @Override
//  public boolean equals(Object obj) {
//    if (!(obj instanceof CrapProject))
//      return false;
//    CrapProject other = (CrapProject)obj;
//    return (projectId == other.projectId);
//  }
//
//  @Override
//  public int hashCode() {
//    return projectDir.hashCode() + pathHashCode(classDirs()) + pathHashCode(libClasspaths()) + pathHashCode(testClassDirs());
//  }
//
//  private int pathHashCode(List<String> classDirs2) {
//    int hashcode = 0;
//    for (String string : classDirs2) {
//      hashcode += string.hashCode();
//    }
//    return hashcode;
//  }
  
  

}

