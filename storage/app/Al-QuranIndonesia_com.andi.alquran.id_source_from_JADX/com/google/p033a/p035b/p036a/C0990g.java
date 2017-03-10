package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.C1075i;
import com.google.p033a.C1081n;
import com.google.p033a.C1082p;
import com.google.p033a.p035b.C1019b;
import com.google.p033a.p035b.C1020h;
import com.google.p033a.p035b.C1030c;
import com.google.p033a.p035b.C1033e;
import com.google.p033a.p035b.C1047j;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.a.b.a.g */
public final class C0990g implements C0974s {
    private final C1030c f2028a;
    private final boolean f2029b;

    /* renamed from: com.google.a.b.a.g.a */
    private final class C0989a<K, V> extends C0976r<Map<K, V>> {
        final /* synthetic */ C0990g f2024a;
        private final C0976r<K> f2025b;
        private final C0976r<V> f2026c;
        private final C1020h<? extends Map<K, V>> f2027d;

        public C0989a(C0990g c0990g, C1073e c1073e, Type type, C0976r<K> c0976r, Type type2, C0976r<V> c0976r2, C1020h<? extends Map<K, V>> c1020h) {
            this.f2024a = c0990g;
            this.f2025b = new C1002l(c1073e, c0976r, type);
            this.f2026c = new C1002l(c1073e, c0976r2, type2);
            this.f2027d = c1020h;
        }

        private String m3522a(C1075i c1075i) {
            if (c1075i.m3816i()) {
                C1081n m = c1075i.m3820m();
                if (m.m3842p()) {
                    return String.valueOf(m.m3833a());
                }
                if (m.m3841o()) {
                    return Boolean.toString(m.m3839f());
                }
                if (m.m3843q()) {
                    return m.m3835b();
                }
                throw new AssertionError();
            } else if (c1075i.m3817j()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public Map<K, V> m3523a(C0984a c0984a) {
            C1063b f = c0984a.m3453f();
            if (f == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            Map<K, V> map = (Map) this.f2027d.m3701a();
            Object b;
            if (f == C1063b.BEGIN_ARRAY) {
                c0984a.m3447a();
                while (c0984a.m3452e()) {
                    c0984a.m3447a();
                    b = this.f2025b.m3406b(c0984a);
                    if (map.put(b, this.f2026c.m3406b(c0984a)) != null) {
                        throw new C1082p("duplicate key: " + b);
                    }
                    c0984a.m3449b();
                }
                c0984a.m3449b();
                return map;
            }
            c0984a.m3450c();
            while (c0984a.m3452e()) {
                C1033e.f2155a.m3731a(c0984a);
                b = this.f2025b.m3406b(c0984a);
                if (map.put(b, this.f2026c.m3406b(c0984a)) != null) {
                    throw new C1082p("duplicate key: " + b);
                }
            }
            c0984a.m3451d();
            return map;
        }

        public void m3525a(C0987c c0987c, Map<K, V> map) {
            int i = 0;
            if (map == null) {
                c0987c.m3505f();
            } else if (this.f2024a.f2029b) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    C1075i a = this.f2025b.m3404a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    int i3 = (a.m3814g() || a.m3815h()) ? 1 : 0;
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    c0987c.m3496b();
                    while (i < arrayList.size()) {
                        c0987c.m3496b();
                        C1047j.m3751a((C1075i) arrayList.get(i), c0987c);
                        this.f2026c.m3405a(c0987c, arrayList2.get(i));
                        c0987c.m3499c();
                        i++;
                    }
                    c0987c.m3499c();
                    return;
                }
                c0987c.m3502d();
                while (i < arrayList.size()) {
                    c0987c.m3494a(m3522a((C1075i) arrayList.get(i)));
                    this.f2026c.m3405a(c0987c, arrayList2.get(i));
                    i++;
                }
                c0987c.m3504e();
            } else {
                c0987c.m3502d();
                for (Entry entry2 : map.entrySet()) {
                    c0987c.m3494a(String.valueOf(entry2.getKey()));
                    this.f2026c.m3405a(c0987c, entry2.getValue());
                }
                c0987c.m3504e();
            }
        }

        public /* synthetic */ Object m3526b(C0984a c0984a) {
            return m3523a(c0984a);
        }
    }

    public C0990g(C1030c c1030c, boolean z) {
        this.f2028a = c1030c;
        this.f2029b = z;
    }

    private C0976r<?> m3527a(C1073e c1073e, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C1014m.f2092f : c1073e.m3797a(C1061a.m3769a(type));
    }

    public <T> C0976r<T> m3529a(C1073e c1073e, C1061a<T> c1061a) {
        Type b = c1061a.m3773b();
        if (!Map.class.isAssignableFrom(c1061a.m3772a())) {
            return null;
        }
        Type[] b2 = C1019b.m3693b(b, C1019b.m3696e(b));
        C0976r a = m3527a(c1073e, b2[0]);
        C0976r a2 = c1073e.m3797a(C1061a.m3769a(b2[1]));
        C1020h a3 = this.f2028a.m3717a((C1061a) c1061a);
        return new C0989a(this, c1073e, b2[0], a, b2[1], a2, a3);
    }
}
