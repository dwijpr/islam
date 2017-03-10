package com.andi.alquran.p023e;

/* renamed from: com.andi.alquran.e.a */
public class C0898a extends Exception {
    C0904c f1751a;

    public C0898a(int i, String str) {
        this(new C0904c(i, str));
    }

    public C0898a(int i, String str, Exception exception) {
        this(new C0904c(i, str), exception);
    }

    public C0898a(C0904c c0904c) {
        this(c0904c, null);
    }

    public C0898a(C0904c c0904c, Exception exception) {
        super(c0904c.m3138a(), exception);
        this.f1751a = c0904c;
    }

    public C0904c m3115a() {
        return this.f1751a;
    }
}
