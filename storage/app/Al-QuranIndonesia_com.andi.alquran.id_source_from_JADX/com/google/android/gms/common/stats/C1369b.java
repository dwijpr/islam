package com.google.android.gms.common.stats;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.internal.al;

/* renamed from: com.google.android.gms.common.stats.b */
public final class C1369b {
    public static al<Integer> f3203a;
    public static al<Integer> f3204b;

    /* renamed from: com.google.android.gms.common.stats.b.a */
    public static final class C1368a {
        public static al<Integer> f3197a;
        public static al<String> f3198b;
        public static al<String> f3199c;
        public static al<String> f3200d;
        public static al<String> f3201e;
        public static al<Long> f3202f;

        static {
            f3197a = al.m5115a("gms:common:stats:connections:level", Integer.valueOf(C1370c.f3206b));
            f3198b = al.m5117a("gms:common:stats:connections:ignored_calling_processes", BuildConfig.VERSION_NAME);
            f3199c = al.m5117a("gms:common:stats:connections:ignored_calling_services", BuildConfig.VERSION_NAME);
            f3200d = al.m5117a("gms:common:stats:connections:ignored_target_processes", BuildConfig.VERSION_NAME);
            f3201e = al.m5117a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
            f3202f = al.m5116a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
        }
    }

    static {
        f3203a = al.m5115a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
        f3204b = al.m5115a("gms:common:stats:max_chunk_size", Integer.valueOf(100));
    }
}
