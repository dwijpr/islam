package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.nl.C1738a;

@op
public final class nr extends C1738a {
    private final InAppPurchaseListener f5111a;

    public nr(InAppPurchaseListener inAppPurchaseListener) {
        this.f5111a = inAppPurchaseListener;
    }

    public void m7782a(nk nkVar) {
        this.f5111a.onInAppPurchaseRequested(new nu(nkVar));
    }
}
