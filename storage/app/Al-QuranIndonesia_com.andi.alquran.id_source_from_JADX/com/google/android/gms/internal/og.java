package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ll.C1777b;
import com.google.android.gms.internal.ll.C1787e;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import java.util.concurrent.TimeUnit;

@op
public class og {
    private static final long f5176a;
    private static final Object f5177b;
    private static boolean f5178c;
    private static ll f5179d;
    private final Context f5180e;
    private final C1938a f5181f;
    private final zzr f5182g;
    private final cg f5183h;
    private li f5184i;
    private C1787e f5185j;
    private lh f5186k;
    private boolean f5187l;

    /* renamed from: com.google.android.gms.internal.og.a */
    public static abstract class C1674a {
        public void m6965a() {
        }

        public abstract void m6966a(lm lmVar);
    }

    /* renamed from: com.google.android.gms.internal.og.1 */
    class C18521 implements C1171c<lm> {
        final /* synthetic */ C1674a f5173a;

        C18521(og ogVar, C1674a c1674a) {
            this.f5173a = c1674a;
        }

        public void m7837a(lm lmVar) {
            this.f5173a.m6966a(lmVar);
        }

        public /* synthetic */ void m7838a(Object obj) {
            m7837a((lm) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.og.2 */
    class C18532 implements C1553a {
        final /* synthetic */ C1674a f5174a;

        C18532(og ogVar, C1674a c1674a) {
            this.f5174a = c1674a;
        }

        public void m7839a() {
            this.f5174a.m6965a();
        }
    }

    /* renamed from: com.google.android.gms.internal.og.3 */
    class C18543 implements rv<lh> {
        final /* synthetic */ og f5175a;

        C18543(og ogVar) {
            this.f5175a = ogVar;
        }

        public void m7840a(lh lhVar) {
            lhVar.m7293a(this.f5175a.f5182g, this.f5175a.f5182g, this.f5175a.f5182g, this.f5175a.f5182g, false, null, null, null, null);
        }

        public /* synthetic */ void m7841a(Object obj) {
            m7840a((lh) obj);
        }
    }

    static {
        f5176a = TimeUnit.SECONDS.toMillis(60);
        f5177b = new Object();
        f5178c = false;
        f5179d = null;
    }

    public og(Context context, C1938a c1938a, zzr com_google_android_gms_ads_internal_zzr, cg cgVar) {
        this.f5187l = false;
        this.f5180e = context;
        this.f5181f = c1938a;
        this.f5182g = com_google_android_gms_ads_internal_zzr;
        this.f5183h = cgVar;
        this.f5187l = ((Boolean) C1648if.cd.m6682c()).booleanValue();
    }

    public static String m7843a(C1938a c1938a, String str) {
        String valueOf = String.valueOf(c1938a.f5595b.f6583b.indexOf("https") == 0 ? "https:" : "http:");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private void m7844g() {
        synchronized (f5177b) {
            if (!f5178c) {
                f5179d = new ll(this.f5180e.getApplicationContext() != null ? this.f5180e.getApplicationContext() : this.f5180e, this.f5181f.f5594a.f6550k, m7843a(this.f5181f, (String) C1648if.cb.m6682c()), new C18543(this), new C1777b());
                f5178c = true;
            }
        }
    }

    private void m7845h() {
        this.f5185j = new C1787e(m7853e().m7370b(this.f5183h));
    }

    private void m7846i() {
        this.f5184i = new li();
    }

    private void m7847j() {
        this.f5186k = (lh) m7851c().m7308a(this.f5180e, this.f5181f.f5594a.f6550k, m7843a(this.f5181f, (String) C1648if.cb.m6682c()), this.f5183h, this.f5182g.zzbz()).get(f5176a, TimeUnit.MILLISECONDS);
        this.f5186k.m7293a(this.f5182g, this.f5182g, this.f5182g, this.f5182g, false, null, null, null, null);
    }

    public void m7848a() {
        if (this.f5187l) {
            m7844g();
        } else {
            m7846i();
        }
    }

    public void m7849a(C1674a c1674a) {
        if (this.f5187l) {
            C1787e f = m7854f();
            if (f == null) {
                sg.m8449e("SharedJavascriptEngine not initialized");
                return;
            } else {
                f.m7354a(new C18521(this, c1674a), new C18532(this, c1674a));
                return;
            }
        }
        lm d = m7852d();
        if (d == null) {
            sg.m8449e("JavascriptEngine not initialized");
        } else {
            c1674a.m6966a(d);
        }
    }

    public void m7850b() {
        if (this.f5187l) {
            m7845h();
        } else {
            m7847j();
        }
    }

    protected li m7851c() {
        return this.f5184i;
    }

    protected lh m7852d() {
        return this.f5186k;
    }

    protected ll m7853e() {
        return f5179d;
    }

    protected C1787e m7854f() {
        return this.f5185j;
    }
}
