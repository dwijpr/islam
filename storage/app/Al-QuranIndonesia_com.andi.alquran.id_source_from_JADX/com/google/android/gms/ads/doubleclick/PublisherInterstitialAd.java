package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.hl;

public final class PublisherInterstitialAd {
    private final hl f2328a;

    public PublisherInterstitialAd(Context context) {
        this.f2328a = new hl(context, this);
    }

    public AdListener getAdListener() {
        return this.f2328a.m6568a();
    }

    public String getAdUnitId() {
        return this.f2328a.m6580b();
    }

    public AppEventListener getAppEventListener() {
        return this.f2328a.m6581c();
    }

    public String getMediationAdapterClassName() {
        return this.f2328a.m6586h();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f2328a.m6583e();
    }

    public boolean isLoaded() {
        return this.f2328a.m6584f();
    }

    public boolean isLoading() {
        return this.f2328a.m6585g();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f2328a.m6577a(publisherAdRequest.zzbq());
    }

    public void setAdListener(AdListener adListener) {
        this.f2328a.m6569a(adListener);
    }

    public void setAdUnitId(String str) {
        this.f2328a.m6578a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f2328a.m6571a(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f2328a.m6570a(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f2328a.m6572a(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.f2328a.m6587i();
    }
}
