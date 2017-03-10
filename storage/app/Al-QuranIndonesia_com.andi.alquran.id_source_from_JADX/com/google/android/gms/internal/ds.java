package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class ds extends er {
    private static volatile String f3810i;
    private static final Object f3811j;

    static {
        f3810i = null;
        f3811j = new Object();
    }

    public ds(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5766a() {
        this.e.f3405a = "E";
        if (f3810i == null) {
            synchronized (f3811j) {
                if (f3810i == null) {
                    f3810i = (String) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f3405a = f3810i;
        }
    }
}
