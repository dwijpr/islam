package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C1314c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class uh {
    private final long f6063a;
    private final String f6064b;
    private final String f6065c;
    private final boolean f6066d;
    private long f6067e;
    private final Map<String, String> f6068f;

    public uh(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        C1314c.m4625a(str);
        C1314c.m4625a(str2);
        this.f6063a = j;
        this.f6064b = str;
        this.f6065c = str2;
        this.f6066d = z;
        this.f6067e = j2;
        if (map != null) {
            this.f6068f = new HashMap(map);
        } else {
            this.f6068f = Collections.emptyMap();
        }
    }

    public long m9192a() {
        return this.f6063a;
    }

    public void m9193a(long j) {
        this.f6067e = j;
    }

    public String m9194b() {
        return this.f6064b;
    }

    public String m9195c() {
        return this.f6065c;
    }

    public boolean m9196d() {
        return this.f6066d;
    }

    public long m9197e() {
        return this.f6067e;
    }

    public Map<String, String> m9198f() {
        return this.f6068f;
    }
}
