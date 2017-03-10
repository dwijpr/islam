package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.C1895p.C1892a;

/* renamed from: com.google.android.gms.internal.d */
public final class C1517d<O extends C1240a> extends C1288n<O> {
    private final C1269f f3724b;
    private final wp f3725c;
    private final C1338k f3726d;
    private final C1266b<? extends cl, cm> f3727e;

    public C1517d(Context context, C1274a<O> c1274a, Looper looper, C1269f c1269f, wp wpVar, C1338k c1338k, C1266b<? extends cl, cm> c1266b) {
        super(context, c1274a, looper);
        this.f3724b = c1269f;
        this.f3725c = wpVar;
        this.f3726d = c1338k;
        this.f3727e = c1266b;
        this.a.m8056a((C1288n) this);
    }

    public C1269f m5673a(Looper looper, C1892a<O> c1892a) {
        this.f3725c.m9697a((wq) c1892a);
        return this.f3724b;
    }

    public ag m5674a(Context context, Handler handler) {
        return new ag(context, handler, this.f3726d, this.f3727e);
    }
}
