package com.google.android.gms.p042b;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.f */
class C1255f<TResult> implements C1254h<TResult> {
    private final Executor f2941a;
    private final Object f2942b;
    private C1248a f2943c;

    /* renamed from: com.google.android.gms.b.f.1 */
    class C12531 implements Runnable {
        final /* synthetic */ C1251d f2939a;
        final /* synthetic */ C1255f f2940b;

        C12531(C1255f c1255f, C1251d c1251d) {
            this.f2940b = c1255f;
            this.f2939a = c1251d;
        }

        public void run() {
            synchronized (this.f2940b.f2942b) {
                if (this.f2940b.f2943c != null) {
                    this.f2940b.f2943c.m4419a(this.f2939a.m4425c());
                }
            }
        }
    }

    public C1255f(Executor executor, C1248a c1248a) {
        this.f2942b = new Object();
        this.f2941a = executor;
        this.f2943c = c1248a;
    }

    public void m4433a(C1251d<TResult> c1251d) {
        if (!c1251d.m4423a()) {
            synchronized (this.f2942b) {
                if (this.f2943c == null) {
                    return;
                }
                this.f2941a.execute(new C12531(this, c1251d));
            }
        }
    }
}
