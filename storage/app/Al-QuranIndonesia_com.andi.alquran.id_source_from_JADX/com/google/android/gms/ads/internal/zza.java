package com.google.android.gms.ads.internal;

import android.os.Debug;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.kc;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.oq.C1156a;
import com.google.android.gms.internal.pw;
import com.google.android.gms.internal.qc;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rd;
import com.google.android.gms.internal.ri;
import com.google.android.gms.internal.rj;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@op
public abstract class zza extends C1154a implements zzq, ge, kc, C1155a, C1156a, ri {
    protected io f2548a;
    protected im f2549b;
    protected im f2550c;
    protected boolean f2551d;
    protected final zzs f2552e;
    protected final zzw f2553f;
    protected transient zzdy f2554g;
    protected final fb f2555h;
    protected final zzd f2556i;

    /* renamed from: com.google.android.gms.ads.internal.zza.1 */
    class C11531 extends TimerTask {
        final /* synthetic */ CountDownLatch f2545a;
        final /* synthetic */ Timer f2546b;
        final /* synthetic */ zza f2547c;

        C11531(zza com_google_android_gms_ads_internal_zza, CountDownLatch countDownLatch, Timer timer) {
            this.f2547c = com_google_android_gms_ads_internal_zza;
            this.f2545a = countDownLatch;
            this.f2546b = timer;
        }

        public void run() {
            if (((long) ((Integer) C1648if.cr.m6682c()).intValue()) != this.f2545a.getCount()) {
                sg.m8444b("Stopping method tracing");
                Debug.stopMethodTracing();
                if (this.f2545a.getCount() == 0) {
                    this.f2546b.cancel();
                    return;
                }
            }
            String concat = String.valueOf(this.f2547c.f2553f.zzqr.getPackageName()).concat("_adsTrace_");
            try {
                sg.m8444b("Starting method tracing");
                this.f2545a.countDown();
                Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzv.zzcP().m4926a()).toString(), ((Integer) C1648if.cs.m6682c()).intValue());
            } catch (Throwable e) {
                sg.m8447c("Exception occurred while starting method tracing.", e);
            }
        }
    }

    zza(zzw com_google_android_gms_ads_internal_zzw, zzs com_google_android_gms_ads_internal_zzs, zzd com_google_android_gms_ads_internal_zzd) {
        this.f2551d = false;
        this.f2553f = com_google_android_gms_ads_internal_zzw;
        if (com_google_android_gms_ads_internal_zzs == null) {
            com_google_android_gms_ads_internal_zzs = new zzs(this);
        }
        this.f2552e = com_google_android_gms_ads_internal_zzs;
        this.f2556i = com_google_android_gms_ads_internal_zzd;
        zzv.zzcJ().m8536b(this.f2553f.zzqr);
        zzv.zzcN().m8394a(this.f2553f.zzqr, this.f2553f.zzvf);
        zzv.zzcO().m6267a(this.f2553f.zzqr);
        this.f2555h = zzv.zzcN().m8424r();
        zzv.zzcM().m6200a(this.f2553f.zzqr);
        m4029f();
    }

    private TimerTask m4026a(Timer timer, CountDownLatch countDownLatch) {
        return new C11531(this, countDownLatch, timer);
    }

    private zzdy m4027b(zzdy com_google_android_gms_internal_zzdy) {
        return (!C1380f.m4944c(this.f2553f.zzqr) || com_google_android_gms_internal_zzdy.f6443k == null) ? com_google_android_gms_internal_zzdy : new gj(com_google_android_gms_internal_zzdy).m6330a(null).m6331a();
    }

    private void m4028c(rc rcVar) {
        if (zzv.zzcR().m8638b() && !rcVar.f5609H && !TextUtils.isEmpty(rcVar.f5605D)) {
            sg.m8444b("Sending troubleshooting signals to the server.");
            zzv.zzcR().m8634a(this.f2553f.zzqr, this.f2553f.zzvf.f6636b, rcVar.f5605D, this.f2553f.zzvd);
            rcVar.f5609H = true;
        }
    }

    private void m4029f() {
        if (((Boolean) C1648if.cp.m6682c()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(m4026a(timer, new CountDownLatch(((Integer) C1648if.cr.m6682c()).intValue())), 0, ((Long) C1648if.cq.m6682c()).longValue());
        }
    }

    long m4030a(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            sg.m8449e("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            sg.m8449e("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }

    protected void m4031a() {
        sg.m8448d("Ad closing.");
        if (this.f2553f.f2729e != null) {
            try {
                this.f2553f.f2729e.m6313a();
            } catch (Throwable e) {
                sg.m8447c("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7228d();
            } catch (Throwable e2) {
                sg.m8447c("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void m4032a(int i) {
        sg.m8449e("Failed to load ad: " + i);
        this.f2551d = false;
        if (this.f2553f.f2729e != null) {
            try {
                this.f2553f.f2729e.m6314a(i);
            } catch (Throwable e) {
                sg.m8447c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7224a(i);
            } catch (Throwable e2) {
                sg.m8447c("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    protected void m4033a(View view) {
        com.google.android.gms.ads.internal.zzw.zza com_google_android_gms_ads_internal_zzw_zza = this.f2553f.f2727c;
        if (com_google_android_gms_ads_internal_zzw_zza != null) {
            com_google_android_gms_ads_internal_zzw_zza.addView(view, zzv.zzcL().m8581d());
        }
    }

    protected void m4034a(zzok com_google_android_gms_internal_zzok) {
        if (this.f2553f.f2741q != null) {
            try {
                String str = BuildConfig.VERSION_NAME;
                int i = 0;
                if (com_google_android_gms_internal_zzok != null) {
                    str = com_google_android_gms_internal_zzok.f6627b;
                    i = com_google_android_gms_internal_zzok.f6628c;
                }
                this.f2553f.f2741q.m7225a(new pw(str, i));
            } catch (Throwable e) {
                sg.m8447c("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    boolean m4035a(rc rcVar) {
        return false;
    }

    protected boolean m4036a(zzdy com_google_android_gms_internal_zzdy) {
        if (this.f2553f.f2727c == null) {
            return false;
        }
        ViewParent parent = this.f2553f.f2727c.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzv.zzcJ().m8525a(view, view.getContext());
    }

    protected void m4037b() {
        sg.m8448d("Ad leaving application.");
        if (this.f2553f.f2729e != null) {
            try {
                this.f2553f.f2729e.m6315b();
            } catch (Throwable e) {
                sg.m8447c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7229e();
            } catch (Throwable e2) {
                sg.m8447c("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void m4038b(rc rcVar) {
        if (rcVar == null) {
            sg.m8449e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        sg.m8444b("Pinging Impression URLs.");
        if (this.f2553f.zzvm != null) {
            this.f2553f.zzvm.m8369a();
        }
        if (rcVar.f5615e != null && !rcVar.f5607F) {
            zzv.zzcJ().m8514a(this.f2553f.zzqr, this.f2553f.zzvf.f6636b, rcVar.f5615e);
            rcVar.f5607F = true;
            m4028c(rcVar);
        }
    }

    protected void m4039c() {
        sg.m8448d("Ad opening.");
        if (this.f2553f.f2729e != null) {
            try {
                this.f2553f.f2729e.m6317d();
            } catch (Throwable e) {
                sg.m8447c("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7226b();
            } catch (Throwable e2) {
                sg.m8447c("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void m4040d() {
        sg.m8448d("Ad finished loading.");
        this.f2551d = false;
        if (this.f2553f.f2729e != null) {
            try {
                this.f2553f.f2729e.m6316c();
            } catch (Throwable e) {
                sg.m8447c("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7223a();
            } catch (Throwable e2) {
                sg.m8447c("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    public void destroy() {
        C1314c.m4631b("destroy must be called on the main UI thread.");
        this.f2552e.cancel();
        this.f2555h.m6058c(this.f2553f.zzvk);
        this.f2553f.destroy();
    }

    protected void m4041e() {
        if (this.f2553f.f2741q != null) {
            try {
                this.f2553f.f2741q.m7227c();
            } catch (Throwable e) {
                sg.m8447c("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public boolean isLoading() {
        return this.f2551d;
    }

    public boolean isReady() {
        C1314c.m4631b("isLoaded must be called on the main UI thread.");
        return this.f2553f.zzvh == null && this.f2553f.zzvi == null && this.f2553f.zzvk != null;
    }

    public void onAdClicked() {
        if (this.f2553f.zzvk == null) {
            sg.m8449e("Ad state was null when trying to ping click URLs.");
            return;
        }
        sg.m8444b("Pinging click URLs.");
        if (this.f2553f.zzvm != null) {
            this.f2553f.zzvm.m8373b();
        }
        if (this.f2553f.zzvk.f5613c != null) {
            zzv.zzcJ().m8514a(this.f2553f.zzqr, this.f2553f.zzvf.f6636b, this.f2553f.zzvk.f5613c);
        }
        if (this.f2553f.f2728d != null) {
            try {
                this.f2553f.f2728d.m6310a();
            } catch (Throwable e) {
                sg.m8447c("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, String str2) {
        if (this.f2553f.f2730f != null) {
            try {
                this.f2553f.f2730f.m6347a(str, str2);
            } catch (Throwable e) {
                sg.m8447c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        C1314c.m4631b("pause must be called on the main UI thread.");
    }

    public void resume() {
        C1314c.m4631b("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        sg.m8449e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        C1314c.m4631b("stopLoading must be called on the main UI thread.");
        this.f2551d = false;
        this.f2553f.zzi(true);
    }

    public void zza(gu guVar) {
        C1314c.m4631b("setAdListener must be called on the main UI thread.");
        this.f2553f.f2728d = guVar;
    }

    public void zza(gv gvVar) {
        C1314c.m4631b("setAdListener must be called on the main UI thread.");
        this.f2553f.f2729e = gvVar;
    }

    public void zza(hb hbVar) {
        C1314c.m4631b("setAppEventListener must be called on the main UI thread.");
        this.f2553f.f2730f = hbVar;
    }

    public void zza(hd hdVar) {
        C1314c.m4631b("setCorrelationIdProvider must be called on the main UI thread");
        this.f2553f.f2731g = hdVar;
    }

    public void zza(is isVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(nl nlVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(nq nqVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(qc qcVar) {
        C1314c.m4631b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f2553f.f2741q = qcVar;
    }

    public void zza(C1938a c1938a) {
        if (!(c1938a.f5595b.f6595n == -1 || TextUtils.isEmpty(c1938a.f5595b.f6606y))) {
            long a = m4030a(c1938a.f5595b.f6606y);
            if (a != -1) {
                im a2 = this.f2548a.m6741a(a + c1938a.f5595b.f6595n);
                this.f2548a.m6746a(a2, "stc");
            }
        }
        this.f2548a.m6743a(c1938a.f5595b.f6606y);
        this.f2548a.m6746a(this.f2549b, "arf");
        this.f2550c = this.f2548a.m6740a();
        this.f2548a.m6744a("gqi", c1938a.f5595b.f6607z);
        this.f2553f.zzvh = null;
        this.f2553f.zzvl = c1938a;
        zza(c1938a, this.f2548a);
    }

    protected abstract void zza(C1938a c1938a, io ioVar);

    public void zza(zzec com_google_android_gms_internal_zzec) {
        C1314c.m4631b("setAdSize must be called on the main UI thread.");
        this.f2553f.zzvj = com_google_android_gms_internal_zzec;
        if (!(this.f2553f.zzvk == null || this.f2553f.zzvk.f5612b == null || this.f2553f.zzvF != 0)) {
            this.f2553f.zzvk.f5612b.m8754a(com_google_android_gms_internal_zzec);
        }
        if (this.f2553f.f2727c != null) {
            if (this.f2553f.f2727c.getChildCount() > 1) {
                this.f2553f.f2727c.removeView(this.f2553f.f2727c.getNextView());
            }
            this.f2553f.f2727c.setMinimumWidth(com_google_android_gms_internal_zzec.f6457g);
            this.f2553f.f2727c.setMinimumHeight(com_google_android_gms_internal_zzec.f6454d);
            this.f2553f.f2727c.requestLayout();
        }
    }

    public void zza(zzfn com_google_android_gms_internal_zzfn) {
        C1314c.m4631b("setVideoOptions must be called on the main UI thread.");
        this.f2553f.f2739o = com_google_android_gms_internal_zzfn;
    }

    public void zza(HashSet<rd> hashSet) {
        this.f2553f.zza(hashSet);
    }

    protected abstract boolean zza(rc rcVar, rc rcVar2);

    protected abstract boolean zza(zzdy com_google_android_gms_internal_zzdy, io ioVar);

    public void zzb(rc rcVar) {
        this.f2548a.m6746a(this.f2550c, "awr");
        this.f2553f.zzvi = null;
        if (!(rcVar.f5614d == -2 || rcVar.f5614d == 3)) {
            zzv.zzcN().m8400a(this.f2553f.zzdi());
        }
        if (rcVar.f5614d == -1) {
            this.f2551d = false;
            return;
        }
        if (m4035a(rcVar)) {
            sg.m8444b("Ad refresh scheduled.");
        }
        if (rcVar.f5614d != -2) {
            m4032a(rcVar.f5614d);
            return;
        }
        if (this.f2553f.zzvD == null) {
            this.f2553f.zzvD = new rj(this.f2553f.zzvd);
        }
        this.f2555h.m6057b(this.f2553f.zzvk);
        if (zza(this.f2553f.zzvk, rcVar)) {
            this.f2553f.zzvk = rcVar;
            this.f2553f.zzdr();
            this.f2548a.m6744a("is_mraid", this.f2553f.zzvk.m8364a() ? "1" : "0");
            this.f2548a.m6744a("is_mediation", this.f2553f.zzvk.f5624n ? "1" : "0");
            if (!(this.f2553f.zzvk.f5612b == null || this.f2553f.zzvk.f5612b.m8776l() == null)) {
                this.f2548a.m6744a("is_delay_pl", this.f2553f.zzvk.f5612b.m8776l().m8820f() ? "1" : "0");
            }
            this.f2548a.m6746a(this.f2549b, "ttc");
            if (zzv.zzcN().m8412f() != null) {
                zzv.zzcN().m8412f().m6719a(this.f2548a);
            }
            if (this.f2553f.zzdm()) {
                m4040d();
            }
        }
        if (rcVar.f5610I != null) {
            zzv.zzcJ().m8517a(this.f2553f.zzqr, rcVar.f5610I);
        }
    }

    public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
        C1314c.m4631b("loadAd must be called on the main UI thread.");
        zzv.zzcO().m6266a();
        if (((Boolean) C1648if.aI.m6682c()).booleanValue()) {
            zzdy.m9766a(com_google_android_gms_internal_zzdy);
        }
        zzdy b = m4027b(com_google_android_gms_internal_zzdy);
        if (this.f2553f.zzvh == null && this.f2553f.zzvi == null) {
            sg.m8448d("Starting ad request.");
            zzbB();
            this.f2549b = this.f2548a.m6740a();
            if (!b.f6438f) {
                String valueOf = String.valueOf(gr.m6416a().m8692a(this.f2553f.zzqr));
                sg.m8448d(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.f2552e.zzg(b);
            this.f2551d = zza(b, this.f2548a);
            return this.f2551d;
        }
        if (this.f2554g != null) {
            sg.m8449e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            sg.m8449e("Loading already in progress, saving this object for future refreshes.");
        }
        this.f2554g = b;
        return false;
    }

    public void zzbB() {
        this.f2548a = new io(((Boolean) C1648if.f4357U.m6682c()).booleanValue(), "load_ad", this.f2553f.zzvj.f6452b);
        this.f2549b = new im(-1, null, null);
        this.f2550c = new im(-1, null, null);
    }

    public C1108c zzbC() {
        C1314c.m4631b("getAdFrame must be called on the main UI thread.");
        return C1111d.m3896a(this.f2553f.f2727c);
    }

    public zzec zzbD() {
        C1314c.m4631b("getAdSize must be called on the main UI thread.");
        return this.f2553f.zzvj == null ? null : new zzfl(this.f2553f.zzvj);
    }

    public void zzbE() {
        m4037b();
    }

    public void zzbF() {
        C1314c.m4631b("recordManualImpression must be called on the main UI thread.");
        if (this.f2553f.zzvk == null) {
            sg.m8449e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        sg.m8444b("Pinging manual tracking URLs.");
        if (this.f2553f.zzvk.f5616f != null && !this.f2553f.zzvk.f5608G) {
            zzv.zzcJ().m8514a(this.f2553f.zzqr, this.f2553f.zzvf.f6636b, this.f2553f.zzvk.f5616f);
            this.f2553f.zzvk.f5608G = true;
            m4028c(this.f2553f.zzvk);
        }
    }

    public hg zzbG() {
        return null;
    }

    public zzd zzbz() {
        return this.f2556i;
    }

    public void zzd(zzdy com_google_android_gms_internal_zzdy) {
        if (m4036a(com_google_android_gms_internal_zzdy)) {
            zzb(com_google_android_gms_internal_zzdy);
            return;
        }
        sg.m8448d("Ad is not visible. Not refreshing ad.");
        this.f2552e.zzh(com_google_android_gms_internal_zzdy);
    }
}
