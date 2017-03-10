package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.p039a.C1111d;

@op
public class hm {
    private static hm f4305a;
    private static final Object f4306b;
    private he f4307c;
    private RewardedVideoAd f4308d;

    static {
        f4306b = new Object();
    }

    private hm() {
    }

    public static hm m6588a() {
        hm hmVar;
        synchronized (f4306b) {
            if (f4305a == null) {
                f4305a = new hm();
            }
            hmVar = f4305a;
        }
        return hmVar;
    }

    public RewardedVideoAd m6589a(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (f4306b) {
            if (this.f4308d != null) {
                rewardedVideoAd = this.f4308d;
            } else {
                this.f4308d = new qh(context, gr.m6418b().m6412a(context, new mc()));
                rewardedVideoAd = this.f4308d;
            }
        }
        return rewardedVideoAd;
    }

    public void m6590a(float f) {
        boolean z = true;
        boolean z2 = 0.0f <= f && f <= 1.0f;
        C1314c.m4633b(z2, "The app volume must be a value between 0 and 1 inclusive.");
        if (this.f4307c == null) {
            z = false;
        }
        C1314c.m4629a(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f4307c.setAppVolume(f);
        } catch (Throwable e) {
            sg.m8445b("Unable to set app volume.", e);
        }
    }

    public void m6591a(Context context, String str) {
        C1314c.m4629a(this.f4307c != null, (Object) "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.f4307c.zzb(C1111d.m3896a((Object) context), str);
        } catch (Throwable e) {
            sg.m8445b("Unable to open debug menu.", e);
        }
    }

    public void m6592a(Context context, String str, hn hnVar) {
        synchronized (f4306b) {
            if (this.f4307c != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else {
                try {
                    this.f4307c = gr.m6418b().m6409a(context);
                    this.f4307c.initialize();
                    if (str != null) {
                        this.f4307c.zzy(str);
                    }
                } catch (Throwable e) {
                    sg.m8447c("Fail to initialize or set applicationCode on mobile ads setting manager", e);
                }
            }
        }
    }

    public void m6593a(boolean z) {
        C1314c.m4629a(this.f4307c != null, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f4307c.setAppMuted(z);
        } catch (Throwable e) {
            sg.m8445b("Unable to set app mute state.", e);
        }
    }
}
