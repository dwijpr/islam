package com.andi.alquran.p025b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.andi.alquran.App;
import com.andi.alquran.BuildConfig;

/* renamed from: com.andi.alquran.b.d */
public class C0881d {
    public boolean f1662a;
    public boolean f1663b;
    public boolean f1664c;
    public boolean f1665d;
    public boolean f1666e;
    public boolean f1667f;
    public boolean f1668g;
    public int f1669h;
    public int f1670i;
    public int f1671j;
    public int f1672k;
    public int f1673l;
    public int f1674m;
    public int f1675n;
    public int f1676o;
    public int f1677p;
    private int f1678q;
    private int f1679r;
    private long f1680s;
    private String f1681t;

    private int m3065a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    private void m3066a() {
        this.f1662a = true;
        this.f1663b = true;
        this.f1664c = true;
        this.f1665d = true;
        this.f1666e = false;
        this.f1667f = true;
        this.f1668g = false;
        this.f1670i = 0;
        this.f1675n = 1;
        this.f1669h = 2;
        this.f1671j = 18;
        this.f1673l = 18;
        this.f1672k = 18;
        this.f1678q = 1;
        this.f1679r = 1;
        this.f1680s = 0;
        this.f1674m = 1;
        this.f1681t = App.m2883h();
        this.f1676o = 1;
        this.f1677p = 1;
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en")) {
            this.f1670i = 1;
            this.f1675n = 2;
        }
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu")) {
            this.f1674m = 2;
        }
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais")) {
            this.f1670i = 1;
        }
    }

    public void m3067a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            m3066a();
            this.f1662a = defaultSharedPreferences.getBoolean("showLatin", this.f1662a);
            this.f1663b = defaultSharedPreferences.getBoolean("showTranslation", this.f1663b);
            this.f1664c = defaultSharedPreferences.getBoolean("showNomorAyatLatin", this.f1664c);
            this.f1665d = defaultSharedPreferences.getBoolean("showNomorAyatArabic", this.f1665d);
            this.f1666e = defaultSharedPreferences.getBoolean("wordByWord", this.f1666e);
            this.f1667f = defaultSharedPreferences.getBoolean("keepScreenOn", this.f1667f);
            this.f1668g = defaultSharedPreferences.getBoolean("fullScreen", this.f1668g);
            this.f1669h = m3065a(defaultSharedPreferences, "qoriSelected", this.f1669h);
            this.f1670i = m3065a(defaultSharedPreferences, "typeArabic", this.f1670i);
            this.f1671j = m3065a(defaultSharedPreferences, "fontSizeArabic", this.f1671j);
            this.f1673l = m3065a(defaultSharedPreferences, "fontSizeLatin", this.f1673l);
            this.f1672k = m3065a(defaultSharedPreferences, "fontSizeTranslation", this.f1672k);
            this.f1678q = m3065a(defaultSharedPreferences, "lastReadSura", this.f1678q);
            this.f1679r = m3065a(defaultSharedPreferences, "lastReadAya", this.f1679r);
            this.f1680s = defaultSharedPreferences.getLong("lastReadDate", this.f1680s);
            this.f1674m = m3065a(defaultSharedPreferences, "translationType", this.f1674m);
            this.f1675n = m3065a(defaultSharedPreferences, "latinType", this.f1675n);
            this.f1681t = defaultSharedPreferences.getString("mp3Directory", this.f1681t);
            this.f1676o = m3065a(defaultSharedPreferences, "themeSelected", this.f1676o);
            this.f1677p = m3065a(defaultSharedPreferences, "actionAya", this.f1677p);
        } catch (Exception e) {
            m3066a();
        }
    }

    public void m3068b(Context context) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("showLatin", this.f1662a);
        edit.putBoolean("showTranslation", this.f1663b);
        edit.putBoolean("showNomorAyatLatin", this.f1664c);
        edit.putBoolean("showNomorAyatArabic", this.f1665d);
        edit.putBoolean("fullScreen", this.f1668g);
        edit.putBoolean("wordByWord", this.f1666e);
        edit.putBoolean("keepScreenOn", this.f1667f);
        edit.putString("qoriSelected", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1669h);
        edit.putString("typeArabic", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1670i);
        edit.putString("fontSizeArabic", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1671j);
        edit.putString("fontSizeLatin", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1673l);
        edit.putString("fontSizeTranslation", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1672k);
        edit.putString("translationType", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1674m);
        edit.putString("latinType", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1675n);
        edit.putString("themeSelected", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1676o);
        edit.putString("actionAya", android.support.v7.recyclerview.BuildConfig.VERSION_NAME + this.f1677p);
        edit.apply();
    }
}
