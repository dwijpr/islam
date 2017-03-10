package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.internal.wm.C1475a;

/* renamed from: com.google.android.gms.internal.q */
public class C1924q<O extends C1240a> extends C1614h {
    private final C1288n<O> f5534a;

    public C1924q(C1288n<O> c1288n) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f5534a = c1288n;
    }

    public Looper m8243a() {
        return this.f5534a.m4570d();
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m8244a(T t) {
        return this.f5534a.m4566a(t);
    }

    public void m8245a(aj ajVar) {
    }

    public void m8246b(aj ajVar) {
    }
}
