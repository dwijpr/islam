package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.j */
public class C2092j implements Creator<zzf> {
    static void m9841a(zzf com_google_android_gms_location_zzf, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4852c(parcel, 1, com_google_android_gms_location_zzf.m9895b(), false);
        C1355b.m4838a(parcel, 2, com_google_android_gms_location_zzf.m9896c(), false);
        C1355b.m4852c(parcel, 3, com_google_android_gms_location_zzf.m9897d(), false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zzf.m9894a());
        C1355b.m4827a(parcel, a);
    }

    public zzf m9842a(Parcel parcel) {
        List list = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        List list2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list2 = C1354a.m4807c(parcel, a, zzd.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    list = C1354a.m4807c(parcel, a, zzarj.CREATOR);
                    break;
                case 1000:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzf(i, list2, str, list);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzf[] m9843a(int i) {
        return new zzf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9842a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9843a(i);
    }
}
