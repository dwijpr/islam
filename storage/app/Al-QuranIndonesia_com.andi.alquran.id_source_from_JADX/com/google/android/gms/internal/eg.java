package com.google.android.gms.internal;

import java.io.IOException;

public abstract class eg {
    protected volatile int ah;

    public eg() {
        this.ah = -1;
    }

    public static final <T extends eg> T m5146a(T t, byte[] bArr) {
        return m5149b(t, bArr, 0, bArr.length);
    }

    public static final void m5147a(eg egVar, byte[] bArr, int i, int i2) {
        try {
            dz a = dz.m5804a(bArr, i, i2);
            egVar.m5150a(a);
            a.m5841b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m5148a(eg egVar) {
        byte[] bArr = new byte[egVar.m5155g()];
        m5147a(egVar, bArr, 0, bArr.length);
        return bArr;
    }

    public static final <T extends eg> T m5149b(T t, byte[] bArr, int i, int i2) {
        try {
            dy a = dy.m5773a(bArr, i, i2);
            t.m5152b(a);
            a.m5776a(0);
            return t;
        } catch (ef e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public void m5150a(dz dzVar) {
    }

    protected int m5151b() {
        return 0;
    }

    public abstract eg m5152b(dy dyVar);

    public /* synthetic */ Object clone() {
        return m5153e();
    }

    public eg m5153e() {
        return (eg) super.clone();
    }

    public int m5154f() {
        if (this.ah < 0) {
            m5155g();
        }
        return this.ah;
    }

    public int m5155g() {
        int b = m5151b();
        this.ah = b;
        return b;
    }

    public String toString() {
        return eh.m5913a(this);
    }
}
