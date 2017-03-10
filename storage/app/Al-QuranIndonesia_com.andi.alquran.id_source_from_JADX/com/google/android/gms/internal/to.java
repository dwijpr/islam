package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import java.util.HashMap;
import java.util.Map;

public final class to extends C1230m<to> {
    private String f5973a;
    private String f5974b;
    private String f5975c;
    private String f5976d;
    private String f5977e;
    private String f5978f;
    private String f5979g;
    private String f5980h;
    private String f5981i;
    private String f5982j;

    public String m9005a() {
        return this.f5973a;
    }

    public /* synthetic */ void m9006a(C1230m c1230m) {
        m9007a((to) c1230m);
    }

    public void m9007a(to toVar) {
        if (!TextUtils.isEmpty(this.f5973a)) {
            toVar.m9008a(this.f5973a);
        }
        if (!TextUtils.isEmpty(this.f5974b)) {
            toVar.m9010b(this.f5974b);
        }
        if (!TextUtils.isEmpty(this.f5975c)) {
            toVar.m9012c(this.f5975c);
        }
        if (!TextUtils.isEmpty(this.f5976d)) {
            toVar.m9014d(this.f5976d);
        }
        if (!TextUtils.isEmpty(this.f5977e)) {
            toVar.m9016e(this.f5977e);
        }
        if (!TextUtils.isEmpty(this.f5978f)) {
            toVar.m9018f(this.f5978f);
        }
        if (!TextUtils.isEmpty(this.f5979g)) {
            toVar.m9020g(this.f5979g);
        }
        if (!TextUtils.isEmpty(this.f5980h)) {
            toVar.m9022h(this.f5980h);
        }
        if (!TextUtils.isEmpty(this.f5981i)) {
            toVar.m9024i(this.f5981i);
        }
        if (!TextUtils.isEmpty(this.f5982j)) {
            toVar.m9026j(this.f5982j);
        }
    }

    public void m9008a(String str) {
        this.f5973a = str;
    }

    public String m9009b() {
        return this.f5974b;
    }

    public void m9010b(String str) {
        this.f5974b = str;
    }

    public String m9011c() {
        return this.f5975c;
    }

    public void m9012c(String str) {
        this.f5975c = str;
    }

    public String m9013d() {
        return this.f5976d;
    }

    public void m9014d(String str) {
        this.f5976d = str;
    }

    public String m9015e() {
        return this.f5977e;
    }

    public void m9016e(String str) {
        this.f5977e = str;
    }

    public String m9017f() {
        return this.f5978f;
    }

    public void m9018f(String str) {
        this.f5978f = str;
    }

    public String m9019g() {
        return this.f5979g;
    }

    public void m9020g(String str) {
        this.f5979g = str;
    }

    public String m9021h() {
        return this.f5980h;
    }

    public void m9022h(String str) {
        this.f5980h = str;
    }

    public String m9023i() {
        return this.f5981i;
    }

    public void m9024i(String str) {
        this.f5981i = str;
    }

    public String m9025j() {
        return this.f5982j;
    }

    public void m9026j(String str) {
        this.f5982j = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.f5973a);
        hashMap.put("source", this.f5974b);
        hashMap.put("medium", this.f5975c);
        hashMap.put("keyword", this.f5976d);
        hashMap.put("content", this.f5977e);
        hashMap.put("id", this.f5978f);
        hashMap.put("adNetworkId", this.f5979g);
        hashMap.put("gclid", this.f5980h);
        hashMap.put("dclid", this.f5981i);
        hashMap.put("aclid", this.f5982j);
        return C1230m.m4358a((Object) hashMap);
    }
}
