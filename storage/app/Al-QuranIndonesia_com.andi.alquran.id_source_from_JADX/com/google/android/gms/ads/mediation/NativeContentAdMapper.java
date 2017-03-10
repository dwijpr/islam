package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private String f2255d;
    private List<Image> f2256e;
    private String f2257f;
    private Image f2258g;
    private String f2259h;
    private String f2260i;

    public final String getAdvertiser() {
        return this.f2260i;
    }

    public final String getBody() {
        return this.f2257f;
    }

    public final String getCallToAction() {
        return this.f2259h;
    }

    public final String getHeadline() {
        return this.f2255d;
    }

    public final List<Image> getImages() {
        return this.f2256e;
    }

    public final Image getLogo() {
        return this.f2258g;
    }

    public final void setAdvertiser(String str) {
        this.f2260i = str;
    }

    public final void setBody(String str) {
        this.f2257f = str;
    }

    public final void setCallToAction(String str) {
        this.f2259h = str;
    }

    public final void setHeadline(String str) {
        this.f2255d = str;
    }

    public final void setImages(List<Image> list) {
        this.f2256e = list;
    }

    public final void setLogo(Image image) {
        this.f2258g = image;
    }
}
