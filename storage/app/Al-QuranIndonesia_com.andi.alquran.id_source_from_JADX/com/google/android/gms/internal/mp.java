package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@op
public final class mp implements NativeMediationAdRequest {
    private final Date f4971a;
    private final int f4972b;
    private final Set<String> f4973c;
    private final boolean f4974d;
    private final Location f4975e;
    private final int f4976f;
    private final zzgw f4977g;
    private final List<String> f4978h;
    private final boolean f4979i;

    public mp(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzgw com_google_android_gms_internal_zzgw, List<String> list, boolean z2) {
        this.f4971a = date;
        this.f4972b = i;
        this.f4973c = set;
        this.f4975e = location;
        this.f4974d = z;
        this.f4976f = i2;
        this.f4977g = com_google_android_gms_internal_zzgw;
        this.f4978h = list;
        this.f4979i = z2;
    }

    public Date getBirthday() {
        return this.f4971a;
    }

    public int getGender() {
        return this.f4972b;
    }

    public Set<String> getKeywords() {
        return this.f4973c;
    }

    public Location getLocation() {
        return this.f4975e;
    }

    public NativeAdOptions getNativeAdOptions() {
        if (this.f4977g == null) {
            return null;
        }
        Builder requestMultipleImages = new Builder().setReturnUrlsForImageAssets(this.f4977g.f6480b).setImageOrientation(this.f4977g.f6481c).setRequestMultipleImages(this.f4977g.f6482d);
        if (this.f4977g.f6479a >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.f4977g.f6483e);
        }
        if (this.f4977g.f6479a >= 3 && this.f4977g.f6484f != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions.Builder().setStartMuted(this.f4977g.f6484f.f6478b).build());
        }
        return requestMultipleImages.build();
    }

    public boolean isAppInstallAdRequested() {
        return this.f4978h != null && this.f4978h.contains("2");
    }

    public boolean isContentAdRequested() {
        return this.f4978h != null && this.f4978h.contains("1");
    }

    public boolean isDesignedForFamilies() {
        return this.f4979i;
    }

    public boolean isTesting() {
        return this.f4974d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f4976f;
    }
}
