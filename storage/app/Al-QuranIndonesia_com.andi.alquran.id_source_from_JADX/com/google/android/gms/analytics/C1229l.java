package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.l */
public final class C1229l {
    private final C1213n f2875a;
    private final C1377c f2876b;
    private boolean f2877c;
    private long f2878d;
    private long f2879e;
    private long f2880f;
    private long f2881g;
    private long f2882h;
    private boolean f2883i;
    private final Map<Class<? extends C1230m>, C1230m> f2884j;
    private final List<C1224p> f2885k;

    C1229l(C1229l c1229l) {
        this.f2875a = c1229l.f2875a;
        this.f2876b = c1229l.f2876b;
        this.f2878d = c1229l.f2878d;
        this.f2879e = c1229l.f2879e;
        this.f2880f = c1229l.f2880f;
        this.f2881g = c1229l.f2881g;
        this.f2882h = c1229l.f2882h;
        this.f2885k = new ArrayList(c1229l.f2885k);
        this.f2884j = new HashMap(c1229l.f2884j.size());
        for (Entry entry : c1229l.f2884j.entrySet()) {
            C1230m c = C1229l.m4342c((Class) entry.getKey());
            ((C1230m) entry.getValue()).m4361a(c);
            this.f2884j.put((Class) entry.getKey(), c);
        }
    }

    C1229l(C1213n c1213n, C1377c c1377c) {
        C1314c.m4623a((Object) c1213n);
        C1314c.m4623a((Object) c1377c);
        this.f2875a = c1213n;
        this.f2876b = c1377c;
        this.f2881g = 1800000;
        this.f2882h = 3024000000L;
        this.f2884j = new HashMap();
        this.f2885k = new ArrayList();
    }

    private static <T extends C1230m> T m4342c(Class<T> cls) {
        try {
            return (C1230m) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public C1229l m4343a() {
        return new C1229l(this);
    }

    public <T extends C1230m> T m4344a(Class<T> cls) {
        return (C1230m) this.f2884j.get(cls);
    }

    public void m4345a(long j) {
        this.f2879e = j;
    }

    public void m4346a(C1230m c1230m) {
        C1314c.m4623a((Object) c1230m);
        Class cls = c1230m.getClass();
        if (cls.getSuperclass() != C1230m.class) {
            throw new IllegalArgumentException();
        }
        c1230m.m4361a(m4347b(cls));
    }

    public <T extends C1230m> T m4347b(Class<T> cls) {
        C1230m c1230m = (C1230m) this.f2884j.get(cls);
        if (c1230m != null) {
            return c1230m;
        }
        T c = C1229l.m4342c(cls);
        this.f2884j.put(cls, c);
        return c;
    }

    public Collection<C1230m> m4348b() {
        return this.f2884j.values();
    }

    public List<C1224p> m4349c() {
        return this.f2885k;
    }

    public long m4350d() {
        return this.f2878d;
    }

    public void m4351e() {
        m4355i().m4370a(this);
    }

    public boolean m4352f() {
        return this.f2877c;
    }

    void m4353g() {
        this.f2880f = this.f2876b.m4927b();
        if (this.f2879e != 0) {
            this.f2878d = this.f2879e;
        } else {
            this.f2878d = this.f2876b.m4926a();
        }
        this.f2877c = true;
    }

    C1213n m4354h() {
        return this.f2875a;
    }

    C1236o m4355i() {
        return this.f2875a.m4204n();
    }

    boolean m4356j() {
        return this.f2883i;
    }

    void m4357k() {
        this.f2883i = true;
    }
}
