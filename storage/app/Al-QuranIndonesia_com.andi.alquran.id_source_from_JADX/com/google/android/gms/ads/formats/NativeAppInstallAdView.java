package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.sg;

public final class NativeAppInstallAdView extends NativeAdView {
    public NativeAppInstallAdView(Context context) {
        super(context);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final View getBodyView() {
        return super.m3914a("2004");
    }

    public final View getCallToActionView() {
        return super.m3914a("2002");
    }

    public final View getHeadlineView() {
        return super.m3914a("2001");
    }

    public final View getIconView() {
        return super.m3914a("2003");
    }

    public final View getImageView() {
        return super.m3914a("2007");
    }

    public final MediaView getMediaView() {
        View a = super.m3914a("2011");
        if (a instanceof MediaView) {
            return (MediaView) a;
        }
        if (a != null) {
            sg.m8444b("View is not an instance of MediaView");
        }
        return null;
    }

    public final View getPriceView() {
        return super.m3914a("2006");
    }

    public final View getStarRatingView() {
        return super.m3914a("2008");
    }

    public final View getStoreView() {
        return super.m3914a("2005");
    }

    public final void setBodyView(View view) {
        super.m3916a("2004", view);
    }

    public final void setCallToActionView(View view) {
        super.m3916a("2002", view);
    }

    public final void setHeadlineView(View view) {
        super.m3916a("2001", view);
    }

    public final void setIconView(View view) {
        super.m3916a("2003", view);
    }

    public final void setImageView(View view) {
        super.m3916a("2007", view);
    }

    public final void setMediaView(MediaView mediaView) {
        super.m3916a("2011", mediaView);
    }

    public final void setPriceView(View view) {
        super.m3916a("2006", view);
    }

    public final void setStarRatingView(View view) {
        super.m3916a("2008", view);
    }

    public final void setStoreView(View view) {
        super.m3916a("2005", view);
    }
}
