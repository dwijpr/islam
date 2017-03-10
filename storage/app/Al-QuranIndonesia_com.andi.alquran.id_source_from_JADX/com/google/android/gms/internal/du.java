package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;

public class du extends er {
    private final StackTraceElement[] f3813i;

    public du(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3813i = stackTraceElementArr;
    }

    protected void m5768a() {
        if (this.f3813i != null) {
            da daVar = new da((String) this.f.invoke(null, new Object[]{this.f3813i}));
            synchronized (this.e) {
                this.e.f3390L = daVar.f3728a;
                if (daVar.f3729b.booleanValue()) {
                    this.e.f3400V = Integer.valueOf(daVar.f3730c.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
