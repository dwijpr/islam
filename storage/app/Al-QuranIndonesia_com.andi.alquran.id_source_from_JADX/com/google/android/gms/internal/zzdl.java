package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.InputStream;

@op
public class zzdl extends zza {
    public static final Creator<zzdl> CREATOR;
    public final int f6423a;
    private ParcelFileDescriptor f6424b;

    static {
        CREATOR = new fy();
    }

    public zzdl() {
        this(1, null);
    }

    zzdl(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f6423a = i;
        this.f6424b = parcelFileDescriptor;
    }

    public synchronized boolean m9761a() {
        return this.f6424b != null;
    }

    public synchronized InputStream m9762b() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.f6424b != null) {
                inputStream = new AutoCloseInputStream(this.f6424b);
                this.f6424b = null;
            }
        }
        return inputStream;
    }

    synchronized ParcelFileDescriptor m9763c() {
        return this.f6424b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        fy.m6269a(this, parcel, i);
    }
}
