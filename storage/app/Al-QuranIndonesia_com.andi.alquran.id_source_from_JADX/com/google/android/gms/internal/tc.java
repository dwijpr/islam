package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1378d;
import com.google.android.gms.internal.hg.C1624a;
import java.util.HashMap;
import java.util.Map;

@op
public class tc extends C1624a {
    private final sx f5945a;
    private final Object f5946b;
    private final float f5947c;
    private int f5948d;
    private hh f5949e;
    private boolean f5950f;
    private boolean f5951g;
    private float f5952h;
    private boolean f5953i;
    private float f5954j;

    /* renamed from: com.google.android.gms.internal.tc.1 */
    class C20061 implements Runnable {
        final /* synthetic */ Map f5940a;
        final /* synthetic */ tc f5941b;

        C20061(tc tcVar, Map map) {
            this.f5941b = tcVar;
            this.f5940a = map;
        }

        public void run() {
            this.f5941b.f5945a.m8757a("pubVideoCmd", this.f5940a);
        }
    }

    /* renamed from: com.google.android.gms.internal.tc.2 */
    class C20072 implements Runnable {
        final /* synthetic */ int f5942a;
        final /* synthetic */ int f5943b;
        final /* synthetic */ tc f5944c;

        C20072(tc tcVar, int i, int i2) {
            this.f5944c = tcVar;
            this.f5942a = i;
            this.f5943b = i2;
        }

        public void run() {
            boolean z = false;
            synchronized (this.f5944c.f5946b) {
                boolean z2 = this.f5942a != this.f5943b;
                boolean z3 = !this.f5944c.f5950f && this.f5943b == 1;
                boolean z4 = z2 && this.f5943b == 1;
                boolean z5 = z2 && this.f5943b == 2;
                z2 = z2 && this.f5943b == 3;
                tc tcVar = this.f5944c;
                if (this.f5944c.f5950f || z3) {
                    z = true;
                }
                tcVar.f5950f = z;
                if (this.f5944c.f5949e == null) {
                    return;
                }
                if (z3) {
                    try {
                        this.f5944c.f5949e.m6468a();
                    } catch (Throwable e) {
                        sg.m8447c("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        this.f5944c.f5949e.m6469b();
                    } catch (Throwable e2) {
                        sg.m8447c("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        this.f5944c.f5949e.m6470c();
                    } catch (Throwable e22) {
                        sg.m8447c("Unable to call onVideoPause()", e22);
                    }
                }
                if (z2) {
                    try {
                        this.f5944c.f5949e.m6471d();
                    } catch (Throwable e222) {
                        sg.m8447c("Unable to call onVideoEnd()", e222);
                    }
                }
            }
        }
    }

    public tc(sx sxVar, float f) {
        this.f5946b = new Object();
        this.f5953i = true;
        this.f5945a = sxVar;
        this.f5947c = f;
    }

    private void m8966a(int i, int i2) {
        zzv.zzcJ().m8518a(new C20072(this, i, i2));
    }

    private void m8967a(String str) {
        m8968a(str, null);
    }

    private void m8968a(String str, Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzv.zzcJ().m8518a(new C20061(this, hashMap));
    }

    public void m8973a() {
        m8967a("play");
    }

    public void m8974a(float f, int i, boolean z, float f2) {
        int i2;
        synchronized (this.f5946b) {
            this.f5952h = f;
            this.f5951g = z;
            i2 = this.f5948d;
            this.f5948d = i;
            this.f5954j = f2;
        }
        m8966a(i2, i);
    }

    public void m8975a(hh hhVar) {
        synchronized (this.f5946b) {
            this.f5949e = hhVar;
        }
    }

    public void m8976a(boolean z) {
        m8967a(z ? "mute" : "unmute");
    }

    public void m8977b() {
        m8967a("pause");
    }

    public void m8978b(boolean z) {
        synchronized (this.f5946b) {
            this.f5953i = z;
        }
        m8968a("initialState", C1378d.m4936b("muteStart", z ? "1" : "0"));
    }

    public boolean m8979c() {
        boolean z;
        synchronized (this.f5946b) {
            z = this.f5951g;
        }
        return z;
    }

    public int m8980d() {
        int i;
        synchronized (this.f5946b) {
            i = this.f5948d;
        }
        return i;
    }

    public float m8981e() {
        return this.f5947c;
    }

    public float m8982f() {
        float f;
        synchronized (this.f5946b) {
            f = this.f5952h;
        }
        return f;
    }

    public float m8983g() {
        float f;
        synchronized (this.f5946b) {
            f = this.f5954j;
        }
        return f;
    }
}
