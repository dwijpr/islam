package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.be;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.a */
public abstract class C1413a<T> {

    /* renamed from: com.google.android.gms.flags.impl.a.a */
    public static class C1414a extends C1413a<Boolean> {

        /* renamed from: com.google.android.gms.flags.impl.a.a.1 */
        class C14121 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f3257a;
            final /* synthetic */ String f3258b;
            final /* synthetic */ Boolean f3259c;

            C14121(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f3257a = sharedPreferences;
                this.f3258b = str;
                this.f3259c = bool;
            }

            public Boolean m5030a() {
                return Boolean.valueOf(this.f3257a.getBoolean(this.f3258b, this.f3259c.booleanValue()));
            }

            public /* synthetic */ Object call() {
                return m5030a();
            }
        }

        public static Boolean m5031a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) be.m5265a(new C14121(sharedPreferences, str, bool));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.b */
    public static class C1416b extends C1413a<Integer> {

        /* renamed from: com.google.android.gms.flags.impl.a.b.1 */
        class C14151 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f3260a;
            final /* synthetic */ String f3261b;
            final /* synthetic */ Integer f3262c;

            C14151(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f3260a = sharedPreferences;
                this.f3261b = str;
                this.f3262c = num;
            }

            public Integer m5032a() {
                return Integer.valueOf(this.f3260a.getInt(this.f3261b, this.f3262c.intValue()));
            }

            public /* synthetic */ Object call() {
                return m5032a();
            }
        }

        public static Integer m5033a(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) be.m5265a(new C14151(sharedPreferences, str, num));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.c */
    public static class C1418c extends C1413a<Long> {

        /* renamed from: com.google.android.gms.flags.impl.a.c.1 */
        class C14171 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f3263a;
            final /* synthetic */ String f3264b;
            final /* synthetic */ Long f3265c;

            C14171(SharedPreferences sharedPreferences, String str, Long l) {
                this.f3263a = sharedPreferences;
                this.f3264b = str;
                this.f3265c = l;
            }

            public Long m5034a() {
                return Long.valueOf(this.f3263a.getLong(this.f3264b, this.f3265c.longValue()));
            }

            public /* synthetic */ Object call() {
                return m5034a();
            }
        }

        public static Long m5035a(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) be.m5265a(new C14171(sharedPreferences, str, l));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.d */
    public static class C1420d extends C1413a<String> {

        /* renamed from: com.google.android.gms.flags.impl.a.d.1 */
        class C14191 implements Callable<String> {
            final /* synthetic */ SharedPreferences f3266a;
            final /* synthetic */ String f3267b;
            final /* synthetic */ String f3268c;

            C14191(SharedPreferences sharedPreferences, String str, String str2) {
                this.f3266a = sharedPreferences;
                this.f3267b = str;
                this.f3268c = str2;
            }

            public String m5036a() {
                return this.f3266a.getString(this.f3267b, this.f3268c);
            }

            public /* synthetic */ Object call() {
                return m5036a();
            }
        }

        public static String m5037a(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) be.m5265a(new C14191(sharedPreferences, str, str2));
        }
    }
}
