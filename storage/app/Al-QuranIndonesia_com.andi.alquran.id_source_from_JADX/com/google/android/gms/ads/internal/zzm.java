package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.op;

@op
public final class zzm extends zza {
    public static final Creator<zzm> CREATOR;
    public final int versionCode;
    public final boolean zztH;
    public final boolean zztI;
    public final String zztJ;
    public final boolean zztK;
    public final float zztL;
    public final int zztM;

    static {
        CREATOR = new zzn();
    }

    zzm(int i, boolean z, boolean z2, String str, boolean z3, float f, int i2) {
        this.versionCode = i;
        this.zztH = z;
        this.zztI = z2;
        this.zztJ = str;
        this.zztK = z3;
        this.zztL = f;
        this.zztM = i2;
    }

    public zzm(boolean z, boolean z2, boolean z3, float f, int i) {
        this(3, z, z2, null, z3, f, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.m4094a(this, parcel, i);
    }
}
