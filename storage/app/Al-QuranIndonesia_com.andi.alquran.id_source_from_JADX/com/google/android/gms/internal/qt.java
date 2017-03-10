package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class qt implements Creator<zzok> {
    static void m8353a(zzok com_google_android_gms_internal_zzok, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzok.f6626a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzok.f6627b, false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzok.f6628c);
        C1355b.m4827a(parcel, a);
    }

    public zzok m8354a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzok(i2, str, i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzok[] m8355a(int i) {
        return new zzok[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8354a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8355a(i);
    }
}
