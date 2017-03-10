package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@op
public final class mr<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final mf f4995a;

    /* renamed from: com.google.android.gms.internal.mr.1 */
    class C18081 implements Runnable {
        final /* synthetic */ mr f4984a;

        C18081(mr mrVar) {
            this.f4984a = mrVar;
        }

        public void run() {
            try {
                this.f4984a.f4995a.m7384a();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.2 */
    class C18092 implements Runnable {
        final /* synthetic */ ErrorCode f4985a;
        final /* synthetic */ mr f4986b;

        C18092(mr mrVar, ErrorCode errorCode) {
            this.f4986b = mrVar;
            this.f4985a = errorCode;
        }

        public void run() {
            try {
                this.f4986b.f4995a.m7385a(ms.m7679a(this.f4985a));
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.3 */
    class C18103 implements Runnable {
        final /* synthetic */ mr f4987a;

        C18103(mr mrVar) {
            this.f4987a = mrVar;
        }

        public void run() {
            try {
                this.f4987a.f4995a.m7388c();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.4 */
    class C18114 implements Runnable {
        final /* synthetic */ mr f4988a;

        C18114(mr mrVar) {
            this.f4988a = mrVar;
        }

        public void run() {
            try {
                this.f4988a.f4995a.m7389d();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.5 */
    class C18125 implements Runnable {
        final /* synthetic */ mr f4989a;

        C18125(mr mrVar) {
            this.f4989a = mrVar;
        }

        public void run() {
            try {
                this.f4989a.f4995a.m7390e();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.6 */
    class C18136 implements Runnable {
        final /* synthetic */ mr f4990a;

        C18136(mr mrVar) {
            this.f4990a = mrVar;
        }

        public void run() {
            try {
                this.f4990a.f4995a.m7387b();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.7 */
    class C18147 implements Runnable {
        final /* synthetic */ ErrorCode f4991a;
        final /* synthetic */ mr f4992b;

        C18147(mr mrVar, ErrorCode errorCode) {
            this.f4992b = mrVar;
            this.f4991a = errorCode;
        }

        public void run() {
            try {
                this.f4992b.f4995a.m7385a(ms.m7679a(this.f4991a));
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.8 */
    class C18158 implements Runnable {
        final /* synthetic */ mr f4993a;

        C18158(mr mrVar) {
            this.f4993a = mrVar;
        }

        public void run() {
            try {
                this.f4993a.f4995a.m7388c();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mr.9 */
    class C18169 implements Runnable {
        final /* synthetic */ mr f4994a;

        C18169(mr mrVar) {
            this.f4994a = mrVar;
        }

        public void run() {
            try {
                this.f4994a.f4995a.m7389d();
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdOpened.", e);
            }
        }
    }

    public mr(mf mfVar) {
        this.f4995a = mfVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        sg.m8444b("Adapter called onClick.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7384a();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClicked.", e);
                return;
            }
        }
        sg.m8449e("onClick must be called on the main UI thread.");
        sf.f5831a.post(new C18081(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        sg.m8444b("Adapter called onDismissScreen.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7387b();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClosed.", e);
                return;
            }
        }
        sg.m8449e("onDismissScreen must be called on the main UI thread.");
        sf.f5831a.post(new C18136(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        sg.m8444b("Adapter called onDismissScreen.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7387b();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdClosed.", e);
                return;
            }
        }
        sg.m8449e("onDismissScreen must be called on the main UI thread.");
        sf.f5831a.post(new Runnable() {
            final /* synthetic */ mr f4983a;

            {
                this.f4983a = r1;
            }

            public void run() {
                try {
                    this.f4983a.f4995a.m7387b();
                } catch (Throwable e) {
                    sg.m8447c("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        sg.m8444b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7385a(ms.m7679a(errorCode));
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        sg.m8449e("onFailedToReceiveAd must be called on the main UI thread.");
        sf.f5831a.post(new C18147(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        sg.m8444b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7385a(ms.m7679a(errorCode));
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        sg.m8449e("onFailedToReceiveAd must be called on the main UI thread.");
        sf.f5831a.post(new C18092(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        sg.m8444b("Adapter called onLeaveApplication.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7388c();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        sg.m8449e("onLeaveApplication must be called on the main UI thread.");
        sf.f5831a.post(new C18158(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        sg.m8444b("Adapter called onLeaveApplication.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7388c();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        sg.m8449e("onLeaveApplication must be called on the main UI thread.");
        sf.f5831a.post(new C18103(this));
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        sg.m8444b("Adapter called onPresentScreen.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7389d();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdOpened.", e);
                return;
            }
        }
        sg.m8449e("onPresentScreen must be called on the main UI thread.");
        sf.f5831a.post(new C18169(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        sg.m8444b("Adapter called onPresentScreen.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7389d();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdOpened.", e);
                return;
            }
        }
        sg.m8449e("onPresentScreen must be called on the main UI thread.");
        sf.f5831a.post(new C18114(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        sg.m8444b("Adapter called onReceivedAd.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7390e();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLoaded.", e);
                return;
            }
        }
        sg.m8449e("onReceivedAd must be called on the main UI thread.");
        sf.f5831a.post(new Runnable() {
            final /* synthetic */ mr f4982a;

            {
                this.f4982a = r1;
            }

            public void run() {
                try {
                    this.f4982a.f4995a.m7390e();
                } catch (Throwable e) {
                    sg.m8447c("Could not call onAdLoaded.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        sg.m8444b("Adapter called onReceivedAd.");
        if (gr.m6416a().m8704b()) {
            try {
                this.f4995a.m7390e();
                return;
            } catch (Throwable e) {
                sg.m8447c("Could not call onAdLoaded.", e);
                return;
            }
        }
        sg.m8449e("onReceivedAd must be called on the main UI thread.");
        sf.f5831a.post(new C18125(this));
    }
}
