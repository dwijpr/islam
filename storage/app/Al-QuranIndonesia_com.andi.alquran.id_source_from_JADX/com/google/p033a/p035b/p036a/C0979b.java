package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.p035b.C1019b;
import com.google.p033a.p035b.C1020h;
import com.google.p033a.p035b.C1030c;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.a.b.a.b */
public final class C0979b implements C0974s {
    private final C1030c f1983a;

    /* renamed from: com.google.a.b.a.b.a */
    private static final class C0978a<E> extends C0976r<Collection<E>> {
        private final C0976r<E> f1981a;
        private final C1020h<? extends Collection<E>> f1982b;

        public C0978a(C1073e c1073e, Type type, C0976r<E> c0976r, C1020h<? extends Collection<E>> c1020h) {
            this.f1981a = new C1002l(c1073e, c0976r, type);
            this.f1982b = c1020h;
        }

        public Collection<E> m3409a(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            Collection<E> collection = (Collection) this.f1982b.m3701a();
            c0984a.m3447a();
            while (c0984a.m3452e()) {
                collection.add(this.f1981a.m3406b(c0984a));
            }
            c0984a.m3449b();
            return collection;
        }

        public void m3411a(C0987c c0987c, Collection<E> collection) {
            if (collection == null) {
                c0987c.m3505f();
                return;
            }
            c0987c.m3496b();
            for (E a : collection) {
                this.f1981a.m3405a(c0987c, a);
            }
            c0987c.m3499c();
        }

        public /* synthetic */ Object m3412b(C0984a c0984a) {
            return m3409a(c0984a);
        }
    }

    public C0979b(C1030c c1030c) {
        this.f1983a = c1030c;
    }

    public <T> C0976r<T> m3413a(C1073e c1073e, C1061a<T> c1061a) {
        Type b = c1061a.m3773b();
        Class a = c1061a.m3772a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = C1019b.m3684a(b, a);
        return new C0978a(c1073e, a2, c1073e.m3797a(C1061a.m3769a(a2)), this.f1983a.m3717a((C1061a) c1061a));
    }
}
