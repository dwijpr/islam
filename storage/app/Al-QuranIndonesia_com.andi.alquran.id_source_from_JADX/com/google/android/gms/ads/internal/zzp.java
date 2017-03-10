package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.he.C1186a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rt;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public class zzp extends C1186a {
    private static final Object f2643b;
    private static zzp f2644c;
    private final Context f2645a;
    private final Object f2646d;
    private boolean f2647e;
    private boolean f2648f;
    private float f2649g;
    private zzqa f2650h;

    static {
        f2643b = new Object();
    }

    zzp(Context context, zzqa com_google_android_gms_internal_zzqa) {
        this.f2646d = new Object();
        this.f2649g = GroundOverlayOptions.NO_DIMENSION;
        this.f2645a = context;
        this.f2650h = com_google_android_gms_internal_zzqa;
        this.f2647e = false;
    }

    public static zzp zza(Context context, zzqa com_google_android_gms_internal_zzqa) {
        zzp com_google_android_gms_ads_internal_zzp;
        synchronized (f2643b) {
            if (f2644c == null) {
                f2644c = new zzp(context.getApplicationContext(), com_google_android_gms_internal_zzqa);
            }
            com_google_android_gms_ads_internal_zzp = f2644c;
        }
        return com_google_android_gms_ads_internal_zzp;
    }

    public static zzp zzcn() {
        zzp com_google_android_gms_ads_internal_zzp;
        synchronized (f2643b) {
            com_google_android_gms_ads_internal_zzp = f2644c;
        }
        return com_google_android_gms_ads_internal_zzp;
    }

    protected rt m4118a(C1108c c1108c, String str) {
        if (c1108c == null) {
            return null;
        }
        Context context = (Context) C1111d.m3897a(c1108c);
        if (context == null) {
            return null;
        }
        rt rtVar = new rt(context);
        rtVar.m8623a(str);
        return rtVar;
    }

    public void initialize() {
        synchronized (f2643b) {
            if (this.f2647e) {
                sg.m8449e("Mobile ads is initialized already.");
                return;
            }
            this.f2647e = true;
            C1648if.m6704a(this.f2645a);
            zzv.zzcN().m8394a(this.f2645a, this.f2650h);
            zzv.zzcO().m6267a(this.f2645a);
        }
    }

    public void setAppMuted(boolean z) {
        synchronized (this.f2646d) {
            this.f2648f = z;
        }
    }

    public void setAppVolume(float f) {
        synchronized (this.f2646d) {
            this.f2649g = f;
        }
    }

    public void zzb(C1108c c1108c, String str) {
        rt a = m4118a(c1108c, str);
        if (a == null) {
            sg.m8446c("Context is null. Failed to open debug menu.");
        } else {
            a.m8620a();
        }
    }

    public float zzco() {
        float f;
        synchronized (this.f2646d) {
            f = this.f2649g;
        }
        return f;
    }

    public boolean zzcp() {
        boolean z;
        synchronized (this.f2646d) {
            z = this.f2649g >= 0.0f;
        }
        return z;
    }

    public boolean zzcq() {
        boolean z;
        synchronized (this.f2646d) {
            z = this.f2648f;
        }
        return z;
    }

    public void zzy(String str) {
        C1648if.m6704a(this.f2645a);
        if (!TextUtils.isEmpty(str) && ((Boolean) C1648if.cz.m6682c()).booleanValue()) {
            zzv.zzdf().zza(this.f2645a, this.f2650h, true, null, str, null);
        }
    }
}
