package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class LocationSettingsResult extends zza implements C1263g {
    public static final Creator<LocationSettingsResult> CREATOR;
    private final int f6692a;
    private final Status f6693b;
    private final LocationSettingsStates f6694c;

    static {
        CREATOR = new C2103u();
    }

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.f6692a = i;
        this.f6693b = status;
        this.f6694c = locationSettingsStates;
    }

    public int m9817a() {
        return this.f6692a;
    }

    public Status m9818b() {
        return this.f6693b;
    }

    public LocationSettingsStates m9819c() {
        return this.f6694c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2103u.m9871a(this, parcel, i);
    }
}
