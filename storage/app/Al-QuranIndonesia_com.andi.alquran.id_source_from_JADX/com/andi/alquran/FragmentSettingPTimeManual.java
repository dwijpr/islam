package com.andi.alquran;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.ListView;

@TargetApi(11)
public class FragmentSettingPTimeManual extends PreferenceFragment {
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getView() != null) {
            ((ListView) getView().findViewById(16908298)).setDivider(null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName("prayer_time_by_andi");
        preferenceManager.setSharedPreferencesMode(0);
        addPreferencesFromResource(C0861R.xml.settings_ptime_manual);
    }
}
