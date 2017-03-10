package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;

@op
public class sb {
    private long f5819a;
    private long f5820b;
    private Object f5821c;

    public sb(long j) {
        this.f5820b = Long.MIN_VALUE;
        this.f5821c = new Object();
        this.f5819a = j;
    }

    public boolean m8677a() {
        boolean z;
        synchronized (this.f5821c) {
            long b = zzv.zzcP().m4927b();
            if (this.f5820b + this.f5819a > b) {
                z = false;
            } else {
                this.f5820b = b;
                z = true;
            }
        }
        return z;
    }
}
