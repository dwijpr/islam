package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.C1082p;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.a.b.a.c */
public final class C0981c extends C0976r<Date> {
    public static final C0974s f1984a;
    private final DateFormat f1985b;
    private final DateFormat f1986c;
    private final DateFormat f1987d;

    /* renamed from: com.google.a.b.a.c.1 */
    static class C09801 implements C0974s {
        C09801() {
        }

        public <T> C0976r<T> m3414a(C1073e c1073e, C1061a<T> c1061a) {
            return c1061a.m3772a() == Date.class ? new C0981c() : null;
        }
    }

    static {
        f1984a = new C09801();
    }

    public C0981c() {
        this.f1985b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        this.f1986c = DateFormat.getDateTimeInstance(2, 2);
        this.f1987d = C0981c.m3415a();
    }

    private static DateFormat m3415a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date m3416a(String str) {
        Date parse;
        try {
            parse = this.f1986c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f1985b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f1987d.parse(str);
                } catch (Throwable e3) {
                    throw new C1082p(str, e3);
                }
            }
        }
        return parse;
    }

    public Date m3417a(C0984a c0984a) {
        if (c0984a.m3453f() != C1063b.NULL) {
            return m3416a(c0984a.m3455h());
        }
        c0984a.m3457j();
        return null;
    }

    public synchronized void m3419a(C0987c c0987c, Date date) {
        if (date == null) {
            c0987c.m3505f();
        } else {
            c0987c.m3497b(this.f1985b.format(date));
        }
    }

    public /* synthetic */ Object m3420b(C0984a c0984a) {
        return m3417a(c0984a);
    }
}
