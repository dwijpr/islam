package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dm extends er {
    private static volatile Long f3802i;
    private static final Object f3803j;

    static {
        f3802i = null;
        f3803j = new Object();
    }

    public dm(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5758a() {
        if (f3802i == null) {
            synchronized (f3803j) {
                if (f3802i == null) {
                    f3802i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f3389K = f3802i;
        }
    }
}
