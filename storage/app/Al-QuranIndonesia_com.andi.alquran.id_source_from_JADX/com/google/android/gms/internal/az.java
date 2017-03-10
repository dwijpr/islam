package com.google.android.gms.internal;

import java.util.HashMap;

public class az extends ax<Integer, Object> {
    public String f3516a;
    public long f3517b;
    public String f3518c;
    public String f3519d;
    public String f3520e;

    public az() {
        this.f3516a = "E";
        this.f3517b = -1;
        this.f3518c = "E";
        this.f3519d = "E";
        this.f3520e = "E";
    }

    public az(String str) {
        this();
        m5228a(str);
    }

    protected HashMap<Integer, Object> m5227a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f3516a);
        hashMap.put(Integer.valueOf(4), this.f3520e);
        hashMap.put(Integer.valueOf(3), this.f3519d);
        hashMap.put(Integer.valueOf(2), this.f3518c);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f3517b));
        return hashMap;
    }

    protected void m5228a(String str) {
        HashMap b = ax.m5222b(str);
        if (b != null) {
            this.f3516a = b.get(Integer.valueOf(0)) == null ? "E" : (String) b.get(Integer.valueOf(0));
            this.f3517b = b.get(Integer.valueOf(1)) == null ? -1 : ((Long) b.get(Integer.valueOf(1))).longValue();
            this.f3518c = b.get(Integer.valueOf(2)) == null ? "E" : (String) b.get(Integer.valueOf(2));
            this.f3519d = b.get(Integer.valueOf(3)) == null ? "E" : (String) b.get(Integer.valueOf(3));
            this.f3520e = b.get(Integer.valueOf(4)) == null ? "E" : (String) b.get(Integer.valueOf(4));
        }
    }
}
