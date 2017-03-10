package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzad;

public class zzaxz extends zza {
    public static final Creator<zzaxz> CREATOR;
    final int f6418a;
    final zzad f6419b;

    static {
        CREATOR = new cv();
    }

    zzaxz(int i, zzad com_google_android_gms_common_internal_zzad) {
        this.f6418a = i;
        this.f6419b = com_google_android_gms_common_internal_zzad;
    }

    public zzaxz(zzad com_google_android_gms_common_internal_zzad) {
        this(1, com_google_android_gms_common_internal_zzad);
    }

    public zzad m9758a() {
        return this.f6419b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cv.m5652a(this, parcel, i);
    }
}
