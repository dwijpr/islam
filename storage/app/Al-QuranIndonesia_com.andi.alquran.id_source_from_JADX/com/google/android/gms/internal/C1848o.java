package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.internal.o */
public abstract class C1848o {
    private static final ExecutorService f5147a;

    static {
        f5147a = Executors.newFixedThreadPool(2, new ao("GAC_Executor"));
    }

    public static ExecutorService m7816a() {
        return f5147a;
    }
}
