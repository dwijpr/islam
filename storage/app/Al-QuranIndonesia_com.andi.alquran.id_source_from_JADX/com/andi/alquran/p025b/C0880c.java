package com.andi.alquran.p025b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.andi.alquran.BuildConfig;

/* renamed from: com.andi.alquran.b.c */
public class C0880c {
    private int f1656a;
    private int f1657b;
    private int f1658c;
    private int f1659d;
    private boolean f1660e;
    private boolean f1661f;

    private int m3061a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    private void m3062a() {
        this.f1656a = 0;
        this.f1657b = 0;
        this.f1658c = 3;
        this.f1659d = 0;
        this.f1661f = true;
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") || BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu")) {
            this.f1656a = 1;
        }
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais")) {
            this.f1656a = 9;
        }
        this.f1660e = true;
    }

    public void m3063a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("prayer_time_by_andi", 0);
        try {
            m3062a();
            this.f1656a = m3061a(sharedPreferences, "typeCalc", this.f1656a);
            this.f1657b = m3061a(sharedPreferences, "typeJuristic", this.f1657b);
            this.f1658c = m3061a(sharedPreferences, "typeAdjustHighLat", this.f1658c);
            this.f1659d = m3061a(sharedPreferences, "typeTimeFormat", this.f1659d);
            this.f1660e = sharedPreferences.getBoolean("forcingNotifLollipop", this.f1660e);
            this.f1661f = sharedPreferences.getBoolean("disableJumat", this.f1661f);
        } catch (Exception e) {
            m3062a();
        }
    }

    public void m3064b(Context context) {
        Editor edit = context.getSharedPreferences("prayer_time_by_andi", 0).edit();
        edit.putString("typeCalc", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1656a);
        edit.putString("typeJuristic", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1657b);
        edit.putString("typeAdjustHighLat", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1658c);
        edit.putString("typeTimeFormat", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1659d);
        edit.putBoolean("forcingNotifLollipop", this.f1660e);
        edit.putBoolean("disableJumat", this.f1661f);
        edit.apply();
    }
}
