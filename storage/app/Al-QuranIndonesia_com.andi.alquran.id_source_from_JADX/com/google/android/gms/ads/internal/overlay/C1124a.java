package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rq;

@op
/* renamed from: com.google.android.gms.ads.internal.overlay.a */
class C1124a implements Runnable {
    private zzl f2359a;
    private boolean f2360b;

    C1124a(zzl com_google_android_gms_ads_internal_overlay_zzl) {
        this.f2360b = false;
        this.f2359a = com_google_android_gms_ads_internal_overlay_zzl;
    }

    public void m3946a() {
        this.f2360b = true;
        rq.f5755a.removeCallbacks(this);
    }

    public void m3947b() {
        rq.f5755a.postDelayed(this, 250);
    }

    public void run() {
        if (!this.f2360b) {
            this.f2359a.m3989a();
            m3947b();
        }
    }
}
