package org.crap4j.external;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.crap4j.CrapProject;
import org.crap4j.util.FileUtil;


public class AntBuilder {
	String antFile = "crap_build.xml";
  private String agitatorEclipseCoveragePluginDir;
  private String agitatorEclipseApiPluginDir;
	
	public AntBuilder(String agitatorEclipseCoveragePluginDir,
                    String agitatorEclipseApiPluginDir) {
    this.agitatorEclipseCoveragePluginDir = agitatorEclipseCoveragePluginDir;
    this.agitatorEclipseApiPluginDir = agitatorEclipseApiPluginDir;

	}

	public String buildFileForProject(CrapProject project) {
		String filename = buildFileName(project.projectDir(), antFile);
		FileUtil.writeFile(filename, buildContent(project));
		return filename;
	}

	protected String buildContent(CrapProject project) {
		String PROJECT_NAME = project.getProjectName();
		

		String template = antFileTemplate();
		// do sub replacements first because they contain nested replacements for project_name
		template = template.replaceAll("#CLASSPATH_ELEMENTS#", replacePathElementsForPattern(makeForwardSlashes(project.allClasspaths()), "#CLASS_DIR#", pathElementTemplate()));
		template = template.replaceAll("#TEST_FILESETS#", replaceFileSetWithPattern(makeForwardSlashes(project.testClassDirs()), "#CLASS_DIR#"));
		template = template.replaceAll("#CLASSDIRS#", replacePathElementsForPattern(makeForwardSlashes(project.classDirs()), "#CLASS_DIR#", pathElementTemplate()));
		template = template.replaceAll("#SOURCEDIRS#", replacePathElementsForPattern(makeForwardSlashes(project.sourceDirs()), "#CLASS_DIR#", pathElementTemplate()));
		template = template.replaceAll("#LIBPATH#", replacePathElementsForPattern(makeForwardSlashes(project.libClasspaths()), "#CLASS_DIR#", pathElementTemplate()));
		
		template = template.replaceAll("#PROJECT_NAME#", PROJECT_NAME);
//		template = template.replaceAll("#ECLIPSE_INSTALL_DIR#",Main.getInstance().ECLIPSE_HOME);
		template = template.replaceAll("#COVERAGE_PLUGIN_DIR#", 
                                   makeForwardSlash(eclipseCoveragePluginDir()));
		template = template.replaceAll("#API_PLUGIN_DIR#", 
                                   makeForwardSlash(agitatorEclipseApiPluginDir()));
		return template.replaceAll("\\\\", "");
	}

  private String agitatorEclipseApiPluginDir() {
    return agitatorEclipseApiPluginDir;
  }

  private String eclipseCoveragePluginDir() {
    return agitatorEclipseCoveragePluginDir;
  }

	private List<String> makeForwardSlashes(List<String> name) {
    List<String> slashed = new ArrayList<String>();
    for (String string : name) {
      slashed.add(makeForwardSlash(string));
    }
    return slashed;
  }

  private String makeForwardSlash(String string) {
    return string.replace('\\','/');
  }

  private String antFileTemplate() {
		return "<?xml version=\"1.0\" ?>\n" +
				"<project name=\"#PROJECT_NAME#\" default=\"agitar-all\">\n" +
//				"	<!-- Root directory of your eclipse installation -->\n" +
//				"	<property name=\"eclipse.install.dir\" value=\"#ECLIPSE_INSTALL_DIR#\"/>\n" +
//				"	<property name=\"agitarOne.install.dir\" value=\"#ECLIPSE_INSTALL_DIR#\"/>\n" +
				"\n" +
//				"<!-- Override eclipse.java (using -Declipse.java) with the java you wish to use. -->\n" +
//				"	<property name=\"eclipse.java\" value=\"java\"/>\n" +
//				"	<property name=\"domain.access.key\" value=\"\"/>\n" +
//				"	<property name=\"dashboardURL.#PROJECT_NAME#\" value=\"\"/>\n" +
//				"	<property name=\"domain.email\" value=\"\"/>\n" +
				"	<!-- Use of \\${project.dir.#PROJECT_NAME#} allows for the resolution of relative paths even when this file is imported in another build file -->\n" +
				"	<dirname file=\"\\${ant.file.#PROJECT_NAME#}\" property=\"import.dir.#PROJECT_NAME#\"/>\n" +
				"	<condition property=\"project.dir.#PROJECT_NAME#\" value=\"\\${import.dir.#PROJECT_NAME#}\" else=\"\\${basedir}\">\n" +
				"<isset property=\"import.dir.#PROJECT_NAME#\"/>\n" +
				"	</condition>" +
        "\n" +
				"\n" +

				"<taskdef name=\"super-runner\" classname=\"org.agitar.junit.runner.SuperRunnerTask\">"
				+ "\n" + "<classpath>"
				+ "\n" + "		<pathelement location=\"#COVERAGE_PLUGIN_DIR#/org.agitar.common.jar\" />"
				+ "\n" + "		<pathelement location=\"#COVERAGE_PLUGIN_DIR#/org.agitar.coverage.jar\" />"
				+ "\n" + "		<pathelement location=\"#API_PLUGIN_DIR#/org.agitar.mockingbird.jar\" />"
				+ "\n" + "	  <pathelement location=\"#API_PLUGIN_DIR#/org.agitar.testrunner.jar\" />"
				+ "\n" + "		<fileset dir=\"#API_PLUGIN_DIR#/lib\">"
				+ "\n" + "		  <include name=\"**/*.jar\" />"
				+ "\n" + "    </fileset>"
				+ "\n" + "    <fileset dir=\"#COVERAGE_PLUGIN_DIR#/lib\">"
				+ "\n" + "	    <include name=\"**/*.jar\" />"
				+ "\n" + "    </fileset>"
				+ "\n" + "  </classpath>"
				+ "\n" + "</taskdef>"
				+ "\n" +
//				"	<!-- Project Definitions -->\n" +
//				"	\n" +
//				"	<!-- Agitar project definition for #PROJECT_NAME# project -->\n" +
//				"	<agitar-project id=\"#PROJECT_NAME#.project\" projectDir=\"\\${project.dir.#PROJECT_NAME#}\" \n" +
//				"        agitarDir=\"\\${project.dir.#PROJECT_NAME#}/agitar\" \n" +
//				"        resultDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/.results\" \n" +
//				"        configDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/config\" \n" +
//				"        reportOutputDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/reports/latest\" \n" +
//				"        dataDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/reports/latest/data\" \n" +
//				"        authEmail=\"\\${domain.email}\" \n" +
//				"        accessKey=\"\\${domain.access.key}\" \n" +
//				"        agitationVmArgs=\"-Xms128m -Xmx512m\" \n" +
//				"        projectName=\"#PROJECT_NAME#\" \n" +
//				"        dashboardRootURL=\"\\${dashboardURL.#PROJECT_NAME#}\">\n" +
//				"		<sourcePath>\n" +
//				"       #SOURCEDIRS#"+
//				"		</sourcePath>\n" +
//				"		<targetClasspath>\n" +
//				"			#CLASSDIRS#\n" +
//				"		</targetClasspath>\n" +
//				"		<libClasspath>\n" +
//				"        #LIBPATH#\n" +
//				"		</libClasspath>\n" +
//				"		<testResultsPath>\n" +
//				"			<pathElement location=\"\\${project.dir.#PROJECT_NAME#}/agitar/.junitresults\"/>\n" +
//				"		</testResultsPath>\n" +
//				"	</agitar-project>\n" +
//				"	\n" +
//				"	\n" +
//				"	<!-- Configuration for #PROJECT_NAME# -->\n" +
//				"	<agitar-config id=\"#PROJECT_NAME#.config\" local=\"false\" showCoverageDetails=\"true\" emailPort=\"25\" emailFailureOnly=\"false\"/>\n" +
				"	\n" +
				"	\n" +
				"	<!-- Default target -->\n" +
				"	<target name=\"agitar-all\" depends=\"run-tests\"/>\n" +
				"	\n" +
				"	\n" +
				"	<!-- Cleans old agitation results and coverage -->\n" +
				"	<target name=\"clean-results\">\n" +
				"		<delete dir=\"\\${basedir}/agitar/.results\" quiet=\"true\"/>\n" +
				"	</target>\n" +
				"	\n" +
				"	<!-- Run the tests for this project -->\n" +
				"\n" +
				"	<target name=\"run-tests\">\n" +
				"		<property name=\"test.results.dir\" value=\"\\${project.dir.#PROJECT_NAME#}/agitar/.junitresults\"/>\n" +
				"		<mkdir dir=\"\\${test.results.dir}\"/>\n" +
				"		<super-runner dir=\"\\${basedir}\" batchSize=\"5\" printsummary=\"yes\" mergeCoverage=\"true\" haltonfailure=\"no\" resultsDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/.results\">\n" +
				"			<jvmarg value=\"-Xmx512M\"/>\n" +
				"			<jvmarg value=\"-ea\"/>\n" +
				"			<jvmarg value=\"-Djava.awt.headless\"/>\n" +
				"			<formatter type=\"xml\"/>\n" +
				"			<classpath>\n" +
				"         #CLASSPATH_ELEMENTS#"+
				"			</classpath>\n" +
				"			<batchtest todir=\"\\${test.results.dir}\">\n" +
				"        #TEST_FILESETS#"+
				"			</batchtest>\n" +
				"		</super-runner>\n" +
				"	</target>\n" +
				"	\n" +
//				"		<!-- Publish results to a loation represented by \\${artifacts.destination} -->\n" +
//				"	<target name=\"publish\">\n" +
//				"		<mkdir dir=\"\\${project.dir.#PROJECT_NAME#}/agitar/reports/latest/.logs\"/>\n" +
//				"		<copy todir=\"\\${project.dir.#PROJECT_NAME#}/agitar/reports/latest/.logs\">\n" +
//				"			<fileset dir=\"\\${project.dir.#PROJECT_NAME#}/agitar/.logs\"/>\n" +
//				"		</copy>\n" +
//				"		<copy todir=\"\\${artifacts.destination}\">\n" +
//				"			<fileset dir=\"\\${project.dir.#PROJECT_NAME#}/agitar/reports/latest\"/>\n" +
//				"		</copy>\n" +
//				"	</target>\n" +
				"</project>";
	}

	public String replacePathElementsForPattern(List<String> paths, String pattern, String pathElementTemplate) {
		StringBuilder pathElements = new StringBuilder();
		for (String classdir : paths) {			
			pathElements.append(pathElementTemplate.replaceAll(pattern, classdir)).append("\n");
		}
		return pathElements.toString();
	}
	
	private String replaceFileSetWithPattern(List<String> paths, String pattern) {
		StringBuilder filesets = new StringBuilder();
		for (String classdir : paths) {
			filesets.append(filesetTemplate().replaceAll(pattern, classdir)).append("\n");
		}
		return filesets.toString();
	}

	public static String pathElementTemplate() {
		return "				<pathElement location=\"#CLASS_DIR#\"/>";
	}
	
	public static String filesetTemplate() {
		return "				<fileset dir=\"#CLASS_DIR#\">\n" +
				"					<include name=\"**/*Test.class\"/>\n" +
				"					<include name=\"**/Test*.class\"/>\n" +
				"				</fileset>";
	}
	
	private String buildFileName(String string, String antFile2) {
		return string + File.separator + antFile2;
	}

}
