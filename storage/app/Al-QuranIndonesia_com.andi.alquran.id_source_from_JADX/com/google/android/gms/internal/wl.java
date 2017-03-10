package com.google.android.gms.internal;

import android.support.v4.p014g.C0298a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1287m;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.p042b.C1251d;
import com.google.android.gms.p042b.C1252e;
import java.util.Set;

public final class wl {
    private final C0298a<wj<?>, ConnectionResult> f6329a;
    private final C1252e<Void> f6330b;
    private int f6331c;
    private boolean f6332d;

    public wl(Iterable<C1288n<? extends C1240a>> iterable) {
        this.f6330b = new C1252e();
        this.f6332d = false;
        this.f6329a = new C0298a();
        for (C1288n a : iterable) {
            this.f6329a.put(a.m4565a(), null);
        }
        this.f6331c = this.f6329a.keySet().size();
    }

    public Set<wj<?>> m9684a() {
        return this.f6329a.keySet();
    }

    public void m9685a(wj<?> wjVar, ConnectionResult connectionResult) {
        this.f6329a.put(wjVar, connectionResult);
        this.f6331c--;
        if (!connectionResult.m4452b()) {
            this.f6332d = true;
        }
        if (this.f6331c != 0) {
            return;
        }
        if (this.f6332d) {
            this.f6330b.m4427a(new C1287m(this.f6329a));
            return;
        }
        this.f6330b.m4428a(null);
    }

    public C1251d<Void> m9686b() {
        return this.f6330b.m4426a();
    }

    public void m9687c() {
        this.f6330b.m4428a(null);
    }
}
