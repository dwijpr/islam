package com.google.p033a.p035b;

import com.google.p033a.C1074f;
import com.google.p033a.C1078j;
import com.google.p033a.p035b.C1030c;
import com.google.p033a.p038c.C1061a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.google.a.b.c */
public final class C1030c {
    private final Map<Type, C1074f<?>> f2141a;

    /* renamed from: com.google.a.b.c.1 */
    class C10211 implements C1020h<T> {
        final /* synthetic */ C1074f f2123a;
        final /* synthetic */ Type f2124b;
        final /* synthetic */ C1030c f2125c;

        C10211(C1030c c1030c, C1074f c1074f, Type type) {
            this.f2125c = c1030c;
            this.f2123a = c1074f;
            this.f2124b = type;
        }

        public T m3705a() {
            return this.f2123a.m3807a(this.f2124b);
        }
    }

    /* renamed from: com.google.a.b.c.2 */
    class C10222 implements C1020h<T> {
        final /* synthetic */ C1030c f2126a;

        C10222(C1030c c1030c) {
            this.f2126a = c1030c;
        }

        public T m3706a() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: com.google.a.b.c.3 */
    class C10233 implements C1020h<T> {
        final /* synthetic */ C1030c f2127a;

        C10233(C1030c c1030c) {
            this.f2127a = c1030c;
        }

        public T m3707a() {
            return new C1042g();
        }
    }

    /* renamed from: com.google.a.b.c.4 */
    class C10244 implements C1020h<T> {
        final /* synthetic */ Class f2128a;
        final /* synthetic */ Type f2129b;
        final /* synthetic */ C1030c f2130c;
        private final C1048k f2131d;

        C10244(C1030c c1030c, Class cls, Type type) {
            this.f2130c = c1030c;
            this.f2128a = cls;
            this.f2129b = type;
            this.f2131d = C1048k.m3752a();
        }

        public T m3708a() {
            try {
                return this.f2131d.m3753a(this.f2128a);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f2129b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* renamed from: com.google.a.b.c.5 */
    class C10255 implements C1020h<T> {
        final /* synthetic */ C1074f f2132a;
        final /* synthetic */ Type f2133b;
        final /* synthetic */ C1030c f2134c;

        C10255(C1030c c1030c, C1074f c1074f, Type type) {
            this.f2134c = c1030c;
            this.f2132a = c1074f;
            this.f2133b = type;
        }

        public T m3709a() {
            return this.f2132a.m3807a(this.f2133b);
        }
    }

    /* renamed from: com.google.a.b.c.6 */
    class C10266 implements C1020h<T> {
        final /* synthetic */ Constructor f2135a;
        final /* synthetic */ C1030c f2136b;

        C10266(C1030c c1030c, Constructor constructor) {
            this.f2136b = c1030c;
            this.f2135a = constructor;
        }

        public T m3710a() {
            try {
                return this.f2135a.newInstance(null);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to invoke " + this.f2135a + " with no args", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to invoke " + this.f2135a + " with no args", e2.getTargetException());
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* renamed from: com.google.a.b.c.7 */
    class C10277 implements C1020h<T> {
        final /* synthetic */ C1030c f2137a;

        C10277(C1030c c1030c) {
            this.f2137a = c1030c;
        }

        public T m3711a() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.a.b.c.8 */
    class C10288 implements C1020h<T> {
        final /* synthetic */ Type f2138a;
        final /* synthetic */ C1030c f2139b;

        C10288(C1030c c1030c, Type type) {
            this.f2139b = c1030c;
            this.f2138a = type;
        }

        public T m3712a() {
            if (this.f2138a instanceof ParameterizedType) {
                Type type = ((ParameterizedType) this.f2138a).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return EnumSet.noneOf((Class) type);
                }
                throw new C1078j("Invalid EnumSet type: " + this.f2138a.toString());
            }
            throw new C1078j("Invalid EnumSet type: " + this.f2138a.toString());
        }
    }

    /* renamed from: com.google.a.b.c.9 */
    class C10299 implements C1020h<T> {
        final /* synthetic */ C1030c f2140a;

        C10299(C1030c c1030c) {
            this.f2140a = c1030c;
        }

        public T m3713a() {
            return new LinkedHashSet();
        }
    }

    public C1030c(Map<Type, C1074f<?>> map) {
        this.f2141a = map;
    }

    private <T> C1020h<T> m3714a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C10266(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> C1020h<T> m3715a(Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C10277(this) : EnumSet.class.isAssignableFrom(cls) ? new C10288(this, type) : Set.class.isAssignableFrom(cls) ? new C10299(this) : Queue.class.isAssignableFrom(cls) ? new C1020h<T>() {
            final /* synthetic */ C1030c f2120a;

            {
                this.f2120a = r1;
            }

            public T m3702a() {
                return new LinkedList();
            }
        } : new C1020h<T>() {
            final /* synthetic */ C1030c f2121a;

            {
                this.f2121a = r1;
            }

            public T m3703a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new C1020h<T>() {
            final /* synthetic */ C1030c f2122a;

            {
                this.f2122a = r1;
            }

            public T m3704a() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C1061a.m3769a(((ParameterizedType) type).getActualTypeArguments()[0]).m3772a())) ? new C10233(this) : new C10222(this) : null;
    }

    private <T> C1020h<T> m3716b(Type type, Class<? super T> cls) {
        return new C10244(this, cls, type);
    }

    public <T> C1020h<T> m3717a(C1061a<T> c1061a) {
        Type b = c1061a.m3773b();
        Class a = c1061a.m3772a();
        C1074f c1074f = (C1074f) this.f2141a.get(b);
        if (c1074f != null) {
            return new C10211(this, c1074f, b);
        }
        c1074f = (C1074f) this.f2141a.get(a);
        if (c1074f != null) {
            return new C10255(this, c1074f, b);
        }
        C1020h<T> a2 = m3714a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = m3715a(b, a);
        return a2 == null ? m3716b(b, a) : a2;
    }

    public String toString() {
        return this.f2141a.toString();
    }
}
