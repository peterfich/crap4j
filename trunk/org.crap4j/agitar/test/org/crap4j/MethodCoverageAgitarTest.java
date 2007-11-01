/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 12:01:59 AM
 * Time to generate: 00:17.277 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;

public class MethodCoverageAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MethodCoverage.class;
    }
    
    public void testConstructor() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        assertEquals("methodCoverage.getCoverage()", 100.0F, methodCoverage.getCoverage(), 1.0E-6F);
        assertEquals("methodCoverage.matchingMethodSignature", "testMethodCoverageParam1", methodCoverage.matchingMethodSignature);
    }
    
    public void testCompareTo() throws Throwable {
        int result = new MethodCoverage("testMethodCoverageParam1", 100.0F).compareTo(new MethodCoverage("testMethodCoverageParam11", 1000.0F));
        assertEquals("result", -1, result);
    }
    
    public void testCompareTo1() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        int result = methodCoverage.compareTo(methodCoverage);
        assertEquals("result", 0, result);
    }
    
    public void testEquals() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testString", 0.0F);
        boolean result = methodCoverage.equals(new MethodCoverage("testString", 0.0F));
        assertTrue("result", result);
    }
    
    public void testEquals1() throws Throwable {
        boolean result = new MethodCoverage("testMethodCoverageParam1", 100.0F).equals(new Integer(0));
        assertFalse("result", result);
    }
    
    public void testEquals2() throws Throwable {
        boolean result = new MethodCoverage("testMethodCoverageParam1", 100.0F).equals(new MethodCoverage("testMethodCoverageParam11", 1000.0F));
        assertFalse("result", result);
    }
    
    public void testEquals3() throws Throwable {
        boolean result = new MethodCoverage("testMethodCoverageParam1", 100.0F).equals(null);
        assertFalse("result", result);
    }
    
    public void testGetCoverage() throws Throwable {
        float result = new MethodCoverage("testMethodCoverageParam1", 0.0F).getCoverage();
        assertEquals("result", 0.0F, result, 1.0E-6F);
    }
    
    public void testGetCoverage1() throws Throwable {
        float result = new MethodCoverage("testMethodCoverageParam1", 100.0F).getCoverage();
        assertEquals("result", 100.0F, result, 1.0E-6F);
    }
    
    public void testHashCode() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        int result = methodCoverage.hashCode();
        assertEquals("result", 1802553407, result);
        assertEquals("methodCoverage.matchingMethodSignature", "testMethodCoverageParam1", methodCoverage.matchingMethodSignature);
    }
    
    public void testHashCode1() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("", 0.0F);
        int result = methodCoverage.hashCode();
        assertEquals("result", 0, result);
        assertEquals("methodCoverage.matchingMethodSignature", "", methodCoverage.matchingMethodSignature);
    }
    
    public void testIsInvalidComparable() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageMethodSignature1", 1000.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.MethodCoverage", "isInvalidComparable", new Class[] {Object.class}, methodCoverage, new Object[] {new MethodCoverage("testMethodCoverageMethodSignature", 100.0F)})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsInvalidComparable1() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageMethodSignature", 100.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.MethodCoverage", "isInvalidComparable", new Class[] {Object.class}, methodCoverage, new Object[] {null})).booleanValue();
        assertTrue("result", result);
    }
    
    public void testPrettyMethodSignature() throws Throwable {
        String result = new MethodCoverage("testMethodCoverageParam1", 100.0F).prettyMethodSignature();
        assertEquals("result", "Implement This, or don't call IT!! -- When done refactoring, make it abstract", result);
    }
    
    public void testToString() throws Throwable {
        String result = new MethodCoverage("testMethodCoverageParam1", 100.0F).toString();
        assertEquals("result", "testMethodCoverageParam1 : 100.0", result);
    }
    
    public void testCompareToThrowsClassCastException() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        try {
            methodCoverage.compareTo("testString");
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException ex) {
            assertEquals("ex.getClass()", ClassCastException.class, ex.getClass());
            assertThrownBy(MethodCoverage.class, ex);
            assertEquals("methodCoverage.matchingMethodSignature", "testMethodCoverageParam1", methodCoverage.matchingMethodSignature);
        }
    }
    
    public void testCompareToThrowsNullPointerException() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        try {
            methodCoverage.compareTo(new MethodCoverage(null, 1000.0F));
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(String.class, ex);
            assertEquals("methodCoverage.matchingMethodSignature", "testMethodCoverageParam1", methodCoverage.matchingMethodSignature);
        }
    }
    
    public void testCompareToThrowsNullPointerException1() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage("testMethodCoverageParam1", 100.0F);
        try {
            methodCoverage.compareTo(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodCoverage.class, ex);
            assertEquals("methodCoverage.matchingMethodSignature", "testMethodCoverageParam1", methodCoverage.matchingMethodSignature);
        }
    }
    
    public void testEqualsThrowsNullPointerException() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage(null, 100.0F);
        try {
            methodCoverage.equals(new MethodCoverage("testMethodCoverageMethodSignature", 1000.0F));
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodCoverage.class, ex);
            assertNull("methodCoverage.matchingMethodSignature", methodCoverage.matchingMethodSignature);
        }
    }
    
    public void testHashCodeThrowsNullPointerException() throws Throwable {
        MethodCoverage methodCoverage = new MethodCoverage(null, 100.0F);
        try {
            methodCoverage.hashCode();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodCoverage.class, ex);
            assertNull("methodCoverage.matchingMethodSignature", methodCoverage.matchingMethodSignature);
        }
    }
}

