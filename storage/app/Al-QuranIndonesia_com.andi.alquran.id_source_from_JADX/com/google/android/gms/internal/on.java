package com.google.android.gms.internal;

import com.google.android.gms.internal.cz.C1516a;

public class on<T> {
    public final T f5263a;
    public final C1516a f5264b;
    public final ti f5265c;
    public boolean f5266d;

    /* renamed from: com.google.android.gms.internal.on.a */
    public interface C1875a {
        void m7935a(ti tiVar);
    }

    /* renamed from: com.google.android.gms.internal.on.b */
    public interface C1876b<T> {
        void m7936a(T t);
    }

    private on(ti tiVar) {
        this.f5266d = false;
        this.f5263a = null;
        this.f5264b = null;
        this.f5265c = tiVar;
    }

    private on(T t, C1516a c1516a) {
        this.f5266d = false;
        this.f5263a = t;
        this.f5264b = c1516a;
        this.f5265c = null;
    }

    public static <T> on<T> m7937a(ti tiVar) {
        return new on(tiVar);
    }

    public static <T> on<T> m7938a(T t, C1516a c1516a) {
        return new on(t, c1516a);
    }

    public boolean m7939a() {
        return this.f5265c == null;
    }
}
