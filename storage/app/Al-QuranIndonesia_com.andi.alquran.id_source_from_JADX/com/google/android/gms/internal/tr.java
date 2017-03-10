package com.google.android.gms.internal;

import com.google.android.gms.analytics.C1230m;
import com.google.android.gms.common.internal.C1314c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class tr extends C1230m<tr> {
    private final Map<String, Object> f5985a;

    public tr() {
        this.f5985a = new HashMap();
    }

    private String m9033a(String str) {
        C1314c.m4625a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        C1314c.m4626a(str, (Object) "Name can not be empty or \"&\"");
        return str;
    }

    public Map<String, Object> m9034a() {
        return Collections.unmodifiableMap(this.f5985a);
    }

    public /* synthetic */ void m9035a(C1230m c1230m) {
        m9036a((tr) c1230m);
    }

    public void m9036a(tr trVar) {
        C1314c.m4623a((Object) trVar);
        trVar.f5985a.putAll(this.f5985a);
    }

    public void m9037a(String str, String str2) {
        this.f5985a.put(m9033a(str), str2);
    }

    public String toString() {
        return C1230m.m4358a((Object) this.f5985a);
    }
}
