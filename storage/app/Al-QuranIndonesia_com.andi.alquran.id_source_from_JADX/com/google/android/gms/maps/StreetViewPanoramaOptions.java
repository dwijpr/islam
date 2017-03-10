package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions extends zza implements ReflectedParcelable {
    public static final Creator<StreetViewPanoramaOptions> CREATOR;
    private final int f6821a;
    private StreetViewPanoramaCamera f6822b;
    private String f6823c;
    private LatLng f6824d;
    private Integer f6825e;
    private Boolean f6826f;
    private Boolean f6827g;
    private Boolean f6828h;
    private Boolean f6829i;
    private Boolean f6830j;

    static {
        CREATOR = new zzb();
    }

    public StreetViewPanoramaOptions() {
        this.f6826f = Boolean.valueOf(true);
        this.f6827g = Boolean.valueOf(true);
        this.f6828h = Boolean.valueOf(true);
        this.f6829i = Boolean.valueOf(true);
        this.f6821a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f6826f = Boolean.valueOf(true);
        this.f6827g = Boolean.valueOf(true);
        this.f6828h = Boolean.valueOf(true);
        this.f6829i = Boolean.valueOf(true);
        this.f6821a = i;
        this.f6822b = streetViewPanoramaCamera;
        this.f6824d = latLng;
        this.f6825e = num;
        this.f6823c = str;
        this.f6826f = com.google.android.gms.maps.internal.zza.zza(b);
        this.f6827g = com.google.android.gms.maps.internal.zza.zza(b2);
        this.f6828h = com.google.android.gms.maps.internal.zza.zza(b3);
        this.f6829i = com.google.android.gms.maps.internal.zza.zza(b4);
        this.f6830j = com.google.android.gms.maps.internal.zza.zza(b5);
    }

    int m9976a() {
        return this.f6821a;
    }

    byte m9977b() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6826f);
    }

    byte m9978c() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6827g);
    }

    byte m9979d() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6828h);
    }

    byte m9980e() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6829i);
    }

    byte m9981f() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6830j);
    }

    public Boolean getPanningGesturesEnabled() {
        return this.f6828h;
    }

    public String getPanoramaId() {
        return this.f6823c;
    }

    public LatLng getPosition() {
        return this.f6824d;
    }

    public Integer getRadius() {
        return this.f6825e;
    }

    public Boolean getStreetNamesEnabled() {
        return this.f6829i;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f6822b;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f6830j;
    }

    public Boolean getUserNavigationEnabled() {
        return this.f6826f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f6827g;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.f6828h = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f6822b = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.f6823c = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.f6824d = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f6824d = latLng;
        this.f6825e = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.f6829i = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.f6830j = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.f6826f = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m10088a(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.f6827g = Boolean.valueOf(z);
        return this;
    }
}
