package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class hu implements Creator<zzfj> {
    static void m6632a(zzfj com_google_android_gms_internal_zzfj, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzfj.f6462a);
        C1355b.m4831a(parcel, 2, com_google_android_gms_internal_zzfj.f6463b);
        C1355b.m4831a(parcel, 3, com_google_android_gms_internal_zzfj.f6464c);
        C1355b.m4831a(parcel, 4, com_google_android_gms_internal_zzfj.f6465d);
        C1355b.m4831a(parcel, 5, com_google_android_gms_internal_zzfj.f6466e);
        C1355b.m4831a(parcel, 6, com_google_android_gms_internal_zzfj.f6467f);
        C1355b.m4831a(parcel, 7, com_google_android_gms_internal_zzfj.f6468g);
        C1355b.m4831a(parcel, 8, com_google_android_gms_internal_zzfj.f6469h);
        C1355b.m4831a(parcel, 9, com_google_android_gms_internal_zzfj.f6470i);
        C1355b.m4838a(parcel, 10, com_google_android_gms_internal_zzfj.f6471j, false);
        C1355b.m4831a(parcel, 11, com_google_android_gms_internal_zzfj.f6472k);
        C1355b.m4838a(parcel, 12, com_google_android_gms_internal_zzfj.f6473l, false);
        C1355b.m4831a(parcel, 13, com_google_android_gms_internal_zzfj.f6474m);
        C1355b.m4831a(parcel, 14, com_google_android_gms_internal_zzfj.f6475n);
        C1355b.m4838a(parcel, 15, com_google_android_gms_internal_zzfj.f6476o, false);
        C1355b.m4827a(parcel, a);
    }

    public zzfj m6633a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    i5 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    i6 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i7 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    i8 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    i9 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    i10 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    i11 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    i12 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzfj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzfj[] m6634a(int i) {
        return new zzfj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6633a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6634a(i);
    }
}
