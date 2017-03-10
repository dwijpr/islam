package com.andi.alquran.p023e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.andi.alquran.e.d */
public class C0905d {
    Map<String, C0908g> f1782a;
    Map<String, C0906e> f1783b;

    C0905d() {
        this.f1782a = new HashMap();
        this.f1783b = new HashMap();
    }

    public C0906e m3141a(String str) {
        return (C0906e) this.f1783b.get(str);
    }

    void m3142a(C0906e c0906e) {
        this.f1783b.put(c0906e.m3146b(), c0906e);
    }

    void m3143a(C0908g c0908g) {
        this.f1782a.put(c0908g.m3152a(), c0908g);
    }

    List<String> m3144b(String str) {
        List<String> arrayList = new ArrayList();
        for (C0906e c0906e : this.f1783b.values()) {
            if (c0906e.m3145a().equals(str)) {
                arrayList.add(c0906e.m3146b());
            }
        }
        return arrayList;
    }
}
