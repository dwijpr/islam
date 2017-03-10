package android.support.v4.p014g;

/* renamed from: android.support.v4.g.e */
public class C0302e<E> implements Cloneable {
    private static final Object f636a;
    private boolean f637b;
    private long[] f638c;
    private Object[] f639d;
    private int f640e;

    static {
        f636a = new Object();
    }

    public C0302e() {
        this(10);
    }

    public C0302e(int i) {
        this.f637b = false;
        if (i == 0) {
            this.f638c = C0299b.f632b;
            this.f639d = C0299b.f633c;
        } else {
            int b = C0299b.m1011b(i);
            this.f638c = new long[b];
            this.f639d = new Object[b];
        }
        this.f640e = 0;
    }

    private void m1015d() {
        int i = this.f640e;
        long[] jArr = this.f638c;
        Object[] objArr = this.f639d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f636a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f637b = false;
        this.f640e = i2;
    }

    public C0302e<E> m1016a() {
        try {
            C0302e<E> c0302e = (C0302e) super.clone();
            try {
                c0302e.f638c = (long[]) this.f638c.clone();
                c0302e.f639d = (Object[]) this.f639d.clone();
                return c0302e;
            } catch (CloneNotSupportedException e) {
                return c0302e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1017a(long j) {
        return m1018a(j, null);
    }

    public E m1018a(long j, E e) {
        int a = C0299b.m1009a(this.f638c, this.f640e, j);
        return (a < 0 || this.f639d[a] == f636a) ? e : this.f639d[a];
    }

    public void m1019a(int i) {
        if (this.f639d[i] != f636a) {
            this.f639d[i] = f636a;
            this.f637b = true;
        }
    }

    public int m1020b() {
        if (this.f637b) {
            m1015d();
        }
        return this.f640e;
    }

    public long m1021b(int i) {
        if (this.f637b) {
            m1015d();
        }
        return this.f638c[i];
    }

    public void m1022b(long j) {
        int a = C0299b.m1009a(this.f638c, this.f640e, j);
        if (a >= 0 && this.f639d[a] != f636a) {
            this.f639d[a] = f636a;
            this.f637b = true;
        }
    }

    public void m1023b(long j, E e) {
        int a = C0299b.m1009a(this.f638c, this.f640e, j);
        if (a >= 0) {
            this.f639d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f640e || this.f639d[a] != f636a) {
            if (this.f637b && this.f640e >= this.f638c.length) {
                m1015d();
                a = C0299b.m1009a(this.f638c, this.f640e, j) ^ -1;
            }
            if (this.f640e >= this.f638c.length) {
                int b = C0299b.m1011b(this.f640e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f638c, 0, obj, 0, this.f638c.length);
                System.arraycopy(this.f639d, 0, obj2, 0, this.f639d.length);
                this.f638c = obj;
                this.f639d = obj2;
            }
            if (this.f640e - a != 0) {
                System.arraycopy(this.f638c, a, this.f638c, a + 1, this.f640e - a);
                System.arraycopy(this.f639d, a, this.f639d, a + 1, this.f640e - a);
            }
            this.f638c[a] = j;
            this.f639d[a] = e;
            this.f640e++;
            return;
        }
        this.f638c[a] = j;
        this.f639d[a] = e;
    }

    public E m1024c(int i) {
        if (this.f637b) {
            m1015d();
        }
        return this.f639d[i];
    }

    public void m1025c() {
        int i = this.f640e;
        Object[] objArr = this.f639d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f640e = 0;
        this.f637b = false;
    }

    public /* synthetic */ Object clone() {
        return m1016a();
    }

    public String toString() {
        if (m1020b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f640e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f640e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1021b(i));
            stringBuilder.append('=');
            C0302e c = m1024c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
