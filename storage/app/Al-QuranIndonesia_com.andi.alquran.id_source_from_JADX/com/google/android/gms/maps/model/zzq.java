package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzq implements Creator<VisibleRegion> {
    static void m10086a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, visibleRegion.m10069a());
        C1355b.m4835a(parcel, 2, visibleRegion.nearLeft, i, false);
        C1355b.m4835a(parcel, 3, visibleRegion.nearRight, i, false);
        C1355b.m4835a(parcel, 4, visibleRegion.farLeft, i, false);
        C1355b.m4835a(parcel, 5, visibleRegion.farRight, i, false);
        C1355b.m4835a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzln(i);
    }

    public VisibleRegion zzhJ(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    latLng4 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    latLng3 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    latLng2 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    latLng = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    latLngBounds = (LatLngBounds) C1354a.m4800a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public VisibleRegion[] zzln(int i) {
        return new VisibleRegion[i];
    }
}
