package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class jf implements Creator<zzgw> {
    static void m6976a(zzgw com_google_android_gms_internal_zzgw, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzgw.f6479a);
        C1355b.m4841a(parcel, 2, com_google_android_gms_internal_zzgw.f6480b);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzgw.f6481c);
        C1355b.m4841a(parcel, 4, com_google_android_gms_internal_zzgw.f6482d);
        C1355b.m4831a(parcel, 5, com_google_android_gms_internal_zzgw.f6483e);
        C1355b.m4835a(parcel, 6, com_google_android_gms_internal_zzgw.f6484f, i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzgw m6977a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        zzfn com_google_android_gms_internal_zzfn = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    com_google_android_gms_internal_zzfn = (zzfn) C1354a.m4800a(parcel, a, zzfn.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzgw(i3, z2, i2, z, i, com_google_android_gms_internal_zzfn);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzgw[] m6978a(int i) {
        return new zzgw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6977a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6978a(i);
    }
}
