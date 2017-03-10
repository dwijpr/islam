package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sy.C1137a;
import java.util.concurrent.atomic.AtomicBoolean;

@op
public abstract class nw implements rs<Void>, C1137a {
    protected final C1155a f5116a;
    protected final Context f5117b;
    protected final sx f5118c;
    protected final C1938a f5119d;
    protected zzmk f5120e;
    protected final Object f5121f;
    private Runnable f5122g;
    private AtomicBoolean f5123h;

    /* renamed from: com.google.android.gms.internal.nw.1 */
    class C18431 implements Runnable {
        final /* synthetic */ nw f5115a;

        C18431(nw nwVar) {
            this.f5115a = nwVar;
        }

        public void run() {
            if (this.f5115a.f5123h.get()) {
                sg.m8446c("Timed out waiting for WebView to finish loading.");
                this.f5115a.cancel();
            }
        }
    }

    protected nw(Context context, C1938a c1938a, sx sxVar, C1155a c1155a) {
        this.f5121f = new Object();
        this.f5123h = new AtomicBoolean(true);
        this.f5117b = context;
        this.f5119d = c1938a;
        this.f5120e = this.f5119d.f5595b;
        this.f5118c = sxVar;
        this.f5116a = c1155a;
    }

    private rc m7789b(int i) {
        zzmh com_google_android_gms_internal_zzmh = this.f5119d.f5594a;
        return new rc(com_google_android_gms_internal_zzmh.f6542c, this.f5118c, this.f5120e.f6585d, i, this.f5120e.f6587f, this.f5120e.f6591j, this.f5120e.f6593l, this.f5120e.f6592k, com_google_android_gms_internal_zzmh.f6548i, this.f5120e.f6589h, null, null, null, null, null, this.f5120e.f6590i, this.f5119d.f5597d, this.f5120e.f6588g, this.f5119d.f5599f, this.f5120e.f6595n, this.f5120e.f6596o, this.f5119d.f5601h, null, this.f5120e.f6568C, this.f5120e.f6569D, this.f5120e.f6570E, this.f5120e.f6571F, this.f5120e.f6572G, null, this.f5120e.f6575J, this.f5120e.f6579N);
    }

    public final Void m7790a() {
        C1314c.m4631b("Webview render task needs to be called on UI thread.");
        this.f5122g = new C18431(this);
        rq.f5755a.postDelayed(this.f5122g, ((Long) C1648if.bo.m6682c()).longValue());
        m7793b();
        return null;
    }

    protected void m7791a(int i) {
        if (i != -2) {
            this.f5120e = new zzmk(i, this.f5120e.f6592k);
        }
        this.f5118c.m8769e();
        this.f5116a.zzb(m7789b(i));
    }

    public void m7792a(sx sxVar, boolean z) {
        int i = 0;
        sg.m8444b("WebView finished loading.");
        if (this.f5123h.getAndSet(false)) {
            if (z) {
                i = m7794c();
            }
            m7791a(i);
            rq.f5755a.removeCallbacks(this.f5122g);
        }
    }

    protected abstract void m7793b();

    protected int m7794c() {
        return -2;
    }

    public void cancel() {
        if (this.f5123h.getAndSet(false)) {
            this.f5118c.stopLoading();
            zzv.zzcL().m8573a(this.f5118c);
            m7791a(-1);
            rq.f5755a.removeCallbacks(this.f5122g);
        }
    }

    public /* synthetic */ Object zziw() {
        return m7790a();
    }
}
