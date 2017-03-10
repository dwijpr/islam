package android.support.v4.view.p015a;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.a.k */
public class C0427k {
    private static final C0422c f867a;
    private final Object f868b;

    /* renamed from: android.support.v4.view.a.k.c */
    interface C0422c {
        void m1586a(Object obj, int i);

        void m1587a(Object obj, boolean z);

        void m1588b(Object obj, int i);

        void m1589c(Object obj, int i);

        void m1590d(Object obj, int i);

        void m1591e(Object obj, int i);

        void m1592f(Object obj, int i);

        void m1593g(Object obj, int i);
    }

    /* renamed from: android.support.v4.view.a.k.e */
    static class C0423e implements C0422c {
        C0423e() {
        }

        public void m1594a(Object obj, int i) {
        }

        public void m1595a(Object obj, boolean z) {
        }

        public void m1596b(Object obj, int i) {
        }

        public void m1597c(Object obj, int i) {
        }

        public void m1598d(Object obj, int i) {
        }

        public void m1599e(Object obj, int i) {
        }

        public void m1600f(Object obj, int i) {
        }

        public void m1601g(Object obj, int i) {
        }
    }

    /* renamed from: android.support.v4.view.a.k.a */
    static class C0424a extends C0423e {
        C0424a() {
        }

        public void m1602a(Object obj, int i) {
            C0428l.m1618a(obj, i);
        }

        public void m1603a(Object obj, boolean z) {
            C0428l.m1619a(obj, z);
        }

        public void m1604b(Object obj, int i) {
            C0428l.m1620b(obj, i);
        }

        public void m1605c(Object obj, int i) {
            C0428l.m1621c(obj, i);
        }

        public void m1606d(Object obj, int i) {
            C0428l.m1622d(obj, i);
        }

        public void m1607e(Object obj, int i) {
            C0428l.m1623e(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.a.k.b */
    static class C0425b extends C0424a {
        C0425b() {
        }

        public void m1608f(Object obj, int i) {
            C0429m.m1624a(obj, i);
        }

        public void m1609g(Object obj, int i) {
            C0429m.m1625b(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.a.k.d */
    static class C0426d extends C0425b {
        C0426d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f867a = new C0426d();
        } else if (VERSION.SDK_INT >= 15) {
            f867a = new C0425b();
        } else if (VERSION.SDK_INT >= 14) {
            f867a = new C0424a();
        } else {
            f867a = new C0423e();
        }
    }

    @Deprecated
    public C0427k(Object obj) {
        this.f868b = obj;
    }

    public void m1610a(int i) {
        f867a.m1588b(this.f868b, i);
    }

    public void m1611a(boolean z) {
        f867a.m1587a(this.f868b, z);
    }

    public void m1612b(int i) {
        f867a.m1586a(this.f868b, i);
    }

    public void m1613c(int i) {
        f867a.m1591e(this.f868b, i);
    }

    public void m1614d(int i) {
        f867a.m1589c(this.f868b, i);
    }

    public void m1615e(int i) {
        f867a.m1590d(this.f868b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0427k c0427k = (C0427k) obj;
        return this.f868b == null ? c0427k.f868b == null : this.f868b.equals(c0427k.f868b);
    }

    public void m1616f(int i) {
        f867a.m1592f(this.f868b, i);
    }

    public void m1617g(int i) {
        f867a.m1593g(this.f868b, i);
    }

    public int hashCode() {
        return this.f868b == null ? 0 : this.f868b.hashCode();
    }
}
