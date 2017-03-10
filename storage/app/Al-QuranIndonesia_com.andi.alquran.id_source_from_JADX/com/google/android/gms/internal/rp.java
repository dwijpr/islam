package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@op
public final class rp {
    private static final ThreadPoolExecutor f5745a;
    private static final ThreadPoolExecutor f5746b;

    /* renamed from: com.google.android.gms.internal.rp.1 */
    class C19541 implements Callable<Void> {
        final /* synthetic */ Runnable f5737a;

        C19541(Runnable runnable) {
            this.f5737a = runnable;
        }

        public Void m8469a() {
            this.f5737a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m8469a();
        }
    }

    /* renamed from: com.google.android.gms.internal.rp.2 */
    class C19552 implements Callable<Void> {
        final /* synthetic */ Runnable f5738a;

        C19552(Runnable runnable) {
            this.f5738a = runnable;
        }

        public Void m8470a() {
            this.f5738a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m8470a();
        }
    }

    /* renamed from: com.google.android.gms.internal.rp.3 */
    class C19563 implements Runnable {
        final /* synthetic */ sk f5739a;
        final /* synthetic */ Callable f5740b;

        C19563(sk skVar, Callable callable) {
            this.f5739a = skVar;
            this.f5740b = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.f5739a.m7304b(this.f5740b.call());
            } catch (Throwable e) {
                zzv.zzcN().m8399a(e, "AdThreadPool.submit");
                this.f5739a.m7303a(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.rp.4 */
    class C19574 implements Runnable {
        final /* synthetic */ sk f5741a;
        final /* synthetic */ Future f5742b;

        C19574(sk skVar, Future future) {
            this.f5741a = skVar;
            this.f5742b = future;
        }

        public void run() {
            if (this.f5741a.isCancelled()) {
                this.f5742b.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.rp.5 */
    class C19585 implements ThreadFactory {
        final /* synthetic */ String f5743a;
        private final AtomicInteger f5744b;

        C19585(String str) {
            this.f5743a = str;
            this.f5744b = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            String str = this.f5743a;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.f5744b.getAndIncrement()).toString());
        }
    }

    static {
        f5745a = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m8475a("Default"));
        f5746b = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m8475a("Loader"));
        f5745a.allowCoreThreadTimeOut(true);
        f5746b.allowCoreThreadTimeOut(true);
    }

    public static sn<Void> m8471a(int i, Runnable runnable) {
        return i == 1 ? m8474a(f5746b, new C19541(runnable)) : m8474a(f5745a, new C19552(runnable));
    }

    public static sn<Void> m8472a(Runnable runnable) {
        return m8471a(0, runnable);
    }

    public static <T> sn<T> m8473a(Callable<T> callable) {
        return m8474a(f5745a, (Callable) callable);
    }

    public static <T> sn<T> m8474a(ExecutorService executorService, Callable<T> callable) {
        Object skVar = new sk();
        try {
            skVar.m7305b(new C19574(skVar, executorService.submit(new C19563(skVar, callable))));
        } catch (Throwable e) {
            sg.m8447c("Thread execution is rejected.", e);
            skVar.cancel(true);
        }
        return skVar;
    }

    private static ThreadFactory m8475a(String str) {
        return new C19585(str);
    }
}
