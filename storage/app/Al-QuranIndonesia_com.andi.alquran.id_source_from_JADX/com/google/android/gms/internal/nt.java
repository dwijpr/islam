package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@op
public class nt implements InAppPurchaseResult {
    private final np f5112a;

    public nt(np npVar) {
        this.f5112a = npVar;
    }

    public void finishPurchase() {
        try {
            this.f5112a.finishPurchase();
        } catch (Throwable e) {
            sg.m8447c("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.f5112a.getProductId();
        } catch (Throwable e) {
            sg.m8447c("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.f5112a.getPurchaseData();
        } catch (Throwable e) {
            sg.m8447c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.f5112a.getResultCode();
        } catch (Throwable e) {
            sg.m8447c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.f5112a.isVerified();
        } catch (Throwable e) {
            sg.m8447c("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
