package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.GoogleMap;
import java.util.Locale;

public class zzarz extends zza {
    public static final Creator<zzarz> CREATOR;
    private final int f6388a;
    private final String f6389b;
    private final long f6390c;
    private final short f6391d;
    private final double f6392e;
    private final double f6393f;
    private final float f6394g;
    private final int f6395h;
    private final int f6396i;
    private final int f6397j;

    static {
        CREATOR = new ca();
    }

    public zzarz(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m9740a(str);
        m9739a(f);
        m9738a(d, d2);
        int a = m9737a(i2);
        this.f6388a = i;
        this.f6391d = s;
        this.f6389b = str;
        this.f6392e = d;
        this.f6393f = d2;
        this.f6394g = f;
        this.f6390c = j;
        this.f6395h = a;
        this.f6396i = i3;
        this.f6397j = i4;
    }

    private static int m9737a(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static void m9738a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void m9739a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void m9740a(String str) {
        if (str == null || str.length() > 100) {
            String str2 = "requestId is null or too long: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String m9741b(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public int m9742a() {
        return this.f6388a;
    }

    public short m9743b() {
        return this.f6391d;
    }

    public double m9744c() {
        return this.f6392e;
    }

    public double m9745d() {
        return this.f6393f;
    }

    public float m9746e() {
        return this.f6394g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzarz)) {
            return false;
        }
        zzarz com_google_android_gms_internal_zzarz = (zzarz) obj;
        return this.f6394g != com_google_android_gms_internal_zzarz.f6394g ? false : this.f6392e != com_google_android_gms_internal_zzarz.f6392e ? false : this.f6393f != com_google_android_gms_internal_zzarz.f6393f ? false : this.f6391d == com_google_android_gms_internal_zzarz.f6391d;
    }

    public String m9747f() {
        return this.f6389b;
    }

    public long m9748g() {
        return this.f6390c;
    }

    public int m9749h() {
        return this.f6395h;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f6392e);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f6393f);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f6394g)) * 31) + this.f6391d) * 31) + this.f6395h;
    }

    public int m9750i() {
        return this.f6396i;
    }

    public int m9751j() {
        return this.f6397j;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m9741b(this.f6391d), this.f6389b, Integer.valueOf(this.f6395h), Double.valueOf(this.f6392e), Double.valueOf(this.f6393f), Float.valueOf(this.f6394g), Integer.valueOf(this.f6396i / 1000), Integer.valueOf(this.f6397j), Long.valueOf(this.f6390c)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        ca.m5520a(this, parcel, i);
    }
}
