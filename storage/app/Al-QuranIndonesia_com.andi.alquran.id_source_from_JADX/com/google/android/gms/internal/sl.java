package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@op
public class sl<T> implements sn<T> {
    private final T f5839a;
    private final so f5840b;

    public sl(T t) {
        this.f5839a = t;
        this.f5840b = new so();
        this.f5840b.m8720a();
    }

    public void m8713a(Runnable runnable) {
        this.f5840b.m8721a(runnable);
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.f5839a;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.f5839a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
