package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.tw;
import com.google.android.gms.internal.ua;
import com.google.android.gms.internal.uf;
import java.util.ListIterator;

/* renamed from: com.google.android.gms.analytics.h */
public class C1214h extends C1213n<C1214h> {
    private final uf f2830b;
    private boolean f2831c;

    public C1214h(uf ufVar) {
        super(ufVar.m9160h(), ufVar.m9156d());
        this.f2830b = ufVar;
    }

    protected void m4205a(C1229l c1229l) {
        tw twVar = (tw) c1229l.m4347b(tw.class);
        if (TextUtils.isEmpty(twVar.m9081b())) {
            twVar.m9082b(this.f2830b.m9168p().m9316b());
        }
        if (this.f2831c && TextUtils.isEmpty(twVar.m9086d())) {
            ua o = this.f2830b.m9167o();
            twVar.m9087d(o.m9133c());
            twVar.m9080a(o.m9132b());
        }
    }

    public void m4206b(String str) {
        C1314c.m4625a(str);
        m4208c(str);
        m4203m().add(new C1225i(this.f2830b, str));
    }

    public void m4207b(boolean z) {
        this.f2831c = z;
    }

    public void m4208c(String str) {
        Uri a = C1225i.m4318a(str);
        ListIterator listIterator = m4203m().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(((C1224p) listIterator.next()).m4316a())) {
                listIterator.remove();
            }
        }
    }

    uf m4209j() {
        return this.f2830b;
    }

    public C1229l m4210k() {
        C1229l a = m4202l().m4343a();
        a.m4346a(this.f2830b.m9169q().m9268c());
        a.m4346a(this.f2830b.m9170r().m9363b());
        m4200b(a);
        return a;
    }
}
