package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p014g.C0297j;
import android.text.TextUtils;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx.C1176a;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzqa;

@op
public class zzk extends C1176a {
    private gv f2610a;
    private js f2611b;
    private jt f2612c;
    private C0297j<String, ju> f2613d;
    private C0297j<String, jv> f2614e;
    private zzgw f2615f;
    private hd f2616g;
    private final Context f2617h;
    private final md f2618i;
    private final String f2619j;
    private final zzqa f2620k;
    private final zzd f2621l;

    public zzk(Context context, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        this.f2617h = context;
        this.f2619j = str;
        this.f2618i = mdVar;
        this.f2620k = com_google_android_gms_internal_zzqa;
        this.f2614e = new C0297j();
        this.f2613d = new C0297j();
        this.f2621l = com_google_android_gms_ads_internal_zzd;
    }

    public void zza(js jsVar) {
        this.f2611b = jsVar;
    }

    public void zza(jt jtVar) {
        this.f2612c = jtVar;
    }

    public void zza(zzgw com_google_android_gms_internal_zzgw) {
        this.f2615f = com_google_android_gms_internal_zzgw;
    }

    public void zza(String str, jv jvVar, ju juVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f2614e.put(str, jvVar);
        this.f2613d.put(str, juVar);
    }

    public void zzb(gv gvVar) {
        this.f2610a = gvVar;
    }

    public void zzb(hd hdVar) {
        this.f2616g = hdVar;
    }

    public gw zzci() {
        return new zzj(this.f2617h, this.f2619j, this.f2618i, this.f2620k, this.f2610a, this.f2611b, this.f2612c, this.f2614e, this.f2613d, this.f2615f, this.f2616g, this.f2621l);
    }
}
