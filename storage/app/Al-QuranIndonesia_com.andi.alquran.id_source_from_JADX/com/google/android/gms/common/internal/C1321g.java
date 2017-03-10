package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.g */
public class C1321g implements Creator<zzan> {
    static void m4698a(zzan com_google_android_gms_common_internal_zzan, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_common_internal_zzan.f3156a);
        C1355b.m4827a(parcel, a);
    }

    public zzan m4699a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzan(i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzan[] m4700a(int i) {
        return new zzan[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4699a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4700a(i);
    }
}
