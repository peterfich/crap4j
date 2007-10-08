package com.xagitarlabs.crap4j;

import java.util.ArrayList;
import java.util.List;

import com.xagitarlabs.crap4j.MethodComplexity;
import com.xagitarlabs.crap4j.MethodCrap;
import com.xagitarlabs.crap4j.SystemCrapStats;

import junit.framework.TestCase;


public class SystemCrapStatsTest extends TestCase {

	
	public void testComputesCrapOverallWith1Value() throws Exception {
		float coverage = 0.0f;
		int complexity = 1;
		List<MethodCrap> methodValues = new ArrayList<MethodCrap>();
		methodValues.add(new MethodCrap(null, coverage, new MethodComplexity("foo", "bar", "baz", "biz", "buz", complexity, "foo()")));
		assertEquals(2.0, new SystemCrapStats(methodValues, null, null, 0f, 0f , 0f).getCrapNumber(), 0.001);
	}

	public void testComputesCrapOverallWith2Values() throws Exception {
		List<MethodCrap> methodValues = new ArrayList<MethodCrap>();
		methodValues.add(new MethodCrap(null, 0.0f, new MethodComplexity("foo", "bar", "baz", "biz", "buz", 1, "foo()")));
		methodValues.add(new MethodCrap(null, 0.0f, new MethodComplexity("foofoo", "bar", "baz", "biz", "buz", 1, "foo()")));
		assertEquals(2.0, new SystemCrapStats(methodValues, null, null, 0f, 0f , 0f).getCrapNumber(), 0.001);
	}

	public void testComputesCrapOverallWith2OppositeValues() throws Exception {
		List<MethodCrap> methodValues = new ArrayList<MethodCrap>();
		methodValues.add(new MethodCrap(null, 0.0f, new MethodComplexity("foo", "bar", "baz", "biz", "buz", 1, "foo()")));
		methodValues.add(new MethodCrap(null, 1.0f, new MethodComplexity("foofoo", "bar", "baz", "biz", "buz", 1, "foo()")));
		assertEquals(1.5, new SystemCrapStats(methodValues, null, null, 0f, 0f , 0f).getCrapNumber(), 0.001);
	}
}
