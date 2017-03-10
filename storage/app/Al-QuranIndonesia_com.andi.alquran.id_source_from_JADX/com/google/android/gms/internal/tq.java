package com.google.android.gms.internal;

import com.google.android.gms.analytics.C1230m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class tq extends C1230m<tq> {
    private Map<Integer, Double> f5984a;

    public tq() {
        this.f5984a = new HashMap(4);
    }

    public Map<Integer, Double> m9030a() {
        return Collections.unmodifiableMap(this.f5984a);
    }

    public /* synthetic */ void m9031a(C1230m c1230m) {
        m9032a((tq) c1230m);
    }

    public void m9032a(tq tqVar) {
        tqVar.f5984a.putAll(this.f5984a);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f5984a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 6).append("metric").append(valueOf).toString(), entry.getValue());
        }
        return C1230m.m4358a((Object) hashMap);
    }
}
