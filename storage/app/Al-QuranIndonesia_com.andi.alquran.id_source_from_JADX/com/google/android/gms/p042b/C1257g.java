package com.google.android.gms.p042b;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.g */
class C1257g<TResult> implements C1254h<TResult> {
    private final Executor f2946a;
    private final Object f2947b;
    private C1249b<? super TResult> f2948c;

    /* renamed from: com.google.android.gms.b.g.1 */
    class C12561 implements Runnable {
        final /* synthetic */ C1251d f2944a;
        final /* synthetic */ C1257g f2945b;

        C12561(C1257g c1257g, C1251d c1251d) {
            this.f2945b = c1257g;
            this.f2944a = c1251d;
        }

        public void run() {
            synchronized (this.f2945b.f2947b) {
                if (this.f2945b.f2948c != null) {
                    this.f2945b.f2948c.m4420a(this.f2944a.m4424b());
                }
            }
        }
    }

    public C1257g(Executor executor, C1249b<? super TResult> c1249b) {
        this.f2947b = new Object();
        this.f2946a = executor;
        this.f2948c = c1249b;
    }

    public void m4436a(C1251d<TResult> c1251d) {
        if (c1251d.m4423a()) {
            synchronized (this.f2947b) {
                if (this.f2948c == null) {
                    return;
                }
                this.f2946a.execute(new C12561(this, c1251d));
            }
        }
    }
}
