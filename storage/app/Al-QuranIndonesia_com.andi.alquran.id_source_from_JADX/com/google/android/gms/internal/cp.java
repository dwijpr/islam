package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class cp implements Creator<zzaxs> {
    static void m5569a(zzaxs com_google_android_gms_internal_zzaxs, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzaxs.f6411a);
        C1355b.m4841a(parcel, 2, com_google_android_gms_internal_zzaxs.f6412b);
        C1355b.m4852c(parcel, 3, com_google_android_gms_internal_zzaxs.f6413c, false);
        C1355b.m4827a(parcel, a);
    }

    public zzaxs m5570a(Parcel parcel) {
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        List list = null;
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
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    list = C1354a.m4807c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaxs(i, z, list);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzaxs[] m5571a(int i) {
        return new zzaxs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5570a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5571a(i);
    }
}
