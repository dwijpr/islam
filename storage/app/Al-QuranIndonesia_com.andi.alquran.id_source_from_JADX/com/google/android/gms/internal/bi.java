package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class bi implements Creator<zzapx> {
    static void m5283a(zzapx com_google_android_gms_internal_zzapx, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzapx.f6364a);
        C1355b.m4842a(parcel, 2, com_google_android_gms_internal_zzapx.m9722a(), false);
        C1355b.m4827a(parcel, a);
    }

    public zzapx m5284a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    bArr = C1354a.m4820o(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzapx(i, bArr);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzapx[] m5285a(int i) {
        return new zzapx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5284a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5285a(i);
    }
}
