package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public class zzfn extends zza {
    public static final Creator<zzfn> CREATOR;
    public final int f6477a;
    public final boolean f6478b;

    static {
        CREATOR = new hw();
    }

    public zzfn(int i, boolean z) {
        this.f6477a = i;
        this.f6478b = z;
    }

    public zzfn(VideoOptions videoOptions) {
        this(1, videoOptions.getStartMuted());
    }

    public void writeToParcel(Parcel parcel, int i) {
        hw.m6639a(this, parcel, i);
    }
}
