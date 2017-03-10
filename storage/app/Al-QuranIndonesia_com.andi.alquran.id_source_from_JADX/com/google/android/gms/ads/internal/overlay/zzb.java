package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;

public class zzb implements Creator<zzc> {
    static void m3958a(zzc com_google_android_gms_ads_internal_overlay_zzc, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_ads_internal_overlay_zzc.versionCode);
        C1355b.m4838a(parcel, 2, com_google_android_gms_ads_internal_overlay_zzc.zzLY, false);
        C1355b.m4838a(parcel, 3, com_google_android_gms_ads_internal_overlay_zzc.url, false);
        C1355b.m4838a(parcel, 4, com_google_android_gms_ads_internal_overlay_zzc.mimeType, false);
        C1355b.m4838a(parcel, 5, com_google_android_gms_ads_internal_overlay_zzc.packageName, false);
        C1355b.m4838a(parcel, 6, com_google_android_gms_ads_internal_overlay_zzc.zzLZ, false);
        C1355b.m4838a(parcel, 7, com_google_android_gms_ads_internal_overlay_zzc.zzMa, false);
        C1355b.m4838a(parcel, 8, com_google_android_gms_ads_internal_overlay_zzc.zzMb, false);
        C1355b.m4835a(parcel, 9, com_google_android_gms_ads_internal_overlay_zzc.intent, i, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzH(i);
    }

    public zzc[] zzH(int i) {
        return new zzc[i];
    }

    public zzc zzj(Parcel parcel) {
        Intent intent = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    str7 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str6 = C1354a.m4817l(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str5 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    intent = (Intent) C1354a.m4800a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzc(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }
}
