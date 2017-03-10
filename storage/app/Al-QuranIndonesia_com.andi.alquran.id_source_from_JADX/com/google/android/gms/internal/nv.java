package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.nq.C1842a;

@op
public final class nv extends C1842a {
    private final PlayStorePurchaseListener f5114a;

    public nv(PlayStorePurchaseListener playStorePurchaseListener) {
        this.f5114a = playStorePurchaseListener;
    }

    public void m7786a(np npVar) {
        this.f5114a.onInAppPurchaseFinished(new nt(npVar));
    }

    public boolean m7787a(String str) {
        return this.f5114a.isValidPurchase(str);
    }
}
