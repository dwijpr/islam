package com.google.android.gms.internal;

import com.google.android.gms.internal.as.C1438a;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.maps.GoogleMap;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

public class dj extends er {
    private static volatile az f3789i;
    private static final Object f3790j;
    private boolean f3791k;
    private C1438a f3792l;

    static {
        f3789i = null;
        f3790j = new Object();
    }

    public dj(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2, boolean z, C1438a c1438a) {
        super(dcVar, str, str2, c1444a, i, i2);
        this.f3791k = false;
        this.f3792l = null;
        this.f3791k = z;
        this.f3792l = c1438a;
    }

    public static Boolean m5739a(C1438a c1438a) {
        boolean z = false;
        if (!de.m5722b(m5741b(c1438a))) {
            return Boolean.valueOf(false);
        }
        if (!(c1438a == null || c1438a.f3345a == null || c1438a.f3345a.f3347a.intValue() != 3)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private void m5740a(int i) {
        boolean z = true;
        Method method = this.f;
        Object[] objArr = new Object[3];
        objArr[0] = this.b.m5696a();
        objArr[1] = Boolean.valueOf(this.f3791k);
        if (i != 2) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        f3789i = new az((String) method.invoke(null, objArr));
        if (de.m5722b(f3789i.f3516a) || f3789i.f3516a.equals("E")) {
            switch (i) {
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    String f = m5745f();
                    if (!de.m5722b(f)) {
                        f3789i.f3516a = f;
                    }
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    f3789i.f3516a = this.f3792l.f3346b.f3348a;
                default:
            }
        }
    }

    public static String m5741b(C1438a c1438a) {
        return (c1438a == null || c1438a.f3346b == null || de.m5722b(c1438a.f3346b.f3348a)) ? null : c1438a.f3346b.f3348a;
    }

    private boolean m5742c() {
        return f3789i == null || de.m5722b(f3789i.f3516a) || f3789i.f3516a.equals("E");
    }

    private int m5743d() {
        return !de.m5722b(m5741b(this.f3792l)) ? 4 : (m5739a(this.f3792l).booleanValue() && m5744e()) ? 3 : 2;
    }

    private boolean m5744e() {
        return this.b.m5708k() && ((Boolean) C1648if.bP.m6682c()).booleanValue() && ((Boolean) C1648if.bQ.m6682c()).booleanValue() && ((Boolean) C1648if.bN.m6682c()).booleanValue();
    }

    private String m5745f() {
        try {
            if (this.b.m5710m() != null) {
                this.b.m5710m().get();
            }
            C1444a l = this.b.m5709l();
            if (!(l == null || l.f3427w == null)) {
                return l.f3427w;
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
        return null;
    }

    protected void m5746a() {
        if (m5742c()) {
            synchronized (f3790j) {
                int d = m5743d();
                if (d == 3) {
                    this.b.m5711n();
                }
                m5740a(d);
            }
        }
        synchronized (this.e) {
            if (f3789i != null) {
                this.e.f3427w = f3789i.f3516a;
                this.e.f3381C = Long.valueOf(f3789i.f3517b);
                this.e.f3380B = f3789i.f3518c;
                if (this.f3791k) {
                    this.e.f3391M = f3789i.f3519d;
                    this.e.f3392N = f3789i.f3520e;
                }
            }
        }
    }
}
