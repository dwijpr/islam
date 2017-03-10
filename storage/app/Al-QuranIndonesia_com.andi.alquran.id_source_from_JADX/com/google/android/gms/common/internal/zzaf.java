package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1308t.C1309a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf extends zza {
    public static final Creator<zzaf> CREATOR;
    final int f3151a;
    IBinder f3152b;
    private ConnectionResult f3153c;
    private boolean f3154d;
    private boolean f3155e;

    static {
        CREATOR = new C1316e();
    }

    zzaf(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f3151a = i;
        this.f3152b = iBinder;
        this.f3153c = connectionResult;
        this.f3154d = z;
        this.f3155e = z2;
    }

    public C1308t m4871a() {
        return C1309a.m4615a(this.f3152b);
    }

    public ConnectionResult m4872b() {
        return this.f3153c;
    }

    public boolean m4873c() {
        return this.f3154d;
    }

    public boolean m4874d() {
        return this.f3155e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf com_google_android_gms_common_internal_zzaf = (zzaf) obj;
        return this.f3153c.equals(com_google_android_gms_common_internal_zzaf.f3153c) && m4871a().equals(com_google_android_gms_common_internal_zzaf.m4871a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1316e.m4639a(this, parcel, i);
    }
}
