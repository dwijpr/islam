package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.br.C1479a;
import com.google.android.gms.location.C1493n;
import com.google.android.gms.location.C1493n.C1494a;
import com.google.android.gms.location.C1497o;
import com.google.android.gms.location.C1497o.C1498a;

public class zzarx extends zza {
    public static final Creator<zzarx> CREATOR;
    int f6381a;
    zzarv f6382b;
    C1497o f6383c;
    PendingIntent f6384d;
    C1493n f6385e;
    br f6386f;
    private final int f6387g;

    static {
        CREATOR = new by();
    }

    zzarx(int i, int i2, zzarv com_google_android_gms_internal_zzarv, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        br brVar = null;
        this.f6387g = i;
        this.f6381a = i2;
        this.f6382b = com_google_android_gms_internal_zzarv;
        this.f6383c = iBinder == null ? null : C1498a.m5438a(iBinder);
        this.f6384d = pendingIntent;
        this.f6385e = iBinder2 == null ? null : C1494a.m5431a(iBinder2);
        if (iBinder3 != null) {
            brVar = C1479a.m5330a(iBinder3);
        }
        this.f6386f = brVar;
    }

    public static zzarx m9730a(zzarv com_google_android_gms_internal_zzarv, C1497o c1497o, br brVar) {
        return new zzarx(1, 1, com_google_android_gms_internal_zzarv, c1497o.asBinder(), null, null, brVar != null ? brVar.asBinder() : null);
    }

    public static zzarx m9731a(C1493n c1493n, br brVar) {
        return new zzarx(1, 2, null, null, null, c1493n.asBinder(), brVar != null ? brVar.asBinder() : null);
    }

    public static zzarx m9732a(C1497o c1497o, br brVar) {
        return new zzarx(1, 2, null, c1497o.asBinder(), null, null, brVar != null ? brVar.asBinder() : null);
    }

    int m9733a() {
        return this.f6387g;
    }

    IBinder m9734b() {
        return this.f6383c == null ? null : this.f6383c.asBinder();
    }

    IBinder m9735c() {
        return this.f6385e == null ? null : this.f6385e.asBinder();
    }

    IBinder m9736d() {
        return this.f6386f == null ? null : this.f6386f.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        by.m5452a(this, parcel, i);
    }
}
