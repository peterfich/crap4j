/**
 * Generated by Agitar build: JUnitFactory Version 2.1.1.000614 (Build date: Nov 19, 2007) [2.1.1.000614]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 27, 2007 4:09:26 PM
 * Time to generate: 00:30.562 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.agitar.lib.mockingbird.MockingbirdSystem;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.crap4j.benchmark.StatsDownloader;
import org.crap4j.external.MetricsComplexityReader;
import org.crap4j.external.SuperRunnerCoverageReader;

public class Crap4jRunnerAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return Crap4jRunner.class;
    }
    
    public void testConstructor() throws Throwable {
        CoverageGeneratorStrategy antSuperrunnerCoverageStrategy = new AntSuperrunnerCoverageStrategy(Main.createMain());
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, antSuperrunnerCoverageStrategy, 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerParam8");
        assertTrue("crap4jRunner.downloadAverages", ((Boolean) getPrivateField(crap4jRunner, "downloadAverages")).booleanValue());
        assertTrue("crap4jRunner.debug", ((Boolean) getPrivateField(crap4jRunner, "debug")).booleanValue());
        assertEquals("crap4jRunner.crapPercentCriticalThreshold", 0.0F, ((Number) getPrivateField(crap4jRunner, "crapPercentCriticalThreshold")).floatValue(), 1.0E-6F);
        assertSame("crap4jRunner.coverageStrategy", antSuperrunnerCoverageStrategy, getPrivateField(crap4jRunner, "coverageStrategy"));
        assertEquals("crap4jRunner.crapThreshold", 100.0F, ((Number) getPrivateField(crap4jRunner, "crapThreshold")).floatValue(), 1.0E-6F);
        assertFalse("crap4jRunner.dontTest", ((Boolean) getPrivateField(crap4jRunner, "dontTest")).booleanValue());
        assertEquals("crap4jRunner.server", "testCrap4jRunnerParam8", getPrivateField(crap4jRunner, "server"));
        assertEquals("crap4jRunner.crapPercentWarningThreshold", 1000.0F, ((Number) getPrivateField(crap4jRunner, "crapPercentWarningThreshold")).floatValue(), 1.0E-6F);
    }
    
    public void testBuildMethodCrap() throws Throwable {
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerServer");
        ArrayList result = (ArrayList) callPrivateMethod("org.crap4j.Crap4jRunner", "buildMethodCrap", new Class[] {List.class, List.class}, crap4jRunner, new Object[] {new ArrayList(100), new ArrayList(1000)});
        assertEquals("result.size()", 0, result.size());
    }
    
    public void testBuildMethodCrap1() throws Throwable {
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerServer");
        List arrayList = new ArrayList(100);
        MethodComplexity methodComplexity = new MethodComplexity("testCrap4jRunnerMethodSignature", "testCrap4jRunnerPkgclassName", "testCrap4jRunnerMethodName", "testCrap4jRunnerMethodDescriptor", "testCrap4jRunnerJava5Signature", 100, "testCrap4jRunnerPrettyMethodSignature");
        List arrayList2 = new ArrayList(1000);
        arrayList2.add(methodComplexity);
        ArrayList result = (ArrayList) callPrivateMethod("org.crap4j.Crap4jRunner", "buildMethodCrap", new Class[] {List.class, List.class}, crap4jRunner, new Object[] {arrayList, arrayList2});
        assertEquals("result.size()", 1, result.size());
    }
    
    public void testDoProjectWithAggressiveMocks() throws Throwable {
        Crap4jRunner crap4jRunner = (Crap4jRunner) Mockingbird.getProxyObject(Crap4jRunner.class, true);
        CoverageGeneratorStrategy coverageGeneratorStrategy = (CoverageGeneratorStrategy) Mockingbird.getProxyObject(CoverageGeneratorStrategy.class);
        setPrivateField(crap4jRunner, "dontTest", Boolean.FALSE);
        setPrivateField(crap4jRunner, "coverageStrategy", coverageGeneratorStrategy);
        setPrivateField(crap4jRunner, "debug", Boolean.FALSE);
        Mockingbird.enterRecordingMode();
        coverageGeneratorStrategy.execute(crap4jRunner, null, false);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(Crap4jRunner.class);
        crap4jRunner.doProject(null);
        assertNotNull("crap4jRunner.coverageStrategy", getPrivateField(crap4jRunner, "coverageStrategy"));
    }
    
    public void testReadCoverage() throws Throwable {
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerServer");
        ArrayList result = (ArrayList) callPrivateMethod("org.crap4j.Crap4jRunner", "readCoverage", new Class[] {CrapProject.class}, crap4jRunner, new Object[] {null});
        assertEquals("result.size()", 0, result.size());
    }
    
    public void testReadResultsWithAggressiveMocks() throws Throwable {
        Crap4jRunner crap4jRunner = (Crap4jRunner) Mockingbird.getProxyObject(Crap4jRunner.class, true);
        setPrivateField(crap4jRunner, "crapThreshold", new Float(2.8E-45F));
        setPrivateField(crap4jRunner, "crapPercentWarningThreshold", new Float(2.8E-45F));
        setPrivateField(crap4jRunner, "crapPercentCriticalThreshold", new Float(2.8E-45F));
        setPrivateField(crap4jRunner, "downloadAverages", Boolean.FALSE);
        setPrivateField(crap4jRunner, "server", "");
        PrintStream printStream = (PrintStream) Mockingbird.getProxyObject(PrintStream.class);
        MockingbirdSystem.out = printStream;
        Mockingbird.enterRecordingMode();
        SuperRunnerCoverageReader superRunnerCoverageReader = (SuperRunnerCoverageReader) Mockingbird.getProxyObject(SuperRunnerCoverageReader.class);
        Mockingbird.replaceObjectForRecording(SuperRunnerCoverageReader.class, "<init>(org.crap4j.CrapProject)", superRunnerCoverageReader);
        Mockingbird.setReturnValue(superRunnerCoverageReader.read(), null);
        MetricsComplexityReader metricsComplexityReader = (MetricsComplexityReader) Mockingbird.getProxyObject(MetricsComplexityReader.class);
        Mockingbird.replaceObjectForRecording(MetricsComplexityReader.class, "<init>(org.crap4j.CrapProject)", metricsComplexityReader);
        Mockingbird.setReturnValue(metricsComplexityReader.readMethodComplexities(), null);
        Mockingbird.setReturnValue(MethodCrap.combine(null, null), null);
        StatsDownloader statsDownloader = (StatsDownloader) Mockingbird.getProxyObject(StatsDownloader.class);
        Mockingbird.replaceObjectForRecording(StatsDownloader.class, "<init>(java.lang.String)", statsDownloader);
        Mockingbird.setReturnValue(statsDownloader.getAverage(false), null);
        SystemCrapStats systemCrapStats = (SystemCrapStats) Mockingbird.getProxyObject(SystemCrapStats.class);
        Mockingbird.replaceObjectForRecording(SystemCrapStats.class, "<init>(java.util.List,java.lang.String,org.crap4j.CrapProject,float,float,float,org.crap4j.benchmark.GlobalStats,java.lang.String)", systemCrapStats);
        systemCrapStats.writeReport();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(systemCrapStats.toString(), "");
        Mockingbird.setReturnValue(false, printStream, "println", "(java.lang.String)void", null, 1);
        Mockingbird.enterTestMode(Crap4jRunner.class);
        crap4jRunner.readResults(null);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testDoProjectThrowsNullPointerException() throws Throwable {
        CoverageGeneratorStrategy antSuperrunnerCoverageStrategy = new AntSuperrunnerCoverageStrategy(Main.createMain());
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, false, antSuperrunnerCoverageStrategy, 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerParam8");
        try {
            crap4jRunner.doProject(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntSuperrunnerCoverageStrategy.class, ex);
            assertSame("crap4jRunner.coverageStrategy", antSuperrunnerCoverageStrategy, getPrivateField(crap4jRunner, "coverageStrategy"));
        }
    }
    
    public void testDoProjectThrowsNullPointerException1() throws Throwable {
        CoverageGeneratorStrategy antSuperrunnerCoverageStrategy = new AntSuperrunnerCoverageStrategy(Main.createMain());
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, true, false, antSuperrunnerCoverageStrategy, 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerParam8");
        try {
            crap4jRunner.doProject(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MetricsComplexityReader.class, ex);
            assertSame("crap4jRunner.coverageStrategy", antSuperrunnerCoverageStrategy, getPrivateField(crap4jRunner, "coverageStrategy"));
        }
    }
    
    public void testGenerateCoverageDataStatsForThrowsNullPointerException() throws Throwable {
        CoverageGeneratorStrategy strategy = new AntSuperrunnerCoverageStrategy(Main.createMain());
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, false, strategy, 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerServer");
        try {
            callPrivateMethod("org.crap4j.Crap4jRunner", "generateCoverageDataStatsFor", new Class[] {CrapProject.class}, crap4jRunner, new Object[] {null});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntSuperrunnerCoverageStrategy.class, ex);
            assertSame("crap4jRunner.coverageStrategy", strategy, getPrivateField(crap4jRunner, "coverageStrategy"));
        }
    }
    
    public void testReadMethodComplexityThrowsNullPointerException() throws Throwable {
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerServer");
        try {
            callPrivateMethod("org.crap4j.Crap4jRunner", "readMethodComplexity", new Class[] {CrapProject.class}, crap4jRunner, new Object[] {null});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MetricsComplexityReader.class, ex);
        }
    }
    
    public void testReadResultsThrowsNullPointerException() throws Throwable {
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, true, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testCrap4jRunnerParam8");
        try {
            crap4jRunner.readResults(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MetricsComplexityReader.class, ex);
        }
    }
}
