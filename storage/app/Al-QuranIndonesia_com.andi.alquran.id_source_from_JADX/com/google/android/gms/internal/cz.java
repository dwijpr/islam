package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public interface cz {

    /* renamed from: com.google.android.gms.internal.cz.a */
    public static class C1516a {
        public byte[] f3717a;
        public String f3718b;
        public long f3719c;
        public long f3720d;
        public long f3721e;
        public long f3722f;
        public Map<String, String> f3723g;

        public C1516a() {
            this.f3723g = Collections.emptyMap();
        }

        public boolean m5668a() {
            return this.f3721e < System.currentTimeMillis();
        }

        public boolean m5669b() {
            return this.f3722f < System.currentTimeMillis();
        }
    }

    C1516a m5670a(String str);

    void m5671a();

    void m5672a(String str, C1516a c1516a);
}
