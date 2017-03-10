package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class bh implements Creator<zzapv> {
    static void m5280a(zzapv com_google_android_gms_internal_zzapv, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzapv.f6361a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzapv.f6362b, false);
        C1355b.m4838a(parcel, 3, com_google_android_gms_internal_zzapv.f6363c, false);
        C1355b.m4827a(parcel, a);
    }

    public zzapv m5281a(Parcel parcel) {
        String str = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzapv(i, str2, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzapv[] m5282a(int i) {
        return new zzapv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5281a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5282a(i);
    }
}
