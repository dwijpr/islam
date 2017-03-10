package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;

public class StreetViewPanoramaLink extends zza {
    public static final Creator<StreetViewPanoramaLink> CREATOR;
    private final int f6983a;
    public final float bearing;
    public final String panoId;

    static {
        CREATOR = new zzl();
    }

    StreetViewPanoramaLink(int i, String str, float f) {
        this.f6983a = i;
        this.panoId = str;
        if (((double) f) <= 0.0d) {
            f = (f % 360.0f) + 360.0f;
        }
        this.bearing = f % 360.0f;
    }

    int m10060a() {
        return this.f6983a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    public int hashCode() {
        return C1313b.m4619a(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("panoId", this.panoId).m4618a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.m10081a(this, parcel, i);
    }
}
