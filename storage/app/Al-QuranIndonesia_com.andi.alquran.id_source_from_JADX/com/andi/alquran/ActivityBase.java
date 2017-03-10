package com.andi.alquran;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.p009b.C0173a;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import com.andi.alquran.arabic.C0875a;
import com.andi.alquran.p024a.C0862a;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p032j.C0946f;
import java.io.File;
import java.util.Arrays;
import p017b.p018a.p019a.p020a.p021a.C0722c;

public class ActivityBase extends AppCompatActivity {
    private App f1170a;
    private Context f1171b;

    /* renamed from: com.andi.alquran.ActivityBase.1 */
    class C07361 implements Runnable {
        final /* synthetic */ ActivityBase f1163a;

        /* renamed from: com.andi.alquran.ActivityBase.1.1 */
        class C07351 implements OnClickListener {
            final /* synthetic */ C07361 f1162a;

            C07351(C07361 c07361) {
                this.f1162a = c07361;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f1162a.f1163a.finish();
            }
        }

        C07361(ActivityBase activityBase) {
            this.f1163a = activityBase;
        }

        public void run() {
            if (App.f1448m.m2904d()) {
                if (!((ActivityBase) this.f1163a.f1171b).isFinishing()) {
                    App.m2871b(this.f1163a.getResources().getString(C0861R.string.msg_extract_data_done));
                }
            } else if (!((ActivityBase) this.f1163a.f1171b).isFinishing()) {
                new Builder(this.f1163a).setMessage((int) C0861R.string.sdcard_required).setCancelable(false).setPositiveButton((int) C0861R.string.quit, new C07351(this)).show();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityBase.2 */
    class C07372 implements OnClickListener {
        final /* synthetic */ ActivityBase f1164a;

        C07372(ActivityBase activityBase) {
            this.f1164a = activityBase;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.andi.alquran.id"));
            this.f1164a.startActivity(intent);
        }
    }

    /* renamed from: com.andi.alquran.ActivityBase.3 */
    class C07383 implements OnClickListener {
        final /* synthetic */ Intent f1165a;
        final /* synthetic */ int f1166b;
        final /* synthetic */ int f1167c;
        final /* synthetic */ boolean f1168d;
        final /* synthetic */ ActivityBase f1169e;

        C07383(ActivityBase activityBase, Intent intent, int i, int i2, boolean z) {
            this.f1169e = activityBase;
            this.f1165a = intent;
            this.f1166b = i;
            this.f1167c = i2;
            this.f1168d = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1165a.putExtra("PAGING", 1);
                this.f1165a.putExtra("SURA", this.f1166b);
                this.f1165a.putExtra("AYA", this.f1167c);
                this.f1165a.putExtra("OPENFROMJUZ", false);
                this.f1169e.startActivity(this.f1165a);
                if (this.f1168d) {
                    this.f1169e.finish();
                }
            } else if (i == 1) {
                this.f1165a.putExtra("PAGING", 2);
                this.f1165a.putExtra("SURA", this.f1166b);
                this.f1165a.putExtra("AYA", this.f1167c);
                this.f1165a.putExtra("OPENFROMJUZ", false);
                this.f1169e.startActivity(this.f1165a);
                if (this.f1168d) {
                    this.f1169e.finish();
                }
            }
        }
    }

    private int m2597a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    private void m2599f() {
        App.f1448m.m2904d();
    }

    private void m2600g() {
        App.f1448m.f1450b.m3067a(this);
        if (!App.f1448m.m2904d()) {
            m2602a();
            App.m2887l();
            setRequestedOrientation(1);
            C0946f.m3282a(this, new C07361(this));
            m2601h();
        }
    }

    private void m2601h() {
        File g = App.m2882g();
        if (g != null && g.exists()) {
            File[] listFiles = g.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                Arrays.sort(listFiles, C0722c.f1118b);
                int i = 0;
                while (i < listFiles.length) {
                    if (listFiles[i].getName().contains("versi") && !listFiles[i].getName().equals(C0882e.f1690i)) {
                        File file = new File(g, listFiles[i].getName());
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void m2602a() {
        SharedPreferences sharedPreferences = getSharedPreferences(C0879b.f1644a, 0);
        if (sharedPreferences.getLong(C0879b.f1645b, 0) + ((long) ((C0879b.f1646c * 60) * 1000)) < System.currentTimeMillis()) {
            long currentTimeMillis = System.currentTimeMillis() + 2400000;
            Editor edit = sharedPreferences.edit();
            edit.putLong(C0879b.f1645b, currentTimeMillis);
            edit.apply();
        }
        if (sharedPreferences.getLong(C0879b.f1647d, 0) + ((long) ((C0879b.f1648e * 60) * 1000)) < System.currentTimeMillis()) {
            currentTimeMillis = System.currentTimeMillis();
            Editor edit2 = sharedPreferences.edit();
            edit2.putLong(C0879b.f1647d, currentTimeMillis);
            edit2.apply();
        }
    }

    public void m2603a(boolean z) {
        App.f1448m.f1450b.m3067a(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int a = m2597a(defaultSharedPreferences, "lastReadSura", 1);
        int a2 = m2597a(defaultSharedPreferences, "lastReadAya", 1);
        String[] strArr = new String[]{getString(C0861R.string.open_as_sura), getString(C0861R.string.open_as_juz)};
        int i = C0861R.drawable.ic_black_action_view;
        if (z && this.f1170a.f1450b.f1676o == 2) {
            i = C0861R.drawable.ic_white_action_view;
        }
        ListAdapter c0862a = new C0862a(this, strArr, new Integer[]{Integer.valueOf(i), Integer.valueOf(i)});
        Intent intent = new Intent(this, ActivityQuran.class);
        new Builder(this).setTitle(this.f1170a.m2902a(a, a2, App.f1448m.f1453e.m3071a(2, a, a2))).setAdapter(c0862a, new C07383(this, intent, a, a2, z)).show();
    }

    public void m2604b() {
        App.f1448m.f1450b.m3068b(this);
        startActivity(new Intent(this, ActivityInfoApp.class));
    }

    public void m2605c() {
        App.f1448m.f1450b.m3068b(this);
        startActivity(VERSION.SDK_INT <= 10 ? new Intent(this, ActivitySettingV10.class) : new Intent(this, ActivitySetting.class));
    }

    public void m2606d() {
        App.f1448m.f1450b.m3068b(this);
        startActivity(new Intent(this, ActivitySearch.class));
    }

    public void m2607e() {
        new Builder(this).setIcon(this.f1170a.f1450b.f1676o == 1 ? C0861R.drawable.ic_black_rateapp : C0861R.drawable.ic_action_rate).setCancelable(true).setTitle(getString(C0861R.string.button_beri_rating) + "!").setMessage(getString(C0861R.string.msg_give_rating)).setPositiveButton((int) C0861R.string.next, new C07372(this)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1171b = this;
        this.f1170a = (App) getApplication();
        if ((C0173a.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? 1 : 0) == 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, C0861R.styleable.AppCompatTheme_spinnerStyle);
        } else {
            m2600g();
        }
    }

    protected void onPause() {
        App.f1448m.f1450b.m3068b(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (this.f1170a.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case C0861R.styleable.AppCompatTheme_spinnerStyle /*112*/:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    App.m2865a(getString(C0861R.string.msg_request_permission_sdcard));
                } else {
                    m2600g();
                }
            default:
        }
    }

    protected void onResume() {
        super.onResume();
        C0875a.m3035a().m3039b();
        App.f1448m.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (this.f1170a.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        m2599f();
    }
}
