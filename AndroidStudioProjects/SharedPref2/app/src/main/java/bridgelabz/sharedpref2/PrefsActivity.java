package bridgelabz.sharedpref2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by bridgeit on 24/3/17.
 */
public class PrefsActivity  extends PreferenceActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.prefs);
    }
}
