package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.op;

@op
public class zzf {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzNf == 4 && adOverlayInfoParcel.zzMY == null) {
            if (adOverlayInfoParcel.zzMX != null) {
                adOverlayInfoParcel.zzMX.onAdClicked();
            }
            zzv.zzcG().zza(context, adOverlayInfoParcel.zzMW, adOverlayInfoParcel.zzNe);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzvf.f6639e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!C1387m.m4967i()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzv.zzcJ().m8509a(context, intent);
    }
}
