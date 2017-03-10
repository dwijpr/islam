package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sy.C1137a;

@op
public class ob extends nw implements C1137a {
    ob(Context context, C1938a c1938a, sx sxVar, C1155a c1155a) {
        super(context, c1938a, sxVar, c1155a);
    }

    protected void m7819b() {
        if (this.e.f6586e == -2) {
            this.c.m8776l().m8806a((C1137a) this);
            m7820d();
            sg.m8444b("Loading HTML in WebView.");
            this.c.loadDataWithBaseURL(this.e.f6583b, this.e.f6584c, "text/html", "UTF-8", null);
        }
    }

    protected void m7820d() {
    }
}
