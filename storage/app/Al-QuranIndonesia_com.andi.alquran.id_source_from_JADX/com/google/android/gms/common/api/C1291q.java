package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.api.q */
public class C1291q implements Creator<Status> {
    static void m4575a(Status status, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, status.m4506e());
        C1355b.m4838a(parcel, 2, status.m4504c(), false);
        C1355b.m4835a(parcel, 3, status.m4502a(), i, false);
        C1355b.m4831a(parcel, 1000, status.f2982h);
        C1355b.m4827a(parcel, a);
    }

    public Status m4576a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C1354a.m4804b(parcel);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) C1354a.m4800a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public Status[] m4577a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4576a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4577a(i);
    }
}
