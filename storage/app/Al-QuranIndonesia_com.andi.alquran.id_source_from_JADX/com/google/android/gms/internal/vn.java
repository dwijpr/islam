package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;

class vn {
    private final C1377c f6244a;
    private long f6245b;

    public vn(C1377c c1377c) {
        C1314c.m4623a((Object) c1377c);
        this.f6244a = c1377c;
    }

    public vn(C1377c c1377c, long j) {
        C1314c.m4623a((Object) c1377c);
        this.f6244a = c1377c;
        this.f6245b = j;
    }

    public void m9501a() {
        this.f6245b = this.f6244a.m4927b();
    }

    public boolean m9502a(long j) {
        return this.f6245b == 0 || this.f6244a.m4927b() - this.f6245b > j;
    }

    public void m9503b() {
        this.f6245b = 0;
    }
}
