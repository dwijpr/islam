package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.p */
public class C2098p implements Creator<LocationAvailability> {
    static void m9856a(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, locationAvailability.f6670a);
        C1355b.m4831a(parcel, 2, locationAvailability.f6671b);
        C1355b.m4832a(parcel, 3, locationAvailability.f6672c);
        C1355b.m4831a(parcel, 4, locationAvailability.f6673d);
        C1355b.m4831a(parcel, 1000, locationAvailability.m9802b());
        C1355b.m4827a(parcel, a);
    }

    public LocationAvailability m9857a(Parcel parcel) {
        int i = 1;
        int b = C1354a.m4804b(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i3 = C1354a.m4811f(parcel, a);
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
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationAvailability[] m9858a(int i) {
        return new LocationAvailability[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9857a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9858a(i);
    }
}
