package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.C1314c;

@op
public class ry {
    private HandlerThread f5810a;
    private Handler f5811b;
    private int f5812c;
    private final Object f5813d;

    /* renamed from: com.google.android.gms.internal.ry.1 */
    class C19901 implements Runnable {
        final /* synthetic */ ry f5809a;

        C19901(ry ryVar) {
            this.f5809a = ryVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.f5809a;
            r1 = r0.f5813d;
            monitor-enter(r1);
            r0 = "Suspending the looper thread";
            com.google.android.gms.internal.rm.m8450a(r0);	 Catch:{ all -> 0x002a }
        L_0x000c:
            r0 = r2.f5809a;	 Catch:{ all -> 0x002a }
            r0 = r0.f5812c;	 Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x002d;
        L_0x0014:
            r0 = r2.f5809a;	 Catch:{ InterruptedException -> 0x0023 }
            r0 = r0.f5813d;	 Catch:{ InterruptedException -> 0x0023 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0023 }
            r0 = "Looper thread resumed";
            com.google.android.gms.internal.rm.m8450a(r0);	 Catch:{ InterruptedException -> 0x0023 }
            goto L_0x000c;
        L_0x0023:
            r0 = move-exception;
            r0 = "Looper thread interrupted.";
            com.google.android.gms.internal.rm.m8450a(r0);	 Catch:{ all -> 0x002a }
            goto L_0x000c;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ry.1.run():void");
        }
    }

    public ry() {
        this.f5810a = null;
        this.f5811b = null;
        this.f5812c = 0;
        this.f5813d = new Object();
    }

    public Looper m8669a() {
        Looper looper;
        synchronized (this.f5813d) {
            if (this.f5812c != 0) {
                C1314c.m4624a(this.f5810a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f5810a == null) {
                rm.m8450a("Starting the looper thread.");
                this.f5810a = new HandlerThread("LooperProvider");
                this.f5810a.start();
                this.f5811b = new Handler(this.f5810a.getLooper());
                rm.m8450a("Looper thread started.");
            } else {
                rm.m8450a("Resuming the looper thread");
                this.f5813d.notifyAll();
            }
            this.f5812c++;
            looper = this.f5810a.getLooper();
        }
        return looper;
    }

    public void m8670b() {
        synchronized (this.f5813d) {
            C1314c.m4633b(this.f5812c > 0, "Invalid state: release() called more times than expected.");
            int i = this.f5812c - 1;
            this.f5812c = i;
            if (i == 0) {
                this.f5811b.post(new C19901(this));
            }
        }
    }
}
