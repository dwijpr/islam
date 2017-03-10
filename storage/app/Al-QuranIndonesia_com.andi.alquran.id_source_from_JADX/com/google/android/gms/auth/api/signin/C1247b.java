package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.auth.api.signin.b */
public class C1247b implements Creator<GoogleSignInOptions> {
    static void m4416a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, googleSignInOptions.f2924e);
        C1355b.m4852c(parcel, 2, googleSignInOptions.m4396a(), false);
        C1355b.m4835a(parcel, 3, googleSignInOptions.m4397b(), i, false);
        C1355b.m4841a(parcel, 4, googleSignInOptions.m4398c());
        C1355b.m4841a(parcel, 5, googleSignInOptions.m4399d());
        C1355b.m4841a(parcel, 6, googleSignInOptions.m4400e());
        C1355b.m4838a(parcel, 7, googleSignInOptions.m4401f(), false);
        C1355b.m4838a(parcel, 8, googleSignInOptions.m4402g(), false);
        C1355b.m4827a(parcel, a);
    }

    public GoogleSignInOptions m4417a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    arrayList = C1354a.m4807c(parcel, a, Scope.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    account = (Account) C1354a.m4800a(parcel, a, Account.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m4418a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4417a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4418a(i);
    }
}
