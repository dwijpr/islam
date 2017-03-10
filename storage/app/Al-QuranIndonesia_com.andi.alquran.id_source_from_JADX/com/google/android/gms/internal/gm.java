package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@op
public class gm {
    public static final gm f4167a;

    static {
        f4167a = new gm();
    }

    protected gm() {
    }

    public static gm m6341a() {
        return f4167a;
    }

    public zzdy m6342a(Context context, hi hiVar) {
        Date a = hiVar.m6510a();
        long time = a != null ? a.getTime() : -1;
        String b = hiVar.m6513b();
        int c = hiVar.m6514c();
        Collection d = hiVar.m6516d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = hiVar.m6511a(context);
        int l = hiVar.m6524l();
        Location e = hiVar.m6517e();
        Bundle b2 = hiVar.m6512b(AdMobAdapter.class);
        boolean f = hiVar.m6518f();
        String g = hiVar.m6519g();
        SearchAdRequest i = hiVar.m6521i();
        zzfj com_google_android_gms_internal_zzfj = i != null ? new zzfj(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = gr.m6416a().m8695a(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new zzdy(7, time, b2, c, unmodifiableList, a2, l, f, g, com_google_android_gms_internal_zzfj, e, b, hiVar.m6523k(), hiVar.m6525m(), Collections.unmodifiableList(new ArrayList(hiVar.m6526n())), hiVar.m6520h(), str, hiVar.m6527o());
    }

    public zznx m6343a(Context context, hi hiVar, String str) {
        return new zznx(m6342a(context, hiVar), str);
    }
}
