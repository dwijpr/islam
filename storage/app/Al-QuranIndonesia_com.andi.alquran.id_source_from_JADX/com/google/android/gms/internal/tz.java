package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class tz extends C1230m<tz> {
    public String f6020a;
    public long f6021b;
    public String f6022c;
    public String f6023d;

    public String m9114a() {
        return this.f6020a;
    }

    public void m9115a(long j) {
        this.f6021b = j;
    }

    public /* synthetic */ void m9116a(C1230m c1230m) {
        m9117a((tz) c1230m);
    }

    public void m9117a(tz tzVar) {
        if (!TextUtils.isEmpty(this.f6020a)) {
            tzVar.m9118a(this.f6020a);
        }
        if (this.f6021b != 0) {
            tzVar.m9115a(this.f6021b);
        }
        if (!TextUtils.isEmpty(this.f6022c)) {
            tzVar.m9120b(this.f6022c);
        }
        if (!TextUtils.isEmpty(this.f6023d)) {
            tzVar.m9122c(this.f6023d);
        }
    }

    public void m9118a(String str) {
        this.f6020a = str;
    }

    public long m9119b() {
        return this.f6021b;
    }

    public void m9120b(String str) {
        this.f6022c = str;
    }

    public String m9121c() {
        return this.f6022c;
    }

    public void m9122c(String str) {
        this.f6023d = str;
    }

    public String m9123d() {
        return this.f6023d;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.f6020a);
        hashMap.put("timeInMillis", Long.valueOf(this.f6021b));
        hashMap.put("category", this.f6022c);
        hashMap.put("label", this.f6023d);
        return C1230m.m4358a((Object) hashMap);
    }
}
