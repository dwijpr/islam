package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class di extends er {
    private static volatile String f3787i;
    private static final Object f3788j;

    static {
        f3787i = null;
        f3788j = new Object();
    }

    public di(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5738a() {
        this.e.f3428x = "E";
        if (f3787i == null) {
            synchronized (f3788j) {
                if (f3787i == null) {
                    f3787i = (String) this.f.invoke(null, new Object[]{this.b.m5696a()});
                }
            }
        }
        synchronized (this.e) {
            this.e.f3428x = ay.m5225a(f3787i.getBytes(), true);
        }
    }
}
