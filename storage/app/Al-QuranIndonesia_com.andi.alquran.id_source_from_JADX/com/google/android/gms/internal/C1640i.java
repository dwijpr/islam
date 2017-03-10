package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1320f;
import com.google.android.gms.internal.C1829n.C1636a;
import com.google.android.gms.internal.wm.C1475a;

/* renamed from: com.google.android.gms.internal.i */
public class C1640i implements C1639m {
    private final C1829n f4322a;
    private boolean f4323b;

    /* renamed from: com.google.android.gms.internal.i.1 */
    class C16371 extends C1636a {
        final /* synthetic */ C1640i f4320a;

        C16371(C1640i c1640i, C1639m c1639m) {
            this.f4320a = c1640i;
            super(c1639m);
        }

        public void m6653a() {
            this.f4320a.m6666a(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.2 */
    class C16382 extends C1636a {
        final /* synthetic */ C1640i f4321a;

        C16382(C1640i c1640i, C1639m c1639m) {
            this.f4321a = c1640i;
            super(c1639m);
        }

        public void m6654a() {
            this.f4321a.f4322a.f5076h.m5476a(null);
        }
    }

    public C1640i(C1829n c1829n) {
        this.f4323b = false;
        this.f4322a = c1829n;
    }

    private <A extends C1267c> void m6663b(C1475a<? extends C1263g, A> c1475a) {
        this.f4322a.f5075g.f4692i.m5111a((wo) c1475a);
        C1267c b = this.f4322a.f5075g.m7183b(c1475a.m5321b());
        if (b.m4515b() || !this.f4322a.f5070b.containsKey(c1475a.m5321b())) {
            if (b instanceof C1320f) {
                b = ((C1320f) b).m4697k();
            }
            c1475a.m5322b(b);
            return;
        }
        c1475a.m5324c(new Status(17));
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m6664a(T t) {
        try {
            m6663b(t);
        } catch (DeadObjectException e) {
            this.f4322a.m7747a(new C16371(this, this));
        }
        return t;
    }

    public void m6665a() {
    }

    public void m6666a(int i) {
        this.f4322a.m7745a(null);
        this.f4322a.f5076h.m5475a(i, this.f4323b);
    }

    public void m6667a(Bundle bundle) {
    }

    public void m6668a(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
    }

    public boolean m6669b() {
        if (this.f4323b) {
            return false;
        }
        if (this.f4322a.f5075g.m7192i()) {
            this.f4323b = true;
            for (aj a : this.f4322a.f5075g.f4691h) {
                a.m5101a();
            }
            return false;
        }
        this.f4322a.m7745a(null);
        return true;
    }

    public void m6670c() {
        if (this.f4323b) {
            this.f4323b = false;
            this.f4322a.m7747a(new C16382(this, this));
        }
    }

    void m6671d() {
        if (this.f4323b) {
            this.f4323b = false;
            this.f4322a.f5075g.f4692i.m5110a();
            m6669b();
        }
    }
}
