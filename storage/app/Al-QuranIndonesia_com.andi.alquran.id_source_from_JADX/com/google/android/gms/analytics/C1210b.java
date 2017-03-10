package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C1218d.C1217a;
import com.google.android.gms.internal.vf;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.analytics.b */
public class C1210b implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f2821a;
    private final C1223g f2822b;
    private final Context f2823c;
    private C1209a f2824d;
    private C1215c f2825e;

    public C1210b(C1223g c1223g, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (c1223g == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.f2821a = uncaughtExceptionHandler;
            this.f2822b = c1223g;
            this.f2824d = new C1220f(context, new ArrayList());
            this.f2823c = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            vf.m9424a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    C1215c m4195a() {
        if (this.f2825e == null) {
            this.f2825e = C1215c.m4211a(this.f2823c);
        }
        return this.f2825e;
    }

    UncaughtExceptionHandler m4196b() {
        return this.f2821a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.f2824d != null) {
            str = this.f2824d.m4194a(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        vf.m9424a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f2822b.m4311a(new C1217a().m4232a(str).m4233a(true).m4234a());
        C1215c a = m4195a();
        a.m4228h();
        a.m4229i();
        if (this.f2821a != null) {
            vf.m9424a("Passing exception to the original handler");
            this.f2821a.uncaughtException(thread, th);
        }
    }
}
