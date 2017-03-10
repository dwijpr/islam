package android.support.v4.view.p015a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p015a.C0419i.C0410a;
import android.support.v4.view.p015a.C0421j.C0414a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.h */
public class C0417h {
    private static final C0409a f863a;
    private final Object f864b;

    /* renamed from: android.support.v4.view.a.h.a */
    interface C0409a {
        Object m1561a(C0417h c0417h);
    }

    /* renamed from: android.support.v4.view.a.h.d */
    static class C0412d implements C0409a {
        C0412d() {
        }

        public Object m1568a(C0417h c0417h) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.a.h.b */
    private static class C0413b extends C0412d {

        /* renamed from: android.support.v4.view.a.h.b.1 */
        class C04111 implements C0410a {
            final /* synthetic */ C0417h f859a;
            final /* synthetic */ C0413b f860b;

            C04111(C0413b c0413b, C0417h c0417h) {
                this.f860b = c0413b;
                this.f859a = c0417h;
            }

            public Object m1565a(int i) {
                C0404c a = this.f859a.m1579a(i);
                return a == null ? null : a.m1502a();
            }

            public List<Object> m1566a(String str, int i) {
                List a = this.f859a.m1581a(str, i);
                if (a == null) {
                    return null;
                }
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((C0404c) a.get(i2)).m1502a());
                }
                return arrayList;
            }

            public boolean m1567a(int i, int i2, Bundle bundle) {
                return this.f859a.m1582a(i, i2, bundle);
            }
        }

        C0413b() {
        }

        public Object m1569a(C0417h c0417h) {
            return C0419i.m1584a(new C04111(this, c0417h));
        }
    }

    /* renamed from: android.support.v4.view.a.h.c */
    private static class C0416c extends C0412d {

        /* renamed from: android.support.v4.view.a.h.c.1 */
        class C04151 implements C0414a {
            final /* synthetic */ C0417h f861a;
            final /* synthetic */ C0416c f862b;

            C04151(C0416c c0416c, C0417h c0417h) {
                this.f862b = c0416c;
                this.f861a = c0417h;
            }

            public Object m1574a(int i) {
                C0404c a = this.f861a.m1579a(i);
                return a == null ? null : a.m1502a();
            }

            public List<Object> m1575a(String str, int i) {
                List a = this.f861a.m1581a(str, i);
                if (a == null) {
                    return null;
                }
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((C0404c) a.get(i2)).m1502a());
                }
                return arrayList;
            }

            public boolean m1576a(int i, int i2, Bundle bundle) {
                return this.f861a.m1582a(i, i2, bundle);
            }

            public Object m1577b(int i) {
                C0404c b = this.f861a.m1583b(i);
                return b == null ? null : b.m1502a();
            }
        }

        C0416c() {
        }

        public Object m1578a(C0417h c0417h) {
            return C0421j.m1585a(new C04151(this, c0417h));
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f863a = new C0416c();
        } else if (VERSION.SDK_INT >= 16) {
            f863a = new C0413b();
        } else {
            f863a = new C0412d();
        }
    }

    public C0417h() {
        this.f864b = f863a.m1561a(this);
    }

    public C0417h(Object obj) {
        this.f864b = obj;
    }

    public C0404c m1579a(int i) {
        return null;
    }

    public Object m1580a() {
        return this.f864b;
    }

    public List<C0404c> m1581a(String str, int i) {
        return null;
    }

    public boolean m1582a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0404c m1583b(int i) {
        return null;
    }
}
