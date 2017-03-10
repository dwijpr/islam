package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.os.C1881a;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;

@op
public abstract class ot implements C1881a, rs<Void> {
    private final sq<zzmh> f5285a;
    private final C1881a f5286b;
    private final Object f5287c;

    /* renamed from: com.google.android.gms.internal.ot.1 */
    class C18841 implements C1171c<zzmh> {
        final /* synthetic */ pa f5282a;
        final /* synthetic */ ot f5283b;

        C18841(ot otVar, pa paVar) {
            this.f5283b = otVar;
            this.f5282a = paVar;
        }

        public void m7959a(zzmh com_google_android_gms_internal_zzmh) {
            if (!this.f5283b.m7964a(this.f5282a, com_google_android_gms_internal_zzmh)) {
                this.f5283b.m7962a();
            }
        }

        public /* synthetic */ void m7960a(Object obj) {
            m7959a((zzmh) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ot.2 */
    class C18852 implements C1553a {
        final /* synthetic */ ot f5284a;

        C18852(ot otVar) {
            this.f5284a = otVar;
        }

        public void m7961a() {
            this.f5284a.m7962a();
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.ot.a */
    public static final class C1886a extends ot {
        private final Context f5288a;

        public C1886a(Context context, sq<zzmh> sqVar, C1881a c1881a) {
            super(sqVar, c1881a);
            this.f5288a = context;
        }

        public void m7967a() {
        }

        public pa m7968b() {
            return ph.m8111a(this.f5288a, new hy((String) C1648if.f4364b.m6682c()), pg.m8103a());
        }

        public /* synthetic */ Object zziw() {
            return super.m7966c();
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.ot.b */
    public static class C1887b extends ot implements C1326b, C1327c {
        protected ou f5289a;
        private Context f5290b;
        private zzqa f5291c;
        private sq<zzmh> f5292d;
        private final C1881a f5293e;
        private final Object f5294f;
        private boolean f5295g;

        public C1887b(Context context, zzqa com_google_android_gms_internal_zzqa, sq<zzmh> sqVar, C1881a c1881a) {
            Looper a;
            super(sqVar, c1881a);
            this.f5294f = new Object();
            this.f5290b = context;
            this.f5291c = com_google_android_gms_internal_zzqa;
            this.f5292d = sqVar;
            this.f5293e = c1881a;
            if (((Boolean) C1648if.f4351O.m6682c()).booleanValue()) {
                this.f5295g = true;
                a = zzv.zzcZ().m8669a();
            } else {
                a = context.getMainLooper();
            }
            this.f5289a = new ou(context, a, this, this, this.f5291c.f6638d);
            m7974d();
        }

        public void m7969a() {
            synchronized (this.f5294f) {
                if (this.f5289a.m4666b() || this.f5289a.m4667c()) {
                    this.f5289a.m4656a();
                }
                Binder.flushPendingCommands();
                if (this.f5295g) {
                    zzv.zzcZ().m8670b();
                    this.f5295g = false;
                }
            }
        }

        public void m7970a(int i) {
            sg.m8444b("Disconnected from remote ad request service.");
        }

        public void m7971a(Bundle bundle) {
            zziw();
        }

        public void m7972a(ConnectionResult connectionResult) {
            sg.m8444b("Cannot connect to remote service, fallback to local instance.");
            m7975e().zziw();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzv.zzcJ().m8535b(this.f5290b, this.f5291c.f6636b, "gmob-apps", bundle, true);
        }

        public pa m7973b() {
            pa k;
            synchronized (this.f5294f) {
                try {
                    k = this.f5289a.m7980k();
                } catch (IllegalStateException e) {
                    k = null;
                    return k;
                } catch (DeadObjectException e2) {
                    k = null;
                    return k;
                }
            }
            return k;
        }

        protected void m7974d() {
            this.f5289a.m4676n();
        }

        rs m7975e() {
            return new C1886a(this.f5290b, this.f5292d, this.f5293e);
        }

        public /* synthetic */ Object zziw() {
            return super.m7966c();
        }
    }

    public ot(sq<zzmh> sqVar, C1881a c1881a) {
        this.f5287c = new Object();
        this.f5285a = sqVar;
        this.f5286b = c1881a;
    }

    public abstract void m7962a();

    public void m7963a(zzmk com_google_android_gms_internal_zzmk) {
        synchronized (this.f5287c) {
            this.f5286b.m7943a(com_google_android_gms_internal_zzmk);
            m7962a();
        }
    }

    boolean m7964a(pa paVar, zzmh com_google_android_gms_internal_zzmh) {
        try {
            paVar.m8065a(com_google_android_gms_internal_zzmh, new ow(this));
            return true;
        } catch (Throwable e) {
            sg.m8447c("Could not fetch ad response from ad request service.", e);
            zzv.zzcN().m8399a(e, "AdRequestClientTask.getAdResponseFromService");
            this.f5286b.m7943a(new zzmk(0));
            return false;
        } catch (Throwable e2) {
            sg.m8447c("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzv.zzcN().m8399a(e2, "AdRequestClientTask.getAdResponseFromService");
            this.f5286b.m7943a(new zzmk(0));
            return false;
        } catch (Throwable e22) {
            sg.m8447c("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzv.zzcN().m8399a(e22, "AdRequestClientTask.getAdResponseFromService");
            this.f5286b.m7943a(new zzmk(0));
            return false;
        } catch (Throwable e222) {
            sg.m8447c("Could not fetch ad response from ad request service due to an Exception.", e222);
            zzv.zzcN().m8399a(e222, "AdRequestClientTask.getAdResponseFromService");
            this.f5286b.m7943a(new zzmk(0));
            return false;
        }
    }

    public abstract pa m7965b();

    public Void m7966c() {
        pa b = m7965b();
        if (b == null) {
            this.f5286b.m7943a(new zzmk(0));
            m7962a();
        } else {
            this.f5285a.m7337a(new C18841(this, b), new C18852(this));
        }
        return null;
    }

    public void cancel() {
        m7962a();
    }

    public /* synthetic */ Object zziw() {
        return m7966c();
    }
}
