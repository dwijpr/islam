package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C1314c;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ao implements ThreadFactory {
    private final String f3336a;
    private final int f3337b;
    private final AtomicInteger f3338c;
    private final ThreadFactory f3339d;

    public ao(String str) {
        this(str, 0);
    }

    public ao(String str, int i) {
        this.f3338c = new AtomicInteger();
        this.f3339d = Executors.defaultThreadFactory();
        this.f3336a = (String) C1314c.m4624a((Object) str, (Object) "Name must not be null");
        this.f3337b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3339d.newThread(new ap(runnable, this.f3337b));
        String str = this.f3336a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f3338c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
