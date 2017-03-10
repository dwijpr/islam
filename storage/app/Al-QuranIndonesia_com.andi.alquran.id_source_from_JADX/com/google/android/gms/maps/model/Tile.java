package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Tile extends zza {
    public static final Creator<Tile> CREATOR;
    private final int f6986a;
    public final byte[] data;
    public final int height;
    public final int width;

    static {
        CREATOR = new zzo();
    }

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f6986a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    int m10063a() {
        return this.f6986a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m10084a(this, parcel, i);
    }
}
