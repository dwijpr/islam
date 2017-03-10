package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;
import com.google.android.gms.internal.ka;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzgw;

public class AdLoader {
    private final gm f2308a;
    private final Context f2309b;
    private final gw f2310c;

    public static class Builder {
        private final Context f2306a;
        private final gx f2307b;

        Builder(Context context, gx gxVar) {
            this.f2306a = context;
            this.f2307b = gxVar;
        }

        public Builder(Context context, String str) {
            this((Context) C1314c.m4624a((Object) context, (Object) "context cannot be null"), gr.m6418b().m6406a(context, str, new mc()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.f2306a, this.f2307b.zzci());
            } catch (Throwable e) {
                sg.m8445b("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f2307b.zza(new jx(onAppInstallAdLoadedListener));
            } catch (Throwable e) {
                sg.m8447c("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f2307b.zza(new jy(onContentAdLoadedListener));
            } catch (Throwable e) {
                sg.m8447c("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            try {
                this.f2307b.zza(str, new ka(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new jz(onCustomClickListener));
            } catch (Throwable e) {
                sg.m8447c("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.f2307b.zzb(new gg(adListener));
            } catch (Throwable e) {
                sg.m8447c("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            C1314c.m4623a((Object) correlator);
            try {
                this.f2307b.zzb(correlator.zzbr());
            } catch (Throwable e) {
                sg.m8447c("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.f2307b.zza(new zzgw(nativeAdOptions));
            } catch (Throwable e) {
                sg.m8447c("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, gw gwVar) {
        this(context, gwVar, gm.m6341a());
    }

    AdLoader(Context context, gw gwVar, gm gmVar) {
        this.f2309b = context;
        this.f2310c = gwVar;
        this.f2308a = gmVar;
    }

    private void m3901a(hi hiVar) {
        try {
            this.f2310c.zzf(this.f2308a.m6342a(this.f2309b, hiVar));
        } catch (Throwable e) {
            sg.m8445b("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.f2310c.getMediationAdapterClassName();
        } catch (Throwable e) {
            sg.m8447c("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.f2310c.isLoading();
        } catch (Throwable e) {
            sg.m8447c("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        m3901a(adRequest.zzbq());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        m3901a(publisherAdRequest.zzbq());
    }
}
