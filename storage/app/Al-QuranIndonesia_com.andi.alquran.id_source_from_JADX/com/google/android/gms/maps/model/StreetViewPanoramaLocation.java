package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;

public class StreetViewPanoramaLocation extends zza {
    public static final Creator<StreetViewPanoramaLocation> CREATOR;
    private final int f6984a;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    static {
        CREATOR = new zzm();
    }

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f6984a = i;
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this(1, streetViewPanoramaLinkArr, latLng, str);
    }

    int m10061a() {
        return this.f6984a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    public int hashCode() {
        return C1313b.m4619a(this.position, this.panoId);
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("panoId", this.panoId).m4618a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.m10082a(this, parcel, i);
    }
}
