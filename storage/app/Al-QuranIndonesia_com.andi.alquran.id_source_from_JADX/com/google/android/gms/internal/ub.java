package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C1236o;
import com.google.android.gms.common.internal.C1314c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ub extends ud {
    private final um f6041a;

    /* renamed from: com.google.android.gms.internal.ub.1 */
    class C20161 implements Runnable {
        final /* synthetic */ boolean f6031a;
        final /* synthetic */ ub f6032b;

        C20161(ub ubVar, boolean z) {
            this.f6032b = ubVar;
            this.f6031a = z;
        }

        public void run() {
            this.f6032b.f6041a.m9299a(this.f6031a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ub.2 */
    class C20172 implements Runnable {
        final /* synthetic */ String f6033a;
        final /* synthetic */ Runnable f6034b;
        final /* synthetic */ ub f6035c;

        C20172(ub ubVar, String str, Runnable runnable) {
            this.f6035c = ubVar;
            this.f6033a = str;
            this.f6034b = runnable;
        }

        public void run() {
            this.f6035c.f6041a.m9298a(this.f6033a);
            if (this.f6034b != null) {
                this.f6034b.run();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ub.3 */
    class C20183 implements Runnable {
        final /* synthetic */ vc f6036a;
        final /* synthetic */ ub f6037b;

        C20183(ub ubVar, vc vcVar) {
            this.f6037b = ubVar;
            this.f6036a = vcVar;
        }

        public void run() {
            this.f6037b.f6041a.m9297a(this.f6036a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ub.4 */
    class C20194 implements Runnable {
        final /* synthetic */ ux f6038a;
        final /* synthetic */ ub f6039b;

        C20194(ub ubVar, ux uxVar) {
            this.f6039b = ubVar;
            this.f6038a = uxVar;
        }

        public void run() {
            this.f6039b.f6041a.m9295a(this.f6038a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ub.5 */
    class C20205 implements Callable<Void> {
        final /* synthetic */ ub f6040a;

        C20205(ub ubVar) {
            this.f6040a = ubVar;
        }

        public Void m9136a() {
            this.f6040a.f6041a.m9287D();
            return null;
        }

        public /* synthetic */ Object call() {
            return m9136a();
        }
    }

    public ub(uf ufVar, ug ugVar) {
        super(ufVar);
        C1314c.m4623a((Object) ugVar);
        this.f6041a = ugVar.m9184j(ufVar);
    }

    public long m9138a(uh uhVar) {
        m4280A();
        C1314c.m4623a((Object) uhVar);
        m4264j();
        long a = this.f6041a.m9292a(uhVar, true);
        if (a == 0) {
            this.f6041a.m9294a(uhVar);
        }
        return a;
    }

    protected void m9139a() {
        this.f6041a.m4281B();
    }

    public void m9140a(ux uxVar) {
        m4280A();
        m4269o().m4371a(new C20194(this, uxVar));
    }

    public void m9141a(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        m4280A();
        m4251b("Hit delivery requested", vcVar);
        m4269o().m4371a(new C20183(this, vcVar));
    }

    public void m9142a(String str, Runnable runnable) {
        C1314c.m4626a(str, (Object) "campaign param can't be empty");
        m4269o().m4371a(new C20172(this, str, runnable));
    }

    public void m9143a(boolean z) {
        m4247a("Network connectivity status changed", Boolean.valueOf(z));
        m4269o().m4371a(new C20161(this, z));
    }

    public void m9144b() {
        this.f6041a.m9301b();
    }

    public void m9145c() {
        m4280A();
        Context l = m4266l();
        if (vl.m9491a(l) && vm.m9495a(l)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(l, "com.google.android.gms.analytics.AnalyticsService"));
            l.startService(intent);
            return;
        }
        m9140a(null);
    }

    public boolean m9146d() {
        m4280A();
        try {
            m4269o().m4369a(new C20205(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            m4258d("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            m4261e("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            m4258d("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void m9147e() {
        m4280A();
        C1236o.m4367d();
        this.f6041a.m9305f();
    }

    public void m9148f() {
        m4250b("Radio powered up");
        m9145c();
    }

    void m9149g() {
        m4264j();
        this.f6041a.m9304e();
    }

    void m9150h() {
        m4264j();
        this.f6041a.m9303d();
    }
}
