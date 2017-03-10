package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class ci implements Creator<zzawe> {
    static void m5540a(zzawe com_google_android_gms_internal_zzawe, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzawe.f6398a);
        C1355b.m4838a(parcel, 2, com_google_android_gms_internal_zzawe.f6399b, false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzawe.f6400c);
        C1355b.m4831a(parcel, 4, com_google_android_gms_internal_zzawe.f6401d);
        C1355b.m4838a(parcel, 5, com_google_android_gms_internal_zzawe.f6402e, false);
        C1355b.m4838a(parcel, 6, com_google_android_gms_internal_zzawe.f6403f, false);
        C1355b.m4841a(parcel, 7, com_google_android_gms_internal_zzawe.f6404g);
        C1355b.m4838a(parcel, 8, com_google_android_gms_internal_zzawe.f6405h, false);
        C1355b.m4841a(parcel, 9, com_google_android_gms_internal_zzawe.f6406i);
        C1355b.m4831a(parcel, 10, com_google_android_gms_internal_zzawe.f6407j);
        C1355b.m4827a(parcel, a);
    }

    public zzawe m5541a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C1354a.m4804b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzawe(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzawe[] m5542a(int i) {
        return new zzawe[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5541a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5542a(i);
    }
}
