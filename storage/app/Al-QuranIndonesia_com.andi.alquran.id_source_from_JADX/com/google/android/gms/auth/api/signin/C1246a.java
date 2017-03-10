package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.signin.a */
public class C1246a implements Creator<GoogleSignInAccount> {
    static void m4413a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, googleSignInAccount.f2900b);
        C1355b.m4838a(parcel, 2, googleSignInAccount.m4379a(), false);
        C1355b.m4838a(parcel, 3, googleSignInAccount.m4381b(), false);
        C1355b.m4838a(parcel, 4, googleSignInAccount.m4382c(), false);
        C1355b.m4838a(parcel, 5, googleSignInAccount.m4383d(), false);
        C1355b.m4835a(parcel, 6, googleSignInAccount.m4386g(), i, false);
        C1355b.m4838a(parcel, 7, googleSignInAccount.m4387h(), false);
        C1355b.m4832a(parcel, 8, googleSignInAccount.m4388i());
        C1355b.m4838a(parcel, 9, googleSignInAccount.m4389j(), false);
        C1355b.m4852c(parcel, 10, googleSignInAccount.f2901c, false);
        C1355b.m4838a(parcel, 11, googleSignInAccount.m4384e(), false);
        C1355b.m4838a(parcel, 12, googleSignInAccount.m4385f(), false);
        C1355b.m4827a(parcel, a);
    }

    public GoogleSignInAccount m4414a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    uri = (Uri) C1354a.m4800a(parcel, a, Uri.CREATOR);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    str5 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    str6 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    list = C1354a.m4807c(parcel, a, Scope.CREATOR);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    str7 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    str8 = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m4415a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4414a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4415a(i);
    }
}
