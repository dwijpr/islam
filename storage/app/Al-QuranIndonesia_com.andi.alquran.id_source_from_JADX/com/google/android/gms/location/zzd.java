package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    private final int f6719a;
    private final int f6720b;
    private final int f6721c;

    static {
        CREATOR = new C2091i();
    }

    zzd(int i, int i2, int i3) {
        this.f6719a = i;
        this.f6720b = i2;
        this.f6721c = i3;
    }

    public int m9889a() {
        return this.f6719a;
    }

    public int m9890b() {
        return this.f6720b;
    }

    public int m9891c() {
        return this.f6721c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd com_google_android_gms_location_zzd = (zzd) obj;
        return this.f6720b == com_google_android_gms_location_zzd.f6720b && this.f6721c == com_google_android_gms_location_zzd.f6721c;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6720b), Integer.valueOf(this.f6721c));
    }

    public String toString() {
        int i = this.f6720b;
        return "ActivityTransition [mActivityType=" + i + ", mTransitionType=" + this.f6721c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2091i.m9838a(this, parcel, i);
    }
}
