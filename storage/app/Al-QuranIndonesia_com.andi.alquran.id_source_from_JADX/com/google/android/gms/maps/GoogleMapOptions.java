package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends zza implements ReflectedParcelable {
    public static final Creator<GoogleMapOptions> CREATOR;
    private final int f6771a;
    private Boolean f6772b;
    private Boolean f6773c;
    private int f6774d;
    private CameraPosition f6775e;
    private Boolean f6776f;
    private Boolean f6777g;
    private Boolean f6778h;
    private Boolean f6779i;
    private Boolean f6780j;
    private Boolean f6781k;
    private Boolean f6782l;
    private Boolean f6783m;
    private Boolean f6784n;
    private Float f6785o;
    private Float f6786p;
    private LatLngBounds f6787q;

    static {
        CREATOR = new zza();
    }

    public GoogleMapOptions() {
        this.f6774d = -1;
        this.f6785o = null;
        this.f6786p = null;
        this.f6787q = null;
        this.f6771a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds) {
        this.f6774d = -1;
        this.f6785o = null;
        this.f6786p = null;
        this.f6787q = null;
        this.f6771a = i;
        this.f6772b = com.google.android.gms.maps.internal.zza.zza(b);
        this.f6773c = com.google.android.gms.maps.internal.zza.zza(b2);
        this.f6774d = i2;
        this.f6775e = cameraPosition;
        this.f6776f = com.google.android.gms.maps.internal.zza.zza(b3);
        this.f6777g = com.google.android.gms.maps.internal.zza.zza(b4);
        this.f6778h = com.google.android.gms.maps.internal.zza.zza(b5);
        this.f6779i = com.google.android.gms.maps.internal.zza.zza(b6);
        this.f6780j = com.google.android.gms.maps.internal.zza.zza(b7);
        this.f6781k = com.google.android.gms.maps.internal.zza.zza(b8);
        this.f6782l = com.google.android.gms.maps.internal.zza.zza(b9);
        this.f6783m = com.google.android.gms.maps.internal.zza.zza(b10);
        this.f6784n = com.google.android.gms.maps.internal.zza.zza(b11);
        this.f6785o = f;
        this.f6786p = f2;
        this.f6787q = latLngBounds;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1096c.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C1096c.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C1096c.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C1096c.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C1096c.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C1096c.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(C1096c.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(C1096c.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(C1096c.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(LatLngBounds.createFromAttributes(context, attributeSet));
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    int m9909a() {
        return this.f6771a;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.f6784n = Boolean.valueOf(z);
        return this;
    }

    byte m9910b() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6772b);
    }

    byte m9911c() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6773c);
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.f6775e = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.f6777g = Boolean.valueOf(z);
        return this;
    }

    byte m9912d() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6776f);
    }

    byte m9913e() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6777g);
    }

    byte m9914f() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6778h);
    }

    byte m9915g() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6779i);
    }

    public Boolean getAmbientEnabled() {
        return this.f6784n;
    }

    public CameraPosition getCamera() {
        return this.f6775e;
    }

    public Boolean getCompassEnabled() {
        return this.f6777g;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.f6787q;
    }

    public Boolean getLiteMode() {
        return this.f6782l;
    }

    public Boolean getMapToolbarEnabled() {
        return this.f6783m;
    }

    public int getMapType() {
        return this.f6774d;
    }

    public Float getMaxZoomPreference() {
        return this.f6786p;
    }

    public Float getMinZoomPreference() {
        return this.f6785o;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f6781k;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f6778h;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f6780j;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f6773c;
    }

    public Boolean getZOrderOnTop() {
        return this.f6772b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f6776f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f6779i;
    }

    byte m9916h() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6780j);
    }

    byte m9917i() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6781k);
    }

    byte m9918j() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6782l);
    }

    byte m9919k() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6783m);
    }

    byte m9920l() {
        return com.google.android.gms.maps.internal.zza.zze(this.f6784n);
    }

    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.f6787q = latLngBounds;
        return this;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.f6782l = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.f6783m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.f6774d = i;
        return this;
    }

    public GoogleMapOptions maxZoomPreference(float f) {
        this.f6786p = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions minZoomPreference(float f) {
        this.f6785o = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.f6781k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.f6778h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.f6780j = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.f6773c = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m10087a(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.f6772b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.f6776f = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.f6779i = Boolean.valueOf(z);
        return this;
    }
}
