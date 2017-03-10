package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.maps.GoogleMap;

public class cv implements Creator<zzaxz> {
    static void m5652a(zzaxz com_google_android_gms_internal_zzaxz, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzaxz.f6418a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzaxz.m9758a(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzaxz m5653a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        zzad com_google_android_gms_common_internal_zzad = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    com_google_android_gms_common_internal_zzad = (zzad) C1354a.m4800a(parcel, a, zzad.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaxz(i, com_google_android_gms_common_internal_zzad);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzaxz[] m5654a(int i) {
        return new zzaxz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5653a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5654a(i);
    }
}
