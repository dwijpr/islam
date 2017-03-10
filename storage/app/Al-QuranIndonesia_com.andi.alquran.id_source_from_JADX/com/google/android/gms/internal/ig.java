package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedHashMap;
import java.util.Map;

@op
public class ig {
    private boolean f4389a;
    private String f4390b;
    private Map<String, String> f4391c;
    private Context f4392d;
    private String f4393e;

    public ig(Context context, String str) {
        this.f4392d = null;
        this.f4393e = null;
        this.f4392d = context;
        this.f4393e = str;
        this.f4389a = ((Boolean) C1648if.f4357U.m6682c()).booleanValue();
        this.f4390b = (String) C1648if.f4358V.m6682c();
        this.f4391c = new LinkedHashMap();
        this.f4391c.put("s", "gmob_sdk");
        this.f4391c.put("v", "3");
        this.f4391c.put("os", VERSION.RELEASE);
        this.f4391c.put("sdk", VERSION.SDK);
        this.f4391c.put("device", zzv.zzcJ().m8546e());
        this.f4391c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.f4391c.put("is_lite_sdk", zzv.zzcJ().m8557l(context) ? "1" : "0");
        po a = zzv.zzcS().m8200a(this.f4392d);
        this.f4391c.put("network_coarse", Integer.toString(a.f5501m));
        this.f4391c.put("network_fine", Integer.toString(a.f5502n));
    }

    boolean m6706a() {
        return this.f4389a;
    }

    String m6707b() {
        return this.f4390b;
    }

    Context m6708c() {
        return this.f4392d;
    }

    String m6709d() {
        return this.f4393e;
    }

    Map<String, String> m6710e() {
        return this.f4391c;
    }
}
