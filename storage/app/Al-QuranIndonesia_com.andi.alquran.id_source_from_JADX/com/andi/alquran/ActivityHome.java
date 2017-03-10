package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.andi.alquran.p023e.C0903b;
import com.andi.alquran.p023e.C0903b.C0748c;
import com.andi.alquran.p023e.C0903b.C0750d;
import com.andi.alquran.p023e.C0903b.C0902a;
import com.andi.alquran.p023e.C0904c;
import com.andi.alquran.p023e.C0905d;
import com.andi.alquran.p023e.C0906e;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p027d.C0895b;
import com.andi.alquran.p031i.C0931h;
import com.andi.alquran.p031i.C0937m;
import com.andi.alquran.p032j.C0940b;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityHome extends ActivityBase {
    C0903b f1190a;
    C0750d f1191b;
    private App f1192c;
    private Context f1193d;
    private SharedPreferences f1194e;
    private SharedPreferences f1195f;
    private Handler f1196g;
    private Handler f1197h;
    private int f1198i;
    private boolean f1199j;
    private LinearLayout f1200k;
    private NativeExpressAdView f1201l;
    private Thread f1202m;
    private Thread f1203n;
    private Runnable f1204o;
    private Runnable f1205p;

    /* renamed from: com.andi.alquran.ActivityHome.1 */
    class C07431 implements OnClickListener {
        final /* synthetic */ ActivityHome f1181a;

        C07431(ActivityHome activityHome) {
            this.f1181a = activityHome;
        }

        public void onClick(View view) {
            if (this.f1181a.f1199j) {
                this.f1181a.startActivity(new Intent(this.f1181a, ActivityList.class));
            } else if (App.m2884i().equals(App.m2883h())) {
                Editor edit = this.f1181a.f1194e.edit();
                edit.putBoolean("haveMigrationAudioFix", true);
                edit.apply();
                this.f1181a.startActivity(new Intent(this.f1181a, ActivityList.class));
            } else {
                this.f1181a.m2623g();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.2 */
    class C07442 implements OnClickListener {
        final /* synthetic */ ActivityHome f1182a;

        C07442(ActivityHome activityHome) {
            this.f1182a = activityHome;
        }

        public void onClick(View view) {
            if (this.f1182a.f1199j) {
                this.f1182a.m2603a(false);
            } else if (App.m2884i().equals(App.m2883h())) {
                Editor edit = this.f1182a.f1194e.edit();
                edit.putBoolean("haveMigrationAudioFix", true);
                edit.apply();
                this.f1182a.m2603a(false);
            } else {
                this.f1182a.m2623g();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.3 */
    class C07453 implements OnClickListener {
        final /* synthetic */ ActivityHome f1183a;

        C07453(ActivityHome activityHome) {
            this.f1183a = activityHome;
        }

        public void onClick(View view) {
            if (this.f1183a.f1199j) {
                this.f1183a.m2606d();
            } else if (App.m2884i().equals(App.m2883h())) {
                Editor edit = this.f1183a.f1194e.edit();
                edit.putBoolean("haveMigrationAudioFix", true);
                edit.apply();
                this.f1183a.m2606d();
            } else {
                this.f1183a.m2623g();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.4 */
    class C07464 implements OnClickListener {
        final /* synthetic */ ActivityHome f1184a;

        C07464(ActivityHome activityHome) {
            this.f1184a = activityHome;
        }

        public void onClick(View view) {
            this.f1184a.startActivity(new Intent(this.f1184a, ActivityPTime.class));
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.5 */
    class C07475 implements OnClickListener {
        final /* synthetic */ ActivityHome f1185a;

        C07475(ActivityHome activityHome) {
            this.f1185a = activityHome;
        }

        public void onClick(View view) {
            App.f1448m.f1450b.m3068b(this.f1185a);
            if (this.f1185a.f1199j) {
                if (VERSION.SDK_INT <= 10) {
                    this.f1185a.startActivity(new Intent(this.f1185a, ActivitySettingV10.class));
                    return;
                }
                this.f1185a.startActivity(new Intent(this.f1185a, ActivitySetting.class));
            } else if (App.m2884i().equals(App.m2883h())) {
                Editor edit = this.f1185a.f1194e.edit();
                edit.putBoolean("haveMigrationAudioFix", true);
                edit.apply();
                if (VERSION.SDK_INT <= 10) {
                    this.f1185a.startActivity(new Intent(this.f1185a, ActivitySettingV10.class));
                    return;
                }
                this.f1185a.startActivity(new Intent(this.f1185a, ActivitySetting.class));
            } else {
                this.f1185a.m2623g();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.6 */
    class C07496 implements C0748c {
        final /* synthetic */ ActivityHome f1186a;

        C07496(ActivityHome activityHome) {
            this.f1186a = activityHome;
        }

        public void m2609a(C0904c c0904c) {
            if (c0904c.m3139b() && this.f1186a.f1190a != null) {
                try {
                    this.f1186a.f1190a.m3127a(this.f1186a.f1191b);
                } catch (C0902a e) {
                    e.getMessage();
                }
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.7 */
    class C07517 implements C0750d {
        final /* synthetic */ ActivityHome f1187a;

        C07517(ActivityHome activityHome) {
            this.f1187a = activityHome;
        }

        public void m2611a(C0904c c0904c, C0905d c0905d) {
            if (this.f1187a.f1190a != null && !c0904c.m3140c()) {
                C0906e a = c0905d.m3141a("donation_removeads");
                Editor edit = this.f1187a.f1194e.edit();
                if (a == null || !this.f1187a.m2615a(a)) {
                    edit.putBoolean("translationText", false);
                } else {
                    if (this.f1187a.f1200k.getVisibility() == 0 && this.f1187a.f1201l != null) {
                        this.f1187a.f1200k.setVisibility(8);
                    }
                    edit.putBoolean("translationText", true);
                }
                edit.apply();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.8 */
    class C07528 extends Thread {
        final /* synthetic */ ActivityHome f1188a;

        C07528(ActivityHome activityHome) {
            this.f1188a = activityHome;
        }

        public void run() {
            try {
                C0895b.m3111b(this.f1188a.f1193d);
                Editor edit = this.f1188a.f1195f.edit();
                edit.putLong(C0882e.f1699r, System.currentTimeMillis());
                edit.apply();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityHome.9 */
    class C07539 extends Thread {
        final /* synthetic */ ActivityHome f1189a;

        C07539(ActivityHome activityHome) {
            this.f1189a = activityHome;
        }

        public void run() {
            if (App.m2881f()) {
                String a = new C0940b().m3275a(C0882e.f1682a + "?success=true");
                if (a != null) {
                    try {
                        Editor edit;
                        JSONObject jSONObject = new JSONObject(a);
                        int b = App.m2866b();
                        long currentTimeMillis = System.currentTimeMillis();
                        int i = jSONObject.getInt(BuildConfig.APPLICATION_ID);
                        this.f1189a.f1198i = jSONObject.getInt(C0882e.f1688g);
                        String string = jSONObject.getString(C0882e.f1697p);
                        String string2 = jSONObject.getString(C0882e.f1691j);
                        String string3 = jSONObject.getString(C0882e.f1692k);
                        String string4 = jSONObject.getString(C0882e.f1693l);
                        Editor edit2 = this.f1189a.f1195f.edit();
                        edit2.putLong(C0882e.f1684c, currentTimeMillis);
                        edit2.putString(C0882e.f1697p, string);
                        edit2.putString(C0882e.f1691j, string2);
                        edit2.putString(C0882e.f1692k, string3);
                        edit2.putString(C0882e.f1693l, string4);
                        edit2.apply();
                        if (i > 94 && !((ActivityHome) this.f1189a.f1193d).isFinishing()) {
                            edit = this.f1189a.f1195f.edit();
                            edit.putLong(C0882e.f1686e, currentTimeMillis);
                            edit.apply();
                            this.f1189a.f1196g.post(this.f1189a.f1204o);
                        }
                        if (this.f1189a.f1195f.getLong(C0882e.f1686e, 0) + C0882e.f1687f < System.currentTimeMillis() && App.m2899x() < System.currentTimeMillis() - 345600000 && this.f1189a.f1198i > b && !((ActivityHome) this.f1189a.f1193d).isFinishing()) {
                            edit = this.f1189a.f1195f.edit();
                            edit.putLong(C0882e.f1686e, currentTimeMillis);
                            edit.apply();
                            this.f1189a.f1197h.post(this.f1189a.f1205p);
                        }
                    } catch (JSONException e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

    public ActivityHome() {
        this.f1193d = this;
        this.f1198i = App.m2866b();
        this.f1199j = false;
        this.f1201l = null;
        this.f1190a = null;
        this.f1191b = new C07517(this);
        this.f1202m = new C07528(this);
        this.f1203n = new C07539(this);
        this.f1204o = new Runnable() {
            final /* synthetic */ ActivityHome f1174a;

            /* renamed from: com.andi.alquran.ActivityHome.10.1 */
            class C07391 implements DialogInterface.OnClickListener {
                final /* synthetic */ AnonymousClass10 f1172a;

                C07391(AnonymousClass10 anonymousClass10) {
                    this.f1172a = anonymousClass10;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }

            /* renamed from: com.andi.alquran.ActivityHome.10.2 */
            class C07402 implements DialogInterface.OnClickListener {
                final /* synthetic */ AnonymousClass10 f1173a;

                C07402(AnonymousClass10 anonymousClass10) {
                    this.f1173a = anonymousClass10;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f1173a.f1174a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.andi.alquran.id")));
                }
            }

            {
                this.f1174a = r1;
            }

            public void run() {
                new Builder(this.f1174a).setIcon((int) C0861R.drawable.ic_black_action_about).setTitle(this.f1174a.getString(C0861R.string.update_title)).setMessage(this.f1174a.getString(C0861R.string.update_description)).setCancelable(false).setPositiveButton(this.f1174a.getString(C0861R.string.update_button_yes), new C07402(this)).setNegativeButton(this.f1174a.getString(C0861R.string.update_button_later), new C07391(this)).show();
            }
        };
        this.f1205p = new Runnable() {
            final /* synthetic */ ActivityHome f1177a;

            /* renamed from: com.andi.alquran.ActivityHome.11.1 */
            class C07411 implements DialogInterface.OnClickListener {
                final /* synthetic */ AnonymousClass11 f1175a;

                C07411(AnonymousClass11 anonymousClass11) {
                    this.f1175a = anonymousClass11;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }

            /* renamed from: com.andi.alquran.ActivityHome.11.2 */
            class C07422 implements DialogInterface.OnClickListener {
                final /* synthetic */ AnonymousClass11 f1176a;

                C07422(AnonymousClass11 anonymousClass11) {
                    this.f1176a = anonymousClass11;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (VERSION.SDK_INT >= 11) {
                        new C0937m(this.f1176a.f1177a, this.f1176a.f1177a.f1198i, App.m2873c()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        new C0937m(this.f1176a.f1177a, this.f1176a.f1177a.f1198i, App.m2873c()).execute(new Void[0]);
                    }
                }
            }

            {
                this.f1177a = r1;
            }

            public void run() {
                new Builder(this.f1177a).setIcon((int) C0861R.drawable.ic_black_action_about).setTitle(this.f1177a.getString(C0861R.string.msg_update_content_dialog_title)).setMessage(this.f1177a.getString(C0861R.string.msg_update_content_dialog_desc)).setCancelable(false).setPositiveButton(this.f1177a.getString(C0861R.string.msg_update_content_dialog_button), new C07422(this)).setNegativeButton(this.f1177a.getString(C0861R.string.update_button_later), new C07411(this)).show();
            }
        };
    }

    private boolean m2615a(C0906e c0906e) {
        return c0906e.m3147c().equals("andigambon");
    }

    private void m2621f() {
        Editor edit = this.f1194e.edit();
        if (this.f1192c.f1450b.f1671j > getResources().getInteger(C0861R.integer.max_font_size)) {
            edit.putString("fontSizeArabic", BuildConfig.VERSION_NAME + getResources().getInteger(C0861R.integer.max_font_size));
            edit.apply();
        }
        if (this.f1192c.f1450b.f1673l > getResources().getInteger(C0861R.integer.max_font_size)) {
            edit.putString("fontSizeLatin", BuildConfig.VERSION_NAME + getResources().getInteger(C0861R.integer.max_font_size));
            edit.apply();
        }
        if (this.f1192c.f1450b.f1672k > getResources().getInteger(C0861R.integer.max_font_size)) {
            edit.putString("fontSizeTranslation", BuildConfig.VERSION_NAME + getResources().getInteger(C0861R.integer.max_font_size));
            edit.apply();
        }
    }

    private void m2623g() {
        int i = this.f1192c.f1450b.f1676o == 1 ? C0861R.drawable.ic_black_action_about : C0861R.drawable.ic_action_about;
        new Builder(this).setCancelable(false).setIcon(i).setTitle(getString(C0861R.string.sdcard_warning_title)).setMessage(getString(C0861R.string.sdcard_warning_migration_desc)).setPositiveButton((int) C0861R.string.ok, new DialogInterface.OnClickListener() {
            final /* synthetic */ ActivityHome f1178a;

            {
                this.f1178a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f1178a.m2625h();
            }
        }).setNegativeButton((int) C0861R.string.close, new DialogInterface.OnClickListener() {
            final /* synthetic */ ActivityHome f1179a;

            {
                this.f1179a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    @SuppressLint({"InlinedApi"})
    private void m2625h() {
        if (!App.m2884i().contains(App.m2885j())) {
            if (App.m2877e(App.m2885j()) < ((int) App.m2859a(new File(App.m2884i())))) {
                new Builder(this).setCancelable(false).setIcon(this.f1192c.f1450b.f1676o == 1 ? C0861R.drawable.ic_black_warning : C0861R.drawable.ic_white_warning).setTitle(getString(C0861R.string.sdcard_warning_size_title)).setMessage(getString(C0861R.string.sdcard_warning_size_migration_desc, new Object[]{Integer.valueOf(r1), Integer.valueOf(r2)})).setNegativeButton((int) C0861R.string.quit, new DialogInterface.OnClickListener() {
                    final /* synthetic */ ActivityHome f1180a;

                    {
                        this.f1180a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f1180a.finish();
                    }
                }).show();
            } else if (VERSION.SDK_INT >= 11) {
                new C0931h(this, App.m2883h()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new C0931h(this, App.m2883h()).execute(new Void[0]);
            }
        } else if (VERSION.SDK_INT >= 11) {
            new C0931h(this, App.m2883h()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new C0931h(this, App.m2883h()).execute(new Void[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_home);
        this.f1192c = (App) getApplication();
        this.f1194e = PreferenceManager.getDefaultSharedPreferences(this);
        this.f1199j = this.f1194e.getBoolean("haveMigrationAudioFix", false);
        ((Button) findViewById(C0861R.id.buttonIndexBacaQuran)).setOnClickListener(new C07431(this));
        ((Button) findViewById(C0861R.id.buttonIndexLastRead)).setOnClickListener(new C07442(this));
        ((Button) findViewById(C0861R.id.buttonIndexPencarian)).setOnClickListener(new C07453(this));
        ((Button) findViewById(C0861R.id.buttonIndexJadwalSholat)).setOnClickListener(new C07464(this));
        ((Button) findViewById(C0861R.id.buttonIndexSetting)).setOnClickListener(new C07475(this));
        this.f1200k = (LinearLayout) findViewById(C0861R.id.bannerAds);
        if (App.m2897v()) {
            this.f1200k.setVisibility(8);
        }
        if (this.f1200k.getVisibility() == 0) {
            this.f1201l = new NativeExpressAdView(this);
            this.f1201l.setAdSize(new AdSize(-1, 80));
            this.f1201l.setAdUnitId(App.m2892q());
            AdRequest.Builder builder = new AdRequest.Builder();
            this.f1200k.addView(this.f1201l);
            this.f1201l.loadAd(builder.build());
        }
        m2621f();
        this.f1196g = new Handler();
        this.f1197h = new Handler();
        this.f1195f = getSharedPreferences(C0882e.f1683b, 0);
        if (this.f1195f.getLong(C0882e.f1684c, 0) + C0882e.f1685d < System.currentTimeMillis()) {
            this.f1203n.start();
        }
        if (this.f1195f.getLong(C0882e.f1699r, 0) + C0882e.f1700s < System.currentTimeMillis()) {
            this.f1202m.start();
        }
        this.f1190a = new C0903b(this, App.m2898w());
        this.f1190a.m3129a(false);
        this.f1190a.m3126a(new C07496(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1190a != null) {
            this.f1190a.m3132b();
            this.f1190a = null;
        }
    }

    protected void onResume() {
        super.onResume();
        this.f1194e = PreferenceManager.getDefaultSharedPreferences(this);
        this.f1199j = this.f1194e.getBoolean("haveMigrationAudioFix", false);
        if (App.m2897v() && this.f1200k.getVisibility() == 0) {
            this.f1200k.setVisibility(8);
        }
    }
}
