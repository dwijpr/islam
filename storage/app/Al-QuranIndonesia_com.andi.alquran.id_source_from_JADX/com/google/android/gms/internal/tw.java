package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1230m;
import com.google.android.gms.common.internal.C1314c;
import java.util.HashMap;
import java.util.Map;

public final class tw extends C1230m<tw> {
    private String f6002a;
    private String f6003b;
    private String f6004c;
    private String f6005d;
    private boolean f6006e;
    private String f6007f;
    private boolean f6008g;
    private double f6009h;

    public String m9075a() {
        return this.f6002a;
    }

    public void m9076a(double d) {
        boolean z = d >= 0.0d && d <= 100.0d;
        C1314c.m4633b(z, "Sample rate must be between 0% and 100%");
        this.f6009h = d;
    }

    public /* synthetic */ void m9077a(C1230m c1230m) {
        m9078a((tw) c1230m);
    }

    public void m9078a(tw twVar) {
        if (!TextUtils.isEmpty(this.f6002a)) {
            twVar.m9079a(this.f6002a);
        }
        if (!TextUtils.isEmpty(this.f6003b)) {
            twVar.m9082b(this.f6003b);
        }
        if (!TextUtils.isEmpty(this.f6004c)) {
            twVar.m9085c(this.f6004c);
        }
        if (!TextUtils.isEmpty(this.f6005d)) {
            twVar.m9087d(this.f6005d);
        }
        if (this.f6006e) {
            twVar.m9080a(true);
        }
        if (!TextUtils.isEmpty(this.f6007f)) {
            twVar.m9088e(this.f6007f);
        }
        if (this.f6008g) {
            twVar.m9083b(this.f6008g);
        }
        if (this.f6009h != 0.0d) {
            twVar.m9076a(this.f6009h);
        }
    }

    public void m9079a(String str) {
        this.f6002a = str;
    }

    public void m9080a(boolean z) {
        this.f6006e = z;
    }

    public String m9081b() {
        return this.f6003b;
    }

    public void m9082b(String str) {
        this.f6003b = str;
    }

    public void m9083b(boolean z) {
        this.f6008g = z;
    }

    public String m9084c() {
        return this.f6004c;
    }

    public void m9085c(String str) {
        this.f6004c = str;
    }

    public String m9086d() {
        return this.f6005d;
    }

    public void m9087d(String str) {
        this.f6005d = str;
    }

    public void m9088e(String str) {
        this.f6007f = str;
    }

    public boolean m9089e() {
        return this.f6006e;
    }

    public String m9090f() {
        return this.f6007f;
    }

    public boolean m9091g() {
        return this.f6008g;
    }

    public double m9092h() {
        return this.f6009h;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.f6002a);
        hashMap.put("clientId", this.f6003b);
        hashMap.put("userId", this.f6004c);
        hashMap.put("androidAdId", this.f6005d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.f6006e));
        hashMap.put("sessionControl", this.f6007f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.f6008g));
        hashMap.put("sampleRate", Double.valueOf(this.f6009h));
        return C1230m.m4358a((Object) hashMap);
    }
}
