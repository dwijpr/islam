package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class PointOfInterest extends zza {
    public static final Creator<PointOfInterest> CREATOR;
    private final int f6960a;
    public final LatLng latLng;
    public final String name;
    public final String placeId;

    static {
        CREATOR = new zzh();
    }

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.f6960a = i;
        this.latLng = latLng;
        this.placeId = str;
        this.name = str2;
    }

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this(1, latLng, str, str2);
    }

    int m10055a() {
        return this.f6960a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m10077a(this, parcel, i);
    }
}
