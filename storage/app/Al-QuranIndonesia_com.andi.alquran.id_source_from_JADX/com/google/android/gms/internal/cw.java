package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.maps.GoogleMap;

public class cw implements Creator<zzayb> {
    static void m5655a(zzayb com_google_android_gms_internal_zzayb, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzayb.f6420a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzayb.m9759a(), i, false);
        C1355b.m4835a(parcel, 3, com_google_android_gms_internal_zzayb.m9760b(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzayb m5656a(Parcel parcel) {
        zzaf com_google_android_gms_common_internal_zzaf = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int f;
            zzaf com_google_android_gms_common_internal_zzaf2;
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    zzaf com_google_android_gms_common_internal_zzaf3 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    f = C1354a.m4811f(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C1354a.m4800a(parcel, a, ConnectionResult.CREATOR);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    com_google_android_gms_common_internal_zzaf2 = (zzaf) C1354a.m4800a(parcel, a, zzaf.CREATOR);
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
            }
            i = f;
            connectionResult = connectionResult2;
            com_google_android_gms_common_internal_zzaf = com_google_android_gms_common_internal_zzaf2;
        }
        if (parcel.dataPosition() == b) {
            return new zzayb(i, connectionResult, com_google_android_gms_common_internal_zzaf);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzayb[] m5657a(int i) {
        return new zzayb[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5656a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5657a(i);
    }
}
