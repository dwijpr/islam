package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.tn;
import com.google.android.gms.internal.ts;
import com.google.android.gms.internal.vp;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.analytics.o */
public final class C1236o {
    private static volatile C1236o f2891a;
    private final Context f2892b;
    private final List<Object> f2893c;
    private final C1228k f2894d;
    private final C1233a f2895e;
    private volatile tn f2896f;
    private UncaughtExceptionHandler f2897g;

    /* renamed from: com.google.android.gms.analytics.o.1 */
    class C12311 implements Runnable {
        final /* synthetic */ C1229l f2886a;
        final /* synthetic */ C1236o f2887b;

        C12311(C1236o c1236o, C1229l c1229l) {
            this.f2887b = c1236o;
            this.f2886a = c1229l;
        }

        public void run() {
            this.f2886a.m4354h().m4199a(this.f2886a);
            Iterator it = this.f2887b.f2893c.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f2887b.m4366b(this.f2886a);
        }
    }

    /* renamed from: com.google.android.gms.analytics.o.a */
    private class C1233a extends ThreadPoolExecutor {
        final /* synthetic */ C1236o f2889a;

        /* renamed from: com.google.android.gms.analytics.o.a.1 */
        class C12321 extends FutureTask<T> {
            final /* synthetic */ C1233a f2888a;

            C12321(C1233a c1233a, Runnable runnable, Object obj) {
                this.f2888a = c1233a;
                super(runnable, obj);
            }

            protected void setException(Throwable th) {
                UncaughtExceptionHandler b = this.f2888a.f2889a.f2897g;
                if (b != null) {
                    b.uncaughtException(Thread.currentThread(), th);
                } else if (Log.isLoggable("GAv4", 6)) {
                    String valueOf = String.valueOf(th);
                    Log.e("GAv4", new StringBuilder(String.valueOf(valueOf).length() + 37).append("MeasurementExecutor: job failed with ").append(valueOf).toString());
                }
                super.setException(th);
            }
        }

        public C1233a(C1236o c1236o) {
            this.f2889a = c1236o;
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new C1234b());
            allowCoreThreadTimeOut(true);
        }

        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new C12321(this, runnable, t);
        }
    }

    /* renamed from: com.google.android.gms.analytics.o.b */
    private static class C1234b implements ThreadFactory {
        private static final AtomicInteger f2890a;

        static {
            f2890a = new AtomicInteger();
        }

        private C1234b() {
        }

        public Thread newThread(Runnable runnable) {
            return new C1235c(runnable, "measurement-" + f2890a.incrementAndGet());
        }
    }

    /* renamed from: com.google.android.gms.analytics.o.c */
    private static class C1235c extends Thread {
        C1235c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    C1236o(Context context) {
        Object applicationContext = context.getApplicationContext();
        C1314c.m4623a(applicationContext);
        this.f2892b = applicationContext;
        this.f2895e = new C1233a(this);
        this.f2893c = new CopyOnWriteArrayList();
        this.f2894d = new C1228k();
    }

    public static C1236o m4362a(Context context) {
        C1314c.m4623a((Object) context);
        if (f2891a == null) {
            synchronized (C1236o.class) {
                if (f2891a == null) {
                    f2891a = new C1236o(context);
                }
            }
        }
        return f2891a;
    }

    private void m4366b(C1229l c1229l) {
        C1314c.m4635c("deliver should be called from worker thread");
        C1314c.m4633b(c1229l.m4352f(), "Measurement must be submitted");
        List<C1224p> c = c1229l.m4349c();
        if (!c.isEmpty()) {
            Set hashSet = new HashSet();
            for (C1224p c1224p : c) {
                Uri a = c1224p.m4316a();
                if (!hashSet.contains(a)) {
                    hashSet.add(a);
                    c1224p.m4317a(c1229l);
                }
            }
        }
    }

    public static void m4367d() {
        if (!(Thread.currentThread() instanceof C1235c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public tn m4368a() {
        if (this.f2896f == null) {
            synchronized (this) {
                if (this.f2896f == null) {
                    tn tnVar = new tn();
                    PackageManager packageManager = this.f2892b.getPackageManager();
                    String packageName = this.f2892b.getPackageName();
                    tnVar.m9002c(packageName);
                    tnVar.m9004d(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f2892b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        String str2 = "GAv4";
                        String str3 = "Error retrieving package info: appName set to ";
                        String valueOf = String.valueOf(packageName);
                        Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                    tnVar.m8998a(packageName);
                    tnVar.m9000b(str);
                    this.f2896f = tnVar;
                }
            }
        }
        return this.f2896f;
    }

    public <V> Future<V> m4369a(Callable<V> callable) {
        C1314c.m4623a((Object) callable);
        if (!(Thread.currentThread() instanceof C1235c)) {
            return this.f2895e.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    void m4370a(C1229l c1229l) {
        if (c1229l.m4356j()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (c1229l.m4352f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            C1229l a = c1229l.m4343a();
            a.m4353g();
            this.f2895e.execute(new C12311(this, a));
        }
    }

    public void m4371a(Runnable runnable) {
        C1314c.m4623a((Object) runnable);
        this.f2895e.submit(runnable);
    }

    public void m4372a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f2897g = uncaughtExceptionHandler;
    }

    public ts m4373b() {
        DisplayMetrics displayMetrics = this.f2892b.getResources().getDisplayMetrics();
        ts tsVar = new ts();
        tsVar.m9042a(vp.m9509a(Locale.getDefault()));
        tsVar.m9044b(displayMetrics.widthPixels);
        tsVar.m9046c(displayMetrics.heightPixels);
        return tsVar;
    }

    public Context m4374c() {
        return this.f2892b;
    }
}
