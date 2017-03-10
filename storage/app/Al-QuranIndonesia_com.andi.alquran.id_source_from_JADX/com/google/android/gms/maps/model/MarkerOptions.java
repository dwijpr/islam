package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.p039a.C1108c.C1110a;

public final class MarkerOptions extends zza {
    public static final Creator<MarkerOptions> CREATOR;
    private final int f6945a;
    private LatLng f6946b;
    private String f6947c;
    private String f6948d;
    private BitmapDescriptor f6949e;
    private float f6950f;
    private float f6951g;
    private boolean f6952h;
    private boolean f6953i;
    private boolean f6954j;
    private float f6955k;
    private float f6956l;
    private float f6957m;
    private float f6958n;
    private float f6959o;

    static {
        CREATOR = new zzg();
    }

    public MarkerOptions() {
        this.f6950f = 0.5f;
        this.f6951g = 1.0f;
        this.f6953i = true;
        this.f6954j = false;
        this.f6955k = 0.0f;
        this.f6956l = 0.5f;
        this.f6957m = 0.0f;
        this.f6958n = 1.0f;
        this.f6945a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.f6950f = 0.5f;
        this.f6951g = 1.0f;
        this.f6953i = true;
        this.f6954j = false;
        this.f6955k = 0.0f;
        this.f6956l = 0.5f;
        this.f6957m = 0.0f;
        this.f6958n = 1.0f;
        this.f6945a = i;
        this.f6946b = latLng;
        this.f6947c = str;
        this.f6948d = str2;
        this.f6949e = iBinder == null ? null : new BitmapDescriptor(C1110a.m3895a(iBinder));
        this.f6950f = f;
        this.f6951g = f2;
        this.f6952h = z;
        this.f6953i = z2;
        this.f6954j = z3;
        this.f6955k = f3;
        this.f6956l = f4;
        this.f6957m = f5;
        this.f6958n = f6;
        this.f6959o = f7;
    }

    int m10053a() {
        return this.f6945a;
    }

    public MarkerOptions alpha(float f) {
        this.f6958n = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f6950f = f;
        this.f6951g = f2;
        return this;
    }

    IBinder m10054b() {
        return this.f6949e == null ? null : this.f6949e.zzIy().asBinder();
    }

    public MarkerOptions draggable(boolean z) {
        this.f6952h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f6954j = z;
        return this;
    }

    public float getAlpha() {
        return this.f6958n;
    }

    public float getAnchorU() {
        return this.f6950f;
    }

    public float getAnchorV() {
        return this.f6951g;
    }

    public BitmapDescriptor getIcon() {
        return this.f6949e;
    }

    public float getInfoWindowAnchorU() {
        return this.f6956l;
    }

    public float getInfoWindowAnchorV() {
        return this.f6957m;
    }

    public LatLng getPosition() {
        return this.f6946b;
    }

    public float getRotation() {
        return this.f6955k;
    }

    public String getSnippet() {
        return this.f6948d;
    }

    public String getTitle() {
        return this.f6947c;
    }

    public float getZIndex() {
        return this.f6959o;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f6949e = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.f6956l = f;
        this.f6957m = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.f6952h;
    }

    public boolean isFlat() {
        return this.f6954j;
    }

    public boolean isVisible() {
        return this.f6953i;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.f6946b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f6955k = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f6948d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f6947c = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f6953i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m10076a(this, parcel, i);
    }

    public MarkerOptions zIndex(float f) {
        this.f6959o = f;
        return this;
    }
}
