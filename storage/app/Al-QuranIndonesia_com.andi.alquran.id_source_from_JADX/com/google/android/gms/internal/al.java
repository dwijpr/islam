package com.google.android.gms.internal;

import android.os.Binder;

public abstract class al<T> {
    private static final Object f3328c;
    private static C1437a f3329d;
    private static int f3330e;
    private static String f3331f;
    protected final String f3332a;
    protected final T f3333b;
    private T f3334g;

    /* renamed from: com.google.android.gms.internal.al.1 */
    class C14321 extends al<Boolean> {
        C14321(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object m5121a(String str) {
            return m5122b(str);
        }

        protected Boolean m5122b(String str) {
            C1437a c1437a = null;
            return c1437a.m5131a(this.a, (Boolean) this.b);
        }
    }

    /* renamed from: com.google.android.gms.internal.al.2 */
    class C14332 extends al<Long> {
        C14332(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object m5123a(String str) {
            return m5124b(str);
        }

        protected Long m5124b(String str) {
            C1437a c1437a = null;
            return c1437a.m5134a(this.a, (Long) this.b);
        }
    }

    /* renamed from: com.google.android.gms.internal.al.3 */
    class C14343 extends al<Integer> {
        C14343(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object m5125a(String str) {
            return m5126b(str);
        }

        protected Integer m5126b(String str) {
            C1437a c1437a = null;
            return c1437a.m5133a(this.a, (Integer) this.b);
        }
    }

    /* renamed from: com.google.android.gms.internal.al.4 */
    class C14354 extends al<Float> {
        C14354(String str, Float f) {
            super(str, f);
        }

        protected /* synthetic */ Object m5127a(String str) {
            return m5128b(str);
        }

        protected Float m5128b(String str) {
            C1437a c1437a = null;
            return c1437a.m5132a(this.a, (Float) this.b);
        }
    }

    /* renamed from: com.google.android.gms.internal.al.5 */
    class C14365 extends al<String> {
        C14365(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object m5129a(String str) {
            return m5130b(str);
        }

        protected String m5130b(String str) {
            C1437a c1437a = null;
            return c1437a.m5135a(this.a, (String) this.b);
        }
    }

    /* renamed from: com.google.android.gms.internal.al.a */
    private interface C1437a {
        Boolean m5131a(String str, Boolean bool);

        Float m5132a(String str, Float f);

        Integer m5133a(String str, Integer num);

        Long m5134a(String str, Long l);

        String m5135a(String str, String str2);
    }

    static {
        f3328c = new Object();
        f3329d = null;
        f3330e = 0;
        f3331f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected al(String str, T t) {
        this.f3334g = null;
        this.f3332a = str;
        this.f3333b = t;
    }

    public static al<Float> m5114a(String str, Float f) {
        return new C14354(str, f);
    }

    public static al<Integer> m5115a(String str, Integer num) {
        return new C14343(str, num);
    }

    public static al<Long> m5116a(String str, Long l) {
        return new C14332(str, l);
    }

    public static al<String> m5117a(String str, String str2) {
        return new C14365(str, str2);
    }

    public static al<Boolean> m5118a(String str, boolean z) {
        return new C14321(str, Boolean.valueOf(z));
    }

    public final T m5119a() {
        T a;
        long clearCallingIdentity;
        try {
            a = m5120a(this.f3332a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            a = m5120a(this.f3332a);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return a;
    }

    protected abstract T m5120a(String str);
}
