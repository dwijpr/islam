package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class oz implements Creator<zzmo> {
    static void m7993a(zzmo com_google_android_gms_internal_zzmo, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzmo.f6611a);
        C1355b.m4841a(parcel, 2, com_google_android_gms_internal_zzmo.f6612b);
        C1355b.m4841a(parcel, 3, com_google_android_gms_internal_zzmo.f6613c);
        C1355b.m4841a(parcel, 4, com_google_android_gms_internal_zzmo.f6614d);
        C1355b.m4827a(parcel, a);
    }

    public zzmo m7994a(Parcel parcel) {
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmo(i, z3, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzmo[] m7995a(int i) {
        return new zzmo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7994a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7995a(i);
    }
}
