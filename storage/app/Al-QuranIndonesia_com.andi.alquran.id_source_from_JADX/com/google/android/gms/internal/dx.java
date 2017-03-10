package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dx extends er {
    private static volatile Long f3817i;
    private static final Object f3818j;

    static {
        f3817i = null;
        f3818j = new Object();
    }

    public dx(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5771a() {
        if (f3817i == null) {
            synchronized (f3818j) {
                if (f3817i == null) {
                    f3817i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f3379A = f3817i;
        }
    }
}
