package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzm implements Creator<StreetViewPanoramaLocation> {
    static void m10082a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, streetViewPanoramaLocation.m10061a());
        C1355b.m4844a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C1355b.m4835a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C1355b.m4838a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlj(i);
    }

    public StreetViewPanoramaLocation zzhF(Parcel parcel) {
        String str = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < b) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int f;
            String str2;
            int a = C1354a.m4798a(parcel);
            String str3;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = C1354a.m4811f(parcel, a);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    f = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C1354a.m4806b(parcel, a, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    str3 = str;
                    latLng2 = (LatLng) C1354a.m4800a(parcel, a, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str2 = C1354a.m4817l(parcel, a);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
            }
            i = f;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaLocation[] zzlj(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
