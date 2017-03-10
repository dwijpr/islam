package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.sg;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner f2760a;
    CustomEventInterstitial f2761b;
    CustomEventNative f2762c;
    private View f2763d;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.a */
    static final class C1197a implements CustomEventBannerListener {
        private final CustomEventAdapter f2753a;
        private final MediationBannerListener f2754b;

        public C1197a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f2753a = customEventAdapter;
            this.f2754b = mediationBannerListener;
        }

        public void onAdClicked() {
            sg.m8444b("Custom event adapter called onAdClicked.");
            this.f2754b.onAdClicked(this.f2753a);
        }

        public void onAdClosed() {
            sg.m8444b("Custom event adapter called onAdClosed.");
            this.f2754b.onAdClosed(this.f2753a);
        }

        public void onAdFailedToLoad(int i) {
            sg.m8444b("Custom event adapter called onAdFailedToLoad.");
            this.f2754b.onAdFailedToLoad(this.f2753a, i);
        }

        public void onAdLeftApplication() {
            sg.m8444b("Custom event adapter called onAdLeftApplication.");
            this.f2754b.onAdLeftApplication(this.f2753a);
        }

        public void onAdLoaded(View view) {
            sg.m8444b("Custom event adapter called onAdLoaded.");
            this.f2753a.m4157a(view);
            this.f2754b.onAdLoaded(this.f2753a);
        }

        public void onAdOpened() {
            sg.m8444b("Custom event adapter called onAdOpened.");
            this.f2754b.onAdOpened(this.f2753a);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.b */
    class C1198b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f2755a;
        private final CustomEventAdapter f2756b;
        private final MediationInterstitialListener f2757c;

        public C1198b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f2755a = customEventAdapter;
            this.f2756b = customEventAdapter2;
            this.f2757c = mediationInterstitialListener;
        }

        public void onAdClicked() {
            sg.m8444b("Custom event adapter called onAdClicked.");
            this.f2757c.onAdClicked(this.f2756b);
        }

        public void onAdClosed() {
            sg.m8444b("Custom event adapter called onAdClosed.");
            this.f2757c.onAdClosed(this.f2756b);
        }

        public void onAdFailedToLoad(int i) {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2757c.onAdFailedToLoad(this.f2756b, i);
        }

        public void onAdLeftApplication() {
            sg.m8444b("Custom event adapter called onAdLeftApplication.");
            this.f2757c.onAdLeftApplication(this.f2756b);
        }

        public void onAdLoaded() {
            sg.m8444b("Custom event adapter called onReceivedAd.");
            this.f2757c.onAdLoaded(this.f2755a);
        }

        public void onAdOpened() {
            sg.m8444b("Custom event adapter called onAdOpened.");
            this.f2757c.onAdOpened(this.f2756b);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.c */
    static class C1199c implements CustomEventNativeListener {
        private final CustomEventAdapter f2758a;
        private final MediationNativeListener f2759b;

        public C1199c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f2758a = customEventAdapter;
            this.f2759b = mediationNativeListener;
        }

        public void onAdClicked() {
            sg.m8444b("Custom event adapter called onAdClicked.");
            this.f2759b.onAdClicked(this.f2758a);
        }

        public void onAdClosed() {
            sg.m8444b("Custom event adapter called onAdClosed.");
            this.f2759b.onAdClosed(this.f2758a);
        }

        public void onAdFailedToLoad(int i) {
            sg.m8444b("Custom event adapter called onAdFailedToLoad.");
            this.f2759b.onAdFailedToLoad(this.f2758a, i);
        }

        public void onAdImpression() {
            sg.m8444b("Custom event adapter called onAdImpression.");
            this.f2759b.onAdImpression(this.f2758a);
        }

        public void onAdLeftApplication() {
            sg.m8444b("Custom event adapter called onAdLeftApplication.");
            this.f2759b.onAdLeftApplication(this.f2758a);
        }

        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            sg.m8444b("Custom event adapter called onAdLoaded.");
            this.f2759b.onAdLoaded(this.f2758a, nativeAdMapper);
        }

        public void onAdOpened() {
            sg.m8444b("Custom event adapter called onAdOpened.");
            this.f2759b.onAdOpened(this.f2758a);
        }
    }

    private static <T> T m4156a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            sg.m8449e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    private void m4157a(View view) {
        this.f2763d = view;
    }

    C1198b m4159a(MediationInterstitialListener mediationInterstitialListener) {
        return new C1198b(this, this, mediationInterstitialListener);
    }

    public View getBannerView() {
        return this.f2763d;
    }

    public void onDestroy() {
        if (this.f2760a != null) {
            this.f2760a.onDestroy();
        }
        if (this.f2761b != null) {
            this.f2761b.onDestroy();
        }
        if (this.f2762c != null) {
            this.f2762c.onDestroy();
        }
    }

    public void onPause() {
        if (this.f2760a != null) {
            this.f2760a.onPause();
        }
        if (this.f2761b != null) {
            this.f2761b.onPause();
        }
        if (this.f2762c != null) {
            this.f2762c.onPause();
        }
    }

    public void onResume() {
        if (this.f2760a != null) {
            this.f2760a.onResume();
        }
        if (this.f2761b != null) {
            this.f2761b.onResume();
        }
        if (this.f2762c != null) {
            this.f2762c.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f2760a = (CustomEventBanner) m4156a(bundle.getString("class_name"));
        if (this.f2760a == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f2760a.requestBannerAd(context, new C1197a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f2761b = (CustomEventInterstitial) m4156a(bundle.getString("class_name"));
        if (this.f2761b == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f2761b.requestInterstitialAd(context, m4159a(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f2762c = (CustomEventNative) m4156a(bundle.getString("class_name"));
        if (this.f2762c == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f2762c.requestNativeAd(context, new C1199c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void showInterstitial() {
        this.f2761b.showInterstitial();
    }
}
