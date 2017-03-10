package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzarj extends zza {
    public static final Creator<zzarj> CREATOR;
    public final int f6367a;
    public final String f6368b;
    private final int f6369c;

    static {
        CREATOR = new bn();
    }

    zzarj(int i, int i2, String str) {
        this.f6369c = i;
        this.f6367a = i2;
        this.f6368b = str;
    }

    int m9724a() {
        return this.f6369c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzarj)) {
            return false;
        }
        zzarj com_google_android_gms_internal_zzarj = (zzarj) obj;
        return com_google_android_gms_internal_zzarj.f6367a == this.f6367a && C1313b.m4621a(com_google_android_gms_internal_zzarj.f6368b, this.f6368b);
    }

    public int hashCode() {
        return this.f6367a;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.f6367a), this.f6368b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        bn.m5314a(this, parcel, i);
    }
}
