package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class CircleOptions extends zza {
    public static final Creator<CircleOptions> CREATOR;
    private final int f6910a;
    private LatLng f6911b;
    private double f6912c;
    private float f6913d;
    private int f6914e;
    private int f6915f;
    private float f6916g;
    private boolean f6917h;
    private boolean f6918i;

    static {
        CREATOR = new zzb();
    }

    public CircleOptions() {
        this.f6911b = null;
        this.f6912c = 0.0d;
        this.f6913d = 10.0f;
        this.f6914e = -16777216;
        this.f6915f = 0;
        this.f6916g = 0.0f;
        this.f6917h = true;
        this.f6918i = false;
        this.f6910a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.f6911b = null;
        this.f6912c = 0.0d;
        this.f6913d = 10.0f;
        this.f6914e = -16777216;
        this.f6915f = 0;
        this.f6916g = 0.0f;
        this.f6917h = true;
        this.f6918i = false;
        this.f6910a = i;
        this.f6911b = latLng;
        this.f6912c = d;
        this.f6913d = f;
        this.f6914e = i2;
        this.f6915f = i3;
        this.f6916g = f2;
        this.f6917h = z;
        this.f6918i = z2;
    }

    int m10039a() {
        return this.f6910a;
    }

    public CircleOptions center(LatLng latLng) {
        this.f6911b = latLng;
        return this;
    }

    public CircleOptions clickable(boolean z) {
        this.f6918i = z;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f6915f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f6911b;
    }

    public int getFillColor() {
        return this.f6915f;
    }

    public double getRadius() {
        return this.f6912c;
    }

    public int getStrokeColor() {
        return this.f6914e;
    }

    public float getStrokeWidth() {
        return this.f6913d;
    }

    public float getZIndex() {
        return this.f6916g;
    }

    public boolean isClickable() {
        return this.f6918i;
    }

    public boolean isVisible() {
        return this.f6917h;
    }

    public CircleOptions radius(double d) {
        this.f6912c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f6914e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f6913d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6917h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m10071a(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.f6916g = f;
        return this;
    }
}
