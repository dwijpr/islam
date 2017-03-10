package com.google.android.gms.analytics.p040a;

import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.a.c */
public class C1208c {
    Map<String, String> f2820a;

    public C1208c() {
        this.f2820a = new HashMap();
    }

    public Map<String, String> m4193a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f2820a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return C1230m.m4360a(this.f2820a);
    }
}
