package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzn implements Creator<zzm> {
    static void m4094a(zzm com_google_android_gms_ads_internal_zzm, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_ads_internal_zzm.versionCode);
        C1355b.m4841a(parcel, 2, com_google_android_gms_ads_internal_zzm.zztH);
        C1355b.m4841a(parcel, 3, com_google_android_gms_ads_internal_zzm.zztI);
        C1355b.m4838a(parcel, 4, com_google_android_gms_ads_internal_zzm.zztJ, false);
        C1355b.m4841a(parcel, 5, com_google_android_gms_ads_internal_zzm.zztK);
        C1355b.m4830a(parcel, 6, com_google_android_gms_ads_internal_zzm.zztL);
        C1355b.m4831a(parcel, 7, com_google_android_gms_ads_internal_zzm.zztM);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzi(i);
    }

    public zzm zzb(Parcel parcel) {
        int i = 0;
        int b = C1354a.m4804b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzm(i2, z3, z2, str, z, f, i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzm[] zzi(int i) {
        return new zzm[i];
    }
}
