package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.p039a.C1111d;

@op
public class qj extends rl implements ql, qo {
    private final C1938a f5551a;
    private final Context f5552b;
    private final qq f5553c;
    private final qo f5554d;
    private final Object f5555e;
    private final String f5556f;
    private final String f5557g;
    private final lt f5558h;
    private final long f5559i;
    private int f5560j;
    private int f5561k;
    private qk f5562l;

    /* renamed from: com.google.android.gms.internal.qj.1 */
    class C19291 implements Runnable {
        final /* synthetic */ zzdy f5544a;
        final /* synthetic */ me f5545b;
        final /* synthetic */ qj f5546c;

        C19291(qj qjVar, zzdy com_google_android_gms_internal_zzdy, me meVar) {
            this.f5546c = qjVar;
            this.f5544a = com_google_android_gms_internal_zzdy;
            this.f5545b = meVar;
        }

        public void run() {
            this.f5546c.m8287a(this.f5544a, this.f5545b);
        }
    }

    /* renamed from: com.google.android.gms.internal.qj.2 */
    class C19302 implements Runnable {
        final /* synthetic */ me f5547a;
        final /* synthetic */ zzdy f5548b;
        final /* synthetic */ qn f5549c;
        final /* synthetic */ qj f5550d;

        C19302(qj qjVar, me meVar, zzdy com_google_android_gms_internal_zzdy, qn qnVar) {
            this.f5550d = qjVar;
            this.f5547a = meVar;
            this.f5548b = com_google_android_gms_internal_zzdy;
            this.f5549c = qnVar;
        }

        public void run() {
            try {
                this.f5547a.m7465a(C1111d.m3896a(this.f5550d.f5552b), this.f5548b, null, this.f5549c, this.f5550d.f5557g);
            } catch (Throwable e) {
                Throwable th = e;
                String str = "Fail to initialize adapter ";
                String valueOf = String.valueOf(this.f5550d.f5556f);
                sg.m8447c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
                this.f5550d.m8294a(this.f5550d.f5556f, 0);
            }
        }
    }

    public qj(Context context, String str, String str2, lt ltVar, C1938a c1938a, qq qqVar, qo qoVar, long j) {
        this.f5560j = 0;
        this.f5561k = 3;
        this.f5552b = context;
        this.f5556f = str;
        this.f5557g = str2;
        this.f5558h = ltVar;
        this.f5551a = c1938a;
        this.f5553c = qqVar;
        this.f5555e = new Object();
        this.f5554d = qoVar;
        this.f5559i = j;
    }

    private void m8287a(zzdy com_google_android_gms_internal_zzdy, me meVar) {
        this.f5553c.m8342b().m8322a((qo) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f5556f)) {
                meVar.m7471a(com_google_android_gms_internal_zzdy, this.f5557g, this.f5558h.f4837a);
            } else {
                meVar.m7470a(com_google_android_gms_internal_zzdy, this.f5557g);
            }
        } catch (Throwable e) {
            sg.m8447c("Fail to load ad from adapter.", e);
            m8294a(this.f5556f, 0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8289b(long r6) {
        /*
        r5 = this;
    L_0x0000:
        r1 = r5.f5555e;
        monitor-enter(r1);
        r0 = r5.f5560j;	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x003c;
    L_0x0007:
        r0 = new com.google.android.gms.internal.qk$a;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ all -> 0x0070 }
        r2 = r2.m4927b();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r2 = r0.m8303a(r2);	 Catch:{ all -> 0x0070 }
        r0 = 1;
        r3 = r5.f5560j;	 Catch:{ all -> 0x0070 }
        if (r0 != r3) goto L_0x0039;
    L_0x001e:
        r0 = 6;
    L_0x001f:
        r0 = r2.m8302a(r0);	 Catch:{ all -> 0x0070 }
        r2 = r5.f5556f;	 Catch:{ all -> 0x0070 }
        r0 = r0.m8304a(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.f5558h;	 Catch:{ all -> 0x0070 }
        r2 = r2.f4840d;	 Catch:{ all -> 0x0070 }
        r0 = r0.m8306b(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.m8305a();	 Catch:{ all -> 0x0070 }
        r5.f5562l = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
    L_0x0038:
        return;
    L_0x0039:
        r0 = r5.f5561k;	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x003c:
        r0 = r5.m8295a(r6);	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0073;
    L_0x0042:
        r0 = new com.google.android.gms.internal.qk$a;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = r5.f5561k;	 Catch:{ all -> 0x0070 }
        r0 = r0.m8302a(r2);	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ all -> 0x0070 }
        r2 = r2.m4927b();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r0 = r0.m8303a(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.f5556f;	 Catch:{ all -> 0x0070 }
        r0 = r0.m8304a(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.f5558h;	 Catch:{ all -> 0x0070 }
        r2 = r2.f4840d;	 Catch:{ all -> 0x0070 }
        r0 = r0.m8306b(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.m8305a();	 Catch:{ all -> 0x0070 }
        r5.f5562l = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0038;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        throw r0;
    L_0x0073:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.qj.b(long):void");
    }

    public qk m8291a() {
        qk qkVar;
        synchronized (this.f5555e) {
            qkVar = this.f5562l;
        }
        return qkVar;
    }

    public void m8292a(int i) {
        m8294a(this.f5556f, 0);
    }

    public void m8293a(String str) {
        synchronized (this.f5555e) {
            this.f5560j = 1;
            this.f5555e.notify();
        }
    }

    public void m8294a(String str, int i) {
        synchronized (this.f5555e) {
            this.f5560j = 2;
            this.f5561k = i;
            this.f5555e.notify();
        }
    }

    protected boolean m8295a(long j) {
        long b = this.f5559i - (zzv.zzcP().m4927b() - j);
        if (b <= 0) {
            this.f5561k = 4;
            return false;
        }
        try {
            this.f5555e.wait(b);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.f5561k = 5;
            return false;
        }
    }

    public lt m8296b() {
        return this.f5558h;
    }

    public void m8297c() {
        m8287a(this.f5551a.f5594a.f6542c, this.f5553c.m8341a());
    }

    public void onStop() {
    }

    public void zzcm() {
        if (this.f5553c != null && this.f5553c.m8342b() != null && this.f5553c.m8341a() != null) {
            qn b = this.f5553c.m8342b();
            b.m8322a(null);
            b.m8321a((ql) this);
            zzdy com_google_android_gms_internal_zzdy = this.f5551a.f5594a.f6542c;
            me a = this.f5553c.m8341a();
            try {
                if (a.m7477g()) {
                    sf.f5831a.post(new C19291(this, com_google_android_gms_internal_zzdy, a));
                } else {
                    sf.f5831a.post(new C19302(this, a, com_google_android_gms_internal_zzdy, b));
                }
            } catch (Throwable e) {
                sg.m8447c("Fail to check if adapter is initialized.", e);
                m8294a(this.f5556f, 0);
            }
            m8289b(zzv.zzcP().m4927b());
            b.m8322a(null);
            b.m8321a(null);
            if (this.f5560j == 1) {
                this.f5554d.m8283a(this.f5556f);
            } else {
                this.f5554d.m8284a(this.f5556f, this.f5561k);
            }
        }
    }
}
