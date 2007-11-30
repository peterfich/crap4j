package org.crap4j.external;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.crap4j.Crap4jTestFileSystemUtility;
import org.crap4j.CrapProject;
import org.crap4j.external.AntBuilder;

import junit.framework.TestCase;


public class AntBuilderTest extends TestCase {

  private String projectDir;
  private Crap4jTestFileSystemUtility crap4jTestFileSystemUtility;

  @Override
  protected void setUp() throws Exception {
    // TODO Auto-generated method stub
    crap4jTestFileSystemUtility = new Crap4jTestFileSystemUtility();
    projectDir = crap4jTestFileSystemUtility.createTestFileSystem("project1");
  }
  
  @Override
  protected void tearDown() throws Exception {
    // TODO Auto-generated method stub
    crap4jTestFileSystemUtility.removeDirsCreated();
  }
  
	public void testBuildContent() throws IOException {
		List<String> sourceDirs = new ArrayList<String>();
		sourceDirs.add("sourcedirs");
		List<String> projectClasses = new ArrayList<String>();
		projectClasses.add("projectclasses");
		List<String> testClasses = new ArrayList<String>();
		testClasses.add("testclasses");
		List<String> libClasspath = new ArrayList<String>();
		libClasspath.add("libclasspath");
		libClasspath.add("libclasspath2");
		String projectName = "project1";

		CrapProject p = new CrapProject(projectDir, libClasspath, testClasses, projectClasses, sourceDirs, null);
		AntBuilder a = new AntBuilder("/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323",
        "/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/");
		String result = a.buildContent(p);

    String expectedResult = "<?xmlversion=\"1.0\"?>" +
        "<projectname=\"project1\"default=\"agitar-all\">" +
        "<!--Rootdirectoryofyoureclipseinstallation-->" +
        "<propertyname=\"eclipse.install.dir\"value=\"/Users/bobevans/Applications/eclipse\"/>" +
        "<propertyname=\"agitarOne.install.dir\"value=\"/Users/bobevans/Applications/eclipse\"/>" +
        "<!--Overrideeclipse.java(using-Declipse.java)withthejavayouwishtouse.-->" +
        "<propertyname=\"eclipse.java\"value=\"java\"/><propertyname=\"domain.access.key\"value=\"\"/>" +
        "<propertyname=\"dashboardURL.projectDir\"value=\"\"/><propertyname=\"domain.email\"value=\"\"/>" +
        "<!--Useof${project.dir.project1}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile-->" +
        "<dirnamefile=\"${ant.file.project1}\"property=\"import.dir.project1\"/>" +
        "<conditionproperty=\"project.dir.project1\"value=\"${import.dir.project1}\"else=\"${basedir}\">" +
        "<issetproperty=\"import.dir.project1\"/>" +
        "</condition>" +
        "<taskdefname=\"super-runner\"classname=\"org.agitar.junit.runner.SuperRunnerTask\">" +
        "<classpath>" +
        "<pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/org.agitar.common.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/org.agitar.coverage.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/org.agitar.mockingbird.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/org.agitar.testrunner.jar\"/><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset></classpath></taskdef><!--ProjectDefinitions--><!--Agitarprojectdefinitionforproject1project--><!--Defaulttarget--><targetname=\"agitar-all\"depends=\"run-tests\"/><!--Cleansoldagitationresultsandcoverage--><targetname=\"clean-results\"><deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/></target><!--Runthetestsforthisproject--><targetname=\"run-tests\"><propertyname=\"test.results.dir\"value=\"${project.dir.project1}/agitar/.junitresults\"/><mkdirdir=\"${test.results.dir}\"/><super-runnerdir=\"${basedir}\"batchSize=\"5\"printsummary=\"yes\"mergeCoverage=\"false\"haltonfailure=\"no\"resultsDir=\"${project.dir.project1}/agitar/.results\"><jvmargvalue=\"-Xmx512M\"/><jvmargvalue=\"-ea\"/><jvmargvalue=\"-Djava.awt.headless\"/><formattertype=\"xml\"/><classpath><pathElementlocation=\"${project.dir.project1}/projectclasses\"/><pathElementlocation=\"${project.dir.project1}/testclasses\"/><pathElementlocation=\"${project.dir.project1}/libclasspath\"/><pathElementlocation=\"${project.dir.project1}/libclasspath2\"/></classpath><batchtesttodir=\"${test.results.dir}\"><filesetdir=\"${project.dir.project1}/testclasses\"><includename=\"**/*Test.class\"/><includename=\"**/Test*.class\"/></fileset></batchtest></super-runner></target></project>";
      expectedResult = "<?xmlversion=\"1.0\"?><projectname=\"project1\"default=\"agitar-all\"><!--Useof${project.dir.project1}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile--><dirnamefile=\"${ant.file.project1}\"property=\"import.dir.project1\"/><conditionproperty=\"project.dir.project1\"value=\"${import.dir.project1}\"else=\"${basedir}\"><issetproperty=\"import.dir.project1\"/></condition><taskdefname=\"super-runner\"classname=\"com.agitar.junit.runner.SuperRunnerTask\"><classpath><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.common.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.coverage.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.mockingbird.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.testrunner.jar\"/><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//lib\"><includename=\"**/*.jar\"/></fileset><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset></classpath></taskdef><!--Defaulttarget--><targetname=\"agitar-all\"depends=\"run-tests\"/><!--Cleansoldagitationresultsandcoverage--><targetname=\"clean-results\"><deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/></target><!--Runthetestsforthisproject--><targetname=\"run-tests\"><propertyname=\"test.results.dir\"value=\"${project.dir.project1}/agitar/.junitresults\"/><mkdirdir=\"${test.results.dir}\"/><super-runnerdir=\"${basedir}\"batchSize=\"5\"printsummary=\"yes\"mergeCoverage=\"true\"haltonfailure=\"no\"resultsDir=\"${project.dir.project1}/agitar/.results\"><jvmargvalue=\"-Xmx512M\"/><jvmargvalue=\"-ea\"/><jvmargvalue=\"-Djava.awt.headless\"/><formattertype=\"xml\"/><classpath><pathElementlocation=\"/private/tmp/project1/projectclasses\"/><pathElementlocation=\"/private/tmp/project1/testclasses\"/><pathElementlocation=\"/private/tmp/project1/libclasspath\"/><pathElementlocation=\"/private/tmp/project1/libclasspath2\"/></classpath><batchtesttodir=\"${test.results.dir}\"><filesetdir=\"/private/tmp/project1/testclasses\"><includename=\"**/*Test.class\"/><includename=\"**/Test*.class\"/></fileset></batchtest></super-runner></target></project>";  

    
//    assertEquals(removeWhitespace(expectedResult).length(), removeWhitespace(result).length());
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
