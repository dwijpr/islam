package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.s */
public class C2101s implements Creator<zzq> {
    static void m9865a(zzq com_google_android_gms_location_zzq, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4838a(parcel, 1, com_google_android_gms_location_zzq.m9901b(), false);
        C1355b.m4838a(parcel, 2, com_google_android_gms_location_zzq.m9902c(), false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_location_zzq.m9903d());
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zzq.m9900a());
        C1355b.m4827a(parcel, a);
    }

    public zzq m9866a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        String str = BuildConfig.VERSION_NAME;
        String str2 = BuildConfig.VERSION_NAME;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case 1000:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzq(i2, str, str2, i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzq[] m9867a(int i) {
        return new zzq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9866a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9867a(i);
    }
}
