package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@op
public class kz {
    private final Context f4677a;
    private final md f4678b;
    private final zzqa f4679c;
    private final zzd f4680d;

    kz(Context context, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        this.f4677a = context;
        this.f4678b = mdVar;
        this.f4679c = com_google_android_gms_internal_zzqa;
        this.f4680d = com_google_android_gms_ads_internal_zzd;
    }

    public Context m7157a() {
        return this.f4677a.getApplicationContext();
    }

    public zzl m7158a(String str) {
        return new zzl(this.f4677a, new zzec(), str, this.f4678b, this.f4679c, this.f4680d);
    }

    public zzl m7159b(String str) {
        return new zzl(this.f4677a.getApplicationContext(), new zzec(), str, this.f4678b, this.f4679c, this.f4680d);
    }

    public kz m7160b() {
        return new kz(m7157a(), this.f4678b, this.f4679c, this.f4680d);
    }
}
