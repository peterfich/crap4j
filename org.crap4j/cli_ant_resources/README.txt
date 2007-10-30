Welcome to crap4j, the tool that tells you if your project is in trouble.
Specify the location of classes and tests for your project and get a report.

LAUNCHING
=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
Launch crap4j with the batch or shell file, depending on your operating system. 

Or, add a crap4j ant task to your ant build file, then you can reference your 
existing project definitions. Alternatively, you can use a tool that exports an ant file 
from your IDE to make this easier, then add the taskdef and target for running crap4j.
See Ant Configuration below for details.

CONFIGURATION FOR A PROJECT
=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
You must provide parameters that specify where the parts of your project reside on disk.
Optionally, you can specify a non-default place for the report to be saved.
You have two options for providing this information. You can pass parameters to the command 
line or you can specify a configuration file.

FILE-BASED CONFIGURATION
=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
The configuration file is probably the easiest to manage. You can see an example in 
doc/projectConfig.sample.

Launch the script and pass the location of the file. For example,

	crap4j.sh -f /pathTo/myConfigFile
	
says run crap4j with the configuration in '/pathTo/myconfigFile'. To use
debug mode, add -debug after specifying the configuration file. 

COMMAND LINE PARAMETERS
=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
There are 7 parameters. You can always get a reminder by running the script with no parameters 
to see the usage message.

 -p  path  Project root directory
 -c  paths Project class directories separated by path char
 -l  paths Project classpath separated by path char. You do not need to add the class or test directories again.
 -s  paths Project source directories separated by path char
 -t  paths Project test directories separated by path char
 -o  path  Output directory where reports will be stored. This defaults 
           to <projectDir>/agitar/reports/crap4j

 -debug    This is for development purposes and just dumps more output to the console. 
           As a boolean, it takes no arg. Always specify -debug on the command line.

 -dontTest This turns off running of the tests. This is useful if you have already run the tests,
 			because the tool will still read any coverage files in <proejctDir>/agitar/.results.
 			As a boolean, it takes no arg. Always specify -dontTest on the command line.
 
 or, as specified in the example above, you can launch it with a config file
 
 -f  Config_File_with_project_directories

Copy the projectConfig.sample in the doc directory and modify it for your project. 
 
This is an example of invoking the script with command-line parameters:
   
   crap4j.sh -p /Users/bobevans/Documents/projects/MDTWorkspace/crap4j -s src -c bin -t test_bin:agitar/test_bin
   
This example would run crap4j on itself if you have the src distribution. NOTE: paths that are not specified with a starting slash will be made relative to the project root, to save some typing.   

 Ant Configuration
 =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
 If you would like to use ant to run crap4j, you need to do 2 things. 
 (See doc/example_build.xml for a copyable example.)
 
 1) Add the taskdef code to your ant file so that it can find the crap4j ant task.
 
 <!-- Define the Crap4j task -->
	<taskdef name="crap4j" classname="com.xagitarlabs.crap4j.anttask.Crap4jAntTask" >
		<classpath>
			<fileset dir="${CRAP4J_HOME}/lib">
				<include name="**/*.jar" />
			</fileset>
		</classpath>
	</taskdef>
	
	NOTE: this example requires you to pass -DCRAP4J_HOME=<crap4j_install_dir> as a param or put it in a build.properties file.
	
	2) Add the target for launching the crap4j task.
	
	<!-- Use crap4j on the project -->
	<target name="run-crap4j">
		<crap4j projectdir="${project.dir.crap4j}" outputDir="agitar/reports/crap4j" dontTest="true" debug="false">
			<classDirs>
				<pathElement location="${project.dir.crap4j}/bin" />
			</classDirs>
			<srcDirs>
				<pathElement location="${project.dir.crap4j}/src" />
			</srcDirs>
			<testClassDirs>
				<pathElement location="${project.dir.crap4j}/test_bin" />
				<pathElement location="${project.dir.crap4j}/integration_tests_bin" />
				<pathElement location="${project.dir.crap4j}/agitar/test_bin" />
			</testClassDirs>
			<libClasspath>
				<fileset dir="${project.dir.crap4j}/dist/crap4j/lib">
					<include name="**/*.jar" />
				</fileset>
			</libClasspath>
		</crap4j>
	</target>

NOTE: this has all the same properties as the shell script. 
It has the added benefit that paths can be specified in handy Ant idioms. You can use filesets and 
pathElements, as well as paths with refids. This is particularly useful if you use Eclipse's export 
ant file feature, as it creates the classpath as a referrable path element.


