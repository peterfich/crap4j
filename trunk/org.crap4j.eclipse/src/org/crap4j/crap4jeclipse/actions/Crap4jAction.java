package org.crap4j.crap4jeclipse.actions;

import java.util.ArrayList;
import java.util.List;

import org.crap4j.Crap4jRunner;
import org.crap4j.CrapProject;
import org.crap4j.crap4jeclipse.Activator;
import org.crap4j.crap4jeclipse.Crap4jEclipseLog;
import org.crap4j.crap4jeclipse.preferences.PreferenceConstants;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.progress.IProgressConstants;


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
    if (selection == null) {
      MessageDialog.openError(window.getShell(), "No Open Project", "The project you selected is not open. Please open it to run Crap4j.");
      return;
    } else {
//    ISelection selection = ((WWinPluginAction)action).getSelection();
//    if (selection instanceof IStructuredSelection) {
      ArrayList<IJavaProject> openProjects = getOpenSelectedProjects(selection);
      if (openProjects.size() > 0) {
//        if (displayMsgAboutOpenProjects(openProjects)) {
          runCrap4jOnProject(openProjects, selection);
//        }
      }
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
//      runJob(runner, ecpb.getCrapProject());
    } catch (Throwable t) {
      Crap4jEclipseLog.logError("Crap4j Error on project: "+firstProject.getPath(),t);
      MessageDialog.openError(window.getShell(), "Could not run Crap4j", "the crap4j run could not complete. Please check the Error Log for messages.");
    }
    Crap4jJob job = new  Crap4jJob(runner, ecpb.getCrapProject());
    job.setUser(true);
    job.schedule();
  }

  class Crap4jJob extends WorkspaceJob {
    private Crap4jRunner runner;
    private CrapProject project;
    public Crap4jJob(Crap4jRunner runner, CrapProject project) {
      super("Crap4j Job");
      this.runner = runner;
      this.project = project;
    }

    @Override
    public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
      monitor.beginTask("Crap4j running tests", 1);
      try {
        runner.doProject(project);
        monitor.worked(1);
        monitor.done();
        
        if (isModal(this)) {
          // The progress dialog is still open so
          // just open the message
//          showResults();
       } else {
//         setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
//         setProperty(IProgressConstants.ACTION_PROPERTY, getReservationCompletedAction());
       }
        return Status.OK_STATUS;
      } catch (Exception e) {
        e.printStackTrace();
      }       
      return Status.OK_STATUS;
    }
    protected Action getReservationCompletedAction() {
      return new Action("View reservation status") {
        public void run() {
          MessageDialog.openInformation(Display.getCurrent().getActiveShell(), 
                    "Reservation Complete", 
                    "Your reservation has been completed");
        }
      };
    }
    protected void showResults() {
      Display.getDefault().asyncExec(new Runnable() {
         public void run() {
            getReservationCompletedAction().run();
         }
      });
   }



    public boolean isModal(WorkspaceJob job) {
      Boolean isModal = (Boolean)job.getProperty(
                             IProgressConstants.PROPERTY_IN_DIALOG);
      if(isModal == null) return false;
      return isModal.booleanValue();
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

  private boolean displayMsgAboutOpenProjects(ArrayList<IJavaProject> openProjects) {
    StringBuilder buf = new StringBuilder();
    
    for (IJavaProject project : openProjects) {
      buf.append(project.getElementName());
    }
    String openProjectsList = buf.toString();
    return (MessageDialog.openConfirm(
        window.getShell(),
        "Crap4jEclipse Plug-in",
        "Running Crap4j on project, "+openProjectsList+".\n\n" +
        		"First, any tests that can be found, will be run in the junit runner.\n" +
        		"Finally, a browser will popup with your report when it is done."));
  }

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