package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.C1314c;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.internal.z */
public class C2079z {
    private final Set<C2078x<?>> f6346a;

    public C2079z() {
        this.f6346a = Collections.newSetFromMap(new WeakHashMap());
    }

    public static <L> C2078x<L> m9702a(L l, Looper looper, String str) {
        C1314c.m4624a((Object) l, (Object) "Listener must not be null");
        C1314c.m4624a((Object) looper, (Object) "Looper must not be null");
        C1314c.m4624a((Object) str, (Object) "Listener type must not be null");
        return new C2078x(looper, l, str);
    }

    public void m9703a() {
        for (C2078x a : this.f6346a) {
            a.m9698a();
        }
        this.f6346a.clear();
    }
}
