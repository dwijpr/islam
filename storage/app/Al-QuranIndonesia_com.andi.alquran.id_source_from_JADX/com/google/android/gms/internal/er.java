package com.google.android.gms.internal;

import com.google.android.gms.internal.au.C1444a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class er implements Callable {
    protected final String f3771a;
    protected final dc f3772b;
    protected final String f3773c;
    protected final String f3774d;
    protected final C1444a f3775e;
    protected Method f3776f;
    protected final int f3777g;
    protected final int f3778h;

    public er(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        this.f3771a = getClass().getSimpleName();
        this.f3772b = dcVar;
        this.f3773c = str;
        this.f3774d = str2;
        this.f3775e = c1444a;
        this.f3777g = i;
        this.f3778h = i2;
    }

    protected abstract void m5725a();

    public Void m5726b() {
        try {
            long nanoTime = System.nanoTime();
            this.f3776f = this.f3772b.m5697a(this.f3773c, this.f3774d);
            if (this.f3776f != null) {
                m5725a();
                bc j = this.f3772b.m5707j();
                if (!(j == null || this.f3777g == RtlSpacingHelper.UNDEFINED)) {
                    j.m5264a(this.f3778h, this.f3777g, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m5726b();
    }
}
