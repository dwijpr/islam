package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.v */
public class C2104v implements Creator<LocationSettingsStates> {
    static void m9874a(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4841a(parcel, 1, locationSettingsStates.m9821b());
        C1355b.m4841a(parcel, 2, locationSettingsStates.m9823d());
        C1355b.m4841a(parcel, 3, locationSettingsStates.m9825f());
        C1355b.m4841a(parcel, 4, locationSettingsStates.m9822c());
        C1355b.m4841a(parcel, 5, locationSettingsStates.m9824e());
        C1355b.m4841a(parcel, 6, locationSettingsStates.m9826g());
        C1355b.m4831a(parcel, 1000, locationSettingsStates.m9820a());
        C1355b.m4827a(parcel, a);
    }

    public LocationSettingsStates m9875a(Parcel parcel) {
        boolean z = false;
        int b = C1354a.m4804b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    z6 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    z5 = C1354a.m4808c(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    z4 = C1354a.m4808c(parcel, a);
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
                case 1000:
                    i = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsStates(i, z6, z5, z4, z3, z2, z);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsStates[] m9876a(int i) {
        return new LocationSettingsStates[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9875a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9876a(i);
    }
}
