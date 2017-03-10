package com.andi.alquran;

import android.annotation.TargetApi;
import android.app.backup.BackupManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager.LayoutParams;
import com.andi.alquran.p023e.C0903b;
import com.andi.alquran.p023e.C0903b.C0748c;
import com.andi.alquran.p023e.C0903b.C0750d;
import com.andi.alquran.p023e.C0903b.C0816b;
import com.andi.alquran.p023e.C0903b.C0902a;
import com.andi.alquran.p023e.C0904c;
import com.andi.alquran.p023e.C0905d;
import com.andi.alquran.p023e.C0906e;

@TargetApi(11)
public class ActivitySetting extends AppCompatActivity {
    C0903b f1415a;
    C0750d f1416b;
    C0816b f1417c;
    private SharedPreferences f1418d;

    /* renamed from: com.andi.alquran.ActivitySetting.1 */
    class C08141 implements C0748c {
        final /* synthetic */ ActivitySetting f1411a;

        C08141(ActivitySetting activitySetting) {
            this.f1411a = activitySetting;
        }

        public void m2811a(C0904c c0904c) {
            if (c0904c.m3139b() && this.f1411a.f1415a != null) {
                try {
                    this.f1411a.f1415a.m3127a(this.f1411a.f1416b);
                } catch (C0902a e) {
                    e.getMessage();
                }
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySetting.2 */
    class C08152 implements C0750d {
        final /* synthetic */ ActivitySetting f1412a;

        C08152(ActivitySetting activitySetting) {
            this.f1412a = activitySetting;
        }

        public void m2812a(C0904c c0904c, C0905d c0905d) {
            if (this.f1412a.f1415a != null && !c0904c.m3140c()) {
                C0906e a = c0905d.m3141a("donation_removeads");
                Editor edit = this.f1412a.f1418d.edit();
                if (a == null || !this.f1412a.m2819a(a)) {
                    edit.putBoolean("translationText", false);
                } else {
                    edit.putBoolean("translationText", true);
                }
                edit.apply();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySetting.3 */
    class C08173 implements C0816b {
        final /* synthetic */ ActivitySetting f1413a;

        C08173(ActivitySetting activitySetting) {
            this.f1413a = activitySetting;
        }

        public void m2814a(C0904c c0904c, C0906e c0906e) {
            if (this.f1413a.f1415a != null && !c0904c.m3140c() && this.f1413a.m2819a(c0906e) && c0906e.m3146b().equals("donation_removeads")) {
                Editor edit = this.f1413a.f1418d.edit();
                edit.putBoolean("translationText", true);
                edit.apply();
                this.f1413a.m2820b(this.f1413a.getString(C0861R.string.infaq_thank_you));
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySetting.4 */
    class C08184 implements OnClickListener {
        final /* synthetic */ ActivitySetting f1414a;

        C08184(ActivitySetting activitySetting) {
            this.f1414a = activitySetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f1414a.m2822b();
        }
    }

    public ActivitySetting() {
        this.f1415a = null;
        this.f1416b = new C08152(this);
        this.f1417c = new C08173(this);
    }

    private void m2817a(String str) {
        Builder builder = new Builder(this);
        builder.setTitle(getString(C0861R.string.infaq_error));
        builder.setIcon((int) C0861R.drawable.ic_black_warning);
        builder.setMessage((CharSequence) str);
        builder.setNeutralButton(getString(C0861R.string.close), null);
        builder.create().show();
    }

    private boolean m2819a(C0906e c0906e) {
        return c0906e.m3147c().equals("andigambon");
    }

    private void m2820b(String str) {
        OnClickListener c08184 = new C08184(this);
        Builder builder = new Builder(this);
        builder.setMessage((CharSequence) str);
        builder.setNeutralButton(getString(C0861R.string.close), c08184);
        builder.create().show();
    }

    public void m2821a() {
        try {
            this.f1415a.m3124a(this, "donation_removeads", 10001, this.f1417c, "andigambon");
        } catch (C0902a e) {
            m2817a(getString(C0861R.string.infaq_error_async_another));
        } catch (IllegalStateException e2) {
            m2817a(getString(C0861R.string.infaq_error_google_play));
        }
    }

    public void m2822b() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.setFlags(67108864);
        intent.addFlags(65536);
        overridePendingTransition(0, 0);
        finish();
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f1415a != null && !this.f1415a.m3131a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_setting);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        App app = (App) getApplication();
        app.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (app.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        if (getFragmentManager().findFragmentById(C0861R.id.layoutSetting) == null) {
            getFragmentManager().beginTransaction().replace(C0861R.id.layoutSetting, new FragmentSetting()).commit();
        }
        this.f1418d = PreferenceManager.getDefaultSharedPreferences(this);
        this.f1415a = new C0903b(this, App.m2898w());
        this.f1415a.m3129a(false);
        this.f1415a.m3126a(new C08141(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1415a != null) {
            this.f1415a.m3132b();
            this.f1415a = null;
        }
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
