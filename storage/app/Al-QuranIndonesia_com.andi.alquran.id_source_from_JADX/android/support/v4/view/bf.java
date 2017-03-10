package android.support.v4.view;

import android.os.Build.VERSION;

public class bf {
    private static final C0483d f913a;
    private final Object f914b;

    /* renamed from: android.support.v4.view.bf.d */
    private interface C0483d {
        int m2092a(Object obj);

        bf m2093a(Object obj, int i, int i2, int i3, int i4);

        int m2094b(Object obj);

        int m2095c(Object obj);

        int m2096d(Object obj);

        boolean m2097e(Object obj);
    }

    /* renamed from: android.support.v4.view.bf.c */
    private static class C0484c implements C0483d {
        C0484c() {
        }

        public int m2098a(Object obj) {
            return 0;
        }

        public bf m2099a(Object obj, int i, int i2, int i3, int i4) {
            return null;
        }

        public int m2100b(Object obj) {
            return 0;
        }

        public int m2101c(Object obj) {
            return 0;
        }

        public int m2102d(Object obj) {
            return 0;
        }

        public boolean m2103e(Object obj) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.bf.a */
    private static class C0485a extends C0484c {
        C0485a() {
        }

        public int m2104a(Object obj) {
            return bg.m2118a(obj);
        }

        public bf m2105a(Object obj, int i, int i2, int i3, int i4) {
            return new bf(bg.m2119a(obj, i, i2, i3, i4));
        }

        public int m2106b(Object obj) {
            return bg.m2120b(obj);
        }

        public int m2107c(Object obj) {
            return bg.m2121c(obj);
        }

        public int m2108d(Object obj) {
            return bg.m2122d(obj);
        }
    }

    /* renamed from: android.support.v4.view.bf.b */
    private static class C0486b extends C0485a {
        C0486b() {
        }

        public boolean m2109e(Object obj) {
            return bh.m2123a(obj);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f913a = new C0486b();
        } else if (i >= 20) {
            f913a = new C0485a();
        } else {
            f913a = new C0484c();
        }
    }

    bf(Object obj) {
        this.f914b = obj;
    }

    static bf m2110a(Object obj) {
        return obj == null ? null : new bf(obj);
    }

    static Object m2111a(bf bfVar) {
        return bfVar == null ? null : bfVar.f914b;
    }

    public int m2112a() {
        return f913a.m2094b(this.f914b);
    }

    public bf m2113a(int i, int i2, int i3, int i4) {
        return f913a.m2093a(this.f914b, i, i2, i3, i4);
    }

    public int m2114b() {
        return f913a.m2096d(this.f914b);
    }

    public int m2115c() {
        return f913a.m2095c(this.f914b);
    }

    public int m2116d() {
        return f913a.m2092a(this.f914b);
    }

    public boolean m2117e() {
        return f913a.m2097e(this.f914b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bf bfVar = (bf) obj;
        return this.f914b == null ? bfVar.f914b == null : this.f914b.equals(bfVar.f914b);
    }

    public int hashCode() {
        return this.f914b == null ? 0 : this.f914b.hashCode();
    }
}
