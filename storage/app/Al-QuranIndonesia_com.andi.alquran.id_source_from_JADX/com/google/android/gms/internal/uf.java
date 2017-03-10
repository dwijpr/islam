package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.C1215c;
import com.google.android.gms.analytics.C1236o;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;
import java.lang.Thread.UncaughtExceptionHandler;

public class uf {
    private static volatile uf f6045a;
    private final Context f6046b;
    private final Context f6047c;
    private final C1377c f6048d;
    private final us f6049e;
    private final vg f6050f;
    private final C1236o f6051g;
    private final ub f6052h;
    private final uw f6053i;
    private final vq f6054j;
    private final vk f6055k;
    private final C1215c f6056l;
    private final uo f6057m;
    private final ua f6058n;
    private final ul f6059o;
    private final uv f6060p;

    /* renamed from: com.google.android.gms.internal.uf.1 */
    class C20211 implements UncaughtExceptionHandler {
        final /* synthetic */ uf f6044a;

        C20211(uf ufVar) {
            this.f6044a = ufVar;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            vg g = this.f6044a.m9159g();
            if (g != null) {
                g.m4261e("Job execution failed", th);
            }
        }
    }

    protected uf(ug ugVar) {
        Context a = ugVar.m9172a();
        C1314c.m4624a((Object) a, (Object) "Application context can't be null");
        Object b = ugVar.m9175b();
        C1314c.m4623a(b);
        this.f6046b = a;
        this.f6047c = b;
        this.f6048d = ugVar.m9182h(this);
        this.f6049e = ugVar.m9181g(this);
        vg f = ugVar.m9180f(this);
        f.m4281B();
        this.f6050f = f;
        f = m9158f();
        String str = ue.f6042a;
        f.m4257d(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        vk q = ugVar.m9191q(this);
        q.m4281B();
        this.f6055k = q;
        vq e = ugVar.m9179e(this);
        e.m4281B();
        this.f6054j = e;
        ub l = ugVar.m9186l(this);
        uo d = ugVar.m9178d(this);
        ua c = ugVar.m9177c(this);
        ul b2 = ugVar.m9176b(this);
        uv a2 = ugVar.m9174a(this);
        C1236o a3 = ugVar.m9173a(a);
        a3.m4372a(m9153a());
        this.f6051g = a3;
        C1215c i = ugVar.m9183i(this);
        d.m4281B();
        this.f6057m = d;
        c.m4281B();
        this.f6058n = c;
        b2.m4281B();
        this.f6059o = b2;
        a2.m4281B();
        this.f6060p = a2;
        uw p = ugVar.m9190p(this);
        p.m4281B();
        this.f6053i = p;
        l.m4281B();
        this.f6052h = l;
        i.m4216a();
        this.f6056l = i;
        l.m9144b();
    }

    public static uf m9151a(Context context) {
        C1314c.m4623a((Object) context);
        if (f6045a == null) {
            synchronized (uf.class) {
                if (f6045a == null) {
                    C1377c d = C1379e.m4937d();
                    long b = d.m4927b();
                    uf ufVar = new uf(new ug(context));
                    f6045a = ufVar;
                    C1215c.m4212d();
                    b = d.m4927b() - b;
                    long longValue = ((Long) uz.f6157Q.m9383a()).longValue();
                    if (b > longValue) {
                        ufVar.m9158f().m4256c("Slow initialization (ms)", Long.valueOf(b), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f6045a;
    }

    private void m9152a(ud udVar) {
        C1314c.m4624a((Object) udVar, (Object) "Analytics service not created/initialized");
        C1314c.m4633b(udVar.m4283z(), "Analytics service not initialized");
    }

    protected UncaughtExceptionHandler m9153a() {
        return new C20211(this);
    }

    public Context m9154b() {
        return this.f6046b;
    }

    public Context m9155c() {
        return this.f6047c;
    }

    public C1377c m9156d() {
        return this.f6048d;
    }

    public us m9157e() {
        return this.f6049e;
    }

    public vg m9158f() {
        m9152a(this.f6050f);
        return this.f6050f;
    }

    public vg m9159g() {
        return this.f6050f;
    }

    public C1236o m9160h() {
        C1314c.m4623a(this.f6051g);
        return this.f6051g;
    }

    public ub m9161i() {
        m9152a(this.f6052h);
        return this.f6052h;
    }

    public uw m9162j() {
        m9152a(this.f6053i);
        return this.f6053i;
    }

    public C1215c m9163k() {
        C1314c.m4623a(this.f6056l);
        C1314c.m4633b(this.f6056l.m4224c(), "Analytics instance not initialized");
        return this.f6056l;
    }

    public vq m9164l() {
        m9152a(this.f6054j);
        return this.f6054j;
    }

    public vk m9165m() {
        m9152a(this.f6055k);
        return this.f6055k;
    }

    public vk m9166n() {
        return (this.f6055k == null || !this.f6055k.m4283z()) ? null : this.f6055k;
    }

    public ua m9167o() {
        m9152a(this.f6058n);
        return this.f6058n;
    }

    public uo m9168p() {
        m9152a(this.f6057m);
        return this.f6057m;
    }

    public ul m9169q() {
        m9152a(this.f6059o);
        return this.f6059o;
    }

    public uv m9170r() {
        return this.f6060p;
    }

    public void m9171s() {
        C1236o.m4367d();
    }
}
