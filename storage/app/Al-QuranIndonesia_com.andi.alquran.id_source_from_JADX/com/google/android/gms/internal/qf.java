package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.qc.C1751a;

@op
public class qf extends C1751a {
    private final RewardedVideoAdListener f5539a;

    public qf(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f5539a = rewardedVideoAdListener;
    }

    public void m8271a() {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoAdLoaded();
        }
    }

    public void m8272a(int i) {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public void m8273a(pz pzVar) {
        if (this.f5539a != null) {
            this.f5539a.onRewarded(new qd(pzVar));
        }
    }

    public void m8274b() {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoAdOpened();
        }
    }

    public void m8275c() {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoStarted();
        }
    }

    public void m8276d() {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoAdClosed();
        }
    }

    public void m8277e() {
        if (this.f5539a != null) {
            this.f5539a.onRewardedVideoAdLeftApplication();
        }
    }
}
