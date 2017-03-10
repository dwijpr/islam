package com.andi.alquran.p023e;

import org.json.JSONObject;

/* renamed from: com.andi.alquran.e.g */
public class C0908g {
    private final String f1795a;
    private final String f1796b;
    private final String f1797c;
    private final String f1798d;
    private final long f1799e;
    private final String f1800f;
    private final String f1801g;
    private final String f1802h;
    private final String f1803i;

    public C0908g(String str, String str2) {
        this.f1795a = str;
        this.f1803i = str2;
        JSONObject jSONObject = new JSONObject(this.f1803i);
        this.f1796b = jSONObject.optString("productId");
        this.f1797c = jSONObject.optString("type");
        this.f1798d = jSONObject.optString("price");
        this.f1799e = jSONObject.optLong("price_amount_micros");
        this.f1800f = jSONObject.optString("price_currency_code");
        this.f1801g = jSONObject.optString("title");
        this.f1802h = jSONObject.optString("description");
    }

    public String m3152a() {
        return this.f1796b;
    }

    public String toString() {
        return "SkuDetails:" + this.f1803i;
    }
}
