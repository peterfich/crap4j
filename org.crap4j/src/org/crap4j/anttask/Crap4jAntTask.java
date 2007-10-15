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
	
	private File projectDir;
	private File outputDir;
	
	private Path libClasspath;
	private Path classDirs;
	private Path srcDirs;
	private Path testClassDirs;
	private Project antProject;
	
	
	
	public void CrapjAntTask(Project p) {
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

	@Override
	public void execute() throws BuildException {
    if (isDebug()) {
  		System.out.println("projectDir is "+getProjectDir());
  		System.out.println("outputDir is "+getOutputDir());
  		System.out.println("srcDir is "+getSrcDirs());
  		System.out.println("classDirs is "+stringOf(getClassDirs()));
  		System.out.println("testClassDirs is "+stringOf(getTestClassDirs()));
  		System.out.println("libClasspath is "+stringOf(getLibClasspath()));
    }
		CrapProject p = createCrapProject();
		try {
			Main.createMain().run(p, isDebug(), isDontTest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String stringOf(Path classDirs2) {
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

}
