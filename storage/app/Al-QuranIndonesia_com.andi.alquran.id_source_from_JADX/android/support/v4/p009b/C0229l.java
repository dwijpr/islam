package android.support.v4.p009b;

import android.support.v4.app.NotificationCompat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.b.l */
abstract class C0229l<Params, Progress, Result> {
    public static final Executor f556a;
    private static final ThreadFactory f557b;
    private static final BlockingQueue<Runnable> f558c;
    private static volatile Executor f559d;

    /* renamed from: android.support.v4.b.l.1 */
    static class C02281 implements ThreadFactory {
        private final AtomicInteger f555a;

        C02281() {
            this.f555a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f555a.getAndIncrement());
        }
    }

    static {
        f557b = new C02281();
        f558c = new LinkedBlockingQueue(10);
        f556a = new ThreadPoolExecutor(5, NotificationCompat.FLAG_HIGH_PRIORITY, 1, TimeUnit.SECONDS, f558c, f557b);
        f559d = f556a;
    }
}
