package com.xagitarlabs.crap4j;

public interface CoverageGeneratorStrategy {

  public void execute(Crap4jRunner runner, CrapProject crapProject, boolean debug);

}