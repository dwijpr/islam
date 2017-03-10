package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.zzv;

@op
public class sz {
    public sx m8830a(Context context, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, cg cgVar, zzqa com_google_android_gms_internal_zzqa) {
        return m8831a(context, com_google_android_gms_internal_zzec, z, z2, cgVar, com_google_android_gms_internal_zzqa, null, null, null);
    }

    public sx m8831a(Context context, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, cg cgVar, zzqa com_google_android_gms_internal_zzqa, io ioVar, zzt com_google_android_gms_ads_internal_zzt, zzd com_google_android_gms_ads_internal_zzd) {
        sx taVar = new ta(tb.m8898a(context, com_google_android_gms_internal_zzec, z, z2, cgVar, com_google_android_gms_internal_zzqa, ioVar, com_google_android_gms_ads_internal_zzt, com_google_android_gms_ads_internal_zzd));
        taVar.setWebViewClient(zzv.zzcL().m8562a(taVar, z2));
        taVar.setWebChromeClient(zzv.zzcL().m8579c(taVar));
        return taVar;
    }
}
