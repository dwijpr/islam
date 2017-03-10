package com.google.p033a;

import com.google.p033a.p035b.C1030c;
import com.google.p033a.p035b.C1032d;
import com.google.p033a.p035b.C1043i;
import com.google.p033a.p035b.C1047j;
import com.google.p033a.p035b.p036a.C0977a;
import com.google.p033a.p035b.p036a.C0979b;
import com.google.p033a.p035b.p036a.C0981c;
import com.google.p033a.p035b.p036a.C0982d;
import com.google.p033a.p035b.p036a.C0990g;
import com.google.p033a.p035b.p036a.C0993h;
import com.google.p033a.p035b.p036a.C0997i;
import com.google.p033a.p035b.p036a.C0999j;
import com.google.p033a.p035b.p036a.C1001k;
import com.google.p033a.p035b.p036a.C1014m;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.e */
public final class C1073e {
    final C1065h f2219a;
    final C1067o f2220b;
    private final ThreadLocal<Map<C1061a<?>, C1072a<?>>> f2221c;
    private final Map<C1061a<?>, C0976r<?>> f2222d;
    private final List<C0974s> f2223e;
    private final C1030c f2224f;
    private final boolean f2225g;
    private final boolean f2226h;
    private final boolean f2227i;
    private final boolean f2228j;

    /* renamed from: com.google.a.e.1 */
    class C10661 implements C1065h {
        final /* synthetic */ C1073e f2213a;

        C10661(C1073e c1073e) {
            this.f2213a = c1073e;
        }
    }

    /* renamed from: com.google.a.e.2 */
    class C10682 implements C1067o {
        final /* synthetic */ C1073e f2214a;

        C10682(C1073e c1073e) {
            this.f2214a = c1073e;
        }
    }

    /* renamed from: com.google.a.e.3 */
    class C10693 extends C0976r<Number> {
        final /* synthetic */ C1073e f2215a;

        C10693(C1073e c1073e) {
            this.f2215a = c1073e;
        }

        public Double m3775a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return Double.valueOf(c0984a.m3458k());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3776a(C0987c c0987c, Number number) {
            if (number == null) {
                c0987c.m3505f();
                return;
            }
            this.f2215a.m3792a(number.doubleValue());
            c0987c.m3493a(number);
        }

        public /* synthetic */ Object m3778b(C0984a c0984a) {
            return m3775a(c0984a);
        }
    }

    /* renamed from: com.google.a.e.4 */
    class C10704 extends C0976r<Number> {
        final /* synthetic */ C1073e f2216a;

        C10704(C1073e c1073e) {
            this.f2216a = c1073e;
        }

        public Float m3779a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return Float.valueOf((float) c0984a.m3458k());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3780a(C0987c c0987c, Number number) {
            if (number == null) {
                c0987c.m3505f();
                return;
            }
            this.f2216a.m3792a((double) number.floatValue());
            c0987c.m3493a(number);
        }

        public /* synthetic */ Object m3782b(C0984a c0984a) {
            return m3779a(c0984a);
        }
    }

    /* renamed from: com.google.a.e.5 */
    class C10715 extends C0976r<Number> {
        final /* synthetic */ C1073e f2217a;

        C10715(C1073e c1073e) {
            this.f2217a = c1073e;
        }

        public Number m3783a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return Long.valueOf(c0984a.m3459l());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3784a(C0987c c0987c, Number number) {
            if (number == null) {
                c0987c.m3505f();
            } else {
                c0987c.m3497b(number.toString());
            }
        }

        public /* synthetic */ Object m3786b(C0984a c0984a) {
            return m3783a(c0984a);
        }
    }

    /* renamed from: com.google.a.e.a */
    static class C1072a<T> extends C0976r<T> {
        private C0976r<T> f2218a;

        C1072a() {
        }

        public void m3787a(C0987c c0987c, T t) {
            if (this.f2218a == null) {
                throw new IllegalStateException();
            }
            this.f2218a.m3405a(c0987c, t);
        }

        public void m3788a(C0976r<T> c0976r) {
            if (this.f2218a != null) {
                throw new AssertionError();
            }
            this.f2218a = c0976r;
        }

        public T m3789b(C0984a c0984a) {
            if (this.f2218a != null) {
                return this.f2218a.m3406b(c0984a);
            }
            throw new IllegalStateException();
        }
    }

    public C1073e() {
        this(C1032d.f2148a, C1055c.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, C1083q.DEFAULT, Collections.emptyList());
    }

    C1073e(C1032d c1032d, C1054d c1054d, Map<Type, C1074f<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C1083q c1083q, List<C0974s> list) {
        this.f2221c = new ThreadLocal();
        this.f2222d = Collections.synchronizedMap(new HashMap());
        this.f2219a = new C10661(this);
        this.f2220b = new C10682(this);
        this.f2224f = new C1030c(map);
        this.f2225g = z;
        this.f2227i = z3;
        this.f2226h = z4;
        this.f2228j = z5;
        List arrayList = new ArrayList();
        arrayList.add(C1014m.f2085Q);
        arrayList.add(C0993h.f2031a);
        arrayList.add(c1032d);
        arrayList.addAll(list);
        arrayList.add(C1014m.f2110x);
        arrayList.add(C1014m.f2099m);
        arrayList.add(C1014m.f2093g);
        arrayList.add(C1014m.f2095i);
        arrayList.add(C1014m.f2097k);
        arrayList.add(C1014m.m3674a(Long.TYPE, Long.class, m3790a(c1083q)));
        arrayList.add(C1014m.m3674a(Double.TYPE, Double.class, m3791a(z6)));
        arrayList.add(C1014m.m3674a(Float.TYPE, Float.class, m3795b(z6)));
        arrayList.add(C1014m.f2104r);
        arrayList.add(C1014m.f2106t);
        arrayList.add(C1014m.f2112z);
        arrayList.add(C1014m.f2070B);
        arrayList.add(C1014m.m3673a(BigDecimal.class, C1014m.f2108v));
        arrayList.add(C1014m.m3673a(BigInteger.class, C1014m.f2109w));
        arrayList.add(C1014m.f2072D);
        arrayList.add(C1014m.f2074F);
        arrayList.add(C1014m.f2078J);
        arrayList.add(C1014m.f2083O);
        arrayList.add(C1014m.f2076H);
        arrayList.add(C1014m.f2090d);
        arrayList.add(C0981c.f1984a);
        arrayList.add(C1014m.f2081M);
        arrayList.add(C1001k.f2049a);
        arrayList.add(C0999j.f2047a);
        arrayList.add(C1014m.f2079K);
        arrayList.add(C0977a.f1978a);
        arrayList.add(C1014m.f2088b);
        arrayList.add(new C0979b(this.f2224f));
        arrayList.add(new C0990g(this.f2224f, z2));
        arrayList.add(new C0982d(this.f2224f));
        arrayList.add(C1014m.f2086R);
        arrayList.add(new C0997i(this.f2224f, c1054d, c1032d));
        this.f2223e = Collections.unmodifiableList(arrayList);
    }

    private C0976r<Number> m3790a(C1083q c1083q) {
        return c1083q == C1083q.DEFAULT ? C1014m.f2100n : new C10715(this);
    }

    private C0976r<Number> m3791a(boolean z) {
        return z ? C1014m.f2102p : new C10693(this);
    }

    private void m3792a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void m3794a(Object obj, C0984a c0984a) {
        if (obj != null) {
            try {
                if (c0984a.m3453f() != C1063b.END_DOCUMENT) {
                    throw new C1078j("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new C1082p(e);
            } catch (Throwable e2) {
                throw new C1078j(e2);
            }
        }
    }

    private C0976r<Number> m3795b(boolean z) {
        return z ? C1014m.f2101o : new C10704(this);
    }

    public C0987c m3796a(Writer writer) {
        if (this.f2227i) {
            writer.write(")]}'\n");
        }
        C0987c c0987c = new C0987c(writer);
        if (this.f2228j) {
            c0987c.m3500c("  ");
        }
        c0987c.m3503d(this.f2225g);
        return c0987c;
    }

    public <T> C0976r<T> m3797a(C1061a<T> c1061a) {
        Map map;
        C0976r<T> c0976r = (C0976r) this.f2222d.get(c1061a);
        if (c0976r == null) {
            Map map2 = (Map) this.f2221c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.f2221c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            C1072a c1072a = (C1072a) map.get(c1061a);
            if (c1072a == null) {
                try {
                    C1072a c1072a2 = new C1072a();
                    map.put(c1061a, c1072a2);
                    for (C0974s a : this.f2223e) {
                        c0976r = a.m3402a(this, c1061a);
                        if (c0976r != null) {
                            c1072a2.m3788a(c0976r);
                            this.f2222d.put(c1061a, c0976r);
                            map.remove(c1061a);
                            if (obj != null) {
                                this.f2221c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + c1061a);
                } catch (Throwable th) {
                    map.remove(c1061a);
                    if (obj != null) {
                        this.f2221c.remove();
                    }
                }
            }
        }
        return c0976r;
    }

    public <T> C0976r<T> m3798a(C0974s c0974s, C1061a<T> c1061a) {
        Object obj = null;
        if (!this.f2223e.contains(c0974s)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (C0974s c0974s2 : this.f2223e) {
            if (obj2 != null) {
                C0976r<T> a = c0974s2.m3402a(this, c1061a);
                if (a != null) {
                    return a;
                }
            } else if (c0974s2 == c0974s) {
                obj2 = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + c1061a);
    }

    public <T> C0976r<T> m3799a(Class<T> cls) {
        return m3797a(C1061a.m3771b(cls));
    }

    public <T> T m3800a(C0984a c0984a, Type type) {
        boolean z = true;
        boolean p = c0984a.m3462p();
        c0984a.m3448a(true);
        try {
            c0984a.m3453f();
            z = false;
            T b = m3797a(C1061a.m3769a(type)).m3406b(c0984a);
            c0984a.m3448a(p);
            return b;
        } catch (Throwable e) {
            if (z) {
                c0984a.m3448a(p);
                return null;
            }
            throw new C1082p(e);
        } catch (Throwable e2) {
            throw new C1082p(e2);
        } catch (Throwable e22) {
            throw new C1082p(e22);
        } catch (Throwable th) {
            c0984a.m3448a(p);
        }
    }

    public <T> T m3801a(Reader reader, Type type) {
        C0984a c0984a = new C0984a(reader);
        Object a = m3800a(c0984a, type);
        C1073e.m3794a(a, c0984a);
        return a;
    }

    public <T> T m3802a(String str, Class<T> cls) {
        return C1043i.m3747a((Class) cls).cast(m3803a(str, (Type) cls));
    }

    public <T> T m3803a(String str, Type type) {
        return str == null ? null : m3801a(new StringReader(str), type);
    }

    public String m3804a(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m3806a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void m3805a(Object obj, Type type, C0987c c0987c) {
        C0976r a = m3797a(C1061a.m3769a(type));
        boolean g = c0987c.m3506g();
        c0987c.m3498b(true);
        boolean h = c0987c.m3507h();
        c0987c.m3501c(this.f2226h);
        boolean i = c0987c.m3508i();
        c0987c.m3503d(this.f2225g);
        try {
            a.m3405a(c0987c, obj);
            c0987c.m3498b(g);
            c0987c.m3501c(h);
            c0987c.m3503d(i);
        } catch (Throwable e) {
            throw new C1078j(e);
        } catch (Throwable th) {
            c0987c.m3498b(g);
            c0987c.m3501c(h);
            c0987c.m3503d(i);
        }
    }

    public void m3806a(Object obj, Type type, Appendable appendable) {
        try {
            m3805a(obj, type, m3796a(C1047j.m3750a(appendable)));
        } catch (Throwable e) {
            throw new C1078j(e);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f2225g + "factories:" + this.f2223e + ",instanceCreators:" + this.f2224f + "}";
    }
}
