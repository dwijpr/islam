package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.recyclerview.BuildConfig;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.kq;
import com.google.android.gms.internal.kq.C1180a;
import com.google.android.gms.internal.lt;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.pj;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rl;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.sy;
import com.google.android.gms.internal.sy.C1168c;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzqa;
import java.util.Collections;
import org.json.JSONObject;

@op
public class zzl extends zzc implements kl, C1180a {
    protected transient boolean f2628l;
    private int f2629m;
    private boolean f2630n;
    private float f2631o;

    /* renamed from: com.google.android.gms.ads.internal.zzl.1 */
    class C11771 implements C1168c {
        final /* synthetic */ rc f2622a;
        final /* synthetic */ zzl f2623b;

        C11771(zzl com_google_android_gms_ads_internal_zzl, rc rcVar) {
            this.f2623b = com_google_android_gms_ads_internal_zzl;
            this.f2622a = rcVar;
        }

        public void m4084a() {
            new fh(this.f2623b.f.zzqr, this.f2622a.f5612b.m8760b()).m6151a(this.f2622a.f5612b);
        }
    }

    @op
    /* renamed from: com.google.android.gms.ads.internal.zzl.a */
    private class C1179a extends rl {
        final /* synthetic */ zzl f2626a;
        private final int f2627b;

        /* renamed from: com.google.android.gms.ads.internal.zzl.a.1 */
        class C11781 implements Runnable {
            final /* synthetic */ AdOverlayInfoParcel f2624a;
            final /* synthetic */ C1179a f2625b;

            C11781(C1179a c1179a, AdOverlayInfoParcel adOverlayInfoParcel) {
                this.f2625b = c1179a;
                this.f2624a = adOverlayInfoParcel;
            }

            public void run() {
                zzv.zzcH().zza(this.f2625b.f2626a.f.zzqr, this.f2624a);
            }
        }

        public C1179a(zzl com_google_android_gms_ads_internal_zzl, int i) {
            this.f2626a = com_google_android_gms_ads_internal_zzl;
            this.f2627b = i;
        }

        public void onStop() {
        }

        public void zzcm() {
            zzm com_google_android_gms_ads_internal_zzm = new zzm(this.f2626a.f.f2746v, this.f2626a.m4093g(), this.f2626a.f2630n, this.f2626a.f2631o, this.f2626a.f.f2746v ? this.f2627b : -1);
            int q = this.f2626a.f.zzvk.f5612b.m8781q();
            rq.f5755a.post(new C11781(this, new AdOverlayInfoParcel(this.f2626a, this.f2626a, this.f2626a, this.f2626a.f.zzvk.f5612b, q == -1 ? this.f2626a.f.zzvk.f5617g : q, this.f2626a.f.zzvf, this.f2626a.f.zzvk.f5604C, com_google_android_gms_ads_internal_zzm)));
        }
    }

    public zzl(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, com_google_android_gms_internal_zzec, str, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
        this.f2629m = -1;
        this.f2628l = false;
    }

    static C1938a m4085a(C1938a c1938a) {
        try {
            String jSONObject = pj.m8126a(c1938a.f5595b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, c1938a.f5594a.f6544e);
            lt ltVar = new lt(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            zzmk com_google_android_gms_internal_zzmk = c1938a.f5595b;
            lu luVar = new lu(Collections.singletonList(ltVar), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmk.f6575J, com_google_android_gms_internal_zzmk.f6576K, BuildConfig.VERSION_NAME, -1, 0, 1, null, 0, -1, -1, false);
            return new C1938a(c1938a.f5594a, new zzmk(c1938a.f5594a, com_google_android_gms_internal_zzmk.f6583b, com_google_android_gms_internal_zzmk.f6584c, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmk.f6588g, true, com_google_android_gms_internal_zzmk.f6590i, Collections.emptyList(), com_google_android_gms_internal_zzmk.f6592k, com_google_android_gms_internal_zzmk.f6593l, com_google_android_gms_internal_zzmk.f6594m, com_google_android_gms_internal_zzmk.f6595n, com_google_android_gms_internal_zzmk.f6596o, com_google_android_gms_internal_zzmk.f6597p, com_google_android_gms_internal_zzmk.f6598q, null, com_google_android_gms_internal_zzmk.f6600s, com_google_android_gms_internal_zzmk.f6601t, com_google_android_gms_internal_zzmk.f6602u, com_google_android_gms_internal_zzmk.f6603v, com_google_android_gms_internal_zzmk.f6604w, com_google_android_gms_internal_zzmk.f6607z, com_google_android_gms_internal_zzmk.f6566A, com_google_android_gms_internal_zzmk.f6567B, null, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmk.f6571F, com_google_android_gms_internal_zzmk.f6572G, com_google_android_gms_internal_zzmk.f6573H, com_google_android_gms_internal_zzmk.f6574I, com_google_android_gms_internal_zzmk.f6575J, com_google_android_gms_internal_zzmk.f6576K, com_google_android_gms_internal_zzmk.f6577L, null, com_google_android_gms_internal_zzmk.f6579N, com_google_android_gms_internal_zzmk.f6580O), luVar, c1938a.f5597d, c1938a.f5598e, c1938a.f5599f, c1938a.f5600g, null);
        } catch (Throwable e) {
            sg.m8445b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return c1938a;
        }
    }

    private void m4086a(Bundle bundle) {
        zzv.zzcJ().m8535b(this.f.zzqr, this.f.zzvf.f6636b, "gmob-apps", bundle, false);
    }

    protected sx m4089a(C1938a c1938a, zze com_google_android_gms_ads_internal_zze, qw qwVar) {
        sx a = zzv.zzcK().m8831a(this.f.zzqr, this.f.zzvj, false, false, this.f.f2726b, this.f.zzvf, this.a, this, this.i);
        a.m8776l().m8804a(this, null, this, this, ((Boolean) C1648if.ar.m6682c()).booleanValue(), this, this, com_google_android_gms_ads_internal_zze, null, qwVar);
        m4051a(a);
        a.m8763b(c1938a.f5594a.f6562w);
        kq.m7125a(a, (C1180a) this);
        return a;
    }

    protected void m4090a() {
        zzck();
        super.m4031a();
    }

    protected boolean m4091a(zzdy com_google_android_gms_internal_zzdy, rc rcVar, boolean z) {
        if (this.f.zzdm() && rcVar.f5612b != null) {
            zzv.zzcL().m8573a(rcVar.f5612b);
        }
        return this.e.zzcv();
    }

    protected void m4092d() {
        super.m4040d();
        this.f2628l = true;
    }

    protected boolean m4093g() {
        if (!(this.f.zzqr instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.f.zzqr).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void showInterstitial() {
        C1314c.m4631b("showInterstitial must be called on the main UI thread.");
        if (this.f.zzvk == null) {
            sg.m8449e("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) C1648if.bb.m6682c()).booleanValue()) {
            Bundle bundle;
            String packageName = this.f.zzqr.getApplicationContext() != null ? this.f.zzqr.getApplicationContext().getPackageName() : this.f.zzqr.getPackageName();
            if (!this.f2628l) {
                sg.m8449e("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                m4086a(bundle);
            }
            if (!zzv.zzcJ().m8550g(this.f.zzqr)) {
                sg.m8449e("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                m4086a(bundle);
            }
        }
        if (!this.f.zzdn()) {
            if (this.f.zzvk.f5624n && this.f.zzvk.f5626p != null) {
                try {
                    this.f.zzvk.f5626p.m7472b();
                } catch (Throwable e) {
                    sg.m8447c("Could not show interstitial.", e);
                    zzck();
                }
            } else if (this.f.zzvk.f5612b == null) {
                sg.m8449e("The interstitial failed to load.");
            } else if (this.f.zzvk.f5612b.m8780p()) {
                sg.m8449e("The interstitial is already showing.");
            } else {
                this.f.zzvk.f5612b.m8759a(true);
                if (this.f.zzvk.f5620j != null) {
                    this.h.m6051a(this.f.zzvj, this.f.zzvk);
                }
                if (C1387m.m4961c()) {
                    rc rcVar = this.f.zzvk;
                    if (rcVar.m8364a()) {
                        new fh(this.f.zzqr, rcVar.f5612b.m8760b()).m6151a(rcVar.f5612b);
                    } else {
                        rcVar.f5612b.m8776l().m8808a(new C11771(this, rcVar));
                    }
                }
                Bitmap h = this.f.f2746v ? zzv.zzcJ().m8551h(this.f.zzqr) : null;
                this.f2629m = zzv.zzde().m8671a(h);
                if (!((Boolean) C1648if.bT.m6682c()).booleanValue() || h == null) {
                    zzm com_google_android_gms_ads_internal_zzm = new zzm(this.f.f2746v, m4093g(), false, 0.0f, -1);
                    int q = this.f.zzvk.f5612b.m8781q();
                    if (q == -1) {
                        q = this.f.zzvk.f5617g;
                    }
                    zzv.zzcH().zza(this.f.zzqr, new AdOverlayInfoParcel(this, this, this, this.f.zzvk.f5612b, q, this.f.zzvf, this.f.zzvk.f5604C, com_google_android_gms_ads_internal_zzm));
                    return;
                }
                new C1179a(this, this.f2629m).zziw();
            }
        }
    }

    public void zza(C1938a c1938a, io ioVar) {
        Object obj = 1;
        if (!((Boolean) C1648if.aK.m6682c()).booleanValue()) {
            super.zza(c1938a, ioVar);
        } else if (c1938a.f5598e != -2) {
            super.zza(c1938a, ioVar);
        } else {
            Bundle bundle = c1938a.f5594a.f6542c.f6445m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            Object obj2 = (bundle == null || !bundle.containsKey("gw")) ? 1 : null;
            if (c1938a.f5595b.f6589h) {
                obj = null;
            }
            if (!(obj2 == null || r2 == null)) {
                this.f.zzvl = m4085a(c1938a);
            }
            super.zza(this.f.zzvl, ioVar);
        }
    }

    public void zza(boolean z, float f) {
        this.f2630n = z;
        this.f2631o = f;
    }

    public boolean zza(rc rcVar, rc rcVar2) {
        if (!super.zza(rcVar, rcVar2)) {
            return false;
        }
        if (!(this.f.zzdm() || this.f.f2744t == null || rcVar2.f5620j == null)) {
            this.h.m6052a(this.f.zzvj, rcVar2, this.f.f2744t);
        }
        return true;
    }

    public boolean zza(zzdy com_google_android_gms_internal_zzdy, io ioVar) {
        if (this.f.zzvk == null) {
            return super.zza(com_google_android_gms_internal_zzdy, ioVar);
        }
        sg.m8449e("An interstitial is already loading. Aborting.");
        return false;
    }

    public void zzb(zzok com_google_android_gms_internal_zzok) {
        if (this.f.zzvk != null) {
            if (this.f.zzvk.f5636z != null) {
                zzv.zzcJ().m8514a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk.f5636z);
            }
            if (this.f.zzvk.f5634x != null) {
                com_google_android_gms_internal_zzok = this.f.zzvk.f5634x;
            }
        }
        m4034a(com_google_android_gms_internal_zzok);
    }

    public void zzbO() {
        recordImpression();
        super.zzbO();
        if (this.f.zzvk != null && this.f.zzvk.f5612b != null) {
            sy l = this.f.zzvk.f5612b.m8776l();
            if (l != null) {
                l.m8822h();
            }
        }
    }

    public void zzck() {
        zzv.zzde().m8673b(Integer.valueOf(this.f2629m));
        if (this.f.zzdm()) {
            this.f.zzdj();
            this.f.zzvk = null;
            this.f.f2746v = false;
            this.f2628l = false;
        }
    }

    public void zzcl() {
        if (!(this.f.zzvk == null || this.f.zzvk.f5635y == null)) {
            zzv.zzcJ().m8514a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk.f5635y);
        }
        m4041e();
    }

    public void zzg(boolean z) {
        this.f.f2746v = z;
    }
}
