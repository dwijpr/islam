package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dv extends er {
    public dv(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5769a() {
        synchronized (this.e) {
            db dbVar = new db((String) this.f.invoke(null, new Object[0]));
            this.e.f3395Q = dbVar.f3731a;
            this.e.f3396R = dbVar.f3732b;
        }
    }
}
