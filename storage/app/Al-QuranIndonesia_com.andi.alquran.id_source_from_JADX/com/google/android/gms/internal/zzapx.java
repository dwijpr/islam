package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.au.C1444a;

public final class zzapx extends zza {
    public static final Creator<zzapx> CREATOR;
    public final int f6364a;
    private C1444a f6365b;
    private byte[] f6366c;

    static {
        CREATOR = new bi();
    }

    zzapx(int i, byte[] bArr) {
        this.f6364a = i;
        this.f6365b = null;
        this.f6366c = bArr;
        m9721e();
    }

    private boolean m9719c() {
        return this.f6365b != null;
    }

    private void m9720d() {
        if (!m9719c()) {
            try {
                this.f6365b = C1444a.m5190a(this.f6366c);
                this.f6366c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        m9721e();
    }

    private void m9721e() {
        if (this.f6365b == null && this.f6366c != null) {
            return;
        }
        if (this.f6365b != null && this.f6366c == null) {
            return;
        }
        if (this.f6365b != null && this.f6366c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f6365b == null && this.f6366c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public byte[] m9722a() {
        return this.f6366c != null ? this.f6366c : eg.m5148a(this.f6365b);
    }

    public C1444a m9723b() {
        m9720d();
        return this.f6365b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bi.m5283a(this, parcel, i);
    }
}
