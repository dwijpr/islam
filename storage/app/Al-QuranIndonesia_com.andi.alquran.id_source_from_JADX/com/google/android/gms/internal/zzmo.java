package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public class zzmo extends zza {
    public static final Creator<zzmo> CREATOR;
    public final int f6611a;
    public final boolean f6612b;
    public final boolean f6613c;
    public final boolean f6614d;

    static {
        CREATOR = new oz();
    }

    zzmo(int i, boolean z, boolean z2, boolean z3) {
        this.f6611a = i;
        this.f6612b = z;
        this.f6613c = z2;
        this.f6614d = z3;
    }

    public zzmo(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle m9775a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.f6612b);
        bundle.putBoolean("default_iap_supported", this.f6613c);
        bundle.putBoolean("app_streaming_supported", this.f6614d);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        oz.m7993a(this, parcel, i);
    }
}
