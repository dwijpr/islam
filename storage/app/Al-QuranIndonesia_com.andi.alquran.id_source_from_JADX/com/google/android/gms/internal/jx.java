package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.js.C1694a;

@op
public class jx extends C1694a {
    private final OnAppInstallAdLoadedListener f4585a;

    public jx(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f4585a = onAppInstallAdLoadedListener;
    }

    public void m7052a(jm jmVar) {
        this.f4585a.onAppInstallAdLoaded(m7053b(jmVar));
    }

    jn m7053b(jm jmVar) {
        return new jn(jmVar);
    }
}
