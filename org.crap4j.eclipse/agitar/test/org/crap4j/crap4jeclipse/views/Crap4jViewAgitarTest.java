/**
 * Generated by Agitar build: JUnitFactory Version 2.0.3.000562 (Build date: Oct 09, 2007) [2.0.3.000562]
 * JDK Version: 1.5.0_11
 *
 * Generated on Oct 15, 2007 5:45:19 PM
 * Time to generate: 01:48.530 seconds
 *
 */

package org.crap4j.crap4jeclipse.views;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Crap4jViewAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return Crap4jView.class;
    }
    
    public void testConstructor() throws Throwable {
        Crap4jView crap4jView = new Crap4jView();
        assertEquals("crap4jView.getPartProperties().size()", 0, crap4jView.getPartProperties().size());
        assertEquals("crap4jView.getTitleToolTip()", "", crap4jView.getTitleToolTip());
        assertEquals("crap4jView.getTitle()", "", crap4jView.getTitle());
        assertEquals("crap4jView.getContentDescription()", "", crap4jView.getContentDescription());
        assertEquals("crap4jView.partChangeListeners.size()", 0, ((ListenerList) getPrivateField(crap4jView, "partChangeListeners")).size());
        assertNotNull("crap4jView.compatibilityTitleListener", getPrivateField(crap4jView, "compatibilityTitleListener"));
        assertNotNull("crap4jView.listenerList", getPrivateField(crap4jView, "listenerList"));
        assertEquals("crap4jView.getPartName()", "", crap4jView.getPartName());
    }
    
    public void testNameSorterConstructor() throws Throwable {
        Crap4jView.NameSorter nameSorter = new Crap4jView().new NameSorter();
        assertNotNull("nameSorter.comparator", getPrivateField(nameSorter, "comparator"));
        assertEquals("nameSorter.getCollator().getDecomposition()", 0, nameSorter.getCollator().getDecomposition());
    }
    
    public void testViewContentProviderConstructor() throws Throwable {
        new Crap4jView().new ViewContentProvider();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testViewLabelProviderConstructor() throws Throwable {
        Crap4jView.ViewLabelProvider viewLabelProvider = new Crap4jView().new ViewLabelProvider();
        assertNull("viewLabelProvider.listenerList", getPrivateField(viewLabelProvider, "listenerList"));
    }
    
    public void testSetFocusWithAggressiveMocks() throws Throwable {
        Crap4jView crap4jView = (Crap4jView) Mockingbird.getProxyObject(Crap4jView.class, true);
        TableViewer tableViewer = (TableViewer) Mockingbird.getProxyObject(TableViewer.class);
        Table table = (Table) Mockingbird.getProxyObject(Table.class);
        setPrivateField(crap4jView, "viewer", tableViewer);
        setPrivateField(tableViewer, "table", table);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, table, "setFocus", "()boolean", Boolean.FALSE, 1);
        Mockingbird.enterTestMode(Crap4jView.class);
        crap4jView.setFocus();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testViewContentProviderDispose() throws Throwable {
        new Crap4jView().new ViewContentProvider().dispose();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testViewContentProviderGetElements() throws Throwable {
        String[] result = (String[]) new Crap4jView().new ViewContentProvider().getElements("");
        assertEquals("result.length", 3, result.length);
        assertEquals("(String[]) result[0]", "One", ((String[]) result)[0]);
    }
    
    public void testViewContentProviderInputChangedWithAggressiveMocks() throws Throwable {
        Crap4jView.ViewContentProvider viewContentProvider = (Crap4jView.ViewContentProvider) Mockingbird.getProxyObject(Crap4jView.ViewContentProvider.class, true);
        Mockingbird.enterTestMode(Crap4jView.ViewContentProvider.class);
        viewContentProvider.inputChanged(null, null, null);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testViewLabelProviderGetColumnImageWithAggressiveMocks() throws Throwable {
        Crap4jView.ViewLabelProvider viewLabelProvider = (Crap4jView.ViewLabelProvider) Mockingbird.getProxyObject(Crap4jView.ViewLabelProvider.class, true);
        IWorkbench iWorkbench = (IWorkbench) Mockingbird.getProxyObject(IWorkbench.class);
        ISharedImages iSharedImages = (ISharedImages) Mockingbird.getProxyObject(ISharedImages.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(PlatformUI.getWorkbench(), iWorkbench);
        Mockingbird.setReturnValue(iWorkbench.getSharedImages(), iSharedImages);
        Mockingbird.setReturnValue(iSharedImages.getImage("IMG_OBJ_ELEMENTS"), null);
        Mockingbird.enterTestMode(Crap4jView.ViewLabelProvider.class);
        Image result = viewLabelProvider.getColumnImage(null, 0);
        assertNull("result", result);
    }
    
    public void testViewLabelProviderGetColumnText() throws Throwable {
        new Crap4jView().new ViewLabelProvider().getColumnText(new Crap4jView(), 100);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testCreatePartControlThrowsSWTException() throws Throwable {
        Composite parent = (Composite) callPrivateMethod("org.eclipse.swt.widgets.Composite", "<init>", new Class[] {}, null, new Object[] {});
        Crap4jView crap4jView = new Crap4jView();
        try {
            crap4jView.createPartControl(parent);
            fail("Expected SWTException to be thrown");
        } catch (SWTException ex) {
            assertEquals("ex.getMessage()", "Widget is disposed", ex.getMessage());
            assertThrownBy(SWT.class, ex);
            assertEquals("ex.code", 24, ex.code);
            assertNull("ex.throwable", ex.throwable);
            assertNull("crap4jView.viewer", getPrivateField(crap4jView, "viewer"));
            assertNull("crap4jView.action2", getPrivateField(crap4jView, "action2"));
            assertNull("crap4jView.doubleClickAction", getPrivateField(crap4jView, "doubleClickAction"));
            assertNull("crap4jView.action1", getPrivateField(crap4jView, "action1"));
        }
    }
    
    public void testSetFocusThrowsNullPointerException() throws Throwable {
        try {
            new Crap4jView().setFocus();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Crap4jView.class, ex);
        }
    }
    
    public void testViewLabelProviderGetColumnImageThrowsIllegalStateException() throws Throwable {
        try {
            new Crap4jView().new ViewLabelProvider().getColumnImage("testString", 100);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException ex) {
            assertEquals("ex.getMessage()", "Workbench has not been created yet.", ex.getMessage());
            assertThrownBy(PlatformUI.class, ex);
        }
    }
    
    public void testViewLabelProviderGetImageThrowsIllegalStateException() throws Throwable {
        try {
            new Crap4jView().new ViewLabelProvider().getImage("testString");
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException ex) {
            assertEquals("ex.getMessage()", "Workbench has not been created yet.", ex.getMessage());
            assertThrownBy(PlatformUI.class, ex);
        }
    }
}
