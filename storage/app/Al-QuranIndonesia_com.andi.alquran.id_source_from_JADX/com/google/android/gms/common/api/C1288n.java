package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.C1895p;
import com.google.android.gms.internal.C1895p.C1892a;
import com.google.android.gms.internal.C1924q;
import com.google.android.gms.internal.ag;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.wi;
import com.google.android.gms.internal.wj;
import com.google.android.gms.internal.wm.C1475a;

/* renamed from: com.google.android.gms.common.api.n */
public abstract class C1288n<O extends C1240a> {
    protected final C1895p f3013a;
    private final Context f3014b;
    private final C1274a<O> f3015c;
    private final O f3016d;
    private final wj<O> f3017e;
    private final Looper f3018f;
    private final int f3019g;
    private final C1277c f3020h;
    private final ah f3021i;

    protected C1288n(Context context, C1274a<O> c1274a, Looper looper) {
        C1314c.m4624a((Object) context, (Object) "Null context is not permitted.");
        C1314c.m4624a((Object) c1274a, (Object) "Api must not be null.");
        C1314c.m4624a((Object) looper, (Object) "Looper must not be null.");
        this.f3014b = context.getApplicationContext();
        this.f3015c = c1274a;
        this.f3016d = null;
        this.f3018f = looper;
        this.f3017e = wj.m9670a(c1274a);
        this.f3020h = new C1924q(this);
        this.f3013a = C1895p.m8036a(this.f3014b);
        this.f3019g = this.f3013a.m8060b();
        this.f3021i = new wi();
    }

    public C1288n(Context context, C1274a<O> c1274a, O o, Looper looper, ah ahVar) {
        C1314c.m4624a((Object) context, (Object) "Null context is not permitted.");
        C1314c.m4624a((Object) c1274a, (Object) "Api must not be null.");
        C1314c.m4624a((Object) looper, (Object) "Looper must not be null.");
        this.f3014b = context.getApplicationContext();
        this.f3015c = c1274a;
        this.f3016d = o;
        this.f3018f = looper;
        this.f3017e = wj.m9671a(this.f3015c, this.f3016d);
        this.f3020h = new C1924q(this);
        this.f3013a = C1895p.m8036a(this.f3014b);
        this.f3019g = this.f3013a.m8060b();
        this.f3021i = ahVar;
        this.f3013a.m8056a(this);
    }

    public C1288n(Context context, C1274a<O> c1274a, O o, ah ahVar) {
        this(context, c1274a, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper(), ahVar);
    }

    private <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m4562a(int i, T t) {
        t.m5086i();
        this.f3013a.m8057a(this, i, t);
        return t;
    }

    public C1269f m4563a(Looper looper, C1892a<O> c1892a) {
        return this.f3015c.m4526b().m4510a(this.f3014b, looper, C1338k.m4730a(this.f3014b), this.f3016d, c1892a, c1892a);
    }

    public ag m4564a(Context context, Handler handler) {
        return new ag(context, handler);
    }

    public wj<O> m4565a() {
        return this.f3017e;
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m4566a(T t) {
        return m4562a(1, (C1475a) t);
    }

    public int m4567b() {
        return this.f3019g;
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m4568b(T t) {
        return m4562a(2, (C1475a) t);
    }

    public C1277c m4569c() {
        return this.f3020h;
    }

    public Looper m4570d() {
        return this.f3018f;
    }
}
