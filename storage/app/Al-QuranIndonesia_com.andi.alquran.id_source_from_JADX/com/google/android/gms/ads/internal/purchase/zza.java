package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void m4013a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, gInAppPurchaseManagerInfoParcel.versionCode);
        C1355b.m4834a(parcel, 3, gInAppPurchaseManagerInfoParcel.m4010b(), false);
        C1355b.m4834a(parcel, 4, gInAppPurchaseManagerInfoParcel.m4011c(), false);
        C1355b.m4834a(parcel, 5, gInAppPurchaseManagerInfoParcel.m4012d(), false);
        C1355b.m4834a(parcel, 6, gInAppPurchaseManagerInfoParcel.m4009a(), false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzM(i);
    }

    public GInAppPurchaseManagerInfoParcel[] zzM(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public GInAppPurchaseManagerInfoParcel zzl(Parcel parcel) {
        IBinder iBinder = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    iBinder4 = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    iBinder3 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iBinder2 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }
}
