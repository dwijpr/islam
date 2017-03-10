package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb implements Creator<StreetViewPanoramaOptions> {
    static void m10088a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, streetViewPanoramaOptions.m9976a());
        C1355b.m4835a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C1355b.m4838a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C1355b.m4835a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C1355b.m4837a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C1355b.m4828a(parcel, 6, streetViewPanoramaOptions.m9977b());
        C1355b.m4828a(parcel, 7, streetViewPanoramaOptions.m9978c());
        C1355b.m4828a(parcel, 8, streetViewPanoramaOptions.m9979d());
        C1355b.m4828a(parcel, 9, streetViewPanoramaOptions.m9980e());
        C1355b.m4828a(parcel, 10, streetViewPanoramaOptions.m9981f());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkW(i);
    }

    public StreetViewPanoramaOptions zzhs(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int b2 = C1354a.m4804b(parcel);
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C1354a.m4800a(parcel, a, StreetViewPanoramaCamera.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    latLng = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    num = C1354a.m4812g(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    b6 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    b5 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    b4 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    b3 = C1354a.m4809d(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    b = C1354a.m4809d(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b6, b5, b4, b3, b);
        }
        throw new C1353a("Overread allowed size end=" + b2, parcel);
    }

    public StreetViewPanoramaOptions[] zzkW(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
