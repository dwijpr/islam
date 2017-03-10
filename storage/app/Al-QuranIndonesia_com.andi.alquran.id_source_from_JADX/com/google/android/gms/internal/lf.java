package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.internal.le.C1755a;
import com.google.android.gms.p039a.C1108c;

@op
public class lf extends C1154a {
    private final String f4748a;
    private final kz f4749b;
    private zzl f4750c;
    private final lb f4751d;
    private nq f4752e;
    private String f4753f;

    public lf(Context context, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        this(str, new kz(context, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd));
    }

    lf(String str, kz kzVar) {
        this.f4748a = str;
        this.f4749b = kzVar;
        this.f4751d = new lb();
        zzv.zzcY().m7259a(kzVar);
    }

    static boolean m7280a(zzdy com_google_android_gms_internal_zzdy) {
        Bundle a = lc.m7247a(com_google_android_gms_internal_zzdy);
        return a != null && a.containsKey("gw");
    }

    private void m7281b() {
        if (this.f4750c != null && this.f4752e != null) {
            this.f4750c.zza(this.f4752e, this.f4753f);
        }
    }

    static boolean m7282b(zzdy com_google_android_gms_internal_zzdy) {
        Bundle a = lc.m7247a(com_google_android_gms_internal_zzdy);
        return a != null && a.containsKey("_ad");
    }

    void m7283a() {
        if (this.f4750c == null) {
            this.f4750c = this.f4749b.m7158a(this.f4748a);
            this.f4751d.m7246a(this.f4750c);
            m7281b();
        }
    }

    public void destroy() {
        if (this.f4750c != null) {
            this.f4750c.destroy();
        }
    }

    public String getMediationAdapterClassName() {
        return this.f4750c != null ? this.f4750c.getMediationAdapterClassName() : null;
    }

    public boolean isLoading() {
        return this.f4750c != null && this.f4750c.isLoading();
    }

    public boolean isReady() {
        return this.f4750c != null && this.f4750c.isReady();
    }

    public void pause() {
        if (this.f4750c != null) {
            this.f4750c.pause();
        }
    }

    public void resume() {
        if (this.f4750c != null) {
            this.f4750c.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        m7283a();
        if (this.f4750c != null) {
            this.f4750c.setManualImpressionsEnabled(z);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
        if (this.f4750c != null) {
            this.f4750c.showInterstitial();
        } else {
            sg.m8449e("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() {
        if (this.f4750c != null) {
            this.f4750c.stopLoading();
        }
    }

    public void zza(gu guVar) {
        this.f4751d.f4730e = guVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(gv gvVar) {
        this.f4751d.f4726a = gvVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(hb hbVar) {
        this.f4751d.f4727b = hbVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(hd hdVar) {
        m7283a();
        if (this.f4750c != null) {
            this.f4750c.zza(hdVar);
        }
    }

    public void zza(is isVar) {
        this.f4751d.f4729d = isVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(nl nlVar) {
        this.f4751d.f4728c = nlVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(nq nqVar, String str) {
        this.f4752e = nqVar;
        this.f4753f = str;
        m7281b();
    }

    public void zza(qc qcVar) {
        this.f4751d.f4731f = qcVar;
        if (this.f4750c != null) {
            this.f4751d.m7246a(this.f4750c);
        }
    }

    public void zza(zzec com_google_android_gms_internal_zzec) {
        if (this.f4750c != null) {
            this.f4750c.zza(com_google_android_gms_internal_zzec);
        }
    }

    public void zza(zzfn com_google_android_gms_internal_zzfn) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
        if (((Boolean) C1648if.aI.m6682c()).booleanValue()) {
            zzdy.m9766a(com_google_android_gms_internal_zzdy);
        }
        if (!m7280a(com_google_android_gms_internal_zzdy)) {
            m7283a();
        }
        if (lc.m7253c(com_google_android_gms_internal_zzdy)) {
            m7283a();
        }
        if (com_google_android_gms_internal_zzdy.f6442j != null) {
            m7283a();
        }
        if (this.f4750c != null) {
            return this.f4750c.zzb(com_google_android_gms_internal_zzdy);
        }
        lc zzcY = zzv.zzcY();
        if (m7282b(com_google_android_gms_internal_zzdy)) {
            zzcY.m7261b(com_google_android_gms_internal_zzdy, this.f4748a);
        }
        C1755a a = zzcY.m7257a(com_google_android_gms_internal_zzdy, this.f4748a);
        if (a != null) {
            if (!a.f4740e) {
                a.m7266a();
            }
            this.f4750c = a.f4736a;
            a.f4738c.m7240a(this.f4751d);
            this.f4751d.m7246a(this.f4750c);
            m7281b();
            return a.f4741f;
        }
        m7283a();
        return this.f4750c.zzb(com_google_android_gms_internal_zzdy);
    }

    public C1108c zzbC() {
        return this.f4750c != null ? this.f4750c.zzbC() : null;
    }

    public zzec zzbD() {
        return this.f4750c != null ? this.f4750c.zzbD() : null;
    }

    public void zzbF() {
        if (this.f4750c != null) {
            this.f4750c.zzbF();
        } else {
            sg.m8449e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public hg zzbG() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
