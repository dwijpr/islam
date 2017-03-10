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

public final class LatLngBounds extends zza implements ReflectedParcelable {
    public static final Creator<LatLngBounds> CREATOR;
    private final int f6940a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double f6936a;
        private double f6937b;
        private double f6938c;
        private double f6939d;

        public Builder() {
            this.f6936a = Double.POSITIVE_INFINITY;
            this.f6937b = Double.NEGATIVE_INFINITY;
            this.f6938c = Double.NaN;
            this.f6939d = Double.NaN;
        }

        private boolean m10044a(double d) {
            boolean z = false;
            if (this.f6938c <= this.f6939d) {
                return this.f6938c <= d && d <= this.f6939d;
            } else {
                if (this.f6938c <= d || d <= this.f6939d) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            C1314c.m4629a(!Double.isNaN(this.f6938c), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f6936a, this.f6938c), new LatLng(this.f6937b, this.f6939d));
        }

        public Builder include(LatLng latLng) {
            this.f6936a = Math.min(this.f6936a, latLng.latitude);
            this.f6937b = Math.max(this.f6937b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f6938c)) {
                this.f6938c = d;
                this.f6939d = d;
            } else if (!m10044a(d)) {
                if (LatLngBounds.m10049c(this.f6938c, d) < LatLngBounds.m10050d(this.f6939d, d)) {
                    this.f6938c = d;
                } else {
                    this.f6939d = d;
                }
            }
            return this;
        }
    }

    static {
        CREATOR = new zzd();
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        C1314c.m4624a((Object) latLng, (Object) "null southwest");
        C1314c.m4624a((Object) latLng2, (Object) "null northeast");
        C1314c.m4634b(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.f6940a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean m10046a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean m10048b(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double m10049c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1096c.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(C1096c.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(C1096c.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(C1096c.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(C1096c.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(C1096c.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(C1096c.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(C1096c.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(C1096c.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        return (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) ? null : new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    private static double m10050d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    int m10051a() {
        return this.f6940a;
    }

    public boolean contains(LatLng latLng) {
        return m10046a(latLng.latitude) && m10048b(latLng.longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    public int hashCode() {
        return C1313b.m4619a(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (m10048b(d3)) {
            d3 = d2;
            d2 = d;
        } else if (m10049c(d2, d3) < m10050d(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("southwest", this.southwest).m4618a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m10073a(this, parcel, i);
    }
}
