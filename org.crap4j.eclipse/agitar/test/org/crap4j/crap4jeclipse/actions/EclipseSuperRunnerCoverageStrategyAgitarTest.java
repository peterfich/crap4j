/**
 * Generated by Agitar build: JUnitFactory Version 2.0.3.000562 (Build date: Oct 09, 2007) [2.0.3.000562]
 * JDK Version: 1.5.0_11
 *
 * Generated on Oct 15, 2007 5:45:28 PM
 * Time to generate: 00:37.630 seconds
 *
 */

package org.crap4j.crap4jeclipse.actions;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.IOException;
import org.crap4j.Crap4jRunner;
import org.crap4j.CrapProject;
import org.crap4j.util.FileUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;

public class EclipseSuperRunnerCoverageStrategyAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return EclipseSuperRunnerCoverageStrategy.class;
    }
    
    public void testConstructor() throws Throwable {
        ISelection selection = new TreeSelection();
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = new EclipseSuperRunnerCoverageStrategy(selection);
        assertSame("eclipseSuperRunnerCoverageStrategy.selection", selection, getPrivateField(eclipseSuperRunnerCoverageStrategy, "selection"));
    }
    
    public void testExecuteWithAggressiveMocks() throws Throwable {
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = (EclipseSuperRunnerCoverageStrategy) Mockingbird.getProxyObject(EclipseSuperRunnerCoverageStrategy.class, true);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(crapProject.getCoverageDir(), iOException);
        Mockingbird.setReturnValue(false, iOException, "printStackTrace", "()void", new Object[] {}, null, 1);
        Mockingbird.enterTestMode(EclipseSuperRunnerCoverageStrategy.class);
        eclipseSuperRunnerCoverageStrategy.execute(null, crapProject, false);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testExecuteWithAggressiveMocks1() throws Throwable {
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = (EclipseSuperRunnerCoverageStrategy) Mockingbird.getProxyObject(EclipseSuperRunnerCoverageStrategy.class, true);
        CrapProject crapProject = (CrapProject) Mockingbird.getProxyObject(CrapProject.class);
        Display display = (Display) Mockingbird.getProxyObject(Display.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(crapProject.getCoverageDir(), "");
        Mockingbird.setReturnValue(true, FileUtil.class, "ensureCleanDirectory", "(java.lang.String)void", null, 1);
        Mockingbird.setReturnValue(crapProject.getAllProjectClasses(), null);
        Mockingbird.setReturnValue(FileUtil.hasTestClassFiles(null), false);
        Runnable runnable = (Runnable) Mockingbird.getProxyObject(Class.forName("org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy$2"));
        Mockingbird.replaceObjectForRecording(Class.forName("org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy$2"), "<init>(org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy,org.crap4j.Crap4jRunner,org.crap4j.CrapProject)", runnable);
        Mockingbird.setReturnValue(Display.getDefault(), display);
        display.asyncExec(runnable);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(EclipseSuperRunnerCoverageStrategy.class);
        eclipseSuperRunnerCoverageStrategy.execute(null, crapProject, false);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testExecuteThrowsNullPointerException() throws Throwable {
        Crap4jRunner runner = new Crap4jRunner(true, false, new EclipseSuperRunnerCoverageStrategy(new TreeSelection()), 100.0F, 1000.0F, 0.0F);
        try {
            new EclipseSuperRunnerCoverageStrategy(new StructuredSelection()).execute(runner, null, true);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(EclipseSuperRunnerCoverageStrategy.class, ex);
        }
    }
}
