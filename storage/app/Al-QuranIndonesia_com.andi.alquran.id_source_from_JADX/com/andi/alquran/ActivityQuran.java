package com.andi.alquran;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.p009b.C0173a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0088f;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.andi.alquran.p022f.C0733b;
import com.andi.alquran.p022f.C0734e;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p026c.C0885a;
import com.andi.alquran.p026c.C0885a.C0883a;
import com.andi.alquran.p026c.C0885a.C0884b;
import com.andi.alquran.p028g.p029a.C0910d;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0913c;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p031i.C0921b;
import com.andi.alquran.p032j.C0939a;
import com.andi.alquran.p032j.C0947g;
import com.andi.alquran.services.MurattalService;
import com.andi.alquran.services.SingleDownloadService;
import com.andi.alquran.services.SingleDownloadService.C0966a;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.maps.GoogleMap;
import java.io.File;
import p000a.p001a.p002a.C0000a;
import p000a.p001a.p002a.C0006c;
import p000a.p001a.p002a.C0006c.C0004a;

public class ActivityQuran extends ActivityBase implements C0733b, C0734e {
    private ServiceConnection f1359A;
    public BroadcastReceiver f1360a;
    public BroadcastReceiver f1361b;
    private final Handler f1362c;
    private ViewPager f1363d;
    private ViewerAdapter f1364e;
    private int f1365f;
    private int f1366g;
    private int f1367h;
    private boolean f1368i;
    private int f1369j;
    private App f1370k;
    private ImageButton f1371l;
    private Context f1372m;
    private ImageButton f1373n;
    private ImageButton f1374o;
    private SharedPreferences f1375p;
    private Editor f1376q;
    private SharedPreferences f1377r;
    private LinearLayout f1378s;
    private InterstitialAd f1379t;
    private boolean f1380u;
    private C0088f f1381v;
    private Runnable f1382w;
    private ProgressDialog f1383x;
    private SingleDownloadService f1384y;
    private boolean f1385z;

    /* renamed from: com.andi.alquran.ActivityQuran.15 */
    class AnonymousClass15 implements OnClickListener {
        final /* synthetic */ EditText f1338a;
        final /* synthetic */ ActivityQuran f1339b;

        AnonymousClass15(ActivityQuran activityQuran, EditText editText) {
            this.f1339b = activityQuran;
            this.f1338a = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1338a.getText().toString().matches(BuildConfig.VERSION_NAME)) {
                App.m2871b(this.f1339b.getString(C0861R.string.ayat_goto_empty));
                return;
            }
            int parseInt = Integer.parseInt(this.f1338a.getText().toString());
            FragmentAlQuran q = this.f1339b.m2766u();
            if (q != null && q.getUserVisibleHint()) {
                q.m2963a();
                this.f1339b.m2775a(this.f1339b.f1365f, this.f1339b.f1369j, parseInt);
                q.setSelection(this.f1339b.m2729b(this.f1339b.f1369j, parseInt));
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.19 */
    class AnonymousClass19 implements OnCancelListener {
        final /* synthetic */ String f1343a;
        final /* synthetic */ String f1344b;
        final /* synthetic */ String f1345c;
        final /* synthetic */ ActivityQuran f1346d;

        AnonymousClass19(ActivityQuran activityQuran, String str, String str2, String str3) {
            this.f1346d = activityQuran;
            this.f1343a = str;
            this.f1344b = str2;
            this.f1345c = str3;
        }

        public void onCancel(DialogInterface dialogInterface) {
            SingleDownloadService.m3367b(this.f1346d.f1372m, C0914e.m3185a(this.f1343a, this.f1344b, this.f1345c));
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.1 */
    class C07991 implements C0004a {
        final /* synthetic */ ActivityQuran f1347a;

        C07991(ActivityQuran activityQuran) {
            this.f1347a = activityQuran;
        }

        public void m2718a(C0006c c0006c, int i, int i2) {
            if (i2 == 1) {
                this.f1347a.m2603a(true);
            } else if (i2 == 2) {
                this.f1347a.m2605c();
            } else if (i2 == 3) {
                this.f1347a.m2607e();
            } else if (i2 == 4) {
                this.f1347a.m2604b();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.2 */
    class C08002 implements View.OnClickListener {
        final /* synthetic */ C0006c f1349a;
        final /* synthetic */ ActivityQuran f1350b;

        C08002(ActivityQuran activityQuran, C0006c c0006c) {
            this.f1350b = activityQuran;
            this.f1349a = c0006c;
        }

        public void onClick(View view) {
            this.f1349a.m18b(view);
            this.f1349a.m19c(4);
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.3 */
    class C08013 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1351a;

        C08013(ActivityQuran activityQuran) {
            this.f1351a = activityQuran;
        }

        public void onClick(View view) {
            this.f1351a.finish();
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.4 */
    class C08024 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1352a;

        C08024(ActivityQuran activityQuran) {
            this.f1352a = activityQuran;
        }

        public void onClick(View view) {
            if (App.m2874c(this.f1352a.f1366g)) {
                if (MurattalService.f1949b) {
                    if (this.f1352a.f1366g == this.f1352a.f1375p.getInt("suraSelected", 1)) {
                        this.f1352a.m2781h();
                        return;
                    }
                    MurattalService.m3349c();
                    this.f1352a.f1376q.putInt("pageSelected", this.f1352a.f1365f);
                    this.f1352a.f1376q.putInt("suraSelected", this.f1352a.f1366g);
                    this.f1352a.f1376q.putInt("ayaSelected", 1);
                    this.f1352a.f1376q.apply();
                    this.f1352a.m2780g();
                    return;
                }
                this.f1352a.m2780g();
            } else if (this.f1352a.m2744j()) {
                this.f1352a.m2721B();
            } else {
                this.f1352a.m2767v();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.5 */
    class C08035 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1353a;

        C08035(ActivityQuran activityQuran) {
            this.f1353a = activityQuran;
        }

        public void onClick(View view) {
            this.f1353a.m2771x();
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.6 */
    class C08046 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1354a;

        C08046(ActivityQuran activityQuran) {
            this.f1354a = activityQuran;
        }

        public void onClick(View view) {
            this.f1354a.m2749m();
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.7 */
    class C08057 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1355a;

        C08057(ActivityQuran activityQuran) {
            this.f1355a = activityQuran;
        }

        public void onClick(View view) {
            this.f1355a.m2761s();
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.8 */
    class C08068 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1356a;

        C08068(ActivityQuran activityQuran) {
            this.f1356a = activityQuran;
        }

        public void onClick(View view) {
            this.f1356a.m2753o();
        }
    }

    /* renamed from: com.andi.alquran.ActivityQuran.9 */
    class C08079 implements View.OnClickListener {
        final /* synthetic */ ActivityQuran f1357a;

        C08079(ActivityQuran activityQuran) {
            this.f1357a = activityQuran;
        }

        public void onClick(View view) {
            this.f1357a.m2763t();
        }
    }

    private class ViewerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ ActivityQuran f1358a;

        private ViewerAdapter(ActivityQuran activityQuran, FragmentManager fragmentManager) {
            this.f1358a = activityQuran;
            super(fragmentManager);
        }

        private C0883a m2719a(int i) {
            int a = this.f1358a.m2728b(i);
            switch (this.f1358a.f1365f) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return new C0883a(a + 1, 1);
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return App.f1448m.f1453e.m3072a(2, a + 1);
                default:
                    return null;
            }
        }

        public int getCount() {
            switch (this.f1358a.f1365f) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return App.f1448m.f1453e.m3070a();
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return App.f1448m.f1453e.m3074b(2);
                default:
                    return App.f1448m.f1453e.m3070a();
            }
        }

        public Fragment getItem(int i) {
            Fragment fragmentAlQuran = new FragmentAlQuran();
            Bundle bundle = new Bundle();
            C0883a a = m2719a(i);
            if (i == this.f1358a.m2722a(this.f1358a.f1366g, this.f1358a.f1367h)) {
                a.f1702a = this.f1358a.f1366g;
                a.f1703b = this.f1358a.f1367h;
            }
            bundle.putInt("PAGING", this.f1358a.f1365f);
            bundle.putInt("SURA", a.f1702a);
            bundle.putInt("AYA", a.f1703b);
            bundle.putBoolean("OPENFROMJUZ", this.f1358a.f1368i);
            fragmentAlQuran.setArguments(bundle);
            return fragmentAlQuran;
        }

        public CharSequence getPageTitle(int i) {
            if (i < getCount()) {
                int a = this.f1358a.m2728b(i);
                switch (this.f1358a.f1365f) {
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        return BuildConfig.VERSION_NAME + (a + 1) + ". " + App.m2863a(a + 1);
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        return "Juz " + (a + 1);
                }
            }
            return BuildConfig.VERSION_NAME;
        }
    }

    public ActivityQuran() {
        this.f1362c = new Handler();
        this.f1372m = this;
        this.f1379t = null;
        this.f1381v = new C0088f() {
            final /* synthetic */ ActivityQuran f1334a;

            {
                this.f1334a = r1;
            }

            public void m2715a(int i) {
            }

            public void m2716a(int i, float f, int i2) {
            }

            public void m2717b(int i) {
                int a = this.f1334a.m2728b(i - 1);
                if (!MurattalService.f1949b) {
                    this.f1334a.f1376q.putInt("pageSelected", this.f1334a.f1365f);
                    this.f1334a.f1376q.putInt("suraSelected", a);
                    this.f1334a.f1376q.putInt("ayaSelected", 1);
                    this.f1334a.f1376q.apply();
                } else if (MurattalService.f1950c.equals("PAUSE")) {
                    this.f1334a.m2781h();
                    this.f1334a.f1376q.putInt("pageSelected", this.f1334a.f1365f);
                    this.f1334a.f1376q.putInt("suraSelected", a);
                    this.f1334a.f1376q.putInt("ayaSelected", 1);
                    this.f1334a.f1376q.apply();
                } else {
                    this.f1334a.f1366g = a;
                }
                if (this.f1334a.f1365f == 1) {
                    this.f1334a.f1366g = a;
                }
                this.f1334a.f1369j = a;
                this.f1334a.m2745k();
            }
        };
        this.f1382w = new Runnable() {
            final /* synthetic */ ActivityQuran f1335a;

            {
                this.f1335a = r1;
            }

            public void run() {
                this.f1335a.getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            }
        };
        this.f1360a = new BroadcastReceiver() {
            final /* synthetic */ ActivityQuran f1341a;

            {
                this.f1341a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (intent.getExtras() != null) {
                    this.f1341a.m2745k();
                    this.f1341a.m2758q();
                    this.f1341a.m2769w();
                    FragmentAlQuran q = this.f1341a.m2766u();
                    if (q != null && q.getUserVisibleHint()) {
                        q.m2963a();
                        int i = this.f1341a.f1375p.getInt("suraSelected", 1);
                        int i2 = this.f1341a.f1375p.getInt("ayaSelected", 1);
                        this.f1341a.m2775a(this.f1341a.f1365f, i, i2);
                        q.setSelection(this.f1341a.m2729b(i, i2));
                        if (!App.m2874c(i)) {
                            App.m2865a(this.f1341a.getString(C0861R.string.msg_sura_yet_downloaded_toast, new Object[]{App.m2863a(i)}));
                        }
                    }
                }
            }
        };
        this.f1361b = new BroadcastReceiver() {
            final /* synthetic */ ActivityQuran f1342a;

            {
                this.f1342a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (!((ActivityQuran) context).isFinishing()) {
                    this.f1342a.m2745k();
                }
            }
        };
        this.f1385z = false;
        this.f1359A = new ServiceConnection() {
            final /* synthetic */ ActivityQuran f1348a;

            {
                this.f1348a = r1;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                this.f1348a.f1384y = ((C0966a) iBinder).m3363a();
                this.f1348a.f1385z = true;
                this.f1348a.m2773z();
            }

            public void onServiceDisconnected(ComponentName componentName) {
                this.f1348a.f1385z = false;
                this.f1348a.m2720A();
            }
        };
    }

    private void m2720A() {
        super.onPause();
        this.f1384y.m3372b((C0734e) this);
    }

    private void m2721B() {
        new Builder(this).setMessage(getString(C0861R.string.msg_download_single_alert_multi_is_running)).setCancelable(false).setNegativeButton((int) C0861R.string.close, null).show();
    }

    private int m2722a(int i, int i2) {
        int i3 = 0;
        switch (this.f1365f) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                i3 = i - 1;
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                i3 = App.f1448m.f1453e.m3071a(2, i, i2) - 1;
                break;
        }
        return m2728b(i3);
    }

    private int m2728b(int i) {
        return (this.f1364e.getCount() - i) - 1;
    }

    private int m2729b(int i, int i2) {
        int i3 = 0;
        C0883a a = this.f1370k.f1453e.m3072a(this.f1365f, this.f1370k.f1453e.m3071a(this.f1365f, this.f1375p.getInt("suraSelected", 1), this.f1375p.getInt("ayaSelected", 1)));
        int i4 = 0;
        int i5 = a.f1703b == 1 ? 0 : a.f1703b;
        int i6 = a.f1702a;
        int i7 = i5;
        while (i6 < i) {
            i6++;
            i4 = ((this.f1370k.f1453e.m3073a(i6).f1706c + 1) - i7) + i4;
            i7 = 0;
        }
        i6 = i2 - i7;
        if (i2 == 1) {
            i3 = 1;
        }
        return (i6 - i3) + i4;
    }

    private void m2735c(int i) {
        new Builder(this.f1372m).setCancelable(true).setMessage(getString(C0861R.string.msg_sura_yet_downloaded_corrupt_dialog, new Object[]{Integer.valueOf(i), App.m2863a(this.f1375p.getInt("suraSelected", 1))})).setPositiveButton((int) C0861R.string.ok, new OnClickListener() {
            final /* synthetic */ ActivityQuran f1337a;

            {
                this.f1337a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if ((C0173a.checkSelfPermission(this.f1337a, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? 1 : 0) == 0) {
                    ActivityCompat.requestPermissions(this.f1337a, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, C0861R.styleable.AppCompatTheme_spinnerStyle);
                } else {
                    this.f1337a.m2772y();
                }
            }
        }).setNegativeButton((int) C0861R.string.update_button_later, null).show();
    }

    private void m2741i() {
        if (this.f1379t != null && this.f1379t.isLoaded()) {
            this.f1379t.show();
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = this.f1377r.edit();
            edit.putLong(C0879b.f1645b, currentTimeMillis);
            edit.apply();
        }
    }

    private boolean m2744j() {
        return this.f1375p.getBoolean("multiDownloadIsRunning", false);
    }

    private void m2745k() {
        if (!App.m2874c(this.f1366g)) {
            this.f1371l.setImageResource(C0861R.drawable.ic_action_download);
        } else if (MurattalService.f1949b) {
            this.f1371l.setImageResource(C0861R.drawable.ic_action_murattal_on);
        } else {
            this.f1371l.setImageResource(C0861R.drawable.ic_action_murattal_off);
        }
        m2752n();
    }

    private void m2747l() {
        this.f1373n = (ImageButton) findViewById(C0861R.id.repeaterButton);
        this.f1373n.setOnClickListener(new C08046(this));
        ((ImageButton) findViewById(C0861R.id.prevButton)).setOnClickListener(new C08057(this));
        this.f1374o = (ImageButton) findViewById(C0861R.id.playButton);
        this.f1374o.setOnClickListener(new C08068(this));
        ((ImageButton) findViewById(C0861R.id.nextButton)).setOnClickListener(new C08079(this));
        ((ImageButton) findViewById(C0861R.id.stopButton)).setOnClickListener(new View.OnClickListener() {
            final /* synthetic */ ActivityQuran f1333a;

            {
                this.f1333a = r1;
            }

            public void onClick(View view) {
                this.f1333a.m2781h();
            }
        });
        m2758q();
        m2760r();
    }

    private void m2749m() {
        int i = this.f1375p.getInt("repeaterSelected", 1);
        if (i == 1) {
            this.f1376q.putInt("repeaterSelected", 2);
            App.m2871b(getString(C0861R.string.repeater_onesura));
        } else if (i == 2) {
            this.f1376q.putInt("repeaterSelected", 3);
            App.m2871b(getString(C0861R.string.repeater_oneaya));
        } else if (i == 3) {
            this.f1376q.putInt("repeaterSelected", 1);
            App.m2871b(getString(C0861R.string.repeater_allsura));
        }
        this.f1376q.apply();
        m2760r();
    }

    private void m2752n() {
        if (MurattalService.f1949b) {
            this.f1378s.setVisibility(0);
        } else {
            this.f1378s.setVisibility(8);
        }
    }

    private void m2753o() {
        if (MurattalService.f1950c.equals("PLAYING")) {
            m2755p();
        } else {
            m2780g();
        }
    }

    private void m2755p() {
        MurattalService.m3348b();
        m2758q();
    }

    private void m2758q() {
        if (MurattalService.f1950c.equals("PLAYING")) {
            this.f1374o.setImageResource(C0861R.drawable.ic_action_pause);
        } else {
            this.f1374o.setImageResource(C0861R.drawable.ic_action_play);
        }
    }

    private void m2760r() {
        int i = this.f1375p.getInt("repeaterSelected", 1);
        if (i == 1) {
            this.f1373n.setImageResource(C0861R.drawable.ic_action_repeater_allsura);
        } else if (i == 2) {
            this.f1373n.setImageResource(C0861R.drawable.ic_action_repeater_onesura);
        } else if (i == 3) {
            this.f1373n.setImageResource(C0861R.drawable.ic_action_repeater_oneaya);
        }
    }

    private void m2761s() {
        int i;
        int i2 = 1;
        m2781h();
        int i3 = this.f1375p.getInt("suraSelected", 1);
        int i4 = this.f1375p.getInt("ayaSelected", 1);
        int i5 = i4 - 1;
        if (i4 != 1 || i3 <= 1) {
            i = i3;
        } else {
            C0884b a = new C0885a().m3073a(i3 - 1);
            i = a.f1704a;
            i5 = a.f1706c;
        }
        if (!(i3 == 1 && i4 == 1)) {
            i2 = i5;
        }
        this.f1376q.putInt("suraSelected", i);
        this.f1376q.putInt("ayaSelected", i2);
        this.f1376q.apply();
        m2780g();
    }

    private void m2763t() {
        int i;
        m2781h();
        int i2 = this.f1375p.getInt("suraSelected", 1);
        int i3 = this.f1375p.getInt("ayaSelected", 1);
        int i4 = new C0885a().m3073a(i2).f1706c;
        int i5 = i3 + 1;
        if (i4 == i3) {
            if (i2 < C0861R.styleable.AppCompatTheme_listMenuViewStyle) {
                i2++;
            }
            i = i2;
            i2 = 1;
        } else {
            i = i2;
            i2 = i5;
        }
        this.f1376q.putInt("suraSelected", i);
        this.f1376q.putInt("ayaSelected", i2);
        this.f1376q.apply();
        m2780g();
    }

    private FragmentAlQuran m2766u() {
        return this.f1364e.getCount() == 0 ? null : (FragmentAlQuran) this.f1364e.instantiateItem(this.f1363d, this.f1363d.getCurrentItem());
    }

    private void m2767v() {
        new Builder(this.f1372m).setCancelable(true).setMessage(getString(C0861R.string.msg_sura_yet_downloaded_dialog, new Object[]{App.m2878e(), App.m2863a(this.f1375p.getInt("suraSelected", 1))})).setPositiveButton((int) C0861R.string.yes, new OnClickListener() {
            final /* synthetic */ ActivityQuran f1336a;

            {
                this.f1336a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f1336a.m2772y();
            }
        }).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    private void m2769w() {
        Intent intent = new Intent();
        intent.setAction(C0879b.f1652i);
        intent.putExtras(new Bundle());
        sendBroadcast(intent);
    }

    @SuppressLint({"InflateParams"})
    private void m2771x() {
        View inflate = LayoutInflater.from(this.f1372m).inflate(C0861R.layout.dialog_gotoaya, null);
        Builder builder = new Builder(this.f1372m);
        builder.setView(inflate);
        builder.setTitle(getString(C0861R.string.dialog_title_gotoaya));
        builder.setIcon(this.f1380u ? C0861R.drawable.ic_black_action_gotosura : C0861R.drawable.ic_action_gotosura);
        TextView textView = (TextView) inflate.findViewById(C0861R.id.info_aya_goto2);
        EditText editText = (EditText) inflate.findViewById(C0861R.id.edit_aya2);
        editText.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
        textView.setText(getResources().getString(C0861R.string.ayat_goto, new Object[]{"1-" + this.f1370k.f1453e.m3073a(this.f1369j).f1706c}));
        editText.setHint("1-" + r2);
        editText.setFilters(new InputFilter[]{new C0947g(1, r2)});
        builder.setPositiveButton(getString(C0861R.string.ok), new AnonymousClass15(this, editText));
        builder.setNegativeButton(getString(C0861R.string.cancel), new OnClickListener() {
            final /* synthetic */ ActivityQuran f1340a;

            {
                this.f1340a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setCanceledOnTouchOutside(false);
    }

    @SuppressLint({"InlinedApi"})
    private void m2772y() {
        if (!App.m2881f()) {
            App.m2871b(getString(C0861R.string.msg_not_online));
        } else if (App.m2891p()) {
            C0921b c0921b = new C0921b(this.f1372m, App.m2876d(this.f1375p.getInt("suraSelected", 1)), this);
            if (VERSION.SDK_INT >= 11) {
                c0921b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else {
                c0921b.execute(new String[0]);
            }
        } else {
            App.m2871b(getString(C0861R.string.msg_sdcard_not_mounted_download));
        }
    }

    private void m2773z() {
        this.f1384y.m3369a((C0734e) this);
    }

    @SuppressLint({"InlinedApi"})
    public void m2774a(int i) {
        if (!((ActivityQuran) this.f1372m).isFinishing()) {
            if (i == 0 || i == 4) {
                App.m2871b(getString(C0861R.string.msg_download_exception_server_not_response));
                return;
            }
            int i2 = this.f1375p.getInt("suraSelected", 1);
            String m = i == 1 ? App.m2888m() : i == 2 ? App.m2889n() : i == 3 ? App.m2890o() : App.m2888m();
            String a = App.m2863a(i2);
            String e = App.m2879e(i2);
            String str = m + e + ".zip";
            this.f1383x = new ProgressDialog(this.f1372m);
            int i3 = this.f1380u ? C0861R.drawable.ic_black_action_other_app : C0861R.drawable.ic_action_download;
            this.f1383x.setProgressStyle(1);
            this.f1383x.setIcon(i3);
            this.f1383x.setTitle(this.f1372m.getString(C0861R.string.dialog_title_download_empty));
            this.f1383x.setMessage(this.f1372m.getString(C0861R.string.msg_loading_download, new Object[]{App.m2878e(), a}));
            this.f1383x.setCancelable(true);
            this.f1383x.setCanceledOnTouchOutside(false);
            this.f1383x.setProgress(0);
            this.f1383x.setMax(0);
            this.f1383x.setIndeterminate(false);
            if (VERSION.SDK_INT >= 14) {
                this.f1383x.setProgressNumberFormat(null);
            }
            this.f1383x.setOnCancelListener(new AnonymousClass19(this, e, a, str));
            this.f1383x.show();
            SingleDownloadService.m3365a(this.f1372m, C0914e.m3185a(e, a, str));
        }
    }

    public void m2775a(int i, int i2, int i3) {
        this.f1365f = i;
        this.f1366g = i2;
        this.f1367h = i3;
        this.f1364e.notifyDataSetChanged();
        this.f1363d.setCurrentItem(m2722a(i2, i3));
        m2745k();
    }

    public void m2776a(C0910d c0910d) {
        if (c0910d instanceof C0911a) {
            C0911a c0911a = (C0911a) c0910d;
            if (this.f1383x != null && this.f1383x.isShowing()) {
                if (c0911a.m3160a().intValue() >= 100) {
                    this.f1383x.setProgress(100);
                    this.f1383x.setCancelable(false);
                    this.f1383x.setIndeterminate(true);
                    this.f1383x.setMessage(getString(C0861R.string.msg_download_single_progress_extracting, new Object[]{c0911a.m3158g()}));
                    return;
                }
                this.f1383x.setProgress(c0911a.m3160a().intValue());
                this.f1383x.setMessage(this.f1372m.getString(C0861R.string.msg_loading_download, new Object[]{App.m2878e(), c0911a.m3158g() + ".\n(" + C0939a.m3271a(c0911a.m3160a().intValue(), c0911a.m3163c()) + ")"}));
            }
        }
    }

    public void m2777b(C0910d c0910d) {
        if (!((ActivityQuran) this.f1372m).isFinishing()) {
            m2745k();
            m2780g();
            if (this.f1383x != null && this.f1383x.isShowing()) {
                this.f1383x.dismiss();
            }
        }
    }

    public void m2778c(C0910d c0910d) {
        if (c0910d instanceof C0913c) {
            App.m2871b(((C0913c) c0910d).m3183a());
            App.m2871b(((C0913c) c0910d).m3183a());
            if (!((ActivityQuran) this.f1372m).isFinishing() && this.f1383x != null && this.f1383x.isShowing()) {
                this.f1383x.dismiss();
            }
        }
    }

    public void m2779f() {
        if (m2744j()) {
            m2721B();
        } else {
            m2780g();
        }
    }

    public void m2780g() {
        int i = this.f1375p.getInt("suraSelected", 1);
        int i2 = this.f1375p.getInt("ayaSelected", 1);
        String b = App.m2870b(i, i2);
        if (App.m2872c(b).booleanValue()) {
            startService(new Intent(this, MurattalService.class));
            MurattalService.m3346a();
            m2758q();
        } else if (!App.m2874c(i) || App.m2872c(b).booleanValue()) {
            m2781h();
            m2767v();
        } else {
            m2781h();
            m2735c(i2);
        }
    }

    public void m2781h() {
        if (MurattalService.f1949b) {
            MurattalService.m3349c();
        }
        stopService(new Intent(this, MurattalService.class));
        m2758q();
    }

    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        App.f1448m.f1450b.m3067a(this);
        this.f1370k = (App) getApplication();
        if (this.f1370k.f1450b.f1676o == 1) {
            setContentView((int) C0861R.layout.activity_alquran);
            this.f1380u = true;
        } else {
            setTheme(C0861R.style.AndiThemeNoHeaderDark);
            setContentView((int) C0861R.layout.dark_activity_alquran);
            this.f1380u = false;
        }
        if (!new File(getFilesDir(), "../shared_prefs/" + C0879b.f1644a + ".xml").exists()) {
            m2602a();
        }
        this.f1375p = getSharedPreferences("murattal_audio_by_andi", 0);
        this.f1376q = this.f1375p.edit();
        this.f1377r = getSharedPreferences(C0879b.f1644a, 0);
        this.f1378s = (LinearLayout) findViewById(C0861R.id.playerButtonsArea);
        this.f1378s.setVisibility(8);
        if (bundle != null) {
            this.f1365f = bundle.getInt("PAGING");
            this.f1366g = bundle.getInt("SURA");
            this.f1367h = bundle.getInt("AYA");
            this.f1368i = bundle.getBoolean("OPENFROMJUZ");
            i = bundle.getInt("SURA_ACTION");
        } else {
            Intent intent = getIntent();
            this.f1365f = intent.getIntExtra("PAGING", 1);
            this.f1366g = intent.getIntExtra("SURA", 1);
            this.f1367h = intent.getIntExtra("AYA", 1);
            this.f1368i = intent.getBooleanExtra("OPENFROMJUZ", false);
            i = intent.getIntExtra("SURA_ACTION", 0);
        }
        if (MurattalService.f1949b) {
            int i2 = this.f1375p.getInt("pageSelected", 1);
            int i3 = this.f1375p.getInt("suraSelected", 1);
            int i4 = this.f1375p.getInt("ayaSelected", 1);
            this.f1365f = i2;
            this.f1366g = i3;
            this.f1367h = i4;
        }
        C0006c c0006c = new C0006c(this, 1);
        C0000a c0000a = new C0000a(1, getResources().getString(C0861R.string.go_to_last_read), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_last_read));
        C0000a c0000a2 = new C0000a(2, getResources().getString(C0861R.string.go_to_setting), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_setting));
        C0000a c0000a3 = new C0000a(3, getResources().getString(C0861R.string.go_to_rate), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_rate));
        C0000a c0000a4 = new C0000a(4, getResources().getString(C0861R.string.go_to_about), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_about));
        c0006c.m15a(c0000a);
        c0006c.m15a(c0000a2);
        c0006c.m15a(c0000a3);
        c0006c.m15a(c0000a4);
        c0006c.m16a(new C07991(this));
        ((ImageButton) findViewById(C0861R.id.buttonMenu)).setOnClickListener(new C08002(this, c0006c));
        ((ImageButton) findViewById(C0861R.id.logo)).setOnClickListener(new C08013(this));
        this.f1371l = (ImageButton) findViewById(C0861R.id.startMP3);
        ImageButton imageButton = (ImageButton) findViewById(C0861R.id.buttonGoToSura);
        m2745k();
        if (this.f1365f == 2) {
            this.f1371l.setVisibility(8);
            imageButton.setVisibility(8);
        } else {
            this.f1371l.setVisibility(0);
            this.f1371l.setOnClickListener(new C08024(this));
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new C08035(this));
        }
        this.f1369j = this.f1366g;
        this.f1364e = new ViewerAdapter(getSupportFragmentManager(), null);
        this.f1363d = (ViewPager) findViewById(C0861R.id.pager);
        this.f1363d.setAdapter(this.f1364e);
        this.f1363d.m1320a(this.f1381v);
        m2752n();
        m2747l();
        m2775a(this.f1365f, this.f1366g, this.f1367h);
        if (i != 0) {
            if (i == 1) {
                m2780g();
                m2745k();
            } else if (i == 2) {
                if (m2744j()) {
                    m2721B();
                } else {
                    m2767v();
                }
            }
        }
        if (!App.m2897v() && this.f1377r.getLong(C0879b.f1645b, 0) + ((long) ((C0879b.f1646c * 60) * 1000)) < System.currentTimeMillis()) {
            this.f1379t = new InterstitialAd(this);
            this.f1379t.setAdUnitId(App.m2894s());
            this.f1379t.loadAd(new AdRequest.Builder().build());
        }
        this.f1376q.putBoolean("multiDownloadIsRunning", false);
        this.f1376q.apply();
    }

    protected void onDestroy() {
        m2741i();
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.f1360a);
        unregisterReceiver(this.f1361b);
    }

    protected void onResume() {
        super.onResume();
        if (this.f1360a != null) {
            registerReceiver(this.f1360a, new IntentFilter(C0879b.f1651h));
        }
        if (this.f1361b != null) {
            registerReceiver(this.f1361b, new IntentFilter(C0879b.f1649f));
        }
        if (App.f1448m.f1450b.f1667f) {
            getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        } else {
            getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        }
        FragmentAlQuran u = m2766u();
        if (u != null && u.getUserVisibleHint()) {
            C0883a b = u.m2964b();
            m2775a(this.f1365f, b.f1702a, b.f1703b);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        FragmentAlQuran u = m2766u();
        if (u != null) {
            C0883a b = u.m2964b();
            bundle.putInt("PAGING", this.f1365f);
            bundle.putInt("SURA", b.f1702a);
            bundle.putInt("AYA", b.f1703b);
            bundle.putBoolean("OPENFROMJUZ", this.f1368i);
        }
    }

    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, SingleDownloadService.class), this.f1359A, 1);
    }

    protected void onStop() {
        super.onStop();
        if (this.f1385z) {
            unbindService(this.f1359A);
            this.f1385z = false;
            m2720A();
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        if (App.f1448m.f1450b.f1667f) {
            this.f1362c.removeCallbacks(this.f1382w);
            this.f1362c.postDelayed(this.f1382w, 600000);
            getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        }
    }
}
