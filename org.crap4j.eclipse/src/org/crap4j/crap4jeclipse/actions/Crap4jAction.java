package org.crap4j.crap4jeclipse.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.crap4j.Crap4jRunner;
import org.crap4j.CrapProject;
import org.crap4j.crap4jeclipse.Activator;
import org.crap4j.crap4jeclipse.Crap4jEclipseLog;
import org.crap4j.crap4jeclipse.preferences.PreferenceConstants;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;

import org.objectweb.asm.tree.analysis.AnalyzerException;


/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class Crap4jAction implements IWorkbenchWindowActionDelegate, IObjectActionDelegate {
	private IWorkbenchWindow window;
  private ISelection selection;
  
  
  public Crap4jAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
    if (selection == null)
      return;
//    ISelection selection = ((WWinPluginAction)action).getSelection();
//    if (selection instanceof IStructuredSelection) {
      ArrayList<IJavaProject> openProjects = getOpenSelectedProjects(selection);
      if (openProjects.size() > 0) {
//        displayMsgAboutOpenProjects(openProjects);
        runCrap4jOnProject(openProjects, selection);
      }
	}

  private void runCrap4jOnProject(ArrayList<IJavaProject> openProjects, ISelection selection) {
    // TODO RBE get from a preferences pane.
    String outputDir = null;
    boolean debug = false;
    boolean dontTest = false;
    IJavaProject[] javaProjects = new IJavaProject[openProjects.size()];
    openProjects.toArray(javaProjects);
    
    IJavaProject firstProject = javaProjects[0];
    
    EclipseCrapProjectBuilder ecpb = new EclipseCrapProjectBuilder(firstProject, outputDir);
    EclipseSuperRunnerCoverageStrategy eclipseCovStrategy = new EclipseSuperRunnerCoverageStrategy(selection);
    Preferences pluginPreferences = Activator.getDefault().getPluginPreferences();
    int crapThreshold = (int) pluginPreferences.getFloat(PreferenceConstants.CRAP_THRESHOLD);
    float crapPercentWarningThreshold = pluginPreferences.getFloat(PreferenceConstants.CRAP_PERCENT_WARNING_THRESHOLD)/ 100.0f;
    float crapPercentCriticalThreshold = pluginPreferences.getFloat(PreferenceConstants.CRAP_PERCENT_CRITICAL_THRESHOLD)/ 100.0f;
    boolean downloadAverages = pluginPreferences.getBoolean(PreferenceConstants.DOWNLOAD_AVERAGES);
    String server = pluginPreferences.getString(PreferenceConstants.SERVER);
    Crap4jRunner runner = new Crap4jRunner(debug, 
                                          dontTest, 
                                          downloadAverages,          
                                          eclipseCovStrategy, 
                                          crapThreshold, 
                                          crapPercentWarningThreshold, 
                                          crapPercentCriticalThreshold, 
                                          server);
    try {
      runJob(runner, ecpb.getCrapProject());
    } catch (Throwable t) {
      Crap4jEclipseLog.logError("Crap4j Error on project: "+firstProject.getPath(),t);
    }
//    Job job = new  Crap4jJob(runner, ecpb.getCrapProject());
//    job.schedule();
  }

  class Crap4jJob extends Job {
    private Crap4jRunner runner;
    private CrapProject project;
    public Crap4jJob(Crap4jRunner runner, CrapProject project) {
      super("Crap4j Job");
      this.runner = runner;
      this.project = project;
    }
    @Override
    protected IStatus run(IProgressMonitor monitor) {
      monitor.beginTask("Crap4j running tests", 1);
      try {
        runJob(runner, project);
        monitor.worked(1);
        monitor.done();
        return Status.OK_STATUS;
      } catch (Exception e) {
        e.printStackTrace();
      }       
      return Status.OK_STATUS;
    }
  }

  private void runJob(Crap4jRunner runner, final CrapProject project) throws Exception /* Evil eclipse plugin builds arrghh  IOException, AnalyzerException, PartInitException, MalformedURLException*/ {
    runner.doProject(project);
  }


  private ArrayList<IJavaProject> getOpenSelectedProjects(ISelection selection) {
    IStructuredSelection structuredSelection = (IStructuredSelection)selection;
    Object[] array= structuredSelection.toArray();
    ArrayList<IJavaProject> openProjects= new ArrayList<IJavaProject>();
    for (int i= 0; i < array.length; i++) {
      Object curr = array[i];
      if (curr instanceof IJavaProject && ((IJavaProject)curr).getProject().isOpen()) {
        openProjects.add((IJavaProject) curr);
      } else if (curr instanceof IWorkingSet) {
        evaluateSelection(((IWorkingSet) curr).getElements(), openProjects);
      }
    }
    return openProjects;
  }

//  private void displayMsgAboutOpenProjects(ArrayList<IJavaProject> openProjects) {
//    StringBuilder buf = new StringBuilder();
//    for (IJavaProject project : openProjects) {
//      buf.append(project.getElementName());
//    }
//    String openProjectsList = buf.toString();
//    MessageDialog.openInformation(
//        window.getShell(),
//        "Crap4jEclipse Plug-in",
//        "Running Crap4j on "+openProjectsList);
//  }
//
	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
//    if (selection instanceof IStructuredSelection && getOpenSelectedProjects(selection).size() > 0) {
	  
      this.selection = selection;
      //enable
//      action.setEnabled(true);
//    } else {
//      this.selection = null;
//      action.setEnabled(false);
//    }
    
	}

//  protected void performSelectionChanged(IStructuredSelection structuredSelection) {
//    Object[] array= structuredSelection.toArray();
//    ArrayList openProjects= new ArrayList();
//    evaluateSelection(array, openProjects);
//  }
  
  private void evaluateSelection(Object[] array, List<IJavaProject> allOpenProjects) {
    for (int i= 0; i < array.length; i++) {
      Object curr= array[i];
      if (curr instanceof IJavaProject) {
//        curr= ((IJavaProject) curr).getProject();
        IJavaProject project= (IJavaProject) curr;
        if (project.isOpen()) {
          allOpenProjects.add(project);
        } 
      } else if (curr instanceof IWorkingSet) {
          evaluateSelection(((IWorkingSet) curr).getElements(), allOpenProjects);
      }
    }
  }
	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}