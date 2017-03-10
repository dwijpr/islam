package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@op
class so {
    private final Object f5848a;
    private final List<Runnable> f5849b;
    private final List<Runnable> f5850c;
    private boolean f5851d;

    public so() {
        this.f5848a = new Object();
        this.f5849b = new ArrayList();
        this.f5850c = new ArrayList();
        this.f5851d = false;
    }

    private void m8718c(Runnable runnable) {
        rp.m8472a(runnable);
    }

    private void m8719d(Runnable runnable) {
        sf.f5831a.post(runnable);
    }

    public void m8720a() {
        synchronized (this.f5848a) {
            if (this.f5851d) {
                return;
            }
            for (Runnable c : this.f5849b) {
                m8718c(c);
            }
            for (Runnable c2 : this.f5850c) {
                m8719d(c2);
            }
            this.f5849b.clear();
            this.f5850c.clear();
            this.f5851d = true;
        }
    }

    public void m8721a(Runnable runnable) {
        synchronized (this.f5848a) {
            if (this.f5851d) {
                m8718c(runnable);
            } else {
                this.f5849b.add(runnable);
            }
        }
    }

    public void m8722b(Runnable runnable) {
        synchronized (this.f5848a) {
            if (this.f5851d) {
                m8719d(runnable);
            } else {
                this.f5850c.add(runnable);
            }
        }
    }
}
