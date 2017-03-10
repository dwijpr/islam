package com.google.p033a.p038c;

import com.google.p033a.p035b.C1015a;
import com.google.p033a.p035b.C1019b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.google.a.c.a */
public class C1061a<T> {
    final Class<? super T> f2199a;
    final Type f2200b;
    final int f2201c;

    protected C1061a() {
        this.f2200b = C1061a.m3770a(getClass());
        this.f2199a = C1019b.m3696e(this.f2200b);
        this.f2201c = this.f2200b.hashCode();
    }

    C1061a(Type type) {
        this.f2200b = C1019b.m3695d((Type) C1015a.m3677a((Object) type));
        this.f2199a = C1019b.m3696e(this.f2200b);
        this.f2201c = this.f2200b.hashCode();
    }

    public static C1061a<?> m3769a(Type type) {
        return new C1061a(type);
    }

    static Type m3770a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C1019b.m3695d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static <T> C1061a<T> m3771b(Class<T> cls) {
        return new C1061a(cls);
    }

    public final Class<? super T> m3772a() {
        return this.f2199a;
    }

    public final Type m3773b() {
        return this.f2200b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1061a) && C1019b.m3689a(this.f2200b, ((C1061a) obj).f2200b);
    }

    public final int hashCode() {
        return this.f2201c;
    }

    public final String toString() {
        return C1019b.m3697f(this.f2200b);
    }
}
