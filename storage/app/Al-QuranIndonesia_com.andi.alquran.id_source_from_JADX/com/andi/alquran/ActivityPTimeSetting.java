package com.andi.alquran;

import android.annotation.TargetApi;
import android.app.backup.BackupManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager.LayoutParams;
import com.andi.alquran.p027d.C0895b;

@TargetApi(11)
public class ActivityPTimeSetting extends AppCompatActivity {
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_setting_ptime);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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
        if (getFragmentManager().findFragmentById(C0861R.id.layoutSettingPTime) == null) {
            getFragmentManager().beginTransaction().replace(C0861R.id.layoutSettingPTime, new FragmentSettingPTime()).commit();
        }
    }

    protected void onDestroy() {
        C0895b.m3111b(this);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    protected void onPause() {
        super.onPause();
        BackupManager.dataChanged(App.f1447a);
    }
}
