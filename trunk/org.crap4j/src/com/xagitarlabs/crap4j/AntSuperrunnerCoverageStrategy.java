package com.xagitarlabs.crap4j;

import java.io.IOException;

import com.agitar.org.objectweb.asm.tree.analysis.AnalyzerException;
import com.xagitarlabs.crap4j.external.AntBuilder;
import com.xagitarlabs.crap4j.external.AntRunner;
import com.xagitarlabs.crap4j.util.FileUtil;

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
    antRunner.run();
    try {
      runner.readResults(crapProject);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (AnalyzerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
