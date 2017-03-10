package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaxp extends zza implements C1263g {
    public static final Creator<zzaxp> CREATOR;
    final int f6408a;
    private int f6409b;
    private Intent f6410c;

    static {
        CREATOR = new cn();
    }

    public zzaxp() {
        this(0, null);
    }

    zzaxp(int i, int i2, Intent intent) {
        this.f6408a = i;
        this.f6409b = i2;
        this.f6410c = intent;
    }

    public zzaxp(int i, Intent intent) {
        this(2, i, intent);
    }

    public int m9752a() {
        return this.f6409b;
    }

    public Status m9753b() {
        return this.f6409b == 0 ? Status.f2975a : Status.f2979e;
    }

    public Intent m9754c() {
        return this.f6410c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cn.m5566a(this, parcel, i);
    }
}
