package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzarz;
import java.util.List;

public class GeofencingRequest extends zza {
    public static final Creator<GeofencingRequest> CREATOR;
    private final int f6666a;
    private final List<zzarz> f6667b;
    private final int f6668c;
    private final String f6669d;

    static {
        CREATOR = new C2094l();
    }

    GeofencingRequest(int i, List<zzarz> list, int i2, String str) {
        this.f6666a = i;
        this.f6667b = list;
        this.f6668c = i2;
        this.f6669d = str;
    }

    public int m9797a() {
        return this.f6666a;
    }

    public List<zzarz> m9798b() {
        return this.f6667b;
    }

    public int m9799c() {
        return this.f6668c;
    }

    public String m9800d() {
        return this.f6669d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2094l.m9847a(this, parcel, i);
    }
}
