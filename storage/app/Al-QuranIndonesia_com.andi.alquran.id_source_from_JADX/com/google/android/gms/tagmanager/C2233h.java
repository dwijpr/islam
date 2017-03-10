package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.aw.C1450a;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.h */
abstract class C2233h {
    private final Set<String> f7126a;

    public abstract C1450a m10254a(Map<String, C1450a> map);

    public abstract boolean m10255a();

    boolean m10256a(Set<String> set) {
        return set.containsAll(this.f7126a);
    }

    public Set<String> m10257b() {
        return this.f7126a;
    }
}
