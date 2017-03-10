package com.google.android.gms.internal;

import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.p039a.C1108c;

public class hq extends C1154a {
    private gv f4313a;

    /* renamed from: com.google.android.gms.internal.hq.1 */
    class C16321 implements Runnable {
        final /* synthetic */ hq f4312a;

        C16321(hq hqVar) {
            this.f4312a = hqVar;
        }

        public void run() {
            if (this.f4312a.f4313a != null) {
                try {
                    this.f4312a.f4313a.m6314a(1);
                } catch (Throwable e) {
                    sg.m8447c("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(gu guVar) {
    }

    public void zza(gv gvVar) {
        this.f4313a = gvVar;
    }

    public void zza(hb hbVar) {
    }

    public void zza(hd hdVar) {
    }

    public void zza(is isVar) {
    }

    public void zza(nl nlVar) {
    }

    public void zza(nq nqVar, String str) {
    }

    public void zza(qc qcVar) {
    }

    public void zza(zzec com_google_android_gms_internal_zzec) {
    }

    public void zza(zzfn com_google_android_gms_internal_zzfn) {
    }

    public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
        sg.m8446c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        sf.f5831a.post(new C16321(this));
        return false;
    }

    public C1108c zzbC() {
        return null;
    }

    public zzec zzbD() {
        return null;
    }

    public void zzbF() {
    }

    public hg zzbG() {
        return null;
    }
}
