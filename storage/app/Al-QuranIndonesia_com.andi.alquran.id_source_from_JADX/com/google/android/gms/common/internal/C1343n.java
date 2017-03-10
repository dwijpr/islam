package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.n */
public class C1343n implements Creator<zzj> {
    static void m4754a(zzj com_google_android_gms_common_internal_zzj, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_common_internal_zzj.f3162a);
        C1355b.m4831a(parcel, 2, com_google_android_gms_common_internal_zzj.f3163b);
        C1355b.m4831a(parcel, 3, com_google_android_gms_common_internal_zzj.f3164c);
        C1355b.m4838a(parcel, 4, com_google_android_gms_common_internal_zzj.f3165d, false);
        C1355b.m4834a(parcel, 5, com_google_android_gms_common_internal_zzj.f3166e, false);
        C1355b.m4844a(parcel, 6, com_google_android_gms_common_internal_zzj.f3167f, i, false);
        C1355b.m4833a(parcel, 7, com_google_android_gms_common_internal_zzj.f3168g, false);
        C1355b.m4835a(parcel, 8, com_google_android_gms_common_internal_zzj.f3169h, i, false);
        C1355b.m4832a(parcel, 9, com_google_android_gms_common_internal_zzj.f3170i);
        C1355b.m4827a(parcel, a);
    }

    public zzj m4755a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C1354a.m4804b(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    scopeArr = (Scope[]) C1354a.m4806b(parcel, a, Scope.CREATOR);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    bundle = C1354a.m4819n(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    account = (Account) C1354a.m4800a(parcel, a, Account.CREATOR);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzj(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzj[] m4756a(int i) {
        return new zzj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4755a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4756a(i);
    }
}
