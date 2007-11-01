/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 12:00:32 AM
 * Time to generate: 00:17.838 seconds
 *
 */

package org.crap4j.complexity;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.lang.reflect.Array;
import java.util.Set;

public class MyAnalyzerAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MyAnalyzer.class;
    }
    
    public void testConstructor() throws Throwable {
        new MyAnalyzer();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testNewControlFlowEdgeWithAggressiveMocks() throws Throwable {
        MyAnalyzer myAnalyzer = (MyAnalyzer) Mockingbird.getProxyObject(MyAnalyzer.class, true);
        Object[] instance = (Object[]) Array.newInstance(Class.forName("com.agitar.org.objectweb.asm.tree.analysis.Frame"), new int[] {1});
        Node node = (Node) Mockingbird.getProxyObject(Node.class);
        Set set = (Set) Mockingbird.getProxyObject(Set.class);
        setPrivateField(myAnalyzer, "frames", instance);
        Array.set(instance, 0, node);
        node.successors = set;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, set, "add", "(java.lang.Object)boolean", Boolean.FALSE, 1);
        Mockingbird.enterTestMode(MyAnalyzer.class);
        myAnalyzer.newControlFlowEdge(0, 0);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testNewControlFlowEdgeWithAggressiveMocks1() throws Throwable {
        MyAnalyzer myAnalyzer = (MyAnalyzer) Mockingbird.getProxyObject(MyAnalyzer.class, true);
        Object[] instance = (Object[]) Array.newInstance(Class.forName("com.agitar.org.objectweb.asm.tree.analysis.Frame"), new int[] {2});
        Node node = (Node) Mockingbird.getProxyObject(Node.class);
        Set set = (Set) Mockingbird.getProxyObject(Set.class);
        setPrivateField(myAnalyzer, "frames", instance);
        Array.set(instance, 1, node);
        Array.set(instance, 0, null);
        node.successors = set;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, set, "add", "(java.lang.Object)boolean", Boolean.FALSE, 1);
        Mockingbird.enterTestMode(MyAnalyzer.class);
        myAnalyzer.newControlFlowEdge(1, 0);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testNewFrame() throws Throwable {
        MyAnalyzer myAnalyzer = new MyAnalyzer();
        Node result = (Node) myAnalyzer.newFrame(100, 1000);
        assertNotNull("result", result);
    }
    
    public void testNewControlFlowEdgeThrowsNullPointerException() throws Throwable {
        MyAnalyzer myAnalyzer = new MyAnalyzer();
        try {
            myAnalyzer.newControlFlowEdge(100, 1000);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MyAnalyzer.class, ex);
        }
    }
    
    public void testNewFrameThrowsNegativeArraySizeException() throws Throwable {
        MyAnalyzer myAnalyzer = new MyAnalyzer();
        try {
            myAnalyzer.newFrame(100, -166);
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
        }
    }
    
    public void testNewFrameThrowsNullPointerException() throws Throwable {
        MyAnalyzer myAnalyzer = new MyAnalyzer();
        try {
            callPrivateMethod("org.crap4j.complexity.MyAnalyzer", "newFrame", new Class[] {Class.forName("com.agitar.org.objectweb.asm.tree.analysis.Frame")}, myAnalyzer, new Object[] {null});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
        }
    }
}

