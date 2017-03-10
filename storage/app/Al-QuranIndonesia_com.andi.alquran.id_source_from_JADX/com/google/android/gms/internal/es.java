package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.cz.C1516a;
import java.util.concurrent.BlockingQueue;

public class es extends Thread {
    private static final boolean f3916a;
    private final BlockingQueue<ml<?>> f3917b;
    private final BlockingQueue<ml<?>> f3918c;
    private final cz f3919d;
    private final pi f3920e;
    private volatile boolean f3921f;

    /* renamed from: com.google.android.gms.internal.es.1 */
    class C15351 implements Runnable {
        final /* synthetic */ ml f3914a;
        final /* synthetic */ es f3915b;

        C15351(es esVar, ml mlVar) {
            this.f3915b = esVar;
            this.f3914a = mlVar;
        }

        public void run() {
            try {
                this.f3915b.f3918c.put(this.f3914a);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        f3916a = uj.f6092b;
    }

    public es(BlockingQueue<ml<?>> blockingQueue, BlockingQueue<ml<?>> blockingQueue2, cz czVar, pi piVar) {
        super("VolleyCacheDispatcher");
        this.f3921f = false;
        this.f3917b = blockingQueue;
        this.f3918c = blockingQueue2;
        this.f3919d = czVar;
        this.f3920e = piVar;
    }

    public void m5976a() {
        this.f3921f = true;
        interrupt();
    }

    public void run() {
        if (f3916a) {
            uj.m9227a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f3919d.m5671a();
        while (true) {
            try {
                ml mlVar = (ml) this.f3917b.take();
                mlVar.m7609b("cache-queue-take");
                C1516a a = this.f3919d.m5670a(mlVar.m7612d());
                if (a == null) {
                    mlVar.m7609b("cache-miss");
                    this.f3918c.put(mlVar);
                } else if (a.m5668a()) {
                    mlVar.m7609b("cache-hit-expired");
                    mlVar.m7601a(a);
                    this.f3918c.put(mlVar);
                } else {
                    mlVar.m7609b("cache-hit");
                    on a2 = mlVar.m7604a(new kj(a.f3717a, a.f3723g));
                    mlVar.m7609b("cache-hit-parsed");
                    if (a.m5669b()) {
                        mlVar.m7609b("cache-hit-refresh-needed");
                        mlVar.m7601a(a);
                        a2.f5266d = true;
                        this.f3920e.m6333a(mlVar, a2, new C15351(this, mlVar));
                    } else {
                        this.f3920e.m6332a(mlVar, a2);
                    }
                }
            } catch (InterruptedException e) {
                if (this.f3921f) {
                    return;
                }
            }
        }
    }
}
