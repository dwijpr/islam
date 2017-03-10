package com.andi.alquran.p023e;

import org.json.JSONObject;

/* renamed from: com.andi.alquran.e.e */
public class C0906e {
    String f1784a;
    String f1785b;
    String f1786c;
    String f1787d;
    long f1788e;
    int f1789f;
    String f1790g;
    String f1791h;
    String f1792i;
    String f1793j;
    boolean f1794k;

    public C0906e(String str, String str2, String str3) {
        this.f1784a = str;
        this.f1792i = str2;
        JSONObject jSONObject = new JSONObject(this.f1792i);
        this.f1785b = jSONObject.optString("orderId");
        this.f1786c = jSONObject.optString("packageName");
        this.f1787d = jSONObject.optString("productId");
        this.f1788e = jSONObject.optLong("purchaseTime");
        this.f1789f = jSONObject.optInt("purchaseState");
        this.f1790g = jSONObject.optString("developerPayload");
        this.f1791h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f1794k = jSONObject.optBoolean("autoRenewing");
        this.f1793j = str3;
    }

    public String m3145a() {
        return this.f1784a;
    }

    public String m3146b() {
        return this.f1787d;
    }

    public String m3147c() {
        return this.f1790g;
    }

    public String m3148d() {
        return this.f1791h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f1784a + "):" + this.f1792i;
    }
}
