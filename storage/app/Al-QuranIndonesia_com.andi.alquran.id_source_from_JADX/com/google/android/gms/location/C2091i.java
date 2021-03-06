package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.i */
public class C2091i implements Creator<zzd> {
    static void m9838a(zzd com_google_android_gms_location_zzd, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_location_zzd.m9890b());
        C1355b.m4831a(parcel, 2, com_google_android_gms_location_zzd.m9891c());
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zzd.m9889a());
        C1355b.m4827a(parcel, a);
    }

    public zzd m9839a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case 1000:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzd(i3, i2, i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzd[] m9840a(int i) {
        return new zzd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9839a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9840a(i);
    }
}
