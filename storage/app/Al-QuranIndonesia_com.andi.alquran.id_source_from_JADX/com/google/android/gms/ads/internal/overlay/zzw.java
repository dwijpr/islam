package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rq;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@op
public class zzw {
    private final long f2457a;
    private long f2458b;
    private boolean f2459c;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzw.1 */
    class C11471 implements Runnable {
        final /* synthetic */ zzi f2456a;

        C11471(zzw com_google_android_gms_ads_internal_overlay_zzw, zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.f2456a = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            this.f2456a.zzhD();
        }
    }

    zzw() {
        this.f2457a = TimeUnit.MILLISECONDS.toNanos(((Long) C1648if.f4339C.m6682c()).longValue());
        this.f2459c = true;
    }

    public void zza(SurfaceTexture surfaceTexture, zzi com_google_android_gms_ads_internal_overlay_zzi) {
        if (com_google_android_gms_ads_internal_overlay_zzi != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.f2459c || Math.abs(timestamp - this.f2458b) >= this.f2457a) {
                this.f2459c = false;
                this.f2458b = timestamp;
                rq.f5755a.post(new C11471(this, com_google_android_gms_ads_internal_overlay_zzi));
            }
        }
    }

    public void zzhA() {
        this.f2459c = true;
    }
}
