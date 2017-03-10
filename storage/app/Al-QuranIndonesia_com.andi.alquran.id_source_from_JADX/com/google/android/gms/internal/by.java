package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class by implements Creator<zzarx> {
    static void m5452a(zzarx com_google_android_gms_internal_zzarx, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzarx.f6381a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzarx.f6382b, i, false);
        C1355b.m4834a(parcel, 3, com_google_android_gms_internal_zzarx.m9734b(), false);
        C1355b.m4835a(parcel, 4, com_google_android_gms_internal_zzarx.f6384d, i, false);
        C1355b.m4834a(parcel, 5, com_google_android_gms_internal_zzarx.m9735c(), false);
        C1355b.m4834a(parcel, 6, com_google_android_gms_internal_zzarx.m9736d(), false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_internal_zzarx.m9733a());
        C1355b.m4827a(parcel, a);
    }

    public zzarx m5453a(Parcel parcel) {
        IBinder iBinder = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        zzarv com_google_android_gms_internal_zzarv = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    com_google_android_gms_internal_zzarv = (zzarv) C1354a.m4800a(parcel, a, zzarv.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    iBinder3 = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    pendingIntent = (PendingIntent) C1354a.m4800a(parcel, a, PendingIntent.CREATOR);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iBinder2 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    iBinder = C1354a.m4818m(parcel, a);
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
            return new zzarx(i, i2, com_google_android_gms_internal_zzarv, iBinder3, pendingIntent, iBinder2, iBinder);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzarx[] m5454a(int i) {
        return new zzarx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5453a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5454a(i);
    }
}
