package com.google.android.gms.internal;

import com.andi.alquran.C0861R;
import com.google.android.gms.internal.aw.C1450a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class dh {

    /* renamed from: com.google.android.gms.internal.dh.a */
    public static class C1521a {
        private final Map<String, C1450a> f3779a;
        private final C1450a f3780b;

        public Map<String, C1450a> m5728a() {
            return Collections.unmodifiableMap(this.f3779a);
        }

        public void m5729a(String str, C1450a c1450a) {
            this.f3779a.put(str, c1450a);
        }

        public C1450a m5730b() {
            return this.f3780b;
        }

        public String toString() {
            String valueOf = String.valueOf(m5728a());
            String valueOf2 = String.valueOf(this.f3780b);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
        }
    }

    /* renamed from: com.google.android.gms.internal.dh.b */
    public static class C1522b {
        private final List<C1521a> f3781a;
        private final List<C1521a> f3782b;
        private final List<C1521a> f3783c;
        private final List<C1521a> f3784d;
        private final List<C1521a> f3785e;
        private final List<C1521a> f3786f;

        public List<C1521a> m5731a() {
            return this.f3781a;
        }

        public List<C1521a> m5732b() {
            return this.f3782b;
        }

        public List<C1521a> m5733c() {
            return this.f3783c;
        }

        public List<C1521a> m5734d() {
            return this.f3784d;
        }

        public List<C1521a> m5735e() {
            return this.f3785e;
        }

        public List<C1521a> m5736f() {
            return this.f3786f;
        }

        public String toString() {
            String valueOf = String.valueOf(m5731a());
            String valueOf2 = String.valueOf(m5732b());
            String valueOf3 = String.valueOf(m5733c());
            String valueOf4 = String.valueOf(m5734d());
            String valueOf5 = String.valueOf(m5735e());
            String valueOf6 = String.valueOf(m5736f());
            return new StringBuilder((((((String.valueOf(valueOf).length() + C0861R.styleable.AppCompatTheme_buttonStyle) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).append("  Add macros: ").append(valueOf5).append("  Remove macros: ").append(valueOf6).toString();
        }
    }

    public static C1450a m5737a(C1450a c1450a) {
        C1450a c1450a2 = new C1450a();
        c1450a2.f3503a = c1450a.f3503a;
        c1450a2.f3513k = (int[]) c1450a.f3513k.clone();
        if (c1450a.f3514l) {
            c1450a2.f3514l = c1450a.f3514l;
        }
        return c1450a2;
    }
}
