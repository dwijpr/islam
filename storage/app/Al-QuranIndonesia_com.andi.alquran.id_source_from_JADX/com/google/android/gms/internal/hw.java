package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class hw implements Creator<zzfn> {
    static void m6639a(zzfn com_google_android_gms_internal_zzfn, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzfn.f6477a);
        C1355b.m4841a(parcel, 2, com_google_android_gms_internal_zzfn.f6478b);
        C1355b.m4827a(parcel, a);
    }

    public zzfn m6640a(Parcel parcel) {
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzfn(i, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzfn[] m6641a(int i) {
        return new zzfn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6640a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6641a(i);
    }
}
