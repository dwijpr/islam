package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hc.C1122a;
import com.google.android.gms.internal.he;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jk;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.nd;
import com.google.android.gms.internal.nn;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.px;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@Keep
@DynamiteApi
@op
public class ClientApi extends C1122a {
    public gx createAdLoaderBuilder(C1108c c1108c, String str, md mdVar, int i) {
        return new zzk((Context) C1111d.m3897a(c1108c), str, mdVar, new zzqa(10084000, i, true), zzd.zzca());
    }

    public nd createAdOverlay(C1108c c1108c) {
        return new zze((Activity) C1111d.m3897a(c1108c));
    }

    public gz createBannerAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
        return new zzf((Context) C1111d.m3897a(c1108c), com_google_android_gms_internal_zzec, str, mdVar, new zzqa(10084000, i, true), zzd.zzca());
    }

    public nn createInAppPurchaseManager(C1108c c1108c) {
        return new com.google.android.gms.ads.internal.purchase.zze((Activity) C1111d.m3897a(c1108c));
    }

    public gz createInterstitialAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
        Context context = (Context) C1111d.m3897a(c1108c);
        C1648if.m6704a(context);
        zzqa com_google_android_gms_internal_zzqa = new zzqa(10084000, i, true);
        boolean equals = "reward_mb".equals(com_google_android_gms_internal_zzec.f6452b);
        Object obj = ((equals || !((Boolean) C1648if.aK.m6682c()).booleanValue()) && !(equals && ((Boolean) C1648if.aL.m6682c()).booleanValue())) ? null : 1;
        if (obj != null) {
            return new lf(context, str, mdVar, com_google_android_gms_internal_zzqa, zzd.zzca());
        }
        return new zzl(context, com_google_android_gms_internal_zzec, str, mdVar, com_google_android_gms_internal_zzqa, zzd.zzca());
    }

    public jk createNativeAdViewDelegate(C1108c c1108c, C1108c c1108c2) {
        return new jg((FrameLayout) C1111d.m3897a(c1108c), (FrameLayout) C1111d.m3897a(c1108c2));
    }

    public qa createRewardedVideoAd(C1108c c1108c, md mdVar, int i) {
        return new px((Context) C1111d.m3897a(c1108c), zzd.zzca(), mdVar, new zzqa(10084000, i, true));
    }

    public gz createSearchAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, int i) {
        return new zzu((Context) C1111d.m3897a(c1108c), com_google_android_gms_internal_zzec, str, new zzqa(10084000, i, true));
    }

    public he getMobileAdsSettingsManager(C1108c c1108c) {
        return null;
    }

    public he getMobileAdsSettingsManagerWithClientJarVersion(C1108c c1108c, int i) {
        return zzp.zza((Context) C1111d.m3897a(c1108c), new zzqa(10084000, i, true));
    }
}
