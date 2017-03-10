package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class ty extends C1230m<ty> {
    public String f6017a;
    public String f6018b;
    public String f6019c;

    public String m9106a() {
        return this.f6017a;
    }

    public /* synthetic */ void m9107a(C1230m c1230m) {
        m9108a((ty) c1230m);
    }

    public void m9108a(ty tyVar) {
        if (!TextUtils.isEmpty(this.f6017a)) {
            tyVar.m9109a(this.f6017a);
        }
        if (!TextUtils.isEmpty(this.f6018b)) {
            tyVar.m9111b(this.f6018b);
        }
        if (!TextUtils.isEmpty(this.f6019c)) {
            tyVar.m9113c(this.f6019c);
        }
    }

    public void m9109a(String str) {
        this.f6017a = str;
    }

    public String m9110b() {
        return this.f6018b;
    }

    public void m9111b(String str) {
        this.f6018b = str;
    }

    public String m9112c() {
        return this.f6019c;
    }

    public void m9113c(String str) {
        this.f6019c = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.f6017a);
        hashMap.put("action", this.f6018b);
        hashMap.put("target", this.f6019c);
        return C1230m.m4358a((Object) hashMap);
    }
}
