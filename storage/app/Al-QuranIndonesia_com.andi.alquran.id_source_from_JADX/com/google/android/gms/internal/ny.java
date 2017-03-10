package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sy.C1137a;

@op
public class ny extends nw {
    private nx f5136g;

    ny(Context context, C1938a c1938a, sx sxVar, C1155a c1155a) {
        super(context, c1938a, sxVar, c1155a);
    }

    protected void m7810b() {
        int i;
        int i2;
        zzec k = this.c.m8775k();
        if (k.f6455e) {
            DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = k.f6457g;
            i2 = k.f6454d;
        }
        this.f5136g = new nx(this, this.c, i, i2);
        this.c.m8776l().m8806a((C1137a) this);
        this.f5136g.m7805a(this.e);
    }

    protected int m7811c() {
        if (!this.f5136g.m7808c()) {
            return !this.f5136g.m7809d() ? 2 : -2;
        } else {
            sg.m8444b("Ad-Network indicated no fill with passback URL.");
            return 3;
        }
    }
}
