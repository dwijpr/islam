package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.p035b.C1019b;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.a.b.a.a */
public final class C0977a<E> extends C0976r<Object> {
    public static final C0974s f1978a;
    private final Class<E> f1979b;
    private final C0976r<E> f1980c;

    /* renamed from: com.google.a.b.a.a.1 */
    static class C09751 implements C0974s {
        C09751() {
        }

        public <T> C0976r<T> m3403a(C1073e c1073e, C1061a<T> c1061a) {
            Type b = c1061a.m3773b();
            if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
                return null;
            }
            b = C1019b.m3698g(b);
            return new C0977a(c1073e, c1073e.m3797a(C1061a.m3769a(b)), C1019b.m3696e(b));
        }
    }

    static {
        f1978a = new C09751();
    }

    public C0977a(C1073e c1073e, C0976r<E> c0976r, Class<E> cls) {
        this.f1980c = new C1002l(c1073e, c0976r, cls);
        this.f1979b = cls;
    }

    public void m3407a(C0987c c0987c, Object obj) {
        if (obj == null) {
            c0987c.m3505f();
            return;
        }
        c0987c.m3496b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f1980c.m3405a(c0987c, Array.get(obj, i));
        }
        c0987c.m3499c();
    }

    public Object m3408b(C0984a c0984a) {
        if (c0984a.m3453f() == C1063b.NULL) {
            c0984a.m3457j();
            return null;
        }
        List arrayList = new ArrayList();
        c0984a.m3447a();
        while (c0984a.m3452e()) {
            arrayList.add(this.f1980c.m3406b(c0984a));
        }
        c0984a.m3449b();
        Object newInstance = Array.newInstance(this.f1979b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
