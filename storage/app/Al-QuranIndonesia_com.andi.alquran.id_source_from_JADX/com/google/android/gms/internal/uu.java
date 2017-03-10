package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.C1314c;

abstract class uu {
    private static volatile Handler f6069b;
    private final uf f6070a;
    private final Runnable f6071c;
    private volatile long f6072d;

    /* renamed from: com.google.android.gms.internal.uu.1 */
    class C20361 implements Runnable {
        final /* synthetic */ uu f6135a;

        C20361(uu uuVar) {
            this.f6135a = uuVar;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f6135a.f6070a.m9160h().m4371a((Runnable) this);
                return;
            }
            boolean c = this.f6135a.m9206c();
            this.f6135a.f6072d = 0;
            if (c) {
                this.f6135a.m9202a();
            }
        }
    }

    uu(uf ufVar) {
        C1314c.m4623a((Object) ufVar);
        this.f6070a = ufVar;
        this.f6071c = new C20361(this);
    }

    private Handler m9201e() {
        if (f6069b != null) {
            return f6069b;
        }
        Handler handler;
        synchronized (uu.class) {
            if (f6069b == null) {
                f6069b = new Handler(this.f6070a.m9154b().getMainLooper());
            }
            handler = f6069b;
        }
        return handler;
    }

    public abstract void m9202a();

    public void m9203a(long j) {
        m9207d();
        if (j >= 0) {
            this.f6072d = this.f6070a.m9156d().m4926a();
            if (!m9201e().postDelayed(this.f6071c, j)) {
                this.f6070a.m9158f().m4261e("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public long m9204b() {
        return this.f6072d == 0 ? 0 : Math.abs(this.f6070a.m9156d().m4926a() - this.f6072d);
    }

    public void m9205b(long j) {
        long j2 = 0;
        if (!m9206c()) {
            return;
        }
        if (j < 0) {
            m9207d();
            return;
        }
        long abs = j - Math.abs(this.f6070a.m9156d().m4926a() - this.f6072d);
        if (abs >= 0) {
            j2 = abs;
        }
        m9201e().removeCallbacks(this.f6071c);
        if (!m9201e().postDelayed(this.f6071c, j2)) {
            this.f6070a.m9158f().m4261e("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }

    public boolean m9206c() {
        return this.f6072d != 0;
    }

    public void m9207d() {
        this.f6072d = 0;
        m9201e().removeCallbacks(this.f6071c);
    }
}
