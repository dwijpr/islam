package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzl implements Creator<StreetViewPanoramaLink> {
    static void m10081a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, streetViewPanoramaLink.m10060a());
        C1355b.m4838a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C1355b.m4830a(parcel, 3, streetViewPanoramaLink.bearing);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzli(i);
    }

    public StreetViewPanoramaLink zzhE(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaLink[] zzli(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
