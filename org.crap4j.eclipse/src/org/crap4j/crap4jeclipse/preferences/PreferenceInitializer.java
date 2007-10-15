package org.crap4j.crap4jeclipse.preferences;

import org.crap4j.crap4jeclipse.Activator;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;



/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.CRAP_THRESHOLD, 30);
		store.setDefault(PreferenceConstants.CRAP_PERCENT_CRITICAL_THRESHOLD, 15);
		store.setDefault(PreferenceConstants.CRAP_PERCENT_WARNING_THRESHOLD, 5);
	}

}
