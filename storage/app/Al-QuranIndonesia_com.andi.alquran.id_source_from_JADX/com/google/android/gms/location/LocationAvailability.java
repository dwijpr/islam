package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class LocationAvailability extends zza implements ReflectedParcelable {
    public static final Creator<LocationAvailability> CREATOR;
    int f6670a;
    int f6671b;
    long f6672c;
    int f6673d;
    private final int f6674e;

    static {
        CREATOR = new C2098p();
    }

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.f6674e = i;
        this.f6673d = i2;
        this.f6670a = i3;
        this.f6671b = i4;
        this.f6672c = j;
    }

    public boolean m9801a() {
        return this.f6673d < 1000;
    }

    int m9802b() {
        return this.f6674e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.f6673d == locationAvailability.f6673d && this.f6670a == locationAvailability.f6670a && this.f6671b == locationAvailability.f6671b && this.f6672c == locationAvailability.f6672c;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6673d), Integer.valueOf(this.f6670a), Integer.valueOf(this.f6671b), Long.valueOf(this.f6672c));
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + m9801a() + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2098p.m9856a(this, parcel, i);
    }
}
