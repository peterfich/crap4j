/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 12:02:01 AM
 * Time to generate: 00:20.417 seconds
 *
 */

package org.crap4j.external;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;

public class MyCoveragePointAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MyCoveragePoint.class;
    }
    
    public void testConstructor() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint();
        assertEquals("myCoveragePoint.type", new Integer(-1), getPrivateField(myCoveragePoint, "type"));
    }
    
    public void testConstructor1() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(100, 1000, 0, -1);
        assertEquals("myCoveragePoint.byteOffset", new Integer(1000), getPrivateField(myCoveragePoint, "byteOffset"));
        assertEquals("myCoveragePoint.methodNumber", new Integer(0), getPrivateField(myCoveragePoint, "methodNumber"));
        assertEquals("myCoveragePoint.lineNumber", new Integer(-1), getPrivateField(myCoveragePoint, "lineNumber"));
        assertEquals("myCoveragePoint.type", new Integer(100), getPrivateField(myCoveragePoint, "type"));
    }
    
    public void testConstructor2() throws Throwable {
        DataInput dataInput = (DataInput) Mockingbird.getProxyObject(DataInput.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataInput.readInt(), 0);
        Mockingbird.setReturnValue(dataInput.readInt(), 0);
        Mockingbird.setReturnValue(dataInput.readInt(), 0);
        Mockingbird.setReturnValue(dataInput.readInt(), 0);
        Mockingbird.setReturnValue(dataInput.readInt(), 0);
        Mockingbird.enterTestMode();
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(dataInput);
        assertEquals("myCoveragePoint.byteOffset", new Integer(0), getPrivateField(myCoveragePoint, "byteOffset"));
        assertEquals("myCoveragePoint.methodNumber", new Integer(0), getPrivateField(myCoveragePoint, "methodNumber"));
        assertEquals("myCoveragePoint.timesReached", new Integer(0), getPrivateField(myCoveragePoint, "timesReached"));
        assertEquals("myCoveragePoint.lineNumber", new Integer(0), getPrivateField(myCoveragePoint, "lineNumber"));
        assertEquals("myCoveragePoint.type", new Integer(0), getPrivateField(myCoveragePoint, "type"));
    }
    
    public void testGetTimesReached() throws Throwable {
        int result = new MyCoveragePoint().getTimesReached();
        assertEquals("result", 0, result);
    }
    
    public void testGetTimesReached1() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(100, 1000, 0, -1);
        myCoveragePoint.setTimesReached(100);
        int result = myCoveragePoint.getTimesReached();
        assertEquals("result", 100, result);
    }
    
    public void testSetByteOffset() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint();
        myCoveragePoint.setByteOffset(100);
        assertEquals("myCoveragePoint.byteOffset", new Integer(100), getPrivateField(myCoveragePoint, "byteOffset"));
    }
    
    public void testSetLineNumber() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint();
        myCoveragePoint.setLineNumber(100);
        assertEquals("myCoveragePoint.lineNumber", new Integer(100), getPrivateField(myCoveragePoint, "lineNumber"));
    }
    
    public void testSetMethodNumber() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(100, 1000, 0, -1);
        myCoveragePoint.setMethodNumber(100);
        assertEquals("myCoveragePoint.methodNumber", new Integer(100), getPrivateField(myCoveragePoint, "methodNumber"));
    }
    
    public void testSetTimesReached() throws Throwable {
        boolean result = new MyCoveragePoint().setTimesReached(0);
        assertFalse("result", result);
    }
    
    public void testSetTimesReached1() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(100, 1000, 0, -1);
        boolean result = myCoveragePoint.setTimesReached(100);
        assertEquals("myCoveragePoint.timesReached", new Integer(100), getPrivateField(myCoveragePoint, "timesReached"));
        assertTrue("result", result);
    }
    
    public void testSetType() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint(100, 1000, 0, -1);
        myCoveragePoint.setType(100);
        assertEquals("myCoveragePoint.type", new Integer(100), getPrivateField(myCoveragePoint, "type"));
    }
    
    public void testToString() throws Throwable {
        String result = new MyCoveragePoint(100, 1000, 0, -1).toString();
        assertEquals("result", "[-1/0/100]", result);
    }
    
    public void testConstructorThrowsEOFException() throws Throwable {
        byte[] bytes = new byte[1];
        try {
            new MyCoveragePoint(new DataInputStream(new ByteArrayInputStream(bytes)));
            fail("Expected EOFException to be thrown");
        } catch (EOFException ex) {
            assertEquals("ex.getClass()", EOFException.class, ex.getClass());
            assertThrownBy(DataInputStream.class, ex);
        }
    }
    
    public void testConstructorThrowsNullPointerException() throws Throwable {
        try {
            new MyCoveragePoint(new DataInputStream(null));
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(DataInputStream.class, ex);
        }
    }
    
    public void testReadThrowsEOFException() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint();
        try {
            myCoveragePoint.read(new DataInputStream(new ByteArrayInputStream("testString".getBytes())));
            fail("Expected EOFException to be thrown");
        } catch (EOFException ex) {
            assertEquals("myCoveragePoint.type", new Integer(1952805748), getPrivateField(myCoveragePoint, "type"));
            assertEquals("myCoveragePoint.byteOffset", new Integer(1400140393), getPrivateField(myCoveragePoint, "byteOffset"));
            assertEquals("ex.getClass()", EOFException.class, ex.getClass());
            assertThrownBy(DataInputStream.class, ex);
            assertEquals("myCoveragePoint.methodNumber", new Integer(0), getPrivateField(myCoveragePoint, "methodNumber"));
            assertEquals("myCoveragePoint.timesReached", new Integer(0), getPrivateField(myCoveragePoint, "timesReached"));
            assertEquals("myCoveragePoint.lineNumber", new Integer(0), getPrivateField(myCoveragePoint, "lineNumber"));
        }
    }
    
    public void testReadThrowsNullPointerException() throws Throwable {
        MyCoveragePoint myCoveragePoint = new MyCoveragePoint();
        try {
            myCoveragePoint.read(new DataInputStream(null));
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(DataInputStream.class, ex);
            assertEquals("myCoveragePoint.byteOffset", new Integer(0), getPrivateField(myCoveragePoint, "byteOffset"));
            assertEquals("myCoveragePoint.methodNumber", new Integer(0), getPrivateField(myCoveragePoint, "methodNumber"));
            assertEquals("myCoveragePoint.timesReached", new Integer(0), getPrivateField(myCoveragePoint, "timesReached"));
            assertEquals("myCoveragePoint.lineNumber", new Integer(0), getPrivateField(myCoveragePoint, "lineNumber"));
            assertEquals("myCoveragePoint.type", new Integer(-1), getPrivateField(myCoveragePoint, "type"));
        }
    }
}
