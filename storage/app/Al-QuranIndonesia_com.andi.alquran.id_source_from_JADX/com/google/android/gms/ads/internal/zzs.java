package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzdy;
import java.lang.ref.WeakReference;

@op
public class zzs {
    private final zza f2664a;
    private final Runnable f2665b;
    private zzdy f2666c;
    private boolean f2667d;
    private boolean f2668e;
    private long f2669f;

    /* renamed from: com.google.android.gms.ads.internal.zzs.1 */
    class C11911 implements Runnable {
        final /* synthetic */ WeakReference f2661a;
        final /* synthetic */ zzs f2662b;

        C11911(zzs com_google_android_gms_ads_internal_zzs, WeakReference weakReference) {
            this.f2662b = com_google_android_gms_ads_internal_zzs;
            this.f2661a = weakReference;
        }

        public void run() {
            this.f2662b.f2667d = false;
            zza com_google_android_gms_ads_internal_zza = (zza) this.f2661a.get();
            if (com_google_android_gms_ads_internal_zza != null) {
                com_google_android_gms_ads_internal_zza.zzd(this.f2662b.f2666c);
            }
        }
    }

    public static class zza {
        private final Handler f2663a;

        public zza(Handler handler) {
            this.f2663a = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.f2663a.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.f2663a.removeCallbacks(runnable);
        }
    }

    public zzs(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(rq.f5755a));
    }

    zzs(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzs_zza) {
        this.f2667d = false;
        this.f2668e = false;
        this.f2669f = 0;
        this.f2664a = com_google_android_gms_ads_internal_zzs_zza;
        this.f2665b = new C11911(this, new WeakReference(com_google_android_gms_ads_internal_zza));
    }

    public void cancel() {
        this.f2667d = false;
        this.f2664a.removeCallbacks(this.f2665b);
    }

    public void pause() {
        this.f2668e = true;
        if (this.f2667d) {
            this.f2664a.removeCallbacks(this.f2665b);
        }
    }

    public void resume() {
        this.f2668e = false;
        if (this.f2667d) {
            this.f2667d = false;
            zza(this.f2666c, this.f2669f);
        }
    }

    public void zza(zzdy com_google_android_gms_internal_zzdy, long j) {
        if (this.f2667d) {
            sg.m8449e("An ad refresh is already scheduled.");
            return;
        }
        this.f2666c = com_google_android_gms_internal_zzdy;
        this.f2667d = true;
        this.f2669f = j;
        if (!this.f2668e) {
            sg.m8448d("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f2664a.postDelayed(this.f2665b, j);
        }
    }

    public boolean zzcv() {
        return this.f2667d;
    }

    public void zzg(zzdy com_google_android_gms_internal_zzdy) {
        this.f2666c = com_google_android_gms_internal_zzdy;
    }

    public void zzh(zzdy com_google_android_gms_internal_zzdy) {
        zza(com_google_android_gms_internal_zzdy, 60000);
    }
}
