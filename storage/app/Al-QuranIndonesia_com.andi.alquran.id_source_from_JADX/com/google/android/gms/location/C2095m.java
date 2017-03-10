package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.m */
public class C2095m implements Creator<zzj> {
    static void m9850a(zzj com_google_android_gms_location_zzj, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4839a(parcel, 1, com_google_android_gms_location_zzj.m9899b(), false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zzj.m9898a());
        C1355b.m4827a(parcel, a);
    }

    public zzj m9851a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list = C1354a.m4824s(parcel, a);
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
            return new zzj(i, list);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzj[] m9852a(int i) {
        return new zzj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9851a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9852a(i);
    }
}
