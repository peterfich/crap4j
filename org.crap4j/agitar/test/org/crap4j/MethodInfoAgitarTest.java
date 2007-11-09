/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 12:01:09 AM
 * Time to generate: 00:17.194 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;
import java.util.ArrayList;

public class MethodInfoAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MethodInfo.class;
    }
    
    public void testCompareTo() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        MethodInfo methodComplexity2 = new MethodComplexity("testMethodInfoParam11", "testMethodInfoParam21", "testMethodInfoParam31", "testMethodInfoParam41", "testMethodInfoParam51", 1000, "testMethodInfoParam71");
        int result = methodComplexity2.compareTo(methodComplexity);
        assertEquals("result", 3, result);
    }
    
    public void testCompareTo1() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoParam1", "testMethodInfoParam2", "testMethodInfoParam3", "testMethodInfoParam4", "testMethodInfoParam5", 100, "testMethodInfoParam7");
        int result = methodComplexity.compareTo(methodComplexity);
        assertEquals("result", 0, result);
    }
    
    public void testGetMatchingMethodSignature() throws Throwable {
        String result = new MethodCoverage("testMethodInfoMethodSignature", 100.0F).getMatchingMethodSignature();
        assertEquals("result", "testMethodInfoMethodSignature", result);
    }
    
    public void testCompareToThrowsClassCastException() throws Throwable {
        ArrayList o = new ArrayList(100);
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoMethodSignature", "testMethodInfoPkgclassName", "testMethodInfoMethodName", "testMethodInfoMethodDescriptor", "testMethodInfoJava5Signature", 100, "testMethodInfoPrettyMethodSignature");
        try {
            methodComplexity.compareTo(o);
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException ex) {
            assertEquals("ex.getClass()", ClassCastException.class, ex.getClass());
            assertThrownBy(MethodInfo.class, ex);
            assertEquals("(MethodComplexity) methodComplexity.matchingMethodSignature", "testMethodInfoPkgclassName.testMethodInfoMethodNametestMethodInfoMethodDescriptor", ((MethodComplexity) methodComplexity).matchingMethodSignature);
        }
    }
    
    public void testCompareToThrowsNullPointerException() throws Throwable {
        MethodInfo methodComplexity = new MethodComplexity("testMethodInfoMethodSignature", "testMethodInfoPkgclassName", "testMethodInfoMethodName", "testMethodInfoMethodDescriptor", "testMethodInfoJava5Signature", 100, "testMethodInfoPrettyMethodSignature");
        try {
            methodComplexity.compareTo(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodInfo.class, ex);
            assertEquals("(MethodComplexity) methodComplexity.matchingMethodSignature", "testMethodInfoPkgclassName.testMethodInfoMethodNametestMethodInfoMethodDescriptor", ((MethodComplexity) methodComplexity).matchingMethodSignature);
        }
    }
}
