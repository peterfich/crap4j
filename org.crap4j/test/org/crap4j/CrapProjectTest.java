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
import java.util.Collections;
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
	private ArrayList<String> dirsCreated;
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
	private static final List<String> emptyClasspath = Collections.EMPTY_LIST;
	private static final List<String> emptyClassDirs = Collections.EMPTY_LIST;
	private static final List<String> emptyTestDirs = Collections.EMPTY_LIST;
	private static final List<String> emptySourceDirs = Collections.EMPTY_LIST;


	public CrapProjectTest(String name) {
		super(name);
	}

	
	@Override
	protected void setUp() throws Exception {
		dirsCreated = new ArrayList<String>();
		createDefaultProject();
	}


	private void createDefaultProject() throws IOException {
		testDirRoot = "CrapProjectTestDir";
		projectFolder = createTestFileSystem(testDirRoot+Long.toString(System.currentTimeMillis()));
		projectName = "testCrapProjectCtorDir";
		projectDir = makeDir(projectFolder, projectName);
		srcDir = makeDir(projectDir, "src");
		defaultClassDir = "bin";
		defaultTestDir2 = "agitar"+File.separator+"test_bin";
		defaultTestDir1 = "test_bin";
		classpathLib = "lib"+File.separator+"junit.jar";
		
		classDir = makeDir(projectDir, defaultClassDir);
		testDir1 = makeDir(projectDir, defaultTestDir1);
		testDir2 = makeDir(projectDir, defaultTestDir2);
	}

	@Override
	protected void tearDown() throws Exception {		
		removeDirsCreated();
		testDirRoot = null;
		defaultClassDir = null;
		defaultTestDir2 = null;
		defaultTestDir1 = null;
	}

	private void removeDirsCreated() {
		for (String dir : dirsCreated) {
			File file = new File(dir);
			if (file.exists())
			  FileUtil.deleteDirectory(file);
		}		
	}

	private String createTestFileSystem(String folderName) throws IOException {		
		return makeDir(getTempDir(), folderName);
	}

	private String makeDir(File rootDir, String projectName) throws IOException {
		File dir = new File(rootDir, projectName);
		if (dir.exists())
			throw new IllegalArgumentException("The directory"+dir+" already exists!");
		
		dir.mkdirs();
		String dirStr = dir.getCanonicalPath();
		dirsCreated.add(dirStr);
		return dirStr;
	}
	
	private String makeDir(String rootDir, String name) throws IOException {
		return makeDir(new File(rootDir), name);
	}

  private void addDefaultClassToDefaultPackage(String classDir2) throws Exception {
    copyClassToDir(classDir2, "DefaultClass.class");
  }

  private void addDefaultTestClassToDefaultPackage(String classDir2) throws Exception {
    copyClassToDir(classDir2, "DefaultTestCaseClass.class");
  }

  
  private void copyClassToDir(String classDir2, String className) throws FileNotFoundException, IOException {
    BufferedOutputStream out = null;
    try {
      out = new BufferedOutputStream(new DataOutputStream(new FileOutputStream(new File(classDir2, className))));
      BufferedInputStream s = new BufferedInputStream(getClass().getResourceAsStream(className));
      byte[] b = new byte[1024];
      while (s.read(b) != -1) {
        out.write(b);
      }
    } finally {
      if (out != null)
        out.close();
    }
  }

	private String getTempDir() {
		String javaTmpDir = System.getProperty("java.io.tmpdir");
		if (javaTmpDir == null) {
			throw new IllegalArgumentException("Cannot get the tmp dir!!!");
		}
		return javaTmpDir;
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
			CrapProject p = new CrapProject(projectDir, emptyClasspath, emptyTestDirs, emptyClassDirs,  emptySourceDirs, null);
			assertEquals(0, p.libClasspaths().size());
			assertEquals(0, p.classDirs().size());
			assertEquals(0, p.sourceDirs().size());
			assertEquals(0, p.testClassDirs().size());
			assertEquals(0, p.allClasspaths().size());
			
			assertEquals(0, p.allProjectClasses().size());
	}
	
	public void testCtorNullProjectDir() throws Exception {
		try {
			CrapProject p = new CrapProject(null, emptyClasspath, emptyTestDirs, emptyClassDirs,	emptySourceDirs, null);
			fail("Should have thrown illegal arg on null projectDir");
		} catch (IllegalArgumentException e) {			
		}
	}
	
	public void testCtorNonExistentProjectDir() throws Exception {
		try {
			CrapProject p = new CrapProject("garblegarbledoesnotexist", emptyClasspath, emptyTestDirs, emptyClassDirs,	emptySourceDirs, null);
			fail("Should have thrown illegal arg on non-existent projectDir");
		} catch (IllegalArgumentException e) {			
		}
	}
	
  public void testAllProjectClassesAllTestClasses() throws Exception {   
    List<String> classDirs = new ArrayList<String>();
    classDirs.add(classDir);
    addDefaultClassToDefaultPackage(classDir);
    
    List<String> testClassDirs = new ArrayList<String>();
    testClassDirs.add(testDir1);
    addDefaultTestClassToDefaultPackage(testDir1);
 
    CrapProject p = new CrapProject(projectDir, emptyClasspath, testClassDirs, classDirs, emptySourceDirs, null);
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
    addDefaultClassToDefaultPackage(classDir);
    addDefaultTestClassToDefaultPackage(classDir);
 
    CrapProject p = new CrapProject(projectDir, emptyClasspath, emptyTestDirs, classDirs, emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(1, p.classDirs().size());
    assertEquals(projectDir+File.separator+"bin", p.classDirs().get(0));
    
    assertEquals(1, p.allProjectClasses().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.allProjectClasses().get(0).getPath());
  }
  
  public void testAllTestClasses() throws Exception {   
    List<String> testClassDirs = new ArrayList<String>();
    testClassDirs.add(testDir1);
    addDefaultClassToDefaultPackage(testDir1);
    addDefaultTestClassToDefaultPackage(testDir1);
 
    CrapProject p = new CrapProject(projectDir, emptyClasspath, testClassDirs, emptyClassDirs, emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(0, p.allProjectClasses().size());
    
    assertEquals(1, p.allTestClasses().size());
    assertEquals(projectDir+File.separator+"test_bin"+File.separator+"DefaultTestCaseClass.class", p.allTestClasses().get(0).getPath());

  }

  public void testClassDirIsClassFileNotPath() throws Exception {   
    List<String> classDirs = new ArrayList<String>();
    classDirs.add(new File(classDir, "DefaultClass.class").getPath());
    addDefaultClassToDefaultPackage(classDir);
    
    CrapProject p = new CrapProject(projectDir, emptyClasspath, emptyTestDirs, classDirs, emptySourceDirs, null);
    assertProjectDirectory(p);
    
    assertEquals(1, p.classDirs().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.classDirs().get(0));
    
    assertEquals(1, p.allProjectClasses().size());
    assertEquals(projectDir+File.separator+"bin"+File.separator+"DefaultClass.class", p.allProjectClasses().get(0).getPath());
  }
  
  

}
