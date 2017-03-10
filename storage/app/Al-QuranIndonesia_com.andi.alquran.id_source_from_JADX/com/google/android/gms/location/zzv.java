package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

public class zzv extends zza {
    public static final Creator<zzv> CREATOR;
    private final int f6737a;
    private final List<String> f6738b;
    private final PendingIntent f6739c;
    private final String f6740d;

    static {
        CREATOR = new C2105w();
    }

    zzv(int i, List<String> list, PendingIntent pendingIntent, String str) {
        this.f6737a = i;
        this.f6738b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f6739c = pendingIntent;
        this.f6740d = str;
    }

    public int m9904a() {
        return this.f6737a;
    }

    public List<String> m9905b() {
        return this.f6738b;
    }

    public PendingIntent m9906c() {
        return this.f6739c;
    }

    public String m9907d() {
        return this.f6740d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2105w.m9877a(this, parcel, i);
    }
}
