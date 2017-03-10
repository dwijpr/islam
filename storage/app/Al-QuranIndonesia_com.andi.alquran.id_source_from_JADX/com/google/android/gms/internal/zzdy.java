package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

@op
public final class zzdy extends zza {
    public static final Creator<zzdy> CREATOR;
    public final int f6433a;
    public final long f6434b;
    public final Bundle f6435c;
    public final int f6436d;
    public final List<String> f6437e;
    public final boolean f6438f;
    public final int f6439g;
    public final boolean f6440h;
    public final String f6441i;
    public final zzfj f6442j;
    public final Location f6443k;
    public final String f6444l;
    public final Bundle f6445m;
    public final Bundle f6446n;
    public final List<String> f6447o;
    public final String f6448p;
    public final String f6449q;
    public final boolean f6450r;

    static {
        CREATOR = new gl();
    }

    public zzdy(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzfj com_google_android_gms_internal_zzfj, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f6433a = i;
        this.f6434b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f6435c = bundle;
        this.f6436d = i2;
        this.f6437e = list;
        this.f6438f = z;
        this.f6439g = i3;
        this.f6440h = z2;
        this.f6441i = str;
        this.f6442j = com_google_android_gms_internal_zzfj;
        this.f6443k = location;
        this.f6444l = str2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.f6445m = bundle2;
        this.f6446n = bundle3;
        this.f6447o = list2;
        this.f6448p = str3;
        this.f6449q = str4;
        this.f6450r = z3;
    }

    public static void m9766a(zzdy com_google_android_gms_internal_zzdy) {
        com_google_android_gms_internal_zzdy.f6445m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", com_google_android_gms_internal_zzdy.f6435c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzdy)) {
            return false;
        }
        zzdy com_google_android_gms_internal_zzdy = (zzdy) obj;
        return this.f6433a == com_google_android_gms_internal_zzdy.f6433a && this.f6434b == com_google_android_gms_internal_zzdy.f6434b && C1313b.m4621a(this.f6435c, com_google_android_gms_internal_zzdy.f6435c) && this.f6436d == com_google_android_gms_internal_zzdy.f6436d && C1313b.m4621a(this.f6437e, com_google_android_gms_internal_zzdy.f6437e) && this.f6438f == com_google_android_gms_internal_zzdy.f6438f && this.f6439g == com_google_android_gms_internal_zzdy.f6439g && this.f6440h == com_google_android_gms_internal_zzdy.f6440h && C1313b.m4621a(this.f6441i, com_google_android_gms_internal_zzdy.f6441i) && C1313b.m4621a(this.f6442j, com_google_android_gms_internal_zzdy.f6442j) && C1313b.m4621a(this.f6443k, com_google_android_gms_internal_zzdy.f6443k) && C1313b.m4621a(this.f6444l, com_google_android_gms_internal_zzdy.f6444l) && C1313b.m4621a(this.f6445m, com_google_android_gms_internal_zzdy.f6445m) && C1313b.m4621a(this.f6446n, com_google_android_gms_internal_zzdy.f6446n) && C1313b.m4621a(this.f6447o, com_google_android_gms_internal_zzdy.f6447o) && C1313b.m4621a(this.f6448p, com_google_android_gms_internal_zzdy.f6448p) && C1313b.m4621a(this.f6449q, com_google_android_gms_internal_zzdy.f6449q) && this.f6450r == com_google_android_gms_internal_zzdy.f6450r;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6433a), Long.valueOf(this.f6434b), this.f6435c, Integer.valueOf(this.f6436d), this.f6437e, Boolean.valueOf(this.f6438f), Integer.valueOf(this.f6439g), Boolean.valueOf(this.f6440h), this.f6441i, this.f6442j, this.f6443k, this.f6444l, this.f6445m, this.f6446n, this.f6447o, this.f6448p, this.f6449q, Boolean.valueOf(this.f6450r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        gl.m6338a(this, parcel, i);
    }
}
