package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.jk;
import com.google.android.gms.internal.sg;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout f2339a;
    private final jk f2340b;

    public NativeAdView(Context context) {
        super(context);
        this.f2339a = m3913b(context);
        this.f2340b = m3912a();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2339a = m3913b(context);
        this.f2340b = m3912a();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2339a = m3913b(context);
        this.f2340b = m3912a();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2339a = m3913b(context);
        this.f2340b = m3912a();
    }

    private jk m3912a() {
        C1314c.m4624a(this.f2339a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return gr.m6418b().m6410a(this.f2339a.getContext(), (FrameLayout) this, this.f2339a);
    }

    private FrameLayout m3913b(Context context) {
        View a = m3915a(context);
        a.setLayoutParams(new LayoutParams(-1, -1));
        addView(a);
        return a;
    }

    protected View m3914a(String str) {
        try {
            C1108c a = this.f2340b.m6599a(str);
            if (a != null) {
                return (View) C1111d.m3897a(a);
            }
        } catch (Throwable e) {
            sg.m8445b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout m3915a(Context context) {
        return new FrameLayout(context);
    }

    protected void m3916a(String str, View view) {
        try {
            this.f2340b.m6602a(str, C1111d.m3896a((Object) view));
        } catch (Throwable e) {
            sg.m8445b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f2339a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f2339a != view) {
            super.bringChildToFront(this.f2339a);
        }
    }

    public void destroy() {
        try {
            this.f2340b.m6600a();
        } catch (Throwable e) {
            sg.m8445b("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f2339a);
    }

    public void removeView(View view) {
        if (this.f2339a != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f2340b.m6601a((C1108c) nativeAd.m3906a());
        } catch (Throwable e) {
            sg.m8445b("Unable to call setNativeAd on delegate", e);
        }
    }
}
