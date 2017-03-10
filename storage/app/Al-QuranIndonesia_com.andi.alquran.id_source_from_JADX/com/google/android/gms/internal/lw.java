package com.google.android.gms.internal;

import com.google.android.gms.internal.ly.C1792a;
import com.google.android.gms.internal.mf.C1788a;

@op
public final class lw extends C1788a {
    private final Object f4869a;
    private C1792a f4870b;
    private lv f4871c;

    public lw() {
        this.f4869a = new Object();
    }

    public void m7393a() {
        synchronized (this.f4869a) {
            if (this.f4871c != null) {
                this.f4871c.zzbP();
            }
        }
    }

    public void m7394a(int i) {
        synchronized (this.f4869a) {
            if (this.f4870b != null) {
                this.f4870b.m7406a(i == 3 ? 1 : 2);
                this.f4870b = null;
            }
        }
    }

    public void m7395a(lv lvVar) {
        synchronized (this.f4869a) {
            this.f4871c = lvVar;
        }
    }

    public void m7396a(C1792a c1792a) {
        synchronized (this.f4869a) {
            this.f4870b = c1792a;
        }
    }

    public void m7397a(mg mgVar) {
        synchronized (this.f4869a) {
            if (this.f4870b != null) {
                this.f4870b.m7407a(0, mgVar);
                this.f4870b = null;
                return;
            }
            if (this.f4871c != null) {
                this.f4871c.zzbT();
            }
        }
    }

    public void m7398b() {
        synchronized (this.f4869a) {
            if (this.f4871c != null) {
                this.f4871c.zzbQ();
            }
        }
    }

    public void m7399c() {
        synchronized (this.f4869a) {
            if (this.f4871c != null) {
                this.f4871c.zzbR();
            }
        }
    }

    public void m7400d() {
        synchronized (this.f4869a) {
            if (this.f4871c != null) {
                this.f4871c.zzbS();
            }
        }
    }

    public void m7401e() {
        synchronized (this.f4869a) {
            if (this.f4870b != null) {
                this.f4870b.m7406a(0);
                this.f4870b = null;
                return;
            }
            if (this.f4871c != null) {
                this.f4871c.zzbT();
            }
        }
    }

    public void m7402f() {
        synchronized (this.f4869a) {
            if (this.f4871c != null) {
                this.f4871c.zzbU();
            }
        }
    }
}
