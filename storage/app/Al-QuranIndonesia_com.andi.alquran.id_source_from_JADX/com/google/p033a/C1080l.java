package com.google.p033a;

import com.google.p033a.p035b.C1042g;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.a.l */
public final class C1080l extends C1075i {
    private final C1042g<String, C1075i> f2231a;

    public C1080l() {
        this.f2231a = new C1042g();
    }

    public void m3829a(String str, C1075i c1075i) {
        Object obj;
        if (c1075i == null) {
            obj = C1079k.f2230a;
        }
        this.f2231a.put(str, obj);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C1080l) && ((C1080l) obj).f2231a.equals(this.f2231a));
    }

    public int hashCode() {
        return this.f2231a.hashCode();
    }

    public Set<Entry<String, C1075i>> m3830o() {
        return this.f2231a.entrySet();
    }
}
