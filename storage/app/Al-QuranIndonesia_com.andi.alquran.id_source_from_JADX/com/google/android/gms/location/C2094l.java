package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.internal.zzarz;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.l */
public class C2094l implements Creator<GeofencingRequest> {
    static void m9847a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4852c(parcel, 1, geofencingRequest.m9798b(), false);
        C1355b.m4831a(parcel, 2, geofencingRequest.m9799c());
        C1355b.m4838a(parcel, 3, geofencingRequest.m9800d(), false);
        C1355b.m4831a(parcel, 1000, geofencingRequest.m9797a());
        C1355b.m4827a(parcel, a);
    }

    public GeofencingRequest m9848a(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        List list = null;
        String str = BuildConfig.VERSION_NAME;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list = C1354a.m4807c(parcel, a, zzarz.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str = C1354a.m4817l(parcel, a);
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
            return new GeofencingRequest(i2, list, i, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public GeofencingRequest[] m9849a(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9848a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9849a(i);
    }
}
