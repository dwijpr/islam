package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private String f2245d;
    private List<Image> f2246e;
    private String f2247f;
    private Image f2248g;
    private String f2249h;
    private double f2250i;
    private String f2251j;
    private String f2252k;
    private VideoController f2253l;

    public final String getBody() {
        return this.f2247f;
    }

    public final String getCallToAction() {
        return this.f2249h;
    }

    public final String getHeadline() {
        return this.f2245d;
    }

    public final Image getIcon() {
        return this.f2248g;
    }

    public final List<Image> getImages() {
        return this.f2246e;
    }

    public final String getPrice() {
        return this.f2252k;
    }

    public final double getStarRating() {
        return this.f2250i;
    }

    public final String getStore() {
        return this.f2251j;
    }

    public final VideoController getVideoController() {
        return this.f2253l;
    }

    public final void setBody(String str) {
        this.f2247f = str;
    }

    public final void setCallToAction(String str) {
        this.f2249h = str;
    }

    public final void setHeadline(String str) {
        this.f2245d = str;
    }

    public final void setIcon(Image image) {
        this.f2248g = image;
    }

    public final void setImages(List<Image> list) {
        this.f2246e = list;
    }

    public final void setPrice(String str) {
        this.f2252k = str;
    }

    public final void setStarRating(double d) {
        this.f2250i = d;
    }

    public final void setStore(String str) {
        this.f2251j = str;
    }

    public final void zza(VideoController videoController) {
        this.f2253l = videoController;
    }
}
