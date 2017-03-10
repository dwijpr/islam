package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.t */
public class C2102t implements Creator<LocationSettingsRequest> {
    static void m9868a(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4852c(parcel, 1, locationSettingsRequest.m9813b(), false);
        C1355b.m4841a(parcel, 2, locationSettingsRequest.m9814c());
        C1355b.m4841a(parcel, 3, locationSettingsRequest.m9815d());
        C1355b.m4835a(parcel, 5, locationSettingsRequest.m9816e(), i, false);
        C1355b.m4831a(parcel, 1000, locationSettingsRequest.m9812a());
        C1355b.m4827a(parcel, a);
    }

    public LocationSettingsRequest m9869a(Parcel parcel) {
        zzq com_google_android_gms_location_zzq = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list = C1354a.m4807c(parcel, a, LocationRequest.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    com_google_android_gms_location_zzq = (zzq) C1354a.m4800a(parcel, a, zzq.CREATOR);
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
            return new LocationSettingsRequest(i, list, z2, z, com_google_android_gms_location_zzq);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsRequest[] m9870a(int i) {
        return new LocationSettingsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9869a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9870a(i);
    }
}
