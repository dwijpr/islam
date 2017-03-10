package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Status extends zza implements C1263g, ReflectedParcelable {
    public static final Creator<Status> CREATOR;
    public static final Status f2975a;
    public static final Status f2976b;
    public static final Status f2977c;
    public static final Status f2978d;
    public static final Status f2979e;
    public static final Status f2980f;
    public static final Status f2981g;
    final int f2982h;
    private final int f2983i;
    private final String f2984j;
    private final PendingIntent f2985k;

    static {
        f2975a = new Status(0);
        f2976b = new Status(14);
        f2977c = new Status(8);
        f2978d = new Status(15);
        f2979e = new Status(16);
        f2980f = new Status(17);
        f2981g = new Status(18);
        CREATOR = new C1291q();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f2982h = i;
        this.f2983i = i2;
        this.f2984j = str;
        this.f2985k = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    PendingIntent m4502a() {
        return this.f2985k;
    }

    public Status m4503b() {
        return this;
    }

    public String m4504c() {
        return this.f2984j;
    }

    public boolean m4505d() {
        return this.f2983i <= 0;
    }

    public int m4506e() {
        return this.f2983i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2982h == status.f2982h && this.f2983i == status.f2983i && C1313b.m4621a(this.f2984j, status.f2984j) && C1313b.m4621a(this.f2985k, status.f2985k);
    }

    public String m4507f() {
        return this.f2984j != null ? this.f2984j : C1275b.m4529a(this.f2983i);
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f2982h), Integer.valueOf(this.f2983i), this.f2984j, this.f2985k);
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("statusCode", m4507f()).m4618a("resolution", this.f2985k).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1291q.m4575a(this, parcel, i);
    }
}
