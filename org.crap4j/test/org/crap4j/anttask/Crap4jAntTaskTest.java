package org.crap4j.anttask;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildFileTest;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.Path;
import org.crap4j.Crap4jTestFileSystemUtility;
import org.crap4j.util.FileUtil;

import junit.framework.TestCase;

public class Crap4jAntTaskTest extends BuildFileTest{
  
  
	private Crap4jTestFileSystemUtility fileSystemUtil;
  private String testDirRoot;
  private String projectFolder;
  private String projectName;
  private String projectDir;
  private String srcDir;
  private String defaultTestDir2;
  private String defaultTestDir1;
  private String classpathLib;
  private String classDir;
  private String testDir1;
  private String testDir2;
  private String defaultClassDir1;
  private String defaultClassDir2;
  private String classDir2;

  public Crap4jAntTaskTest(String name) {
    super(name);
  }

	@Override
	protected void setUp() throws Exception {
	   fileSystemUtil = new Crap4jTestFileSystemUtility();
	   createDefaultProject();
	}
	
	

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    fileSystemUtil.removeDirsCreated();
    testDirRoot = null;
    defaultClassDir1 = null;
    defaultTestDir2 = null;
    defaultTestDir1 = null;

  }

  private void createDefaultProject() throws Exception {
    testDirRoot = "crap4jant";
    projectFolder = fileSystemUtil.createTestFileSystem(testDirRoot);
    projectName = "testProjectDir";
    projectDir = fileSystemUtil.makeDir(projectFolder, projectName);
    srcDir = fileSystemUtil.makeDir(projectDir, "src");
    defaultClassDir1 = "path1";
    defaultClassDir2 = "path2";
    defaultTestDir2 = "agitar"+File.separator+"test_bin";
    defaultTestDir1 = "test_bin";
    classpathLib = "lib"+File.separator+"junit.jar";
    
    classDir = fileSystemUtil.makeDir(projectDir, defaultClassDir1);
    classDir2 = fileSystemUtil.makeDir(projectDir, defaultClassDir2);
    testDir1 = fileSystemUtil.makeDir(projectDir, defaultTestDir1);
    testDir2 = fileSystemUtil.makeDir(projectDir, defaultTestDir2);
    
    fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
    fileSystemUtil.addDefaultTestClassToDefaultPackage(classDir);
  }

	public void testProjectDirSetButNotExist() throws Exception {
    configureProject("test/org/crap4j/anttask/test.xml");
    try {
      Crap4jAntTask task = new Crap4jAntTask(new Project());
      File f = new File(System.getProperty("java.io.tmpdir"), "Crap4jAntTaskTest");
      if (f.exists())
        f.delete();
      task.setProjectDir(f);
      task.execute();
      fail("Should have thrown project dir does not exist");
    } catch (BuildException e) {      
    }   

  }

  public void testProjectDirSetProperlyClassesNotSet() throws Exception {
    configureProject("test/org/crap4j/anttask/test2.xml");
    File f = null;
    try {
      try {
        Crap4jAntTask task = new Crap4jAntTask(new Project());
        f = new File(System.getProperty("java.io.tmpdir"), "Crap4jAntTaskTest");
        if (!f.exists())
          f.mkdir();
        task.setProjectDir(f);
        task.execute();
        fail("Should have thrown exception for null classes");
      } catch (BuildException e) {}
    } finally {
      if (f != null)
        f.delete();
    }
  }
  
  public void testProjectSetProperly() throws Exception {
    configureProject("test/org/crap4j/anttask/test2.xml");
    File f = null;
    try {
        Crap4jAntTask task = new Crap4jAntTask(new Project());
        f = new File(System.getProperty("java.io.tmpdir"), "Crap4jAntTaskTest");
        if (!f.exists())
          f.mkdir();
        task.setProjectDir(f);
        Path classDirsPath = task.createClasses();
        classDirsPath.setPath("/tmp/Crap4jAntTaskTest/bin");
        task.setClasses(classDirsPath);
        task.execute();
    } finally {
      if (f != null)
        f.delete();
    }
  }

  
  public void testProjectDirNotSet() throws Exception {
    configureProject("test/org/crap4j/anttask/test2.xml");
    try {
  		Crap4jAntTask task = new Crap4jAntTask(new Project());
  		task.execute();
  		fail("Should have thrown null project dir");
    } catch (BuildException e) {      
    }		
	}
  
  public void testClassDirSet() throws Exception {
    configureProject("test/org/crap4j/anttask/test2.xml");
    executeTarget("run_crap4j");
    Target target = (Target) getProject().getTargets().get("run_crap4j");
    Task[] tasks = target.getTasks();
    Crap4jAntTask t = (Crap4jAntTask) tasks[0];
    assertEquals(projectDir+ File.separator +defaultClassDir1+ File.separator + "DefaultClass.class" + 
                 File.pathSeparator + 
                 projectDir+ File.separator + defaultClassDir1 + File.separator + "DefaultTestCaseClass.class", 
                 Crap4jAntTaskTest.stringPath(t.getClasses()));
  }
  
  public void testClassDirSetWithClasses() throws Exception {
    configureProject("test/org/crap4j/anttask/test2.xml");
    executeTarget("run_crap4j");
    Target target = (Target) getProject().getTargets().get("run_crap4j");
    Task[] tasks = target.getTasks();
    Crap4jAntTask t = (Crap4jAntTask) tasks[0];
    assertEquals(projectDir+ File.separator + defaultClassDir1 + File.separator + "DefaultClass.class"+ 
                 File.pathSeparator + 
                 projectDir+ File.separator + defaultClassDir1 + File.separator + "DefaultTestCaseClass.class", 
                 Crap4jAntTaskTest.stringPath(t.getClasses()));
  }

  public void testClassDirSetWithClassesAndWithExclude() throws Exception {
    configureProject("test/org/crap4j/anttask/test3.xml");
    executeTarget("run_crap4j");
    Target target = (Target) getProject().getTargets().get("run_crap4j");
    Task[] tasks = target.getTasks();
    Crap4jAntTask t = (Crap4jAntTask) tasks[0];
    assertEquals(projectDir+ File.separator + defaultClassDir1 + File.separator + "DefaultClass.class" + 
                 File.pathSeparator + 
                 projectDir+ File.separator +defaultClassDir2, 
                 Crap4jAntTaskTest.stringPath(t.getClasses()));
  }

  public static String stringPath(Path classDirs2) throws IOException {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (String s : classDirs2.list()) {
      if (first)
        first = false;
      else
        b.append(File.pathSeparator);
      b.append(new File(s).getCanonicalPath());
      
    }
    return b.toString();
  }

}
