package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class zzj implements Creator<PolylineOptions> {
    static void m10079a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, polylineOptions.m10058a());
        C1355b.m4852c(parcel, 2, polylineOptions.getPoints(), false);
        C1355b.m4830a(parcel, 3, polylineOptions.getWidth());
        C1355b.m4831a(parcel, 4, polylineOptions.getColor());
        C1355b.m4830a(parcel, 5, polylineOptions.getZIndex());
        C1355b.m4841a(parcel, 6, polylineOptions.isVisible());
        C1355b.m4841a(parcel, 7, polylineOptions.isGeodesic());
        C1355b.m4841a(parcel, 8, polylineOptions.isClickable());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlg(i);
    }

    public PolylineOptions zzhC(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        List list = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    list = C1354a.m4807c(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolylineOptions(i2, list, f2, i, f, z3, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public PolylineOptions[] zzlg(int i) {
        return new PolylineOptions[i];
    }
}
