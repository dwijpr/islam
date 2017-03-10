package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzg implements Creator<MarkerOptions> {
    static void m10076a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, markerOptions.m10053a());
        C1355b.m4835a(parcel, 2, markerOptions.getPosition(), i, false);
        C1355b.m4838a(parcel, 3, markerOptions.getTitle(), false);
        C1355b.m4838a(parcel, 4, markerOptions.getSnippet(), false);
        C1355b.m4834a(parcel, 5, markerOptions.m10054b(), false);
        C1355b.m4830a(parcel, 6, markerOptions.getAnchorU());
        C1355b.m4830a(parcel, 7, markerOptions.getAnchorV());
        C1355b.m4841a(parcel, 8, markerOptions.isDraggable());
        C1355b.m4841a(parcel, 9, markerOptions.isVisible());
        C1355b.m4841a(parcel, 10, markerOptions.isFlat());
        C1355b.m4830a(parcel, 11, markerOptions.getRotation());
        C1355b.m4830a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C1355b.m4830a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C1355b.m4830a(parcel, 14, markerOptions.getAlpha());
        C1355b.m4830a(parcel, 15, markerOptions.getZIndex());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzld(i);
    }

    public MarkerOptions zzhz(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
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
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    f3 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    f4 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    f5 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    f6 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    f7 = C1354a.m4814i(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6, f7);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public MarkerOptions[] zzld(int i) {
        return new MarkerOptions[i];
    }
}
