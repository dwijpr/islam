package com.google.p033a.p035b.p036a;

import com.google.p033a.C1075i;
import com.google.p033a.C1076g;
import com.google.p033a.C1079k;
import com.google.p033a.C1080l;
import com.google.p033a.C1081n;
import com.google.p033a.p037d.C0987c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.a.b.a.f */
public final class C0988f extends C0987c {
    private static final Writer f2019a;
    private static final C1081n f2020b;
    private final List<C1075i> f2021c;
    private String f2022d;
    private C1075i f2023e;

    /* renamed from: com.google.a.b.a.f.1 */
    static class C09861 extends Writer {
        C09861() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    static {
        f2019a = new C09861();
        f2020b = new C1081n("closed");
    }

    public C0988f() {
        super(f2019a);
        this.f2021c = new ArrayList();
        this.f2023e = C1079k.f2230a;
    }

    private void m3509a(C1075i c1075i) {
        if (this.f2022d != null) {
            if (!c1075i.m3817j() || m3508i()) {
                ((C1080l) m3510j()).m3829a(this.f2022d, c1075i);
            }
            this.f2022d = null;
        } else if (this.f2021c.isEmpty()) {
            this.f2023e = c1075i;
        } else {
            C1075i j = m3510j();
            if (j instanceof C1076g) {
                ((C1076g) j).m3823a(c1075i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private C1075i m3510j() {
        return (C1075i) this.f2021c.get(this.f2021c.size() - 1);
    }

    public C0987c m3511a(long j) {
        m3509a(new C1081n(Long.valueOf(j)));
        return this;
    }

    public C0987c m3512a(Number number) {
        if (number == null) {
            return m3521f();
        }
        if (!m3506g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m3509a(new C1081n(number));
        return this;
    }

    public C0987c m3513a(String str) {
        if (this.f2021c.isEmpty() || this.f2022d != null) {
            throw new IllegalStateException();
        } else if (m3510j() instanceof C1080l) {
            this.f2022d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0987c m3514a(boolean z) {
        m3509a(new C1081n(Boolean.valueOf(z)));
        return this;
    }

    public C1075i m3515a() {
        if (this.f2021c.isEmpty()) {
            return this.f2023e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f2021c);
    }

    public C0987c m3516b() {
        C1075i c1076g = new C1076g();
        m3509a(c1076g);
        this.f2021c.add(c1076g);
        return this;
    }

    public C0987c m3517b(String str) {
        if (str == null) {
            return m3521f();
        }
        m3509a(new C1081n(str));
        return this;
    }

    public C0987c m3518c() {
        if (this.f2021c.isEmpty() || this.f2022d != null) {
            throw new IllegalStateException();
        } else if (m3510j() instanceof C1076g) {
            this.f2021c.remove(this.f2021c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (this.f2021c.isEmpty()) {
            this.f2021c.add(f2020b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public C0987c m3519d() {
        C1075i c1080l = new C1080l();
        m3509a(c1080l);
        this.f2021c.add(c1080l);
        return this;
    }

    public C0987c m3520e() {
        if (this.f2021c.isEmpty() || this.f2022d != null) {
            throw new IllegalStateException();
        } else if (m3510j() instanceof C1080l) {
            this.f2021c.remove(this.f2021c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0987c m3521f() {
        m3509a(C1079k.f2230a);
        return this;
    }

    public void flush() {
    }
}
