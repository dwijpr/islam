package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzn implements Creator<StreetViewPanoramaOrientation> {
    static void m10083a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, streetViewPanoramaOrientation.m10062a());
        C1355b.m4830a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C1355b.m4830a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlk(i);
    }

    public StreetViewPanoramaOrientation zzhG(Parcel parcel) {
        float f = 0.0f;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaOrientation[] zzlk(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
