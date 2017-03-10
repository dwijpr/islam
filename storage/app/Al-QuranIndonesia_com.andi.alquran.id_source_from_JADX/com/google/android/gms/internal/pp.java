package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.po.C1917a;
import java.util.WeakHashMap;

@op
public final class pp {
    private WeakHashMap<Context, C1918a> f5517a;

    /* renamed from: com.google.android.gms.internal.pp.a */
    private class C1918a {
        public final long f5515a;
        public final po f5516b;

        public C1918a(pp ppVar, po poVar) {
            this.f5515a = zzv.zzcP().m4926a();
            this.f5516b = poVar;
        }

        public boolean m8199a() {
            return ((Long) C1648if.ba.m6682c()).longValue() + this.f5515a < zzv.zzcP().m4926a();
        }
    }

    public pp() {
        this.f5517a = new WeakHashMap();
    }

    public po m8200a(Context context) {
        C1918a c1918a = (C1918a) this.f5517a.get(context);
        po a = (c1918a == null || c1918a.m8199a() || !((Boolean) C1648if.aZ.m6682c()).booleanValue()) ? new C1917a(context).m8198a() : new C1917a(context, c1918a.f5516b).m8198a();
        this.f5517a.put(context, new C1918a(this, a));
        return a;
    }
}
