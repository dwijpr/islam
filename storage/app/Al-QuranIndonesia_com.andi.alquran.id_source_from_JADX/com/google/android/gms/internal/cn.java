package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class cn implements Creator<zzaxp> {
    static void m5566a(zzaxp com_google_android_gms_internal_zzaxp, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzaxp.f6408a);
        C1355b.m4831a(parcel, 2, com_google_android_gms_internal_zzaxp.m9752a());
        C1355b.m4835a(parcel, 3, com_google_android_gms_internal_zzaxp.m9754c(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzaxp m5567a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    intent = (Intent) C1354a.m4800a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaxp(i2, i, intent);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzaxp[] m5568a(int i) {
        return new zzaxp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5567a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5568a(i);
    }
}
