package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class zzarv extends zza {
    public static final Creator<zzarv> CREATOR;
    static final List<zzarj> f6373a;
    LocationRequest f6374b;
    boolean f6375c;
    List<zzarj> f6376d;
    String f6377e;
    boolean f6378f;
    boolean f6379g;
    private final int f6380h;

    static {
        f6373a = Collections.emptyList();
        CREATOR = new bx();
    }

    zzarv(int i, LocationRequest locationRequest, boolean z, List<zzarj> list, String str, boolean z2, boolean z3) {
        this.f6380h = i;
        this.f6374b = locationRequest;
        this.f6375c = z;
        this.f6376d = list;
        this.f6377e = str;
        this.f6378f = z2;
        this.f6379g = z3;
    }

    @Deprecated
    public static zzarv m9727a(LocationRequest locationRequest) {
        return m9728a(null, locationRequest);
    }

    public static zzarv m9728a(String str, LocationRequest locationRequest) {
        return new zzarv(1, locationRequest, true, f6373a, str, false, false);
    }

    int m9729a() {
        return this.f6380h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzarv)) {
            return false;
        }
        zzarv com_google_android_gms_internal_zzarv = (zzarv) obj;
        return C1313b.m4621a(this.f6374b, com_google_android_gms_internal_zzarv.f6374b) && this.f6375c == com_google_android_gms_internal_zzarv.f6375c && this.f6378f == com_google_android_gms_internal_zzarv.f6378f && C1313b.m4621a(this.f6376d, com_google_android_gms_internal_zzarv.f6376d) && this.f6379g == com_google_android_gms_internal_zzarv.f6379g;
    }

    public int hashCode() {
        return this.f6374b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f6374b.toString());
        if (this.f6377e != null) {
            stringBuilder.append(" tag=").append(this.f6377e);
        }
        stringBuilder.append(" trigger=").append(this.f6375c);
        stringBuilder.append(" hideAppOps=").append(this.f6378f);
        stringBuilder.append(" clients=").append(this.f6376d);
        stringBuilder.append(" forceCoarseLocation=").append(this.f6379g);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bx.m5449a(this, parcel, i);
    }
}
