package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaf;

public class zzayb extends zza {
    public static final Creator<zzayb> CREATOR;
    final int f6420a;
    private final ConnectionResult f6421b;
    private final zzaf f6422c;

    static {
        CREATOR = new cw();
    }

    public zzayb(int i) {
        this(new ConnectionResult(i, null), null);
    }

    zzayb(int i, ConnectionResult connectionResult, zzaf com_google_android_gms_common_internal_zzaf) {
        this.f6420a = i;
        this.f6421b = connectionResult;
        this.f6422c = com_google_android_gms_common_internal_zzaf;
    }

    public zzayb(ConnectionResult connectionResult, zzaf com_google_android_gms_common_internal_zzaf) {
        this(1, connectionResult, com_google_android_gms_common_internal_zzaf);
    }

    public ConnectionResult m9759a() {
        return this.f6421b;
    }

    public zzaf m9760b() {
        return this.f6422c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cw.m5655a(this, parcel, i);
    }
}
