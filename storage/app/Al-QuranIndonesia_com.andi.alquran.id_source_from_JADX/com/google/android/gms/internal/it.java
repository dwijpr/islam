package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.is.C1656a;

@op
public final class it extends C1656a {
    private final OnCustomRenderedAdLoadedListener f4430a;

    public it(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f4430a = onCustomRenderedAdLoadedListener;
    }

    public void m6770a(ir irVar) {
        this.f4430a.onCustomRenderedAdLoaded(new iq(irVar));
    }
}
