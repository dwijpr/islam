package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends zza implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR;
    static final List<Location> f6684a;
    private final int f6685b;
    private final List<Location> f6686c;

    static {
        f6684a = Collections.emptyList();
        CREATOR = new C2100r();
    }

    LocationResult(int i, List<Location> list) {
        this.f6685b = i;
        this.f6686c = list;
    }

    public List<Location> m9810a() {
        return this.f6686c;
    }

    int m9811b() {
        return this.f6685b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f6686c.size() != this.f6686c.size()) {
            return false;
        }
        Iterator it = this.f6686c.iterator();
        for (Location time : locationResult.f6686c) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 17;
        for (Location time : this.f6686c) {
            long time2 = time.getTime();
            i = ((int) (time2 ^ (time2 >>> 32))) + (i * 31);
        }
        return i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f6686c);
        return new StringBuilder(String.valueOf(valueOf).length() + 27).append("LocationResult[locations: ").append(valueOf).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2100r.m9862a(this, parcel, i);
    }
}
