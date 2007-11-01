/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 7:06:12 AM
 * Time to generate: 04:07.703 seconds
 *
 */

package org.crap4j.util;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopierAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return StreamCopier.class;
    }
    
    public void testConstructor() throws Throwable {
        byte[] bytes = new byte[0];
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StreamCopier streamCopier = new StreamCopier(byteArrayInputStream, byteArrayOutputStream, true);
        assertSame("streamCopier.is", byteArrayInputStream, getPrivateField(streamCopier, "is"));
        assertFalse("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
        assertSame("streamCopier.os", byteArrayOutputStream, getPrivateField(streamCopier, "os"));
        assertTrue("streamCopier.close", ((Boolean) getPrivateField(streamCopier, "close")).booleanValue());
    }
    
    public void testConstructor1() throws Throwable {
        InputStream inputStream = (InputStream) Mockingbird.getProxyObject(InputStream.class);
        OutputStream outputStream = (OutputStream) Mockingbird.getProxyObject(OutputStream.class);
        Mockingbird.ignoreConstructorExceptions(Thread.class);
        InterruptedException interruptedException = (InterruptedException) Mockingbird.getProxyObject(InterruptedException.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(true, Thread.class, "sleep", "(long)void", new Object[] {new Long(100L)}, interruptedException, 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(StringBuilder.class), "toString", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(Thread.class), "setName", "(java.lang.String)void", null, 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(Thread.class), "setDaemon", "(boolean)void", null, 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(Thread.class), "start", "()void", null, 1);
        Mockingbird.enterTestMode();
        StreamCopier streamCopier = new StreamCopier(inputStream, outputStream, true);
        assertNotNull("streamCopier.is", getPrivateField(streamCopier, "is"));
        assertFalse("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
        assertNotNull("streamCopier.os", getPrivateField(streamCopier, "os"));
        assertTrue("streamCopier.close", ((Boolean) getPrivateField(streamCopier, "close")).booleanValue());
    }
    
    public void testRunWithAggressiveMocks() throws Throwable {
        StreamCopier streamCopier = (StreamCopier) Mockingbird.getProxyObject(StreamCopier.class, true);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        setPrivateField(streamCopier, "is", null);
        setPrivateField(streamCopier, "os", null);
        setPrivateField(streamCopier, "close", Boolean.FALSE);
        setPrivateField(streamCopier, "dieNow", Boolean.FALSE);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, streamCopier, "copy", "(java.io.InputStream,java.io.OutputStream,boolean)void", new Object[] {null, null, Boolean.FALSE}, iOException, 1);
        Mockingbird.setReturnValue(false, iOException, "printStackTrace", "()void", new Object[] {}, null, 1);
        Mockingbird.enterTestMode(StreamCopier.class);
        streamCopier.run();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testRunWithAggressiveMocks1() throws Throwable {
        StreamCopier streamCopier = (StreamCopier) Mockingbird.getProxyObject(StreamCopier.class, true);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        setPrivateField(streamCopier, "is", null);
        setPrivateField(streamCopier, "os", null);
        setPrivateField(streamCopier, "close", Boolean.FALSE);
        setPrivateField(streamCopier, "dieNow", Boolean.TRUE);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, streamCopier, "copy", "(java.io.InputStream,java.io.OutputStream,boolean)void", new Object[] {null, null, Boolean.FALSE}, iOException, 1);
        Mockingbird.enterTestMode(StreamCopier.class);
        streamCopier.run();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testShutdown() throws Throwable {
        byte[] bytes = new byte[0];
        StreamCopier streamCopier = new StreamCopier(new ByteArrayInputStream(bytes), new ByteArrayOutputStream(), true);
        streamCopier.shutdown(100);
        streamCopier.shutdown(1000);
        assertTrue("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
    }
    
    public void testShutdown1() throws Throwable {
        StreamCopier streamCopier = new StreamCopier((InputStream) Mockingbird.getProxyObject(ByteArrayInputStream.class), (OutputStream) Mockingbird.getProxyObject(ByteArrayOutputStream.class), true);
        Mockingbird.enterTestMode(StreamCopier.class);
        streamCopier.shutdown(100);
        assertTrue("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
    }
    
    public void testShutdown2() throws Throwable {
        StreamCopier streamCopier = new StreamCopier((InputStream) Mockingbird.getProxyObject(ByteArrayInputStream.class), (OutputStream) Mockingbird.getProxyObject(ByteArrayOutputStream.class), true);
        Mockingbird.enterTestMode(StreamCopier.class);
        streamCopier.shutdown(2);
        assertTrue("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
    }
    
    public void testShutdown3() throws Throwable {
        byte[] bytes = new byte[0];
        StreamCopier streamCopier = new StreamCopier(new ByteArrayInputStream(bytes), new ByteArrayOutputStream(), true);
        streamCopier.shutdown(1000);
        streamCopier.shutdown(100);
        assertTrue("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
    }
    
    public void testShutdownWithAggressiveMocks() throws Throwable {
        StreamCopier streamCopier = (StreamCopier) Mockingbird.getProxyObject(StreamCopier.class, true);
        InterruptedException interruptedException = (InterruptedException) Mockingbird.getProxyObject(InterruptedException.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, Mockingbird.getProxyObject(Thread.class), "join", "(long)void", interruptedException, 1);
        Mockingbird.enterTestMode(StreamCopier.class);
        streamCopier.shutdown(0);
        assertTrue("streamCopier.dieNow", ((Boolean) getPrivateField(streamCopier, "dieNow")).booleanValue());
    }
    
    public void testWaitOnCloseWithAggressiveMocks() throws Throwable {
        StreamCopier streamCopier = (StreamCopier) Mockingbird.getProxyObject(StreamCopier.class, true);
        setPrivateField(streamCopier, "close", Boolean.FALSE);
        Mockingbird.enterTestMode(StreamCopier.class);
        callPrivateMethod("org.crap4j.util.StreamCopier", "waitOnClose", new Class[] {}, streamCopier, new Object[] {});
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testConstructorThrowsAssertionError() throws Throwable {
        ByteArrayInputStream i = (ByteArrayInputStream) Mockingbird.getProxyObject(ByteArrayInputStream.class);
        Mockingbird.enterTestMode(StreamCopier.class);
        try {
            new StreamCopier(i, null, true);
            fail("Expected AssertionError to be thrown");
        } catch (AssertionError ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(StreamCopier.class, ex);
        }
    }
    
    public void testConstructorThrowsAssertionError1() throws Throwable {
        try {
            new StreamCopier(null, new ByteArrayOutputStream(), true);
            fail("Expected AssertionError to be thrown");
        } catch (AssertionError ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(StreamCopier.class, ex);
        }
    }
    
    public void testShutdownThrowsIllegalArgumentException() throws Throwable {
        byte[] bytes = new byte[1];
        StreamCopier streamCopier = new StreamCopier(new ByteArrayInputStream(bytes), new ByteArrayOutputStream(), true);
        try {
            streamCopier.shutdown(-1);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            
        }
    }
}

