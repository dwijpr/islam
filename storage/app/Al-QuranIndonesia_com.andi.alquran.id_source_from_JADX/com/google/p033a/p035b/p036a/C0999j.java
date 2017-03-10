package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.C1082p;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* renamed from: com.google.a.b.a.j */
public final class C0999j extends C0976r<Date> {
    public static final C0974s f2047a;
    private final DateFormat f2048b;

    /* renamed from: com.google.a.b.a.j.1 */
    static class C09981 implements C0974s {
        C09981() {
        }

        public <T> C0976r<T> m3550a(C1073e c1073e, C1061a<T> c1061a) {
            return c1061a.m3772a() == Date.class ? new C0999j() : null;
        }
    }

    static {
        f2047a = new C09981();
    }

    public C0999j() {
        this.f2048b = new SimpleDateFormat("MMM d, yyyy");
    }

    public synchronized Date m3551a(C0984a c0984a) {
        Date date;
        if (c0984a.m3453f() == C1063b.NULL) {
            c0984a.m3457j();
            date = null;
        } else {
            try {
                date = new Date(this.f2048b.parse(c0984a.m3455h()).getTime());
            } catch (Throwable e) {
                throw new C1082p(e);
            }
        }
        return date;
    }

    public synchronized void m3553a(C0987c c0987c, Date date) {
        c0987c.m3497b(date == null ? null : this.f2048b.format(date));
    }

    public /* synthetic */ Object m3554b(C0984a c0984a) {
        return m3551a(c0984a);
    }
}
