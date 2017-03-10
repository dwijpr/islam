package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzapv extends zza {
    public static final Creator<zzapv> CREATOR;
    public final int f6361a;
    public final String f6362b;
    public final String f6363c;

    static {
        CREATOR = new bh();
    }

    zzapv(int i, String str, String str2) {
        this.f6361a = i;
        this.f6362b = str;
        this.f6363c = str2;
    }

    public zzapv(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        bh.m5280a(this, parcel, i);
    }
}
