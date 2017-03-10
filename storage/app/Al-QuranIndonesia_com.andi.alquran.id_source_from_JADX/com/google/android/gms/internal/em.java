package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class em extends er {
    public em(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    protected void m5969a() {
        this.e.f3393O = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.f.invoke(null, new Object[]{this.b.m5699b()})).booleanValue();
        synchronized (this.e) {
            if (booleanValue) {
                this.e.f3393O = Integer.valueOf(1);
            } else {
                this.e.f3393O = Integer.valueOf(0);
            }
        }
    }
}
