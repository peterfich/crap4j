/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 6, 2007 1:40:04 PM
 * Time to generate: 01:25.543 seconds
 *
 */

package org.crap4j.external;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.crap4j.CrapProject;
import org.crap4j.util.FileUtil;

public class AntBuilderAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return AntBuilder.class;
    }
    
    public void testConstructor() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2");
        assertEquals("antBuilder.agitatorEclipseApiPluginDir", "testAntBuilderParam2", getPrivateField(antBuilder, "agitatorEclipseApiPluginDir"));
        assertEquals("antBuilder.antFile", "crap_build.xml", antBuilder.antFile);
        assertEquals("antBuilder.agitatorEclipseCoveragePluginDir", "testAntBuilderParam1", getPrivateField(antBuilder, "agitatorEclipseCoveragePluginDir"));
    }
    
    public void testAgitatorEclipseApiPluginDir() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "agitatorEclipseApiPluginDir", new Class[] {}, antBuilder, new Object[] {});
        assertEquals("result", "testAntBuilderAgitatorEclipseApiPluginDir", result);
    }
    
    public void testAntFileTemplate() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "antFileTemplate", new Class[] {}, antBuilder, new Object[] {});
        assertEquals("result", "<?xml version=\"1.0\" ?>\n<project name=\"#PROJECT_NAME#\" default=\"agitar-all\">\n\n\t<!-- Use of \\${project.dir.#PROJECT_NAME#} allows for the resolution of relative paths even when this file is imported in another build file -->\n\t<dirname file=\"\\${ant.file.#PROJECT_NAME#}\" property=\"import.dir.#PROJECT_NAME#\"/>\n\t<condition property=\"project.dir.#PROJECT_NAME#\" value=\"\\${import.dir.#PROJECT_NAME#}\" else=\"\\${basedir}\">\n<isset property=\"import.dir.#PROJECT_NAME#\"/>\n\t</condition>\n\n<taskdef name=\"super-runner\" classname=\"com.agitar.junit.runner.SuperRunnerTask\">\n<classpath>\n\t\t<pathelement location=\"#COVERAGE_PLUGIN_DIR#/com.agitar.common.jar\" />\n\t\t<pathelement location=\"#COVERAGE_PLUGIN_DIR#/com.agitar.coverage.jar\" />\n\t\t<pathelement location=\"#API_PLUGIN_DIR#/com.agitar.mockingbird.jar\" />\n\t  <pathelement location=\"#API_PLUGIN_DIR#/com.agitar.testrunner.jar\" />\n\t\t<fileset dir=\"#API_PLUGIN_DIR#/lib\">\n\t\t  <include name=\"**/*.jar\" />\n    </fileset>\n    <fileset dir=\"#COVERAGE_PLUGIN_DIR#/lib\">\n\t    <include name=\"**/*.jar\" />\n    </fileset>\n  </classpath>\n</taskdef>\n\t\n\t\n\t<!-- Default target -->\n\t<target name=\"agitar-all\" depends=\"run-tests\"/>\n\t\n\t\n\t<!-- Cleans old agitation results and coverage -->\n\t<target name=\"clean-results\">\n\t\t<delete dir=\"\\${basedir}/agitar/.results\" quiet=\"true\"/>\n\t</target>\n\t\n\t<!-- Run the tests for this project -->\n\n\t<target name=\"run-tests\">\n\t\t<property name=\"test.results.dir\" value=\"\\${project.dir.#PROJECT_NAME#}/agitar/.junitresults\"/>\n\t\t<mkdir dir=\"\\${test.results.dir}\"/>\n\t\t<super-runner dir=\"\\${basedir}\" batchSize=\"5\" printsummary=\"yes\" mergeCoverage=\"true\" haltonfailure=\"no\" resultsDir=\"\\${project.dir.#PROJECT_NAME#}/agitar/.results\">\n\t\t\t<jvmarg value=\"-Xmx512M\"/>\n\t\t\t<jvmarg value=\"-ea\"/>\n\t\t\t<jvmarg value=\"-Djava.awt.headless\"/>\n\t\t\t<formatter type=\"xml\"/>\n\t\t\t<classpath>\n         #CLASSPATH_ELEMENTS#\t\t\t</classpath>\n\t\t\t<batchtest todir=\"\\${test.results.dir}\">\n        #TEST_FILESETS#\t\t\t</batchtest>\n\t\t</super-runner>\n\t</target>\n\t\n</project>", result);
    }
    
    public void testBuildFileForProjectWithAggressiveMocks() throws Throwable {
        AntBuilder antBuilder = (AntBuilder) Mockingbird.getProxyObject(AntBuilder.class, true);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        antBuilder.antFile = "";
        setPrivateField(antBuilder, "agitatorEclipseCoveragePluginDir", "");
        setPrivateField(antBuilder, "agitatorEclipseApiPluginDir", "");
        setPrivateField(crapProject, "projectDir", "");
        setPrivateField(crapProject, "testClassDirs", null);
        setPrivateField(crapProject, "classDirs", null);
        setPrivateField(crapProject, "sourceDirs", null);
        setPrivateField(crapProject, "libClasspaths", null);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(StringBuilder.class), "toString", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(crapProject.getProjectName(), "");
        Mockingbird.setReturnValue(false, antBuilder, "antFileTemplate", "()java.lang.String", new Object[] {}, "", 1);
        Mockingbird.setReturnValue(crapProject.allClasspaths(), null);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlashes", "(java.util.List)java.util.List", new Object[] {null}, null, 1);
        Mockingbird.setReturnValue(AntBuilder.pathElementTemplate(), "");
        Mockingbird.setReturnValue(antBuilder.replacePathElementsForPattern(null, "#CLASS_DIR#", ""), "");
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlashes", "(java.util.List)java.util.List", new Object[] {null}, null, 1);
        Mockingbird.setReturnValue(false, antBuilder, "replaceFileSetWithPattern", "(java.util.List,java.lang.String)java.lang.String", new Object[] {null, "#CLASS_DIR#"}, "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlashes", "(java.util.List)java.util.List", new Object[] {null}, null, 1);
        Mockingbird.setReturnValue(AntBuilder.pathElementTemplate(), "");
        Mockingbird.setReturnValue(false, antBuilder, "replacePathElementsForPattern", "(java.util.List,java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlashes", "(java.util.List)java.util.List", new Object[] {null}, null, 1);
        Mockingbird.setReturnValue(AntBuilder.pathElementTemplate(), "");
        Mockingbird.setReturnValue(false, antBuilder, "replacePathElementsForPattern", "(java.util.List,java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlashes", "(java.util.List)java.util.List", new Object[] {null}, null, 1);
        Mockingbird.setReturnValue(AntBuilder.pathElementTemplate(), "");
        Mockingbird.setReturnValue(false, antBuilder, "replacePathElementsForPattern", "(java.util.List,java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlash", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, antBuilder, "makeForwardSlash", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "replaceAll", "(java.lang.String,java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, FileUtil.class, "writeFile", "(java.lang.String,java.lang.String)void", null, 1);
        Mockingbird.enterTestMode(AntBuilder.class);
        String result = antBuilder.buildFileForProject(crapProject);
        assertEquals("result", "", result);
    }
    
    public void testBuildFileName() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "buildFileName", new Class[] {String.class, String.class}, antBuilder, new Object[] {"testAntBuilderString", "testAntBuilderAntFile2"});
        assertEquals("result", "testAntBuilderString/testAntBuilderAntFile2", result);
    }
    
    public void testEclipseCoveragePluginDir() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "eclipseCoveragePluginDir", new Class[] {}, antBuilder, new Object[] {});
        assertEquals("result", "testAntBuilderAgitatorEclipseCoveragePluginDir", result);
    }
    
    public void testFilesetTemplate() throws Throwable {
        String result = AntBuilder.filesetTemplate();
        assertEquals("result", "\t\t\t\t<fileset dir=\"#CLASS_DIR#\">\n\t\t\t\t\t<include name=\"**/*Test.class\"/>\n\t\t\t\t\t<include name=\"**/Test*.class\"/>\n\t\t\t\t</fileset>", result);
    }
    
    public void testMakeForwardSlash() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "makeForwardSlash", new Class[] {String.class}, antBuilder, new Object[] {"testAntBuilderString"});
        assertEquals("result", "testAntBuilderString", result);
    }
    
    public void testMakeForwardSlashes() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        List arrayList = new ArrayList(100);
        arrayList.add("testString");
        ArrayList result = (ArrayList) callPrivateMethod("org.crap4j.external.AntBuilder", "makeForwardSlashes", new Class[] {List.class}, antBuilder, new Object[] {arrayList});
        assertEquals("result.size()", 1, result.size());
        assertEquals("(ArrayList) result.get(0)", "testString", ((List) result).get(0));
    }
    
    public void testMakeForwardSlashes1() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        ArrayList result = (ArrayList) callPrivateMethod("org.crap4j.external.AntBuilder", "makeForwardSlashes", new Class[] {List.class}, antBuilder, new Object[] {new ArrayList(100)});
        assertEquals("result.size()", 0, result.size());
    }
    
    public void testPathElementTemplate() throws Throwable {
        String result = AntBuilder.pathElementTemplate();
        assertEquals("result", "\t\t\t\t<pathElement location=\"#CLASS_DIR#\"/>", result);
    }
    
    public void testReplaceFileSetWithPattern() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "replaceFileSetWithPattern", new Class[] {List.class, String.class}, antBuilder, new Object[] {new ArrayList(100), "testAntBuilderPattern"});
        assertEquals("result", "", result);
    }
    
    public void testReplaceFileSetWithPattern1() throws Throwable {
        List arrayList = new ArrayList(100);
        arrayList.add("#CLASSPATH_ELEMENTS#");
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        String result = (String) callPrivateMethod("org.crap4j.external.AntBuilder", "replaceFileSetWithPattern", new Class[] {List.class, String.class}, antBuilder, new Object[] {arrayList, "testAntBuilderPattern"});
        assertEquals("result", "\t\t\t\t<fileset dir=\"#CLASS_DIR#\">\n\t\t\t\t\t<include name=\"**/*Test.class\"/>\n\t\t\t\t\t<include name=\"**/Test*.class\"/>\n\t\t\t\t</fileset>\n", result);
    }
    
    public void testReplacePathElementsForPattern() throws Throwable {
        List arrayList = new ArrayList();
        arrayList.add("path1");
        String result = new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2").replacePathElementsForPattern(arrayList, "testAntBuilderParam2", "testAntBuilderParam3");
        assertEquals("result", "testAntBuilderParam3\n", result);
    }
    
    public void testReplacePathElementsForPattern1() throws Throwable {
        String result = new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2").replacePathElementsForPattern(new ArrayList(100), "testAntBuilderParam2", "testAntBuilderParam3");
        assertEquals("result", "", result);
    }
    
    public void testBuildContentThrowsNullPointerException() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2");
        try {
            antBuilder.buildContent(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
        }
    }
    
    public void testBuildFileForProjectThrowsNullPointerException() throws Throwable {
        try {
            new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2").buildFileForProject(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
        }
    }
    
    public void testBuildFileForProjectThrowsNullPointerException1() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        CrapProject project = new CrapProject(null, new ArrayList(100), new ArrayList(1000), new ArrayList(0), new ArrayList(1), "/home/agitar/work/sexy-dolphin-01-agitar-1/tmp/agitar-agitar/Agitator1268.dir/Agitator42.tmp");
        try {
            antBuilder.buildFileForProject(project);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(File.class, ex);
            // dependencies on static and environment state led to removal of 1 assertion
        }
    }
    
    public void testMakeForwardSlashThrowsNullPointerException() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        try {
            callPrivateMethod("org.crap4j.external.AntBuilder", "makeForwardSlash", new Class[] {String.class}, antBuilder, new Object[] {null});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
        }
    }
    
    public void testMakeForwardSlashesThrowsNullPointerException() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        List arrayList = new ArrayList(100);
        arrayList.add(null);
        try {
            callPrivateMethod("org.crap4j.external.AntBuilder", "makeForwardSlashes", new Class[] {List.class}, antBuilder, new Object[] {arrayList});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
            assertEquals("(ArrayList) arrayList.size()", 1, arrayList.size());
        }
    }
    
    public void testReplaceFileSetWithPatternThrowsNullPointerException() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        List arrayList = new ArrayList(100);
        arrayList.add("testString");
        try {
            callPrivateMethod("org.crap4j.external.AntBuilder", "replaceFileSetWithPattern", new Class[] {List.class, String.class}, antBuilder, new Object[] {arrayList, null});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Pattern.class, ex);
            assertEquals("(ArrayList) arrayList.size()", 1, arrayList.size());
        }
    }
    
    public void testReplaceFileSetWithPatternThrowsNullPointerException1() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        try {
            callPrivateMethod("org.crap4j.external.AntBuilder", "replaceFileSetWithPattern", new Class[] {List.class, String.class}, antBuilder, new Object[] {null, "testAntBuilderPattern"});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
        }
    }
    
    public void testReplacePathElementsForPatternThrowsNullPointerException() throws Throwable {
        AntBuilder antBuilder = new AntBuilder("testAntBuilderAgitatorEclipseCoveragePluginDir", "testAntBuilderAgitatorEclipseApiPluginDir");
        List paths = new ArrayList(100);
        paths.add("");
        try {
            antBuilder.replacePathElementsForPattern(paths, "testAntBuilderPattern", null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
            assertEquals("(ArrayList) paths.size()", 1, paths.size());
        }
    }
    
    public void testReplacePathElementsForPatternThrowsNullPointerException1() throws Throwable {
        try {
            new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2").replacePathElementsForPattern(null, "testAntBuilderParam2", "testAntBuilderParam3");
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntBuilder.class, ex);
        }
    }
    
    public void testReplacePathElementsForPatternThrowsPatternSyntaxException() throws Throwable {
        List arrayList = new ArrayList(100);
        arrayList.add("testString");
        try {
            new AntBuilder("testAntBuilderParam1", "testAntBuilderParam2").replacePathElementsForPattern(arrayList, "\\", "testAntBuilderParam3");
            fail("Expected PatternSyntaxException to be thrown");
        } catch (PatternSyntaxException ex) {
            assertEquals("ex.getMessage()", "Unexpected internal error near index 1\n\\\n ^", ex.getMessage());
            assertThrownBy(Pattern.class, ex);
        }
    }
}

