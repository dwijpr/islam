package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.internal.mh.C1803a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

@op
public class mn extends C1803a {
    private final NativeAppInstallAdMapper f4969a;

    public mn(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f4969a = nativeAppInstallAdMapper;
    }

    public String m7627a() {
        return this.f4969a.getHeadline();
    }

    public void m7628a(C1108c c1108c) {
        this.f4969a.handleClick((View) C1111d.m3897a(c1108c));
    }

    public List m7629b() {
        List<Image> images = this.f4969a.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new ix(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public void m7630b(C1108c c1108c) {
        this.f4969a.trackView((View) C1111d.m3897a(c1108c));
    }

    public String m7631c() {
        return this.f4969a.getBody();
    }

    public void m7632c(C1108c c1108c) {
        this.f4969a.untrackView((View) C1111d.m3897a(c1108c));
    }

    public jh m7633d() {
        Image icon = this.f4969a.getIcon();
        return icon != null ? new ix(icon.getDrawable(), icon.getUri(), icon.getScale()) : null;
    }

    public String m7634e() {
        return this.f4969a.getCallToAction();
    }

    public double m7635f() {
        return this.f4969a.getStarRating();
    }

    public String m7636g() {
        return this.f4969a.getStore();
    }

    public String m7637h() {
        return this.f4969a.getPrice();
    }

    public void m7638i() {
        this.f4969a.recordImpression();
    }

    public boolean m7639j() {
        return this.f4969a.getOverrideImpressionRecording();
    }

    public boolean m7640k() {
        return this.f4969a.getOverrideClickHandling();
    }

    public Bundle m7641l() {
        return this.f4969a.getExtras();
    }

    public hg m7642m() {
        return this.f4969a.getVideoController() != null ? this.f4969a.getVideoController().zzbt() : null;
    }
}
