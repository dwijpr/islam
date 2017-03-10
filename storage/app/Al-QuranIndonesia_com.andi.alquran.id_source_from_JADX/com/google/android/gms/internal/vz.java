package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class vz implements Creator<zzzh> {
    static void m9607a(zzzh com_google_android_gms_internal_zzzh, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzzh.f6643a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzzh.f6644b, i, false);
        C1355b.m4842a(parcel, 3, com_google_android_gms_internal_zzzh.f6645c, false);
        C1355b.m4843a(parcel, 4, com_google_android_gms_internal_zzzh.f6646d, false);
        C1355b.m4845a(parcel, 5, com_google_android_gms_internal_zzzh.f6647e, false);
        C1355b.m4843a(parcel, 6, com_google_android_gms_internal_zzzh.f6648f, false);
        C1355b.m4846a(parcel, 7, com_google_android_gms_internal_zzzh.f6649g, false);
        C1355b.m4841a(parcel, 8, com_google_android_gms_internal_zzzh.f6650h);
        C1355b.m4827a(parcel, a);
    }

    public zzzh m9608a(Parcel parcel) {
        byte[][] bArr = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        zzawe com_google_android_gms_internal_zzawe = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    com_google_android_gms_internal_zzawe = (zzawe) C1354a.m4800a(parcel, a, zzawe.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    bArr2 = C1354a.m4820o(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    iArr2 = C1354a.m4822q(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    strArr = C1354a.m4823r(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    iArr = C1354a.m4822q(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    bArr = C1354a.m4821p(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzzh(i, com_google_android_gms_internal_zzawe, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzzh[] m9609a(int i) {
        return new zzzh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9608a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9609a(i);
    }
}
