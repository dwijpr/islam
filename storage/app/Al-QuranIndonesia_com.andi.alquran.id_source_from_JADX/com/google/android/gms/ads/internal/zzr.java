package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p014g.C0297j;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mh;
import com.google.android.gms.internal.mi;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzqa;
import java.util.List;

@op
public class zzr extends zzb {
    private sx f2660l;

    /* renamed from: com.google.android.gms.ads.internal.zzr.1 */
    class C11871 implements Runnable {
        final /* synthetic */ C1938a f2651a;
        final /* synthetic */ zzr f2652b;

        C11871(zzr com_google_android_gms_ads_internal_zzr, C1938a c1938a) {
            this.f2652b = com_google_android_gms_ads_internal_zzr;
            this.f2651a = c1938a;
        }

        public void run() {
            this.f2652b.zzb(new rc(this.f2651a, null, null, null, null, null, null, null));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzr.2 */
    class C11882 implements Runnable {
        final /* synthetic */ iy f2653a;
        final /* synthetic */ zzr f2654b;

        C11882(zzr com_google_android_gms_ads_internal_zzr, iy iyVar) {
            this.f2654b = com_google_android_gms_ads_internal_zzr;
            this.f2653a = iyVar;
        }

        public void run() {
            try {
                if (this.f2654b.f.f2734j != null) {
                    this.f2654b.f.f2734j.m7037a(this.f2653a);
                }
            } catch (Throwable e) {
                sg.m8447c("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzr.3 */
    class C11893 implements Runnable {
        final /* synthetic */ iz f2655a;
        final /* synthetic */ zzr f2656b;

        C11893(zzr com_google_android_gms_ads_internal_zzr, iz izVar) {
            this.f2656b = com_google_android_gms_ads_internal_zzr;
            this.f2655a = izVar;
        }

        public void run() {
            try {
                if (this.f2656b.f.f2735k != null) {
                    this.f2656b.f.f2735k.m7040a(this.f2655a);
                }
            } catch (Throwable e) {
                sg.m8447c("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzr.4 */
    class C11904 implements Runnable {
        final /* synthetic */ String f2657a;
        final /* synthetic */ rc f2658b;
        final /* synthetic */ zzr f2659c;

        C11904(zzr com_google_android_gms_ads_internal_zzr, String str, rc rcVar) {
            this.f2659c = com_google_android_gms_ads_internal_zzr;
            this.f2657a = str;
            this.f2658b = rcVar;
        }

        public void run() {
            try {
                ((jv) this.f2659c.f.f2737m.get(this.f2657a)).m7046a((ja) this.f2658b.f5606E);
            } catch (Throwable e) {
                sg.m8447c("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
            }
        }
    }

    public zzr(Context context, zzd com_google_android_gms_ads_internal_zzd, zzec com_google_android_gms_internal_zzec, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa) {
        super(context, com_google_android_gms_internal_zzec, str, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
    }

    private static iy m4119a(mh mhVar) {
        return new iy(mhVar.m7514a(), mhVar.m7516b(), mhVar.m7518c(), mhVar.m7520d() != null ? mhVar.m7520d() : null, mhVar.m7521e(), mhVar.m7522f(), mhVar.m7523g(), mhVar.m7524h(), null, mhVar.m7528l(), mhVar.m7529m(), null);
    }

    private static iz m4120a(mi miVar) {
        return new iz(miVar.m7547a(), miVar.m7549b(), miVar.m7551c(), miVar.m7553d() != null ? miVar.m7553d() : null, miVar.m7554e(), miVar.m7555f(), null, miVar.m7559j());
    }

    private void m4121a(iy iyVar) {
        rq.f5755a.post(new C11882(this, iyVar));
    }

    private void m4122a(iz izVar) {
        rq.f5755a.post(new C11893(this, izVar));
    }

    private void m4123a(rc rcVar, String str) {
        rq.f5755a.post(new C11904(this, str, rcVar));
    }

    protected boolean m4124a(zzdy com_google_android_gms_internal_zzdy, rc rcVar, boolean z) {
        return this.e.zzcv();
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(C0297j<String, jv> c0297j) {
        C1314c.m4631b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.f.f2737m = c0297j;
    }

    public void zza(is isVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(jb jbVar) {
        if (this.f2660l != null) {
            this.f2660l.m8752a(jbVar);
        }
    }

    public void zza(jd jdVar) {
        if (this.f.zzvk.f5620j != null) {
            zzv.zzcN().m8424r().m6055a(this.f.zzvj, this.f.zzvk, jdVar);
        }
    }

    public void zza(nl nlVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(C1938a c1938a, io ioVar) {
        if (c1938a.f5597d != null) {
            this.f.zzvj = c1938a.f5597d;
        }
        if (c1938a.f5598e != -2) {
            rq.f5755a.post(new C11871(this, c1938a));
            return;
        }
        this.f.zzvF = 0;
        this.f.zzvi = zzv.zzcI().m7817a(this.f.zzqr, this, c1938a, this.f.f2726b, null, this.j, this, ioVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(this.f.zzvi.getClass().getName());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    protected boolean zza(rc rcVar, rc rcVar2) {
        zzb(null);
        if (this.f.zzdm()) {
            if (rcVar2.f5624n) {
                try {
                    mh h = rcVar2.f5626p != null ? rcVar2.f5626p.m7478h() : null;
                    mi i = rcVar2.f5626p != null ? rcVar2.f5626p.m7479i() : null;
                    if (h == null || this.f.f2734j == null) {
                        if (i != null) {
                            if (this.f.f2735k != null) {
                                iz a = m4120a(i);
                                a.m6836a(new jc(this.f.zzqr, this, this.f.f2726b, i, (C1660a) a));
                                m4122a(a);
                            }
                        }
                        sg.m8449e("No matching mapper/listener for retrieved native ad template.");
                        m4032a(0);
                        return false;
                    }
                    iy a2 = m4119a(h);
                    a2.m6809a(new jc(this.f.zzqr, this, this.f.f2726b, h, (C1660a) a2));
                    m4121a(a2);
                } catch (Throwable e) {
                    sg.m8447c("Failed to get native ad mapper", e);
                }
            } else {
                C1660a c1660a = rcVar2.f5606E;
                if ((c1660a instanceof iz) && this.f.f2735k != null) {
                    m4122a((iz) rcVar2.f5606E);
                } else if ((c1660a instanceof iy) && this.f.f2734j != null) {
                    m4121a((iy) rcVar2.f5606E);
                } else if (!(c1660a instanceof ja) || this.f.f2737m == null || this.f.f2737m.get(((ja) c1660a).m6913l()) == null) {
                    sg.m8449e("No matching listener for retrieved native ad template.");
                    m4032a(0);
                    return false;
                } else {
                    m4123a(rcVar2, ((ja) c1660a).m6913l());
                }
            }
            return super.zza(rcVar, rcVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void zzb(C0297j<String, ju> c0297j) {
        C1314c.m4631b("setOnCustomClickListener must be called on the main UI thread.");
        this.f.f2736l = c0297j;
    }

    public void zzb(js jsVar) {
        C1314c.m4631b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.f.f2734j = jsVar;
    }

    public void zzb(jt jtVar) {
        C1314c.m4631b("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.f.f2735k = jtVar;
    }

    public void zzb(zzgw com_google_android_gms_internal_zzgw) {
        C1314c.m4631b("setNativeAdOptions must be called on the main UI thread.");
        this.f.f2738n = com_google_android_gms_internal_zzgw;
    }

    public void zzb(List<String> list) {
        C1314c.m4631b("setNativeTemplates must be called on the main UI thread.");
        this.f.f2742r = list;
    }

    public void zzc(sx sxVar) {
        this.f2660l = sxVar;
    }

    public void zzcr() {
        if (this.f.zzvk == null || this.f2660l == null) {
            sg.m8449e("Request to enable ActiveView before adState is available.");
        } else {
            zzv.zzcN().m8424r().m6053a(this.f.zzvj, this.f.zzvk, this.f2660l.m8760b(), this.f2660l);
        }
    }

    public C0297j<String, jv> zzcs() {
        C1314c.m4631b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.f.f2737m;
    }

    public void zzct() {
        if (this.f2660l != null) {
            this.f2660l.destroy();
            this.f2660l = null;
        }
    }

    public void zzcu() {
        if (this.f2660l != null && this.f2660l.m8790z() != null && this.f.f2738n != null && this.f.f2738n.f6484f != null) {
            this.f2660l.m8790z().m8978b(this.f.f2738n.f6484f.f6478b);
        }
    }

    public ju zzz(String str) {
        C1314c.m4631b("getOnCustomClickListener must be called on the main UI thread.");
        return (ju) this.f.f2736l.get(str);
    }
}
