package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzb implements Creator<CircleOptions> {
    static void m10071a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, circleOptions.m10039a());
        C1355b.m4835a(parcel, 2, circleOptions.getCenter(), i, false);
        C1355b.m4829a(parcel, 3, circleOptions.getRadius());
        C1355b.m4830a(parcel, 4, circleOptions.getStrokeWidth());
        C1355b.m4831a(parcel, 5, circleOptions.getStrokeColor());
        C1355b.m4831a(parcel, 6, circleOptions.getFillColor());
        C1355b.m4830a(parcel, 7, circleOptions.getZIndex());
        C1355b.m4841a(parcel, 8, circleOptions.isVisible());
        C1355b.m4841a(parcel, 9, circleOptions.isClickable());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkY(i);
    }

    public CircleOptions zzhu(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        boolean z2 = false;
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
                    latLng = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    d = C1354a.m4816k(parcel, a);
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
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public CircleOptions[] zzkY(int i) {
        return new CircleOptions[i];
    }
}
