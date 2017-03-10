package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class bx implements Creator<zzarv> {
    static void m5449a(zzarv com_google_android_gms_internal_zzarv, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4835a(parcel, 1, com_google_android_gms_internal_zzarv.f6374b, i, false);
        C1355b.m4841a(parcel, 4, com_google_android_gms_internal_zzarv.f6375c);
        C1355b.m4852c(parcel, 5, com_google_android_gms_internal_zzarv.f6376d, false);
        C1355b.m4838a(parcel, 6, com_google_android_gms_internal_zzarv.f6377e, false);
        C1355b.m4841a(parcel, 7, com_google_android_gms_internal_zzarv.f6378f);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_internal_zzarv.m9729a());
        C1355b.m4841a(parcel, 8, com_google_android_gms_internal_zzarv.f6379g);
        C1355b.m4827a(parcel, a);
    }

    public zzarv m5450a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = true;
        List list = zzarv.f6373a;
        boolean z3 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    locationRequest = (LocationRequest) C1354a.m4800a(parcel, a, LocationRequest.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    list = C1354a.m4807c(parcel, a, zzarj.CREATOR);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z = C1354a.m4808c(parcel, a);
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
            return new zzarv(i, locationRequest, z2, list, str, z3, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzarv[] m5451a(int i) {
        return new zzarv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5450a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5451a(i);
    }
}
