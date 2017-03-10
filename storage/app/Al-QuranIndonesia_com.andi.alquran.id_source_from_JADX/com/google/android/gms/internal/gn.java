package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class gn implements Creator<zzec> {
    static void m6344a(zzec com_google_android_gms_internal_zzec, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzec.f6451a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzec.f6452b, false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzec.f6453c);
        C1355b.m4831a(parcel, 4, com_google_android_gms_internal_zzec.f6454d);
        C1355b.m4841a(parcel, 5, com_google_android_gms_internal_zzec.f6455e);
        C1355b.m4831a(parcel, 6, com_google_android_gms_internal_zzec.f6456f);
        C1355b.m4831a(parcel, 7, com_google_android_gms_internal_zzec.f6457g);
        C1355b.m4844a(parcel, 8, com_google_android_gms_internal_zzec.f6458h, i, false);
        C1355b.m4841a(parcel, 9, com_google_android_gms_internal_zzec.f6459i);
        C1355b.m4841a(parcel, 10, com_google_android_gms_internal_zzec.f6460j);
        C1355b.m4841a(parcel, 11, com_google_android_gms_internal_zzec.f6461k);
        C1355b.m4827a(parcel, a);
    }

    public zzec m6345a(Parcel parcel) {
        zzec[] com_google_android_gms_internal_zzecArr = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i5 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z4 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    com_google_android_gms_internal_zzecArr = (zzec[]) C1354a.m4806b(parcel, a, zzec.CREATOR);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzec(i5, str, i4, i3, z4, i2, i, com_google_android_gms_internal_zzecArr, z3, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzec[] m6346a(int i) {
        return new zzec[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6345a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6346a(i);
    }
}
