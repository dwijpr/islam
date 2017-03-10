package com.google.android.gms.internal;

import java.util.concurrent.Future;

@op
public abstract class rl implements rs<Future> {
    private final Runnable f2410a;
    private volatile Thread f2411b;
    private boolean f2412c;

    /* renamed from: com.google.android.gms.internal.rl.1 */
    class C19431 implements Runnable {
        final /* synthetic */ rl f5705a;

        C19431(rl rlVar) {
            this.f5705a = rlVar;
        }

        public final void run() {
            this.f5705a.f2411b = Thread.currentThread();
            this.f5705a.zzcm();
        }
    }

    public rl() {
        this.f2410a = new C19431(this);
        this.f2412c = false;
    }

    public rl(boolean z) {
        this.f2410a = new C19431(this);
        this.f2412c = z;
    }

    public final void cancel() {
        onStop();
        if (this.f2411b != null) {
            this.f2411b.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzcm();

    public /* synthetic */ Object zziw() {
        return zzkf();
    }

    public final Future zzkf() {
        return this.f2412c ? rp.m8471a(1, this.f2410a) : rp.m8472a(this.f2410a);
    }
}
