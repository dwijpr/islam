package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzv;

@op
public class rg {
    long f5690a;
    long f5691b;
    int f5692c;
    int f5693d;
    final String f5694e;
    int f5695f;
    int f5696g;
    private final Object f5697h;

    public rg(String str) {
        this.f5690a = -1;
        this.f5691b = -1;
        this.f5692c = -1;
        this.f5693d = -1;
        this.f5697h = new Object();
        this.f5695f = 0;
        this.f5696g = 0;
        this.f5694e = str;
    }

    public static boolean m8429a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            sg.m8448d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            sg.m8448d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            sg.m8449e("Fail to fetch AdActivity theme");
            sg.m8448d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public long m8430a() {
        return this.f5691b;
    }

    public Bundle m8431a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f5697h) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f5694e);
            bundle.putLong("basets", this.f5691b);
            bundle.putLong("currts", this.f5690a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f5692c);
            bundle.putInt("preqs_in_session", this.f5693d);
            bundle.putInt("pclick", this.f5695f);
            bundle.putInt("pimp", this.f5696g);
            bundle.putBoolean("support_transparent_background", m8429a(context));
        }
        return bundle;
    }

    public void m8432a(int i) {
        this.f5693d = i;
    }

    public void m8433a(zzdy com_google_android_gms_internal_zzdy, long j) {
        synchronized (this.f5697h) {
            if (this.f5691b == -1) {
                if (j - zzv.zzcN().m8420n() > ((Long) C1648if.aF.m6682c()).longValue()) {
                    m8432a(-1);
                } else {
                    m8432a(zzv.zzcN().m8421o());
                }
                this.f5691b = j;
                this.f5690a = this.f5691b;
            } else {
                this.f5690a = j;
            }
            if (com_google_android_gms_internal_zzdy.f6435c == null || com_google_android_gms_internal_zzdy.f6435c.getInt("gw", 2) != 1) {
                this.f5692c++;
                this.f5693d++;
                return;
            }
        }
    }

    public void m8434b() {
        synchronized (this.f5697h) {
            this.f5695f++;
        }
    }

    public void m8435c() {
        synchronized (this.f5697h) {
            this.f5696g++;
        }
    }

    public int m8436d() {
        return this.f5693d;
    }
}
