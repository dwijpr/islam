package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@op
public class in {
    private final Map<String, im> f4415a;
    private final io f4416b;

    public in(io ioVar) {
        this.f4416b = ioVar;
        this.f4415a = new HashMap();
    }

    public io m6737a() {
        return this.f4416b;
    }

    public void m6738a(String str, im imVar) {
        this.f4415a.put(str, imVar);
    }

    public void m6739a(String str, String str2, long j) {
        ik.m6726a(this.f4416b, (im) this.f4415a.get(str2), j, str);
        this.f4415a.put(str, ik.m6725a(this.f4416b, j));
    }
}
