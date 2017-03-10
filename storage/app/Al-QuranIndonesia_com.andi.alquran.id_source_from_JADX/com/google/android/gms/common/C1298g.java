package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.g */
public class C1298g implements Creator<ConnectionResult> {
    static void m4599a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, connectionResult.f2958b);
        C1355b.m4831a(parcel, 2, connectionResult.m4453c());
        C1355b.m4835a(parcel, 3, connectionResult.m4454d(), i, false);
        C1355b.m4838a(parcel, 4, connectionResult.m4455e(), false);
        C1355b.m4827a(parcel, a);
    }

    public ConnectionResult m4600a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C1354a.m4804b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C1354a.m4798a(parcel);
            String str3;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C1354a.m4811f(parcel, a);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C1354a.m4811f(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C1354a.m4800a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str2 = C1354a.m4817l(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m4601a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4600a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4601a(i);
    }
}
