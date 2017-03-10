package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.C1082p;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* renamed from: com.google.a.b.a.k */
public final class C1001k extends C0976r<Time> {
    public static final C0974s f2049a;
    private final DateFormat f2050b;

    /* renamed from: com.google.a.b.a.k.1 */
    static class C10001 implements C0974s {
        C10001() {
        }

        public <T> C0976r<T> m3555a(C1073e c1073e, C1061a<T> c1061a) {
            return c1061a.m3772a() == Time.class ? new C1001k() : null;
        }
    }

    static {
        f2049a = new C10001();
    }

    public C1001k() {
        this.f2050b = new SimpleDateFormat("hh:mm:ss a");
    }

    public synchronized Time m3556a(C0984a c0984a) {
        Time time;
        if (c0984a.m3453f() == C1063b.NULL) {
            c0984a.m3457j();
            time = null;
        } else {
            try {
                time = new Time(this.f2050b.parse(c0984a.m3455h()).getTime());
            } catch (Throwable e) {
                throw new C1082p(e);
            }
        }
        return time;
    }

    public synchronized void m3558a(C0987c c0987c, Time time) {
        c0987c.m3497b(time == null ? null : this.f2050b.format(time));
    }

    public /* synthetic */ Object m3559b(C0984a c0984a) {
        return m3556a(c0984a);
    }
}
