package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.lh.C1756a;
import com.google.android.gms.internal.sy.C1137a;
import org.json.JSONObject;

@op
public class lj implements lh {
    private final sx f4785a;

    /* renamed from: com.google.android.gms.internal.lj.1 */
    class C17601 implements Runnable {
        final /* synthetic */ String f4772a;
        final /* synthetic */ JSONObject f4773b;
        final /* synthetic */ lj f4774c;

        C17601(lj ljVar, String str, JSONObject jSONObject) {
            this.f4774c = ljVar;
            this.f4772a = str;
            this.f4773b = jSONObject;
        }

        public void run() {
            this.f4774c.f4785a.m8758a(this.f4772a, this.f4773b);
        }
    }

    /* renamed from: com.google.android.gms.internal.lj.2 */
    class C17612 implements Runnable {
        final /* synthetic */ String f4775a;
        final /* synthetic */ String f4776b;
        final /* synthetic */ lj f4777c;

        C17612(lj ljVar, String str, String str2) {
            this.f4777c = ljVar;
            this.f4775a = str;
            this.f4776b = str2;
        }

        public void run() {
            this.f4777c.f4785a.m8756a(this.f4775a, this.f4776b);
        }
    }

    /* renamed from: com.google.android.gms.internal.lj.3 */
    class C17623 implements Runnable {
        final /* synthetic */ String f4778a;
        final /* synthetic */ lj f4779b;

        C17623(lj ljVar, String str) {
            this.f4779b = ljVar;
            this.f4778a = str;
        }

        public void run() {
            this.f4779b.f4785a.loadData(this.f4778a, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.lj.4 */
    class C17634 implements Runnable {
        final /* synthetic */ String f4780a;
        final /* synthetic */ lj f4781b;

        C17634(lj ljVar, String str) {
            this.f4781b = ljVar;
            this.f4780a = str;
        }

        public void run() {
            this.f4781b.f4785a.loadData(this.f4780a, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.lj.5 */
    class C17645 implements Runnable {
        final /* synthetic */ String f4782a;
        final /* synthetic */ lj f4783b;

        C17645(lj ljVar, String str) {
            this.f4783b = ljVar;
            this.f4782a = str;
        }

        public void run() {
            this.f4783b.f4785a.loadUrl(this.f4782a);
        }
    }

    /* renamed from: com.google.android.gms.internal.lj.6 */
    class C17656 implements C1137a {
        final /* synthetic */ C1756a f4784a;

        C17656(lj ljVar, C1756a c1756a) {
            this.f4784a = c1756a;
        }

        public void m7309a(sx sxVar, boolean z) {
            this.f4784a.m7286a();
        }
    }

    public lj(Context context, zzqa com_google_android_gms_internal_zzqa, cg cgVar, zzd com_google_android_gms_ads_internal_zzd) {
        this.f4785a = zzv.zzcK().m8831a(context, new zzec(), false, false, cgVar, com_google_android_gms_internal_zzqa, null, null, com_google_android_gms_ads_internal_zzd);
        this.f4785a.m8747a().setWillNotDraw(true);
    }

    private void m7311a(Runnable runnable) {
        if (gr.m6416a().m8704b()) {
            runnable.run();
        } else {
            rq.f5755a.post(runnable);
        }
    }

    public void m7312a() {
        this.f4785a.destroy();
    }

    public void m7313a(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, kc kcVar, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, ki kiVar, kl klVar, zze com_google_android_gms_ads_internal_zze, nb nbVar) {
        this.f4785a.m8776l().m8804a(geVar, com_google_android_gms_ads_internal_overlay_zzh, kcVar, com_google_android_gms_ads_internal_overlay_zzq, z, kiVar, klVar, new zze(this.f4785a.getContext(), false), nbVar, null);
    }

    public void m7314a(C1756a c1756a) {
        this.f4785a.m8776l().m8806a(new C17656(this, c1756a));
    }

    public void m7315a(String str) {
        m7311a(new C17623(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void m7316a(String str, kg kgVar) {
        this.f4785a.m8776l().m8810a(str, kgVar);
    }

    public void m7317a(String str, String str2) {
        m7311a(new C17612(this, str, str2));
    }

    public void m7318a(String str, JSONObject jSONObject) {
        m7311a(new C17601(this, str, jSONObject));
    }

    public ln m7319b() {
        return new lo(this);
    }

    public void m7320b(String str) {
        m7311a(new C17645(this, str));
    }

    public void m7321b(String str, kg kgVar) {
        this.f4785a.m8776l().m8815b(str, kgVar);
    }

    public void m7322b(String str, JSONObject jSONObject) {
        this.f4785a.m7291b(str, jSONObject);
    }

    public void m7323c(String str) {
        m7311a(new C17634(this, str));
    }
}
