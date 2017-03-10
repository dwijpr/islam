package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.sg;

/* renamed from: com.google.android.gms.ads.a */
class C1116a extends ViewGroup {
    protected final hj f2316a;

    public C1116a(Context context, int i) {
        super(context);
        this.f2316a = new hj(this, i);
    }

    public C1116a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2316a = new hj(this, attributeSet, false, i);
    }

    public C1116a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f2316a = new hj(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.f2316a.m6533a();
    }

    public AdListener getAdListener() {
        return this.f2316a.m6547b();
    }

    public AdSize getAdSize() {
        return this.f2316a.m6549c();
    }

    public String getAdUnitId() {
        return this.f2316a.m6551e();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f2316a.m6553g();
    }

    public String getMediationAdapterClassName() {
        return this.f2316a.m6558l();
    }

    public boolean isLoading() {
        return this.f2316a.m6559m();
    }

    public void loadAd(AdRequest adRequest) {
        this.f2316a.m6542a(adRequest.zzbq());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int widthInPixels;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize;
            AdSize adSize2 = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                sg.m8445b("Unable to retrieve ad size.", e);
                adSize = adSize2;
            }
            if (adSize != null) {
                Context context = getContext();
                widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
            } else {
                widthInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            widthInPixels = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(widthInPixels, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.f2316a.m6555i();
    }

    public void resume() {
        this.f2316a.m6557k();
    }

    public void setAdListener(AdListener adListener) {
        this.f2316a.m6534a(adListener);
        if (adListener != null && (adListener instanceof ge)) {
            this.f2316a.m6541a((ge) adListener);
        } else if (adListener == null) {
            this.f2316a.m6541a(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f2316a.m6545a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f2316a.m6543a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f2316a.m6539a(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f2316a.m6540a(playStorePurchaseListener, str);
    }
}
