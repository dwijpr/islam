package com.google.android.gms.internal;

import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1279d.C1278a;
import com.google.android.gms.common.api.C1286l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p042b.C1252e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.internal.f */
public class C1543f {
    private final Map<wo<?>, Boolean> f3933a;
    private final Map<C1252e<?>, Boolean> f3934b;

    /* renamed from: com.google.android.gms.internal.f.1 */
    class C15421 implements C1278a {
        final /* synthetic */ wo f3931a;
        final /* synthetic */ C1543f f3932b;

        C15421(C1543f c1543f, wo woVar) {
            this.f3932b = c1543f;
            this.f3931a = woVar;
        }

        public void m6036a(Status status) {
            this.f3932b.f3933a.remove(this.f3931a);
        }
    }

    public C1543f() {
        this.f3933a = Collections.synchronizedMap(new WeakHashMap());
        this.f3934b = Collections.synchronizedMap(new WeakHashMap());
    }

    private void m6038a(boolean z, Status status) {
        synchronized (this.f3933a) {
            Map hashMap = new HashMap(this.f3933a);
        }
        synchronized (this.f3934b) {
            Map hashMap2 = new HashMap(this.f3934b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((wo) entry.getKey()).m5080d(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C1252e) entry2.getKey()).m4429b(new C1286l(status));
            }
        }
    }

    void m6039a(wo<? extends C1263g> woVar, boolean z) {
        this.f3933a.put(woVar, Boolean.valueOf(z));
        woVar.m5075a(new C15421(this, woVar));
    }

    boolean m6040a() {
        return (this.f3933a.isEmpty() && this.f3934b.isEmpty()) ? false : true;
    }

    public void m6041b() {
        m6038a(false, C1895p.f5322a);
    }

    public void m6042c() {
        m6038a(true, ak.f3323a);
    }
}
