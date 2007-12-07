package org.crap4j.external;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.crap4j.Crap4jTestFileSystemUtility;
import org.crap4j.CrapProject;
import org.crap4j.external.AntBuilder;

import junit.framework.TestCase;


public class AntBuilderTest extends TestCase {

  private String projectDir;
  private Crap4jTestFileSystemUtility fileSystemUtil;
  private String testDirRoot;
  private String projectFolder;
  private String projectName;
  private String srcDir;
  private String defaultClassDir;
  private String defaultTestDir2;
  private String defaultTestDir1;
  private String classpathLib;
  private String classDir;
  private String testDir1;
  private String testDir2;
  private String defaultClassDir2;
  private String classDir2;
  private String libDir;

  @Override
  protected void setUp() throws Exception {
    fileSystemUtil = new Crap4jTestFileSystemUtility();
    createDefaultProject();
  }
  
  private void createDefaultProject() throws Exception {
    testDirRoot = "CrapProjectTestDir";
    projectFolder = fileSystemUtil.createTestFileSystem(testDirRoot);
    projectName = "project1";
    projectDir = fileSystemUtil.makeDir(projectFolder, projectName);
    srcDir = fileSystemUtil.makeDir(projectDir, "src");
    defaultClassDir = "bin";
    defaultClassDir2 = "bin2";
    defaultTestDir2 = "agitar"+File.separator+"test_bin";
    defaultTestDir1 = "test_bin";
    classpathLib = "lib"+File.separator+"junit.jar";
    
    classDir = fileSystemUtil.makeDir(projectDir, defaultClassDir);
    classDir2 = fileSystemUtil.makeDir(projectDir, defaultClassDir2);
    testDir1 = fileSystemUtil.makeDir(projectDir, defaultTestDir1);
    libDir = fileSystemUtil.makeDir(projectDir, "lib");
    fileSystemUtil.addDefaultLibraryToLibDir(libDir, "junit.jar");
    
  }


  
  @Override
  protected void tearDown() throws Exception {
    fileSystemUtil.removeDirsCreated();
    testDirRoot = null;
    defaultClassDir = null;
    defaultTestDir2 = null;
    defaultTestDir1 = null;

  }
  
	public void testBuildContent() throws IOException {
		List<String> sourceDirs = new ArrayList<String>();
		sourceDirs.add(srcDir);
		List<String> projectClasses = new ArrayList<String>();
		projectClasses.add(classDir);
		List<String> testClasses = new ArrayList<String>();
		testClasses.add(testDir1);
		List<String> libClasspath = new ArrayList<String>();
		libClasspath.add(classpathLib);
		String projectName = "project1";

		CrapProject p = new CrapProject(projectDir, libClasspath, testClasses, projectClasses, sourceDirs, null);
		AntBuilder a = new AntBuilder("/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323",
        "/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/");
		String result = a.buildContent(p);

    String expectedResult = "<?xmlversion=\"1.0\"?>" +
    		"<projectname=\"project1\"default=\"agitar-all\">" +
    		"<!--Useof${project.dir.project1}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile-->" +
    		"<dirnamefile=\"${ant.file.project1}\"property=\"import.dir.project1\"/><" +
    		"conditionproperty=\"project.dir.project1\"value=\"${import.dir.project1}\"else=\"${basedir}\">" +
    		"<issetproperty=\"import.dir.project1\"/>" +
    		"</condition>" +
    		"<taskdefname=\"super-runner\"classname=\"com.agitar.junit.runner.SuperRunnerTask\">" +
    		"<classpath><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.common.jar\"/>" +
    		"<pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.coverage.jar\"/>" +
    		"<pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.mockingbird.jar\"/>" +
    		"<pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.testrunner.jar\"/>" +
    		"<filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//lib\">" +
    		"<includename=\"**/*.jar\"/>" +
    		"</fileset>" +
    		"<filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\">" +
    		"<includename=\"**/*.jar\"/>" +
    		"</fileset>" +
    		"</classpath>" +
    		"</taskdef>" +
    		"<!--Defaulttarget-->" +
    		"<targetname=\"agitar-all\"depends=\"run-tests\"/>" +
    		"<!--Cleansoldagitationresultsandcoverage--><targetname=\"clean-results\">" +
    		"<deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/><" +
    		"/target><!--Runthetestsforthisproject-->" +
    		"<targetname=\"run-tests\">" +
    		"<propertyname=\"test.results.dir\"value=\"${project.dir.project1}/agitar/.junitresults\"/>" +
    		"<mkdirdir=\"${test.results.dir}\"/>" +
    		"<super-runnerdir=\"${basedir}\"batchSize=\"5\"printsummary=\"yes\"mergeCoverage=\"true\"haltonfailure=\"no\"resultsDir=\"${project.dir.project1}/agitar/.results\">" +
    		"<jvmargvalue=\"-Xmx512M\"/>" +
    		"<jvmargvalue=\"-ea\"/>" +
    		"<jvmargvalue=\"-Djava.awt.headless\"/>" +
    		"<formattertype=\"xml\"/>" +
    		"<classpath>" +
    		"<pathElementlocation=\"/private/tmp/CrapProjectTestDir/project1/bin\"/>" +
    		"<pathElementlocation=\"/private/tmp/CrapProjectTestDir/project1/test_bin\"/>" +
    		"<pathElementlocation=\"/private/tmp/CrapProjectTestDir/project1/lib/junit.jar\"/>" +
    		"</classpath>" +
    		"<batchtesttodir=\"${test.results.dir}\">" +
    		"<filesetdir=\"/private/tmp/CrapProjectTestDir/project1/test_bin\">" +
    		"<includename=\"**/*Test.class\"/>" +
    		"<includename=\"**/Test*.class\"/>" +
    		"</fileset>" +
    		"</batchtest>" +
    		"</super-runner>" +
    		"</target></project>";
    
			assertEquals(removeWhitespace(expectedResult), removeWhitespace(result));
		}

	/*
	 * Test that the ant builder does the right thing when the paths are mixtures of classes and directories.
	 * this test makes the classes under examination be a list of classes instead of directories. 
	 * 
	 * Note: this means we have to put the classDir on the libClasspath, and that the ant builder will not put the
	 * classDirs on the path.
	 */
	
	 public void testBuildContent_WithMixedClassDirectories() throws Exception {
	    File classFile = fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
	    
	    List<String> testClassDirs = new ArrayList<String>();
	    testClassDirs.add(testDir1);

	    // the difference a class instead of a directory!
	    List<String> classDirs = new ArrayList<String>();
      classDirs.add(classFile.getCanonicalPath());
      classDirs.add(classDir2);
      
      List<String> classpath = new ArrayList<String>(); 
      classpath.add(classpathLib);
      classpath.add(classDir);
      // NOTE: if you build a project and use a classlist, you have to put the containing classdir on the 
      // libclasspath so that the tests can find the class.

	    CrapProject p = new CrapProject(projectDir, 
	                                    classpath, 
	                                    testClassDirs, 
	                                    classDirs, 
	                                    Crap4jTestFileSystemUtility.emptySourceDirs, 
	                                    null);
	    AntBuilder a = new AntBuilder("/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323",
	        "/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/");
	    String result = a.buildContent(p);

	    String expectedResult = "<?xmlversion=\"1.0\"?>" +
	    		"<projectname=\"project1\"default=\"agitar-all\">" +
	    		"<!--Useof${project.dir.project1}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile-->" +
	    		"<dirnamefile=\"${ant.file.project1}\"property=\"import.dir.project1\"/>" +
	    		"<conditionproperty=\"project.dir.project1\"value=\"${import.dir.project1}\"else=\"${basedir}\">" +
	    		"<issetproperty=\"import.dir.project1\"/>" +
	    		"</condition>" +
	    		"<taskdef name=\"super-runner\"classname=\"com.agitar.junit.runner.SuperRunnerTask\">" +
	    		"  <classpath>" +
	    		"    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.common.jar\"/>" +
	    		"    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.coverage.jar\"/>" +
	    		"    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.mockingbird.jar\"/>" +
	    		"    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.testrunner.jar\"/>" +
	    		
	    		"    <filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//lib\">" +
	    		"      <includename=\"**/*.jar\"/>" +
	    		"    </fileset>" +
	    		
	    		"    <filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\">" +
	    		"      <includename=\"**/*.jar\"/>" +
	    		"    </fileset>" +
	    		"  </classpath>" +
	    		"</taskdef>" +
	    		
	    		"<!--Defaulttarget-->" +
	    		"<targetname=\"agitar-all\"depends=\"run-tests\"/>" +
	    		"<!--Cleansoldagitationresultsandcoverage-->" +
	    		"<targetname=\"clean-results\">" +
	    		"<deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/>" +
	    		"</target>" +
	    		"<!--Runthetestsforthisproject-->" +
	    		"<targetname=\"run-tests\">" +
	    		"  <propertyname=\"test.results.dir\"value=\"${project.dir.project1}/agitar/.junitresults\"/>" +
	    		"  <mkdir dir=\"${test.results.dir}\"/>" +
	    		"  <super-runner dir=\"${basedir}\" " +
	    		"                batchSize=\"5\" " +
	    		"                printsummary=\"yes\"" +
	    		"                mergeCoverage=\"true\"" +
	    		"                haltonfailure=\"no\"" +
	    		"                resultsDir=\"${project.dir.project1}/agitar/.results\">" +
	    		"    <jvmargvalue=\"-Xmx512M\"/>" +
	    		"    <jvmargvalue=\"-ea\"/>" +
	    		"    <jvmargvalue=\"-Djava.awt.headless\"/>" +
	    		"    <formattertype=\"xml\"/>" +
	    		"    <classpath>" +
	    		"      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/bin2\"/>" +
	    		"      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/test_bin\"/>" +
          "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/lib/junit.jar\"/>" +
          "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/bin\"/>" +
	        "    </classpath>" +
	    		"    <batchtest todir=\"${test.results.dir}\">" +
	    		"      <filesetdir=\"/private/tmp/CrapProjectTestDir/project1/test_bin\">" +
	    		"        <include name=\"**/*Test.class\"/>" +
	    		"        <include name=\"**/Test*.class\"/>" +
	    		"      </fileset>" +
	    		"    </batchtest>" +
	    		"  </super-runner>" +
	    		"</target>" +
	    		"</project>";  

	    
//	    assertEquals(removeWhitespace(expectedResult).length(), removeWhitespace(result).length());
	      assertEquals(removeWhitespace(expectedResult), removeWhitespace(result));
	    }

	 public void testTestClasses_Mixed() throws Exception {
     File classFile = fileSystemUtil.addDefaultClassToDefaultPackage(classDir);
     File testClassFile = fileSystemUtil.addDefaultTestClassToDefaultPackage(testDir1);

     // the difference a test class instead of a directory!
     List<String> testClassDirs = new ArrayList<String>();
     testClassDirs.add(testClassFile.getCanonicalPath());

     List<String> classDirs = new ArrayList<String>();
     classDirs.add(classDir);
     
     List<String> classpath = new ArrayList<String>(); 
     classpath.add(classpathLib);
     classpath.add(testDir1);
     // NOTE: if you build a project and use a classlist, you have to put the containing classdir on the 
     // libclasspath so that the tests can find the class.

     CrapProject p = new CrapProject(projectDir, 
                                     classpath, 
                                     testClassDirs, 
                                     classDirs, 
                                     Crap4jTestFileSystemUtility.emptySourceDirs, 
                                     null);
     AntBuilder a = new AntBuilder("/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323",
         "/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/");
     String result = a.buildContent(p);

     String expectedResult = "<?xmlversion=\"1.0\"?>" +
         "<projectname=\"project1\"default=\"agitar-all\">" +
         "<!--Useof${project.dir.project1}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile-->" +
         "<dirnamefile=\"${ant.file.project1}\"property=\"import.dir.project1\"/>" +
         "<conditionproperty=\"project.dir.project1\"value=\"${import.dir.project1}\"else=\"${basedir}\">" +
         "<issetproperty=\"import.dir.project1\"/>" +
         "</condition>" +
         "<taskdef name=\"super-runner\"classname=\"com.agitar.junit.runner.SuperRunnerTask\">" +
         "  <classpath>" +
         "    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.common.jar\"/>" +
         "    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.coverage.jar\"/>" +
         "    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.mockingbird.jar\"/>" +
         "    <pathelement location=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.testrunner.jar\"/>" +
         
         "    <filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//lib\">" +
         "      <includename=\"**/*.jar\"/>" +
         "    </fileset>" +
         
         "    <filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\">" +
         "      <includename=\"**/*.jar\"/>" +
         "    </fileset>" +
         "  </classpath>" +
         "</taskdef>" +
         
         "<!--Defaulttarget-->" +
         "<targetname=\"agitar-all\"depends=\"run-tests\"/>" +
         "<!--Cleansoldagitationresultsandcoverage-->" +
         "<targetname=\"clean-results\">" +
         "<deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/>" +
         "</target>" +
         "<!--Runthetestsforthisproject-->" +
         "<targetname=\"run-tests\">" +
         "  <propertyname=\"test.results.dir\"value=\"${project.dir.project1}/agitar/.junitresults\"/>" +
         "  <mkdir dir=\"${test.results.dir}\"/>" +
         "  <super-runner dir=\"${basedir}\" " +
         "                batchSize=\"5\" " +
         "                printsummary=\"yes\"" +
         "                mergeCoverage=\"true\"" +
         "                haltonfailure=\"no\"" +
         "                resultsDir=\"${project.dir.project1}/agitar/.results\">" +
         "    <jvmargvalue=\"-Xmx512M\"/>" +
         "    <jvmargvalue=\"-ea\"/>" +
         "    <jvmargvalue=\"-Djava.awt.headless\"/>" +
         "    <formattertype=\"xml\"/>" +
         "    <classpath>" +
         "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/bin\"/>" +
         "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/lib/junit.jar\"/>" +
         "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/test_bin\"/>" +
         "    </classpath>" +
         "    <batchtest todir=\"${test.results.dir}\">" +
         "      <pathElement location=\"/private/tmp/CrapProjectTestDir/project1/test_bin/DefaultTestCaseClass.class\" />" +
         "    </batchtest>" +
         "  </super-runner>" +
         "</target>" +
         "</project>";  

     
//     assertEquals(removeWhitespace(expectedResult).length(), removeWhitespace(result).length());
       assertEquals(removeWhitespace(expectedResult), removeWhitespace(result));
    
  }
	
  public void testReplace() throws Exception {
    AntBuilder a = new AntBuilder(null, null);
    List<String> paths = new ArrayList<String>();
    paths.add("path1");
    paths.add("path2");
    String result = a.replacePathElementsForPattern(paths , "#CLASS_DIR#", AntBuilder.pathElementTemplate());
    String expected =         "\t\t\t\t<pathElement location=\"path1\"/>\n" +
    "\t\t\t\t<pathElement location=\"path2\"/>\n";

    assertEquals(expected, result);    
  }
  
	private String removeWhitespace(String expectedResult) {
		return expectedResult.replaceAll("\\s", "");
	}

}
