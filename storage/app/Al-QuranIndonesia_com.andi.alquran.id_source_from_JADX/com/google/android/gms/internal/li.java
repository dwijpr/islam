package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.internal.lh.C1756a;
import java.util.concurrent.Future;

@op
public class li {

    /* renamed from: com.google.android.gms.internal.li.1 */
    class C17571 implements Runnable {
        final /* synthetic */ Context f4757a;
        final /* synthetic */ zzqa f4758b;
        final /* synthetic */ C1759a f4759c;
        final /* synthetic */ cg f4760d;
        final /* synthetic */ zzd f4761e;
        final /* synthetic */ String f4762f;
        final /* synthetic */ li f4763g;

        C17571(li liVar, Context context, zzqa com_google_android_gms_internal_zzqa, C1759a c1759a, cg cgVar, zzd com_google_android_gms_ads_internal_zzd, String str) {
            this.f4763g = liVar;
            this.f4757a = context;
            this.f4758b = com_google_android_gms_internal_zzqa;
            this.f4759c = c1759a;
            this.f4760d = cgVar;
            this.f4761e = com_google_android_gms_ads_internal_zzd;
            this.f4762f = str;
        }

        public void run() {
            this.f4763g.m7306a(this.f4757a, this.f4758b, this.f4759c, this.f4760d, this.f4761e).m7297b(this.f4762f);
        }
    }

    /* renamed from: com.google.android.gms.internal.li.2 */
    class C17582 implements C1756a {
        final /* synthetic */ C1759a f4764a;

        C17582(li liVar, C1759a c1759a) {
            this.f4764a = c1759a;
        }

        public void m7299a() {
            this.f4764a.m7304b((Object) (lh) this.f4764a.f4771a);
        }
    }

    /* renamed from: com.google.android.gms.internal.li.a */
    private static class C1759a<JavascriptEngine> extends sk<JavascriptEngine> {
        JavascriptEngine f4771a;

        private C1759a() {
        }
    }

    private lh m7306a(Context context, zzqa com_google_android_gms_internal_zzqa, C1759a<lh> c1759a, cg cgVar, zzd com_google_android_gms_ads_internal_zzd) {
        lh ljVar = new lj(context, com_google_android_gms_internal_zzqa, cgVar, com_google_android_gms_ads_internal_zzd);
        c1759a.f4771a = ljVar;
        ljVar.m7294a(new C17582(this, c1759a));
        return ljVar;
    }

    public Future<lh> m7308a(Context context, zzqa com_google_android_gms_internal_zzqa, String str, cg cgVar, zzd com_google_android_gms_ads_internal_zzd) {
        Future c1759a = new C1759a();
        rq.f5755a.post(new C17571(this, context, com_google_android_gms_internal_zzqa, c1759a, cgVar, com_google_android_gms_ads_internal_zzd, str));
        return c1759a;
    }
}
