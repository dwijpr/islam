package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dn extends er {
    private long f3804i;

    public dn(dc dcVar, String str, String str2, C1444a c1444a, long j, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3804i = j;
    }

    protected void m5759a() {
        long longValue = ((Long) this.f.invoke(null, new Object[0])).longValue();
        synchronized (this.e) {
            this.e.ae = Long.valueOf(longValue);
            if (this.f3804i != 0) {
                this.e.f3421q = Long.valueOf(longValue - this.f3804i);
                this.e.f3426v = Long.valueOf(this.f3804i);
            }
        }
    }
}
