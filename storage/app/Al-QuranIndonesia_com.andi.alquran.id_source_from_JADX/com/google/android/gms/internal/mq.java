package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.me.C1799a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@op
public final class mq<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C1799a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f4980a;
    private final NETWORK_EXTRAS f4981b;

    public mq(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f4980a = mediationAdapter;
        this.f4981b = network_extras;
    }

    private SERVER_PARAMETERS m7656a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                sg.m8447c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f4980a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public C1108c m7657a() {
        if (this.f4980a instanceof MediationBannerAdapter) {
            try {
                return C1111d.m3896a(((MediationBannerAdapter) this.f4980a).getBannerView());
            } catch (Throwable th) {
                sg.m8447c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4980a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void m7658a(C1108c c1108c) {
    }

    public void m7659a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
        m7661a(c1108c, com_google_android_gms_internal_zzdy, str, null, mfVar);
    }

    public void m7660a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, qr qrVar, String str2) {
    }

    public void m7661a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
        if (this.f4980a instanceof MediationInterstitialAdapter) {
            sg.m8444b("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f4980a).requestInterstitialAd(new mr(mfVar), (Activity) C1111d.m3897a(c1108c), m7656a(str, com_google_android_gms_internal_zzdy.f6439g, str2), ms.m7682a(com_google_android_gms_internal_zzdy), this.f4981b);
            } catch (Throwable th) {
                sg.m8447c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4980a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7662a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar, zzgw com_google_android_gms_internal_zzgw, List<String> list) {
    }

    public void m7663a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
        m7664a(c1108c, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzdy, str, null, mfVar);
    }

    public void m7664a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
        if (this.f4980a instanceof MediationBannerAdapter) {
            sg.m8444b("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.f4980a).requestBannerAd(new mr(mfVar), (Activity) C1111d.m3897a(c1108c), m7656a(str, com_google_android_gms_internal_zzdy.f6439g, str2), ms.m7681a(com_google_android_gms_internal_zzec), ms.m7682a(com_google_android_gms_internal_zzdy), this.f4981b);
            } catch (Throwable th) {
                sg.m8447c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4980a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void m7665a(zzdy com_google_android_gms_internal_zzdy, String str) {
    }

    public void m7666a(zzdy com_google_android_gms_internal_zzdy, String str, String str2) {
    }

    public void m7667b() {
        if (this.f4980a instanceof MediationInterstitialAdapter) {
            sg.m8444b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f4980a).showInterstitial();
            } catch (Throwable th) {
                sg.m8447c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4980a.getClass().getCanonicalName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void m7668c() {
        try {
            this.f4980a.destroy();
        } catch (Throwable th) {
            sg.m8447c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7669d() {
        throw new RemoteException();
    }

    public void m7670e() {
        throw new RemoteException();
    }

    public void m7671f() {
    }

    public boolean m7672g() {
        return true;
    }

    public mh m7673h() {
        return null;
    }

    public mi m7674i() {
        return null;
    }

    public Bundle m7675j() {
        return new Bundle();
    }

    public Bundle m7676k() {
        return new Bundle();
    }

    public Bundle m7677l() {
        return new Bundle();
    }
}
