package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class LocationSettingsStates extends zza {
    public static final Creator<LocationSettingsStates> CREATOR;
    private final int f6695a;
    private final boolean f6696b;
    private final boolean f6697c;
    private final boolean f6698d;
    private final boolean f6699e;
    private final boolean f6700f;
    private final boolean f6701g;

    static {
        CREATOR = new C2104v();
    }

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f6695a = i;
        this.f6696b = z;
        this.f6697c = z2;
        this.f6698d = z3;
        this.f6699e = z4;
        this.f6700f = z5;
        this.f6701g = z6;
    }

    public int m9820a() {
        return this.f6695a;
    }

    public boolean m9821b() {
        return this.f6696b;
    }

    public boolean m9822c() {
        return this.f6699e;
    }

    public boolean m9823d() {
        return this.f6697c;
    }

    public boolean m9824e() {
        return this.f6700f;
    }

    public boolean m9825f() {
        return this.f6698d;
    }

    public boolean m9826g() {
        return this.f6701g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2104v.m9874a(this, parcel, i);
    }
}
