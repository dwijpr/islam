package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class ad {
    private static final ExecutorService f3278a;

    static {
        f3278a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ao("GAC_Transform"));
    }

    public static ExecutorService m5042a() {
        return f3278a;
    }
}
