package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@op
public class sk<T> implements sn<T> {
    private final Object f4765a;
    private T f4766b;
    private Throwable f4767c;
    private boolean f4768d;
    private boolean f4769e;
    private final so f4770f;

    public sk() {
        this.f4765a = new Object();
        this.f4770f = new so();
    }

    private boolean m7301a() {
        return this.f4767c != null || this.f4768d;
    }

    public void m7302a(Runnable runnable) {
        this.f4770f.m8721a(runnable);
    }

    public void m7303a(Throwable th) {
        synchronized (this.f4765a) {
            if (this.f4769e) {
            } else if (m7301a()) {
                zzv.zzcN().m8399a(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideException");
            } else {
                this.f4767c = th;
                this.f4765a.notifyAll();
                this.f4770f.m8720a();
            }
        }
    }

    public void m7304b(T t) {
        synchronized (this.f4765a) {
            if (this.f4769e) {
            } else if (m7301a()) {
                zzv.zzcN().m8399a(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideValue");
            } else {
                this.f4768d = true;
                this.f4766b = t;
                this.f4765a.notifyAll();
                this.f4770f.m8720a();
            }
        }
    }

    public void m7305b(Runnable runnable) {
        this.f4770f.m8722b(runnable);
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f4765a) {
            if (m7301a()) {
                return false;
            }
            this.f4769e = true;
            this.f4768d = true;
            this.f4765a.notifyAll();
            this.f4770f.m8720a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f4765a) {
            if (!m7301a()) {
                try {
                    this.f4765a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f4767c != null) {
                throw new ExecutionException(this.f4767c);
            } else if (this.f4769e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f4766b;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f4765a) {
            if (!m7301a()) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.f4765a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f4767c != null) {
                throw new ExecutionException(this.f4767c);
            } else if (!this.f4768d) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f4769e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f4766b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f4765a) {
            z = this.f4769e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f4765a) {
            a = m7301a();
        }
        return a;
    }
}
