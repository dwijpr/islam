package com.andi.alquran.p028g;

import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.p032j.C0951j;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.andi.alquran.g.a */
public class C0915a {
    private int f1827a;
    private int f1828b;
    private int f1829c;
    private double f1830d;
    private String f1831e;
    private int f1832f;
    private boolean f1833g;

    public C0915a() {
        this.f1833g = false;
    }

    public C0915a(int i, String str, double d) {
        this.f1833g = false;
        this.f1832f = i;
        this.f1831e = str;
        this.f1830d = d;
        double b = C0951j.m3313b(0.008333333333333333d + d);
        this.f1827a = (int) Math.floor(b);
        this.f1828b = (int) Math.floor(b);
        this.f1829c = (int) Math.floor((b - ((double) this.f1827a)) * 60.0d);
    }

    private String m3188b(boolean z) {
        int i = this.f1827a;
        int i2 = this.f1829c;
        String str = i >= 12 ? "pm" : "am";
        i = (((i + 12) - 1) % 12) + 1;
        return !z ? (i < 0 || i > 9 || i2 < 0 || i2 > 9) ? (i < 0 || i > 9) ? (i2 < 0 || i2 > 9) ? i + ":" + Math.round((float) i2) + " " + str : i + ":0" + Math.round((float) i2) + " " + str : "0" + i + ":" + Math.round((float) i2) + " " + str : "0" + i + ":0" + Math.round((float) i2) + " " + str : (i < 0 || i > 9 || i2 < 0 || i2 > 9) ? (i < 0 || i > 9) ? (i2 < 0 || i2 > 9) ? i + ":" + Math.round((float) i2) : i + ":0" + Math.round((float) i2) : "0" + i + ":" + Math.round((float) i2) : "0" + i + ":0" + Math.round((float) i2);
    }

    private String m3189h() {
        String str = BuildConfig.VERSION_NAME;
        int i = this.f1827a;
        int i2 = this.f1829c;
        return (i < 0 || i > 9 || i2 < 0 || i2 > 9) ? (i < 0 || i > 9) ? (i2 < 0 || i2 > 9) ? i + ":" + Math.round((float) i2) : i + ":0" + Math.round((float) i2) : "0" + i + ":" + Math.round((float) i2) : "0" + i + ":0" + Math.round((float) i2);
    }

    public String m3190a() {
        return this.f1831e;
    }

    public String m3191a(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return m3189h();
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return m3188b(false);
            default:
                return null;
        }
    }

    public void m3192a(boolean z) {
        this.f1833g = z;
    }

    public int m3193b() {
        return this.f1827a;
    }

    public int m3194c() {
        return this.f1829c;
    }

    public double m3195d() {
        return this.f1830d;
    }

    public int m3196e() {
        return this.f1832f;
    }

    public String m3197f() {
        return m3189h();
    }

    public boolean m3198g() {
        return this.f1833g;
    }
}
