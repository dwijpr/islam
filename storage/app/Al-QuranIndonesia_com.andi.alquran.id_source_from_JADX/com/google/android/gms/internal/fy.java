package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class fy implements Creator<zzdl> {
    static void m6269a(zzdl com_google_android_gms_internal_zzdl, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzdl.f6423a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzdl.m9763c(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzdl m6270a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C1354a.m4800a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzdl(i, parcelFileDescriptor);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzdl[] m6271a(int i) {
        return new zzdl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6270a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6271a(i);
    }
}
