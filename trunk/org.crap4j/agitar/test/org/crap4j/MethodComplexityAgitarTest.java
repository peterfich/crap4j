/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 1, 2007 12:01:15 AM
 * Time to generate: 00:19.306 seconds
 *
 */

package org.crap4j;

import com.agitar.lib.junit.AgitarTestCase;

public class MethodComplexityAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MethodComplexity.class;
    }
    
    public void testConstructor() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", ".", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        assertEquals("methodComplexity.getMethodName()", "testMethodComplexityParam3", methodComplexity.getMethodName());
        assertEquals("methodComplexity.getClassName()", ".", methodComplexity.getClassName());
        assertEquals("methodComplexity.getJava5Signature()", "testMethodComplexityParam5", methodComplexity.getJava5Signature());
        assertEquals("methodComplexity.getPackageName()", "", methodComplexity.getPackageName());
        assertEquals("methodComplexity.pkgclassName", ".", getPrivateField(methodComplexity, "pkgclassName"));
        assertEquals("methodComplexity.getMethodDescriptor()", "testMethodComplexityParam4", methodComplexity.getMethodDescriptor());
        assertEquals("methodComplexity.prettyMethodSignature()", "testMethodComplexityParam7", methodComplexity.prettyMethodSignature());
        assertEquals("methodComplexity.matchingMethodSignature", "..testMethodComplexityParam3testMethodComplexityParam4", methodComplexity.matchingMethodSignature);
        assertEquals("methodComplexity.getComplexity()", 100, methodComplexity.getComplexity());
    }
    
    public void testConstructor1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        assertEquals("methodComplexity.getMethodName()", "testMethodComplexityParam3", methodComplexity.getMethodName());
        assertEquals("methodComplexity.getClassName()", "testMethodComplexityParam2", methodComplexity.getClassName());
        assertEquals("methodComplexity.getJava5Signature()", "testMethodComplexityParam5", methodComplexity.getJava5Signature());
        assertEquals("methodComplexity.getPackageName()", "", methodComplexity.getPackageName());
        assertEquals("methodComplexity.pkgclassName", "testMethodComplexityParam2", getPrivateField(methodComplexity, "pkgclassName"));
        assertEquals("methodComplexity.getMethodDescriptor()", "testMethodComplexityParam4", methodComplexity.getMethodDescriptor());
        assertEquals("methodComplexity.prettyMethodSignature()", "testMethodComplexityParam7", methodComplexity.prettyMethodSignature());
        assertEquals("methodComplexity.matchingMethodSignature", "testMethodComplexityParam2.testMethodComplexityParam3testMethodComplexityParam4", methodComplexity.matchingMethodSignature);
        assertEquals("methodComplexity.getComplexity()", 100, methodComplexity.getComplexity());
    }
    
    public void testConstructor2() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "{.", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        assertEquals("methodComplexity.getMethodName()", "testMethodComplexityParam3", methodComplexity.getMethodName());
        assertEquals("methodComplexity.getClassName()", "", methodComplexity.getClassName());
        assertEquals("methodComplexity.getJava5Signature()", "testMethodComplexityParam5", methodComplexity.getJava5Signature());
        assertEquals("methodComplexity.getPackageName()", "{", methodComplexity.getPackageName());
        assertEquals("methodComplexity.pkgclassName", "{.", getPrivateField(methodComplexity, "pkgclassName"));
        assertEquals("methodComplexity.getMethodDescriptor()", "testMethodComplexityParam4", methodComplexity.getMethodDescriptor());
        assertEquals("methodComplexity.prettyMethodSignature()", "testMethodComplexityParam7", methodComplexity.prettyMethodSignature());
        assertEquals("methodComplexity.matchingMethodSignature", "{..testMethodComplexityParam3testMethodComplexityParam4", methodComplexity.matchingMethodSignature);
        assertEquals("methodComplexity.getComplexity()", 100, methodComplexity.getComplexity());
    }
    
    public void testGetClassName() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getClassName();
        assertEquals("result", "testMethodComplexityParam2", result);
    }
    
    public void testGetComplexity() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        int result = methodComplexity.getComplexity();
        assertEquals("result", 100, result);
    }
    
    public void testGetComplexity1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 0, "testMethodComplexityParam7");
        int result = methodComplexity.getComplexity();
        assertEquals("result", 0, result);
    }
    
    public void testGetJava5Signature() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getJava5Signature();
        assertEquals("result", "testMethodComplexityParam5", result);
    }
    
    public void testGetMethodDescriptor() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getMethodDescriptor();
        assertEquals("result", "testMethodComplexityParam4", result);
    }
    
    public void testGetMethodName() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getMethodName();
        assertEquals("result", "testMethodComplexityParam3", result);
    }
    
    public void testGetPackageName() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getPackageName();
        assertEquals("result", "", result);
    }
    
    public void testGetSigOrDescriptor() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", " ", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getSigOrDescriptor();
        assertEquals("result", " ", result);
    }
    
    public void testGetSigOrDescriptor1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "", 100, "testMethodComplexityParam7");
        String result = methodComplexity.getSigOrDescriptor();
        assertEquals("result", "testMethodComplexityParam4", result);
    }
    
    public void testGetSigOrDescriptor2() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", null, 100, "testMethodComplexityParam7");
        String result = methodComplexity.getSigOrDescriptor();
        assertEquals("result", "testMethodComplexityParam4", result);
    }
    
    public void testMakeClassName() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityMethodSignature", "testMethodComplexityPkgclassName", "testMethodComplexityMethodName", "testMethodComplexityMethodDescriptor", "testMethodComplexityJava5Signature", 100, "testMethodComplexityPrettyMethodSignature");
        String result = (String) callPrivateMethod("org.crap4j.MethodComplexity", "makeClassName", new Class[] {}, methodComplexity, new Object[] {});
        assertEquals("result", "testMethodComplexityPkgclassName", result);
    }
    
    public void testMakeClassName1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityMethodSignature", "E\f7\n_j.{|{4:v", "testMethodComplexityMethodName", "testMethodComplexityMethodDescriptor", "testMethodComplexityJava5Signature", 100, "testMethodComplexityPrettyMethodSignature");
        String result = (String) callPrivateMethod("org.crap4j.MethodComplexity", "makeClassName", new Class[] {}, methodComplexity, new Object[] {});
        assertEquals("result", "{|{4:v", result);
    }
    
    public void testMakePackageName() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityMethodSignature", "testMethodComplexityPkgclassName", "testMethodComplexityMethodName", "testMethodComplexityMethodDescriptor", "testMethodComplexityJava5Signature", 100, "testMethodComplexityPrettyMethodSignature");
        String result = (String) callPrivateMethod("org.crap4j.MethodComplexity", "makePackageName", new Class[] {}, methodComplexity, new Object[] {});
        assertEquals("result", "", result);
    }
    
    public void testMakePackageName1() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityMethodSignature", ".", "testMethodComplexityMethodName", "testMethodComplexityMethodDescriptor", "testMethodComplexityJava5Signature", 100, "testMethodComplexityPrettyMethodSignature");
        String result = (String) callPrivateMethod("org.crap4j.MethodComplexity", "makePackageName", new Class[] {}, methodComplexity, new Object[] {});
        assertEquals("result", "", result);
    }
    
    public void testPrettyMethodSignature() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.prettyMethodSignature();
        assertEquals("result", "testMethodComplexityParam7", result);
    }
    
    public void testToString() throws Throwable {
        MethodComplexity methodComplexity = new MethodComplexity("testMethodComplexityParam1", "testMethodComplexityParam2", "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
        String result = methodComplexity.toString();
        assertEquals("result", "testMethodComplexityParam2.testMethodComplexityParam3testMethodComplexityParam4 : 100", result);
    }
    
    public void testConstructorThrowsNullPointerException() throws Throwable {
        try {
            new MethodComplexity("testMethodComplexityParam1", null, "testMethodComplexityParam3", "testMethodComplexityParam4", "testMethodComplexityParam5", 100, "testMethodComplexityParam7");
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MethodComplexity.class, ex);
        }
    }
}

