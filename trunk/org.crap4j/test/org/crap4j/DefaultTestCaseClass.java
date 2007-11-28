package org.crap4j;

import junit.framework.TestCase;

public class DefaultTestCaseClass extends TestCase {

  public DefaultTestCaseClass(String name) {
    super(name);
  }

  public void testNothing() throws Exception {
    assert(true);
  }
}
