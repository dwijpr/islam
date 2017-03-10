package com.google.android.gms.internal;

import java.util.HashMap;

public class db extends ax<Integer, Long> {
    public Long f3731a;
    public Long f3732b;

    public db(String str) {
        m5678a(str);
    }

    protected HashMap<Integer, Long> m5677a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f3731a);
        hashMap.put(Integer.valueOf(1), this.f3732b);
        return hashMap;
    }

    protected void m5678a(String str) {
        HashMap b = ax.m5222b(str);
        if (b != null) {
            this.f3731a = (Long) b.get(Integer.valueOf(0));
            this.f3732b = (Long) b.get(Integer.valueOf(1));
        }
    }
}
