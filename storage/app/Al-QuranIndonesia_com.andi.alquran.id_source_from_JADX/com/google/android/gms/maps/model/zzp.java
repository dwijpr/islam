package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzp implements Creator<TileOverlayOptions> {
    static void m10085a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, tileOverlayOptions.m10065a());
        C1355b.m4834a(parcel, 2, tileOverlayOptions.m10066b(), false);
        C1355b.m4841a(parcel, 3, tileOverlayOptions.isVisible());
        C1355b.m4830a(parcel, 4, tileOverlayOptions.getZIndex());
        C1355b.m4841a(parcel, 5, tileOverlayOptions.getFadeIn());
        C1355b.m4830a(parcel, 6, tileOverlayOptions.getTransparency());
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlm(i);
    }

    public TileOverlayOptions zzhI(Parcel parcel) {
        boolean z = false;
        float f = 0.0f;
        int b = C1354a.m4804b(parcel);
        IBinder iBinder = null;
        boolean z2 = true;
        float f2 = 0.0f;
        int i = 0;
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
                    z = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TileOverlayOptions(i, iBinder, z, f2, z2, f);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public TileOverlayOptions[] zzlm(int i) {
        return new TileOverlayOptions[i];
    }
}
