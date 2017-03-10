package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dg extends er {
    public dg(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5727a() {
        synchronized (this.e) {
            this.e.f3407c = Long.valueOf(-1);
            this.e.f3407c = (Long) this.f.invoke(null, new Object[]{this.b.m5696a()});
        }
    }
}
