package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class dl extends er {
    public dl(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5757a() {
        this.e.f3409e = Long.valueOf(-1);
        this.e.f3410f = Long.valueOf(-1);
        int[] iArr = (int[]) this.f.invoke(null, new Object[]{this.b.m5696a()});
        synchronized (this.e) {
            this.e.f3409e = Long.valueOf((long) iArr[0]);
            this.e.f3410f = Long.valueOf((long) iArr[1]);
        }
    }
}
