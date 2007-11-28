/**
 * Generated by Agitar build: JUnitFactory Version 2.1.1.000614 (Build date: Nov 19, 2007) [2.1.1.000614]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 27, 2007 4:11:33 PM
 * Time to generate: 01:18.091 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.IOException;
import org.crap4j.external.AntBuilder;
import org.crap4j.external.AntRunner;
import org.crap4j.util.FileUtil;

public class AntSuperrunnerCoverageStrategyAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return AntSuperrunnerCoverageStrategy.class;
    }
    
    public void testConstructor() throws Throwable {
        Main main = Main.createMain("testAntSuperrunnerCoverageStrategyParam1", "testAntSuperrunnerCoverageStrategyParam2", "testAntSuperrunnerCoverageStrategyParam3", "testAntSuperrunnerCoverageStrategyParam4", "testAntSuperrunnerCoverageStrategyParam5");
        AntSuperrunnerCoverageStrategy antSuperrunnerCoverageStrategy = new AntSuperrunnerCoverageStrategy(main);
        assertSame("antSuperrunnerCoverageStrategy.main", main, getPrivateField(antSuperrunnerCoverageStrategy, "main"));
    }
    
    public void testExecuteWithAggressiveMocks() throws Throwable {
        AntSuperrunnerCoverageStrategy antSuperrunnerCoverageStrategy = (AntSuperrunnerCoverageStrategy) Mockingbird.getProxyObject(AntSuperrunnerCoverageStrategy.class, true);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(crapProject.getCoverageDir(), iOException);
        Mockingbird.setReturnValue(false, iOException, "printStackTrace", "()void", new Object[] {}, null, 1);
        Mockingbird.enterTestMode(AntSuperrunnerCoverageStrategy.class);
        antSuperrunnerCoverageStrategy.execute(null, crapProject, false);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testExecuteWithAggressiveMocks1() throws Throwable {
        AntSuperrunnerCoverageStrategy antSuperrunnerCoverageStrategy = (AntSuperrunnerCoverageStrategy) Mockingbird.getProxyObject(AntSuperrunnerCoverageStrategy.class, true);
        Main main = (Main) Mockingbird.getProxyObject(Main.class);
        Crap4jRunner crap4jRunner = (Crap4jRunner) Mockingbird.getProxyObject(Crap4jRunner.class);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        setPrivateField(antSuperrunnerCoverageStrategy, "main", main);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(crapProject.getCoverageDir(), "");
        main.agitatorEclipseCoveragePluginDir = "";
        main.antHome = "";
        main.junitLib = "";
        main.agitatorEclipseApiPluginDir = "";
        Mockingbird.setReturnValue(true, FileUtil.class, "ensureCleanDirectory", "(java.lang.String)void", null, 1);
        AntBuilder antBuilder = (AntBuilder) Mockingbird.getProxyObject(AntBuilder.class);
        Mockingbird.replaceObjectForRecording(AntBuilder.class, "<init>(java.lang.String,java.lang.String)", antBuilder);
        Mockingbird.setReturnValue(antBuilder.buildFileForProject(crapProject), "");
        AntRunner antRunner = (AntRunner) Mockingbird.getProxyObject(AntRunner.class);
        Mockingbird.replaceObjectForRecording(AntRunner.class, "<init>(java.lang.String,java.lang.String,java.lang.String,java.lang.String,boolean)", antRunner);
        Mockingbird.setReturnValue(antRunner.run(), 0);
        crap4jRunner.readResults(crapProject);
        Mockingbird.setExceptionForVoid(iOException);
        Mockingbird.setReturnValue(false, iOException, "printStackTrace", "()void", new Object[] {}, null, 1);
        Mockingbird.enterTestMode(AntSuperrunnerCoverageStrategy.class);
        antSuperrunnerCoverageStrategy.execute(crap4jRunner, crapProject, false);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testExecuteWithAggressiveMocks2() throws Throwable {
        AntSuperrunnerCoverageStrategy antSuperrunnerCoverageStrategy = (AntSuperrunnerCoverageStrategy) Mockingbird.getProxyObject(AntSuperrunnerCoverageStrategy.class, true);
        Main main = (Main) Mockingbird.getProxyObject(Main.class);
        Crap4jRunner crap4jRunner = (Crap4jRunner) Mockingbird.getProxyObject(Crap4jRunner.class);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        setPrivateField(antSuperrunnerCoverageStrategy, "main", main);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(crapProject.getCoverageDir(), "");
        main.agitatorEclipseCoveragePluginDir = "";
        main.antHome = "";
        main.junitLib = "";
        main.agitatorEclipseApiPluginDir = "";
        Mockingbird.setReturnValue(true, FileUtil.class, "ensureCleanDirectory", "(java.lang.String)void", null, 1);
        AntBuilder antBuilder = (AntBuilder) Mockingbird.getProxyObject(AntBuilder.class);
        Mockingbird.replaceObjectForRecording(AntBuilder.class, "<init>(java.lang.String,java.lang.String)", antBuilder);
        Mockingbird.setReturnValue(antBuilder.buildFileForProject(crapProject), "");
        AntRunner antRunner = (AntRunner) Mockingbird.getProxyObject(AntRunner.class);
        Mockingbird.replaceObjectForRecording(AntRunner.class, "<init>(java.lang.String,java.lang.String,java.lang.String,java.lang.String,boolean)", antRunner);
        Mockingbird.setReturnValue(antRunner.run(), 0);
        crap4jRunner.readResults(crapProject);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(AntSuperrunnerCoverageStrategy.class);
        antSuperrunnerCoverageStrategy.execute(crap4jRunner, crapProject, false);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testExecuteThrowsNullPointerException() throws Throwable {
        Main main = Main.createMain("testAntSuperrunnerCoverageStrategyParam1", "testAntSuperrunnerCoverageStrategyParam2", "testAntSuperrunnerCoverageStrategyParam3", "testAntSuperrunnerCoverageStrategyParam4", "testAntSuperrunnerCoverageStrategyParam5");
        Crap4jRunner crap4jRunner = new Crap4jRunner(true, false, false, new AntSuperrunnerCoverageStrategy(Main.createMain()), 100.0F, 1000.0F, 0.0F, "testAntSuperrunnerCoverageStrategyParam8");
        try {
            new AntSuperrunnerCoverageStrategy(main).execute(crap4jRunner, null, true);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AntSuperrunnerCoverageStrategy.class, ex);
        }
    }
}

