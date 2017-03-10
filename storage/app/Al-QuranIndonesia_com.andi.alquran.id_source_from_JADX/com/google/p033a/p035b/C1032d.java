package com.google.p033a.p035b;

import com.google.p033a.C0973a;
import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1053b;
import com.google.p033a.C1073e;
import com.google.p033a.p034a.C0968a;
import com.google.p033a.p034a.C0971d;
import com.google.p033a.p034a.C0972e;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.a.b.d */
public final class C1032d implements C0974s, Cloneable {
    public static final C1032d f2148a;
    private double f2149b;
    private int f2150c;
    private boolean f2151d;
    private boolean f2152e;
    private List<C0973a> f2153f;
    private List<C0973a> f2154g;

    /* renamed from: com.google.a.b.d.1 */
    class C10311 extends C0976r<T> {
        final /* synthetic */ boolean f2142a;
        final /* synthetic */ boolean f2143b;
        final /* synthetic */ C1073e f2144c;
        final /* synthetic */ C1061a f2145d;
        final /* synthetic */ C1032d f2146e;
        private C0976r<T> f2147f;

        C10311(C1032d c1032d, boolean z, boolean z2, C1073e c1073e, C1061a c1061a) {
            this.f2146e = c1032d;
            this.f2142a = z;
            this.f2143b = z2;
            this.f2144c = c1073e;
            this.f2145d = c1061a;
        }

        private C0976r<T> m3718a() {
            C0976r<T> c0976r = this.f2147f;
            if (c0976r != null) {
                return c0976r;
            }
            c0976r = this.f2144c.m3798a(this.f2146e, this.f2145d);
            this.f2147f = c0976r;
            return c0976r;
        }

        public void m3719a(C0987c c0987c, T t) {
            if (this.f2143b) {
                c0987c.m3505f();
            } else {
                m3718a().m3405a(c0987c, t);
            }
        }

        public T m3720b(C0984a c0984a) {
            if (!this.f2142a) {
                return m3718a().m3406b(c0984a);
            }
            c0984a.m3461n();
            return null;
        }
    }

    static {
        f2148a = new C1032d();
    }

    public C1032d() {
        this.f2149b = -1.0d;
        this.f2150c = 136;
        this.f2151d = true;
        this.f2153f = Collections.emptyList();
        this.f2154g = Collections.emptyList();
    }

    private boolean m3721a(C0971d c0971d) {
        return c0971d == null || c0971d.m3398a() <= this.f2149b;
    }

    private boolean m3722a(C0971d c0971d, C0972e c0972e) {
        return m3721a(c0971d) && m3723a(c0972e);
    }

    private boolean m3723a(C0972e c0972e) {
        return c0972e == null || c0972e.m3399a() > this.f2149b;
    }

    private boolean m3724a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean m3725b(Class<?> cls) {
        return cls.isMemberClass() && !m3726c(cls);
    }

    private boolean m3726c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    protected C1032d m3727a() {
        try {
            return (C1032d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public <T> C0976r<T> m3728a(C1073e c1073e, C1061a<T> c1061a) {
        Class a = c1061a.m3772a();
        boolean a2 = m3729a(a, true);
        boolean a3 = m3729a(a, false);
        return (a2 || a3) ? new C10311(this, a3, a2, c1073e, c1061a) : null;
    }

    public boolean m3729a(Class<?> cls, boolean z) {
        if (this.f2149b != -1.0d && !m3722a((C0971d) cls.getAnnotation(C0971d.class), (C0972e) cls.getAnnotation(C0972e.class))) {
            return true;
        }
        if (!this.f2151d && m3725b(cls)) {
            return true;
        }
        if (m3724a((Class) cls)) {
            return true;
        }
        for (C0973a a : z ? this.f2153f : this.f2154g) {
            if (a.m3401a((Class) cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean m3730a(Field field, boolean z) {
        if ((this.f2150c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f2149b != -1.0d && !m3722a((C0971d) field.getAnnotation(C0971d.class), (C0972e) field.getAnnotation(C0972e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f2152e) {
            C0968a c0968a = (C0968a) field.getAnnotation(C0968a.class);
            if (c0968a == null || (z ? !c0968a.m3393a() : !c0968a.m3394b())) {
                return true;
            }
        }
        if (!this.f2151d && m3725b(field.getType())) {
            return true;
        }
        if (m3724a(field.getType())) {
            return true;
        }
        List<C0973a> list = z ? this.f2153f : this.f2154g;
        if (!list.isEmpty()) {
            C1053b c1053b = new C1053b(field);
            for (C0973a a : list) {
                if (a.m3400a(c1053b)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() {
        return m3727a();
    }
}
