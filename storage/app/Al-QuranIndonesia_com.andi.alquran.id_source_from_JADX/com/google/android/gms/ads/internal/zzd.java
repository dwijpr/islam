package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kx;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qx;

@op
public class zzd {
    public final kx zzsM;
    public final zzk zzsN;
    public final zzn zzsO;
    public final qx zzsP;

    public zzd(kx kxVar, zzk com_google_android_gms_ads_internal_overlay_zzk, zzn com_google_android_gms_ads_internal_overlay_zzn, qx qxVar) {
        this.zzsM = kxVar;
        this.zzsN = com_google_android_gms_ads_internal_overlay_zzk;
        this.zzsO = com_google_android_gms_ads_internal_overlay_zzn;
        this.zzsP = qxVar;
    }

    public static zzd zzca() {
        return new zzd(new kd(), new zzo(), new zzu(), new qu());
    }
}
