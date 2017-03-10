package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;

public class MobileAds {

    public static final class Settings {
        private final hn f2319a;

        public Settings() {
            this.f2319a = new hn();
        }

        hn m3903a() {
            return this.f2319a;
        }

        @Deprecated
        public String getTrackingId() {
            return null;
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return hm.m6588a().m6589a(context);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        hm.m6588a().m6592a(context, str, settings == null ? null : settings.m3903a());
    }

    public static void openDebugMenu(Context context, String str) {
        hm.m6588a().m6591a(context, str);
    }

    public static void setAppMuted(boolean z) {
        hm.m6588a().m6593a(z);
    }

    public static void setAppVolume(float f) {
        hm.m6588a().m6590a(f);
    }
}
