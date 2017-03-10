package com.andi.alquran;

import android.annotation.SuppressLint;
import android.app.backup.BackupManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.ListAdapter;
import com.andi.alquran.p023e.C0903b;
import com.andi.alquran.p023e.C0903b.C0748c;
import com.andi.alquran.p023e.C0903b.C0750d;
import com.andi.alquran.p023e.C0903b.C0816b;
import com.andi.alquran.p023e.C0903b.C0902a;
import com.andi.alquran.p023e.C0904c;
import com.andi.alquran.p023e.C0905d;
import com.andi.alquran.p023e.C0906e;
import com.andi.alquran.p024a.C0871d;
import com.andi.alquran.p031i.C0924c;
import com.andi.alquran.p031i.C0927d;
import com.andi.alquran.p031i.C0930g;
import java.io.File;

public class ActivitySettingV10 extends PreferenceActivity implements OnSharedPreferenceChangeListener, OnPreferenceChangeListener, OnPreferenceClickListener {
    C0903b f1432a;
    C0750d f1433b;
    C0816b f1434c;
    private Preference f1435d;
    private Preference f1436e;
    private Preference f1437f;
    private Preference f1438g;
    private Preference f1439h;
    private Preference f1440i;
    private Preference f1441j;
    private Preference f1442k;
    private CheckBoxPreference f1443l;
    private ListPreference f1444m;
    private ListPreference f1445n;
    private SharedPreferences f1446o;

    /* renamed from: com.andi.alquran.ActivitySettingV10.11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ String f1420a;
        final /* synthetic */ ActivitySettingV10 f1421b;

        AnonymousClass11(ActivitySettingV10 activitySettingV10, String str) {
            this.f1421b = activitySettingV10;
            this.f1420a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1421b.m2841d(this.f1420a);
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.1 */
    class C08191 implements C0748c {
        final /* synthetic */ ActivitySettingV10 f1422a;

        C08191(ActivitySettingV10 activitySettingV10) {
            this.f1422a = activitySettingV10;
        }

        public void m2823a(C0904c c0904c) {
            if (c0904c.m3139b() && this.f1422a.f1432a != null) {
                try {
                    this.f1422a.f1432a.m3127a(this.f1422a.f1433b);
                } catch (C0902a e) {
                    e.getMessage();
                }
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.2 */
    class C08202 implements C0750d {
        final /* synthetic */ ActivitySettingV10 f1423a;

        C08202(ActivitySettingV10 activitySettingV10) {
            this.f1423a = activitySettingV10;
        }

        public void m2824a(C0904c c0904c, C0905d c0905d) {
            if (this.f1423a.f1432a != null && !c0904c.m3140c()) {
                C0906e a = c0905d.m3141a("donation_removeads");
                Editor edit = this.f1423a.f1446o.edit();
                if (a == null || !this.f1423a.m2832a(a)) {
                    edit.putBoolean("translationText", false);
                } else {
                    edit.putBoolean("translationText", true);
                }
                edit.apply();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.3 */
    class C08213 implements C0816b {
        final /* synthetic */ ActivitySettingV10 f1424a;

        C08213(ActivitySettingV10 activitySettingV10) {
            this.f1424a = activitySettingV10;
        }

        public void m2825a(C0904c c0904c, C0906e c0906e) {
            if (this.f1424a.f1432a != null && !c0904c.m3140c() && this.f1424a.m2832a(c0906e) && c0906e.m3146b().equals("donation_removeads")) {
                Editor edit = this.f1424a.f1446o.edit();
                edit.putBoolean("translationText", true);
                edit.apply();
                this.f1424a.m2836b(this.f1424a.getString(C0861R.string.infaq_thank_you));
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.4 */
    class C08224 implements OnClickListener {
        final /* synthetic */ ActivitySettingV10 f1425a;

        C08224(ActivitySettingV10 activitySettingV10) {
            this.f1425a = activitySettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f1425a.m2843e();
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.5 */
    class C08235 implements OnClickListener {
        final /* synthetic */ String f1426a;
        final /* synthetic */ ActivitySettingV10 f1427b;

        C08235(ActivitySettingV10 activitySettingV10, String str) {
            this.f1427b = activitySettingV10;
            this.f1426a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1427b.f1446o.edit();
            edit.putString("themeSelected", BuildConfig.VERSION_NAME + this.f1426a);
            edit.apply();
            Intent launchIntentForPackage = this.f1427b.getBaseContext().getPackageManager().getLaunchIntentForPackage(BuildConfig.APPLICATION_ID);
            this.f1427b.overridePendingTransition(0, 0);
            launchIntentForPackage.addFlags(67108864);
            this.f1427b.finish();
            this.f1427b.overridePendingTransition(0, 0);
            this.f1427b.startActivity(launchIntentForPackage);
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.6 */
    class C08246 implements OnClickListener {
        final /* synthetic */ ActivitySettingV10 f1428a;

        C08246(ActivitySettingV10 activitySettingV10) {
            this.f1428a = activitySettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.andi.alquran.id"));
            this.f1428a.startActivity(intent);
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.7 */
    class C08257 implements OnClickListener {
        final /* synthetic */ ActivitySettingV10 f1429a;

        C08257(ActivitySettingV10 activitySettingV10) {
            this.f1429a = activitySettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1429a.m2833b();
            } else {
                this.f1429a.m2837c();
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.8 */
    class C08268 implements OnClickListener {
        final /* synthetic */ ActivitySettingV10 f1430a;

        C08268(ActivitySettingV10 activitySettingV10) {
            this.f1430a = activitySettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!App.m2881f()) {
                App.m2871b(this.f1430a.getString(C0861R.string.check_not_online));
            } else if (i == 0) {
                if (VERSION.SDK_INT >= 11) {
                    new C0924c(this.f1430a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new C0924c(this.f1430a).execute(new Void[0]);
                }
            } else if (VERSION.SDK_INT >= 11) {
                new C0927d(this.f1430a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new C0927d(this.f1430a).execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySettingV10.9 */
    class C08279 implements OnClickListener {
        final /* synthetic */ ActivitySettingV10 f1431a;

        C08279(ActivitySettingV10 activitySettingV10) {
            this.f1431a = activitySettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1431a.m2828a();
        }
    }

    public ActivitySettingV10() {
        this.f1432a = null;
        this.f1433b = new C08202(this);
        this.f1434c = new C08213(this);
    }

    private int m2826a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    private void m2828a() {
        try {
            this.f1432a.m3124a(this, "donation_removeads", 10001, this.f1434c, "andigambon");
        } catch (C0902a e) {
            m2830a(getString(C0861R.string.infaq_error_async_another));
        } catch (IllegalStateException e2) {
            m2830a(getString(C0861R.string.infaq_error_google_play));
        }
    }

    private void m2830a(String str) {
        Builder builder = new Builder(this);
        builder.setTitle(getString(C0861R.string.infaq_error));
        builder.setIcon((int) C0861R.drawable.ic_black_warning);
        builder.setMessage((CharSequence) str);
        builder.setNeutralButton(getString(C0861R.string.close), null);
        builder.create().show();
    }

    private boolean m2832a(C0906e c0906e) {
        return c0906e.m3147c().equals("andigambon");
    }

    private void m2833b() {
        String j = App.m2885j();
        File file = new File(j);
        if (App.m2884i().equals(j + File.separator + "QuranMurottal")) {
            App.m2865a(getResources().getString(C0861R.string.msg_same_path));
        } else if (file.canWrite()) {
            m2841d(j);
        } else {
            App.m2865a(getResources().getString(C0861R.string.msg_notwritable_change_path));
        }
    }

    private void m2836b(String str) {
        OnClickListener c08224 = new C08224(this);
        Builder builder = new Builder(this);
        builder.setMessage((CharSequence) str);
        builder.setNeutralButton(getString(C0861R.string.close), c08224);
        builder.create().show();
    }

    private void m2837c() {
        String k = App.m2886k();
        File file = new File(k);
        if (App.m2884i().equals(k + File.separator + "QuranMurottal")) {
            App.m2865a(getResources().getString(C0861R.string.msg_same_path));
        } else if (file.canWrite()) {
            m2839c(k);
        } else {
            App.m2865a(getResources().getString(C0861R.string.msg_notwritable_change_path));
        }
    }

    private void m2839c(String str) {
        new Builder(this).setCancelable(false).setIcon((int) C0861R.drawable.ic_black_warning).setTitle(getString(C0861R.string.sdcard_warning_title)).setMessage(getString(C0861R.string.sdcard_warning_movetosdcard2_desc)).setPositiveButton((int) C0861R.string.sdcard_warning_accept, new AnonymousClass11(this, str)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    @SuppressLint({"InlinedApi"})
    private void m2841d(String str) {
        File file = new File(App.m2884i());
        int a = (int) App.m2859a(file);
        int e = App.m2877e(str);
        if (!file.exists()) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
            edit.putString("mp3Directory", str + File.separator + "QuranMurottal");
            edit.apply();
        } else if (e <= a) {
            new Builder(this).setCancelable(true).setIcon((int) C0861R.drawable.ic_black_warning).setTitle(getString(C0861R.string.sdcard_warning_size_title)).setMessage(getString(C0861R.string.sdcard_warning_size_desc, new Object[]{Integer.valueOf(a), Integer.valueOf(e)})).setNegativeButton((int) C0861R.string.close, null).show();
        } else if (VERSION.SDK_INT >= 11) {
            new C0930g(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new C0930g(this, str).execute(new Void[0]);
        }
    }

    private boolean m2842d() {
        return getSharedPreferences("murattal_audio_by_andi", 0).getBoolean("multiDownloadIsRunning", false);
    }

    private void m2843e() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.setFlags(67108864);
        intent.addFlags(65536);
        overridePendingTransition(0, 0);
        finish();
        startActivity(intent);
    }

    private void m2845e(String str) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            if (str.equals("mp3Directory")) {
                findPreference.setSummary(App.m2884i());
            }
            if (str.equals("qoriSelected")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeQori)[m2826a(this.f1446o, "qoriSelected", 2) - 1]);
            }
            if (str.equals("typeArabic")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeArabic)[m2826a(this.f1446o, "typeArabic", 0)]);
            }
            if (str.equals("fontSizeArabic")) {
                findPreference.setSummary(this.f1446o.getString("fontSizeArabic", "18") + " px");
            }
            if (str.equals("fontSizeLatin")) {
                findPreference.setSummary(this.f1446o.getString("fontSizeLatin", "18") + " px");
            }
            if (str.equals("fontSizeTranslation")) {
                findPreference.setSummary(this.f1446o.getString("fontSizeTranslation", "18") + " px");
            }
            if (str.equals("translationType")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeTranslation)[m2826a(this.f1446o, "translationType", 1) - 1]);
            }
            if (str.equals("latinType")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeLatin)[App.m2858a(this.f1446o, "latinType", 1) - 1]);
            }
            if (str.equals("themeSelected")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeTheme)[App.m2858a(this.f1446o, "themeSelected", 1) - 1]);
            }
            if (str.equals("actionAya")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeActionAya)[App.m2858a(this.f1446o, "actionAya", 1) - 1]);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f1432a != null && !this.f1432a.m3131a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        App app = (App) getApplication();
        app.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (app.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        addPreferencesFromResource(C0861R.xml.settings);
        this.f1446o = PreferenceManager.getDefaultSharedPreferences(this);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        this.f1435d = preferenceScreen.findPreference("aboutMe");
        this.f1435d.setOnPreferenceClickListener(this);
        this.f1436e = preferenceScreen.findPreference("shareApp");
        this.f1436e.setOnPreferenceClickListener(this);
        this.f1437f = preferenceScreen.findPreference("rateApp");
        this.f1437f.setOnPreferenceClickListener(this);
        this.f1438g = preferenceScreen.findPreference("otherApp");
        this.f1438g.setOnPreferenceClickListener(this);
        this.f1439h = preferenceScreen.findPreference("mp3Directory");
        this.f1439h.setOnPreferenceClickListener(this);
        this.f1440i = preferenceScreen.findPreference("audioManager");
        this.f1440i.setOnPreferenceClickListener(this);
        this.f1441j = preferenceScreen.findPreference("checkUpdate");
        this.f1441j.setOnPreferenceClickListener(this);
        this.f1442k = preferenceScreen.findPreference("upgradeToPro");
        this.f1442k.setOnPreferenceClickListener(this);
        this.f1443l = (CheckBoxPreference) preferenceScreen.findPreference("fullScreen");
        this.f1443l.setOnPreferenceChangeListener(this);
        this.f1444m = (ListPreference) preferenceScreen.findPreference("qoriSelected");
        this.f1444m.setOnPreferenceChangeListener(this);
        this.f1445n = (ListPreference) preferenceScreen.findPreference("themeSelected");
        this.f1445n.setOnPreferenceChangeListener(this);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("wordByWord");
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu")) {
            ((PreferenceGroup) findPreference("categoryTranslation")).removePreference(checkBoxPreference);
        }
        if (BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) || BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu")) {
            ((PreferenceGroup) findPreference("categoryLatin")).removePreference((ListPreference) findPreference("latinType"));
        }
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais")) {
            ((PreferenceGroup) findPreference("categoryTranslation")).removePreference((ListPreference) findPreference("translationType"));
        }
        if (App.m2885j().equals(BuildConfig.VERSION_NAME) || App.m2886k().equals(BuildConfig.VERSION_NAME)) {
            ((PreferenceGroup) findPreference("categoryAudio")).removePreference(this.f1439h);
        }
        this.f1446o = PreferenceManager.getDefaultSharedPreferences(this);
        this.f1432a = new C0903b(this, App.m2898w());
        this.f1432a.m3129a(false);
        this.f1432a.m3126a(new C08191(this));
        if (App.m2897v()) {
            ((PreferenceGroup) findPreference("categoryInfo")).removePreference(this.f1442k);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1432a != null) {
            this.f1432a.m3132b();
            this.f1432a = null;
        }
    }

    protected void onPause() {
        super.onPause();
        BackupManager.dataChanged(App.f1447a);
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        m2845e("mp3Directory");
        m2845e("qoriSelected");
        m2845e("typeArabic");
        m2845e("fontSizeArabic");
        m2845e("fontSizeLatin");
        m2845e("fontSizeTranslation");
        m2845e("translationType");
        m2845e("latinType");
        m2845e("themeSelected");
        m2845e("actionAya");
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (preference == this.f1443l) {
            m2843e();
            return true;
        } else if (preference != this.f1444m) {
            if (preference == this.f1445n) {
                int a = App.m2858a(this.f1446o, "themeSelected", 1);
                String valueOf = String.valueOf((String) obj);
                if (Integer.parseInt(valueOf) != a) {
                    new Builder(this).setCancelable(false).setMessage(getString(C0861R.string.msg_dialog_change_theme)).setPositiveButton((int) C0861R.string.ok, new C08235(this, valueOf)).setNegativeButton((int) C0861R.string.cancel, null).show();
                }
            }
            return false;
        } else if (!m2842d()) {
            return true;
        } else {
            App.m2865a(getString(C0861R.string.msg_download_qori_alert_multi_is_running));
            return false;
        }
    }

    public boolean onPreferenceClick(Preference preference) {
        int i = 0;
        if (preference == this.f1435d) {
            startActivity(new Intent(this, ActivityInfoApp.class));
            return true;
        } else if (preference == this.f1436e) {
            r0 = new Intent("android.intent.action.SEND");
            r0.setType("text/plain");
            String string = getString(C0861R.string.msg_share_app_desc);
            r0.putExtra("android.intent.extra.SUBJECT", getString(C0861R.string.msg_share_app_title));
            r0.putExtra("android.intent.extra.TEXT", string);
            startActivity(Intent.createChooser(r0, getResources().getString(C0861R.string.share_with)));
            return true;
        } else if (preference == this.f1437f) {
            new Builder(this).setIcon((int) C0861R.drawable.ic_black_rateapp).setCancelable(true).setTitle(getString(C0861R.string.button_beri_rating) + "!").setMessage(getString(C0861R.string.msg_give_rating)).setPositiveButton((int) C0861R.string.next, new C08246(this)).setNegativeButton((int) C0861R.string.cancel, null).show();
            return true;
        } else if (preference == this.f1438g) {
            r0 = new Intent("android.intent.action.VIEW");
            r0.setData(Uri.parse("market://search?q=pub:Andi Unpam"));
            startActivity(r0);
            return true;
        } else if (preference == this.f1439h) {
            if (App.m2885j().equals(BuildConfig.VERSION_NAME) && App.m2886k().equals(BuildConfig.VERSION_NAME)) {
                return true;
            }
            String[] strArr = new String[]{getString(C0861R.string.sdcard_internal_label), getString(C0861R.string.sdcard_external_label)};
            r3 = new String[2];
            r3[0] = getString(C0861R.string.sdcard_internal_sum, new Object[]{App.m2885j(), Integer.valueOf(App.m2875d(App.m2885j()))});
            r3[1] = getString(C0861R.string.sdcard_external_sum, new Object[]{App.m2886k(), Integer.valueOf(App.m2875d(App.m2886k()))});
            if (App.m2884i().equals(App.m2886k() + File.separator + "QuranMurottal")) {
                i = 1;
            }
            ListAdapter c0871d = new C0871d(this, strArr, r3, i);
            r0 = new Builder(this);
            r0.setTitle(getString(C0861R.string.sdcard_choose));
            r0.setNegativeButton(getString(C0861R.string.cancel), null);
            r0.setAdapter(c0871d, new C08257(this));
            r0.create();
            r0.show();
            return true;
        } else if (preference == this.f1440i) {
            startActivity(new Intent(this, ActivityAudioManager.class));
            return true;
        } else if (preference == this.f1441j) {
            CharSequence[] charSequenceArr = new CharSequence[]{getString(C0861R.string.choose_check_app), getString(C0861R.string.choose_check_content)};
            r0 = new Builder(this);
            r0.setIcon((int) C0861R.drawable.ic_black_action_checkupdate);
            r0.setTitle(getString(C0861R.string.choose_check_title));
            r0.setItems(charSequenceArr, new C08268(this));
            r0.create().show();
            return true;
        } else if (preference != this.f1442k) {
            return false;
        } else {
            r0 = new Builder(this);
            r0.setIcon((int) C0861R.drawable.ic_black_action_about);
            View webView = new WebView(this);
            r0.setTitle(getResources().getString(C0861R.string.infaq_alert_title));
            webView.loadUrl("file:///android_asset/about_donasi.html");
            r0.setView(webView);
            r0.setPositiveButton(getResources().getString(C0861R.string.next), new C08279(this));
            r0.setNegativeButton(getResources().getString(C0861R.string.cancel), new OnClickListener() {
                final /* synthetic */ ActivitySettingV10 f1419a;

                {
                    this.f1419a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            r0.show();
            return true;
        }
    }

    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        m2845e("mp3Directory");
        m2845e("qoriSelected");
        m2845e("typeArabic");
        m2845e("fontSizeArabic");
        m2845e("fontSizeLatin");
        m2845e("fontSizeTranslation");
        m2845e("translationType");
        m2845e("latinType");
        m2845e("themeSelected");
        m2845e("actionAya");
        Editor edit = getSharedPreferences("murattal_audio_by_andi", 0).edit();
        edit.putBoolean("multiDownloadIsRunning", false);
        edit.apply();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m2845e(str);
    }
}
