package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class tu extends C1230m<tu> {
    private String f5996a;
    private String f5997b;
    private String f5998c;
    private long f5999d;

    public String m9059a() {
        return this.f5996a;
    }

    public void m9060a(long j) {
        this.f5999d = j;
    }

    public /* synthetic */ void m9061a(C1230m c1230m) {
        m9062a((tu) c1230m);
    }

    public void m9062a(tu tuVar) {
        if (!TextUtils.isEmpty(this.f5996a)) {
            tuVar.m9063a(this.f5996a);
        }
        if (!TextUtils.isEmpty(this.f5997b)) {
            tuVar.m9065b(this.f5997b);
        }
        if (!TextUtils.isEmpty(this.f5998c)) {
            tuVar.m9067c(this.f5998c);
        }
        if (this.f5999d != 0) {
            tuVar.m9060a(this.f5999d);
        }
    }

    public void m9063a(String str) {
        this.f5996a = str;
    }

    public String m9064b() {
        return this.f5997b;
    }

    public void m9065b(String str) {
        this.f5997b = str;
    }

    public String m9066c() {
        return this.f5998c;
    }

    public void m9067c(String str) {
        this.f5998c = str;
    }

    public long m9068d() {
        return this.f5999d;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.f5996a);
        hashMap.put("action", this.f5997b);
        hashMap.put("label", this.f5998c);
        hashMap.put("value", Long.valueOf(this.f5999d));
        return C1230m.m4358a((Object) hashMap);
    }
}
