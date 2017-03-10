package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class sj implements Creator<zzqa> {
    static void m8710a(zzqa com_google_android_gms_internal_zzqa, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzqa.f6635a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzqa.f6636b, false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzqa.f6637c);
        C1355b.m4831a(parcel, 4, com_google_android_gms_internal_zzqa.f6638d);
        C1355b.m4841a(parcel, 5, com_google_android_gms_internal_zzqa.f6639e);
        C1355b.m4827a(parcel, a);
    }

    public zzqa m8711a(Parcel parcel) {
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzqa(i3, str, i2, i, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzqa[] m8712a(int i) {
        return new zzqa[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8711a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8712a(i);
    }
}
