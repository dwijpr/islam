package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends zza {
    public static final Creator<PolylineOptions> CREATOR;
    private final int f6973a;
    private final List<LatLng> f6974b;
    private float f6975c;
    private int f6976d;
    private float f6977e;
    private boolean f6978f;
    private boolean f6979g;
    private boolean f6980h;

    static {
        CREATOR = new zzj();
    }

    public PolylineOptions() {
        this.f6975c = 10.0f;
        this.f6976d = -16777216;
        this.f6977e = 0.0f;
        this.f6978f = true;
        this.f6979g = false;
        this.f6980h = false;
        this.f6973a = 1;
        this.f6974b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2, boolean z3) {
        this.f6975c = 10.0f;
        this.f6976d = -16777216;
        this.f6977e = 0.0f;
        this.f6978f = true;
        this.f6979g = false;
        this.f6980h = false;
        this.f6973a = i;
        this.f6974b = list;
        this.f6975c = f;
        this.f6976d = i2;
        this.f6977e = f2;
        this.f6978f = z;
        this.f6979g = z2;
        this.f6980h = z3;
    }

    int m10058a() {
        return this.f6973a;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f6974b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f6974b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f6974b.add(add);
        }
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.f6980h = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f6976d = i;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f6979g = z;
        return this;
    }

    public int getColor() {
        return this.f6976d;
    }

    public List<LatLng> getPoints() {
        return this.f6974b;
    }

    public float getWidth() {
        return this.f6975c;
    }

    public float getZIndex() {
        return this.f6977e;
    }

    public boolean isClickable() {
        return this.f6980h;
    }

    public boolean isGeodesic() {
        return this.f6979g;
    }

    public boolean isVisible() {
        return this.f6978f;
    }

    public PolylineOptions visible(boolean z) {
        this.f6978f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.f6975c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m10079a(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.f6977e = f;
        return this;
    }
}
