package com.xagitarlabs.crap4j;

import java.io.IOException;
import java.util.List;

import com.agitar.org.objectweb.asm.tree.analysis.AnalyzerException;

public interface ComplexityReader {

	public List<MethodComplexity> readMethodComplexities() throws IOException, AnalyzerException;


}
