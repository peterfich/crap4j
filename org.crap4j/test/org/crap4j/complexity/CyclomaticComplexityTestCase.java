package org.crap4j.complexity;

import java.io.File;
import java.util.List;

import org.crap4j.MethodComplexity;
import org.crap4j.MethodInfo;
import org.crap4j.complexity.CyclomaticComplexity;


import junit.framework.TestCase;

public class CyclomaticComplexityTestCase extends TestCase {

	
	public void testComplexity() throws Exception {
		String file = getClass().getClassLoader().getResource("org/crap4j/complexity/ComplexitySubject1TestFixture.class").getFile();
		File classFile = new File(file);
		CyclomaticComplexity cc = new CyclomaticComplexity();
		List<MethodComplexity> complexities = cc.getMethodComplexitiesFor(classFile);
		for (MethodInfo complexity: complexities) {
			System.out.println(complexity);
		}
	}
}
