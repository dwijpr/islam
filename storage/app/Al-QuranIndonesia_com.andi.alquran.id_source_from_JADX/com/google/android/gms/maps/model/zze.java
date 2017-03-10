package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zze implements Creator<LatLng> {
    static void m10074a(LatLng latLng, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, latLng.m10043a());
        C1355b.m4829a(parcel, 2, latLng.latitude);
        C1355b.m4829a(parcel, 3, latLng.longitude);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlb(i);
    }

    public LatLng zzhx(Parcel parcel) {
        double d = 0.0d;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    d2 = C1354a.m4816k(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    d = C1354a.m4816k(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LatLng(i, d2, d);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LatLng[] zzlb(int i) {
        return new LatLng[i];
    }
}
