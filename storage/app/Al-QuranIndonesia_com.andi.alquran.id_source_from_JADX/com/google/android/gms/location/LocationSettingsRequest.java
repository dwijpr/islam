package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends zza {
    public static final Creator<LocationSettingsRequest> CREATOR;
    private final int f6687a;
    private final List<LocationRequest> f6688b;
    private final boolean f6689c;
    private final boolean f6690d;
    private zzq f6691e;

    static {
        CREATOR = new C2102t();
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2, zzq com_google_android_gms_location_zzq) {
        this.f6687a = i;
        this.f6688b = list;
        this.f6689c = z;
        this.f6690d = z2;
        this.f6691e = com_google_android_gms_location_zzq;
    }

    public int m9812a() {
        return this.f6687a;
    }

    public List<LocationRequest> m9813b() {
        return Collections.unmodifiableList(this.f6688b);
    }

    public boolean m9814c() {
        return this.f6689c;
    }

    public boolean m9815d() {
        return this.f6690d;
    }

    public zzq m9816e() {
        return this.f6691e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2102t.m9868a(this, parcel, i);
    }
}
