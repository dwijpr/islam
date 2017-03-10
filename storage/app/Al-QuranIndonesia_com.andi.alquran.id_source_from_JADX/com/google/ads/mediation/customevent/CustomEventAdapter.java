package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.sg;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner f2278a;
    CustomEventInterstitial f2279b;
    private View f2280c;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    static final class C1092a implements CustomEventBannerListener {
        private final CustomEventAdapter f2273a;
        private final MediationBannerListener f2274b;

        public C1092a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f2273a = customEventAdapter;
            this.f2274b = mediationBannerListener;
        }

        public void onClick() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2274b.onClick(this.f2273a);
        }

        public void onDismissScreen() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2274b.onDismissScreen(this.f2273a);
        }

        public void onFailedToReceiveAd() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2274b.onFailedToReceiveAd(this.f2273a, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2274b.onLeaveApplication(this.f2273a);
        }

        public void onPresentScreen() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2274b.onPresentScreen(this.f2273a);
        }

        public void onReceivedAd(View view) {
            sg.m8444b("Custom event adapter called onReceivedAd.");
            this.f2273a.m3845a(view);
            this.f2274b.onReceivedAd(this.f2273a);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    class C1093b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f2275a;
        private final CustomEventAdapter f2276b;
        private final MediationInterstitialListener f2277c;

        public C1093b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f2275a = customEventAdapter;
            this.f2276b = customEventAdapter2;
            this.f2277c = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            sg.m8444b("Custom event adapter called onDismissScreen.");
            this.f2277c.onDismissScreen(this.f2276b);
        }

        public void onFailedToReceiveAd() {
            sg.m8444b("Custom event adapter called onFailedToReceiveAd.");
            this.f2277c.onFailedToReceiveAd(this.f2276b, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            sg.m8444b("Custom event adapter called onLeaveApplication.");
            this.f2277c.onLeaveApplication(this.f2276b);
        }

        public void onPresentScreen() {
            sg.m8444b("Custom event adapter called onPresentScreen.");
            this.f2277c.onPresentScreen(this.f2276b);
        }

        public void onReceivedAd() {
            sg.m8444b("Custom event adapter called onReceivedAd.");
            this.f2277c.onReceivedAd(this.f2275a);
        }
    }

    private static <T> T m3844a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            sg.m8449e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    private void m3845a(View view) {
        this.f2280c = view;
    }

    C1093b m3847a(MediationInterstitialListener mediationInterstitialListener) {
        return new C1093b(this, this, mediationInterstitialListener);
    }

    public void destroy() {
        if (this.f2278a != null) {
            this.f2278a.destroy();
        }
        if (this.f2279b != null) {
            this.f2279b.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f2280c;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f2278a = (CustomEventBanner) m3844a(customEventServerParameters.className);
        if (this.f2278a == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f2278a.requestBannerAd(new C1092a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f2279b = (CustomEventInterstitial) m3844a(customEventServerParameters.className);
        if (this.f2279b == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f2279b.requestInterstitialAd(m3847a(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.f2279b.showInterstitial();
    }
}
