package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dq extends er {
    private static volatile Long f3807i;
    private static final Object f3808j;

    static {
        f3807i = null;
        f3808j = new Object();
    }

    public dq(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5764a() {
        if (f3807i == null) {
            synchronized (f3808j) {
                if (f3807i == null) {
                    f3807i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f3425u = f3807i;
        }
    }
}
