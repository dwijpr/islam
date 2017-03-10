package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class pe implements Creator<zzmv> {
    static void m8090a(zzmv com_google_android_gms_internal_zzmv, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzmv.f6621a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzmv.f6622b, false);
        C1355b.m4827a(parcel, a);
    }

    public zzmv m8091a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmv(i, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzmv[] m8092a(int i) {
        return new zzmv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8091a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8092a(i);
    }
}
