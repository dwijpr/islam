package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public final class zznx extends zza {
    public static final Creator<zznx> CREATOR;
    public final int f6623a;
    public final zzdy f6624b;
    public final String f6625c;

    static {
        CREATOR = new qg();
    }

    public zznx(int i, zzdy com_google_android_gms_internal_zzdy, String str) {
        this.f6623a = i;
        this.f6624b = com_google_android_gms_internal_zzdy;
        this.f6625c = str;
    }

    public zznx(zzdy com_google_android_gms_internal_zzdy, String str) {
        this(1, com_google_android_gms_internal_zzdy, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        qg.m8278a(this, parcel, i);
    }
}
