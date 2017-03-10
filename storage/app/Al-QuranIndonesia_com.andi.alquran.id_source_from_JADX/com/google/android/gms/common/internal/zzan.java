package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzan extends zza {
    public static final Creator<zzan> CREATOR;
    final int f3156a;

    static {
        CREATOR = new C1321g();
    }

    zzan(int i) {
        this.f3156a = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1321g.m4698a(this, parcel, i);
    }
}
