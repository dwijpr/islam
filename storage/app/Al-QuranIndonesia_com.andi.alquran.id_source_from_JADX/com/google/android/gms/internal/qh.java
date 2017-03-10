package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.p039a.C1111d;

@op
public class qh implements RewardedVideoAd {
    private final qa f5540a;
    private final Context f5541b;
    private final Object f5542c;
    private RewardedVideoAdListener f5543d;

    public qh(Context context, qa qaVar) {
        this.f5542c = new Object();
        this.f5540a = qaVar;
        this.f5541b = context;
    }

    public void destroy() {
        destroy(null);
    }

    public void destroy(Context context) {
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
                return;
            }
            try {
                this.f5540a.m6616c(C1111d.m3896a((Object) context));
            } catch (Throwable e) {
                sg.m8447c("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.f5542c) {
            rewardedVideoAdListener = this.f5543d;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        sg.m8449e("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
            } else {
                try {
                    z = this.f5540a.m6614b();
                } catch (Throwable e) {
                    sg.m8447c("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
                return;
            }
            try {
                this.f5540a.m6611a(gm.m6341a().m6343a(this.f5541b, adRequest.zzbq(), str));
            } catch (Throwable e) {
                sg.m8447c("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        pause(null);
    }

    public void pause(Context context) {
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
                return;
            }
            try {
                this.f5540a.m6609a(C1111d.m3896a((Object) context));
            } catch (Throwable e) {
                sg.m8447c("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        resume(null);
    }

    public void resume(Context context) {
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
                return;
            }
            try {
                this.f5540a.m6613b(C1111d.m3896a((Object) context));
            } catch (Throwable e) {
                sg.m8447c("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f5542c) {
            this.f5543d = rewardedVideoAdListener;
            if (this.f5540a != null) {
                try {
                    this.f5540a.m6610a(new qf(rewardedVideoAdListener));
                } catch (Throwable e) {
                    sg.m8447c("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        sg.m8449e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.f5542c) {
            if (this.f5540a == null) {
                return;
            }
            try {
                this.f5540a.m6608a();
            } catch (Throwable e) {
                sg.m8447c("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
