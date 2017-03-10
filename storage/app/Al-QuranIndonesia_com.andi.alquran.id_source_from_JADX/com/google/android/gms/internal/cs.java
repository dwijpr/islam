package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class cs implements Creator<zzaxw> {
    static void m5598a(zzaxw com_google_android_gms_internal_zzaxw, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzaxw.f6414a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_internal_zzaxw.m9755a(), i, false);
        C1355b.m4844a(parcel, 3, com_google_android_gms_internal_zzaxw.m9756b(), i, false);
        C1355b.m4838a(parcel, 4, com_google_android_gms_internal_zzaxw.m9757c(), false);
        C1355b.m4827a(parcel, a);
    }

    public zzaxw m5599a(Parcel parcel) {
        String str = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int f;
            String str2;
            int a = C1354a.m4798a(parcel);
            String str3;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = C1354a.m4811f(parcel, a);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C1354a.m4800a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    account2 = account;
                    f = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C1354a.m4806b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str2 = C1354a.m4817l(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
            }
            i = f;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zzaxw(i, account, scopeArr, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzaxw[] m5600a(int i) {
        return new zzaxw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5599a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5600a(i);
    }
}
