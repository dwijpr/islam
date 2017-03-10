package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

public class ov implements Creator<zzmh> {
    static void m7981a(zzmh com_google_android_gms_internal_zzmh, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, com_google_android_gms_internal_zzmh.f6540a);
        C1355b.m4833a(parcel, 2, com_google_android_gms_internal_zzmh.f6541b, false);
        C1355b.m4835a(parcel, 3, com_google_android_gms_internal_zzmh.f6542c, i, false);
        C1355b.m4835a(parcel, 4, com_google_android_gms_internal_zzmh.f6543d, i, false);
        C1355b.m4838a(parcel, 5, com_google_android_gms_internal_zzmh.f6544e, false);
        C1355b.m4835a(parcel, 6, com_google_android_gms_internal_zzmh.f6545f, i, false);
        C1355b.m4835a(parcel, 7, com_google_android_gms_internal_zzmh.f6546g, i, false);
        C1355b.m4838a(parcel, 8, com_google_android_gms_internal_zzmh.f6547h, false);
        C1355b.m4838a(parcel, 9, com_google_android_gms_internal_zzmh.f6548i, false);
        C1355b.m4838a(parcel, 10, com_google_android_gms_internal_zzmh.f6549j, false);
        C1355b.m4835a(parcel, 11, com_google_android_gms_internal_zzmh.f6550k, i, false);
        C1355b.m4833a(parcel, 12, com_google_android_gms_internal_zzmh.f6551l, false);
        C1355b.m4831a(parcel, 13, com_google_android_gms_internal_zzmh.f6552m);
        C1355b.m4850b(parcel, 14, com_google_android_gms_internal_zzmh.f6553n, false);
        C1355b.m4833a(parcel, 15, com_google_android_gms_internal_zzmh.f6554o, false);
        C1355b.m4841a(parcel, 16, com_google_android_gms_internal_zzmh.f6555p);
        C1355b.m4835a(parcel, 17, com_google_android_gms_internal_zzmh.f6556q, i, false);
        C1355b.m4831a(parcel, 18, com_google_android_gms_internal_zzmh.f6557r);
        C1355b.m4831a(parcel, 19, com_google_android_gms_internal_zzmh.f6558s);
        C1355b.m4830a(parcel, 20, com_google_android_gms_internal_zzmh.f6559t);
        C1355b.m4838a(parcel, 21, com_google_android_gms_internal_zzmh.f6560u, false);
        C1355b.m4832a(parcel, 25, com_google_android_gms_internal_zzmh.f6561v);
        C1355b.m4838a(parcel, 26, com_google_android_gms_internal_zzmh.f6562w, false);
        C1355b.m4850b(parcel, 27, com_google_android_gms_internal_zzmh.f6563x, false);
        C1355b.m4838a(parcel, 28, com_google_android_gms_internal_zzmh.f6564y, false);
        C1355b.m4835a(parcel, 29, com_google_android_gms_internal_zzmh.f6565z, i, false);
        C1355b.m4850b(parcel, 30, com_google_android_gms_internal_zzmh.f6524A, false);
        C1355b.m4832a(parcel, 31, com_google_android_gms_internal_zzmh.f6525B);
        C1355b.m4835a(parcel, 32, com_google_android_gms_internal_zzmh.f6526C, i, false);
        C1355b.m4838a(parcel, 33, com_google_android_gms_internal_zzmh.f6527D, false);
        C1355b.m4830a(parcel, 34, com_google_android_gms_internal_zzmh.f6528E);
        C1355b.m4831a(parcel, 35, com_google_android_gms_internal_zzmh.f6529F);
        C1355b.m4831a(parcel, 36, com_google_android_gms_internal_zzmh.f6530G);
        C1355b.m4841a(parcel, 37, com_google_android_gms_internal_zzmh.f6531H);
        C1355b.m4841a(parcel, 38, com_google_android_gms_internal_zzmh.f6532I);
        C1355b.m4838a(parcel, 39, com_google_android_gms_internal_zzmh.f6533J, false);
        C1355b.m4841a(parcel, 40, com_google_android_gms_internal_zzmh.f6534K);
        C1355b.m4838a(parcel, 41, com_google_android_gms_internal_zzmh.f6535L, false);
        C1355b.m4841a(parcel, 42, com_google_android_gms_internal_zzmh.f6536M);
        C1355b.m4831a(parcel, 43, com_google_android_gms_internal_zzmh.f6537N);
        C1355b.m4833a(parcel, 44, com_google_android_gms_internal_zzmh.f6538O, false);
        C1355b.m4838a(parcel, 45, com_google_android_gms_internal_zzmh.f6539P, false);
        C1355b.m4827a(parcel, a);
    }

    public zzmh m7982a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        Bundle bundle = null;
        zzdy com_google_android_gms_internal_zzdy = null;
        zzec com_google_android_gms_internal_zzec = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzqa com_google_android_gms_internal_zzqa = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        zzgw com_google_android_gms_internal_zzgw = null;
        List list3 = null;
        long j2 = 0;
        zzmo com_google_android_gms_internal_zzmo = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        String str11 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    bundle = C1354a.m4819n(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    com_google_android_gms_internal_zzdy = (zzdy) C1354a.m4800a(parcel, a, zzdy.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    com_google_android_gms_internal_zzec = (zzec) C1354a.m4800a(parcel, a, zzec.CREATOR);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    applicationInfo = (ApplicationInfo) C1354a.m4800a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    packageInfo = (PackageInfo) C1354a.m4800a(parcel, a, PackageInfo.CREATOR);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    com_google_android_gms_internal_zzqa = (zzqa) C1354a.m4800a(parcel, a, zzqa.CREATOR);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    bundle2 = C1354a.m4819n(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    list = C1354a.m4825t(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    bundle3 = C1354a.m4819n(parcel, a);
                    break;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    z = C1354a.m4808c(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    messenger = (Messenger) C1354a.m4800a(parcel, a, Messenger.CREATOR);
                    break;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    str5 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.Toolbar_navigationContentDescription /*25*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case C0861R.styleable.Toolbar_logoDescription /*26*/:
                    str6 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.Toolbar_titleTextColor /*27*/:
                    list2 = C1354a.m4825t(parcel, a);
                    break;
                case C0861R.styleable.Toolbar_subtitleTextColor /*28*/:
                    str7 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    com_google_android_gms_internal_zzgw = (zzgw) C1354a.m4800a(parcel, a, zzgw.CREATOR);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeSplitBackground /*30*/:
                    list3 = C1354a.m4825t(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    j2 = C1354a.m4813h(parcel, a);
                    break;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    com_google_android_gms_internal_zzmo = (zzmo) C1354a.m4800a(parcel, a, zzmo.CREATOR);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    str8 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    f2 = C1354a.m4814i(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    i5 = C1354a.m4811f(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    i6 = C1354a.m4811f(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    z3 = C1354a.m4808c(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    z4 = C1354a.m4808c(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    str9 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    z2 = C1354a.m4808c(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    str10 = C1354a.m4817l(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    z5 = C1354a.m4808c(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    i7 = C1354a.m4811f(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    bundle4 = C1354a.m4819n(parcel, a);
                    break;
                case C0861R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    str11 = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmh(i, bundle, com_google_android_gms_internal_zzdy, com_google_android_gms_internal_zzec, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqa, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, com_google_android_gms_internal_zzgw, list3, j2, com_google_android_gms_internal_zzmo, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzmh[] m7983a(int i) {
        return new zzmh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7982a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7983a(i);
    }
}
