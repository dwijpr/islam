package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class bp implements Creator<zzarm> {
    static void m5336a(zzarm com_google_android_gms_internal_zzarm, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4835a(parcel, 1, com_google_android_gms_internal_zzarm.m9726b(), i, false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_internal_zzarm.m9725a());
        C1355b.m4827a(parcel, a);
    }

    public zzarm m5337a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    status = (Status) C1354a.m4800a(parcel, a, Status.CREATOR);
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
            return new zzarm(i, status);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzarm[] m5338a(int i) {
        return new zzarm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5337a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5338a(i);
    }
}
