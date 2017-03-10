package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public final class zzqa extends zza {
    public static final Creator<zzqa> CREATOR;
    public final int f6635a;
    public String f6636b;
    public int f6637c;
    public int f6638d;
    public boolean f6639e;

    static {
        CREATOR = new sj();
    }

    public zzqa(int i, int i2, boolean z) {
        this(i, i2, z, false);
    }

    public zzqa(int i, int i2, boolean z, boolean z2) {
        String valueOf = String.valueOf("afma-sdk-a-v");
        String str = z ? "0" : z2 ? "2" : "1";
        this(1, new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(str).length()).append(valueOf).append(i).append(".").append(i2).append(".").append(str).toString(), i, i2, z);
    }

    zzqa(int i, String str, int i2, int i3, boolean z) {
        this.f6635a = i;
        this.f6636b = str;
        this.f6637c = i2;
        this.f6638d = i3;
        this.f6639e = z;
    }

    public static zzqa m9783a() {
        return new zzqa(10084208, 10084208, true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        sj.m8710a(this, parcel, i);
    }
}
