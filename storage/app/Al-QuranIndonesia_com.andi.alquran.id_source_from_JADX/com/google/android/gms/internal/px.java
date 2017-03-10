package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.internal.qa.C1635a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public class px extends C1635a {
    private final Context f5523a;
    private final Object f5524b;
    private final zzqa f5525c;
    private final py f5526d;

    public px(Context context, zzd com_google_android_gms_ads_internal_zzd, md mdVar, zzqa com_google_android_gms_internal_zzqa) {
        this(context, com_google_android_gms_internal_zzqa, new py(context, com_google_android_gms_ads_internal_zzd, zzec.m9768a(), mdVar, com_google_android_gms_internal_zzqa));
    }

    px(Context context, zzqa com_google_android_gms_internal_zzqa, py pyVar) {
        this.f5524b = new Object();
        this.f5523a = context;
        this.f5525c = com_google_android_gms_internal_zzqa;
        this.f5526d = pyVar;
    }

    public void m8209a() {
        synchronized (this.f5524b) {
            this.f5526d.m8234g();
        }
    }

    public void m8210a(C1108c c1108c) {
        synchronized (this.f5524b) {
            this.f5526d.pause();
        }
    }

    public void m8211a(qc qcVar) {
        synchronized (this.f5524b) {
            this.f5526d.zza(qcVar);
        }
    }

    public void m8212a(zznx com_google_android_gms_internal_zznx) {
        synchronized (this.f5524b) {
            this.f5526d.m8230a(com_google_android_gms_internal_zznx);
        }
    }

    public void m8213a(String str) {
        sg.m8449e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void m8214b(C1108c c1108c) {
        synchronized (this.f5524b) {
            Context context = c1108c == null ? null : (Context) C1111d.m3897a(c1108c);
            if (context != null) {
                try {
                    this.f5526d.m8229a(context);
                } catch (Throwable e) {
                    sg.m8447c("Unable to extract updated context.", e);
                }
            }
            this.f5526d.resume();
        }
    }

    public boolean m8215b() {
        boolean h;
        synchronized (this.f5524b) {
            h = this.f5526d.m8235h();
        }
        return h;
    }

    public void m8216c() {
        m8210a(null);
    }

    public void m8217c(C1108c c1108c) {
        synchronized (this.f5524b) {
            this.f5526d.destroy();
        }
    }

    public void m8218d() {
        m8214b(null);
    }

    public void m8219e() {
        m8217c(null);
    }
}
