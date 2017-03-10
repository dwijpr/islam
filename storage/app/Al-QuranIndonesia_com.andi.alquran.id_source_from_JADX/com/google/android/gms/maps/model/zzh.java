package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzh implements Creator<PointOfInterest> {
    static void m10077a(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, pointOfInterest.m10055a());
        C1355b.m4835a(parcel, 2, pointOfInterest.latLng, i, false);
        C1355b.m4838a(parcel, 3, pointOfInterest.placeId, false);
        C1355b.m4838a(parcel, 4, pointOfInterest.name, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzle(i);
    }

    public PointOfInterest zzhA(Parcel parcel) {
        String str = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str2 = null;
        LatLng latLng = null;
        while (parcel.dataPosition() < b) {
            LatLng latLng2;
            int f;
            String str3;
            int a = C1354a.m4798a(parcel);
            String str4;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str4 = str;
                    str = str2;
                    latLng2 = latLng;
                    f = C1354a.m4811f(parcel, a);
                    str3 = str4;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    str4 = str2;
                    latLng2 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    latLng2 = latLng;
                    f = i;
                    str4 = str;
                    str = C1354a.m4817l(parcel, a);
                    str3 = str4;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str3 = C1354a.m4817l(parcel, a);
                    str = str2;
                    latLng2 = latLng;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str3 = str;
                    str = str2;
                    latLng2 = latLng;
                    f = i;
                    break;
            }
            i = f;
            latLng = latLng2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == b) {
            return new PointOfInterest(i, latLng, str2, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public PointOfInterest[] zzle(int i) {
        return new PointOfInterest[i];
    }
}
