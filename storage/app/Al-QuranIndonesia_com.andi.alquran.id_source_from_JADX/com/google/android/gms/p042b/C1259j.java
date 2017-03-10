package com.google.android.gms.p042b;

import com.google.android.gms.common.internal.C1314c;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.j */
final class C1259j<TResult> extends C1251d<TResult> {
    private final Object f2952a;
    private final C1258i<TResult> f2953b;
    private boolean f2954c;
    private TResult f2955d;
    private Exception f2956e;

    C1259j() {
        this.f2952a = new Object();
        this.f2953b = new C1258i();
    }

    private void m4439d() {
        C1314c.m4629a(this.f2954c, (Object) "Task is not yet complete");
    }

    private void m4440e() {
        C1314c.m4629a(!this.f2954c, (Object) "Task is already complete");
    }

    private void m4441f() {
        synchronized (this.f2952a) {
            if (this.f2954c) {
                this.f2953b.m4437a((C1251d) this);
                return;
            }
        }
    }

    public C1251d<TResult> m4442a(Executor executor, C1248a c1248a) {
        this.f2953b.m4438a(new C1255f(executor, c1248a));
        m4441f();
        return this;
    }

    public C1251d<TResult> m4443a(Executor executor, C1249b<? super TResult> c1249b) {
        this.f2953b.m4438a(new C1257g(executor, c1249b));
        m4441f();
        return this;
    }

    public void m4444a(Exception exception) {
        C1314c.m4624a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f2952a) {
            m4440e();
            this.f2954c = true;
            this.f2956e = exception;
        }
        this.f2953b.m4437a((C1251d) this);
    }

    public void m4445a(TResult tResult) {
        synchronized (this.f2952a) {
            m4440e();
            this.f2954c = true;
            this.f2955d = tResult;
        }
        this.f2953b.m4437a((C1251d) this);
    }

    public boolean m4446a() {
        boolean z;
        synchronized (this.f2952a) {
            z = this.f2954c && this.f2956e == null;
        }
        return z;
    }

    public TResult m4447b() {
        TResult tResult;
        synchronized (this.f2952a) {
            m4439d();
            if (this.f2956e != null) {
                throw new C1250c(this.f2956e);
            }
            tResult = this.f2955d;
        }
        return tResult;
    }

    public boolean m4448b(Exception exception) {
        boolean z = true;
        C1314c.m4624a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f2952a) {
            if (this.f2954c) {
                z = false;
            } else {
                this.f2954c = true;
                this.f2956e = exception;
                this.f2953b.m4437a((C1251d) this);
            }
        }
        return z;
    }

    public Exception m4449c() {
        Exception exception;
        synchronized (this.f2952a) {
            exception = this.f2956e;
        }
        return exception;
    }
}
