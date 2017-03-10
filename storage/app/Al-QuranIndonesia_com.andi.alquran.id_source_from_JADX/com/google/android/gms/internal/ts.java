package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class ts extends C1230m<ts> {
    public int f5986a;
    public int f5987b;
    public int f5988c;
    public int f5989d;
    public int f5990e;
    private String f5991f;

    public int m9038a() {
        return this.f5986a;
    }

    public void m9039a(int i) {
        this.f5986a = i;
    }

    public /* synthetic */ void m9040a(C1230m c1230m) {
        m9041a((ts) c1230m);
    }

    public void m9041a(ts tsVar) {
        if (this.f5986a != 0) {
            tsVar.m9039a(this.f5986a);
        }
        if (this.f5987b != 0) {
            tsVar.m9044b(this.f5987b);
        }
        if (this.f5988c != 0) {
            tsVar.m9046c(this.f5988c);
        }
        if (this.f5989d != 0) {
            tsVar.m9048d(this.f5989d);
        }
        if (this.f5990e != 0) {
            tsVar.m9050e(this.f5990e);
        }
        if (!TextUtils.isEmpty(this.f5991f)) {
            tsVar.m9042a(this.f5991f);
        }
    }

    public void m9042a(String str) {
        this.f5991f = str;
    }

    public int m9043b() {
        return this.f5987b;
    }

    public void m9044b(int i) {
        this.f5987b = i;
    }

    public int m9045c() {
        return this.f5988c;
    }

    public void m9046c(int i) {
        this.f5988c = i;
    }

    public int m9047d() {
        return this.f5989d;
    }

    public void m9048d(int i) {
        this.f5989d = i;
    }

    public int m9049e() {
        return this.f5990e;
    }

    public void m9050e(int i) {
        this.f5990e = i;
    }

    public String m9051f() {
        return this.f5991f;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.f5991f);
        hashMap.put("screenColors", Integer.valueOf(this.f5986a));
        hashMap.put("screenWidth", Integer.valueOf(this.f5987b));
        hashMap.put("screenHeight", Integer.valueOf(this.f5988c));
        hashMap.put("viewportWidth", Integer.valueOf(this.f5989d));
        hashMap.put("viewportHeight", Integer.valueOf(this.f5990e));
        return C1230m.m4358a((Object) hashMap);
    }
}
