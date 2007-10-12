package com.xagitarlabs.crap4jeclipse.actions;

import java.io.IOException;
import java.net.URL;

import org.crap4j.CoverageGeneratorStrategy;
import org.crap4j.Crap4jRunner;
import org.crap4j.CrapProject;
import org.crap4j.util.FileUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import com.agitar.eclipse.testrunner.RunJUnitTestsShortcut;

public class EclipseSuperRunnerCoverageStrategy implements
    CoverageGeneratorStrategy {

  // private IJavaProject[] ijavaProject;
  private ISelection selection;

  public EclipseSuperRunnerCoverageStrategy(ISelection selection) {
    super();
    this.selection = selection;
  }

  public void execute(final Crap4jRunner runner, final CrapProject crapProject, boolean debug) {
    try {
      FileUtil.ensureCleanDirectory(crapProject.getCoverageDir());
    } catch (IOException e1) {
      e1.printStackTrace();
      return;
    }

    if (FileUtil.hasTestClassFiles(crapProject.getAllProjectClasses())) { 
      RunJUnitTestsShortcut testrunner = new RunJUnitTestsShortcut();
      TestRunListener.addListener(new Crap4jTestListenerListener() {
        public void cancelled() {
          System.out.println("cancelled the test run.");
          TestRunListener.removeListener(this);
        }
        public void finished() {
          finishComputingCrap(runner, crapProject);
          TestRunListener.removeListener(this);
        }
      });
      testrunner.launch(selection, "run");
    } else {
      finishComputingCrap(runner, crapProject);
    }
  }
  
  private void finishComputingCrap(final Crap4jRunner runner, final CrapProject crapProject) {
    Runnable runnable = new Runnable() {
      public void run() {
        try {
          runner.readResults(crapProject);
          openURL(crapProject.getReportHtmlFile().toURL());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    Display.getDefault().asyncExec(runnable);
  }

  private void openURL(URL url) throws PartInitException {
    if (false) {
      openURLInExternalBrowser(url);
    } else {
      openURLInInternalBrowser(url);
    }
  }

  private void openURLInInternalBrowser(URL url) throws PartInitException {
    IWorkbenchBrowserSupport support = PlatformUI.getWorkbench()
        .getBrowserSupport();
    int style = IWorkbenchBrowserSupport.AS_EDITOR
        | IWorkbenchBrowserSupport.STATUS;
    IWebBrowser browser = support.createBrowser(style, "org.eclipse.pde", //$NON-NLS-1$
        url.toString(), "Crap4j Report");
    browser.openURL(url);
  }

  private void openURLInExternalBrowser(URL url) throws PartInitException {
    IWorkbenchBrowserSupport support = PlatformUI.getWorkbench()
        .getBrowserSupport();
    IWebBrowser browser = support.getExternalBrowser();
    browser.openURL(url);
  }

}
