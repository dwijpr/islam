package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.p039a.C1111d;

@op
public class qs implements MediationRewardedVideoAdListener {
    private final qr f5591a;

    public qs(qr qrVar) {
        this.f5591a = qrVar;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onAdClicked must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClicked.");
        try {
            this.f5591a.m8315f(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onAdClosed must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdClosed.");
        try {
            this.f5591a.m8314e(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        C1314c.m4631b("onAdFailedToLoad must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdFailedToLoad.");
        try {
            this.f5591a.m8311b(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onAdLeftApplication must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLeftApplication.");
        try {
            this.f5591a.m8316g(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onAdLoaded must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdLoaded.");
        try {
            this.f5591a.m8310b(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onAdOpened must be called on the main UI thread.");
        sg.m8444b("Adapter called onAdOpened.");
        try {
            this.f5591a.m8312c(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        C1314c.m4631b("onInitializationFailed must be called on the main UI thread.");
        sg.m8444b("Adapter called onInitializationFailed.");
        try {
            this.f5591a.m8308a(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            sg.m8447c("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onInitializationSucceeded must be called on the main UI thread.");
        sg.m8444b("Adapter called onInitializationSucceeded.");
        try {
            this.f5591a.m8307a(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        C1314c.m4631b("onRewarded must be called on the main UI thread.");
        sg.m8444b("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.f5591a.m8309a(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter), new zzok(rewardItem));
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onRewarded.", e);
                return;
            }
        }
        this.f5591a.m8309a(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter), new zzok(mediationRewardedVideoAdAdapter.getClass().getName(), 1));
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C1314c.m4631b("onVideoStarted must be called on the main UI thread.");
        sg.m8444b("Adapter called onVideoStarted.");
        try {
            this.f5591a.m8313d(C1111d.m3896a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            sg.m8447c("Could not call onVideoStarted.", e);
        }
    }
}
