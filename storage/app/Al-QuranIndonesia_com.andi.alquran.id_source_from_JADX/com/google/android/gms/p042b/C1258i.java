package com.google.android.gms.p042b;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.android.gms.b.i */
class C1258i<TResult> {
    private final Object f2949a;
    private Queue<C1254h<TResult>> f2950b;
    private boolean f2951c;

    C1258i() {
        this.f2949a = new Object();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4437a(com.google.android.gms.p042b.C1251d<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.f2949a;
        monitor-enter(r1);
        r0 = r2.f2950b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f2951c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f2951c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.f2949a;
        monitor-enter(r1);
        r0 = r2.f2950b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.google.android.gms.p042b.C1254h) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.f2951c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.m4430a(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.i.a(com.google.android.gms.b.d):void");
    }

    public void m4438a(C1254h<TResult> c1254h) {
        synchronized (this.f2949a) {
            if (this.f2950b == null) {
                this.f2950b = new ArrayDeque();
            }
            this.f2950b.add(c1254h);
        }
    }
}
