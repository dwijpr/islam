package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class uj {
    public static String f6091a;
    public static boolean f6092b;

    /* renamed from: com.google.android.gms.internal.uj.a */
    static class C2027a {
        public static final boolean f6088a;
        private final List<C2026a> f6089b;
        private boolean f6090c;

        /* renamed from: com.google.android.gms.internal.uj.a.a */
        private static class C2026a {
            public final String f6085a;
            public final long f6086b;
            public final long f6087c;

            public C2026a(String str, long j, long j2) {
                this.f6085a = str;
                this.f6086b = j;
                this.f6087c = j2;
            }
        }

        static {
            f6088a = uj.f6092b;
        }

        C2027a() {
            this.f6089b = new ArrayList();
            this.f6090c = false;
        }

        private long m9224a() {
            if (this.f6089b.size() == 0) {
                return 0;
            }
            return ((C2026a) this.f6089b.get(this.f6089b.size() - 1)).f6087c - ((C2026a) this.f6089b.get(0)).f6087c;
        }

        public synchronized void m9225a(String str) {
            this.f6090c = true;
            if (m9224a() > 0) {
                long j = ((C2026a) this.f6089b.get(0)).f6087c;
                uj.m9229b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C2026a c2026a : this.f6089b) {
                    uj.m9229b("(+%-4d) [%2d] %s", Long.valueOf(c2026a.f6087c - j2), Long.valueOf(c2026a.f6086b), c2026a.f6085a);
                    j2 = c2026a.f6087c;
                }
            }
        }

        public synchronized void m9226a(String str, long j) {
            if (this.f6090c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6089b.add(new C2026a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f6090c) {
                m9225a("Request on the loose");
                uj.m9230c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    static {
        f6091a = "Volley";
        f6092b = Log.isLoggable(f6091a, 2);
    }

    public static void m9227a(String str, Object... objArr) {
        if (f6092b) {
            Log.v(f6091a, m9231d(str, objArr));
        }
    }

    public static void m9228a(Throwable th, String str, Object... objArr) {
        Log.e(f6091a, m9231d(str, objArr), th);
    }

    public static void m9229b(String str, Object... objArr) {
        Log.d(f6091a, m9231d(str, objArr));
    }

    public static void m9230c(String str, Object... objArr) {
        Log.e(f6091a, m9231d(str, objArr));
    }

    private static String m9231d(String str, Object... objArr) {
        String valueOf;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(uj.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                valueOf = String.valueOf(stackTrace[i].getMethodName());
                valueOf = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append(".").append(valueOf).toString();
                break;
            }
        }
        valueOf = str2;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), valueOf, str});
    }
}
