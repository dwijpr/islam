package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.internal.ir.C1653a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public final class ip extends C1653a {
    private final zzh f4424a;
    private final String f4425b;
    private final String f4426c;

    public ip(zzh com_google_android_gms_ads_internal_zzh, String str, String str2) {
        this.f4424a = com_google_android_gms_ads_internal_zzh;
        this.f4425b = str;
        this.f4426c = str2;
    }

    public String m6757a() {
        return this.f4425b;
    }

    public void m6758a(C1108c c1108c) {
        if (c1108c != null) {
            this.f4424a.zzc((View) C1111d.m3897a(c1108c));
        }
    }

    public String m6759b() {
        return this.f4426c;
    }

    public void m6760c() {
        this.f4424a.zzbX();
    }

    public void m6761d() {
        this.f4424a.zzbY();
    }
}
