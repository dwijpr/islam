package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;

@op
public final class SearchAdView extends ViewGroup {
    private final hj f2799a;

    public SearchAdView(Context context) {
        super(context);
        this.f2799a = new hj(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2799a = new hj(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2799a = new hj(this, attributeSet, false);
    }

    public void destroy() {
        this.f2799a.m6533a();
    }

    public AdListener getAdListener() {
        return this.f2799a.m6547b();
    }

    public AdSize getAdSize() {
        return this.f2799a.m6549c();
    }

    public String getAdUnitId() {
        return this.f2799a.m6551e();
    }

    public void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.f2799a.m6542a(dynamicHeightSearchAdRequest.m4161a());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public void loadAd(SearchAdRequest searchAdRequest) {
        this.f2799a.m6542a(searchAdRequest.m4177a());
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
        this.f2799a.m6555i();
    }

    public void resume() {
        this.f2799a.m6557k();
    }

    public void setAdListener(AdListener adListener) {
        this.f2799a.m6534a(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.f2799a.m6545a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f2799a.m6543a(str);
    }
}
