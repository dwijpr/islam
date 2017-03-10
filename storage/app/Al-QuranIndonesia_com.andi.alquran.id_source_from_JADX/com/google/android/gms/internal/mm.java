package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.C1314c;

@op
public final class mm implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final mf f4967a;
    private NativeAdMapper f4968b;

    public mm(mf mfVar) {
        this.f4967a = mfVar;
    }

    public NativeAdMapper m7626a() {
        return this.f4968b;
    }

    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        C1314c.m4631b("onAdClicked must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClicked.");
        try {
            this.f4967a.m7384a();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C1314c.m4631b("onAdClicked must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClicked.");
        try {
            this.f4967a.m7384a();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        C1314c.m4631b("onAdClicked must be called on the main UI thread.");
        NativeAdMapper a = m7626a();
        if (a == null) {
            sg.m8449e("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (a.getOverrideClickHandling()) {
            sg.m8444b("Adapter called onAdClicked.");
            try {
                this.f4967a.m7384a();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClicked.", e);
            }
        } else {
            sg.m8444b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        C1314c.m4631b("onAdClosed must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClosed.");
        try {
            this.f4967a.m7387b();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C1314c.m4631b("onAdClosed must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClosed.");
        try {
            this.f4967a.m7387b();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        C1314c.m4631b("onAdClosed must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClosed.");
        try {
            this.f4967a.m7387b();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        C1314c.m4631b("onAdFailedToLoad must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f4967a.m7385a(i);
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        C1314c.m4631b("onAdFailedToLoad must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f4967a.m7385a(i);
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        C1314c.m4631b("onAdFailedToLoad must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f4967a.m7385a(i);
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        C1314c.m4631b("onAdImpression must be called on the main UI thread.");
        NativeAdMapper a = m7626a();
        if (a == null) {
            sg.m8449e("Could not call onAdImpression since NativeAdMapper is null. ");
        } else if (a.getOverrideImpressionRecording()) {
            sg.m8444b("Adapter called onAdImpression.");
            try {
                this.f4967a.m7391f();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdImpression.", e);
            }
        } else {
            sg.m8444b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        C1314c.m4631b("onAdLeftApplication must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLeftApplication.");
        try {
            this.f4967a.m7388c();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C1314c.m4631b("onAdLeftApplication must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLeftApplication.");
        try {
            this.f4967a.m7388c();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        C1314c.m4631b("onAdLeftApplication must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLeftApplication.");
        try {
            this.f4967a.m7388c();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        C1314c.m4631b("onAdLoaded must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLoaded.");
        try {
            this.f4967a.m7390e();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C1314c.m4631b("onAdLoaded must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLoaded.");
        try {
            this.f4967a.m7390e();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        C1314c.m4631b("onAdLoaded must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLoaded.");
        this.f4968b = nativeAdMapper;
        try {
            this.f4967a.m7390e();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        C1314c.m4631b("onAdOpened must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdOpened.");
        try {
            this.f4967a.m7389d();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C1314c.m4631b("onAdOpened must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdOpened.");
        try {
            this.f4967a.m7389d();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        C1314c.m4631b("onAdOpened must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdOpened.");
        try {
            this.f4967a.m7389d();
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdOpened.", e);
        }
    }
}
