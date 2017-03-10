package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.maps.GoogleMap;

public class zzg implements Creator<AdOverlayInfoParcel> {
    static void m3977a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, adOverlayInfoParcel.versionCode);
        C1355b.m4835a(parcel, 2, adOverlayInfoParcel.zzMW, i, false);
        C1355b.m4834a(parcel, 3, adOverlayInfoParcel.m3940a(), false);
        C1355b.m4834a(parcel, 4, adOverlayInfoParcel.m3941b(), false);
        C1355b.m4834a(parcel, 5, adOverlayInfoParcel.m3942c(), false);
        C1355b.m4834a(parcel, 6, adOverlayInfoParcel.m3943d(), false);
        C1355b.m4838a(parcel, 7, adOverlayInfoParcel.zzNb, false);
        C1355b.m4841a(parcel, 8, adOverlayInfoParcel.zzNc);
        C1355b.m4838a(parcel, 9, adOverlayInfoParcel.zzNd, false);
        C1355b.m4834a(parcel, 10, adOverlayInfoParcel.m3945f(), false);
        C1355b.m4831a(parcel, 11, adOverlayInfoParcel.orientation);
        C1355b.m4831a(parcel, 12, adOverlayInfoParcel.zzNf);
        C1355b.m4838a(parcel, 13, adOverlayInfoParcel.url, false);
        C1355b.m4835a(parcel, 14, adOverlayInfoParcel.zzvf, i, false);
        C1355b.m4834a(parcel, 15, adOverlayInfoParcel.m3944e(), false);
        C1355b.m4838a(parcel, 16, adOverlayInfoParcel.zzNh, false);
        C1355b.m4835a(parcel, 17, adOverlayInfoParcel.zzNi, i, false);
        C1355b.m4827a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzL(i);
    }

    public AdOverlayInfoParcel[] zzL(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public AdOverlayInfoParcel zzk(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        zzc com_google_android_gms_ads_internal_overlay_zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        zzqa com_google_android_gms_internal_zzqa = null;
        IBinder iBinder6 = null;
        String str4 = null;
        zzm com_google_android_gms_ads_internal_zzm = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    com_google_android_gms_ads_internal_overlay_zzc = (zzc) C1354a.m4800a(parcel, a, zzc.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    iBinder = C1354a.m4818m(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    iBinder2 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    iBinder3 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    iBinder4 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    iBinder5 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    com_google_android_gms_internal_zzqa = (zzqa) C1354a.m4800a(parcel, a, zzqa.CREATOR);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    iBinder6 = C1354a.m4818m(parcel, a);
                    break;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    com_google_android_gms_ads_internal_zzm = (zzm) C1354a.m4800a(parcel, a, zzm.CREATOR);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdOverlayInfoParcel(i, com_google_android_gms_ads_internal_overlay_zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, com_google_android_gms_internal_zzqa, iBinder6, str4, com_google_android_gms_ads_internal_zzm);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }
}
