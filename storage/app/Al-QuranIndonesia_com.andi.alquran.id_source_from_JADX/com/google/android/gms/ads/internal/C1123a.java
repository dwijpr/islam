package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cf;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.sg;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@op
/* renamed from: com.google.android.gms.ads.internal.a */
class C1123a implements bk, Runnable {
    CountDownLatch f2355a;
    private final List<Object[]> f2356b;
    private final AtomicReference<bk> f2357c;
    private zzw f2358d;

    public C1123a(zzw com_google_android_gms_ads_internal_zzw) {
        this.f2356b = new Vector();
        this.f2357c = new AtomicReference();
        this.f2355a = new CountDownLatch(1);
        this.f2358d = com_google_android_gms_ads_internal_zzw;
        if (gr.m6416a().m8704b()) {
            rp.m8472a((Runnable) this);
        } else {
            run();
        }
    }

    private Context m3930b(Context context) {
        if (!((Boolean) C1648if.f4376n.m6682c()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    private void m3931b() {
        if (!this.f2356b.isEmpty()) {
            for (Object[] objArr : this.f2356b) {
                if (objArr.length == 1) {
                    ((bk) this.f2357c.get()).m3929a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((bk) this.f2357c.get()).m3928a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f2356b.clear();
        }
    }

    protected bk m3932a(String str, Context context, boolean z) {
        return cf.m5524a(str, context, z);
    }

    public String m3933a(Context context) {
        return m3935a(context, null);
    }

    public String m3934a(Context context, String str, View view) {
        if (m3939a()) {
            bk bkVar = (bk) this.f2357c.get();
            if (bkVar != null) {
                m3931b();
                return bkVar.m3927a(m3930b(context), str, view);
            }
        }
        return BuildConfig.VERSION_NAME;
    }

    public String m3935a(Context context, byte[] bArr) {
        if (m3939a()) {
            bk bkVar = (bk) this.f2357c.get();
            if (bkVar != null) {
                m3931b();
                return bkVar.m3926a(m3930b(context));
            }
        }
        return BuildConfig.VERSION_NAME;
    }

    public void m3936a(int i, int i2, int i3) {
        bk bkVar = (bk) this.f2357c.get();
        if (bkVar != null) {
            m3931b();
            bkVar.m3928a(i, i2, i3);
            return;
        }
        this.f2356b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void m3937a(MotionEvent motionEvent) {
        bk bkVar = (bk) this.f2357c.get();
        if (bkVar != null) {
            m3931b();
            bkVar.m3929a(motionEvent);
            return;
        }
        this.f2356b.add(new Object[]{motionEvent});
    }

    protected void m3938a(bk bkVar) {
        this.f2357c.set(bkVar);
    }

    protected boolean m3939a() {
        try {
            this.f2355a.await();
            return true;
        } catch (Throwable e) {
            sg.m8447c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public void run() {
        try {
            boolean z = !((Boolean) C1648if.f4346J.m6682c()).booleanValue() || this.f2358d.zzvf.f6639e;
            m3938a(m3932a(this.f2358d.zzvf.f6636b, m3930b(this.f2358d.zzqr), z));
        } finally {
            this.f2355a.countDown();
            this.f2358d = null;
        }
    }
}
