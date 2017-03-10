package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class CameraPosition extends zza implements ReflectedParcelable {
    public static final Creator<CameraPosition> CREATOR;
    private final int f6908a;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng f6904a;
        private float f6905b;
        private float f6906c;
        private float f6907d;

        public Builder(CameraPosition cameraPosition) {
            this.f6904a = cameraPosition.target;
            this.f6905b = cameraPosition.zoom;
            this.f6906c = cameraPosition.tilt;
            this.f6907d = cameraPosition.bearing;
        }

        public Builder bearing(float f) {
            this.f6907d = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f6904a, this.f6905b, this.f6906c, this.f6907d);
        }

        public Builder target(LatLng latLng) {
            this.f6904a = latLng;
            return this;
        }

        public Builder tilt(float f) {
            this.f6906c = f;
            return this;
        }

        public Builder zoom(float f) {
            this.f6905b = f;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        C1314c.m4624a((Object) latLng, (Object) "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        C1314c.m4634b(z, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.f6908a = i;
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.bearing = f3 % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1096c.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C1096c.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C1096c.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C1096c.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C1096c.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C1096c.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C1096c.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C1096c.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(C1096c.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C1096c.MapAttrs_cameraTilt, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    int m10038a() {
        return this.f6908a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public int hashCode() {
        return C1313b.m4619a(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("target", this.target).m4618a("zoom", Float.valueOf(this.zoom)).m4618a("tilt", Float.valueOf(this.tilt)).m4618a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m10070a(this, parcel, i);
    }
}
