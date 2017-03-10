package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@op
public class hl {
    private final mc f4289a;
    private final Context f4290b;
    private final gm f4291c;
    private AdListener f4292d;
    private ge f4293e;
    private gz f4294f;
    private String f4295g;
    private String f4296h;
    private AppEventListener f4297i;
    private PlayStorePurchaseListener f4298j;
    private InAppPurchaseListener f4299k;
    private PublisherInterstitialAd f4300l;
    private OnCustomRenderedAdLoadedListener f4301m;
    private Correlator f4302n;
    private RewardedVideoAdListener f4303o;
    private boolean f4304p;

    public hl(Context context) {
        this(context, gm.m6341a(), null);
    }

    public hl(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, gm.m6341a(), publisherInterstitialAd);
    }

    public hl(Context context, gm gmVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f4289a = new mc();
        this.f4290b = context;
        this.f4291c = gmVar;
        this.f4300l = publisherInterstitialAd;
    }

    private void m6566b(String str) {
        if (this.f4295g == null) {
            m6567c(str);
        }
        this.f4294f = gr.m6418b().m6414b(this.f4290b, this.f4304p ? zzec.m9768a() : new zzec(), this.f4295g, this.f4289a);
        if (this.f4292d != null) {
            this.f4294f.zza(new gg(this.f4292d));
        }
        if (this.f4293e != null) {
            this.f4294f.zza(new gf(this.f4293e));
        }
        if (this.f4297i != null) {
            this.f4294f.zza(new go(this.f4297i));
        }
        if (this.f4299k != null) {
            this.f4294f.zza(new nr(this.f4299k));
        }
        if (this.f4298j != null) {
            this.f4294f.zza(new nv(this.f4298j), this.f4296h);
        }
        if (this.f4301m != null) {
            this.f4294f.zza(new it(this.f4301m));
        }
        if (this.f4302n != null) {
            this.f4294f.zza(this.f4302n.zzbr());
        }
        if (this.f4303o != null) {
            this.f4294f.zza(new qf(this.f4303o));
        }
    }

    private void m6567c(String str) {
        if (this.f4294f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public AdListener m6568a() {
        return this.f4292d;
    }

    public void m6569a(AdListener adListener) {
        try {
            this.f4292d = adListener;
            if (this.f4294f != null) {
                this.f4294f.zza(adListener != null ? new gg(adListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AdListener.", e);
        }
    }

    public void m6570a(Correlator correlator) {
        this.f4302n = correlator;
        try {
            if (this.f4294f != null) {
                this.f4294f.zza(this.f4302n == null ? null : this.f4302n.zzbr());
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set correlator.", e);
        }
    }

    public void m6571a(AppEventListener appEventListener) {
        try {
            this.f4297i = appEventListener;
            if (this.f4294f != null) {
                this.f4294f.zza(appEventListener != null ? new go(appEventListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AppEventListener.", e);
        }
    }

    public void m6572a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.f4301m = onCustomRenderedAdLoadedListener;
            if (this.f4294f != null) {
                this.f4294f.zza(onCustomRenderedAdLoadedListener != null ? new it(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m6573a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f4298j != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f4299k = inAppPurchaseListener;
            if (this.f4294f != null) {
                this.f4294f.zza(inAppPurchaseListener != null ? new nr(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m6574a(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f4299k != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.f4298j = playStorePurchaseListener;
            this.f4296h = str;
            if (this.f4294f != null) {
                this.f4294f.zza(playStorePurchaseListener != null ? new nv(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void m6575a(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.f4303o = rewardedVideoAdListener;
            if (this.f4294f != null) {
                this.f4294f.zza(rewardedVideoAdListener != null ? new qf(rewardedVideoAdListener) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AdListener.", e);
        }
    }

    public void m6576a(ge geVar) {
        try {
            this.f4293e = geVar;
            if (this.f4294f != null) {
                this.f4294f.zza(geVar != null ? new gf(geVar) : null);
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to set the AdClickListener.", e);
        }
    }

    public void m6577a(hi hiVar) {
        try {
            if (this.f4294f == null) {
                m6566b("loadAd");
            }
            if (this.f4294f.zzb(this.f4291c.m6342a(this.f4290b, hiVar))) {
                this.f4289a.m7458a(hiVar.m6522j());
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to load ad.", e);
        }
    }

    public void m6578a(String str) {
        if (this.f4295g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f4295g = str;
    }

    public void m6579a(boolean z) {
        this.f4304p = z;
    }

    public String m6580b() {
        return this.f4295g;
    }

    public AppEventListener m6581c() {
        return this.f4297i;
    }

    public InAppPurchaseListener m6582d() {
        return this.f4299k;
    }

    public OnCustomRenderedAdLoadedListener m6583e() {
        return this.f4301m;
    }

    public boolean m6584f() {
        boolean z = false;
        try {
            if (this.f4294f != null) {
                z = this.f4294f.isReady();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public boolean m6585g() {
        boolean z = false;
        try {
            if (this.f4294f != null) {
                z = this.f4294f.isLoading();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to check if ad is loading.", e);
        }
        return z;
    }

    public String m6586h() {
        try {
            if (this.f4294f != null) {
                return this.f4294f.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            sg.m8447c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public void m6587i() {
        try {
            m6567c("show");
            this.f4294f.showInterstitial();
        } catch (Throwable e) {
            sg.m8447c("Failed to show interstitial.", e);
        }
    }
}
