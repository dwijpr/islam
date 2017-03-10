package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzq extends zza {
    public static final Creator<zzq> CREATOR;
    private final int f6733a;
    private final String f6734b;
    private final String f6735c;
    private final int f6736d;

    static {
        CREATOR = new C2101s();
    }

    zzq(int i, String str, String str2, int i2) {
        this.f6733a = i;
        this.f6734b = str;
        this.f6735c = str2;
        this.f6736d = i2;
    }

    public int m9900a() {
        return this.f6733a;
    }

    public String m9901b() {
        return this.f6734b;
    }

    public String m9902c() {
        return this.f6735c;
    }

    public int m9903d() {
        return this.f6736d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2101s.m9865a(this, parcel, i);
    }
}
