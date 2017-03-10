package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.ju.C1698a;

@op
public class jz extends C1698a {
    private final OnCustomClickListener f4587a;

    public jz(OnCustomClickListener onCustomClickListener) {
        this.f4587a = onCustomClickListener;
    }

    public void m7056a(jq jqVar, String str) {
        this.f4587a.onCustomClick(new jr(jqVar), str);
    }
}
