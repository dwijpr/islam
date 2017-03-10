package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public class zzgw extends zza {
    public static final Creator<zzgw> CREATOR;
    public final int f6479a;
    public final boolean f6480b;
    public final int f6481c;
    public final boolean f6482d;
    public final int f6483e;
    public final zzfn f6484f;

    static {
        CREATOR = new jf();
    }

    public zzgw(int i, boolean z, int i2, boolean z2, int i3, zzfn com_google_android_gms_internal_zzfn) {
        this.f6479a = i;
        this.f6480b = z;
        this.f6481c = i2;
        this.f6482d = z2;
        this.f6483e = i3;
        this.f6484f = com_google_android_gms_internal_zzfn;
    }

    public zzgw(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzfn(nativeAdOptions.getVideoOptions()) : null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        jf.m6976a(this, parcel, i);
    }
}
