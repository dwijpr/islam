package com.andi.alquran;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListAdapter;
import com.andi.alquran.p024a.C0871d;
import com.andi.alquran.p031i.C0924c;
import com.andi.alquran.p031i.C0927d;
import com.andi.alquran.p031i.C0930g;
import java.io.File;

@TargetApi(11)
public class FragmentSetting extends PreferenceFragment implements OnSharedPreferenceChangeListener, OnPreferenceChangeListener, OnPreferenceClickListener {
    private Preference f1542a;
    private Preference f1543b;
    private Preference f1544c;
    private Preference f1545d;
    private Preference f1546e;
    private Preference f1547f;
    private Preference f1548g;
    private Preference f1549h;
    private CheckBoxPreference f1550i;
    private ListPreference f1551j;
    private ListPreference f1552k;
    private SharedPreferences f1553l;

    /* renamed from: com.andi.alquran.FragmentSetting.1 */
    class C08431 implements OnClickListener {
        final /* synthetic */ String f1533a;
        final /* synthetic */ FragmentSetting f1534b;

        C08431(FragmentSetting fragmentSetting, String str) {
            this.f1534b = fragmentSetting;
            this.f1533a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1534b.f1553l.edit();
            edit.putString("themeSelected", BuildConfig.VERSION_NAME + this.f1533a);
            edit.apply();
            Intent launchIntentForPackage = this.f1534b.getActivity().getBaseContext().getPackageManager().getLaunchIntentForPackage(BuildConfig.APPLICATION_ID);
            this.f1534b.getActivity().overridePendingTransition(0, 0);
            launchIntentForPackage.addFlags(67108864);
            this.f1534b.getActivity().finish();
            this.f1534b.getActivity().overridePendingTransition(0, 0);
            this.f1534b.startActivity(launchIntentForPackage);
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.2 */
    class C08442 implements OnClickListener {
        final /* synthetic */ FragmentSetting f1535a;

        C08442(FragmentSetting fragmentSetting) {
            this.f1535a = fragmentSetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.andi.alquran.id"));
            this.f1535a.startActivity(intent);
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.3 */
    class C08453 implements OnClickListener {
        final /* synthetic */ FragmentSetting f1536a;

        C08453(FragmentSetting fragmentSetting) {
            this.f1536a = fragmentSetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1536a.m2977a();
            } else if (i == 1) {
                this.f1536a.m2980b();
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.4 */
    class C08464 implements OnClickListener {
        final /* synthetic */ FragmentSetting f1537a;

        C08464(FragmentSetting fragmentSetting) {
            this.f1537a = fragmentSetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!App.m2881f()) {
                App.m2871b(this.f1537a.getString(C0861R.string.check_not_online));
            } else if (i == 0) {
                if (VERSION.SDK_INT >= 11) {
                    new C0924c(this.f1537a.getActivity()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new C0924c(this.f1537a.getActivity()).execute(new Void[0]);
                }
            } else if (VERSION.SDK_INT >= 11) {
                new C0927d(this.f1537a.getActivity()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new C0927d(this.f1537a.getActivity()).execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.5 */
    class C08475 implements OnClickListener {
        final /* synthetic */ FragmentSetting f1538a;

        C08475(FragmentSetting fragmentSetting) {
            this.f1538a = fragmentSetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((ActivitySetting) this.f1538a.getActivity()).m2821a();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.6 */
    class C08486 implements OnClickListener {
        final /* synthetic */ FragmentSetting f1539a;

        C08486(FragmentSetting fragmentSetting) {
            this.f1539a = fragmentSetting;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSetting.7 */
    class C08497 implements OnClickListener {
        final /* synthetic */ String f1540a;
        final /* synthetic */ FragmentSetting f1541b;

        C08497(FragmentSetting fragmentSetting, String str) {
            this.f1541b = fragmentSetting;
            this.f1540a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1541b.m2982b(this.f1540a);
        }
    }

    private void m2977a() {
        String j = App.m2885j();
        File file = new File(j);
        if (App.m2884i().equals(j + File.separator + "QuranMurottal")) {
            App.m2865a(getResources().getString(C0861R.string.msg_same_path));
        } else if (file.canWrite()) {
            m2982b(j);
        } else {
            App.m2865a(getResources().getString(C0861R.string.msg_notwritable_change_path));
        }
    }

    private void m2979a(String str) {
        new Builder(getActivity()).setCancelable(false).setIcon((int) C0861R.drawable.ic_black_warning).setTitle(getString(C0861R.string.sdcard_warning_title)).setMessage(getString(C0861R.string.sdcard_warning_movetosdcard2_desc)).setPositiveButton((int) C0861R.string.sdcard_warning_accept, new C08497(this, str)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    private void m2980b() {
        String k = App.m2886k();
        File file = new File(k);
        if (App.m2884i().equals(k + File.separator + "QuranMurottal")) {
            App.m2865a(getResources().getString(C0861R.string.msg_same_path));
        } else if (file.canWrite()) {
            m2979a(k);
        } else {
            App.m2865a(getResources().getString(C0861R.string.msg_notwritable_change_path));
        }
    }

    @SuppressLint({"InlinedApi"})
    private void m2982b(String str) {
        File file = new File(App.m2884i());
        int a = (int) App.m2859a(file);
        int e = App.m2877e(str);
        if (!file.exists()) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
            edit.putString("mp3Directory", str + File.separator + "QuranMurottal");
            edit.apply();
        } else if (e <= a) {
            new Builder(getActivity()).setCancelable(true).setIcon((int) C0861R.drawable.ic_black_warning).setTitle(getString(C0861R.string.sdcard_warning_size_title)).setMessage(getString(C0861R.string.sdcard_warning_size_desc, new Object[]{Integer.valueOf(a), Integer.valueOf(e)})).setNegativeButton((int) C0861R.string.close, null).show();
        } else if (VERSION.SDK_INT >= 11) {
            new C0930g(getActivity(), str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new C0930g(getActivity(), str).execute(new Void[0]);
        }
    }

    private void m2984c(String str) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            if (str.equals("mp3Directory")) {
                findPreference.setSummary(App.m2884i());
            }
            if (str.equals("qoriSelected")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeQori)[App.m2858a(this.f1553l, "qoriSelected", 2) - 1]);
            }
            if (str.equals("typeArabic")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeArabic)[App.m2858a(this.f1553l, "typeArabic", 0)]);
            }
            if (str.equals("fontSizeArabic")) {
                findPreference.setSummary(this.f1553l.getString("fontSizeArabic", "18") + " px");
            }
            if (str.equals("fontSizeLatin")) {
                findPreference.setSummary(this.f1553l.getString("fontSizeLatin", "18") + " px");
            }
            if (str.equals("fontSizeTranslation")) {
                findPreference.setSummary(this.f1553l.getString("fontSizeTranslation", "18") + " px");
            }
            if (str.equals("translationType")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeTranslation)[App.m2858a(this.f1553l, "translationType", 1) - 1]);
            }
            if (str.equals("latinType")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeLatin)[App.m2858a(this.f1553l, "latinType", 1) - 1]);
            }
            if (str.equals("themeSelected")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeTheme)[App.m2858a(this.f1553l, "themeSelected", 1) - 1]);
            }
            if (str.equals("actionAya")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeActionAya)[App.m2858a(this.f1553l, "actionAya", 1) - 1]);
            }
        }
    }

    private boolean m2985c() {
        return getActivity().getSharedPreferences("murattal_audio_by_andi", 0).getBoolean("multiDownloadIsRunning", false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C0861R.xml.settings);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        this.f1542a = preferenceScreen.findPreference("aboutMe");
        this.f1542a.setOnPreferenceClickListener(this);
        this.f1543b = preferenceScreen.findPreference("shareApp");
        this.f1543b.setOnPreferenceClickListener(this);
        this.f1544c = preferenceScreen.findPreference("rateApp");
        this.f1544c.setOnPreferenceClickListener(this);
        this.f1545d = preferenceScreen.findPreference("otherApp");
        this.f1545d.setOnPreferenceClickListener(this);
        this.f1546e = preferenceScreen.findPreference("mp3Directory");
        this.f1546e.setOnPreferenceClickListener(this);
        this.f1547f = preferenceScreen.findPreference("audioManager");
        this.f1547f.setOnPreferenceClickListener(this);
        this.f1548g = preferenceScreen.findPreference("checkUpdate");
        this.f1548g.setOnPreferenceClickListener(this);
        this.f1549h = preferenceScreen.findPreference("upgradeToPro");
        this.f1549h.setOnPreferenceClickListener(this);
        this.f1550i = (CheckBoxPreference) preferenceScreen.findPreference("fullScreen");
        this.f1550i.setOnPreferenceChangeListener(this);
        this.f1551j = (ListPreference) preferenceScreen.findPreference("qoriSelected");
        this.f1551j.setOnPreferenceChangeListener(this);
        this.f1552k = (ListPreference) preferenceScreen.findPreference("themeSelected");
        this.f1552k.setOnPreferenceChangeListener(this);
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
            ((PreferenceGroup) findPreference("categoryAudio")).removePreference(this.f1546e);
        }
        if (App.m2897v()) {
            ((PreferenceGroup) findPreference("categoryInfo")).removePreference(this.f1549h);
        }
        this.f1553l = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        m2984c("mp3Directory");
        m2984c("qoriSelected");
        m2984c("typeArabic");
        m2984c("fontSizeArabic");
        m2984c("fontSizeLatin");
        m2984c("fontSizeTranslation");
        m2984c("translationType");
        m2984c("latinType");
        m2984c("themeSelected");
        m2984c("actionAya");
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (preference == this.f1550i) {
            ((ActivitySetting) getActivity()).m2822b();
            return true;
        } else if (preference == this.f1551j) {
            if (!m2985c()) {
                return true;
            }
            App.m2865a(getString(C0861R.string.msg_download_qori_alert_multi_is_running));
            return false;
        } else if (preference != this.f1552k) {
            return false;
        } else {
            int a = App.m2858a(this.f1553l, "themeSelected", 1);
            String valueOf = String.valueOf((String) obj);
            if (Integer.parseInt(valueOf) == a) {
                return false;
            }
            new Builder(getActivity()).setCancelable(false).setMessage(getString(C0861R.string.msg_dialog_change_theme)).setPositiveButton((int) C0861R.string.ok, new C08431(this, valueOf)).setNegativeButton((int) C0861R.string.cancel, null).show();
            return false;
        }
    }

    public boolean onPreferenceClick(Preference preference) {
        int i = 0;
        if (preference == this.f1542a) {
            startActivity(new Intent(getActivity(), ActivityInfoApp.class));
            return true;
        } else if (preference == this.f1543b) {
            r0 = new Intent("android.intent.action.SEND");
            r0.setType("text/plain");
            String string = getString(C0861R.string.msg_share_app_desc);
            r0.putExtra("android.intent.extra.SUBJECT", getString(C0861R.string.msg_share_app_title));
            r0.putExtra("android.intent.extra.TEXT", string);
            startActivity(Intent.createChooser(r0, getResources().getString(C0861R.string.share_with)));
            return true;
        } else if (preference == this.f1544c) {
            new Builder(getActivity()).setIcon((int) C0861R.drawable.ic_black_rateapp).setCancelable(true).setTitle(getString(C0861R.string.button_beri_rating) + "!").setMessage(getString(C0861R.string.msg_give_rating)).setPositiveButton((int) C0861R.string.next, new C08442(this)).setNegativeButton((int) C0861R.string.cancel, null).show();
            return true;
        } else if (preference == this.f1545d) {
            r0 = new Intent("android.intent.action.VIEW");
            r0.setData(Uri.parse("market://search?q=pub:Andi Unpam"));
            startActivity(r0);
            return true;
        } else if (preference == this.f1546e) {
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
            ListAdapter c0871d = new C0871d(getActivity(), strArr, r3, i);
            r0 = new Builder(getActivity());
            r0.setTitle(getString(C0861R.string.sdcard_choose));
            r0.setNegativeButton(getString(C0861R.string.cancel), null);
            r0.setAdapter(c0871d, new C08453(this));
            r0.create();
            r0.show();
            return true;
        } else if (preference == this.f1547f) {
            startActivity(new Intent(getActivity(), ActivityAudioManager.class));
            return true;
        } else if (preference == this.f1548g) {
            CharSequence[] charSequenceArr = new CharSequence[]{getString(C0861R.string.choose_check_app), getString(C0861R.string.choose_check_content)};
            r0 = new Builder(getActivity());
            r0.setIcon((int) C0861R.drawable.ic_black_action_checkupdate);
            r0.setTitle(getString(C0861R.string.choose_check_title));
            r0.setItems(charSequenceArr, new C08464(this));
            r0.create().show();
            return true;
        } else if (preference != this.f1549h) {
            return false;
        } else {
            r0 = new Builder(getActivity());
            r0.setIcon((int) C0861R.drawable.ic_black_action_about);
            View webView = new WebView(getActivity());
            r0.setTitle(getResources().getString(C0861R.string.infaq_alert_title));
            webView.loadUrl("file:///android_asset/about_donasi.html");
            r0.setView(webView);
            r0.setPositiveButton(getResources().getString(C0861R.string.next), new C08475(this));
            r0.setNegativeButton(getResources().getString(C0861R.string.cancel), new C08486(this));
            r0.show();
            return true;
        }
    }

    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        m2984c("mp3Directory");
        m2984c("qoriSelected");
        m2984c("typeArabic");
        m2984c("fontSizeArabic");
        m2984c("fontSizeLatin");
        m2984c("fontSizeTranslation");
        m2984c("translationType");
        m2984c("latinType");
        m2984c("themeSelected");
        m2984c("actionAya");
        Editor edit = getActivity().getSharedPreferences("murattal_audio_by_andi", 0).edit();
        edit.putBoolean("multiDownloadIsRunning", false);
        edit.apply();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m2984c(str);
    }
}
