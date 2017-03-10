package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C1385k;
import java.io.IOException;

public final class MapStyleOptions extends zza {
    public static final Creator<MapStyleOptions> CREATOR;
    private static final String f6941a;
    private final int f6942b;
    private String f6943c;

    static {
        f6941a = MapStyleOptions.class.getSimpleName();
        CREATOR = new zzf();
    }

    MapStyleOptions(int i, String str) {
        this.f6942b = i;
        this.f6943c = str;
    }

    public MapStyleOptions(String str) {
        this.f6942b = 1;
        this.f6943c = str;
    }

    public static MapStyleOptions loadRawResourceStyle(Context context, int i) {
        try {
            return new MapStyleOptions(new String(C1385k.m4956a(context.getResources().openRawResource(i)), "UTF-8"));
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            throw new NotFoundException(new StringBuilder(String.valueOf(valueOf).length() + 37).append("Failed to read resource ").append(i).append(": ").append(valueOf).toString());
        }
    }

    int m10052a() {
        return this.f6942b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m10075a(this, parcel, i);
    }

    public String zzIU() {
        return this.f6943c;
    }
}
