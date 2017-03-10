package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class gl implements Creator<zzdy> {
    static void m6338a(zzdy com_google_android_gms_internal_zzdy, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzdy.f6433a);
        C1355b.m4832a(parcel, 2, com_google_android_gms_internal_zzdy.f6434b);
        C1355b.m4833a(parcel, 3, com_google_android_gms_internal_zzdy.f6435c, false);
        C1355b.m4831a(parcel, 4, com_google_android_gms_internal_zzdy.f6436d);
        C1355b.m4850b(parcel, 5, com_google_android_gms_internal_zzdy.f6437e, false);
        C1355b.m4841a(parcel, 6, com_google_android_gms_internal_zzdy.f6438f);
        C1355b.m4831a(parcel, 7, com_google_android_gms_internal_zzdy.f6439g);
        C1355b.m4841a(parcel, 8, com_google_android_gms_internal_zzdy.f6440h);
        C1355b.m4838a(parcel, 9, com_google_android_gms_internal_zzdy.f6441i, false);
        C1355b.m4835a(parcel, 10, com_google_android_gms_internal_zzdy.f6442j, i, false);
        C1355b.m4835a(parcel, 11, com_google_android_gms_internal_zzdy.f6443k, i, false);
        C1355b.m4838a(parcel, 12, com_google_android_gms_internal_zzdy.f6444l, false);
        C1355b.m4833a(parcel, 13, com_google_android_gms_internal_zzdy.f6445m, false);
        C1355b.m4833a(parcel, 14, com_google_android_gms_internal_zzdy.f6446n, false);
        C1355b.m4850b(parcel, 15, com_google_android_gms_internal_zzdy.f6447o, false);
        C1355b.m4838a(parcel, 16, com_google_android_gms_internal_zzdy.f6448p, false);
        C1355b.m4838a(parcel, 17, com_google_android_gms_internal_zzdy.f6449q, false);
        C1355b.m4841a(parcel, 18, com_google_android_gms_internal_zzdy.f6450r);
        C1355b.m4827a(parcel, a);
    }

    public zzdy m6339a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzfj com_google_android_gms_internal_zzfj = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    bundle = C1354a.m4819n(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    list = C1354a.m4825t(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    com_google_android_gms_internal_zzfj = (zzfj) C1354a.m4800a(parcel, a, zzfj.CREATOR);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    location = (Location) C1354a.m4800a(parcel, a, Location.CREATOR);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    bundle2 = C1354a.m4819n(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    bundle3 = C1354a.m4819n(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    list2 = C1354a.m4825t(parcel, a);
                    break;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzdy(i, j, bundle, i2, list, z, i3, z2, str, com_google_android_gms_internal_zzfj, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzdy[] m6340a(int i) {
        return new zzdy[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6339a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6340a(i);
    }
}
