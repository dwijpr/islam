package com.google.android.gms.internal;

import java.util.HashMap;

public class da extends ax<Integer, Object> {
    public Long f3728a;
    public Boolean f3729b;
    public Boolean f3730c;

    public da(String str) {
        m5676a(str);
    }

    protected HashMap<Integer, Object> m5675a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f3728a);
        hashMap.put(Integer.valueOf(1), this.f3729b);
        hashMap.put(Integer.valueOf(2), this.f3730c);
        return hashMap;
    }

    protected void m5676a(String str) {
        HashMap b = ax.m5222b(str);
        if (b != null) {
            this.f3728a = (Long) b.get(Integer.valueOf(0));
            this.f3729b = (Boolean) b.get(Integer.valueOf(1));
            this.f3730c = (Boolean) b.get(Integer.valueOf(2));
        }
    }
}
