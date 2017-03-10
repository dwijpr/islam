package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.fn.C1574b;

@op
public class fx {
    private final Runnable f4128a;
    private final Object f4129b;
    private fz f4130c;
    private Context f4131d;
    private gc f4132e;

    /* renamed from: com.google.android.gms.internal.fx.1 */
    class C15831 implements Runnable {
        final /* synthetic */ fx f4124a;

        C15831(fx fxVar) {
            this.f4124a = fxVar;
        }

        public void run() {
            this.f4124a.m6262c();
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.2 */
    class C15842 implements C1574b {
        final /* synthetic */ fx f4125a;

        C15842(fx fxVar) {
            this.f4125a = fxVar;
        }

        public void m6252a(boolean z) {
            if (z) {
                this.f4125a.m6259b();
            } else {
                this.f4125a.m6262c();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.3 */
    class C15853 implements C1326b {
        final /* synthetic */ fx f4126a;

        C15853(fx fxVar) {
            this.f4126a = fxVar;
        }

        public void m6253a(int i) {
            synchronized (this.f4126a.f4129b) {
                this.f4126a.f4130c = null;
                this.f4126a.f4132e = null;
                this.f4126a.f4129b.notifyAll();
                zzv.zzcZ().m8670b();
            }
        }

        public void m6254a(Bundle bundle) {
            synchronized (this.f4126a.f4129b) {
                try {
                    this.f4126a.f4132e = this.f4126a.f4130c.m6276k();
                } catch (Throwable e) {
                    sg.m8445b("Unable to obtain a cache service instance.", e);
                    this.f4126a.m6262c();
                }
                this.f4126a.f4129b.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.4 */
    class C15864 implements C1327c {
        final /* synthetic */ fx f4127a;

        C15864(fx fxVar) {
            this.f4127a = fxVar;
        }

        public void m6255a(ConnectionResult connectionResult) {
            synchronized (this.f4127a.f4129b) {
                this.f4127a.f4130c = null;
                this.f4127a.f4132e = null;
                this.f4127a.f4129b.notifyAll();
                zzv.zzcZ().m8670b();
            }
        }
    }

    public fx() {
        this.f4128a = new C15831(this);
        this.f4129b = new Object();
    }

    private void m6259b() {
        synchronized (this.f4129b) {
            if (this.f4131d == null || this.f4130c != null) {
                return;
            }
            this.f4130c = m6264a(new C15853(this), new C15864(this));
            this.f4130c.m4676n();
        }
    }

    private void m6262c() {
        synchronized (this.f4129b) {
            if (this.f4130c == null) {
                return;
            }
            if (this.f4130c.m4666b() || this.f4130c.m4667c()) {
                this.f4130c.m4656a();
            }
            this.f4130c = null;
            this.f4132e = null;
            Binder.flushPendingCommands();
            zzv.zzcZ().m8670b();
        }
    }

    protected fz m6264a(C1326b c1326b, C1327c c1327c) {
        return new fz(this.f4131d, zzv.zzcZ().m8669a(), c1326b, c1327c);
    }

    public zzdl m6265a(zzdo com_google_android_gms_internal_zzdo) {
        zzdl com_google_android_gms_internal_zzdl;
        synchronized (this.f4129b) {
            if (this.f4132e == null) {
                com_google_android_gms_internal_zzdl = new zzdl();
            } else {
                try {
                    com_google_android_gms_internal_zzdl = this.f4132e.m6306a(com_google_android_gms_internal_zzdo);
                } catch (Throwable e) {
                    sg.m8445b("Unable to call into cache service.", e);
                    com_google_android_gms_internal_zzdl = new zzdl();
                }
            }
        }
        return com_google_android_gms_internal_zzdl;
    }

    public void m6266a() {
        if (((Boolean) C1648if.cW.m6682c()).booleanValue()) {
            synchronized (this.f4129b) {
                m6259b();
                zzv.zzcJ();
                rq.f5755a.removeCallbacks(this.f4128a);
                zzv.zzcJ();
                rq.f5755a.postDelayed(this.f4128a, ((Long) C1648if.cX.m6682c()).longValue());
            }
        }
    }

    public void m6267a(Context context) {
        if (context != null) {
            synchronized (this.f4129b) {
                if (this.f4131d != null) {
                    return;
                }
                this.f4131d = context.getApplicationContext();
                if (((Boolean) C1648if.cV.m6682c()).booleanValue()) {
                    m6259b();
                } else if (((Boolean) C1648if.cU.m6682c()).booleanValue()) {
                    m6268a(new C15842(this));
                }
            }
        }
    }

    protected void m6268a(C1574b c1574b) {
        zzv.zzcM().m6201a(c1574b);
    }
}
