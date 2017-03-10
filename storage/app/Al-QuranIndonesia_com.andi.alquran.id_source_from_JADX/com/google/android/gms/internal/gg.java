package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.gv.C1592a;

@op
public final class gg extends C1592a {
    private final AdListener f4144a;

    public gg(AdListener adListener) {
        this.f4144a = adListener;
    }

    public void m6319a() {
        this.f4144a.onAdClosed();
    }

    public void m6320a(int i) {
        this.f4144a.onAdFailedToLoad(i);
    }

    public void m6321b() {
        this.f4144a.onAdLeftApplication();
    }

    public void m6322c() {
        this.f4144a.onAdLoaded();
    }

    public void m6323d() {
        this.f4144a.onAdOpened();
    }
}
