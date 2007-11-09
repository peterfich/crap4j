/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 6, 2007 1:39:32 PM
 * Time to generate: 01:49.007 seconds
 *
 */

package org.crap4j.crap4jeclipse.actions;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.IOException;
import java.net.URL;
import org.crap4j.Crap4jRunner;
import org.crap4j.CrapProject;
import org.crap4j.util.FileUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class EclipseSuperRunnerCoverageStrategyAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return EclipseSuperRunnerCoverageStrategy.class;
    }
    
    public void testConstructor() throws Throwable {
        ISelection treeSelection = new TreeSelection();
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = new EclipseSuperRunnerCoverageStrategy(treeSelection);
        assertSame("eclipseSuperRunnerCoverageStrategy.selection", treeSelection, getPrivateField(eclipseSuperRunnerCoverageStrategy, "selection"));
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
        Crap4jRunner runner = new Crap4jRunner(true, false, true, new EclipseSuperRunnerCoverageStrategy(new TreeSelection()), 100.0F, 1000.0F, 0.0F, "testEclipseSuperRunnerCoverageStrategyServer");
        try {
            new EclipseSuperRunnerCoverageStrategy(new StructuredSelection()).execute(runner, null, true);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(EclipseSuperRunnerCoverageStrategy.class, ex);
        }
    }
    
    public void testOpenURLInExternalBrowserThrowsIllegalStateException() throws Throwable {
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = new EclipseSuperRunnerCoverageStrategy(new TreeSelection((TreePath) null));
        URL uRL = new URL("ftp://_J584P_:!!793J0@lmpeombcl.gin.com/bhz8Tb_9E3_/94aB4e___A6N/_L3_3XJ_0lyf/1u50___f7.mgt");
        try {
            callPrivateMethod("org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy", "openURLInExternalBrowser", new Class[] {URL.class}, eclipseSuperRunnerCoverageStrategy, new Object[] {uRL});
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException ex) {
            assertEquals("ex.getMessage()", "Workbench has not been created yet.", ex.getMessage());
            assertThrownBy(PlatformUI.class, ex);
        }
    }
    
    public void testOpenURLInInternalBrowserThrowsIllegalStateException() throws Throwable {
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = new EclipseSuperRunnerCoverageStrategy(TreeSelection.EMPTY);
        URL uRL = new URL("ftp://_J584P_:!!793J0@lmpeombcl.gin.com/bhz8Tb_9E3_/94aB4e___A6N/_L3_3XJ_0lyf/1u50___f7.mgt");
        try {
            callPrivateMethod("org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy", "openURLInInternalBrowser", new Class[] {URL.class}, eclipseSuperRunnerCoverageStrategy, new Object[] {uRL});
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException ex) {
            assertEquals("ex.getMessage()", "Workbench has not been created yet.", ex.getMessage());
            assertThrownBy(PlatformUI.class, ex);
            assertEquals("uRL.getPath()", "/bhz8Tb_9E3_/94aB4e___A6N/_L3_3XJ_0lyf/1u50___f7.mgt", uRL.getPath());
        }
    }
    
    public void testOpenURLThrowsIllegalStateException() throws Throwable {
        EclipseSuperRunnerCoverageStrategy eclipseSuperRunnerCoverageStrategy = new EclipseSuperRunnerCoverageStrategy(TreeSelection.EMPTY);
        URL uRL = new URL("ftp://_J584P_:!!793J0@lmpeombcl.gin.com/bhz8Tb_9E3_/94aB4e___A6N/_L3_3XJ_0lyf/1u50___f7.mgt");
        try {
            callPrivateMethod("org.crap4j.crap4jeclipse.actions.EclipseSuperRunnerCoverageStrategy", "openURL", new Class[] {URL.class}, eclipseSuperRunnerCoverageStrategy, new Object[] {uRL});
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException ex) {
            assertEquals("ex.getMessage()", "Workbench has not been created yet.", ex.getMessage());
            assertThrownBy(PlatformUI.class, ex);
            assertEquals("uRL.getPath()", "/bhz8Tb_9E3_/94aB4e___A6N/_L3_3XJ_0lyf/1u50___f7.mgt", uRL.getPath());
        }
    }
}
