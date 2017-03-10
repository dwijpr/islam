package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzc implements Creator<GroundOverlayOptions> {
    static void m10072a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, groundOverlayOptions.m10042b());
        C1355b.m4834a(parcel, 2, groundOverlayOptions.m10041a(), false);
        C1355b.m4835a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C1355b.m4830a(parcel, 4, groundOverlayOptions.getWidth());
        C1355b.m4830a(parcel, 5, groundOverlayOptions.getHeight());
        C1355b.m4835a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C1355b.m4830a(parcel, 7, groundOverlayOptions.getBearing());
        C1355b.m4830a(parcel, 8, groundOverlayOptions.getZIndex());
        C1355b.m4841a(parcel, 9, groundOverlayOptions.isVisible());
        C1355b.m4830a(parcel, 10, groundOverlayOptions.getTransparency());
        C1355b.m4830a(parcel, 11, groundOverlayOptions.getAnchorU());
        C1355b.m4830a(parcel, 12, groundOverlayOptions.getAnchorV());
        C1355b.m4841a(parcel, 13, groundOverlayOptions.isClickable());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkZ(i);
    }

    public GroundOverlayOptions zzhv(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    latLng = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    latLngBounds = (LatLngBounds) C1354a.m4800a(parcel, a, LatLngBounds.CREATOR);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    f3 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    f4 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    f5 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    f6 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    f7 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public GroundOverlayOptions[] zzkZ(int i) {
        return new GroundOverlayOptions[i];
    }
}
