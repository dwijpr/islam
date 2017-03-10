package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzarm extends zza implements C1263g {
    public static final Creator<zzarm> CREATOR;
    public static final zzarm f6370a;
    private final int f6371b;
    private final Status f6372c;

    static {
        f6370a = new zzarm(Status.f2975a);
        CREATOR = new bp();
    }

    zzarm(int i, Status status) {
        this.f6371b = i;
        this.f6372c = status;
    }

    public zzarm(Status status) {
        this(1, status);
    }

    public int m9725a() {
        return this.f6371b;
    }

    public Status m9726b() {
        return this.f6372c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bp.m5336a(this, parcel, i);
    }
}
