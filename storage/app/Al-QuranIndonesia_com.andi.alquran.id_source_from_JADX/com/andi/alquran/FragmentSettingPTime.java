package com.andi.alquran;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.andi.alquran.p027d.C0895b;

@TargetApi(11)
public class FragmentSettingPTime extends PreferenceFragment implements OnSharedPreferenceChangeListener, OnPreferenceChangeListener, OnPreferenceClickListener {
    public static boolean f1570a;
    private SharedPreferences f1571b;
    private MediaPlayer f1572c;
    private AudioManager f1573d;
    private int f1574e;
    private int f1575f;
    private int f1576g;
    private int f1577h;
    private int f1578i;

    /* renamed from: com.andi.alquran.FragmentSettingPTime.1 */
    class C08501 implements OnSeekBarChangeListener {
        int f1555a;
        final /* synthetic */ int f1556b;
        final /* synthetic */ SeekBar f1557c;
        final /* synthetic */ TextView f1558d;
        final /* synthetic */ FragmentSettingPTime f1559e;

        C08501(FragmentSettingPTime fragmentSettingPTime, int i, SeekBar seekBar, TextView textView) {
            this.f1559e = fragmentSettingPTime;
            this.f1556b = i;
            this.f1557c = seekBar;
            this.f1558d = textView;
            this.f1555a = this.f1556b;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f1555a = i;
            if (i < this.f1559e.f1576g) {
                this.f1557c.setProgress(this.f1559e.f1576g);
            }
            this.f1558d.setText(this.f1559e.getActivity().getString(C0861R.string.volume_adzan_current, new Object[]{this.f1555a + "%"}));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f1558d.setText(this.f1559e.getActivity().getString(C0861R.string.volume_adzan_current, new Object[]{this.f1555a + "%"}));
            this.f1559e.f1575f = this.f1555a;
            this.f1559e.m2997d();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.2 */
    class C08512 implements OnCancelListener {
        final /* synthetic */ FragmentSettingPTime f1560a;

        C08512(FragmentSettingPTime fragmentSettingPTime) {
            this.f1560a = fragmentSettingPTime;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f1560a.m2999e();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.3 */
    class C08523 implements OnClickListener {
        final /* synthetic */ SeekBar f1561a;
        final /* synthetic */ FragmentSettingPTime f1562b;

        C08523(FragmentSettingPTime fragmentSettingPTime, SeekBar seekBar) {
            this.f1562b = fragmentSettingPTime;
            this.f1561a = seekBar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1562b.f1571b.edit();
            edit.putInt("volumeAdzan", this.f1561a.getProgress());
            edit.apply();
            this.f1562b.m2999e();
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.4 */
    class C08534 implements OnClickListener {
        final /* synthetic */ FragmentSettingPTime f1563a;

        C08534(FragmentSettingPTime fragmentSettingPTime) {
            this.f1563a = fragmentSettingPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.5 */
    class C08545 implements OnSeekBarChangeListener {
        final /* synthetic */ TextView f1564a;
        final /* synthetic */ FragmentSettingPTime f1565b;

        C08545(FragmentSettingPTime fragmentSettingPTime, TextView textView) {
            this.f1565b = fragmentSettingPTime;
            this.f1564a = textView;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f1565b.f1578i = this.f1565b.f1577h + i;
            if (this.f1565b.f1578i == 0) {
                this.f1564a.setText(this.f1565b.getActivity().getString(C0861R.string.adjust_hijri_cal_current));
            } else if (this.f1565b.f1578i > 0) {
                this.f1564a.setText(this.f1565b.getActivity().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(this.f1565b.f1578i)}));
            } else if (this.f1565b.f1578i < 0) {
                String replace = String.valueOf(this.f1565b.f1578i).replace("-", BuildConfig.VERSION_NAME);
                this.f1564a.setText(this.f1565b.getActivity().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.6 */
    class C08556 implements OnClickListener {
        final /* synthetic */ FragmentSettingPTime f1566a;

        C08556(FragmentSettingPTime fragmentSettingPTime) {
            this.f1566a = fragmentSettingPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1566a.f1571b.edit();
            edit.putInt("adjustHijrCal", this.f1566a.f1578i);
            edit.apply();
            this.f1566a.m2990a("setHijriCal");
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.7 */
    class C08567 implements OnClickListener {
        final /* synthetic */ FragmentSettingPTime f1567a;

        C08567(FragmentSettingPTime fragmentSettingPTime) {
            this.f1567a = fragmentSettingPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.8 */
    class C08578 extends WebViewClient {
        final /* synthetic */ FragmentSettingPTime f1568a;

        C08578(FragmentSettingPTime fragmentSettingPTime) {
            this.f1568a = fragmentSettingPTime;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            if (url == null) {
                return false;
            }
            String uri = url.toString();
            if (!uri.startsWith("http://") && !uri.startsWith("https://") && !uri.startsWith("market://")) {
                return false;
            }
            this.f1568a.startActivity(new Intent("android.intent.action.VIEW", url));
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("market://"))) {
                return false;
            }
            this.f1568a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    /* renamed from: com.andi.alquran.FragmentSettingPTime.9 */
    class C08589 implements OnClickListener {
        final /* synthetic */ FragmentSettingPTime f1569a;

        C08589(FragmentSettingPTime fragmentSettingPTime) {
            this.f1569a = fragmentSettingPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        f1570a = false;
    }

    public FragmentSettingPTime() {
        this.f1576g = 20;
        this.f1577h = -3;
    }

    private void m2988a() {
        int i = this.f1571b.getInt("volumeAdzan", 60);
        Builder builder = new Builder(getActivity());
        builder.setTitle(getActivity().getString(C0861R.string.volume_adzan_title));
        View linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(20, 20, 20, 10);
        View seekBar = new SeekBar(getActivity());
        seekBar.setMax(100);
        seekBar.setProgress(i);
        View textView = new TextView(getActivity());
        textView.setText(getActivity().getString(C0861R.string.volume_adzan_current, new Object[]{i + "%"}));
        textView.setPadding(10, 10, 10, 10);
        textView.setGravity(1);
        linearLayout.addView(seekBar);
        linearLayout.addView(textView);
        seekBar.setOnSeekBarChangeListener(new C08501(this, i, seekBar, textView));
        builder.setView(linearLayout);
        builder.setOnCancelListener(new C08512(this));
        builder.setPositiveButton(getActivity().getString(C0861R.string.save), new C08523(this, seekBar));
        builder.setNegativeButton(getActivity().getString(C0861R.string.cancel), new C08534(this));
        builder.show();
    }

    private void m2990a(String str) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            int i;
            if (str.equals("typeTimeFormat")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeTimeFormat)[App.m2858a(this.f1571b, "typeTimeFormat", 0)]);
            }
            if (str.equals("typeCalc")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.arrTypeCalc)[App.m2858a(this.f1571b, "typeCalc", 0)]);
            }
            if (str.equals("typeJuristic")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.asrJuristic)[App.m2858a(this.f1571b, "typeJuristic", 0)]);
            }
            if (str.equals("typeAdjustHighLat")) {
                findPreference.setSummary(getActivity().getResources().getStringArray(C0861R.array.adjustHighLats)[App.m2858a(this.f1571b, "typeAdjustHighLat", 3)]);
            }
            if (str.equals("setVolumeAdzan")) {
                i = this.f1571b.getInt("volumeAdzan", 60);
                findPreference.setSummary(getActivity().getString(C0861R.string.volume_adzan_current, new Object[]{i + "%"}));
            }
            if (str.equals("setHijriCal")) {
                i = this.f1571b.getInt("adjustHijrCal", 0);
                if (i == 0) {
                    findPreference.setSummary(getActivity().getString(C0861R.string.adjust_hijri_cal_current));
                } else if (i > 0) {
                    findPreference.setSummary(getActivity().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(i)}));
                } else if (i < 0) {
                    String replace = String.valueOf(i).replace("-", BuildConfig.VERSION_NAME);
                    findPreference.setSummary(getActivity().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
                }
            }
        }
    }

    private void m2992b() {
        this.f1578i = this.f1571b.getInt("adjustHijrCal", 0);
        Builder builder = new Builder(getActivity());
        builder.setTitle(getActivity().getString(C0861R.string.adjust_hijri_cal_title));
        View linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(20, 20, 20, 10);
        View seekBar = new SeekBar(getActivity());
        seekBar.setMax(6);
        seekBar.setProgress(this.f1578i + 3);
        View textView = new TextView(getActivity());
        if (this.f1578i == 0) {
            textView.setText(getActivity().getString(C0861R.string.adjust_hijri_cal_current));
        } else if (this.f1578i > 0) {
            textView.setText(getActivity().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(this.f1578i)}));
        } else if (this.f1578i < 0) {
            String replace = String.valueOf(this.f1578i).replace("-", BuildConfig.VERSION_NAME);
            textView.setText(getActivity().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
        }
        textView.setPadding(10, 10, 10, 10);
        textView.setGravity(1);
        linearLayout.addView(seekBar);
        linearLayout.addView(textView);
        seekBar.setOnSeekBarChangeListener(new C08545(this, textView));
        builder.setView(linearLayout);
        builder.setPositiveButton(getActivity().getString(C0861R.string.save), new C08556(this));
        builder.setNegativeButton(getActivity().getString(C0861R.string.cancel), new C08567(this));
        builder.show();
    }

    private void m2994c() {
        Builder builder = new Builder(getActivity());
        builder.setIcon((int) C0861R.drawable.ic_black_action_about);
        View webView = new WebView(getActivity());
        builder.setTitle(getResources().getString(C0861R.string.info_app_prayer_times_title));
        webView.loadUrl("file:///android_asset/about_shalat.html");
        webView.setWebViewClient(new C08578(this));
        builder.setView(webView);
        builder.setNegativeButton(getResources().getString(C0861R.string.close), new C08589(this));
        builder.show();
    }

    private void m2997d() {
        m2999e();
        this.f1573d = (AudioManager) getActivity().getSystemService("audio");
        this.f1574e = this.f1573d.getStreamVolume(3);
        this.f1573d.setStreamVolume(3, (this.f1573d.getStreamMaxVolume(3) * this.f1575f) / 100, 0);
        this.f1572c = MediaPlayer.create(getActivity(), Uri.parse("android.resource://com.andi.alquran.id/2131230720"));
        this.f1572c.setOnCompletionListener(new OnCompletionListener() {
            final /* synthetic */ FragmentSettingPTime f1554a;

            {
                this.f1554a = r1;
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                this.f1554a.m2999e();
            }
        });
        this.f1572c.start();
        f1570a = true;
    }

    private void m2999e() {
        if (this.f1573d != null) {
            this.f1573d.setStreamVolume(3, this.f1574e, 0);
        }
        if (f1570a && this.f1572c != null && this.f1572c.isPlaying()) {
            this.f1572c.stop();
        }
        f1570a = false;
        m2990a("setVolumeAdzan");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName("prayer_time_by_andi");
        preferenceManager.setSharedPreferencesMode(0);
        addPreferencesFromResource(C0861R.xml.settings_ptime);
        findPreference("adjustManual").setOnPreferenceClickListener(this);
        findPreference("setVolumeAdzan").setOnPreferenceClickListener(this);
        findPreference("setHijriCal").setOnPreferenceClickListener(this);
        findPreference("infoApp").setOnPreferenceClickListener(this);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("forcingNotifLollipop");
        if (VERSION.SDK_INT >= 21) {
            checkBoxPreference.setOnPreferenceChangeListener(this);
        } else {
            ((PreferenceGroup) findPreference("categoryPTimeOther")).removePreference(checkBoxPreference);
        }
        this.f1571b = getActivity().getSharedPreferences("prayer_time_by_andi", 0);
    }

    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        m2990a("typeTimeFormat");
        m2990a("typeCalc");
        m2990a("typeJuristic");
        m2990a("typeAdjustHighLat");
        m2990a("setVolumeAdzan");
        m2990a("setHijriCal");
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        return true;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference.getKey().equals("adjustManual")) {
            getFragmentManager().beginTransaction().replace(C0861R.id.layoutSettingPTime, new FragmentSettingPTimeManual()).addToBackStack(FragmentSettingPTimeManual.class.getSimpleName()).commit();
            return true;
        } else if (preference.getKey().equals("setVolumeAdzan")) {
            m2988a();
            return true;
        } else if (preference.getKey().equals("setHijriCal")) {
            m2992b();
            return true;
        } else if (!preference.getKey().equals("infoApp")) {
            return false;
        } else {
            m2994c();
            return true;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f1571b == null) {
            this.f1571b = getActivity().getSharedPreferences("prayer_time_by_andi", 0);
        }
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        m2990a("typeTimeFormat");
        m2990a("typeCalc");
        m2990a("typeJuristic");
        m2990a("typeAdjustHighLat");
        m2990a("setVolumeAdzan");
        m2990a("setHijriCal");
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (VERSION.SDK_INT >= 21 && VERSION.SDK_INT < 23 && str.equals("forcingNotifLollipop")) {
            C0895b.m3111b(getActivity());
        }
        m2990a(str);
    }
}
