package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.b */
public final class C1313b {

    /* renamed from: com.google.android.gms.common.internal.b.a */
    public static final class C1312a {
        private final List<String> f3043a;
        private final Object f3044b;

        private C1312a(Object obj) {
            this.f3044b = C1314c.m4623a(obj);
            this.f3043a = new ArrayList();
        }

        public C1312a m4618a(String str, Object obj) {
            List list = this.f3043a;
            String str2 = (String) C1314c.m4623a((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f3044b.getClass().getSimpleName()).append('{');
            int size = this.f3043a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f3043a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m4619a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C1312a m4620a(Object obj) {
        return new C1312a(null);
    }

    public static boolean m4621a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
