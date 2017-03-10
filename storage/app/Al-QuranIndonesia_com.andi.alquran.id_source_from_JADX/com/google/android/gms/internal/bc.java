package com.google.android.gms.internal;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.google.android.gms.internal.at.C1441a;
import com.google.android.gms.internal.vx.C2053a;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class bc {
    protected static volatile vx f3592a;
    private static final ConditionVariable f3593d;
    private static volatile Random f3594e;
    protected Boolean f3595b;
    private dc f3596c;

    /* renamed from: com.google.android.gms.internal.bc.1 */
    class C14681 implements Runnable {
        final /* synthetic */ bc f3591a;

        C14681(bc bcVar) {
            this.f3591a = bcVar;
        }

        public void run() {
            if (this.f3591a.f3595b == null) {
                synchronized (bc.f3593d) {
                    if (this.f3591a.f3595b != null) {
                        return;
                    }
                    boolean booleanValue = ((Boolean) C1648if.bp.m6682c()).booleanValue();
                    if (booleanValue) {
                        bc.f3592a = new vx(this.f3591a.f3596c.m5696a(), "ADSHIELD", null);
                    }
                    this.f3591a.f3595b = Boolean.valueOf(booleanValue);
                    bc.f3593d.open();
                }
            }
        }
    }

    static {
        f3593d = new ConditionVariable();
        f3592a = null;
        f3594e = null;
    }

    public bc(dc dcVar) {
        this.f3596c = dcVar;
        m5260a(dcVar.m5700c());
    }

    private void m5260a(Executor executor) {
        executor.execute(new C14681(this));
    }

    private static Random m5262c() {
        if (f3594e == null) {
            synchronized (bc.class) {
                if (f3594e == null) {
                    f3594e = new Random();
                }
            }
        }
        return f3594e;
    }

    public int m5263a() {
        try {
            return VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : m5262c().nextInt();
        } catch (RuntimeException e) {
            return m5262c().nextInt();
        }
    }

    public void m5264a(int i, int i2, long j) {
        try {
            f3593d.block();
            if (this.f3595b.booleanValue() && f3592a != null && this.f3596c.m5706i()) {
                eg c1441a = new C1441a();
                c1441a.f3353a = this.f3596c.m5696a().getPackageName();
                c1441a.f3354b = Long.valueOf(j);
                C2053a a = f3592a.m9605a(eg.m5148a(c1441a));
                a.m9582b(i2);
                a.m9579a(i);
                a.m9578a(this.f3596c.m5704g());
            }
        } catch (Exception e) {
        }
    }
}
