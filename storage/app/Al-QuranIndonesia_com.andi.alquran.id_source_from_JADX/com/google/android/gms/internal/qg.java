package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class qg implements Creator<zznx> {
    static void m8278a(zznx com_google_android_gms_internal_zznx, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zznx.f6623a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zznx.f6624b, i, false);
        C1355b.m4838a(parcel, 3, com_google_android_gms_internal_zznx.f6625c, false);
        C1355b.m4827a(parcel, a);
    }

    public zznx m8279a(Parcel parcel) {
        String str = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        zzdy com_google_android_gms_internal_zzdy = null;
        while (parcel.dataPosition() < b) {
            zzdy com_google_android_gms_internal_zzdy2;
            int f;
            String str2;
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    String str3 = str;
                    com_google_android_gms_internal_zzdy2 = com_google_android_gms_internal_zzdy;
                    f = C1354a.m4811f(parcel, a);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    zzdy com_google_android_gms_internal_zzdy3 = (zzdy) C1354a.m4800a(parcel, a, zzdy.CREATOR);
                    str2 = str;
                    com_google_android_gms_internal_zzdy2 = com_google_android_gms_internal_zzdy3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str2 = C1354a.m4817l(parcel, a);
                    com_google_android_gms_internal_zzdy2 = com_google_android_gms_internal_zzdy;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str2 = str;
                    com_google_android_gms_internal_zzdy2 = com_google_android_gms_internal_zzdy;
                    f = i;
                    break;
            }
            i = f;
            com_google_android_gms_internal_zzdy = com_google_android_gms_internal_zzdy2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zznx(i, com_google_android_gms_internal_zzdy, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zznx[] m8280a(int i) {
        return new zznx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8279a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8280a(i);
    }
}
