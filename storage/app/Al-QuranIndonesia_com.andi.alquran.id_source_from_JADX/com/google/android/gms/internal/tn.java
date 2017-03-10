package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class tn extends C1230m<tn> {
    private String f5969a;
    private String f5970b;
    private String f5971c;
    private String f5972d;

    public String m8995a() {
        return this.f5969a;
    }

    public /* synthetic */ void m8996a(C1230m c1230m) {
        m8997a((tn) c1230m);
    }

    public void m8997a(tn tnVar) {
        if (!TextUtils.isEmpty(this.f5969a)) {
            tnVar.m8998a(this.f5969a);
        }
        if (!TextUtils.isEmpty(this.f5970b)) {
            tnVar.m9000b(this.f5970b);
        }
        if (!TextUtils.isEmpty(this.f5971c)) {
            tnVar.m9002c(this.f5971c);
        }
        if (!TextUtils.isEmpty(this.f5972d)) {
            tnVar.m9004d(this.f5972d);
        }
    }

    public void m8998a(String str) {
        this.f5969a = str;
    }

    public String m8999b() {
        return this.f5970b;
    }

    public void m9000b(String str) {
        this.f5970b = str;
    }

    public String m9001c() {
        return this.f5971c;
    }

    public void m9002c(String str) {
        this.f5971c = str;
    }

    public String m9003d() {
        return this.f5972d;
    }

    public void m9004d(String str) {
        this.f5972d = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.f5969a);
        hashMap.put("appVersion", this.f5970b);
        hashMap.put("appId", this.f5971c);
        hashMap.put("appInstallerId", this.f5972d);
        return C1230m.m4358a((Object) hashMap);
    }
}
