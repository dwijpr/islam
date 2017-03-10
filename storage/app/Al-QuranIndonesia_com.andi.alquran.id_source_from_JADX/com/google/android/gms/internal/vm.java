package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.common.internal.C1314c;

public final class vm {
    private static Boolean f6240d;
    private final Handler f6241a;
    private final C1202a f6242b;
    private final Context f6243c;

    /* renamed from: com.google.android.gms.internal.vm.a */
    public interface C1202a {
        Context m4179a();

        boolean m4180a(int i);
    }

    /* renamed from: com.google.android.gms.internal.vm.1 */
    class C20451 implements ux {
        final /* synthetic */ int f6236a;
        final /* synthetic */ uf f6237b;
        final /* synthetic */ vg f6238c;
        final /* synthetic */ vm f6239d;

        /* renamed from: com.google.android.gms.internal.vm.1.1 */
        class C20441 implements Runnable {
            final /* synthetic */ C20451 f6235a;

            C20441(C20451 c20451) {
                this.f6235a = c20451;
            }

            public void run() {
                if (this.f6235a.f6239d.f6242b.m4180a(this.f6235a.f6236a)) {
                    this.f6235a.f6238c.m4250b("Local AnalyticsService processed last dispatch request");
                }
            }
        }

        C20451(vm vmVar, int i, uf ufVar, vg vgVar) {
            this.f6239d = vmVar;
            this.f6236a = i;
            this.f6237b = ufVar;
            this.f6238c = vgVar;
        }

        public void m9493a(Throwable th) {
            this.f6239d.f6241a.post(new C20441(this));
        }
    }

    public vm(C1202a c1202a) {
        this.f6243c = c1202a.m4179a();
        C1314c.m4623a(this.f6243c);
        this.f6242b = c1202a;
        this.f6241a = new Handler();
    }

    public static boolean m9495a(Context context) {
        C1314c.m4623a((Object) context);
        if (f6240d != null) {
            return f6240d.booleanValue();
        }
        boolean a = vp.m9515a(context, "com.google.android.gms.analytics.AnalyticsService");
        f6240d = Boolean.valueOf(a);
        return a;
    }

    private void m9497c() {
        try {
            synchronized (vl.f6232a) {
                cx cxVar = vl.f6233b;
                if (cxVar != null && cxVar.m5667b()) {
                    cxVar.m5663a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public int m9498a(Intent intent, int i, int i2) {
        m9497c();
        uf a = uf.m9151a(this.f6243c);
        vg f = a.m9158f();
        if (intent == null) {
            f.m4260e("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            f.m4248a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                a.m9161i().m9140a(new C20451(this, i2, a, f));
            }
        }
        return 2;
    }

    public void m9499a() {
        uf.m9151a(this.f6243c).m9158f().m4250b("Local AnalyticsService is starting up");
    }

    public void m9500b() {
        uf.m9151a(this.f6243c).m9158f().m4250b("Local AnalyticsService is shutting down");
    }
}
