package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR;
    final int f3173a;
    private final long f3174b;
    private int f3175c;
    private final String f3176d;
    private final String f3177e;
    private final String f3178f;
    private final int f3179g;
    private final List<String> f3180h;
    private final String f3181i;
    private final long f3182j;
    private int f3183k;
    private final String f3184l;
    private final float f3185m;
    private final long f3186n;
    private long f3187o;

    static {
        CREATOR = new C1373f();
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f3173a = i;
        this.f3174b = j;
        this.f3175c = i2;
        this.f3176d = str;
        this.f3177e = str3;
        this.f3178f = str5;
        this.f3179g = i3;
        this.f3187o = -1;
        this.f3180h = list;
        this.f3181i = str2;
        this.f3182j = j2;
        this.f3183k = i4;
        this.f3184l = str4;
        this.f3185m = f;
        this.f3186n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public long m4889a() {
        return this.f3174b;
    }

    public int m4890b() {
        return this.f3175c;
    }

    public long m4891c() {
        return this.f3187o;
    }

    public String m4892d() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(m4893e());
        String valueOf3 = String.valueOf("\t");
        int h = m4896h();
        String valueOf4 = String.valueOf("\t");
        String join = m4897i() == null ? BuildConfig.VERSION_NAME : TextUtils.join(",", m4897i());
        String valueOf5 = String.valueOf("\t");
        int l = m4900l();
        String valueOf6 = String.valueOf("\t");
        String f = m4894f() == null ? BuildConfig.VERSION_NAME : m4894f();
        String valueOf7 = String.valueOf("\t");
        String m = m4901m() == null ? BuildConfig.VERSION_NAME : m4901m();
        String valueOf8 = String.valueOf("\t");
        float n = m4902n();
        String valueOf9 = String.valueOf("\t");
        String g = m4895g() == null ? BuildConfig.VERSION_NAME : m4895g();
        return new StringBuilder(((((((((((((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(join).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(f).length()) + String.valueOf(valueOf7).length()) + String.valueOf(m).length()) + String.valueOf(valueOf8).length()) + String.valueOf(valueOf9).length()) + String.valueOf(g).length()).append(valueOf).append(valueOf2).append(valueOf3).append(h).append(valueOf4).append(join).append(valueOf5).append(l).append(valueOf6).append(f).append(valueOf7).append(m).append(valueOf8).append(n).append(valueOf9).append(g).toString();
    }

    public String m4893e() {
        return this.f3176d;
    }

    public String m4894f() {
        return this.f3177e;
    }

    public String m4895g() {
        return this.f3178f;
    }

    public int m4896h() {
        return this.f3179g;
    }

    public List<String> m4897i() {
        return this.f3180h;
    }

    public String m4898j() {
        return this.f3181i;
    }

    public long m4899k() {
        return this.f3182j;
    }

    public int m4900l() {
        return this.f3183k;
    }

    public String m4901m() {
        return this.f3184l;
    }

    public float m4902n() {
        return this.f3185m;
    }

    public long m4903o() {
        return this.f3186n;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1373f.m4916a(this, parcel, i);
    }
}
