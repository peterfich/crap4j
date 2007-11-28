package org.crap4j.external;

import java.util.ArrayList;
import java.util.List;

import org.crap4j.CrapProject;
import org.crap4j.external.AntBuilder;

import junit.framework.TestCase;


public class AntBuilderTest extends TestCase {

	public void testBuildContent() {
		List<String> sourceDirs = new ArrayList<String>();
		sourceDirs.add("sourcedirs");
		List<String> projectClasses = new ArrayList<String>();
		projectClasses.add("projectclasses");
		List<String> testClasses = new ArrayList<String>();
		testClasses.add("testclasses");
		List<String> libClasspath = new ArrayList<String>();
		libClasspath.add("libclasspath");
		libClasspath.add("libclasspath2");
		String projectDir = "projectDir";
		CrapProject p = new CrapProject(projectDir, libClasspath, testClasses, projectClasses, sourceDirs, null);
		AntBuilder a = new AntBuilder("/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323",
        "/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/");
		String result = a.buildContent(p);

    String expectedResult = "<?xmlversion=\"1.0\"?>" +
        "<projectname=\"projectDir\"default=\"agitar-all\">" +
        "<!--Rootdirectoryofyoureclipseinstallation-->" +
        "<propertyname=\"eclipse.install.dir\"value=\"/Users/bobevans/Applications/eclipse\"/>" +
        "<propertyname=\"agitarOne.install.dir\"value=\"/Users/bobevans/Applications/eclipse\"/>" +
        "<!--Overrideeclipse.java(using-Declipse.java)withthejavayouwishtouse.-->" +
        "<propertyname=\"eclipse.java\"value=\"java\"/><propertyname=\"domain.access.key\"value=\"\"/>" +
        "<propertyname=\"dashboardURL.projectDir\"value=\"\"/><propertyname=\"domain.email\"value=\"\"/>" +
        "<!--Useof${project.dir.projectDir}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile-->" +
        "<dirnamefile=\"${ant.file.projectDir}\"property=\"import.dir.projectDir\"/>" +
        "<conditionproperty=\"project.dir.projectDir\"value=\"${import.dir.projectDir}\"else=\"${basedir}\">" +
        "<issetproperty=\"import.dir.projectDir\"/>" +
        "</condition>" +
        "<taskdefname=\"super-runner\"classname=\"org.agitar.junit.runner.SuperRunnerTask\">" +
        "<classpath>" +
        "<pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/org.agitar.common.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/org.agitar.coverage.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/org.agitar.mockingbird.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/org.agitar.testrunner.jar\"/><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset></classpath></taskdef><!--ProjectDefinitions--><!--AgitarprojectdefinitionforprojectDirproject--><!--Defaulttarget--><targetname=\"agitar-all\"depends=\"run-tests\"/><!--Cleansoldagitationresultsandcoverage--><targetname=\"clean-results\"><deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/></target><!--Runthetestsforthisproject--><targetname=\"run-tests\"><propertyname=\"test.results.dir\"value=\"${project.dir.projectDir}/agitar/.junitresults\"/><mkdirdir=\"${test.results.dir}\"/><super-runnerdir=\"${basedir}\"batchSize=\"5\"printsummary=\"yes\"mergeCoverage=\"false\"haltonfailure=\"no\"resultsDir=\"${project.dir.projectDir}/agitar/.results\"><jvmargvalue=\"-Xmx512M\"/><jvmargvalue=\"-ea\"/><jvmargvalue=\"-Djava.awt.headless\"/><formattertype=\"xml\"/><classpath><pathElementlocation=\"${project.dir.projectDir}/projectclasses\"/><pathElementlocation=\"${project.dir.projectDir}/testclasses\"/><pathElementlocation=\"${project.dir.projectDir}/libclasspath\"/><pathElementlocation=\"${project.dir.projectDir}/libclasspath2\"/></classpath><batchtesttodir=\"${test.results.dir}\"><filesetdir=\"${project.dir.projectDir}/testclasses\"><includename=\"**/*Test.class\"/><includename=\"**/Test*.class\"/></fileset></batchtest></super-runner></target></project>";
      expectedResult = "<?xmlversion=\"1.0\"?><projectname=\"projectDir\"default=\"agitar-all\"><!--Useof${project.dir.projectDir}allowsfortheresolutionofrelativepathsevenwhenthisfileisimportedinanotherbuildfile--><dirnamefile=\"${ant.file.projectDir}\"property=\"import.dir.projectDir\"/><conditionproperty=\"project.dir.projectDir\"value=\"${import.dir.projectDir}\"else=\"${basedir}\"><issetproperty=\"import.dir.projectDir\"/></condition><taskdefname=\"super-runner\"classname=\"com.agitar.junit.runner.SuperRunnerTask\"><classpath><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.common.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/com.agitar.coverage.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.mockingbird.jar\"/><pathelementlocation=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//com.agitar.testrunner.jar\"/><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.api_1.1.0.000323//lib\"><includename=\"**/*.jar\"/></fileset><filesetdir=\"/Users/bobevans/Applications/eclipse/plugins/org.agitar.eclipse.coverage_1.1.0.000323/lib\"><includename=\"**/*.jar\"/></fileset></classpath></taskdef><!--Defaulttarget--><targetname=\"agitar-all\"depends=\"run-tests\"/><!--Cleansoldagitationresultsandcoverage--><targetname=\"clean-results\"><deletedir=\"${basedir}/agitar/.results\"quiet=\"true\"/></target><!--Runthetestsforthisproject--><targetname=\"run-tests\"><propertyname=\"test.results.dir\"value=\"${project.dir.projectDir}/agitar/.junitresults\"/><mkdirdir=\"${test.results.dir}\"/><super-runnerdir=\"${basedir}\"batchSize=\"5\"printsummary=\"yes\"mergeCoverage=\"true\"haltonfailure=\"no\"resultsDir=\"${project.dir.projectDir}/agitar/.results\"><jvmargvalue=\"-Xmx512M\"/><jvmargvalue=\"-ea\"/><jvmargvalue=\"-Djava.awt.headless\"/><formattertype=\"xml\"/><classpath><pathElementlocation=\"/Users/bobevans/Documents/projects/crap4j/org.crap4j/projectDir/projectclasses\"/><pathElementlocation=\"/Users/bobevans/Documents/projects/crap4j/org.crap4j/projectDir/testclasses\"/><pathElementlocation=\"/Users/bobevans/Documents/projects/crap4j/org.crap4j/projectDir/libclasspath\"/><pathElementlocation=\"/Users/bobevans/Documents/projects/crap4j/org.crap4j/projectDir/libclasspath2\"/></classpath><batchtesttodir=\"${test.results.dir}\"><filesetdir=\"/Users/bobevans/Documents/projects/crap4j/org.crap4j/projectDir/testclasses\"><includename=\"**/*Test.class\"/><includename=\"**/Test*.class\"/></fileset></batchtest></super-runner></target></project>";  

    
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
