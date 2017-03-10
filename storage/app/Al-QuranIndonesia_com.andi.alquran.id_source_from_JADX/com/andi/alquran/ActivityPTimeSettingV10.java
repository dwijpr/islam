package com.andi.alquran;

import android.annotation.TargetApi;
import android.app.backup.BackupManager;
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
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.andi.alquran.p027d.C0895b;

public class ActivityPTimeSettingV10 extends PreferenceActivity implements OnSharedPreferenceChangeListener, OnPreferenceClickListener {
    public static boolean f1314a;
    private SharedPreferences f1315b;
    private MediaPlayer f1316c;
    private AudioManager f1317d;
    private int f1318e;
    private int f1319f;
    private int f1320g;
    private int f1321h;
    private int f1322i;

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.1 */
    class C07871 implements OnSeekBarChangeListener {
        int f1299a;
        final /* synthetic */ int f1300b;
        final /* synthetic */ SeekBar f1301c;
        final /* synthetic */ TextView f1302d;
        final /* synthetic */ ActivityPTimeSettingV10 f1303e;

        C07871(ActivityPTimeSettingV10 activityPTimeSettingV10, int i, SeekBar seekBar, TextView textView) {
            this.f1303e = activityPTimeSettingV10;
            this.f1300b = i;
            this.f1301c = seekBar;
            this.f1302d = textView;
            this.f1299a = this.f1300b;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f1299a = i;
            if (i < this.f1303e.f1320g) {
                this.f1301c.setProgress(this.f1303e.f1320g);
            }
            this.f1302d.setText(this.f1303e.getResources().getString(C0861R.string.volume_adzan_current, new Object[]{this.f1299a + "%"}));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f1302d.setText(this.f1303e.getResources().getString(C0861R.string.volume_adzan_current, new Object[]{this.f1299a + "%"}));
            this.f1303e.f1319f = this.f1299a;
            this.f1303e.m2705d();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.2 */
    class C07882 implements OnCancelListener {
        final /* synthetic */ ActivityPTimeSettingV10 f1304a;

        C07882(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1304a = activityPTimeSettingV10;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f1304a.m2707e();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.3 */
    class C07893 implements OnClickListener {
        final /* synthetic */ SeekBar f1305a;
        final /* synthetic */ ActivityPTimeSettingV10 f1306b;

        C07893(ActivityPTimeSettingV10 activityPTimeSettingV10, SeekBar seekBar) {
            this.f1306b = activityPTimeSettingV10;
            this.f1305a = seekBar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1306b.f1315b.edit();
            edit.putInt("volumeAdzan", this.f1305a.getProgress());
            edit.apply();
            this.f1306b.m2707e();
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.4 */
    class C07904 implements OnClickListener {
        final /* synthetic */ ActivityPTimeSettingV10 f1307a;

        C07904(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1307a = activityPTimeSettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.5 */
    class C07915 implements OnSeekBarChangeListener {
        final /* synthetic */ TextView f1308a;
        final /* synthetic */ ActivityPTimeSettingV10 f1309b;

        C07915(ActivityPTimeSettingV10 activityPTimeSettingV10, TextView textView) {
            this.f1309b = activityPTimeSettingV10;
            this.f1308a = textView;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f1309b.f1322i = this.f1309b.f1321h + i;
            if (this.f1309b.f1322i == 0) {
                this.f1308a.setText(this.f1309b.getResources().getString(C0861R.string.adjust_hijri_cal_current));
            } else if (this.f1309b.f1322i > 0) {
                this.f1308a.setText(this.f1309b.getResources().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(this.f1309b.f1322i)}));
            } else if (this.f1309b.f1322i < 0) {
                String replace = String.valueOf(this.f1309b.f1322i).replace("-", BuildConfig.VERSION_NAME);
                this.f1308a.setText(this.f1309b.getResources().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.6 */
    class C07926 implements OnClickListener {
        final /* synthetic */ ActivityPTimeSettingV10 f1310a;

        C07926(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1310a = activityPTimeSettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1310a.f1315b.edit();
            edit.putInt("adjustHijrCal", this.f1310a.f1322i);
            edit.apply();
            this.f1310a.m2698a("setHijriCal");
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.7 */
    class C07937 implements OnClickListener {
        final /* synthetic */ ActivityPTimeSettingV10 f1311a;

        C07937(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1311a = activityPTimeSettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.8 */
    class C07948 extends WebViewClient {
        final /* synthetic */ ActivityPTimeSettingV10 f1312a;

        C07948(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1312a = activityPTimeSettingV10;
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
            this.f1312a.startActivity(new Intent("android.intent.action.VIEW", url));
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("market://"))) {
                return false;
            }
            this.f1312a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeSettingV10.9 */
    class C07959 implements OnClickListener {
        final /* synthetic */ ActivityPTimeSettingV10 f1313a;

        C07959(ActivityPTimeSettingV10 activityPTimeSettingV10) {
            this.f1313a = activityPTimeSettingV10;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        f1314a = false;
    }

    public ActivityPTimeSettingV10() {
        this.f1320g = 20;
        this.f1321h = -3;
    }

    private void m2696a() {
        int i = this.f1315b.getInt("volumeAdzan", 60);
        Builder builder = new Builder(this);
        builder.setTitle(getResources().getString(C0861R.string.volume_adzan_title));
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(20, 20, 20, 10);
        View seekBar = new SeekBar(this);
        seekBar.setMax(100);
        seekBar.setProgress(i);
        View textView = new TextView(this);
        textView.setText(getResources().getString(C0861R.string.volume_adzan_current, new Object[]{i + "%"}));
        textView.setPadding(10, 10, 10, 10);
        textView.setGravity(1);
        linearLayout.addView(seekBar);
        linearLayout.addView(textView);
        seekBar.setOnSeekBarChangeListener(new C07871(this, i, seekBar, textView));
        builder.setView(linearLayout);
        builder.setOnCancelListener(new C07882(this));
        builder.setPositiveButton(getResources().getString(C0861R.string.save), new C07893(this, seekBar));
        builder.setNegativeButton(getResources().getString(C0861R.string.cancel), new C07904(this));
        builder.show();
    }

    private void m2698a(String str) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            int i;
            if (str.equals("typeTimeFormat")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeTimeFormat)[App.m2858a(this.f1315b, "typeTimeFormat", 0)]);
            }
            if (str.equals("typeCalc")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.arrTypeCalc)[App.m2858a(this.f1315b, "typeCalc", 0)]);
            }
            if (str.equals("typeJuristic")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.asrJuristic)[App.m2858a(this.f1315b, "typeJuristic", 0)]);
            }
            if (str.equals("typeAdjustHighLat")) {
                findPreference.setSummary(getResources().getStringArray(C0861R.array.adjustHighLats)[App.m2858a(this.f1315b, "typeAdjustHighLat", 3)]);
            }
            if (str.equals("setVolumeAdzan")) {
                i = this.f1315b.getInt("volumeAdzan", 60);
                findPreference.setSummary(getResources().getString(C0861R.string.volume_adzan_current, new Object[]{i + "%"}));
            }
            if (str.equals("setHijriCal")) {
                i = this.f1315b.getInt("adjustHijrCal", 0);
                if (i == 0) {
                    findPreference.setSummary(getResources().getString(C0861R.string.adjust_hijri_cal_current));
                } else if (i > 0) {
                    findPreference.setSummary(getResources().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(i)}));
                } else if (i < 0) {
                    String replace = String.valueOf(i).replace("-", BuildConfig.VERSION_NAME);
                    findPreference.setSummary(getResources().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
                }
            }
        }
    }

    private void m2700b() {
        this.f1322i = this.f1315b.getInt("adjustHijrCal", 0);
        Builder builder = new Builder(this);
        builder.setTitle(getResources().getString(C0861R.string.adjust_hijri_cal_title));
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(20, 20, 20, 10);
        View seekBar = new SeekBar(this);
        seekBar.setMax(6);
        seekBar.setProgress(this.f1322i + 3);
        View textView = new TextView(this);
        if (this.f1322i == 0) {
            textView.setText(getResources().getString(C0861R.string.adjust_hijri_cal_current));
        } else if (this.f1322i > 0) {
            textView.setText(getResources().getString(C0861R.string.adjust_hijri_cal_current_plus, new Object[]{Integer.valueOf(this.f1322i)}));
        } else if (this.f1322i < 0) {
            String replace = String.valueOf(this.f1322i).replace("-", BuildConfig.VERSION_NAME);
            textView.setText(getResources().getString(C0861R.string.adjust_hijri_cal_current_min, new Object[]{replace}));
        }
        textView.setPadding(10, 10, 10, 10);
        textView.setGravity(1);
        linearLayout.addView(seekBar);
        linearLayout.addView(textView);
        seekBar.setOnSeekBarChangeListener(new C07915(this, textView));
        builder.setView(linearLayout);
        builder.setPositiveButton(getResources().getString(C0861R.string.save), new C07926(this));
        builder.setNegativeButton(getResources().getString(C0861R.string.cancel), new C07937(this));
        builder.show();
    }

    private void m2702c() {
        Builder builder = new Builder(this);
        builder.setIcon((int) C0861R.drawable.ic_black_action_about);
        View webView = new WebView(this);
        builder.setTitle(getResources().getString(C0861R.string.info_app_prayer_times_title));
        webView.loadUrl("file:///android_asset/about_shalat.html");
        webView.setWebViewClient(new C07948(this));
        builder.setView(webView);
        builder.setNegativeButton(getResources().getString(C0861R.string.close), new C07959(this));
        builder.show();
    }

    private void m2705d() {
        m2707e();
        this.f1317d = (AudioManager) getSystemService("audio");
        this.f1318e = this.f1317d.getStreamVolume(3);
        this.f1317d.setStreamVolume(3, (this.f1317d.getStreamMaxVolume(3) * this.f1319f) / 100, 0);
        this.f1316c = MediaPlayer.create(this, Uri.parse("android.resource://com.andi.alquran.id/2131230720"));
        this.f1316c.setOnCompletionListener(new OnCompletionListener() {
            final /* synthetic */ ActivityPTimeSettingV10 f1298a;

            {
                this.f1298a = r1;
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                this.f1298a.m2707e();
            }
        });
        this.f1316c.start();
        f1314a = true;
    }

    private void m2707e() {
        if (this.f1317d != null) {
            this.f1317d.setStreamVolume(3, this.f1318e, 0);
        }
        if (f1314a && this.f1316c != null && this.f1316c.isPlaying()) {
            this.f1316c.stop();
        }
        f1314a = false;
        m2698a("setVolumeAdzan");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName("prayer_time_by_andi");
        preferenceManager.setSharedPreferencesMode(0);
        addPreferencesFromResource(C0861R.xml.settings_ptime);
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
        this.f1315b = getSharedPreferences("prayer_time_by_andi", 0);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.findPreference("adjustManual").setOnPreferenceClickListener(this);
        findPreference("setVolumeAdzan").setOnPreferenceClickListener(this);
        findPreference("setHijriCal").setOnPreferenceClickListener(this);
        preferenceScreen.findPreference("infoApp").setOnPreferenceClickListener(this);
        ((PreferenceGroup) findPreference("categoryPTimeOther")).removePreference((CheckBoxPreference) findPreference("forcingNotifLollipop"));
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
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        m2698a("typeTimeFormat");
        m2698a("typeCalc");
        m2698a("typeJuristic");
        m2698a("typeAdjustHighLat");
        m2698a("setVolumeAdzan");
        m2698a("setHijriCal");
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference.getKey().equals("adjustManual")) {
            startActivity(new Intent(this, ActivityPTimeSettingV10Manual.class));
            return true;
        } else if (preference.getKey().equals("setVolumeAdzan")) {
            m2696a();
            return true;
        } else if (preference.getKey().equals("setHijriCal")) {
            m2700b();
            return true;
        } else if (!preference.getKey().equals("infoApp")) {
            return false;
        } else {
            m2702c();
            return true;
        }
    }

    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        m2698a("typeTimeFormat");
        m2698a("typeCalc");
        m2698a("typeJuristic");
        m2698a("typeAdjustHighLat");
        m2698a("setVolumeAdzan");
        m2698a("setHijriCal");
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m2698a(str);
    }
}
