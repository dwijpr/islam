package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class an implements Executor {
    private final Handler f3335a;

    public an(Looper looper) {
        this.f3335a = new Handler(looper);
    }

    public void execute(Runnable runnable) {
        this.f3335a.post(runnable);
    }
}
