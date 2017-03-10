package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends zza {
    public static final Creator<PolygonOptions> CREATOR;
    private final int f6962a;
    private final List<LatLng> f6963b;
    private final List<List<LatLng>> f6964c;
    private float f6965d;
    private int f6966e;
    private int f6967f;
    private float f6968g;
    private boolean f6969h;
    private boolean f6970i;
    private boolean f6971j;

    static {
        CREATOR = new zzi();
    }

    public PolygonOptions() {
        this.f6965d = 10.0f;
        this.f6966e = -16777216;
        this.f6967f = 0;
        this.f6968g = 0.0f;
        this.f6969h = true;
        this.f6970i = false;
        this.f6971j = false;
        this.f6962a = 1;
        this.f6963b = new ArrayList();
        this.f6964c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2, boolean z3) {
        this.f6965d = 10.0f;
        this.f6966e = -16777216;
        this.f6967f = 0;
        this.f6968g = 0.0f;
        this.f6969h = true;
        this.f6970i = false;
        this.f6971j = false;
        this.f6962a = i;
        this.f6963b = list;
        this.f6964c = list2;
        this.f6965d = f;
        this.f6966e = i2;
        this.f6967f = i3;
        this.f6968g = f2;
        this.f6969h = z;
        this.f6970i = z2;
        this.f6971j = z3;
    }

    int m10056a() {
        return this.f6962a;
    }

    public PolygonOptions add(LatLng latLng) {
        this.f6963b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f6963b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f6963b.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f6964c.add(arrayList);
        return this;
    }

    List m10057b() {
        return this.f6964c;
    }

    public PolygonOptions clickable(boolean z) {
        this.f6971j = z;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f6967f = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f6970i = z;
        return this;
    }

    public int getFillColor() {
        return this.f6967f;
    }

    public List<List<LatLng>> getHoles() {
        return this.f6964c;
    }

    public List<LatLng> getPoints() {
        return this.f6963b;
    }

    public int getStrokeColor() {
        return this.f6966e;
    }

    public float getStrokeWidth() {
        return this.f6965d;
    }

    public float getZIndex() {
        return this.f6968g;
    }

    public boolean isClickable() {
        return this.f6971j;
    }

    public boolean isGeodesic() {
        return this.f6970i;
    }

    public boolean isVisible() {
        return this.f6969h;
    }

    public PolygonOptions strokeColor(int i) {
        this.f6966e = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f6965d = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f6969h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m10078a(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.f6968g = f;
        return this;
    }
}
