/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Nov 6, 2007 1:37:06 PM
 * Time to generate: 00:23.454 seconds
 *
 */

package org.crap4j.crap4jeclipse.preferences;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import org.crap4j.crap4jeclipse.Activator;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializerAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return PreferenceInitializer.class;
    }
    
    public void testConstructor() throws Throwable {
        new PreferenceInitializer();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testInitializeDefaultPreferences() throws Throwable {
        storeStaticField(Activator.class, "plugin");
        PreferenceInitializer preferenceInitializer = new PreferenceInitializer();
        Activator activator = (Activator) Mockingbird.getProxyObject(Activator.class);
        IPreferenceStore iPreferenceStore = (IPreferenceStore) Mockingbird.getProxyObject(IPreferenceStore.class);
        setPrivateField(Activator.class, "plugin", activator);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(activator.getPreferenceStore(), iPreferenceStore);
        iPreferenceStore.setDefault("crapThreshold", 30);
        Mockingbird.setNormalReturnForVoid();
        iPreferenceStore.setDefault("crapPercentCriticalThreshold", 5);
        Mockingbird.setNormalReturnForVoid();
        iPreferenceStore.setDefault("crapPercentWarningThreshold", 5);
        Mockingbird.setNormalReturnForVoid();
        iPreferenceStore.setDefault("downloadAverages", true);
        Mockingbird.setNormalReturnForVoid();
        iPreferenceStore.setDefault("server", "http://www.crap4j.org/benchmark/");
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(PreferenceInitializer.class);
        preferenceInitializer.initializeDefaultPreferences();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testInitializeDefaultPreferencesThrowsNullPointerException() throws Throwable {
        try {
            new PreferenceInitializer().initializeDefaultPreferences();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(PreferenceInitializer.class, ex);
        }
    }
}
