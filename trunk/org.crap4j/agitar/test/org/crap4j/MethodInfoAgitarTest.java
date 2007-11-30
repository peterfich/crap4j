/**
 * Generated by Agitar build: JUnitFactory Version 2.1.1.000614 (Build date: Nov 19, 2007) [2.1.1.000614]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 27, 2007 4:09:42 PM
 * Time to generate: 00:17.094 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;

public class MethodInfoAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MethodInfo.class;
    }
    
    public void testCompareTo() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        int result = methodComplexity.compareTo(methodComplexity);
        assertEquals("result", 0, result);
    }
    
    public void testCompareTo1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        MethodInfo methodComplexity2 = new MethodComplexity("testMethodInfoParam11", "testMethodInfoParam21", "testMethodInfoParam31", "testMethodInfoParam41", "testMethodInfoParam51", 1000, "testMethodInfoParam71");
        int result = methodComplexity2.compareTo(methodComplexity);
        assertEquals("result", 3, result);
    }
    
    public void testGetMatchingMethodSignature() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        String result = methodComplexity.getMatchingMethodSignature();
        assertEquals("result", "testMethodInfoParam2.testMethodInfoParam3testMethodInfoParam4", result);
    }
    
    public void testCompareToThrowsClassCastException() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        try {
            methodComplexity.compareTo(new Float(0.0F));
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException ex) {
            assertEquals("ex.getClass()", ClassCastException.class, ex.getClass());
            assertThrownBy(MethodInfo.class, ex);
            assertEquals("(MethodComplexity) methodComplexity.matchingMethodSignature", "testMethodInfoParam2.testMethodInfoParam3testMethodInfoParam4", ((MethodComplexity) methodComplexity).matchingMethodSignature);
        }
    }
    
    public void testCompareToThrowsNullPointerException() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        try {
            methodComplexity.compareTo(new MethodCoverage(null, 100.0F));
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(String.class, ex);
            assertEquals("(MethodComplexity) methodComplexity.matchingMethodSignature", "testMethodInfoParam2.testMethodInfoParam3testMethodInfoParam4", ((MethodComplexity) methodComplexity).matchingMethodSignature);
        }
    }
    
    public void testCompareToThrowsNullPointerException1() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        try {
            methodComplexity.compareTo(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodInfo.class, ex);
            assertEquals("(MethodComplexity) methodComplexity.matchingMethodSignature", "testMethodInfoParam2.testMethodInfoParam3testMethodInfoParam4", ((MethodComplexity) methodComplexity).matchingMethodSignature);
        }
    }
}
