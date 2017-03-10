package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dr extends er {
    private long f3809i;

    public dr(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3809i = -1;
    }

    protected void m5765a() {
        this.e.f3416l = Long.valueOf(-1);
        if (this.f3809i == -1) {
            this.f3809i = (long) ((Integer) this.f.invoke(null, new Object[]{this.b.m5696a()})).intValue();
        }
        synchronized (this.e) {
            this.e.f3416l = Long.valueOf(this.f3809i);
        }
    }
}
