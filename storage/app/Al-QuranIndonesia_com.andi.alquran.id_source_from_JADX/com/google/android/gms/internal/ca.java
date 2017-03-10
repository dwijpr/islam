package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class ca implements Creator<zzarz> {
    static void m5520a(zzarz com_google_android_gms_internal_zzarz, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4838a(parcel, 1, com_google_android_gms_internal_zzarz.m9747f(), false);
        C1355b.m4832a(parcel, 2, com_google_android_gms_internal_zzarz.m9748g());
        C1355b.m4840a(parcel, 3, com_google_android_gms_internal_zzarz.m9743b());
        C1355b.m4829a(parcel, 4, com_google_android_gms_internal_zzarz.m9744c());
        C1355b.m4829a(parcel, 5, com_google_android_gms_internal_zzarz.m9745d());
        C1355b.m4830a(parcel, 6, com_google_android_gms_internal_zzarz.m9746e());
        C1355b.m4831a(parcel, 7, com_google_android_gms_internal_zzarz.m9749h());
        C1355b.m4831a(parcel, 1000, com_google_android_gms_internal_zzarz.m9742a());
        C1355b.m4831a(parcel, 8, com_google_android_gms_internal_zzarz.m9750i());
        C1355b.m4831a(parcel, 9, com_google_android_gms_internal_zzarz.m9751j());
        C1355b.m4827a(parcel, a);
    }

    public zzarz m5521a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    s = C1354a.m4810e(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    d = C1354a.m4816k(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    d2 = C1354a.m4816k(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    i4 = C1354a.m4811f(parcel, a);
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
            return new zzarz(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzarz[] m5522a(int i) {
        return new zzarz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5521a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5522a(i);
    }
}
