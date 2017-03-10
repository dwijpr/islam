package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class ga implements Creator<zzdo> {
    static void m6302a(zzdo com_google_android_gms_internal_zzdo, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzdo.f6425a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzdo.f6426b, false);
        C1355b.m4832a(parcel, 3, com_google_android_gms_internal_zzdo.f6427c);
        C1355b.m4838a(parcel, 4, com_google_android_gms_internal_zzdo.f6428d, false);
        C1355b.m4838a(parcel, 5, com_google_android_gms_internal_zzdo.f6429e, false);
        C1355b.m4838a(parcel, 6, com_google_android_gms_internal_zzdo.f6430f, false);
        C1355b.m4833a(parcel, 7, com_google_android_gms_internal_zzdo.f6431g, false);
        C1355b.m4841a(parcel, 8, com_google_android_gms_internal_zzdo.f6432h);
        C1355b.m4827a(parcel, a);
    }

    public zzdo m6303a(Parcel parcel) {
        boolean z = false;
        Bundle bundle = null;
        int b = C1354a.m4804b(parcel);
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    bundle = C1354a.m4819n(parcel, a);
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
            return new zzdo(i, str4, j, str3, str2, str, bundle, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzdo[] m6304a(int i) {
        return new zzdo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6303a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6304a(i);
    }
}
