package com.google.p033a;

import com.google.p033a.p035b.C1047j;
import com.google.p033a.p037d.C0987c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: com.google.a.i */
public abstract class C1075i {
    public Number m3808a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String m3809b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double m3810c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long m3811d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int m3812e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m3813f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m3814g() {
        return this instanceof C1076g;
    }

    public boolean m3815h() {
        return this instanceof C1080l;
    }

    public boolean m3816i() {
        return this instanceof C1081n;
    }

    public boolean m3817j() {
        return this instanceof C1079k;
    }

    public C1080l m3818k() {
        if (m3815h()) {
            return (C1080l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C1076g m3819l() {
        if (m3814g()) {
            return (C1076g) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public C1081n m3820m() {
        if (m3816i()) {
            return (C1081n) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean m3821n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            C0987c c0987c = new C0987c(stringWriter);
            c0987c.m3498b(true);
            C1047j.m3751a(this, c0987c);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
