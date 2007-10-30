set DEFAULT_CRAP4J_HOME=%~dp0

set CRAP4j_PARAMS=%1
if ""%1""=="""" goto runCommand
shift
:loop
if ""%1""=="""" goto runCommand
set CRAP4j_PARAMS=%CRAP4j_PARAMS% %1
shift
goto loop


:runCommand
rem echo %CRAP4j_PARAMS%
java -cp "%DEFAULT_CRAP4J_HOME%lib\crap4j.jar;%DEFAULT_CRAP4J_HOME%lib\args4j-2.0.1.jar;%DEFAULT_CRAP4J_HOME%lib\asm-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\asm-tree-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\asm-analysis-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\asm-commons-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\asm-util-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\asm-xml-3.0.jar;%DEFAULT_CRAP4J_HOME%lib\com.agitar.eclipse.coverage_4.2.0.401405\com.agitar.coverage.jar" com.xagitarlabs.crap4j.Main %CRAP4j_PARAMS%

