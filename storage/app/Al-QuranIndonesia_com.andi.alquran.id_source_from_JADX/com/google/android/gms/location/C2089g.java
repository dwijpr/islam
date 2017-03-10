package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.g */
public class C2089g implements Creator<zza> {
    static void m9832a(zza com_google_android_gms_location_zza, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4832a(parcel, 1, com_google_android_gms_location_zza.m9880a());
        C1355b.m4841a(parcel, 2, com_google_android_gms_location_zza.m9881b());
        C1355b.m4835a(parcel, 3, com_google_android_gms_location_zza.m9882c(), i, false);
        C1355b.m4838a(parcel, 4, com_google_android_gms_location_zza.m9883d(), false);
        C1355b.m4843a(parcel, 5, com_google_android_gms_location_zza.m9884e(), false);
        C1355b.m4841a(parcel, 6, com_google_android_gms_location_zza.m9885f());
        C1355b.m4838a(parcel, 7, com_google_android_gms_location_zza.m9886g(), false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zza.m9888i());
        C1355b.m4832a(parcel, 8, com_google_android_gms_location_zza.m9887h());
        C1355b.m4827a(parcel, a);
    }

    public zza m9833a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int b = C1354a.m4804b(parcel);
        int[] iArr = null;
        String str2 = null;
        WorkSource workSource = null;
        boolean z2 = false;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    j2 = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    workSource = (WorkSource) C1354a.m4800a(parcel, a, WorkSource.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iArr = C1354a.m4822q(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    j = C1354a.m4813h(parcel, a);
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
            return new zza(i, j2, z2, workSource, str2, iArr, z, str, j);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zza[] m9834a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9833a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9834a(i);
    }
}
