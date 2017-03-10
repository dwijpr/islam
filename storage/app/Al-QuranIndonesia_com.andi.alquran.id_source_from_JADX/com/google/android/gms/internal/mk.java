package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.internal.me.C1799a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@op
public final class mk extends C1799a {
    private final MediationAdapter f4944a;
    private mm f4945b;

    public mk(MediationAdapter mediationAdapter) {
        this.f4944a = mediationAdapter;
    }

    private Bundle m7574a(String str, int i, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.f4944a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            sg.m8447c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C1108c m7575a() {
        if (this.f4944a instanceof MediationBannerAdapter) {
            try {
                return C1111d.m3896a(((MediationBannerAdapter) this.f4944a).getBannerView());
            } catch (Throwable th) {
                sg.m8447c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void m7576a(C1108c c1108c) {
        try {
            ((OnContextChangedListener) this.f4944a).onContextChanged((Context) C1111d.m3897a(c1108c));
        } catch (Throwable th) {
            sg.m8442a("Could not inform adapter of changed context", th);
        }
    }

    public void m7577a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
        m7579a(c1108c, com_google_android_gms_internal_zzdy, str, null, mfVar);
    }

    public void m7578a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, qr qrVar, String str2) {
        if (this.f4944a instanceof MediationRewardedVideoAdAdapter) {
            sg.m8444b("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f4944a;
                mediationRewardedVideoAdAdapter.initialize((Context) C1111d.m3897a(c1108c), new mj(com_google_android_gms_internal_zzdy.f6434b == -1 ? null : new Date(com_google_android_gms_internal_zzdy.f6434b), com_google_android_gms_internal_zzdy.f6436d, com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6439g, com_google_android_gms_internal_zzdy.f6450r), str, new qs(qrVar), m7574a(str2, com_google_android_gms_internal_zzdy.f6439g, null), com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                sg.m8447c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7579a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
        if (this.f4944a instanceof MediationInterstitialAdapter) {
            sg.m8444b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f4944a;
                mediationInterstitialAdapter.requestInterstitialAd((Context) C1111d.m3897a(c1108c), new mm(mfVar), m7574a(str, com_google_android_gms_internal_zzdy.f6439g, str2), new mj(com_google_android_gms_internal_zzdy.f6434b == -1 ? null : new Date(com_google_android_gms_internal_zzdy.f6434b), com_google_android_gms_internal_zzdy.f6436d, com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6439g, com_google_android_gms_internal_zzdy.f6450r), com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                sg.m8447c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7580a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar, zzgw com_google_android_gms_internal_zzgw, List<String> list) {
        if (this.f4944a instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.f4944a;
                mp mpVar = new mp(com_google_android_gms_internal_zzdy.f6434b == -1 ? null : new Date(com_google_android_gms_internal_zzdy.f6434b), com_google_android_gms_internal_zzdy.f6436d, com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6439g, com_google_android_gms_internal_zzgw, list, com_google_android_gms_internal_zzdy.f6450r);
                Bundle bundle = com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.f4945b = new mm(mfVar);
                mediationNativeAdapter.requestNativeAd((Context) C1111d.m3897a(c1108c), this.f4945b, m7574a(str, com_google_android_gms_internal_zzdy.f6439g, str2), mpVar, bundle);
            } catch (Throwable th) {
                sg.m8447c("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7581a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
        m7582a(c1108c, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzdy, str, null, mfVar);
    }

    public void m7582a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
        if (this.f4944a instanceof MediationBannerAdapter) {
            sg.m8444b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f4944a;
                mediationBannerAdapter.requestBannerAd((Context) C1111d.m3897a(c1108c), new mm(mfVar), m7574a(str, com_google_android_gms_internal_zzdy.f6439g, str2), zza.zza(com_google_android_gms_internal_zzec.f6456f, com_google_android_gms_internal_zzec.f6453c, com_google_android_gms_internal_zzec.f6452b), new mj(com_google_android_gms_internal_zzdy.f6434b == -1 ? null : new Date(com_google_android_gms_internal_zzdy.f6434b), com_google_android_gms_internal_zzdy.f6436d, com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6439g, com_google_android_gms_internal_zzdy.f6450r), com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                sg.m8447c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7583a(zzdy com_google_android_gms_internal_zzdy, String str) {
        m7584a(com_google_android_gms_internal_zzdy, str, null);
    }

    public void m7584a(zzdy com_google_android_gms_internal_zzdy, String str, String str2) {
        if (this.f4944a instanceof MediationRewardedVideoAdAdapter) {
            sg.m8444b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f4944a;
                mediationRewardedVideoAdAdapter.loadAd(new mj(com_google_android_gms_internal_zzdy.f6434b == -1 ? null : new Date(com_google_android_gms_internal_zzdy.f6434b), com_google_android_gms_internal_zzdy.f6436d, com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6443k, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6439g, com_google_android_gms_internal_zzdy.f6450r), m7574a(str, com_google_android_gms_internal_zzdy.f6439g, str2), com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                sg.m8447c("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7585b() {
        if (this.f4944a instanceof MediationInterstitialAdapter) {
            sg.m8444b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f4944a).showInterstitial();
            } catch (Throwable th) {
                sg.m8447c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void m7586c() {
        try {
            this.f4944a.onDestroy();
        } catch (Throwable th) {
            sg.m8447c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7587d() {
        try {
            this.f4944a.onPause();
        } catch (Throwable th) {
            sg.m8447c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7588e() {
        try {
            this.f4944a.onResume();
        } catch (Throwable th) {
            sg.m8447c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7589f() {
        if (this.f4944a instanceof MediationRewardedVideoAdAdapter) {
            sg.m8444b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f4944a).showVideo();
            } catch (Throwable th) {
                sg.m8447c("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean m7590g() {
        if (this.f4944a instanceof MediationRewardedVideoAdAdapter) {
            sg.m8444b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f4944a).isInitialized();
            } catch (Throwable th) {
                sg.m8447c("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public mh m7591h() {
        NativeAdMapper a = this.f4945b.m7626a();
        return a instanceof NativeAppInstallAdMapper ? new mn((NativeAppInstallAdMapper) a) : null;
    }

    public mi m7592i() {
        NativeAdMapper a = this.f4945b.m7626a();
        return a instanceof NativeContentAdMapper ? new mo((NativeContentAdMapper) a) : null;
    }

    public Bundle m7593j() {
        if (this.f4944a instanceof tl) {
            return ((tl) this.f4944a).m8994a();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
        sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle m7594k() {
        if (this.f4944a instanceof tm) {
            return ((tm) this.f4944a).getInterstitialAdapterInfo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f4944a.getClass().getCanonicalName());
        sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle m7595l() {
        return new Bundle();
    }
}
