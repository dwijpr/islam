package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.zzmh.C2082a;

@op
public class oq {

    /* renamed from: com.google.android.gms.internal.oq.a */
    public interface C1156a {
        void zza(C1938a c1938a);
    }

    public rl m7941a(Context context, C2082a c2082a, cg cgVar, C1156a c1156a) {
        rl pdVar = c2082a.f6499b.f6435c.getBundle("sdk_less_server_data") != null ? new pd(context, c2082a, c1156a) : new or(context, c2082a, cgVar, c1156a);
        pdVar.zziw();
        return pdVar;
    }
}
