package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class bn implements Creator<zzarj> {
    static void m5314a(zzarj com_google_android_gms_internal_zzarj, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzarj.f6367a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzarj.f6368b, false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_internal_zzarj.m9724a());
        C1355b.m4827a(parcel, a);
    }

    public zzarj m5315a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
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
            return new zzarj(i2, i, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzarj[] m5316a(int i) {
        return new zzarj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5315a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5316a(i);
    }
}
