/**
 * Generated by Agitar build: JUnitFactory Version 2.0.3.000562 (Build date: Oct 09, 2007) [2.0.3.000562]
 * JDK Version: 1.5.0_11
 *
 * Generated on Oct 15, 2007 5:43:39 PM
 * Time to generate: 00:24.583 seconds
 *
 */

package org.crap4j.crap4jeclipse;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import org.eclipse.core.runtime.Status;

public class Crap4jEclipseLogAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return Crap4jEclipseLog.class;
    }
    
    public void testConstructor() throws Throwable {
        new Crap4jEclipseLog();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testLogErrorThrowsNullPointerException() throws Throwable {
        ArrayStoreException exception = (ArrayStoreException) Mockingbird.getProxyObject(ArrayStoreException.class);
        Mockingbird.enterRecordingMode();
        Crap4jEclipseLog.logError("Unexpected Exception: ", exception);
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logError(exception);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogErrorThrowsNullPointerException1() throws Throwable {
        Throwable exception = new ArrayStoreException("testCrap4jEclipseLogParam1");
        Mockingbird.enterRecordingMode();
        Crap4jEclipseLog.logError("Unexpected Exception: ", exception);
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logError(exception);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogErrorThrowsNullPointerException2() throws Throwable {
        Throwable exception = new ArrayStoreException("testCrap4jEclipseLogParam1");
        Mockingbird.enterRecordingMode();
        callPrivateMethod("org.crap4j.crap4jeclipse.Crap4jEclipseLog", "log", new Class[] {int.class, int.class, String.class, Throwable.class}, null, new Object[] {new Integer(4), new Integer(0), "Crap4yjEclipse", exception});
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logError("Crap4yjEclipse", exception);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogErrorThrowsNullPointerException3() throws Throwable {
        ArrayStoreException exception = (ArrayStoreException) Mockingbird.getProxyObject(ArrayStoreException.class);
        Mockingbird.enterRecordingMode();
        callPrivateMethod("org.crap4j.crap4jeclipse.Crap4jEclipseLog", "log", new Class[] {int.class, int.class, String.class, Throwable.class}, null, new Object[] {new Integer(4), new Integer(0), "Crap4yjEclipse", exception});
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logError("Crap4yjEclipse", exception);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogInfoThrowsNullPointerException() throws Throwable {
        Mockingbird.enterRecordingMode();
        callPrivateMethod("org.crap4j.crap4jeclipse.Crap4jEclipseLog", "log", new Class[] {int.class, int.class, String.class, Throwable.class}, null, new Object[] {new Integer(1), new Integer(0), "testString", null});
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logInfo("testString");
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogInfoThrowsNullPointerException1() throws Throwable {
        Mockingbird.enterRecordingMode();
        callPrivateMethod("org.crap4j.crap4jeclipse.Crap4jEclipseLog", "log", new Class[] {int.class, int.class, String.class, Throwable.class}, null, new Object[] {new Integer(1), new Integer(0), "testString", null});
        Mockingbird.setExceptionForVoid((Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.logInfo("testString");
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testLogThrowsNullPointerException() throws Throwable {
        Status status = (Status) Mockingbird.getProxyObject(Status.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(Activator.getDefault(), null);
        Mockingbird.enterTestMode(Crap4jEclipseLog.class);
        try {
            Crap4jEclipseLog.log(status);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Crap4jEclipseLog.class, ex);
        }
    }
}

