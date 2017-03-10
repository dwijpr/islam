package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzd implements Creator<LatLngBounds> {
    static void m10073a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, latLngBounds.m10051a());
        C1355b.m4835a(parcel, 2, latLngBounds.southwest, i, false);
        C1355b.m4835a(parcel, 3, latLngBounds.northeast, i, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzla(i);
    }

    public LatLngBounds zzhw(Parcel parcel) {
        LatLng latLng = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int f;
            LatLng latLng3;
            int a = C1354a.m4798a(parcel);
            LatLng latLng4;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    f = C1354a.m4811f(parcel, a);
                    latLng3 = latLng4;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    latLng4 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    latLng3 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    latLng = latLng2;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    latLng3 = latLng;
                    latLng = latLng2;
                    f = i;
                    break;
            }
            i = f;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == b) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LatLngBounds[] zzla(int i) {
        return new LatLngBounds[i];
    }
}
