package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.d */
public class C1315d implements Creator<zzad> {
    static void m4636a(zzad com_google_android_gms_common_internal_zzad, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_common_internal_zzad.f3147a);
        C1355b.m4835a(parcel, 2, com_google_android_gms_common_internal_zzad.m4868a(), i, false);
        C1355b.m4831a(parcel, 3, com_google_android_gms_common_internal_zzad.m4869b());
        C1355b.m4835a(parcel, 4, com_google_android_gms_common_internal_zzad.m4870c(), i, false);
        C1355b.m4827a(parcel, a);
    }

    public zzad m4637a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C1354a.m4804b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int f;
            GoogleSignInAccount googleSignInAccount2;
            int a = C1354a.m4798a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = C1354a.m4811f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i2;
                    int i4 = i;
                    account2 = (Account) C1354a.m4800a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    account2 = account;
                    f = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C1354a.m4811f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    googleSignInAccount2 = (GoogleSignInAccount) C1354a.m4800a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
            }
            i2 = f;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new zzad(i2, account, i, googleSignInAccount);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzad[] m4638a(int i) {
        return new zzad[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4637a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4638a(i);
    }
}
