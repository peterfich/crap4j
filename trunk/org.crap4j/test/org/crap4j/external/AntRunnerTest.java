package org.crap4j.external;

import java.io.File;
import java.io.FileWriter;

import org.crap4j.Main;
import org.crap4j.external.AntRunner;
import org.crap4j.util.FileUtil;


import junit.framework.TestCase;

public class AntRunnerTest extends TestCase {

	private String tmpFile;

	@Override
	protected void setUp() throws Exception {
		tmpFile = getTmpAntFile();
		FileUtil.eraseFile(tmpFile);
		File f = new File(tmpFile);
		FileWriter fr = null;
		try {
			fr = new FileWriter(f);
			fr.write("<project name=\"test\" default=\"hi\">"+
					"<target name=\"hi\">"+
					"  <echo message=\"Hey there\"/>"+
					"</target>"+
					"</project>"
					);
		} finally {		
		  fr.close();
		}
	}

	private static String getTmpAntFile() {
		return FileUtil.getTmpFile("test_build.xml");
	}

	@Override
	protected void tearDown() throws Exception {
		if (tmpFile != null)
			FileUtil.eraseFile(tmpFile);
	}
	
	public void testExecution() throws Exception {
    String crap4jHome = Main.getCrap4jHome();
    String apiPluginDir = Main.getAgitatorEclipseApiPlugin(crap4jHome );
		String antHome = Main.getAntHome(apiPluginDir);
    String junitLib = Main.getJunitLib(apiPluginDir);
    
    AntRunner runner = new AntRunner(tmpFile, antHome, junitLib, apiPluginDir, false);
		assertEquals(0, runner.run());
	}
}
