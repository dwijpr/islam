package com.google.android.gms.internal;

import com.google.android.gms.analytics.C1230m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class tp extends C1230m<tp> {
    private Map<Integer, String> f5983a;

    public tp() {
        this.f5983a = new HashMap(4);
    }

    public Map<Integer, String> m9027a() {
        return Collections.unmodifiableMap(this.f5983a);
    }

    public /* synthetic */ void m9028a(C1230m c1230m) {
        m9029a((tp) c1230m);
    }

    public void m9029a(tp tpVar) {
        tpVar.f5983a.putAll(this.f5983a);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f5983a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return C1230m.m4358a((Object) hashMap);
    }
}
