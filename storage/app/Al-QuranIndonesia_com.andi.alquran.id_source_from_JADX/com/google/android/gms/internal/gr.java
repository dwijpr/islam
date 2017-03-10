package com.google.android.gms.internal;

@op
public class gr {
    private static final Object f4212a;
    private static gr f4213b;
    private final sf f4214c;
    private final gq f4215d;

    static {
        f4212a = new Object();
        m6417a(new gr());
    }

    protected gr() {
        this.f4214c = new sf();
        this.f4215d = new gq(new gi(), new gh(), new ho(), new jw(), new qe(), new ns(), new nc());
    }

    public static sf m6416a() {
        return m6419c().f4214c;
    }

    protected static void m6417a(gr grVar) {
        synchronized (f4212a) {
            f4213b = grVar;
        }
    }

    public static gq m6418b() {
        return m6419c().f4215d;
    }

    private static gr m6419c() {
        gr grVar;
        synchronized (f4212a) {
            grVar = f4213b;
        }
        return grVar;
    }
}
