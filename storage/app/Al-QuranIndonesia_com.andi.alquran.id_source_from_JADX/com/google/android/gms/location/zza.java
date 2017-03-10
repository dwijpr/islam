package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;

public class zza extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zza> CREATOR;
    private final int f6710a;
    private long f6711b;
    private boolean f6712c;
    private WorkSource f6713d;
    private String f6714e;
    private int[] f6715f;
    private boolean f6716g;
    private String f6717h;
    private final long f6718i;

    static {
        CREATOR = new C2089g();
    }

    zza(int i, long j, boolean z, WorkSource workSource, String str, int[] iArr, boolean z2, String str2, long j2) {
        this.f6710a = i;
        this.f6711b = j;
        this.f6712c = z;
        this.f6713d = workSource;
        this.f6714e = str;
        this.f6715f = iArr;
        this.f6716g = z2;
        this.f6717h = str2;
        this.f6718i = j2;
    }

    public long m9880a() {
        return this.f6711b;
    }

    public boolean m9881b() {
        return this.f6712c;
    }

    public WorkSource m9882c() {
        return this.f6713d;
    }

    public String m9883d() {
        return this.f6714e;
    }

    public int[] m9884e() {
        return this.f6715f;
    }

    public boolean m9885f() {
        return this.f6716g;
    }

    public String m9886g() {
        return this.f6717h;
    }

    public long m9887h() {
        return this.f6718i;
    }

    int m9888i() {
        return this.f6710a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2089g.m9832a(this, parcel, i);
    }
}
