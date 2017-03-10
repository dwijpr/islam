package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.concurrent.atomic.AtomicBoolean;

@op
public class hj {
    final gt f4269a;
    private final mc f4270b;
    private final gm f4271c;
    private final AtomicBoolean f4272d;
    private final VideoController f4273e;
    private ge f4274f;
    private AdListener f4275g;
    private AdSize[] f4276h;
    private AppEventListener f4277i;
    private Correlator f4278j;
    private gz f4279k;
    private InAppPurchaseListener f4280l;
    private OnCustomRenderedAdLoadedListener f4281m;
    private PlayStorePurchaseListener f4282n;
    private VideoOptions f4283o;
    private String f4284p;
    private String f4285q;
    private ViewGroup f4286r;
    private int f4287s;
    private boolean f4288t;

    /* renamed from: com.google.android.gms.internal.hj.1 */
    class C16281 extends gt {
        final /* synthetic */ hj f4268a;

        C16281(hj hjVar) {
            this.f4268a = hjVar;
        }

        public void onAdFailedToLoad(int i) {
            this.f4268a.f4273e.zza(this.f4268a.m6561o());
            super.onAdFailedToLoad(i);
        }

        public void onAdLoaded() {
            this.f4268a.f4273e.zza(this.f4268a.m6561o());
            super.onAdLoaded();
        }
    }

    public hj(ViewGroup viewGroup) {
        this(viewGroup, null, false, gm.m6341a(), 0);
    }

    public hj(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, gm.m6341a(), i);
    }

    public hj(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, gm.m6341a(), 0);
    }

    public hj(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, gm.m6341a(), i);
    }

    hj(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, gm gmVar, int i) {
        this(viewGroup, attributeSet, z, gmVar, null, i);
    }

    hj(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, gm gmVar, gz gzVar, int i) {
        this.f4270b = new mc();
        this.f4273e = new VideoController();
        this.f4269a = new C16281(this);
        this.f4286r = viewGroup;
        this.f4271c = gmVar;
        this.f4279k = gzVar;
        this.f4272d = new AtomicBoolean(false);
        this.f4287s = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                gp gpVar = new gp(context, attributeSet);
                this.f4276h = gpVar.m6352a(z);
                this.f4284p = gpVar.m6351a();
                if (viewGroup.isInEditMode()) {
                    gr.m6416a().m8698a(viewGroup, m6529a(context, this.f4276h[0], this.f4287s), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                gr.m6416a().m8699a(viewGroup, new zzec(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzec m6529a(Context context, AdSize adSize, int i) {
        zzec com_google_android_gms_internal_zzec = new zzec(context, adSize);
        com_google_android_gms_internal_zzec.m9772a(m6531a(i));
        return com_google_android_gms_internal_zzec;
    }

    private static zzec m6530a(Context context, AdSize[] adSizeArr, int i) {
        zzec com_google_android_gms_internal_zzec = new zzec(context, adSizeArr);
        com_google_android_gms_internal_zzec.m9772a(m6531a(i));
        return com_google_android_gms_internal_zzec;
    }

    private static boolean m6531a(int i) {
        return i == 1;
    }

    private void m6532s() {
        try {
            C1108c zzbC = this.f4279k.zzbC();
            if (zzbC != null) {
                this.f4286r.addView((View) C1111d.m3897a(zzbC));
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to get an ad frame.", e);
        }
    }

    public void m6533a() {
        try {
            if (this.f4279k != null) {
                this.f4279k.destroy();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to destroy AdView.", e);
        }
    }

    public void m6534a(AdListener adListener) {
        this.f4275g = adListener;
        this.f4269a.m6424a(adListener);
    }

    public void m6535a(Correlator correlator) {
        this.f4278j = correlator;
        try {
            if (this.f4279k != null) {
                this.f4279k.zza(this.f4278j == null ? null : this.f4278j.zzbr());
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set correlator.", e);
        }
    }

    public void m6536a(VideoOptions videoOptions) {
        this.f4283o = videoOptions;
        try {
            if (this.f4279k != null) {
                this.f4279k.zza(videoOptions == null ? null : new zzfn(videoOptions));
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set video options.", e);
        }
    }

    public void m6537a(AppEventListener appEventListener) {
        try {
            this.f4277i = appEventListener;
            if (this.f4279k != null) {
                this.f4279k.zza(appEventListener != null ? new go(appEventListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AppEventListener.", e);
        }
    }

    public void m6538a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f4281m = onCustomRenderedAdLoadedListener;
        try {
            if (this.f4279k != null) {
                this.f4279k.zza(onCustomRenderedAdLoadedListener != null ? new it(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m6539a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f4282n != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f4280l = inAppPurchaseListener;
            if (this.f4279k != null) {
                this.f4279k.zza(inAppPurchaseListener != null ? new nr(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m6540a(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f4280l != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.f4282n = playStorePurchaseListener;
            this.f4285q = str;
            if (this.f4279k != null) {
                this.f4279k.zza(playStorePurchaseListener != null ? new nv(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void m6541a(ge geVar) {
        try {
            this.f4274f = geVar;
            if (this.f4279k != null) {
                this.f4279k.zza(geVar != null ? new gf(geVar) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AdClickListener.", e);
        }
    }

    public void m6542a(hi hiVar) {
        try {
            if (this.f4279k == null) {
                m6563q();
            }
            if (this.f4279k.zzb(this.f4271c.m6342a(this.f4286r.getContext(), hiVar))) {
                this.f4270b.m7458a(hiVar.m6522j());
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to load ad.", e);
        }
    }

    public void m6543a(String str) {
        if (this.f4284p != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f4284p = str;
    }

    public void m6544a(boolean z) {
        this.f4288t = z;
        try {
            if (this.f4279k != null) {
                this.f4279k.setManualImpressionsEnabled(this.f4288t);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set manual impressions.", e);
        }
    }

    public void m6545a(AdSize... adSizeArr) {
        if (this.f4276h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m6548b(adSizeArr);
    }

    public boolean m6546a(zzec com_google_android_gms_internal_zzec) {
        return "search_v2".equals(com_google_android_gms_internal_zzec.f6452b);
    }

    public AdListener m6547b() {
        return this.f4275g;
    }

    public void m6548b(AdSize... adSizeArr) {
        this.f4276h = adSizeArr;
        try {
            if (this.f4279k != null) {
                this.f4279k.zza(m6530a(this.f4286r.getContext(), this.f4276h, this.f4287s));
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the ad size.", e);
        }
        this.f4286r.requestLayout();
    }

    public AdSize m6549c() {
        try {
            if (this.f4279k != null) {
                zzec zzbD = this.f4279k.zzbD();
                if (zzbD != null) {
                    return zzbD.m9773b();
                }
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to get the current AdSize.", e);
        }
        return this.f4276h != null ? this.f4276h[0] : null;
    }

    public AdSize[] m6550d() {
        return this.f4276h;
    }

    public String m6551e() {
        return this.f4284p;
    }

    public AppEventListener m6552f() {
        return this.f4277i;
    }

    public InAppPurchaseListener m6553g() {
        return this.f4280l;
    }

    public OnCustomRenderedAdLoadedListener m6554h() {
        return this.f4281m;
    }

    public void m6555i() {
        try {
            if (this.f4279k != null) {
                this.f4279k.pause();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to call pause.", e);
        }
    }

    public void m6556j() {
        if (!this.f4272d.getAndSet(true)) {
            try {
                if (this.f4279k != null) {
                    this.f4279k.zzbF();
                }
            } catch (Throwable e) {
                sg.m8447c("Failed to record impression.", e);
            }
        }
    }

    public void m6557k() {
        try {
            if (this.f4279k != null) {
                this.f4279k.resume();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to call resume.", e);
        }
    }

    public String m6558l() {
        try {
            if (this.f4279k != null) {
                return this.f4279k.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public boolean m6559m() {
        try {
            if (this.f4279k != null) {
                return this.f4279k.isLoading();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public VideoController m6560n() {
        return this.f4273e;
    }

    public hg m6561o() {
        hg hgVar = null;
        if (this.f4279k != null) {
            try {
                hgVar = this.f4279k.zzbG();
            } catch (Throwable e) {
                sg.m8447c("Failed to retrieve VideoController.", e);
            }
        }
        return hgVar;
    }

    public VideoOptions m6562p() {
        return this.f4283o;
    }

    void m6563q() {
        if ((this.f4276h == null || this.f4284p == null) && this.f4279k == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f4279k = m6564r();
        this.f4279k.zza(new gg(this.f4269a));
        if (this.f4274f != null) {
            this.f4279k.zza(new gf(this.f4274f));
        }
        if (this.f4277i != null) {
            this.f4279k.zza(new go(this.f4277i));
        }
        if (this.f4280l != null) {
            this.f4279k.zza(new nr(this.f4280l));
        }
        if (this.f4282n != null) {
            this.f4279k.zza(new nv(this.f4282n), this.f4285q);
        }
        if (this.f4281m != null) {
            this.f4279k.zza(new it(this.f4281m));
        }
        if (this.f4278j != null) {
            this.f4279k.zza(this.f4278j.zzbr());
        }
        if (this.f4283o != null) {
            this.f4279k.zza(new zzfn(this.f4283o));
        }
        this.f4279k.setManualImpressionsEnabled(this.f4288t);
        m6532s();
    }

    protected gz m6564r() {
        Context context = this.f4286r.getContext();
        zzec a = m6530a(context, this.f4276h, this.f4287s);
        return m6546a(a) ? gr.m6418b().m6407a(context, a, this.f4284p) : gr.m6418b().m6408a(context, a, this.f4284p, this.f4270b);
    }
}
