package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzv;

@op
public abstract class ib<T> {
    private final int f4324a;
    private final String f4325b;
    private final T f4326c;

    /* renamed from: com.google.android.gms.internal.ib.1 */
    class C16411 extends ib<Boolean> {
        C16411(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object m6683a(SharedPreferences sharedPreferences) {
            return m6684b(sharedPreferences);
        }

        public Boolean m6684b(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(m6680a(), ((Boolean) m6681b()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.2 */
    class C16422 extends ib<Integer> {
        C16422(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object m6685a(SharedPreferences sharedPreferences) {
            return m6686b(sharedPreferences);
        }

        public Integer m6686b(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(m6680a(), ((Integer) m6681b()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.3 */
    class C16433 extends ib<Long> {
        C16433(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object m6687a(SharedPreferences sharedPreferences) {
            return m6688b(sharedPreferences);
        }

        public Long m6688b(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(m6680a(), ((Long) m6681b()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.4 */
    class C16444 extends ib<Float> {
        C16444(int i, String str, Float f) {
            super(str, f, null);
        }

        public /* synthetic */ Object m6689a(SharedPreferences sharedPreferences) {
            return m6690b(sharedPreferences);
        }

        public Float m6690b(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(m6680a(), ((Float) m6681b()).floatValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.5 */
    class C16455 extends ib<String> {
        C16455(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object m6691a(SharedPreferences sharedPreferences) {
            return m6692b(sharedPreferences);
        }

        public String m6692b(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(m6680a(), (String) m6681b());
        }
    }

    private ib(int i, String str, T t) {
        this.f4324a = i;
        this.f4325b = str;
        this.f4326c = t;
        zzv.zzcU().m6694a(this);
    }

    public static ib<String> m6672a(int i, String str) {
        ib<String> a = m6677a(i, str, null);
        zzv.zzcU().m6696b(a);
        return a;
    }

    public static ib<Float> m6673a(int i, String str, float f) {
        return new C16444(i, str, Float.valueOf(f));
    }

    public static ib<Integer> m6674a(int i, String str, int i2) {
        return new C16422(i, str, Integer.valueOf(i2));
    }

    public static ib<Long> m6675a(int i, String str, long j) {
        return new C16433(i, str, Long.valueOf(j));
    }

    public static ib<Boolean> m6676a(int i, String str, Boolean bool) {
        return new C16411(i, str, bool);
    }

    public static ib<String> m6677a(int i, String str, String str2) {
        return new C16455(i, str, str2);
    }

    public static ib<String> m6678b(int i, String str) {
        ib<String> a = m6677a(i, str, null);
        zzv.zzcU().m6697c(a);
        return a;
    }

    protected abstract T m6679a(SharedPreferences sharedPreferences);

    public String m6680a() {
        return this.f4325b;
    }

    public T m6681b() {
        return this.f4326c;
    }

    public T m6682c() {
        return zzv.zzcV().m6700a(this);
    }
}
