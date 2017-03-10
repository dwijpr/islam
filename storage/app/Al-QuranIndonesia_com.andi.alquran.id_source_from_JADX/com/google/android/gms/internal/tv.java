package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class tv extends C1230m<tv> {
    public String f6000a;
    public boolean f6001b;

    public String m9069a() {
        return this.f6000a;
    }

    public /* synthetic */ void m9070a(C1230m c1230m) {
        m9071a((tv) c1230m);
    }

    public void m9071a(tv tvVar) {
        if (!TextUtils.isEmpty(this.f6000a)) {
            tvVar.m9072a(this.f6000a);
        }
        if (this.f6001b) {
            tvVar.m9073a(this.f6001b);
        }
    }

    public void m9072a(String str) {
        this.f6000a = str;
    }

    public void m9073a(boolean z) {
        this.f6001b = z;
    }

    public boolean m9074b() {
        return this.f6001b;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.f6000a);
        hashMap.put("fatal", Boolean.valueOf(this.f6001b));
        return C1230m.m4358a((Object) hashMap);
    }
}
