package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.sg;

public final class PublisherAdView extends ViewGroup {
    private final hj f2327a;

    public PublisherAdView(Context context) {
        super(context);
        this.f2327a = new hj(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2327a = new hj(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2327a = new hj(this, attributeSet, true);
    }

    public void destroy() {
        this.f2327a.m6533a();
    }

    public AdListener getAdListener() {
        return this.f2327a.m6547b();
    }

    public AdSize getAdSize() {
        return this.f2327a.m6549c();
    }

    public AdSize[] getAdSizes() {
        return this.f2327a.m6550d();
    }

    public String getAdUnitId() {
        return this.f2327a.m6551e();
    }

    public AppEventListener getAppEventListener() {
        return this.f2327a.m6552f();
    }

    public String getMediationAdapterClassName() {
        return this.f2327a.m6558l();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f2327a.m6554h();
    }

    public boolean isLoading() {
        return this.f2327a.m6559m();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f2327a.m6542a(publisherAdRequest.zzbq());
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
        this.f2327a.m6555i();
    }

    public void recordManualImpression() {
        this.f2327a.m6556j();
    }

    public void resume() {
        this.f2327a.m6557k();
    }

    public void setAdListener(AdListener adListener) {
        this.f2327a.m6534a(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f2327a.m6548b(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.f2327a.m6543a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f2327a.m6537a(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f2327a.m6535a(correlator);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f2327a.m6544a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f2327a.m6538a(onCustomRenderedAdLoadedListener);
    }
}
