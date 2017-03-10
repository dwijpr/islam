package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzv;

@op
public class rj {
    private final Object f5698a;
    private int f5699b;
    private int f5700c;
    private final rf f5701d;
    private final String f5702e;

    rj(rf rfVar, String str) {
        this.f5698a = new Object();
        this.f5701d = rfVar;
        this.f5702e = str;
    }

    public rj(String str) {
        this(zzv.zzcN(), str);
    }

    public Bundle m8437a() {
        Bundle bundle;
        synchronized (this.f5698a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f5699b);
            bundle.putInt("pmnll", this.f5700c);
        }
        return bundle;
    }

    public void m8438a(int i, int i2) {
        synchronized (this.f5698a) {
            this.f5699b = i;
            this.f5700c = i2;
            this.f5701d.m8398a(this.f5702e, this);
        }
    }
}
