package com.google.p033a.p035b.p036a;

import com.google.a.b.a.m.AnonymousClass15;
import com.google.a.b.a.m.AnonymousClass20;
import com.google.a.b.a.m.AnonymousClass21;
import com.google.a.b.a.m.AnonymousClass23;
import com.google.a.b.a.m.AnonymousClass24;
import com.google.a.b.a.m.AnonymousClass25;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.C1075i;
import com.google.p033a.C1076g;
import com.google.p033a.C1078j;
import com.google.p033a.C1079k;
import com.google.p033a.C1080l;
import com.google.p033a.C1081n;
import com.google.p033a.C1082p;
import com.google.p033a.p034a.C0970c;
import com.google.p033a.p035b.C1034f;
import com.google.p033a.p035b.p036a.C1014m.15.C10031;
import com.google.p033a.p035b.p036a.C1014m.C1013a;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

/* renamed from: com.google.a.b.a.m */
public final class C1014m {
    public static final C0976r<StringBuffer> f2069A;
    public static final C0974s f2070B;
    public static final C0976r<URL> f2071C;
    public static final C0974s f2072D;
    public static final C0976r<URI> f2073E;
    public static final C0974s f2074F;
    public static final C0976r<InetAddress> f2075G;
    public static final C0974s f2076H;
    public static final C0976r<UUID> f2077I;
    public static final C0974s f2078J;
    public static final C0974s f2079K;
    public static final C0976r<Calendar> f2080L;
    public static final C0974s f2081M;
    public static final C0976r<Locale> f2082N;
    public static final C0974s f2083O;
    public static final C0976r<C1075i> f2084P;
    public static final C0974s f2085Q;
    public static final C0974s f2086R;
    public static final C0976r<Class> f2087a;
    public static final C0974s f2088b;
    public static final C0976r<BitSet> f2089c;
    public static final C0974s f2090d;
    public static final C0976r<Boolean> f2091e;
    public static final C0976r<Boolean> f2092f;
    public static final C0974s f2093g;
    public static final C0976r<Number> f2094h;
    public static final C0974s f2095i;
    public static final C0976r<Number> f2096j;
    public static final C0974s f2097k;
    public static final C0976r<Number> f2098l;
    public static final C0974s f2099m;
    public static final C0976r<Number> f2100n;
    public static final C0976r<Number> f2101o;
    public static final C0976r<Number> f2102p;
    public static final C0976r<Number> f2103q;
    public static final C0974s f2104r;
    public static final C0976r<Character> f2105s;
    public static final C0974s f2106t;
    public static final C0976r<String> f2107u;
    public static final C0976r<BigDecimal> f2108v;
    public static final C0976r<BigInteger> f2109w;
    public static final C0974s f2110x;
    public static final C0976r<StringBuilder> f2111y;
    public static final C0974s f2112z;

    /* renamed from: com.google.a.b.a.m.1 */
    static class C10041 extends C0976r<Class> {
        C10041() {
        }

        public Class m3601a(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public void m3602a(C0987c c0987c, Class cls) {
            if (cls == null) {
                c0987c.m3505f();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        public /* synthetic */ Object m3604b(C0984a c0984a) {
            return m3601a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.20 */
    static class AnonymousClass20 implements C0974s {
        final /* synthetic */ Class f2056a;
        final /* synthetic */ C0976r f2057b;

        AnonymousClass20(Class cls, C0976r c0976r) {
            this.f2056a = cls;
            this.f2057b = c0976r;
        }

        public <T> C0976r<T> m3605a(C1073e c1073e, C1061a<T> c1061a) {
            return c1061a.m3772a() == this.f2056a ? this.f2057b : null;
        }

        public String toString() {
            return "Factory[type=" + this.f2056a.getName() + ",adapter=" + this.f2057b + "]";
        }
    }

    /* renamed from: com.google.a.b.a.m.21 */
    static class AnonymousClass21 implements C0974s {
        final /* synthetic */ Class f2058a;
        final /* synthetic */ Class f2059b;
        final /* synthetic */ C0976r f2060c;

        AnonymousClass21(Class cls, Class cls2, C0976r c0976r) {
            this.f2058a = cls;
            this.f2059b = cls2;
            this.f2060c = c0976r;
        }

        public <T> C0976r<T> m3606a(C1073e c1073e, C1061a<T> c1061a) {
            Class a = c1061a.m3772a();
            return (a == this.f2058a || a == this.f2059b) ? this.f2060c : null;
        }

        public String toString() {
            return "Factory[type=" + this.f2059b.getName() + "+" + this.f2058a.getName() + ",adapter=" + this.f2060c + "]";
        }
    }

    /* renamed from: com.google.a.b.a.m.23 */
    static class AnonymousClass23 implements C0974s {
        final /* synthetic */ Class f2061a;
        final /* synthetic */ Class f2062b;
        final /* synthetic */ C0976r f2063c;

        AnonymousClass23(Class cls, Class cls2, C0976r c0976r) {
            this.f2061a = cls;
            this.f2062b = cls2;
            this.f2063c = c0976r;
        }

        public <T> C0976r<T> m3611a(C1073e c1073e, C1061a<T> c1061a) {
            Class a = c1061a.m3772a();
            return (a == this.f2061a || a == this.f2062b) ? this.f2063c : null;
        }

        public String toString() {
            return "Factory[type=" + this.f2061a.getName() + "+" + this.f2062b.getName() + ",adapter=" + this.f2063c + "]";
        }
    }

    /* renamed from: com.google.a.b.a.m.24 */
    static class AnonymousClass24 implements C0974s {
        final /* synthetic */ Class f2064a;
        final /* synthetic */ C0976r f2065b;

        AnonymousClass24(Class cls, C0976r c0976r) {
            this.f2064a = cls;
            this.f2065b = c0976r;
        }

        public <T> C0976r<T> m3612a(C1073e c1073e, C1061a<T> c1061a) {
            return this.f2064a.isAssignableFrom(c1061a.m3772a()) ? this.f2065b : null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f2064a.getName() + ",adapter=" + this.f2065b + "]";
        }
    }

    /* renamed from: com.google.a.b.a.m.25 */
    static /* synthetic */ class AnonymousClass25 {
        static final /* synthetic */ int[] f2066a;

        static {
            f2066a = new int[C1063b.values().length];
            try {
                f2066a[C1063b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2066a[C1063b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2066a[C1063b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2066a[C1063b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2066a[C1063b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2066a[C1063b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2066a[C1063b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2066a[C1063b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2066a[C1063b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2066a[C1063b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.a.b.a.m.2 */
    static class C10052 extends C0976r<Number> {
        C10052() {
        }

        public Number m3629a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return Double.valueOf(c0984a.m3458k());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3630a(C0987c c0987c, Number number) {
            c0987c.m3493a(number);
        }

        public /* synthetic */ Object m3632b(C0984a c0984a) {
            return m3629a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.3 */
    static class C10063 extends C0976r<Number> {
        C10063() {
        }

        public Number m3641a(C0984a c0984a) {
            C1063b f = c0984a.m3453f();
            switch (AnonymousClass25.f2066a[f.ordinal()]) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return new C1034f(c0984a.m3455h());
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    c0984a.m3457j();
                    return null;
                default:
                    throw new C1082p("Expecting number, got: " + f);
            }
        }

        public void m3642a(C0987c c0987c, Number number) {
            c0987c.m3493a(number);
        }

        public /* synthetic */ Object m3644b(C0984a c0984a) {
            return m3641a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.4 */
    static class C10074 extends C0976r<Character> {
        C10074() {
        }

        public Character m3645a(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            String h = c0984a.m3455h();
            if (h.length() == 1) {
                return Character.valueOf(h.charAt(0));
            }
            throw new C1082p("Expecting character, got: " + h);
        }

        public void m3646a(C0987c c0987c, Character ch) {
            c0987c.m3497b(ch == null ? null : String.valueOf(ch));
        }

        public /* synthetic */ Object m3648b(C0984a c0984a) {
            return m3645a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.5 */
    static class C10085 extends C0976r<String> {
        C10085() {
        }

        public String m3649a(C0984a c0984a) {
            C1063b f = c0984a.m3453f();
            if (f != C1063b.NULL) {
                return f == C1063b.BOOLEAN ? Boolean.toString(c0984a.m3456i()) : c0984a.m3455h();
            } else {
                c0984a.m3457j();
                return null;
            }
        }

        public void m3651a(C0987c c0987c, String str) {
            c0987c.m3497b(str);
        }

        public /* synthetic */ Object m3652b(C0984a c0984a) {
            return m3649a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.6 */
    static class C10096 extends C0976r<BigDecimal> {
        C10096() {
        }

        public BigDecimal m3653a(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            try {
                return new BigDecimal(c0984a.m3455h());
            } catch (Throwable e) {
                throw new C1082p(e);
            }
        }

        public void m3655a(C0987c c0987c, BigDecimal bigDecimal) {
            c0987c.m3493a((Number) bigDecimal);
        }

        public /* synthetic */ Object m3656b(C0984a c0984a) {
            return m3653a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.7 */
    static class C10107 extends C0976r<BigInteger> {
        C10107() {
        }

        public BigInteger m3657a(C0984a c0984a) {
            if (c0984a.m3453f() == C1063b.NULL) {
                c0984a.m3457j();
                return null;
            }
            try {
                return new BigInteger(c0984a.m3455h());
            } catch (Throwable e) {
                throw new C1082p(e);
            }
        }

        public void m3659a(C0987c c0987c, BigInteger bigInteger) {
            c0987c.m3493a((Number) bigInteger);
        }

        public /* synthetic */ Object m3660b(C0984a c0984a) {
            return m3657a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.8 */
    static class C10118 extends C0976r<StringBuilder> {
        C10118() {
        }

        public StringBuilder m3661a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return new StringBuilder(c0984a.m3455h());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3663a(C0987c c0987c, StringBuilder stringBuilder) {
            c0987c.m3497b(stringBuilder == null ? null : stringBuilder.toString());
        }

        public /* synthetic */ Object m3664b(C0984a c0984a) {
            return m3661a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.9 */
    static class C10129 extends C0976r<StringBuffer> {
        C10129() {
        }

        public StringBuffer m3665a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return new StringBuffer(c0984a.m3455h());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3667a(C0987c c0987c, StringBuffer stringBuffer) {
            c0987c.m3497b(stringBuffer == null ? null : stringBuffer.toString());
        }

        public /* synthetic */ Object m3668b(C0984a c0984a) {
            return m3665a(c0984a);
        }
    }

    /* renamed from: com.google.a.b.a.m.a */
    private static final class C1013a<T extends Enum<T>> extends C0976r<T> {
        private final Map<String, T> f2067a;
        private final Map<T, String> f2068b;

        public C1013a(Class<T> cls) {
            this.f2067a = new HashMap();
            this.f2068b = new HashMap();
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    C0970c c0970c = (C0970c) cls.getField(name).getAnnotation(C0970c.class);
                    if (c0970c != null) {
                        name = c0970c.m3396a();
                        for (Object put : c0970c.m3397b()) {
                            this.f2067a.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.f2067a.put(str, enumR);
                    this.f2068b.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public T m3669a(C0984a c0984a) {
            if (c0984a.m3453f() != C1063b.NULL) {
                return (Enum) this.f2067a.get(c0984a.m3455h());
            }
            c0984a.m3457j();
            return null;
        }

        public void m3670a(C0987c c0987c, T t) {
            c0987c.m3497b(t == null ? null : (String) this.f2068b.get(t));
        }

        public /* synthetic */ Object m3672b(C0984a c0984a) {
            return m3669a(c0984a);
        }
    }

    static {
        f2087a = new C10041();
        f2088b = C1014m.m3673a(Class.class, f2087a);
        f2089c = new C0976r<BitSet>() {
            public BitSet m3571a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                BitSet bitSet = new BitSet();
                c0984a.m3447a();
                C1063b f = c0984a.m3453f();
                int i = 0;
                while (f != C1063b.END_ARRAY) {
                    boolean z;
                    switch (AnonymousClass25.f2066a[f.ordinal()]) {
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            if (c0984a.m3460m() == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            z = c0984a.m3456i();
                            break;
                        case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            String h = c0984a.m3455h();
                            try {
                                if (Integer.parseInt(h) == 0) {
                                    z = false;
                                    break;
                                }
                                z = true;
                                break;
                            } catch (NumberFormatException e) {
                                throw new C1082p("Error: Expecting: bitset number value (1, 0), Found: " + h);
                            }
                        default:
                            throw new C1082p("Invalid bitset value type: " + f);
                    }
                    if (z) {
                        bitSet.set(i);
                    }
                    i++;
                    f = c0984a.m3453f();
                }
                c0984a.m3449b();
                return bitSet;
            }

            public void m3573a(C0987c c0987c, BitSet bitSet) {
                if (bitSet == null) {
                    c0987c.m3505f();
                    return;
                }
                c0987c.m3496b();
                for (int i = 0; i < bitSet.length(); i++) {
                    c0987c.m3492a((long) (bitSet.get(i) ? 1 : 0));
                }
                c0987c.m3499c();
            }

            public /* synthetic */ Object m3574b(C0984a c0984a) {
                return m3571a(c0984a);
            }
        };
        f2090d = C1014m.m3673a(BitSet.class, f2089c);
        f2091e = new C0976r<Boolean>() {
            public Boolean m3607a(C0984a c0984a) {
                if (c0984a.m3453f() != C1063b.NULL) {
                    return c0984a.m3453f() == C1063b.STRING ? Boolean.valueOf(Boolean.parseBoolean(c0984a.m3455h())) : Boolean.valueOf(c0984a.m3456i());
                } else {
                    c0984a.m3457j();
                    return null;
                }
            }

            public void m3608a(C0987c c0987c, Boolean bool) {
                if (bool == null) {
                    c0987c.m3505f();
                } else {
                    c0987c.m3495a(bool.booleanValue());
                }
            }

            public /* synthetic */ Object m3610b(C0984a c0984a) {
                return m3607a(c0984a);
            }
        };
        f2092f = new C0976r<Boolean>() {
            public Boolean m3613a(C0984a c0984a) {
                if (c0984a.m3453f() != C1063b.NULL) {
                    return Boolean.valueOf(c0984a.m3455h());
                }
                c0984a.m3457j();
                return null;
            }

            public void m3614a(C0987c c0987c, Boolean bool) {
                c0987c.m3497b(bool == null ? "null" : bool.toString());
            }

            public /* synthetic */ Object m3616b(C0984a c0984a) {
                return m3613a(c0984a);
            }
        };
        f2093g = C1014m.m3674a(Boolean.TYPE, Boolean.class, f2091e);
        f2094h = new C0976r<Number>() {
            public Number m3617a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) c0984a.m3460m());
                } catch (Throwable e) {
                    throw new C1082p(e);
                }
            }

            public void m3618a(C0987c c0987c, Number number) {
                c0987c.m3493a(number);
            }

            public /* synthetic */ Object m3620b(C0984a c0984a) {
                return m3617a(c0984a);
            }
        };
        f2095i = C1014m.m3674a(Byte.TYPE, Byte.class, f2094h);
        f2096j = new C0976r<Number>() {
            public Number m3621a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                try {
                    return Short.valueOf((short) c0984a.m3460m());
                } catch (Throwable e) {
                    throw new C1082p(e);
                }
            }

            public void m3622a(C0987c c0987c, Number number) {
                c0987c.m3493a(number);
            }

            public /* synthetic */ Object m3624b(C0984a c0984a) {
                return m3621a(c0984a);
            }
        };
        f2097k = C1014m.m3674a(Short.TYPE, Short.class, f2096j);
        f2098l = new C0976r<Number>() {
            public Number m3625a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                try {
                    return Integer.valueOf(c0984a.m3460m());
                } catch (Throwable e) {
                    throw new C1082p(e);
                }
            }

            public void m3626a(C0987c c0987c, Number number) {
                c0987c.m3493a(number);
            }

            public /* synthetic */ Object m3628b(C0984a c0984a) {
                return m3625a(c0984a);
            }
        };
        f2099m = C1014m.m3674a(Integer.TYPE, Integer.class, f2098l);
        f2100n = new C0976r<Number>() {
            public Number m3633a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                try {
                    return Long.valueOf(c0984a.m3459l());
                } catch (Throwable e) {
                    throw new C1082p(e);
                }
            }

            public void m3634a(C0987c c0987c, Number number) {
                c0987c.m3493a(number);
            }

            public /* synthetic */ Object m3636b(C0984a c0984a) {
                return m3633a(c0984a);
            }
        };
        f2101o = new C0976r<Number>() {
            public Number m3637a(C0984a c0984a) {
                if (c0984a.m3453f() != C1063b.NULL) {
                    return Float.valueOf((float) c0984a.m3458k());
                }
                c0984a.m3457j();
                return null;
            }

            public void m3638a(C0987c c0987c, Number number) {
                c0987c.m3493a(number);
            }

            public /* synthetic */ Object m3640b(C0984a c0984a) {
                return m3637a(c0984a);
            }
        };
        f2102p = new C10052();
        f2103q = new C10063();
        f2104r = C1014m.m3673a(Number.class, f2103q);
        f2105s = new C10074();
        f2106t = C1014m.m3674a(Character.TYPE, Character.class, f2105s);
        f2107u = new C10085();
        f2108v = new C10096();
        f2109w = new C10107();
        f2110x = C1014m.m3673a(String.class, f2107u);
        f2111y = new C10118();
        f2112z = C1014m.m3673a(StringBuilder.class, f2111y);
        f2069A = new C10129();
        f2070B = C1014m.m3673a(StringBuffer.class, f2069A);
        f2071C = new C0976r<URL>() {
            public URL m3563a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                String h = c0984a.m3455h();
                return !"null".equals(h) ? new URL(h) : null;
            }

            public void m3565a(C0987c c0987c, URL url) {
                c0987c.m3497b(url == null ? null : url.toExternalForm());
            }

            public /* synthetic */ Object m3566b(C0984a c0984a) {
                return m3563a(c0984a);
            }
        };
        f2072D = C1014m.m3673a(URL.class, f2071C);
        f2073E = new C0976r<URI>() {
            public URI m3567a(C0984a c0984a) {
                URI uri = null;
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                } else {
                    try {
                        String h = c0984a.m3455h();
                        if (!"null".equals(h)) {
                            uri = new URI(h);
                        }
                    } catch (Throwable e) {
                        throw new C1078j(e);
                    }
                }
                return uri;
            }

            public void m3569a(C0987c c0987c, URI uri) {
                c0987c.m3497b(uri == null ? null : uri.toASCIIString());
            }

            public /* synthetic */ Object m3570b(C0984a c0984a) {
                return m3567a(c0984a);
            }
        };
        f2074F = C1014m.m3673a(URI.class, f2073E);
        f2075G = new C0976r<InetAddress>() {
            public InetAddress m3575a(C0984a c0984a) {
                if (c0984a.m3453f() != C1063b.NULL) {
                    return InetAddress.getByName(c0984a.m3455h());
                }
                c0984a.m3457j();
                return null;
            }

            public void m3577a(C0987c c0987c, InetAddress inetAddress) {
                c0987c.m3497b(inetAddress == null ? null : inetAddress.getHostAddress());
            }

            public /* synthetic */ Object m3578b(C0984a c0984a) {
                return m3575a(c0984a);
            }
        };
        f2076H = C1014m.m3675b(InetAddress.class, f2075G);
        f2077I = new C0976r<UUID>() {
            public UUID m3579a(C0984a c0984a) {
                if (c0984a.m3453f() != C1063b.NULL) {
                    return UUID.fromString(c0984a.m3455h());
                }
                c0984a.m3457j();
                return null;
            }

            public void m3581a(C0987c c0987c, UUID uuid) {
                c0987c.m3497b(uuid == null ? null : uuid.toString());
            }

            public /* synthetic */ Object m3582b(C0984a c0984a) {
                return m3579a(c0984a);
            }
        };
        f2078J = C1014m.m3673a(UUID.class, f2077I);
        f2079K = new C0974s() {

            /* renamed from: com.google.a.b.a.m.15.1 */
            class C10031 extends C0976r<Timestamp> {
                final /* synthetic */ C0976r f2054a;
                final /* synthetic */ AnonymousClass15 f2055b;

                C10031(AnonymousClass15 anonymousClass15, C0976r c0976r) {
                    this.f2055b = anonymousClass15;
                    this.f2054a = c0976r;
                }

                public Timestamp m3583a(C0984a c0984a) {
                    Date date = (Date) this.f2054a.m3406b(c0984a);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public void m3585a(C0987c c0987c, Timestamp timestamp) {
                    this.f2054a.m3405a(c0987c, timestamp);
                }

                public /* synthetic */ Object m3586b(C0984a c0984a) {
                    return m3583a(c0984a);
                }
            }

            public <T> C0976r<T> m3587a(C1073e c1073e, C1061a<T> c1061a) {
                return c1061a.m3772a() != Timestamp.class ? null : new C10031(this, c1073e.m3799a(Date.class));
            }
        };
        f2080L = new C0976r<Calendar>() {
            public Calendar m3588a(C0984a c0984a) {
                int i = 0;
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                c0984a.m3450c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (c0984a.m3453f() != C1063b.END_OBJECT) {
                    String g = c0984a.m3454g();
                    int m = c0984a.m3460m();
                    if ("year".equals(g)) {
                        i6 = m;
                    } else if ("month".equals(g)) {
                        i5 = m;
                    } else if ("dayOfMonth".equals(g)) {
                        i4 = m;
                    } else if ("hourOfDay".equals(g)) {
                        i3 = m;
                    } else if ("minute".equals(g)) {
                        i2 = m;
                    } else if ("second".equals(g)) {
                        i = m;
                    }
                }
                c0984a.m3451d();
                return new GregorianCalendar(i6, i5, i4, i3, i2, i);
            }

            public void m3590a(C0987c c0987c, Calendar calendar) {
                if (calendar == null) {
                    c0987c.m3505f();
                    return;
                }
                c0987c.m3502d();
                c0987c.m3494a("year");
                c0987c.m3492a((long) calendar.get(1));
                c0987c.m3494a("month");
                c0987c.m3492a((long) calendar.get(2));
                c0987c.m3494a("dayOfMonth");
                c0987c.m3492a((long) calendar.get(5));
                c0987c.m3494a("hourOfDay");
                c0987c.m3492a((long) calendar.get(11));
                c0987c.m3494a("minute");
                c0987c.m3492a((long) calendar.get(12));
                c0987c.m3494a("second");
                c0987c.m3492a((long) calendar.get(13));
                c0987c.m3504e();
            }

            public /* synthetic */ Object m3591b(C0984a c0984a) {
                return m3588a(c0984a);
            }
        };
        f2081M = C1014m.m3676b(Calendar.class, GregorianCalendar.class, f2080L);
        f2082N = new C0976r<Locale>() {
            public Locale m3592a(C0984a c0984a) {
                if (c0984a.m3453f() == C1063b.NULL) {
                    c0984a.m3457j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(c0984a.m3455h(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            public void m3594a(C0987c c0987c, Locale locale) {
                c0987c.m3497b(locale == null ? null : locale.toString());
            }

            public /* synthetic */ Object m3595b(C0984a c0984a) {
                return m3592a(c0984a);
            }
        };
        f2083O = C1014m.m3673a(Locale.class, f2082N);
        f2084P = new C0976r<C1075i>() {
            public C1075i m3596a(C0984a c0984a) {
                C1075i c1076g;
                switch (AnonymousClass25.f2066a[c0984a.m3453f().ordinal()]) {
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        return new C1081n(new C1034f(c0984a.m3455h()));
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        return new C1081n(Boolean.valueOf(c0984a.m3456i()));
                    case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                        return new C1081n(c0984a.m3455h());
                    case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                        c0984a.m3457j();
                        return C1079k.f2230a;
                    case C1096c.MapAttrs_cameraZoom /*5*/:
                        c1076g = new C1076g();
                        c0984a.m3447a();
                        while (c0984a.m3452e()) {
                            c1076g.m3823a(m3596a(c0984a));
                        }
                        c0984a.m3449b();
                        return c1076g;
                    case C1096c.MapAttrs_liteMode /*6*/:
                        c1076g = new C1080l();
                        c0984a.m3450c();
                        while (c0984a.m3452e()) {
                            c1076g.m3829a(c0984a.m3454g(), m3596a(c0984a));
                        }
                        c0984a.m3451d();
                        return c1076g;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            public void m3597a(C0987c c0987c, C1075i c1075i) {
                if (c1075i == null || c1075i.m3817j()) {
                    c0987c.m3505f();
                } else if (c1075i.m3816i()) {
                    C1081n m = c1075i.m3820m();
                    if (m.m3842p()) {
                        c0987c.m3493a(m.m3833a());
                    } else if (m.m3841o()) {
                        c0987c.m3495a(m.m3839f());
                    } else {
                        c0987c.m3497b(m.m3835b());
                    }
                } else if (c1075i.m3814g()) {
                    c0987c.m3496b();
                    Iterator it = c1075i.m3819l().iterator();
                    while (it.hasNext()) {
                        m3597a(c0987c, (C1075i) it.next());
                    }
                    c0987c.m3499c();
                } else if (c1075i.m3815h()) {
                    c0987c.m3502d();
                    for (Entry entry : c1075i.m3818k().m3830o()) {
                        c0987c.m3494a((String) entry.getKey());
                        m3597a(c0987c, (C1075i) entry.getValue());
                    }
                    c0987c.m3504e();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + c1075i.getClass());
                }
            }

            public /* synthetic */ Object m3599b(C0984a c0984a) {
                return m3596a(c0984a);
            }
        };
        f2085Q = C1014m.m3675b(C1075i.class, f2084P);
        f2086R = new C0974s() {
            public <T> C0976r<T> m3600a(C1073e c1073e, C1061a<T> c1061a) {
                Class a = c1061a.m3772a();
                if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
                    return null;
                }
                if (!a.isEnum()) {
                    a = a.getSuperclass();
                }
                return new C1013a(a);
            }
        };
    }

    public static <TT> C0974s m3673a(Class<TT> cls, C0976r<TT> c0976r) {
        return new AnonymousClass20(cls, c0976r);
    }

    public static <TT> C0974s m3674a(Class<TT> cls, Class<TT> cls2, C0976r<? super TT> c0976r) {
        return new AnonymousClass21(cls, cls2, c0976r);
    }

    public static <TT> C0974s m3675b(Class<TT> cls, C0976r<TT> c0976r) {
        return new AnonymousClass24(cls, c0976r);
    }

    public static <TT> C0974s m3676b(Class<TT> cls, Class<? extends TT> cls2, C0976r<? super TT> c0976r) {
        return new AnonymousClass23(cls, cls2, c0976r);
    }
}
