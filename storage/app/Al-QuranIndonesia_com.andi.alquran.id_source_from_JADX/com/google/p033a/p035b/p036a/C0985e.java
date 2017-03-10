package com.google.p033a.p035b.p036a;

import com.google.p033a.C1076g;
import com.google.p033a.C1079k;
import com.google.p033a.C1080l;
import com.google.p033a.C1081n;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C1063b;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.a.b.a.e */
public final class C0985e extends C0984a {
    private static final Reader f2005a;
    private static final Object f2006b;
    private final List<Object> f2007c;

    /* renamed from: com.google.a.b.a.e.1 */
    static class C09831 extends Reader {
        C09831() {
        }

        public void close() {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    static {
        f2005a = new C09831();
        f2006b = new Object();
    }

    private void m3464a(C1063b c1063b) {
        if (m3472f() != c1063b) {
            throw new IllegalStateException("Expected " + c1063b + " but was " + m3472f());
        }
    }

    private Object m3465r() {
        return this.f2007c.get(this.f2007c.size() - 1);
    }

    private Object m3466s() {
        return this.f2007c.remove(this.f2007c.size() - 1);
    }

    public void m3467a() {
        m3464a(C1063b.BEGIN_ARRAY);
        this.f2007c.add(((C1076g) m3465r()).iterator());
    }

    public void m3468b() {
        m3464a(C1063b.END_ARRAY);
        m3466s();
        m3466s();
    }

    public void m3469c() {
        m3464a(C1063b.BEGIN_OBJECT);
        this.f2007c.add(((C1080l) m3465r()).m3830o().iterator());
    }

    public void close() {
        this.f2007c.clear();
        this.f2007c.add(f2006b);
    }

    public void m3470d() {
        m3464a(C1063b.END_OBJECT);
        m3466s();
        m3466s();
    }

    public boolean m3471e() {
        C1063b f = m3472f();
        return (f == C1063b.END_OBJECT || f == C1063b.END_ARRAY) ? false : true;
    }

    public C1063b m3472f() {
        if (this.f2007c.isEmpty()) {
            return C1063b.END_DOCUMENT;
        }
        Object r = m3465r();
        if (r instanceof Iterator) {
            boolean z = this.f2007c.get(this.f2007c.size() - 2) instanceof C1080l;
            Iterator it = (Iterator) r;
            if (!it.hasNext()) {
                return z ? C1063b.END_OBJECT : C1063b.END_ARRAY;
            } else {
                if (z) {
                    return C1063b.NAME;
                }
                this.f2007c.add(it.next());
                return m3472f();
            }
        } else if (r instanceof C1080l) {
            return C1063b.BEGIN_OBJECT;
        } else {
            if (r instanceof C1076g) {
                return C1063b.BEGIN_ARRAY;
            }
            if (r instanceof C1081n) {
                C1081n c1081n = (C1081n) r;
                if (c1081n.m3843q()) {
                    return C1063b.STRING;
                }
                if (c1081n.m3841o()) {
                    return C1063b.BOOLEAN;
                }
                if (c1081n.m3842p()) {
                    return C1063b.NUMBER;
                }
                throw new AssertionError();
            } else if (r instanceof C1079k) {
                return C1063b.NULL;
            } else {
                if (r == f2006b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public String m3473g() {
        m3464a(C1063b.NAME);
        Entry entry = (Entry) ((Iterator) m3465r()).next();
        this.f2007c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String m3474h() {
        C1063b f = m3472f();
        if (f == C1063b.STRING || f == C1063b.NUMBER) {
            return ((C1081n) m3466s()).m3835b();
        }
        throw new IllegalStateException("Expected " + C1063b.STRING + " but was " + f);
    }

    public boolean m3475i() {
        m3464a(C1063b.BOOLEAN);
        return ((C1081n) m3466s()).m3839f();
    }

    public void m3476j() {
        m3464a(C1063b.NULL);
        m3466s();
    }

    public double m3477k() {
        C1063b f = m3472f();
        if (f == C1063b.NUMBER || f == C1063b.STRING) {
            double c = ((C1081n) m3465r()).m3836c();
            if (m3462p() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                m3466s();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + C1063b.NUMBER + " but was " + f);
    }

    public long m3478l() {
        C1063b f = m3472f();
        if (f == C1063b.NUMBER || f == C1063b.STRING) {
            long d = ((C1081n) m3465r()).m3837d();
            m3466s();
            return d;
        }
        throw new IllegalStateException("Expected " + C1063b.NUMBER + " but was " + f);
    }

    public int m3479m() {
        C1063b f = m3472f();
        if (f == C1063b.NUMBER || f == C1063b.STRING) {
            int e = ((C1081n) m3465r()).m3838e();
            m3466s();
            return e;
        }
        throw new IllegalStateException("Expected " + C1063b.NUMBER + " but was " + f);
    }

    public void m3480n() {
        if (m3472f() == C1063b.NAME) {
            m3473g();
        } else {
            m3466s();
        }
    }

    public void m3481o() {
        m3464a(C1063b.NAME);
        Entry entry = (Entry) ((Iterator) m3465r()).next();
        this.f2007c.add(entry.getValue());
        this.f2007c.add(new C1081n((String) entry.getKey()));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
