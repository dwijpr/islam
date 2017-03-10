package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    final int f3157a;
    final IBinder f3158b;
    final Scope[] f3159c;
    Integer f3160d;
    Integer f3161e;

    static {
        CREATOR = new C1323i();
    }

    zzd(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f3157a = i;
        this.f3158b = iBinder;
        this.f3159c = scopeArr;
        this.f3160d = num;
        this.f3161e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1323i.m4702a(this, parcel, i);
    }
}
