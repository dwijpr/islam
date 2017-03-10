package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzf implements Creator<MapStyleOptions> {
    static void m10075a(MapStyleOptions mapStyleOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, mapStyleOptions.m10052a());
        C1355b.m4838a(parcel, 2, mapStyleOptions.zzIU(), false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlc(i);
    }

    public MapStyleOptions zzhy(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MapStyleOptions(i, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public MapStyleOptions[] zzlc(int i) {
        return new MapStyleOptions[i];
    }
}
