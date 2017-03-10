package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.List;

public class zzi implements Creator<PolygonOptions> {
    static void m10078a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, polygonOptions.m10056a());
        C1355b.m4852c(parcel, 2, polygonOptions.getPoints(), false);
        C1355b.m4853d(parcel, 3, polygonOptions.m10057b(), false);
        C1355b.m4830a(parcel, 4, polygonOptions.getStrokeWidth());
        C1355b.m4831a(parcel, 5, polygonOptions.getStrokeColor());
        C1355b.m4831a(parcel, 6, polygonOptions.getFillColor());
        C1355b.m4830a(parcel, 7, polygonOptions.getZIndex());
        C1355b.m4841a(parcel, 8, polygonOptions.isVisible());
        C1355b.m4841a(parcel, 9, polygonOptions.isGeodesic());
        C1355b.m4841a(parcel, 10, polygonOptions.isClickable());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlf(i);
    }

    public PolygonOptions zzhB(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    list = C1354a.m4807c(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    C1354a.m4803a(parcel, a, arrayList, getClass().getClassLoader());
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z3, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public PolygonOptions[] zzlf(int i) {
        return new PolygonOptions[i];
    }
}
