package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@op
public class gt extends AdListener {
    private final Object f4219a;
    private AdListener f4220b;

    public gt() {
        this.f4219a = new Object();
    }

    public void m6424a(AdListener adListener) {
        synchronized (this.f4219a) {
            this.f4220b = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.f4219a) {
            if (this.f4220b != null) {
                this.f4220b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f4219a) {
            if (this.f4220b != null) {
                this.f4220b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f4219a) {
            if (this.f4220b != null) {
                this.f4220b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f4219a) {
            if (this.f4220b != null) {
                this.f4220b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f4219a) {
            if (this.f4220b != null) {
                this.f4220b.onAdOpened();
            }
        }
    }
}
