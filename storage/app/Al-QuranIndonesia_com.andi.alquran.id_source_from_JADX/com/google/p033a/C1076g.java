package com.google.p033a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.a.g */
public final class C1076g extends C1075i implements Iterable<C1075i> {
    private final List<C1075i> f2229a;

    public C1076g() {
        this.f2229a = new ArrayList();
    }

    public Number m3822a() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3808a();
        }
        throw new IllegalStateException();
    }

    public void m3823a(C1075i c1075i) {
        Object obj;
        if (c1075i == null) {
            obj = C1079k.f2230a;
        }
        this.f2229a.add(obj);
    }

    public String m3824b() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3809b();
        }
        throw new IllegalStateException();
    }

    public double m3825c() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3810c();
        }
        throw new IllegalStateException();
    }

    public long m3826d() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3811d();
        }
        throw new IllegalStateException();
    }

    public int m3827e() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3812e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C1076g) && ((C1076g) obj).f2229a.equals(this.f2229a));
    }

    public boolean m3828f() {
        if (this.f2229a.size() == 1) {
            return ((C1075i) this.f2229a.get(0)).m3813f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f2229a.hashCode();
    }

    public Iterator<C1075i> iterator() {
        return this.f2229a.iterator();
    }
}
