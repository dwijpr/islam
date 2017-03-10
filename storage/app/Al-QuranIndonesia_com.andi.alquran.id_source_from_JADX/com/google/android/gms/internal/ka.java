package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.jv.C1700a;

@op
public class ka extends C1700a {
    private final OnCustomTemplateAdLoadedListener f4589a;

    public ka(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f4589a = onCustomTemplateAdLoadedListener;
    }

    public void m7064a(jq jqVar) {
        this.f4589a.onCustomTemplateAdLoaded(new jr(jqVar));
    }
}
