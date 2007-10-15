package org.xagitarlabs.crap4jeclipse.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.junit.ITestRunListener;

public class TestRunListener implements ITestRunListener {

  
  private static List<Crap4jTestListenerListener> listeners = new ArrayList<Crap4jTestListenerListener>();

  public static void addListener(Crap4jTestListenerListener lis) {
    if (!listeners.contains(lis))
      listeners.add(lis);
  }
  
  public static void removeListener(Crap4jTestListenerListener lis) {
    listeners.remove(lis);
  }
  
  public void testEnded(String testId, String testName) {
  }

  public void testFailed(int status, String testId, String testName,
      String trace) {
  }

  public void testReran(String testId, String testClass, String testName,
      int status, String trace) {
  }

  public void testRunEnded(long elapsedTime) {
    finished();
  }

  public void testRunStarted(int testCount) {
  }

  public void testRunStopped(long elapsedTime) {
    cancelled();
  }

  public void testRunTerminated() {
    cancelled();
  }

  public void testStarted(String testId, String testName) {
  }

  private void finished() {
    for (Crap4jTestListenerListener lis : getCopyOfListeners()) {
      lis.finished();
    }
    
  }

  private List<Crap4jTestListenerListener> getCopyOfListeners() {
    List<Crap4jTestListenerListener> list = new ArrayList<Crap4jTestListenerListener>(listeners.size());
    for (Crap4jTestListenerListener listener : listeners) {
      list.add(listener);
    }
    return list;
  }

  private void cancelled() {
    for (Crap4jTestListenerListener lis : getCopyOfListeners()) {
      lis.cancelled();
    }
  }

}
