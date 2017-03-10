package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.p */
public final class C1346p implements Callback {
    final ArrayList<C0777b> f3109a;
    private final C1318a f3110b;
    private final ArrayList<C0777b> f3111c;
    private final ArrayList<C0778c> f3112d;
    private volatile boolean f3113e;
    private final AtomicInteger f3114f;
    private boolean f3115g;
    private final Handler f3116h;
    private final Object f3117i;

    /* renamed from: com.google.android.gms.common.internal.p.a */
    public interface C1318a {
        boolean m4686b();

        Bundle m4687t();
    }

    public C1346p(Looper looper, C1318a c1318a) {
        this.f3111c = new ArrayList();
        this.f3109a = new ArrayList();
        this.f3112d = new ArrayList();
        this.f3113e = false;
        this.f3114f = new AtomicInteger(0);
        this.f3115g = false;
        this.f3117i = new Object();
        this.f3110b = c1318a;
        this.f3116h = new Handler(looper, this);
    }

    public void m4760a() {
        this.f3113e = false;
        this.f3114f.incrementAndGet();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4761a(int r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = 1;
        r2 = android.os.Looper.myLooper();
        r3 = r5.f3116h;
        r3 = r3.getLooper();
        if (r2 != r3) goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = "onUnintentionalDisconnection must only be called on the Handler thread";
        com.google.android.gms.common.internal.C1314c.m4629a(r0, r2);
        r0 = r5.f3116h;
        r0.removeMessages(r1);
        r1 = r5.f3117i;
        monitor-enter(r1);
        r0 = 1;
        r5.f3115g = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x005e }
        r2 = r5.f3111c;	 Catch:{ all -> 0x005e }
        r0.<init>(r2);	 Catch:{ all -> 0x005e }
        r2 = r5.f3114f;	 Catch:{ all -> 0x005e }
        r2 = r2.get();	 Catch:{ all -> 0x005e }
        r3 = r0.iterator();	 Catch:{ all -> 0x005e }
    L_0x0030:
        r0 = r3.hasNext();	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0048;
    L_0x0036:
        r0 = r3.next();	 Catch:{ all -> 0x005e }
        r0 = (com.google.android.gms.common.api.C1277c.C0777b) r0;	 Catch:{ all -> 0x005e }
        r4 = r5.f3113e;	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0048;
    L_0x0040:
        r4 = r5.f3114f;	 Catch:{ all -> 0x005e }
        r4 = r4.get();	 Catch:{ all -> 0x005e }
        if (r4 == r2) goto L_0x0052;
    L_0x0048:
        r0 = r5.f3109a;	 Catch:{ all -> 0x005e }
        r0.clear();	 Catch:{ all -> 0x005e }
        r0 = 0;
        r5.f3115g = r0;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        return;
    L_0x0052:
        r4 = r5.f3111c;	 Catch:{ all -> 0x005e }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0030;
    L_0x005a:
        r0.m2642a(r6);	 Catch:{ all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.p.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4762a(android.os.Bundle r6) {
        /*
        r5 = this;
        r2 = 0;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r3 = r5.f3116h;
        r3 = r3.getLooper();
        if (r0 != r3) goto L_0x006e;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "onConnectionSuccess must only be called on the Handler thread";
        com.google.android.gms.common.internal.C1314c.m4629a(r0, r3);
        r3 = r5.f3117i;
        monitor-enter(r3);
        r0 = r5.f3115g;	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0070;
    L_0x001b:
        r0 = r1;
    L_0x001c:
        com.google.android.gms.common.internal.C1314c.m4628a(r0);	 Catch:{ all -> 0x0080 }
        r0 = r5.f3116h;	 Catch:{ all -> 0x0080 }
        r4 = 1;
        r0.removeMessages(r4);	 Catch:{ all -> 0x0080 }
        r0 = 1;
        r5.f3115g = r0;	 Catch:{ all -> 0x0080 }
        r0 = r5.f3109a;	 Catch:{ all -> 0x0080 }
        r0 = r0.size();	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0072;
    L_0x0030:
        com.google.android.gms.common.internal.C1314c.m4628a(r1);	 Catch:{ all -> 0x0080 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0080 }
        r1 = r5.f3111c;	 Catch:{ all -> 0x0080 }
        r0.<init>(r1);	 Catch:{ all -> 0x0080 }
        r1 = r5.f3114f;	 Catch:{ all -> 0x0080 }
        r1 = r1.get();	 Catch:{ all -> 0x0080 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0080 }
    L_0x0044:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x0064;
    L_0x004a:
        r0 = r2.next();	 Catch:{ all -> 0x0080 }
        r0 = (com.google.android.gms.common.api.C1277c.C0777b) r0;	 Catch:{ all -> 0x0080 }
        r4 = r5.f3113e;	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = r5.f3110b;	 Catch:{ all -> 0x0080 }
        r4 = r4.m4686b();	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x005c:
        r4 = r5.f3114f;	 Catch:{ all -> 0x0080 }
        r4 = r4.get();	 Catch:{ all -> 0x0080 }
        if (r4 == r1) goto L_0x0074;
    L_0x0064:
        r0 = r5.f3109a;	 Catch:{ all -> 0x0080 }
        r0.clear();	 Catch:{ all -> 0x0080 }
        r0 = 0;
        r5.f3115g = r0;	 Catch:{ all -> 0x0080 }
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        return;
    L_0x006e:
        r0 = r2;
        goto L_0x000f;
    L_0x0070:
        r0 = r2;
        goto L_0x001c;
    L_0x0072:
        r1 = r2;
        goto L_0x0030;
    L_0x0074:
        r4 = r5.f3109a;	 Catch:{ all -> 0x0080 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0080 }
        if (r4 != 0) goto L_0x0044;
    L_0x007c:
        r0.m2643a(r6);	 Catch:{ all -> 0x0080 }
        goto L_0x0044;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.p.a(android.os.Bundle):void");
    }

    public void m4763a(ConnectionResult connectionResult) {
        C1314c.m4629a(Looper.myLooper() == this.f3116h.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
        this.f3116h.removeMessages(1);
        synchronized (this.f3117i) {
            ArrayList arrayList = new ArrayList(this.f3112d);
            int i = this.f3114f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0778c c0778c = (C0778c) it.next();
                if (!this.f3113e || this.f3114f.get() != i) {
                    return;
                } else if (this.f3112d.contains(c0778c)) {
                    c0778c.m2644a(connectionResult);
                }
            }
        }
    }

    public void m4764a(C0777b c0777b) {
        C1314c.m4623a((Object) c0777b);
        synchronized (this.f3117i) {
            if (this.f3111c.contains(c0777b)) {
                String valueOf = String.valueOf(c0777b);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f3111c.add(c0777b);
            }
        }
        if (this.f3110b.m4686b()) {
            this.f3116h.sendMessage(this.f3116h.obtainMessage(1, c0777b));
        }
    }

    public void m4765a(C0778c c0778c) {
        C1314c.m4623a((Object) c0778c);
        synchronized (this.f3117i) {
            if (this.f3112d.contains(c0778c)) {
                String valueOf = String.valueOf(c0778c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f3112d.add(c0778c);
            }
        }
    }

    public void m4766b() {
        this.f3113e = true;
    }

    public void m4767b(C0778c c0778c) {
        C1314c.m4623a((Object) c0778c);
        synchronized (this.f3117i) {
            if (!this.f3112d.remove(c0778c)) {
                String valueOf = String.valueOf(c0778c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C0777b c0777b = (C0777b) message.obj;
            synchronized (this.f3117i) {
                if (this.f3113e && this.f3110b.m4686b() && this.f3111c.contains(c0777b)) {
                    c0777b.m2643a(this.f3110b.m4687t());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
