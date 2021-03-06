package org.crap4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;
import junit.framework.ComparisonFailure;
import junit.framework.TestCase;

import org.crap4j.util.FileUtil;
import org.crap4j.util.MyStringBuilder;

public class CrapProjectTest extends TestCase {

	private String projectFolder;

	private String projectDir;
	private String srcDir;
	private String classDir;
	private String testDir1;
	private String testDir2;
	private String testDirRoot;
	private String defaultClassDir;
	private String defaultTestDir2;
	private String defaultTestDir1;
	private String projectName;
	private String classpathLib;

  private Crap4jTestFileSystemUtility fileSystemUtil;
	public CrapProjectTest(String name) {
		super(name);
	}

	
	@Override
	protected void setUp() throws Exception {
	  fileSystemUtil = new Crap4jTestFileSystemUtility();
		createDefaultProject();
	}


	private void createDefaultProject() throws IOException {
		testDirRoot = "CrapProjectTestDir";
		projectFolder = fileSystemUtil.createTestFileSystem(testDirRoot);
		projectName = "testCrapProjectCtorDir";
		projectDir = fileSystemUtil.makeDir(projectFolder, projectName);
		srcDir = fileSystemUtil.makeDir(projectDir, "src");
		defaultClassDir = "bin";
		defaultTestDir2 = "agitar"+File.separator+"test_bin";
		defaultTestDir1 = "test_bin";
		classpathLib = "lib"+File.separator+"junit.jar";
		
		classDir = fileSystemUtil.makeDir(projectDir, defaultClassDir);
		testDir1 = fileSystemUtil.makeDir(projectDir, defaultTestDir1);
		testDir2 = fileSystemUtil.makeDir(projectDir, defaultTestDir2);
	}

	@Override
	protected void tearDown() throws Exception {		
	  fileSystemUtil.removeDirsCreated();
		testDirRoot = null;
		defaultClassDir = null;
		defaultTestDir2 = null;
		defaultTestDir1 = null;
	}


  private void assertXmlMatches(String actual, String expected) {
    Pattern pattern = Pattern.compile(expected);
    Matcher m = pattern.matcher(actual);
    if (!m.matches())
      throw new ComparisonFailure("Xml does not match", expected, actual);
  }


  private void assertCoverageDir(CrapProject p) throws IOException {
    assertEquals(projectDir+File.separator+"agitar"+File.separator+".results", p.getCoverageDir());
  }


  private void assertReportsDir(CrapProject p) {
    assertEquals(projectDir+File.separator+"agitar"+File.separator+"reports"+File.separator+"crap4j",
        p.outputDir());
  }


  private void assertReportFile(CrapProject p) {
    assertEquals(projectDir+File.separator+"agitar"+File.separator+"reports"+File.separator+"crap4j"+File.separator+"report.xml", 
        p.getReportFile().toString());
  }

  private void assertReportHtmlFile(CrapProject p) {
    assertEquals(projectDir+File.separator+"agitar"+File.separator+"reports"+File.separator+"crap4j"+File.separator+"index.html", 
        p.getReportHtmlFile().toString());
  }

  private void assertProjectDirectory(CrapProject p) {
    assertEquals(projectDir, p.projectDir());
  }


  private void assertProjectName(CrapProject p) {
    assertEquals(projectName, p.getProjectName());
  }

	public void testCrapProjectCtorFullyWithNormalValues() throws Exception {		
		List<String> classpath = new ArrayList<String>();	
		classpath.add(classpathLib);
		List<String> classDirs = new ArrayList<String>();
		classDirs.add(classDir);		
		List<String> testDirs = new ArrayList<String>();
	
		testDirs.add(testDir1);
		testDirs.add(testDir2);
		
		List<String> sourceDirs = new ArrayList<String>();
		sourceDirs.add(srcDir);
		
		CrapProject p = new CrapProject(projectDir, classpath, testDirs, classDirs,	sourceDirs, null);
		assertProjectName(p);
		assertProjectDirectory(p);
		assertNotNull(p.getProjectId());
		assert(p.getProjectIdFile().exists());
		assertReportsDir(p);
		assertReportFile(p);
		assertReportHtmlFile(p);
		assertCoverageDir(p);
		
		assertEquals(1, p.libClasspaths().size());
		assertEquals(projectDir+File.separator+"lib"+File.separator+"junit.jar", p.libClasspaths().get(0));
		
		assertEquals(1, p.classDirs().size());
		assertEquals(projectDir+File.separator+"bin", p.classDirs().get(0));
		
		assertEquals(1, p.sourceDirs().size());
		assertEquals(projectDir+File.separator+"src", p.sourceDirs().get(0));
		
		assertEquals(2, p.testClassDirs().size());
		assertEquals(projectDir+File.separator+"test_bin", p.testClassDirs().get(0));
		assertEquals(projectDir+File.separator+"agitar/test_bin", p.testClassDirs().get(1));
		assertEquals(4, p.allClasspaths().size());
		
		assertEquals(0, p.allProjectClasses().size());
		
		MyStringBuilder myStringBuilder = new MyStringBuilder();
		p.toXml(myStringBuilder);
		String expectedXmlMatchPattern = "<project>\n  "+projectDir+"\n</project>\n<project_id>\n  "+p.getProjectId()+"\n</project_id>\n<timestamp>\n  ../../.. .{1,2}:.. ..\n</timestamp>\n<classDirectories>\n  <classDirectory>\n    "+projectDir+"/bin\n  </classDirectory>\n</classDirectories>\n<testClassDirectories>\n  <testClassDirectory>\n    "+projectDir+"/test_bin\n  </testClassDirectory>\n  <testClassDirectory>\n    "+projectDir+"/agitar/test_bin\n  </testClassDirectory>\n</testClassDirectories>\n<sourceDirectories>\n  <sourceDirectory>\n    "+projectDir+"/src\n  </sourceDirectory>\n</sourceDirectories>\n<libClasspaths>\n  <libClasspath>\n    "+projectDir+"/lib/junit.jar\n  </libClasspath>\n</libClasspaths>\n";
		assertXmlMatches(myStringBuilder.toString(), expectedXmlMatchPattern);		
	}

	public void testCtorNoPaths() throws Exception {
			CrapProject p = new CrapProject(projectDir, Crap4jTestFileSystemUtility.emptyClasspath, Crap4jTestFileSystemUtility.emptyTestDirs, Crap4jTestFileSystemUtility.emptyClassDirs,  Crap4jTestFileSystemUtility.emptySourceDirs, null);
			assertEquals(0, p.libClasspaths().size());
			assertEquals(0, p.classDirs().size());
			assertEquals(0, p.sourceDirs().size());
			assertEquals(0, p.testClassDirs().size());
			assertEquals(0, p.allClasspaths().size());
			
			assertEquals(0, p.allProjectClasses().size());
	}
	
	public void testCtorNullProjectDir() throws Exception {
		try {
			CrapProject p = new CrapProject(null, Crap4jTestFileSystemUtility.emptyClasspath, Crap4jTestFileSystemUtility.emptyTestDirs, Crap4jTestFileSystemUtility.emptyClassDirs,	Crap4jTestFileSystemUtility.emptySourceDirs, null);
			fail("Should have thrown illegal arg on null projectDir");
		} catch (IllegalArgumentException e) {			
		}
	}
	
	public void testCtorNonExistentProjectDir() throws Exception {
		try {
			CrapProject p = new CrapProject("garblegarbledoesnotexist", Crap4jTestFileSystemUtility.emptyClasspath, Crap4jTestFileSystemUtility.emptyTestDirs, Crap4jTestFileSystemUtility.emptyClassDirs,	Crap4jTestFileSystemUtility.emptySourceDirs, null);
			fail("Should have thrown illegal arg on non-existent projectDir");
		} catch (IllegalArgumentException e) {			
		}
	}
	
  public void testAllProjectClassesAllTestClasses() throws Exception {   
    List<String> classDirs = new ArrayList<String>();
    classDirs.add(classDir);
    fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
    
    List<String> testClassDirs = new ArrayList<String>();
    testClassDirs.add(testDir1);
    fileSystemUtil.addDefaultTestClassToDefaultPackage(testDir1);
 
    CrapProject p = new CrapProject(projectDir, Crap4jTestFileSystemUtility.emptyClasspath, testClassDirs, classDirs, Crap4jTestFileSystemUtility.emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(1, p.classDirs().size());
    assertEquals(projectDir+File.separator+"bin", p.classDirs().get(0));
    
    assertEquals(1, p.allProjectClasses().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.allProjectClasses().get(0).getPath());
    
    assertEquals(1, p.allTestClasses().size());
    assertEquals(projectDir+File.separator+"test_bin"+File.separator+"DefaultTestCaseClass.class", p.allTestClasses().get(0).getPath());

  }

  public void testAllProjectClassesFilterTests() throws Exception {   
    List<String> classDirs = new ArrayList<String>();
    classDirs.add(classDir);
    fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
    fileSystemUtil.addDefaultTestClassToDefaultPackage(classDir);
 
    CrapProject p = new CrapProject(projectDir, Crap4jTestFileSystemUtility.emptyClasspath, Crap4jTestFileSystemUtility.emptyTestDirs, classDirs, Crap4jTestFileSystemUtility.emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(1, p.classDirs().size());
    assertEquals(projectDir+File.separator+"bin", p.classDirs().get(0));
    
    assertEquals(1, p.allProjectClasses().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.allProjectClasses().get(0).getPath());
  }
  
  public void testAllTestClasses() throws Exception {   
    List<String> testClassDirs = new ArrayList<String>();
    testClassDirs.add(testDir1);
    fileSystemUtil.addDefaultClassToDefaultPackage(testDir1);
    fileSystemUtil.addDefaultTestClassToDefaultPackage(testDir1);
 
    CrapProject p = new CrapProject(projectDir, Crap4jTestFileSystemUtility.emptyClasspath, testClassDirs, Crap4jTestFileSystemUtility.emptyClassDirs, Crap4jTestFileSystemUtility.emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(0, p.allProjectClasses().size());
    
    assertEquals(1, p.allTestClasses().size());
    assertEquals(projectDir+File.separator+"test_bin"+File.separator+"DefaultTestCaseClass.class", p.allTestClasses().get(0).getPath());

  }

  public void testClassDirIsClassFileNotPath() throws Exception {   
    List<String> classDirs = new ArrayList<String>();
    classDirs.add(new File(classDir, "DefaultClass.class").getPath());
    fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
    
    CrapProject p = new CrapProject(projectDir, Crap4jTestFileSystemUtility.emptyClasspath, Crap4jTestFileSystemUtility.emptyTestDirs, classDirs, Crap4jTestFileSystemUtility.emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(1, p.classDirs().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.classDirs().get(0));
    
    assertEquals(1, p.allProjectClasses().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.allProjectClasses().get(0).getPath());
  }
  
  

}
