package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public class zza implements Creator<GoogleMapOptions> {
    static void m10087a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, googleMapOptions.m9909a());
        C1355b.m4828a(parcel, 2, googleMapOptions.m9910b());
        C1355b.m4828a(parcel, 3, googleMapOptions.m9911c());
        C1355b.m4831a(parcel, 4, googleMapOptions.getMapType());
        C1355b.m4835a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C1355b.m4828a(parcel, 6, googleMapOptions.m9912d());
        C1355b.m4828a(parcel, 7, googleMapOptions.m9913e());
        C1355b.m4828a(parcel, 8, googleMapOptions.m9914f());
        C1355b.m4828a(parcel, 9, googleMapOptions.m9915g());
        C1355b.m4828a(parcel, 10, googleMapOptions.m9916h());
        C1355b.m4828a(parcel, 11, googleMapOptions.m9917i());
        C1355b.m4828a(parcel, 12, googleMapOptions.m9918j());
        C1355b.m4828a(parcel, 14, googleMapOptions.m9919k());
        C1355b.m4828a(parcel, 15, googleMapOptions.m9920l());
        C1355b.m4836a(parcel, 16, googleMapOptions.getMinZoomPreference(), false);
        C1355b.m4836a(parcel, 17, googleMapOptions.getMaxZoomPreference(), false);
        C1355b.m4835a(parcel, 18, googleMapOptions.getLatLngBoundsForCameraTarget(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkV(i);
    }

    public GoogleMapOptions zzhr(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        byte b2 = (byte) -1;
        byte b3 = (byte) -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        byte b12 = (byte) -1;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    b2 = C1354a.m4809d(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    b3 = C1354a.m4809d(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    cameraPosition = (CameraPosition) C1354a.m4800a(parcel, a, CameraPosition.CREATOR);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    b4 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    b5 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    b6 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    b7 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    b8 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    b9 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    b10 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    b11 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    b12 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    f = C1354a.m4815j(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    f2 = C1354a.m4815j(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    latLngBounds = (LatLngBounds) C1354a.m4800a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleMapOptions(i, b2, b3, i2, cameraPosition, b4, b5, b6, b7, b8, b9, b10, b11, b12, f, f2, latLngBounds);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public GoogleMapOptions[] zzkV(int i) {
        return new GoogleMapOptions[i];
    }
}
