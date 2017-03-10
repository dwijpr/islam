package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p014g.C0297j;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw.C1175a;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzqa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@op
public class zzj extends C1175a {
    private final Context f2595a;
    private final gv f2596b;
    private final md f2597c;
    private final js f2598d;
    private final jt f2599e;
    private final C0297j<String, jv> f2600f;
    private final C0297j<String, ju> f2601g;
    private final zzgw f2602h;
    private final List<String> f2603i;
    private final hd f2604j;
    private final String f2605k;
    private final zzqa f2606l;
    private WeakReference<zzr> f2607m;
    private final zzd f2608n;
    private final Object f2609o;

    /* renamed from: com.google.android.gms.ads.internal.zzj.1 */
    class C11741 implements Runnable {
        final /* synthetic */ zzdy f2593a;
        final /* synthetic */ zzj f2594b;

        C11741(zzj com_google_android_gms_ads_internal_zzj, zzdy com_google_android_gms_internal_zzdy) {
            this.f2594b = com_google_android_gms_ads_internal_zzj;
            this.f2593a = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            synchronized (this.f2594b.f2609o) {
                zzr a = this.f2594b.m4082a();
                this.f2594b.f2607m = new WeakReference(a);
                a.zzb(this.f2594b.f2598d);
                a.zzb(this.f2594b.f2599e);
                a.zza(this.f2594b.f2600f);
                a.zza(this.f2594b.f2596b);
                a.zzb(this.f2594b.f2601g);
                a.zzb(this.f2594b.m4074b());
                a.zzb(this.f2594b.f2602h);
                a.zza(this.f2594b.f2604j);
                a.zzb(this.f2593a);
            }
        }
    }

    zzj(Context context, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, gv gvVar, js jsVar, jt jtVar, C0297j<String, jv> c0297j, C0297j<String, ju> c0297j2, zzgw com_google_android_gms_internal_zzgw, hd hdVar, zzd com_google_android_gms_ads_internal_zzd) {
        this.f2609o = new Object();
        this.f2595a = context;
        this.f2605k = str;
        this.f2597c = mdVar;
        this.f2606l = com_google_android_gms_internal_zzqa;
        this.f2596b = gvVar;
        this.f2599e = jtVar;
        this.f2598d = jsVar;
        this.f2600f = c0297j;
        this.f2601g = c0297j2;
        this.f2602h = com_google_android_gms_internal_zzgw;
        this.f2603i = m4074b();
        this.f2604j = hdVar;
        this.f2608n = com_google_android_gms_ads_internal_zzd;
    }

    private List<String> m4074b() {
        List<String> arrayList = new ArrayList();
        if (this.f2599e != null) {
            arrayList.add("1");
        }
        if (this.f2598d != null) {
            arrayList.add("2");
        }
        if (this.f2600f.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    protected zzr m4082a() {
        return new zzr(this.f2595a, this.f2608n, zzec.m9769a(this.f2595a), this.f2605k, this.f2597c, this.f2606l);
    }

    protected void m4083a(Runnable runnable) {
        rq.f5755a.post(runnable);
    }

    public String getMediationAdapterClassName() {
        synchronized (this.f2609o) {
            if (this.f2607m != null) {
                zzr com_google_android_gms_ads_internal_zzr = (zzr) this.f2607m.get();
                String mediationAdapterClassName = com_google_android_gms_ads_internal_zzr != null ? com_google_android_gms_ads_internal_zzr.getMediationAdapterClassName() : null;
                return mediationAdapterClassName;
            }
            return null;
        }
    }

    public boolean isLoading() {
        synchronized (this.f2609o) {
            if (this.f2607m != null) {
                zzr com_google_android_gms_ads_internal_zzr = (zzr) this.f2607m.get();
                boolean isLoading = com_google_android_gms_ads_internal_zzr != null ? com_google_android_gms_ads_internal_zzr.isLoading() : false;
                return isLoading;
            }
            return false;
        }
    }

    public void zzf(zzdy com_google_android_gms_internal_zzdy) {
        m4083a(new C11741(this, com_google_android_gms_internal_zzdy));
    }
}
