package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1054d;
import com.google.p033a.C1073e;
import com.google.p033a.C1082p;
import com.google.p033a.p034a.C0969b;
import com.google.p033a.p034a.C0970c;
import com.google.p033a.p035b.C1019b;
import com.google.p033a.p035b.C1020h;
import com.google.p033a.p035b.C1030c;
import com.google.p033a.p035b.C1032d;
import com.google.p033a.p035b.C1043i;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.b.a.i */
public final class C0997i implements C0974s {
    private final C1030c f2044a;
    private final C1054d f2045b;
    private final C1032d f2046c;

    /* renamed from: com.google.a.b.a.i.b */
    static abstract class C0994b {
        final String f2033g;
        final boolean f2034h;
        final boolean f2035i;

        protected C0994b(String str, boolean z, boolean z2) {
            this.f2033g = str;
            this.f2034h = z;
            this.f2035i = z2;
        }

        abstract void m3533a(C0984a c0984a, Object obj);

        abstract void m3534a(C0987c c0987c, Object obj);

        abstract boolean m3535a(Object obj);
    }

    /* renamed from: com.google.a.b.a.i.1 */
    class C09951 extends C0994b {
        final C0976r<?> f2036a;
        final /* synthetic */ C1073e f2037b;
        final /* synthetic */ Field f2038c;
        final /* synthetic */ C1061a f2039d;
        final /* synthetic */ boolean f2040e;
        final /* synthetic */ C0997i f2041f;

        C09951(C0997i c0997i, String str, boolean z, boolean z2, C1073e c1073e, Field field, C1061a c1061a, boolean z3) {
            this.f2041f = c0997i;
            this.f2037b = c1073e;
            this.f2038c = field;
            this.f2039d = c1061a;
            this.f2040e = z3;
            super(str, z, z2);
            this.f2036a = this.f2041f.m3543a(this.f2037b, this.f2038c, this.f2039d);
        }

        void m3536a(C0984a c0984a, Object obj) {
            Object b = this.f2036a.m3406b(c0984a);
            if (b != null || !this.f2040e) {
                this.f2038c.set(obj, b);
            }
        }

        void m3537a(C0987c c0987c, Object obj) {
            new C1002l(this.f2037b, this.f2036a, this.f2039d.m3773b()).m3405a(c0987c, this.f2038c.get(obj));
        }

        public boolean m3538a(Object obj) {
            return this.h && this.f2038c.get(obj) != obj;
        }
    }

    /* renamed from: com.google.a.b.a.i.a */
    public static final class C0996a<T> extends C0976r<T> {
        private final C1020h<T> f2042a;
        private final Map<String, C0994b> f2043b;

        private C0996a(C1020h<T> c1020h, Map<String, C0994b> map) {
            this.f2042a = c1020h;
            this.f2043b = map;
        }

        public void m3539a(C0987c c0987c, T t) {
            if (t == null) {
                c0987c.m3505f();
                return;
            }
            c0987c.m3502d();
            try {
                for (C0994b c0994b : this.f2043b.values()) {
                    if (c0994b.m3535a(t)) {
                        c0987c.m3494a(c0994b.f2033g);
                        c0994b.m3534a(c0987c, (Object) t);
                    }
                }
                c0987c.m3504e();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T m3540b(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            T a = this.f2042a.m3701a();
            try {
                c0984a.m3450c();
                while (c0984a.m3452e()) {
                    C0994b c0994b = (C0994b) this.f2043b.get(c0984a.m3454g());
                    if (c0994b == null || !c0994b.f2035i) {
                        c0984a.m3461n();
                    } else {
                        c0994b.m3533a(c0984a, (Object) a);
                    }
                }
                c0984a.m3451d();
                return a;
            } catch (Throwable e) {
                throw new C1082p(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public C0997i(C1030c c1030c, C1054d c1054d, C1032d c1032d) {
        this.f2044a = c1030c;
        this.f2045b = c1054d;
        this.f2046c = c1032d;
    }

    private C0994b m3541a(C1073e c1073e, Field field, String str, C1061a<?> c1061a, boolean z, boolean z2) {
        return new C09951(this, str, z, z2, c1073e, field, c1061a, C1043i.m3749a(c1061a.m3772a()));
    }

    private C0976r<?> m3543a(C1073e c1073e, Field field, C1061a<?> c1061a) {
        C0969b c0969b = (C0969b) field.getAnnotation(C0969b.class);
        if (c0969b != null) {
            C0976r<?> a = C0982d.m3421a(this.f2044a, c1073e, c1061a, c0969b);
            if (a != null) {
                return a;
            }
        }
        return c1073e.m3797a((C1061a) c1061a);
    }

    static List<String> m3544a(C1054d c1054d, Field field) {
        C0970c c0970c = (C0970c) field.getAnnotation(C0970c.class);
        List<String> linkedList = new LinkedList();
        if (c0970c == null) {
            linkedList.add(c1054d.m3758a(field));
        } else {
            linkedList.add(c0970c.m3396a());
            for (Object add : c0970c.m3397b()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private List<String> m3545a(Field field) {
        return C0997i.m3544a(this.f2045b, field);
    }

    private Map<String, C0994b> m3546a(C1073e c1073e, C1061a<?> c1061a, Class<?> cls) {
        Map<String, C0994b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = c1061a.m3773b();
        Class a;
        while (a != Object.class) {
            for (Field field : a.getDeclaredFields()) {
                boolean a2 = m3549a(field, true);
                boolean a3 = m3549a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = C1019b.m3686a(r19.m3773b(), a, field.getGenericType());
                    List a5 = m3545a(field);
                    C0994b c0994b = null;
                    int i = 0;
                    while (i < a5.size()) {
                        String str = (String) a5.get(i);
                        if (i != 0) {
                            a2 = false;
                        }
                        C0994b c0994b2 = (C0994b) linkedHashMap.put(str, m3541a(c1073e, field, str, C1061a.m3769a(a4), a2, a3));
                        if (c0994b != null) {
                            c0994b2 = c0994b;
                        }
                        i++;
                        c0994b = c0994b2;
                    }
                    if (c0994b != null) {
                        throw new IllegalArgumentException(b + " declares multiple JSON fields named " + c0994b.f2033g);
                    }
                }
            }
            C1061a a6 = C1061a.m3769a(C1019b.m3686a(a6.m3773b(), a, a.getGenericSuperclass()));
            a = a6.m3772a();
        }
        return linkedHashMap;
    }

    static boolean m3547a(Field field, boolean z, C1032d c1032d) {
        return (c1032d.m3729a(field.getType(), z) || c1032d.m3730a(field, z)) ? false : true;
    }

    public <T> C0976r<T> m3548a(C1073e c1073e, C1061a<T> c1061a) {
        Class a = c1061a.m3772a();
        return !Object.class.isAssignableFrom(a) ? null : new C0996a(m3546a(c1073e, (C1061a) c1061a, a), null);
    }

    public boolean m3549a(Field field, boolean z) {
        return C0997i.m3547a(field, z, this.f2046c);
    }
}
