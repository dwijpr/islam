package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.sy;
import com.google.android.gms.internal.sy.C1166e;
import com.google.android.gms.internal.sy.C1168c;
import com.google.android.gms.internal.tc;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzqa;
import java.util.List;

@op
public class zzf extends zzc implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f2582l;

    /* renamed from: com.google.android.gms.ads.internal.zzf.1 */
    class C11651 implements Runnable {
        final /* synthetic */ zzf f2576a;

        C11651(zzf com_google_android_gms_ads_internal_zzf) {
            this.f2576a = com_google_android_gms_ads_internal_zzf;
        }

        public void run() {
            this.f2576a.m4062c(this.f2576a.f.zzvk);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzf.2 */
    class C11672 implements C1166e {
        final /* synthetic */ rc f2577a;
        final /* synthetic */ Runnable f2578b;

        C11672(zzf com_google_android_gms_ads_internal_zzf, rc rcVar, Runnable runnable) {
            this.f2577a = rcVar;
            this.f2578b = runnable;
        }

        public void m4053a() {
            if (!this.f2577a.f5623m) {
                zzv.zzcJ();
                rq.m8487b(this.f2578b);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzf.3 */
    class C11693 implements C1168c {
        final /* synthetic */ rc f2579a;
        final /* synthetic */ zzf f2580b;

        C11693(zzf com_google_android_gms_ads_internal_zzf, rc rcVar) {
            this.f2580b = com_google_android_gms_ads_internal_zzf;
            this.f2579a = rcVar;
        }

        public void m4055a() {
            new fh(this.f2580b.f.zzqr, this.f2579a.f5612b.m8760b()).m6151a(this.f2579a.f5612b);
        }
    }

    public class zza {
        final /* synthetic */ zzf f2581a;

        public zza(zzf com_google_android_gms_ads_internal_zzf) {
            this.f2581a = com_google_android_gms_ads_internal_zzf;
        }

        public void onClick() {
            this.f2581a.onAdClicked();
        }
    }

    public zzf(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, com_google_android_gms_internal_zzec, str, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
    }

    private zzec m4056a(C1938a c1938a) {
        if (c1938a.f5595b.f6566A) {
            return this.f.zzvj;
        }
        AdSize adSize;
        String str = c1938a.f5595b.f6594m;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            adSize = this.f.zzvj.m9773b();
        }
        return new zzec(this.f.zzqr, adSize);
    }

    private boolean m4057a(rc rcVar, rc rcVar2) {
        if (rcVar2.f5624n) {
            View zzg = zzo.zzg(rcVar2);
            if (zzg == null) {
                sg.m8449e("Could not get mediation view");
                return false;
            }
            View nextView = this.f.f2727c.getNextView();
            if (nextView != null) {
                if (nextView instanceof sx) {
                    ((sx) nextView).destroy();
                }
                this.f.f2727c.removeView(nextView);
            }
            if (!zzo.zzh(rcVar2)) {
                try {
                    m4033a(zzg);
                } catch (Throwable th) {
                    sg.m8447c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(rcVar2.f5632v == null || rcVar2.f5612b == null)) {
            rcVar2.f5612b.m8754a(rcVar2.f5632v);
            this.f.f2727c.removeAllViews();
            this.f.f2727c.setMinimumWidth(rcVar2.f5632v.f6457g);
            this.f.f2727c.setMinimumHeight(rcVar2.f5632v.f6454d);
            m4033a(rcVar2.f5612b.m8760b());
        }
        if (this.f.f2727c.getChildCount() > 1) {
            this.f.f2727c.showNext();
        }
        if (rcVar != null) {
            View nextView2 = this.f.f2727c.getNextView();
            if (nextView2 instanceof sx) {
                ((sx) nextView2).m8750a(this.f.zzqr, this.f.zzvj, this.a);
            } else if (nextView2 != null) {
                this.f.f2727c.removeView(nextView2);
            }
            this.f.zzdl();
        }
        this.f.f2727c.setVisibility(0);
        return true;
    }

    private void m4058d(rc rcVar) {
        if (!C1387m.m4961c()) {
            return;
        }
        if (this.f.zzdm()) {
            if (rcVar.f5612b != null) {
                if (rcVar.f5620j != null) {
                    this.h.m6051a(this.f.zzvj, rcVar);
                }
                if (rcVar.m8364a()) {
                    new fh(this.f.zzqr, rcVar.f5612b.m8760b()).m6151a(rcVar.f5612b);
                } else {
                    rcVar.f5612b.m8776l().m8808a(new C11693(this, rcVar));
                }
            }
        } else if (this.f.f2744t != null && rcVar.f5620j != null) {
            this.h.m6052a(this.f.zzvj, rcVar, this.f.f2744t);
        }
    }

    protected sx m4059a(C1938a c1938a, zze com_google_android_gms_ads_internal_zze, qw qwVar) {
        if (this.f.zzvj.f6458h == null && this.f.zzvj.f6460j) {
            this.f.zzvj = m4056a(c1938a);
        }
        return super.m4050a(c1938a, com_google_android_gms_ads_internal_zze, qwVar);
    }

    protected void m4060a(rc rcVar, boolean z) {
        super.m4043a(rcVar, z);
        if (zzo.zzh(rcVar)) {
            zzo.zza(rcVar, new zza(this));
        }
    }

    zzdy m4061b(zzdy com_google_android_gms_internal_zzdy) {
        if (com_google_android_gms_internal_zzdy.f6440h == this.f2582l) {
            return com_google_android_gms_internal_zzdy;
        }
        int i = com_google_android_gms_internal_zzdy.f6433a;
        long j = com_google_android_gms_internal_zzdy.f6434b;
        Bundle bundle = com_google_android_gms_internal_zzdy.f6435c;
        int i2 = com_google_android_gms_internal_zzdy.f6436d;
        List list = com_google_android_gms_internal_zzdy.f6437e;
        boolean z = com_google_android_gms_internal_zzdy.f6438f;
        int i3 = com_google_android_gms_internal_zzdy.f6439g;
        boolean z2 = com_google_android_gms_internal_zzdy.f6440h || this.f2582l;
        return new zzdy(i, j, bundle, i2, list, z, i3, z2, com_google_android_gms_internal_zzdy.f6441i, com_google_android_gms_internal_zzdy.f6442j, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6444l, com_google_android_gms_internal_zzdy.f6445m, com_google_android_gms_internal_zzdy.f6446n, com_google_android_gms_internal_zzdy.f6447o, com_google_android_gms_internal_zzdy.f6448p, com_google_android_gms_internal_zzdy.f6449q, com_google_android_gms_internal_zzdy.f6450r);
    }

    void m4062c(rc rcVar) {
        if (rcVar != null && !rcVar.f5623m && this.f.f2727c != null && zzv.zzcJ().m8525a(this.f.f2727c, this.f.zzqr) && this.f.f2727c.getGlobalVisibleRect(new Rect(), null)) {
            if (!(rcVar == null || rcVar.f5612b == null || rcVar.f5612b.m8776l() == null)) {
                rcVar.f5612b.m8776l().m8809a(null);
            }
            m4060a(rcVar, false);
            rcVar.f5623m = true;
        }
    }

    protected boolean m4063f() {
        boolean z = true;
        if (!zzv.zzcJ().m8524a(this.f.zzqr.getPackageManager(), this.f.zzqr.getPackageName(), "android.permission.INTERNET")) {
            gr.m6416a().m8699a(this.f.f2727c, this.f.zzvj, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzv.zzcJ().m8523a(this.f.zzqr)) {
            gr.m6416a().m8699a(this.f.f2727c, this.f.zzvj, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.f.f2727c == null)) {
            this.f.f2727c.setVisibility(0);
        }
        return z;
    }

    public void onGlobalLayout() {
        m4062c(this.f.zzvk);
    }

    public void onScrollChanged() {
        m4062c(this.f.zzvk);
    }

    public void setManualImpressionsEnabled(boolean z) {
        C1314c.m4631b("setManualImpressionsEnabled must be called from the main thread.");
        this.f2582l = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(rc rcVar, rc rcVar2) {
        if (!super.zza(rcVar, rcVar2)) {
            return false;
        }
        if (!this.f.zzdm() || m4057a(rcVar, rcVar2)) {
            tc z;
            if (rcVar2.f5621k) {
                m4062c(rcVar2);
                zzv.zzdh().m8725a(this.f.f2727c, (OnGlobalLayoutListener) this);
                zzv.zzdh().m8726a(this.f.f2727c, (OnScrollChangedListener) this);
                if (!rcVar2.f5623m) {
                    Runnable c11651 = new C11651(this);
                    sy l = rcVar2.f5612b != null ? rcVar2.f5612b.m8776l() : null;
                    if (l != null) {
                        l.m8809a(new C11672(this, rcVar2, c11651));
                    }
                }
            } else if (!this.f.zzdn() || ((Boolean) C1648if.ca.m6682c()).booleanValue()) {
                m4060a(rcVar2, false);
            }
            if (rcVar2.f5612b != null) {
                z = rcVar2.f5612b.m8790z();
                sy l2 = rcVar2.f5612b.m8776l();
                if (l2 != null) {
                    l2.m8822h();
                }
            } else {
                z = null;
            }
            if (!(this.f.f2739o == null || z == null)) {
                z.m8978b(this.f.f2739o.f6478b);
            }
            m4058d(rcVar2);
            return true;
        }
        m4032a(0);
        return false;
    }

    public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
        return super.zzb(m4061b(com_google_android_gms_internal_zzdy));
    }

    public hg zzbG() {
        C1314c.m4631b("getVideoController must be called from the main thread.");
        return (this.f.zzvk == null || this.f.zzvk.f5612b == null) ? null : this.f.zzvk.f5612b.m8790z();
    }
}
