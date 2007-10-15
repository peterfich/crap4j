package org.crap4j.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.crap4j.util.FileUtil;


import junit.framework.TestCase;

public class FileUtilTestCase extends TestCase {

	String tmpDirName = "testFileUtil";
	String[] filenames = {"Bar.class", "barFoo.class", "Foo.class"};
	private String tmpDir;

	@Override
	protected void setUp() throws Exception {
		System.setProperty("java.io.tmpDir", "tmpDir");
		tmpDir = FileUtil.getSubTmpDir(tmpDirName);
		for (String filename : filenames) {
			createFile(filename);
		}
		
	}

	private void createFile(String filename) throws IOException {
		File f = new File(tmpDir, filename);
		f.createNewFile();
	}
	
	@Override
	protected void tearDown() throws Exception {
		FileUtil.eraseFile(tmpDirName);
	}
	
	public void testPatternMatchForFilenames() throws Exception {
		String regex = "^Foo.class";
		List<File> matchingFiles = FileUtil.getAllFilesInDirMatchingPattern(tmpDir, regex, false);
		assertEquals(1, matchingFiles.size());
	}

}
