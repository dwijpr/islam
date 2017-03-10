package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.internal.au.C1444a.C1443b;

public class ep extends er {
    private final View f3904i;

    public ep(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2, View view) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3904i = view;
    }

    protected void m5970a() {
        if (this.f3904i != null) {
            df dfVar = new df((String) this.f.invoke(null, new Object[]{this.f3904i}));
            synchronized (this.e) {
                this.e.f3403Y = new C1443b();
                this.e.f3403Y.f3378c = dfVar.f3770a;
            }
        }
    }
}
