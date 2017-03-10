package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.vq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.c */
public final class C1215c extends C1214h {
    private static List<Runnable> f2832b;
    private boolean f2833c;
    private Set<C1211a> f2834d;
    private boolean f2835e;
    private boolean f2836f;
    private volatile boolean f2837g;

    /* renamed from: com.google.android.gms.analytics.c.a */
    interface C1211a {
        void m4197a(Activity activity);

        void m4198b(Activity activity);
    }

    @TargetApi(14)
    /* renamed from: com.google.android.gms.analytics.c.b */
    class C1212b implements ActivityLifecycleCallbacks {
        final /* synthetic */ C1215c f2826a;

        C1212b(C1215c c1215c) {
            this.f2826a = c1215c;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.f2826a.m4217a(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.f2826a.m4222b(activity);
        }
    }

    static {
        f2832b = new ArrayList();
    }

    public C1215c(uf ufVar) {
        super(ufVar);
        this.f2834d = new HashSet();
    }

    public static C1215c m4211a(Context context) {
        return uf.m9151a(context).m9163k();
    }

    public static void m4212d() {
        synchronized (C1215c.class) {
            if (f2832b != null) {
                for (Runnable run : f2832b) {
                    run.run();
                }
                f2832b = null;
            }
        }
    }

    private ub m4213o() {
        return m4209j().m9161i();
    }

    private vq m4214p() {
        return m4209j().m9164l();
    }

    public C1223g m4215a(String str) {
        C1223g c1223g;
        synchronized (this) {
            c1223g = new C1223g(m4209j(), str, null);
            c1223g.m4281B();
        }
        return c1223g;
    }

    public void m4216a() {
        m4221b();
        this.f2833c = true;
    }

    void m4217a(Activity activity) {
        for (C1211a a : this.f2834d) {
            a.m4197a(activity);
        }
    }

    @TargetApi(14)
    public void m4218a(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.f2835e) {
            application.registerActivityLifecycleCallbacks(new C1212b(this));
            this.f2835e = true;
        }
    }

    void m4219a(C1211a c1211a) {
        this.f2834d.add(c1211a);
        Context b = m4209j().m9154b();
        if (b instanceof Application) {
            m4218a((Application) b);
        }
    }

    public void m4220a(boolean z) {
        this.f2836f = z;
    }

    void m4221b() {
        vq p = m4214p();
        p.m9528d();
        if (p.m9531g()) {
            m4220a(p.m9532h());
        }
        p.m9528d();
    }

    void m4222b(Activity activity) {
        for (C1211a b : this.f2834d) {
            b.m4198b(activity);
        }
    }

    void m4223b(C1211a c1211a) {
        this.f2834d.remove(c1211a);
    }

    public boolean m4224c() {
        return this.f2833c;
    }

    public boolean m4225e() {
        return this.f2836f;
    }

    public boolean m4226f() {
        return this.f2837g;
    }

    public String m4227g() {
        C1314c.m4635c("getClientId can not be called from the main thread");
        return m4209j().m9168p().m9316b();
    }

    public void m4228h() {
        m4213o().m9145c();
    }

    void m4229i() {
        m4213o().m9146d();
    }
}
