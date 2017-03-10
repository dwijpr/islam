package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.analytics.C1230m;
import com.google.android.gms.analytics.p040a.C1206a;
import com.google.android.gms.analytics.p040a.C1207b;
import com.google.android.gms.analytics.p040a.C1208c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class tt extends C1230m<tt> {
    private final List<C1206a> f5992a;
    private final List<C1208c> f5993b;
    private final Map<String, List<C1206a>> f5994c;
    private C1207b f5995d;

    public tt() {
        this.f5992a = new ArrayList();
        this.f5993b = new ArrayList();
        this.f5994c = new HashMap();
    }

    public C1207b m9052a() {
        return this.f5995d;
    }

    public void m9053a(C1206a c1206a, String str) {
        if (c1206a != null) {
            Object obj;
            if (str == null) {
                obj = BuildConfig.VERSION_NAME;
            }
            if (!this.f5994c.containsKey(obj)) {
                this.f5994c.put(obj, new ArrayList());
            }
            ((List) this.f5994c.get(obj)).add(c1206a);
        }
    }

    public /* synthetic */ void m9054a(C1230m c1230m) {
        m9055a((tt) c1230m);
    }

    public void m9055a(tt ttVar) {
        ttVar.f5992a.addAll(this.f5992a);
        ttVar.f5993b.addAll(this.f5993b);
        for (Entry entry : this.f5994c.entrySet()) {
            String str = (String) entry.getKey();
            for (C1206a a : (List) entry.getValue()) {
                ttVar.m9053a(a, str);
            }
        }
        if (this.f5995d != null) {
            ttVar.f5995d = this.f5995d;
        }
    }

    public List<C1206a> m9056b() {
        return Collections.unmodifiableList(this.f5992a);
    }

    public Map<String, List<C1206a>> m9057c() {
        return this.f5994c;
    }

    public List<C1208c> m9058d() {
        return Collections.unmodifiableList(this.f5993b);
    }

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.f5992a.isEmpty()) {
            hashMap.put("products", this.f5992a);
        }
        if (!this.f5993b.isEmpty()) {
            hashMap.put("promotions", this.f5993b);
        }
        if (!this.f5994c.isEmpty()) {
            hashMap.put("impressions", this.f5994c);
        }
        hashMap.put("productAction", this.f5995d);
        return C1230m.m4358a((Object) hashMap);
    }
}
