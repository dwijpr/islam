package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.common.internal.C1314c;

@op
public class sw {
    private final sx f5857a;
    private final Context f5858b;
    private final ViewGroup f5859c;
    private zzl f5860d;

    public sw(Context context, ViewGroup viewGroup, sx sxVar) {
        this(context, viewGroup, sxVar, null);
    }

    sw(Context context, ViewGroup viewGroup, sx sxVar, zzl com_google_android_gms_ads_internal_overlay_zzl) {
        this.f5858b = context;
        this.f5859c = viewGroup;
        this.f5857a = sxVar;
        this.f5860d = com_google_android_gms_ads_internal_overlay_zzl;
    }

    public zzl m8736a() {
        C1314c.m4631b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f5860d;
    }

    public void m8737a(int i, int i2, int i3, int i4) {
        C1314c.m4631b("The underlay may only be modified from the UI thread.");
        if (this.f5860d != null) {
            this.f5860d.zzd(i, i2, i3, i4);
        }
    }

    public void m8738a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.f5860d == null) {
            ik.m6727a(this.f5857a.m8789y().m6737a(), this.f5857a.m8788x(), "vpr2");
            this.f5860d = new zzl(this.f5858b, this.f5857a, i5, z, this.f5857a.m8789y().m6737a());
            this.f5859c.addView(this.f5860d, 0, new LayoutParams(-1, -1));
            this.f5860d.zzd(i, i2, i3, i4);
            this.f5857a.m8776l().m8811a(false);
        }
    }

    public void m8739b() {
        C1314c.m4631b("onPause must be called from the UI thread.");
        if (this.f5860d != null) {
            this.f5860d.pause();
        }
    }

    public void m8740c() {
        C1314c.m4631b("onDestroy must be called from the UI thread.");
        if (this.f5860d != null) {
            this.f5860d.destroy();
            this.f5859c.removeView(this.f5860d);
            this.f5860d = null;
        }
    }
}
