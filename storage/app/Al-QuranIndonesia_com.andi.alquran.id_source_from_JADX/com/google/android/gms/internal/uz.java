package com.google.android.gms.internal;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.common.internal.C1314c;

public final class uz {
    public static C2037a<Integer> f6141A;
    public static C2037a<String> f6142B;
    public static C2037a<Integer> f6143C;
    public static C2037a<Long> f6144D;
    public static C2037a<Integer> f6145E;
    public static C2037a<Integer> f6146F;
    public static C2037a<Long> f6147G;
    public static C2037a<String> f6148H;
    public static C2037a<Integer> f6149I;
    public static C2037a<Boolean> f6150J;
    public static C2037a<Long> f6151K;
    public static C2037a<Long> f6152L;
    public static C2037a<Long> f6153M;
    public static C2037a<Long> f6154N;
    public static C2037a<Long> f6155O;
    public static C2037a<Long> f6156P;
    public static C2037a<Long> f6157Q;
    public static C2037a<Boolean> f6158a;
    public static C2037a<Boolean> f6159b;
    public static C2037a<String> f6160c;
    public static C2037a<Long> f6161d;
    public static C2037a<Float> f6162e;
    public static C2037a<Integer> f6163f;
    public static C2037a<Integer> f6164g;
    public static C2037a<Integer> f6165h;
    public static C2037a<Long> f6166i;
    public static C2037a<Long> f6167j;
    public static C2037a<Long> f6168k;
    public static C2037a<Long> f6169l;
    public static C2037a<Long> f6170m;
    public static C2037a<Long> f6171n;
    public static C2037a<Integer> f6172o;
    public static C2037a<Integer> f6173p;
    public static C2037a<String> f6174q;
    public static C2037a<String> f6175r;
    public static C2037a<String> f6176s;
    public static C2037a<String> f6177t;
    public static C2037a<Integer> f6178u;
    public static C2037a<String> f6179v;
    public static C2037a<String> f6180w;
    public static C2037a<Integer> f6181x;
    public static C2037a<Integer> f6182y;
    public static C2037a<Integer> f6183z;

    /* renamed from: com.google.android.gms.internal.uz.a */
    public static final class C2037a<V> {
        private final V f6139a;
        private final al<V> f6140b;

        private C2037a(al<V> alVar, V v) {
            C1314c.m4623a((Object) alVar);
            this.f6140b = alVar;
            this.f6139a = v;
        }

        static C2037a<Float> m9373a(String str, float f) {
            return C2037a.m9374a(str, f, f);
        }

        static C2037a<Float> m9374a(String str, float f, float f2) {
            return new C2037a(al.m5114a(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static C2037a<Integer> m9375a(String str, int i) {
            return C2037a.m9376a(str, i, i);
        }

        static C2037a<Integer> m9376a(String str, int i, int i2) {
            return new C2037a(al.m5115a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static C2037a<Long> m9377a(String str, long j) {
            return C2037a.m9378a(str, j, j);
        }

        static C2037a<Long> m9378a(String str, long j, long j2) {
            return new C2037a(al.m5116a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static C2037a<String> m9379a(String str, String str2) {
            return C2037a.m9380a(str, str2, str2);
        }

        static C2037a<String> m9380a(String str, String str2, String str3) {
            return new C2037a(al.m5117a(str, str3), str2);
        }

        static C2037a<Boolean> m9381a(String str, boolean z) {
            return C2037a.m9382a(str, z, z);
        }

        static C2037a<Boolean> m9382a(String str, boolean z, boolean z2) {
            return new C2037a(al.m5118a(str, z2), Boolean.valueOf(z));
        }

        public V m9383a() {
            return this.f6139a;
        }
    }

    static {
        f6158a = C2037a.m9381a("analytics.service_enabled", false);
        f6159b = C2037a.m9381a("analytics.service_client_enabled", true);
        f6160c = C2037a.m9380a("analytics.log_tag", "GAv4", "GAv4-SVC");
        f6161d = C2037a.m9377a("analytics.max_tokens", 60);
        f6162e = C2037a.m9373a("analytics.tokens_per_sec", 0.5f);
        f6163f = C2037a.m9376a("analytics.max_stored_hits", 2000, 20000);
        f6164g = C2037a.m9375a("analytics.max_stored_hits_per_app", 2000);
        f6165h = C2037a.m9375a("analytics.max_stored_properties_per_app", 100);
        f6166i = C2037a.m9378a("analytics.local_dispatch_millis", 1800000, 120000);
        f6167j = C2037a.m9378a("analytics.initial_local_dispatch_millis", 5000, 5000);
        f6168k = C2037a.m9377a("analytics.min_local_dispatch_millis", 120000);
        f6169l = C2037a.m9377a("analytics.max_local_dispatch_millis", 7200000);
        f6170m = C2037a.m9377a("analytics.dispatch_alarm_millis", 7200000);
        f6171n = C2037a.m9377a("analytics.max_dispatch_alarm_millis", 32400000);
        f6172o = C2037a.m9375a("analytics.max_hits_per_dispatch", 20);
        f6173p = C2037a.m9375a("analytics.max_hits_per_batch", 20);
        f6174q = C2037a.m9379a("analytics.insecure_host", "http://www.google-analytics.com");
        f6175r = C2037a.m9379a("analytics.secure_host", "https://ssl.google-analytics.com");
        f6176s = C2037a.m9379a("analytics.simple_endpoint", "/collect");
        f6177t = C2037a.m9379a("analytics.batching_endpoint", "/batch");
        f6178u = C2037a.m9375a("analytics.max_get_length", 2036);
        f6179v = C2037a.m9380a("analytics.batching_strategy.k", un.BATCH_BY_COUNT.name(), un.BATCH_BY_COUNT.name());
        f6180w = C2037a.m9379a("analytics.compression_strategy.k", up.GZIP.name());
        f6181x = C2037a.m9375a("analytics.max_hits_per_request.k", 20);
        f6182y = C2037a.m9375a("analytics.max_hit_length.k", (int) FragmentTransaction.TRANSIT_EXIT_MASK);
        f6183z = C2037a.m9375a("analytics.max_post_length.k", (int) FragmentTransaction.TRANSIT_EXIT_MASK);
        f6141A = C2037a.m9375a("analytics.max_batch_post_length", (int) FragmentTransaction.TRANSIT_EXIT_MASK);
        f6142B = C2037a.m9379a("analytics.fallback_responses.k", "404,502");
        f6143C = C2037a.m9375a("analytics.batch_retry_interval.seconds.k", 3600);
        f6144D = C2037a.m9377a("analytics.service_monitor_interval", 86400000);
        f6145E = C2037a.m9375a("analytics.http_connection.connect_timeout_millis", 60000);
        f6146F = C2037a.m9375a("analytics.http_connection.read_timeout_millis", 61000);
        f6147G = C2037a.m9377a("analytics.campaigns.time_limit", 86400000);
        f6148H = C2037a.m9379a("analytics.first_party_experiment_id", BuildConfig.VERSION_NAME);
        f6149I = C2037a.m9375a("analytics.first_party_experiment_variant", 0);
        f6150J = C2037a.m9381a("analytics.test.disable_receiver", false);
        f6151K = C2037a.m9378a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
        f6152L = C2037a.m9377a("analytics.service_client.connect_timeout_millis", 5000);
        f6153M = C2037a.m9377a("analytics.service_client.second_connect_delay_millis", 5000);
        f6154N = C2037a.m9377a("analytics.service_client.unexpected_reconnect_millis", 60000);
        f6155O = C2037a.m9377a("analytics.service_client.reconnect_throttle_millis", 1800000);
        f6156P = C2037a.m9377a("analytics.monitoring.sample_period_millis", 86400000);
        f6157Q = C2037a.m9377a("analytics.initialization_warning_threshold", 5000);
    }
}
