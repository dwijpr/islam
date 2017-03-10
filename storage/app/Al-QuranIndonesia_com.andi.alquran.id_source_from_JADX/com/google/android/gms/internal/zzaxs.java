package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzaxs extends zza {
    public static final Creator<zzaxs> CREATOR;
    final int f6411a;
    final boolean f6412b;
    final List<Scope> f6413c;

    static {
        CREATOR = new cp();
    }

    zzaxs(int i, boolean z, List<Scope> list) {
        this.f6411a = i;
        this.f6412b = z;
        this.f6413c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cp.m5569a(this, parcel, i);
    }
}
