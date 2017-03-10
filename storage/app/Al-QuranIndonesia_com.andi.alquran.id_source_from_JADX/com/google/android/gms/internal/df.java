package com.google.android.gms.internal;

import java.util.HashMap;

public class df extends ax<Integer, Long> {
    public Long f3770a;

    public df(String str) {
        m5724a(str);
    }

    protected HashMap<Integer, Long> m5723a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f3770a);
        return hashMap;
    }

    protected void m5724a(String str) {
        HashMap b = ax.m5222b(str);
        if (b != null) {
            this.f3770a = (Long) b.get(Integer.valueOf(0));
        }
    }
}
