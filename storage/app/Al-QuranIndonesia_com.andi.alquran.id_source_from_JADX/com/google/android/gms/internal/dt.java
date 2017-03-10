package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;
import java.util.List;

public class dt extends er {
    private List<Long> f3812i;

    public dt(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3812i = null;
    }

    protected void m5767a() {
        this.e.f3429y = Long.valueOf(-1);
        this.e.f3430z = Long.valueOf(-1);
        if (this.f3812i == null) {
            this.f3812i = (List) this.f.invoke(null, new Object[]{this.b.m5696a()});
        }
        if (this.f3812i != null && this.f3812i.size() == 2) {
            synchronized (this.e) {
                this.e.f3429y = Long.valueOf(((Long) this.f3812i.get(0)).longValue());
                this.e.f3430z = Long.valueOf(((Long) this.f3812i.get(1)).longValue());
            }
        }
    }
}
