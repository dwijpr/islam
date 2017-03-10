package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.iu.C1657a;

@op
public class mt implements MediationInterstitialAdapter {
    private Activity f5001a;
    private iu f5002b;
    private MediationInterstitialListener f5003c;
    private Uri f5004d;

    /* renamed from: com.google.android.gms.internal.mt.1 */
    class C18181 implements C1657a {
        C18181(mt mtVar) {
        }
    }

    /* renamed from: com.google.android.gms.internal.mt.2 */
    class C18192 implements zzh {
        final /* synthetic */ mt f4998a;

        C18192(mt mtVar) {
            this.f4998a = mtVar;
        }

        public void onPause() {
            sg.m8444b("AdMobCustomTabsAdapter overlay is paused.");
        }

        public void onResume() {
            sg.m8444b("AdMobCustomTabsAdapter overlay is resumed.");
        }

        public void zzbN() {
            sg.m8444b("AdMobCustomTabsAdapter overlay is closed.");
            this.f4998a.f5003c.onAdClosed(this.f4998a);
            this.f4998a.f5002b.m6773a(this.f4998a.f5001a);
        }

        public void zzbO() {
            sg.m8444b("Opening AdMobCustomTabsAdapter overlay.");
            this.f4998a.f5003c.onAdOpened(this.f4998a);
        }
    }

    /* renamed from: com.google.android.gms.internal.mt.3 */
    class C18203 implements Runnable {
        final /* synthetic */ AdOverlayInfoParcel f4999a;
        final /* synthetic */ mt f5000b;

        C18203(mt mtVar, AdOverlayInfoParcel adOverlayInfoParcel) {
            this.f5000b = mtVar;
            this.f4999a = adOverlayInfoParcel;
        }

        public void run() {
            zzv.zzcH().zza(this.f5000b.f5001a, this.f4999a);
        }
    }

    public static boolean m7684a(Context context) {
        return iu.m6771a(context);
    }

    public void onDestroy() {
        sg.m8444b("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.f5002b.m6773a(this.f5001a);
        } catch (Throwable e) {
            sg.m8445b("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        sg.m8444b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        sg.m8444b("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f5003c = mediationInterstitialListener;
        if (this.f5003c == null) {
            sg.m8449e("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            sg.m8449e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f5003c.onAdFailedToLoad(this, 0);
        } else if (m7684a(context)) {
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                sg.m8449e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f5003c.onAdFailedToLoad(this, 0);
                return;
            }
            this.f5001a = (Activity) context;
            this.f5004d = Uri.parse(string);
            this.f5002b = new iu();
            this.f5002b.m6774a(new C18181(this));
            this.f5002b.m6775b(this.f5001a);
            this.f5003c.onAdLoaded(this);
        } else {
            sg.m8449e("Default browser does not support custom tabs. Bailing out.");
            this.f5003c.onAdFailedToLoad(this, 0);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new Builder(this.f5002b.m6772a()).build();
        build.intent.setData(this.f5004d);
        rq.f5755a.post(new C18203(this, new AdOverlayInfoParcel(new zzc(build.intent), null, new C18192(this), null, new zzqa(0, 0, false))));
        zzv.zzcN().m8409d(false);
    }
}
