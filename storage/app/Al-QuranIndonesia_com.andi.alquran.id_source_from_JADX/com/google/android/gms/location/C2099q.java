package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.q */
public class C2099q implements Creator<LocationRequest> {
    static void m9859a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, locationRequest.f6675a);
        C1355b.m4832a(parcel, 2, locationRequest.f6676b);
        C1355b.m4832a(parcel, 3, locationRequest.f6677c);
        C1355b.m4841a(parcel, 4, locationRequest.f6678d);
        C1355b.m4832a(parcel, 5, locationRequest.f6679e);
        C1355b.m4831a(parcel, 6, locationRequest.f6680f);
        C1355b.m4830a(parcel, 7, locationRequest.f6681g);
        C1355b.m4831a(parcel, 1000, locationRequest.m9809b());
        C1355b.m4832a(parcel, 8, locationRequest.f6682h);
        C1355b.m4827a(parcel, a);
    }

    public LocationRequest m9860a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        int i2 = C0861R.styleable.AppCompatTheme_buttonStyle;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    j2 = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    j3 = C1354a.m4813h(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    j4 = C1354a.m4813h(parcel, a);
                    break;
                case 1000:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationRequest[] m9861a(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9860a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9861a(i);
    }
}
