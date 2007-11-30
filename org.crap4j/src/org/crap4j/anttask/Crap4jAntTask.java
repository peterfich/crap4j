package org.crap4j.anttask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.Path;
import org.crap4j.CrapProject;
import org.crap4j.Main;


public class Crap4jAntTask extends Task {

	private String crap4jHome;
	private boolean debug;
	private boolean dontTest;
	private boolean downloadAverages = true;
	private String server;
	
	private File projectDir;
	private File outputDir;
	
	private Path libClasspath;
	private Path classDirs;
	private Path srcDirs;
	private Path testClassDirs;
	private Project antProject;
		
	public Crap4jAntTask(Project p) {
		this.antProject = p;
	}	
	
	public Path createClassDirs() {    
		if (classDirs == null)
			classDirs = new Path(antProject);
        return classDirs.createPath();
    }

	public Path createSrcDirs() {    
		if (srcDirs == null)
			srcDirs = new Path(antProject);
        return srcDirs.createPath();
    }

	public Path createTestClassDirs() {    
		if (testClassDirs == null)
			testClassDirs = new Path(antProject);
        return testClassDirs.createPath();
    }
	
	public Path createLibClasspath() {    
		if (libClasspath == null)
			libClasspath = new Path(antProject);
        return libClasspath.createPath();
    }

  public String getServer() {
//    if (server == null || server.length() == 0)
      this.server = "http://www.crap4j.org/benchmark/";
    return server;
  }
  
  public void setServer(String server) {
    this.server = server;
  }
  
  @Override
	public void execute() throws BuildException {
    validate(getProjectDir());
    validate("classes", getClassDirs());
    if (isDebug()) {
  		dumpAttributes();
    }
		CrapProject p = createCrapProject();
		try {
			Main.createMain().run(p, isDebug(), isDontTest(), isDownloadAverages(), getServer());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  private void dumpAttributes() {
    System.out.println("projectDir is "+getProjectDir());
    System.out.println("outputDir is "+getOutputDir());
    System.out.println("srcDir is "+getSrcDirs());
    System.out.println("classDirs is "+stringOf(getClassDirs()));
    System.out.println("testClassDirs is "+stringOf(getTestClassDirs()));
    System.out.println("libClasspath is "+stringOf(getLibClasspath()));
    System.out.println("server is "+getServer());
    System.out.println("downloadAverages is "+isDownloadAverages());
    System.out.println("debug is "+isDebug());
    System.out.println("dontTest is "+isDontTest());
  }

  private void validate(File projectDir2) {
    if (projectDir2 == null)
      throw new BuildException("Project Dir, "+projectDir2+" is null");
    if (!projectDir2.exists())
      throw new BuildException("Project Dir, "+projectDir2+" does not exist");
    if (!projectDir2.isDirectory())
      throw new BuildException("Project Dir, "+projectDir2+" is not a directory");
  }

  private void validate(String attributeName, Path path) {
     if (path == null || path.list().length == 0)
       throw new BuildException(attributeName+" cannot be empty.");
  }

  public static String stringOf(Path classDirs2) {
		StringBuilder b = new StringBuilder();
		for (String s : classDirs2.list()) {
			b.append(s);
			b.append(", ");
		}
		return b.toString();
	}

  private CrapProject createCrapProject() {
		CrapProject p = new CrapProject(getProjectDir().getAbsolutePath(), 
				makeListFrom(getLibClasspath()), 
				makeListFrom(getTestClassDirs()), 
				makeListFrom(getClassDirs()), 
				makeListFrom(getSrcDirs()), 
				(getOutputDir() != null) ? getOutputDir().getAbsolutePath() : null);
		return p;
	}

	private List<String> makeListFrom(Path path) {
		List<String> list = new ArrayList<String>();
		if (path == null)
		  return list;
		
		for (String string : path.list()) {
			list.add(string);			
		}
		return list;
	}

	public String getCrap4jHome() {
		return crap4jHome;
	}

	public void setCrap4jHome(String crap4jHome) {
		this.crap4jHome = crap4jHome;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isDontTest() {
		return dontTest;
	}

	public void setDontTest(boolean dontTest) {
		this.dontTest = dontTest;
	}

	
	public Path getLibClasspath() {
		return libClasspath;
	}

	public void setLibClasspath(Path path) {
		this.libClasspath = path;
	}

	public File getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(File outputDir) {
		this.outputDir = outputDir;
	}

	public File getProjectDir() {
		return projectDir;
	}

	public void setProjectDir(File projectDir) {
		this.projectDir = projectDir;
	}

	public Path getSrcDirs() {
		return srcDirs;
	}

	public void setSrcDirs(Path path) {
		this.srcDirs = path;
	}

	public Path getTestClassDirs() {
		return testClassDirs;
	}

	public void setTestClassDirs(Path path) {
		this.testClassDirs = path;
	}

	public Path getClassDirs() {
		return classDirs;
	}

	public void setClassDirs(Path path) {
		this.classDirs = path;
	}

  public boolean isDownloadAverages() {
    return downloadAverages;
  }

  public void setDownloadAverages(boolean downloadAverages) {
    this.downloadAverages = downloadAverages;
  }

}
