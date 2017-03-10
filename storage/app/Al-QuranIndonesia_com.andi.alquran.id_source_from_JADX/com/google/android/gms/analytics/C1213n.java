package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.analytics.n */
public abstract class C1213n<T extends C1213n> {
    protected final C1229l f2827a;
    private final C1236o f2828b;
    private final List<Object> f2829c;

    protected C1213n(C1236o c1236o, C1377c c1377c) {
        C1314c.m4623a((Object) c1236o);
        this.f2828b = c1236o;
        this.f2829c = new ArrayList();
        C1229l c1229l = new C1229l(this, c1377c);
        c1229l.m4357k();
        this.f2827a = c1229l;
    }

    protected void m4199a(C1229l c1229l) {
    }

    protected void m4200b(C1229l c1229l) {
        Iterator it = this.f2829c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public C1229l m4201k() {
        C1229l a = this.f2827a.m4343a();
        m4200b(a);
        return a;
    }

    public C1229l m4202l() {
        return this.f2827a;
    }

    public List<C1224p> m4203m() {
        return this.f2827a.m4349c();
    }

    protected C1236o m4204n() {
        return this.f2828b;
    }
}
