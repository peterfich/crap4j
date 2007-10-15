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
      expectedResult = "<?xml version=\"1.0\" ?> <project name=\"projectDir\" default=\"agitar-all\">  \t<!-- Use of ${project.dir.projectDir} allows for the resolution of relative paths even when this file is imported in another build file --> \t<dirname file=\"${ant.file.projectDir}\" property=\"import.dir.projectDir\"/> \t<condition property=\"project.dir.projectDir\" value=\"${import.dir.projectDir}\" else=\"${basedir}\"> <isset property=\"import.dir.projectDir\"/> \t</condition>  <taskdef name=\"super-runner\" classname=\"org.agitar.junit.runner.SuperRunnerTask\"> <classpath> \t\t<pathelement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.coverage_4.2.0.401405/org.agitar.common.jar\" /> \t\t<pathelement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.coverage_4.2.0.401405/org.agitar.coverage.jar\" /> \t\t<pathelement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.api_4.2.0.401405/org.agitar.mockingbird.jar\" /> \t  <pathelement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.api_4.2.0.401405/org.agitar.testrunner.jar\" /> \t\t<fileset dir=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.api_4.2.0.401405/lib\"> \t\t  <include name=\"**/*.jar\" />     </fileset>     <fileset dir=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/lib/org.agitar.eclipse.coverage_4.2.0.401405/lib\"> \t    <include name=\"**/*.jar\" />     </fileset>   </classpath> </taskdef> \t \t \t<!-- Default target --> \t<target name=\"agitar-all\" depends=\"run-tests\"/> \t \t \t<!-- Cleans old agitation results and coverage --> \t<target name=\"clean-results\"> \t\t<delete dir=\"${basedir}/agitar/.results\" quiet=\"true\"/> \t</target> \t \t<!-- Run the tests for this project -->  \t<target name=\"run-tests\"> \t\t<property name=\"test.results.dir\" value=\"${project.dir.projectDir}/agitar/.junitresults\"/> \t\t<mkdir dir=\"${test.results.dir}\"/> \t\t<super-runner dir=\"${basedir}\" batchSize=\"5\" printsummary=\"yes\" mergeCoverage=\"false\" haltonfailure=\"no\" resultsDir=\"${project.dir.projectDir}/agitar/.results\"> \t\t\t<jvmarg value=\"-Xmx512M\"/> \t\t\t<jvmarg value=\"-ea\"/> \t\t\t<jvmarg value=\"-Djava.awt.headless\"/> \t\t\t<formatter type=\"xml\"/> \t\t\t<classpath>          \t\t\t\t<pathElement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/projectDir/projectclasses\"/> \t\t\t\t<pathElement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/projectDir/testclasses\"/> \t\t\t\t<pathElement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/projectDir/libclasspath\"/> \t\t\t\t<pathElement location=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/projectDir/libclasspath2\"/> \t\t\t</classpath> \t\t\t<batchtest todir=\"${test.results.dir}\">         \t\t\t\t<fileset dir=\"/Users/bobevans/Documents/projects/MDTWorkspace/crap4j/projectDir/testclasses\"> \t\t\t\t\t<include name=\"**/*Test.class\"/> \t\t\t\t\t<include name=\"**/Test*.class\"/> \t\t\t\t</fileset> \t\t\t</batchtest> \t\t</super-runner> \t</target> \t </project>";  

    
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
