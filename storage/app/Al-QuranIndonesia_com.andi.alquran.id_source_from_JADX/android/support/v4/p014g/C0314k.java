package android.support.v4.p014g;

/* renamed from: android.support.v4.g.k */
public class C0314k<E> implements Cloneable {
    private static final Object f658a;
    private boolean f659b;
    private int[] f660c;
    private Object[] f661d;
    private int f662e;

    static {
        f658a = new Object();
    }

    public C0314k() {
        this(10);
    }

    public C0314k(int i) {
        this.f659b = false;
        if (i == 0) {
            this.f660c = C0299b.f631a;
            this.f661d = C0299b.f633c;
        } else {
            int a = C0299b.m1007a(i);
            this.f660c = new int[a];
            this.f661d = new Object[a];
        }
        this.f662e = 0;
    }

    private void m1036d() {
        int i = this.f662e;
        int[] iArr = this.f660c;
        Object[] objArr = this.f661d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f658a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f659b = false;
        this.f662e = i2;
    }

    public C0314k<E> m1037a() {
        try {
            C0314k<E> c0314k = (C0314k) super.clone();
            try {
                c0314k.f660c = (int[]) this.f660c.clone();
                c0314k.f661d = (Object[]) this.f661d.clone();
                return c0314k;
            } catch (CloneNotSupportedException e) {
                return c0314k;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1038a(int i) {
        return m1039a(i, null);
    }

    public E m1039a(int i, E e) {
        int a = C0299b.m1008a(this.f660c, this.f662e, i);
        return (a < 0 || this.f661d[a] == f658a) ? e : this.f661d[a];
    }

    public int m1040b() {
        if (this.f659b) {
            m1036d();
        }
        return this.f662e;
    }

    public void m1041b(int i) {
        int a = C0299b.m1008a(this.f660c, this.f662e, i);
        if (a >= 0 && this.f661d[a] != f658a) {
            this.f661d[a] = f658a;
            this.f659b = true;
        }
    }

    public void m1042b(int i, E e) {
        int a = C0299b.m1008a(this.f660c, this.f662e, i);
        if (a >= 0) {
            this.f661d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f662e || this.f661d[a] != f658a) {
            if (this.f659b && this.f662e >= this.f660c.length) {
                m1036d();
                a = C0299b.m1008a(this.f660c, this.f662e, i) ^ -1;
            }
            if (this.f662e >= this.f660c.length) {
                int a2 = C0299b.m1007a(this.f662e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f660c, 0, obj, 0, this.f660c.length);
                System.arraycopy(this.f661d, 0, obj2, 0, this.f661d.length);
                this.f660c = obj;
                this.f661d = obj2;
            }
            if (this.f662e - a != 0) {
                System.arraycopy(this.f660c, a, this.f660c, a + 1, this.f662e - a);
                System.arraycopy(this.f661d, a, this.f661d, a + 1, this.f662e - a);
            }
            this.f660c[a] = i;
            this.f661d[a] = e;
            this.f662e++;
            return;
        }
        this.f660c[a] = i;
        this.f661d[a] = e;
    }

    public void m1043c() {
        int i = this.f662e;
        Object[] objArr = this.f661d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f662e = 0;
        this.f659b = false;
    }

    public void m1044c(int i) {
        m1041b(i);
    }

    public /* synthetic */ Object clone() {
        return m1037a();
    }

    public void m1045d(int i) {
        if (this.f661d[i] != f658a) {
            this.f661d[i] = f658a;
            this.f659b = true;
        }
    }

    public int m1046e(int i) {
        if (this.f659b) {
            m1036d();
        }
        return this.f660c[i];
    }

    public E m1047f(int i) {
        if (this.f659b) {
            m1036d();
        }
        return this.f661d[i];
    }

    public int m1048g(int i) {
        if (this.f659b) {
            m1036d();
        }
        return C0299b.m1008a(this.f660c, this.f662e, i);
    }

    public String toString() {
        if (m1040b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f662e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f662e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1046e(i));
            stringBuilder.append('=');
            C0314k f = m1047f(i);
            if (f != this) {
                stringBuilder.append(f);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
