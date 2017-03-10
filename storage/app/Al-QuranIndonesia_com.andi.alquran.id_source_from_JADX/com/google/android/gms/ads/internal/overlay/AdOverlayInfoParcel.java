package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.kc;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.p039a.C1108c.C1110a;
import com.google.android.gms.p039a.C1111d;

@op
public final class AdOverlayInfoParcel extends zza implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR;
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final zzc zzMW;
    public final ge zzMX;
    public final zzh zzMY;
    public final sx zzMZ;
    public final kc zzNa;
    public final String zzNb;
    public final boolean zzNc;
    public final String zzNd;
    public final zzq zzNe;
    public final int zzNf;
    public final ki zzNg;
    public final String zzNh;
    public final zzm zzNi;
    public final zzqa zzvf;

    static {
        CREATOR = new zzg();
    }

    AdOverlayInfoParcel(int i, zzc com_google_android_gms_ads_internal_overlay_zzc, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, zzqa com_google_android_gms_internal_zzqa, IBinder iBinder6, String str4, zzm com_google_android_gms_ads_internal_zzm) {
        this.versionCode = i;
        this.zzMW = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzMX = (ge) C1111d.m3897a(C1110a.m3895a(iBinder));
        this.zzMY = (zzh) C1111d.m3897a(C1110a.m3895a(iBinder2));
        this.zzMZ = (sx) C1111d.m3897a(C1110a.m3895a(iBinder3));
        this.zzNa = (kc) C1111d.m3897a(C1110a.m3895a(iBinder4));
        this.zzNb = str;
        this.zzNc = z;
        this.zzNd = str2;
        this.zzNe = (zzq) C1111d.m3897a(C1110a.m3895a(iBinder5));
        this.orientation = i2;
        this.zzNf = i3;
        this.url = str3;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = (ki) C1111d.m3897a(C1110a.m3895a(iBinder6));
        this.zzNh = str4;
        this.zzNi = com_google_android_gms_ads_internal_zzm;
    }

    public AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqa com_google_android_gms_internal_zzqa) {
        this.versionCode = 4;
        this.zzMW = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzMX = geVar;
        this.zzMY = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzMZ = null;
        this.zzNa = null;
        this.zzNb = null;
        this.zzNc = false;
        this.zzNd = null;
        this.zzNe = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = -1;
        this.zzNf = 4;
        this.url = null;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = null;
        this.zzNh = null;
        this.zzNi = null;
    }

    public AdOverlayInfoParcel(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, sx sxVar, int i, zzqa com_google_android_gms_internal_zzqa, String str, zzm com_google_android_gms_ads_internal_zzm) {
        this.versionCode = 4;
        this.zzMW = null;
        this.zzMX = geVar;
        this.zzMY = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzMZ = sxVar;
        this.zzNa = null;
        this.zzNb = null;
        this.zzNc = false;
        this.zzNd = null;
        this.zzNe = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNf = 1;
        this.url = null;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = null;
        this.zzNh = str;
        this.zzNi = com_google_android_gms_ads_internal_zzm;
    }

    public AdOverlayInfoParcel(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, sx sxVar, boolean z, int i, zzqa com_google_android_gms_internal_zzqa) {
        this.versionCode = 4;
        this.zzMW = null;
        this.zzMX = geVar;
        this.zzMY = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzMZ = sxVar;
        this.zzNa = null;
        this.zzNb = null;
        this.zzNc = z;
        this.zzNd = null;
        this.zzNe = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNf = 2;
        this.url = null;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = null;
        this.zzNh = null;
        this.zzNi = null;
    }

    public AdOverlayInfoParcel(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, kc kcVar, zzq com_google_android_gms_ads_internal_overlay_zzq, sx sxVar, boolean z, int i, String str, zzqa com_google_android_gms_internal_zzqa, ki kiVar) {
        this.versionCode = 4;
        this.zzMW = null;
        this.zzMX = geVar;
        this.zzMY = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzMZ = sxVar;
        this.zzNa = kcVar;
        this.zzNb = null;
        this.zzNc = z;
        this.zzNd = null;
        this.zzNe = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNf = 3;
        this.url = str;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = kiVar;
        this.zzNh = null;
        this.zzNi = null;
    }

    public AdOverlayInfoParcel(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, kc kcVar, zzq com_google_android_gms_ads_internal_overlay_zzq, sx sxVar, boolean z, int i, String str, String str2, zzqa com_google_android_gms_internal_zzqa, ki kiVar) {
        this.versionCode = 4;
        this.zzMW = null;
        this.zzMX = geVar;
        this.zzMY = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzMZ = sxVar;
        this.zzNa = kcVar;
        this.zzNb = str2;
        this.zzNc = z;
        this.zzNd = str;
        this.zzNe = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNf = 3;
        this.url = null;
        this.zzvf = com_google_android_gms_internal_zzqa;
        this.zzNg = kiVar;
        this.zzNh = null;
        this.zzNi = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder m3940a() {
        return C1111d.m3896a(this.zzMX).asBinder();
    }

    IBinder m3941b() {
        return C1111d.m3896a(this.zzMY).asBinder();
    }

    IBinder m3942c() {
        return C1111d.m3896a(this.zzMZ).asBinder();
    }

    IBinder m3943d() {
        return C1111d.m3896a(this.zzNa).asBinder();
    }

    IBinder m3944e() {
        return C1111d.m3896a(this.zzNg).asBinder();
    }

    IBinder m3945f() {
        return C1111d.m3896a(this.zzNe).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m3977a(this, parcel, i);
    }
}
