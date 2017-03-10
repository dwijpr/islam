package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.tm;
import java.util.Date;
import java.util.Set;

@op
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, tm {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzcC;
    protected InterstitialAd zzcD;
    private AdLoader zzcE;
    private Context zzcF;
    private InterstitialAd zzcG;
    private MediationRewardedVideoAdListener zzcH;
    final RewardedVideoAdListener zzcI;

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.1 */
    class C10861 implements RewardedVideoAdListener {
        final /* synthetic */ AbstractAdViewAdapter f2241a;

        C10861(AbstractAdViewAdapter abstractAdViewAdapter) {
            this.f2241a = abstractAdViewAdapter;
        }

        public void onRewarded(RewardItem rewardItem) {
            this.f2241a.zzcH.onRewarded(this.f2241a, rewardItem);
        }

        public void onRewardedVideoAdClosed() {
            this.f2241a.zzcH.onAdClosed(this.f2241a);
            this.f2241a.zzcG = null;
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            this.f2241a.zzcH.onAdFailedToLoad(this.f2241a, i);
        }

        public void onRewardedVideoAdLeftApplication() {
            this.f2241a.zzcH.onAdLeftApplication(this.f2241a);
        }

        public void onRewardedVideoAdLoaded() {
            this.f2241a.zzcH.onAdLoaded(this.f2241a);
        }

        public void onRewardedVideoAdOpened() {
            this.f2241a.zzcH.onAdOpened(this.f2241a);
        }

        public void onRewardedVideoStarted() {
            this.f2241a.zzcH.onVideoStarted(this.f2241a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.a */
    static class C1087a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd f2254d;

        public C1087a(NativeAppInstallAd nativeAppInstallAd) {
            this.f2254d = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f2254d);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.b */
    static class C1088b extends NativeContentAdMapper {
        private final NativeContentAd f2261d;

        public C1088b(NativeContentAd nativeContentAd) {
            this.f2261d = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f2261d);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.c */
    static final class C1089c extends AdListener implements ge {
        final AbstractAdViewAdapter f2262a;
        final MediationBannerListener f2263b;

        public C1089c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f2262a = abstractAdViewAdapter;
            this.f2263b = mediationBannerListener;
        }

        public void onAdClicked() {
            this.f2263b.onAdClicked(this.f2262a);
        }

        public void onAdClosed() {
            this.f2263b.onAdClosed(this.f2262a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2263b.onAdFailedToLoad(this.f2262a, i);
        }

        public void onAdLeftApplication() {
            this.f2263b.onAdLeftApplication(this.f2262a);
        }

        public void onAdLoaded() {
            this.f2263b.onAdLoaded(this.f2262a);
        }

        public void onAdOpened() {
            this.f2263b.onAdOpened(this.f2262a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.d */
    static final class C1090d extends AdListener implements ge {
        final AbstractAdViewAdapter f2264a;
        final MediationInterstitialListener f2265b;

        public C1090d(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f2264a = abstractAdViewAdapter;
            this.f2265b = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.f2265b.onAdClicked(this.f2264a);
        }

        public void onAdClosed() {
            this.f2265b.onAdClosed(this.f2264a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2265b.onAdFailedToLoad(this.f2264a, i);
        }

        public void onAdLeftApplication() {
            this.f2265b.onAdLeftApplication(this.f2264a);
        }

        public void onAdLoaded() {
            this.f2265b.onAdLoaded(this.f2264a);
        }

        public void onAdOpened() {
            this.f2265b.onAdOpened(this.f2264a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.e */
    static final class C1091e extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, ge {
        final AbstractAdViewAdapter f2266a;
        final MediationNativeListener f2267b;

        public C1091e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f2266a = abstractAdViewAdapter;
            this.f2267b = mediationNativeListener;
        }

        public void onAdClicked() {
            this.f2267b.onAdClicked(this.f2266a);
        }

        public void onAdClosed() {
            this.f2267b.onAdClosed(this.f2266a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2267b.onAdFailedToLoad(this.f2266a, i);
        }

        public void onAdLeftApplication() {
            this.f2267b.onAdLeftApplication(this.f2266a);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.f2267b.onAdOpened(this.f2266a);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f2267b.onAdLoaded(this.f2266a, new C1087a(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f2267b.onAdLoaded(this.f2266a, new C1088b(nativeContentAd));
        }
    }

    public AbstractAdViewAdapter() {
        this.zzcI = new C10861(this);
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzcC;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new zza().zzak(1).zzlL();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzcF = context.getApplicationContext();
        this.zzcH = mediationRewardedVideoAdListener;
        this.zzcH.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzcH != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzcF == null || this.zzcH == null) {
            sg.m8446c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzcG = new InterstitialAd(this.zzcF);
        this.zzcG.zzd(true);
        this.zzcG.setAdUnitId(getAdUnitId(bundle));
        this.zzcG.setRewardedVideoAdListener(this.zzcI);
        this.zzcG.loadAd(zza(this.zzcF, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzcC != null) {
            this.zzcC.destroy();
            this.zzcC = null;
        }
        if (this.zzcD != null) {
            this.zzcD = null;
        }
        if (this.zzcE != null) {
            this.zzcE = null;
        }
        if (this.zzcG != null) {
            this.zzcG = null;
        }
    }

    public void onPause() {
        if (this.zzcC != null) {
            this.zzcC.pause();
        }
    }

    public void onResume() {
        if (this.zzcC != null) {
            this.zzcC.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcC = new AdView(context);
        this.zzcC.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzcC.setAdUnitId(getAdUnitId(bundle));
        this.zzcC.setAdListener(new C1089c(this, mediationBannerListener));
        this.zzcC.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcD = new InterstitialAd(context);
        this.zzcD.setAdUnitId(getAdUnitId(bundle));
        this.zzcD.setAdListener(new C1090d(this, mediationInterstitialListener));
        this.zzcD.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener c1091e = new C1091e(this, mediationNativeListener);
        Builder withAdListener = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(c1091e);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(c1091e);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(c1091e);
        }
        this.zzcE = withAdListener.build();
        this.zzcE.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzcD.show();
    }

    public void showVideo() {
        this.zzcG.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    Builder zza(Context context, String str) {
        return new Builder(context, str);
    }

    AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(gr.m6416a().m8692a(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
