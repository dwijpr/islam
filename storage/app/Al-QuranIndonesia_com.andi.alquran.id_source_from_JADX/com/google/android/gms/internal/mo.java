package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.internal.mi.C1805a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

@op
public class mo extends C1805a {
    private final NativeContentAdMapper f4970a;

    public mo(NativeContentAdMapper nativeContentAdMapper) {
        this.f4970a = nativeContentAdMapper;
    }

    public String m7643a() {
        return this.f4970a.getHeadline();
    }

    public void m7644a(C1108c c1108c) {
        this.f4970a.handleClick((View) C1111d.m3897a(c1108c));
    }

    public List m7645b() {
        List<Image> images = this.f4970a.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new ix(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public void m7646b(C1108c c1108c) {
        this.f4970a.trackView((View) C1111d.m3897a(c1108c));
    }

    public String m7647c() {
        return this.f4970a.getBody();
    }

    public void m7648c(C1108c c1108c) {
        this.f4970a.untrackView((View) C1111d.m3897a(c1108c));
    }

    public jh m7649d() {
        Image logo = this.f4970a.getLogo();
        return logo != null ? new ix(logo.getDrawable(), logo.getUri(), logo.getScale()) : null;
    }

    public String m7650e() {
        return this.f4970a.getCallToAction();
    }

    public String m7651f() {
        return this.f4970a.getAdvertiser();
    }

    public void m7652g() {
        this.f4970a.recordImpression();
    }

    public boolean m7653h() {
        return this.f4970a.getOverrideImpressionRecording();
    }

    public boolean m7654i() {
        return this.f4970a.getOverrideClickHandling();
    }

    public Bundle m7655j() {
        return this.f4970a.getExtras();
    }
}
