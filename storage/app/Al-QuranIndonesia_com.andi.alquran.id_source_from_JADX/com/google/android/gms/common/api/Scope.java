package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Scope extends zza implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR;
    final int f2973a;
    private final String f2974b;

    static {
        CREATOR = new C1290p();
    }

    Scope(int i, String str) {
        C1314c.m4626a(str, (Object) "scopeUri must not be null or empty");
        this.f2973a = i;
        this.f2974b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m4500a() {
        return this.f2974b;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f2974b.equals(((Scope) obj).f2974b);
    }

    public int hashCode() {
        return this.f2974b.hashCode();
    }

    public String toString() {
        return this.f2974b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1290p.m4572a(this, parcel, i);
    }
}
