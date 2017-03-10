package com.google.p033a.p035b.p036a;

import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.p035b.p036a.C0997i.C0996a;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.a.b.a.l */
final class C1002l<T> extends C0976r<T> {
    private final C1073e f2051a;
    private final C0976r<T> f2052b;
    private final Type f2053c;

    C1002l(C1073e c1073e, C0976r<T> c0976r, Type type) {
        this.f2051a = c1073e;
        this.f2052b = c0976r;
        this.f2053c = type;
    }

    private Type m3560a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void m3561a(C0987c c0987c, T t) {
        C0976r c0976r = this.f2052b;
        Type a = m3560a(this.f2053c, (Object) t);
        if (a != this.f2053c) {
            c0976r = this.f2051a.m3797a(C1061a.m3769a(a));
            if ((c0976r instanceof C0996a) && !(this.f2052b instanceof C0996a)) {
                c0976r = this.f2052b;
            }
        }
        c0976r.m3405a(c0987c, t);
    }

    public T m3562b(C0984a c0984a) {
        return this.f2052b.m3406b(c0984a);
    }
}
