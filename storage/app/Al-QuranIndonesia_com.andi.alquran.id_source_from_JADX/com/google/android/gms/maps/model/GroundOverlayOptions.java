package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.p039a.C1108c.C1110a;

public final class GroundOverlayOptions extends zza {
    public static final Creator<GroundOverlayOptions> CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private final int f6920a;
    private BitmapDescriptor f6921b;
    private LatLng f6922c;
    private float f6923d;
    private float f6924e;
    private LatLngBounds f6925f;
    private float f6926g;
    private float f6927h;
    private boolean f6928i;
    private float f6929j;
    private float f6930k;
    private float f6931l;
    private boolean f6932m;

    static {
        CREATOR = new zzc();
    }

    public GroundOverlayOptions() {
        this.f6928i = true;
        this.f6929j = 0.0f;
        this.f6930k = 0.5f;
        this.f6931l = 0.5f;
        this.f6932m = false;
        this.f6920a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.f6928i = true;
        this.f6929j = 0.0f;
        this.f6930k = 0.5f;
        this.f6931l = 0.5f;
        this.f6932m = false;
        this.f6920a = i;
        this.f6921b = new BitmapDescriptor(C1110a.m3895a(iBinder));
        this.f6922c = latLng;
        this.f6923d = f;
        this.f6924e = f2;
        this.f6925f = latLngBounds;
        this.f6926g = f3;
        this.f6927h = f4;
        this.f6928i = z;
        this.f6929j = f5;
        this.f6930k = f6;
        this.f6931l = f7;
        this.f6932m = z2;
    }

    private GroundOverlayOptions m10040a(LatLng latLng, float f, float f2) {
        this.f6922c = latLng;
        this.f6923d = f;
        this.f6924e = f2;
        return this;
    }

    IBinder m10041a() {
        return this.f6921b.zzIy().asBinder();
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f6930k = f;
        this.f6931l = f2;
        return this;
    }

    int m10042b() {
        return this.f6920a;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f6926g = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z) {
        this.f6932m = z;
        return this;
    }

    public float getAnchorU() {
        return this.f6930k;
    }

    public float getAnchorV() {
        return this.f6931l;
    }

    public float getBearing() {
        return this.f6926g;
    }

    public LatLngBounds getBounds() {
        return this.f6925f;
    }

    public float getHeight() {
        return this.f6924e;
    }

    public BitmapDescriptor getImage() {
        return this.f6921b;
    }

    public LatLng getLocation() {
        return this.f6922c;
    }

    public float getTransparency() {
        return this.f6929j;
    }

    public float getWidth() {
        return this.f6923d;
    }

    public float getZIndex() {
        return this.f6927h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f6921b = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.f6932m;
    }

    public boolean isVisible() {
        return this.f6928i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        C1314c.m4629a(this.f6925f == null, (Object) "Position has already been set using positionFromBounds");
        C1314c.m4633b(latLng != null, "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        C1314c.m4633b(z, "Width must be non-negative");
        return m10040a(latLng, f, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        C1314c.m4629a(this.f6925f == null, (Object) "Position has already been set using positionFromBounds");
        C1314c.m4633b(latLng != null, "Location must be specified");
        C1314c.m4633b(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        C1314c.m4633b(z, "Height must be non-negative");
        return m10040a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        boolean z = this.f6922c == null;
        String valueOf = String.valueOf(this.f6922c);
        C1314c.m4629a(z, new StringBuilder(String.valueOf(valueOf).length() + 46).append("Position has already been set using position: ").append(valueOf).toString());
        this.f6925f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        C1314c.m4633b(z, "Transparency must be in the range [0..1]");
        this.f6929j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f6928i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m10072a(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f6927h = f;
        return this;
    }
}
