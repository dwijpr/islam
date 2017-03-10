package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;
import java.util.concurrent.Callable;

public class dp implements Callable {
    private final dc f3805a;
    private final C1444a f3806b;

    public dp(dc dcVar, C1444a c1444a) {
        this.f3805a = dcVar;
        this.f3806b = c1444a;
    }

    public Void m5763a() {
        if (this.f3805a.m5710m() != null) {
            this.f3805a.m5710m().get();
        }
        eg l = this.f3805a.m5709l();
        if (l != null) {
            try {
                synchronized (this.f3806b) {
                    eg.m5146a(this.f3806b, eg.m5148a(l));
                }
            } catch (ef e) {
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m5763a();
    }
}
