package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.hl;

public final class InterstitialAd {
    private final hl f2318a;

    public InterstitialAd(Context context) {
        this.f2318a = new hl(context);
    }

    public AdListener getAdListener() {
        return this.f2318a.m6568a();
    }

    public String getAdUnitId() {
        return this.f2318a.m6580b();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f2318a.m6582d();
    }

    public String getMediationAdapterClassName() {
        return this.f2318a.m6586h();
    }

    public boolean isLoaded() {
        return this.f2318a.m6584f();
    }

    public boolean isLoading() {
        return this.f2318a.m6585g();
    }

    public void loadAd(AdRequest adRequest) {
        this.f2318a.m6577a(adRequest.zzbq());
    }

    public void setAdListener(AdListener adListener) {
        this.f2318a.m6569a(adListener);
        if (adListener != null && (adListener instanceof ge)) {
            this.f2318a.m6576a((ge) adListener);
        } else if (adListener == null) {
            this.f2318a.m6576a(null);
        }
    }

    public void setAdUnitId(String str) {
        this.f2318a.m6578a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f2318a.m6573a(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f2318a.m6574a(playStorePurchaseListener, str);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f2318a.m6575a(rewardedVideoAdListener);
    }

    public void show() {
        this.f2318a.m6587i();
    }

    public void zzd(boolean z) {
        this.f2318a.m6579a(z);
    }
}
