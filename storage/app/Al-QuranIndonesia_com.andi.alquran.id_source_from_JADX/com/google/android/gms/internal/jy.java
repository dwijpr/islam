package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.jt.C1696a;

@op
public class jy extends C1696a {
    private final OnContentAdLoadedListener f4586a;

    public jy(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f4586a = onContentAdLoadedListener;
    }

    public void m7054a(jo joVar) {
        this.f4586a.onContentAdLoaded(m7055b(joVar));
    }

    jp m7055b(jo joVar) {
        return new jp(joVar);
    }
}
