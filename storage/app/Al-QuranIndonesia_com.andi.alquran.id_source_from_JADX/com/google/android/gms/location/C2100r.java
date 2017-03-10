package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.r */
public class C2100r implements Creator<LocationResult> {
    static void m9862a(LocationResult locationResult, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4852c(parcel, 1, locationResult.m9810a(), false);
        C1355b.m4831a(parcel, 1000, locationResult.m9811b());
        C1355b.m4827a(parcel, a);
    }

    public LocationResult m9863a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        List list = LocationResult.f6684a;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list = C1354a.m4807c(parcel, a, Location.CREATOR);
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
            return new LocationResult(i, list);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationResult[] m9864a(int i) {
        return new LocationResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9863a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9864a(i);
    }
}
