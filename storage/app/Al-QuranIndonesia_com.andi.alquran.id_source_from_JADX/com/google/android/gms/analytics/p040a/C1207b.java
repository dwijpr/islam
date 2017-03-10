package com.google.android.gms.analytics.p040a;

import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.a.b */
public class C1207b {
    Map<String, String> f2819a;

    public Map<String, String> m4192a() {
        return new HashMap(this.f2819a);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f2819a.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return C1230m.m4360a(hashMap);
    }
}
