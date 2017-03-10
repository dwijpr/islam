package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public final class zzfj extends zza {
    public static final Creator<zzfj> CREATOR;
    public final int f6462a;
    public final int f6463b;
    public final int f6464c;
    public final int f6465d;
    public final int f6466e;
    public final int f6467f;
    public final int f6468g;
    public final int f6469h;
    public final int f6470i;
    public final String f6471j;
    public final int f6472k;
    public final String f6473l;
    public final int f6474m;
    public final int f6475n;
    public final String f6476o;

    static {
        CREATOR = new hu();
    }

    zzfj(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f6462a = i;
        this.f6463b = i2;
        this.f6464c = i3;
        this.f6465d = i4;
        this.f6466e = i5;
        this.f6467f = i6;
        this.f6468g = i7;
        this.f6469h = i8;
        this.f6470i = i9;
        this.f6471j = str;
        this.f6472k = i10;
        this.f6473l = str2;
        this.f6474m = i11;
        this.f6475n = i12;
        this.f6476o = str3;
    }

    public zzfj(SearchAdRequest searchAdRequest) {
        this.f6462a = 1;
        this.f6463b = searchAdRequest.getAnchorTextColor();
        this.f6464c = searchAdRequest.getBackgroundColor();
        this.f6465d = searchAdRequest.getBackgroundGradientBottom();
        this.f6466e = searchAdRequest.getBackgroundGradientTop();
        this.f6467f = searchAdRequest.getBorderColor();
        this.f6468g = searchAdRequest.getBorderThickness();
        this.f6469h = searchAdRequest.getBorderType();
        this.f6470i = searchAdRequest.getCallButtonColor();
        this.f6471j = searchAdRequest.getCustomChannels();
        this.f6472k = searchAdRequest.getDescriptionTextColor();
        this.f6473l = searchAdRequest.getFontFace();
        this.f6474m = searchAdRequest.getHeaderTextColor();
        this.f6475n = searchAdRequest.getHeaderTextSize();
        this.f6476o = searchAdRequest.getQuery();
    }

    public void writeToParcel(Parcel parcel, int i) {
        hu.m6632a(this, parcel, i);
    }
}
