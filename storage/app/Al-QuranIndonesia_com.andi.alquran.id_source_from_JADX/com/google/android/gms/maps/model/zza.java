package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zza implements Creator<CameraPosition> {
    static void m10070a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, cameraPosition.m10038a());
        C1355b.m4835a(parcel, 2, cameraPosition.target, i, false);
        C1355b.m4830a(parcel, 3, cameraPosition.zoom);
        C1355b.m4830a(parcel, 4, cameraPosition.tilt);
        C1355b.m4830a(parcel, 5, cameraPosition.bearing);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzht(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkX(i);
    }

    public CameraPosition zzht(Parcel parcel) {
        float f = 0.0f;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    latLng = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    f3 = C1354a.m4814i(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public CameraPosition[] zzkX(int i) {
        return new CameraPosition[i];
    }
}
