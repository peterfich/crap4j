package org.crap4j;

import java.io.FilePermission;

import com.agitar.lib.SetupHelper;
import com.agitar.lib.junit.AgitarTestUtility;

public class PermissionsSetupHelper implements SetupHelper {

  public void setUpConcreteMocks() {
    // TODO Auto-generated method stub
    

  }

  public void setUpTestCase() throws Exception {
    addOSXJavaReadPermission();
  }

  private void addOSXJavaReadPermission() {
    AgitarTestUtility.addPermission(new FilePermission("/System/Library/Frameworks/JavaVM.framework/Versions/1.5.0/Classes/classes.jar", 
        "read"));
  }

  public void setUpTestGeneration() throws Exception {
    addOSXJavaReadPermission();

  }

  public void tearDownTestCase() throws Exception {
    // TODO Auto-generated method stub

  }

  public void tearDownTestGeneration() throws Exception {
    // TODO Auto-generated method stub

  }

}
