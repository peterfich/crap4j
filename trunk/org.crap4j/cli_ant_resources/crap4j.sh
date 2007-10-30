#!/bin/sh

DEFAULT_CRAP4J_HOME=`dirname "$0"`

echo "Default crap4j home is $DEFAULT_CRAP4J_HOME"

java -cp $DEFAULT_CRAP4J_HOME/lib/org.crap4j.jar:$DEFAULT_CRAP4J_HOME/lib/args4j-2.0.1.jar:$DEFAULT_CRAP4J_HOME/lib/asm-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/asm-tree-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/asm-analysis-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/asm-commons-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/asm-util-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/asm-xml-3.0.jar:$DEFAULT_CRAP4J_HOME/lib/com.agitar.eclipse.coverage_4.2.0.401405/com.agitar.coverage.jar org.crap4j.Main $@
