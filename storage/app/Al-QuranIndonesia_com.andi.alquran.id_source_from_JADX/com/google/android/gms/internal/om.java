package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.oo.C1877a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

@op
public class om implements oo {
    private static final Object f5257a;
    private static oo f5258b;
    private final Object f5259c;
    private final String f5260d;
    private final zzqa f5261e;
    private final WeakHashMap<Thread, Boolean> f5262f;

    /* renamed from: com.google.android.gms.internal.om.1 */
    class C18731 implements UncaughtExceptionHandler {
        final /* synthetic */ UncaughtExceptionHandler f5253a;
        final /* synthetic */ om f5254b;

        C18731(om omVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f5254b = omVar;
            this.f5253a = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                this.f5254b.m7929a(thread, th);
                if (this.f5253a != null) {
                    this.f5253a.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
                if (this.f5253a != null) {
                    this.f5253a.uncaughtException(thread, th);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.om.2 */
    class C18742 implements UncaughtExceptionHandler {
        final /* synthetic */ UncaughtExceptionHandler f5255a;
        final /* synthetic */ om f5256b;

        C18742(om omVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f5256b = omVar;
            this.f5255a = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                this.f5256b.m7929a(thread, th);
                if (this.f5255a != null) {
                    this.f5255a.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
                if (this.f5255a != null) {
                    this.f5255a.uncaughtException(thread, th);
                }
            }
        }
    }

    static {
        f5257a = new Object();
        f5258b = null;
    }

    om(String str, zzqa com_google_android_gms_internal_zzqa) {
        this.f5259c = new Object();
        this.f5262f = new WeakHashMap();
        this.f5260d = str;
        this.f5261e = com_google_android_gms_internal_zzqa;
        m7925b();
        m7924a();
    }

    public static oo m7923a(Context context, zzqa com_google_android_gms_internal_zzqa) {
        synchronized (f5257a) {
            if (f5258b == null) {
                if (((Boolean) C1648if.f4369g.m6682c()).booleanValue()) {
                    String str = "unknown";
                    try {
                        str = context.getApplicationContext().getPackageName();
                    } catch (Throwable th) {
                        sg.m8449e("Cannot obtain package name, proceeding.");
                    }
                    f5258b = new om(str, com_google_android_gms_internal_zzqa);
                } else {
                    f5258b = new C1877a();
                }
            }
        }
        return f5258b;
    }

    private void m7924a() {
        Thread.setDefaultUncaughtExceptionHandler(new C18731(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private void m7925b() {
        m7928a(Looper.getMainLooper().getThread());
    }

    private Throwable m7926c(Throwable th) {
        if (((Boolean) C1648if.f4370h.m6682c()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m7931a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (m7934b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    String m7927a(Class cls, Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzv.zzcJ().m8546e()).appendQueryParameter("js", this.f5261e.f6636b).appendQueryParameter("appid", this.f5260d).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", C1648if.m6703a())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "139965458").appendQueryParameter("rc", "dev").toString();
    }

    public void m7928a(Thread thread) {
        if (thread != null) {
            synchronized (this.f5259c) {
                this.f5262f.put(thread, Boolean.valueOf(true));
            }
            thread.setUncaughtExceptionHandler(new C18742(this, thread.getUncaughtExceptionHandler()));
        }
    }

    protected void m7929a(Thread thread, Throwable th) {
        if (m7932a(th)) {
            m7933b(th);
        }
    }

    public void m7930a(Throwable th, String str) {
        Throwable c = m7926c(th);
        if (c != null) {
            Class cls = th.getClass();
            List arrayList = new ArrayList();
            arrayList.add(m7927a(cls, c, str));
            zzv.zzcJ().m8519a(arrayList, zzv.zzcN().m8415i());
        }
    }

    protected boolean m7931a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) C1648if.f4371i.m6682c())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(op.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            sg.m8442a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean m7932a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m7931a(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void m7933b(Throwable th) {
        m7930a(th, BuildConfig.VERSION_NAME);
    }

    protected boolean m7934b(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }
}
