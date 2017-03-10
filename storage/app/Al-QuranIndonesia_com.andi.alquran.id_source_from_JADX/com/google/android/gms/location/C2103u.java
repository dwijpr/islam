package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.u */
public class C2103u implements Creator<LocationSettingsResult> {
    static void m9871a(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4835a(parcel, 1, locationSettingsResult.m9818b(), i, false);
        C1355b.m4835a(parcel, 2, locationSettingsResult.m9819c(), i, false);
        C1355b.m4831a(parcel, 1000, locationSettingsResult.m9817a());
        C1355b.m4827a(parcel, a);
    }

    public LocationSettingsResult m9872a(Parcel parcel) {
        LocationSettingsStates locationSettingsStates = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            LocationSettingsStates locationSettingsStates2;
            Status status2;
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = i;
                    Status status3 = (Status) C1354a.m4800a(parcel, a, Status.CREATOR);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    locationSettingsStates2 = (LocationSettingsStates) C1354a.m4800a(parcel, a, LocationSettingsStates.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates;
                    status2 = status;
                    i2 = C1354a.m4811f(parcel, a);
                    locationSettingsStates2 = locationSettingsStates3;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            locationSettingsStates = locationSettingsStates2;
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsResult(i, status, locationSettingsStates);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsResult[] m9873a(int i) {
        return new LocationSettingsResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9872a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9873a(i);
    }
}
