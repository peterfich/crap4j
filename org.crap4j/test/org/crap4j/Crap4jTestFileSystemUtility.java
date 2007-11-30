package org.crap4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crap4j.util.FileUtil;

public class Crap4jTestFileSystemUtility {

  private ArrayList<String> dirsCreated;
  public static final List<String> emptySourceDirs = Collections.EMPTY_LIST;
  public static final List<String> emptyTestDirs = Collections.EMPTY_LIST;
  public static final List<String> emptyClassDirs = Collections.EMPTY_LIST;
  public static final List<String> emptyClasspath = Collections.EMPTY_LIST;

  public Crap4jTestFileSystemUtility() {
    dirsCreated = new ArrayList<String>();
  }
  
  public void removeDirsCreated() {
    for (String dir : dirsCreated) {
      File file = new File(dir);
      if (file.exists())
        FileUtil.deleteDirectory(file);
    }   
  }

  public String createTestFileSystem(String folderName) throws IOException {   
    return makeDir(getTempDir(), folderName);
  }

  private String makeDir(File rootDir, String projectName) throws IOException {
    File dir = new File(rootDir, projectName);
    if (dir.exists())
      FileUtil.deleteDirectory(dir);
    dir = new File(rootDir, projectName);
    dir.mkdirs();
    String dirStr = dir.getCanonicalPath();
    dirsCreated.add(dirStr);
    return dirStr;
  }
  
  public String makeDir(String rootDir, String name) throws IOException {
    return makeDir(new File(rootDir), name);
  }

  
  void copyClassToDir(String classDir2, String className) throws FileNotFoundException, IOException {
    BufferedOutputStream out = null;
    try {
      out = new BufferedOutputStream(new DataOutputStream(new FileOutputStream(new File(classDir2, className))));
      BufferedInputStream s = new BufferedInputStream(getClass().getResourceAsStream(className));
      byte[] b = new byte[1024];
      while (s.read(b) != -1) {
        out.write(b);
      }
    } finally {
      if (out != null)
        out.close();
    }
  }

  private String getTempDir() {
    String javaTmpDir = System.getProperty("java.io.tmpdir");
    if (javaTmpDir == null) {
      throw new IllegalArgumentException("Cannot get the tmp dir!!!");
    }
    return javaTmpDir;
  }

  public void addDefaultClassToDefaultPackage(String classDir2) throws Exception {
    copyClassToDir(classDir2, "DefaultClass.class");
  }

  public void addDefaultTestClassToDefaultPackage(String classDir2) throws Exception {
    copyClassToDir(classDir2, "DefaultTestCaseClass.class");
  }



  
  
}

