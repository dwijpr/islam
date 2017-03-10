package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public class zzmv extends zza {
    public static final Creator<zzmv> CREATOR;
    final int f6621a;
    String f6622b;

    static {
        CREATOR = new pe();
    }

    zzmv(int i, String str) {
        this.f6621a = i;
        this.f6622b = str;
    }

    public zzmv(String str) {
        this.f6621a = 1;
        this.f6622b = str;
    }

    public String m9778a() {
        return this.f6622b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        pe.m8090a(this, parcel, i);
    }
}
