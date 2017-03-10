package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class qv implements Creator<zzon> {
    static void m8356a(zzon com_google_android_gms_internal_zzon, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzon.f6629a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzon.f6630b, false);
        C1355b.m4838a(parcel, 3, com_google_android_gms_internal_zzon.f6631c, false);
        C1355b.m4841a(parcel, 4, com_google_android_gms_internal_zzon.f6632d);
        C1355b.m4841a(parcel, 5, com_google_android_gms_internal_zzon.f6633e);
        C1355b.m4850b(parcel, 6, com_google_android_gms_internal_zzon.f6634f, false);
        C1355b.m4827a(parcel, a);
    }

    public zzon m8357a(Parcel parcel) {
        List list = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    list = C1354a.m4825t(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzon(i, str2, str, z2, z, list);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzon[] m8358a(int i) {
        return new zzon[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8357a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8358a(i);
    }
}
