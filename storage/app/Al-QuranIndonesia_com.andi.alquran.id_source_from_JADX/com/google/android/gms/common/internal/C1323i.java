package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.i */
public class C1323i implements Creator<zzd> {
    static void m4702a(zzd com_google_android_gms_common_internal_zzd, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_common_internal_zzd.f3157a);
        C1355b.m4834a(parcel, 2, com_google_android_gms_common_internal_zzd.f3158b, false);
        C1355b.m4844a(parcel, 3, com_google_android_gms_common_internal_zzd.f3159c, i, false);
        C1355b.m4837a(parcel, 4, com_google_android_gms_common_internal_zzd.f3160d, false);
        C1355b.m4837a(parcel, 5, com_google_android_gms_common_internal_zzd.f3161e, false);
        C1355b.m4827a(parcel, a);
    }

    public zzd m4703a(Parcel parcel) {
        Integer num = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    scopeArr = (Scope[]) C1354a.m4806b(parcel, a, Scope.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    num2 = C1354a.m4812g(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    num = C1354a.m4812g(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzd(i, iBinder, scopeArr, num2, num);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzd[] m4704a(int i) {
        return new zzd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4703a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4704a(i);
    }
}
