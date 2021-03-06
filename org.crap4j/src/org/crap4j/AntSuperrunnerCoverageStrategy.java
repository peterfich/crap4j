package org.crap4j;

import java.io.IOException;

import org.crap4j.external.AntBuilder;
import org.crap4j.external.AntRunner;
import org.crap4j.util.FileUtil;

public class AntSuperrunnerCoverageStrategy implements CoverageGeneratorStrategy {

  private Main main;

  public AntSuperrunnerCoverageStrategy(Main main) {
    this.main = main;
  }

  public void execute(Crap4jRunner runner, CrapProject crapProject, boolean debug) {
    try {
      FileUtil.ensureCleanDirectory(crapProject.getCoverageDir());
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      return;
    }
    AntBuilder antBuilder = new AntBuilder(main.agitatorEclipseCoveragePluginDir,
                                           main.agitatorEclipseApiPluginDir);
    String antFile = antBuilder.buildFileForProject(crapProject);
    AntRunner antRunner = new AntRunner(antFile, 
                                        main.antHome, 
                                        main.junitLib,
                                        main.agitatorEclipseApiPluginDir, 
                                        debug);
    
    try {
    	antRunner.run();
      runner.readResults(crapProject);
    } catch (Throwable t) {
      // TODO Auto-generated catch block
      t.printStackTrace();
    } 

  }
}
