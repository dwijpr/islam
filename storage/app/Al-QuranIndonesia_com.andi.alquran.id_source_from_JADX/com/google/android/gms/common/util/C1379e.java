package com.google.android.gms.common.util;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.common.util.e */
public class C1379e implements C1377c {
    private static C1379e f3221a;

    static {
        f3221a = new C1379e();
    }

    private C1379e() {
    }

    public static C1377c m4937d() {
        return f3221a;
    }

    public long m4938a() {
        return System.currentTimeMillis();
    }

    public long m4939b() {
        return SystemClock.elapsedRealtime();
    }

    public long m4940c() {
        return System.nanoTime();
    }
}
