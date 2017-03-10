package com.andi.alquran;

import android.app.backup.BackupManager;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;

public class ActivityPTimeSettingV10Manual extends PreferenceActivity {
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName("prayer_time_by_andi");
        preferenceManager.setSharedPreferencesMode(0);
        addPreferencesFromResource(C0861R.xml.settings_ptime_manual);
        App.f1448m.f1451c.m3063a(this);
        App app = (App) getApplication();
        app.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (app.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        ((ListView) getListView().findViewById(16908298)).setDivider(null);
    }

    protected void onPause() {
        super.onPause();
        BackupManager.dataChanged(App.f1447a);
    }
}
