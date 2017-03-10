package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.e */
public class C1316e implements Creator<zzaf> {
    static void m4639a(zzaf com_google_android_gms_common_internal_zzaf, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_common_internal_zzaf.f3151a);
        C1355b.m4834a(parcel, 2, com_google_android_gms_common_internal_zzaf.f3152b, false);
        C1355b.m4835a(parcel, 3, com_google_android_gms_common_internal_zzaf.m4872b(), i, false);
        C1355b.m4841a(parcel, 4, com_google_android_gms_common_internal_zzaf.m4873c());
        C1355b.m4841a(parcel, 5, com_google_android_gms_common_internal_zzaf.m4874d());
        C1355b.m4827a(parcel, a);
    }

    public zzaf m4640a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    connectionResult = (ConnectionResult) C1354a.m4800a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaf(i, iBinder, connectionResult, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzaf[] m4641a(int i) {
        return new zzaf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4640a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4641a(i);
    }
}
