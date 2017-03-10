package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@op
public class nu implements InAppPurchase {
    private final nk f5113a;

    public nu(nk nkVar) {
        this.f5113a = nkVar;
    }

    public String getProductId() {
        try {
            return this.f5113a.getProductId();
        } catch (Throwable e) {
            sg.m8447c("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.f5113a.recordPlayBillingResolution(i);
        } catch (Throwable e) {
            sg.m8447c("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.f5113a.recordResolution(i);
        } catch (Throwable e) {
            sg.m8447c("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
