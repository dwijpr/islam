package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class ii extends Thread {
    private final BlockingQueue<ml<?>> f4404a;
    private final hk f4405b;
    private final cz f4406c;
    private final pi f4407d;
    private volatile boolean f4408e;

    public ii(BlockingQueue<ml<?>> blockingQueue, hk hkVar, cz czVar, pi piVar) {
        super("VolleyNetworkDispatcher");
        this.f4408e = false;
        this.f4404a = blockingQueue;
        this.f4405b = hkVar;
        this.f4406c = czVar;
        this.f4407d = piVar;
    }

    @TargetApi(14)
    private void m6720a(ml<?> mlVar) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(mlVar.m7607b());
        }
    }

    private void m6721a(ml<?> mlVar, ti tiVar) {
        this.f4407d.m6334a((ml) mlVar, mlVar.m7605a(tiVar));
    }

    public void m6722a() {
        this.f4408e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                ml mlVar = (ml) this.f4404a.take();
                try {
                    mlVar.m7609b("network-queue-take");
                    m6720a(mlVar);
                    kj a = this.f4405b.m6565a(mlVar);
                    mlVar.m7609b("network-http-complete");
                    if (a.f4635d && mlVar.m7625q()) {
                        mlVar.m7611c("not-modified");
                    } else {
                        on a2 = mlVar.m7604a(a);
                        mlVar.m7609b("network-parse-complete");
                        if (mlVar.m7620l() && a2.f5264b != null) {
                            this.f4406c.m5672a(mlVar.m7612d(), a2.f5264b);
                            mlVar.m7609b("network-cache-written");
                        }
                        mlVar.m7624p();
                        this.f4407d.m6332a(mlVar, a2);
                    }
                } catch (ti e) {
                    e.m5040a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m6721a(mlVar, e);
                } catch (Throwable e2) {
                    uj.m9228a(e2, "Unhandled exception %s", e2.toString());
                    ti tiVar = new ti(e2);
                    tiVar.m5040a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f4407d.m6334a(mlVar, tiVar);
                }
            } catch (InterruptedException e3) {
                if (this.f4408e) {
                    return;
                }
            }
        }
    }
}
