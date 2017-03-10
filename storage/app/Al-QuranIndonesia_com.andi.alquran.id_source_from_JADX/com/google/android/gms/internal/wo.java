package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1279d;
import com.google.android.gms.common.api.C1279d.C1278a;
import com.google.android.gms.common.api.C1281f;
import com.google.android.gms.common.api.C1282h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1357u;
import com.google.android.gms.internal.ak.C1429b;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public abstract class wo<R extends C1263g> extends C1279d<R> {
    static final ThreadLocal<Boolean> f3291c;
    private final Object f3292a;
    private final CountDownLatch f3293b;
    protected final C2074a<R> f3294d;
    protected final WeakReference<C1277c> f3295e;
    private final ArrayList<C1278a> f3296f;
    private C1282h<? super R> f3297g;
    private final AtomicReference<C1429b> f3298h;
    private R f3299i;
    private C2075b f3300j;
    private volatile boolean f3301k;
    private boolean f3302l;
    private boolean f3303m;
    private C1357u f3304n;
    private volatile aj<R> f3305o;
    private boolean f3306p;

    /* renamed from: com.google.android.gms.internal.wo.1 */
    class C20731 extends ThreadLocal<Boolean> {
        C20731() {
        }

        protected Boolean m9689a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return m9689a();
        }
    }

    /* renamed from: com.google.android.gms.internal.wo.a */
    public static class C2074a<R extends C1263g> extends Handler {
        public C2074a() {
            this(Looper.getMainLooper());
        }

        public C2074a(Looper looper) {
            super(looper);
        }

        public void m9690a() {
            removeMessages(2);
        }

        public void m9691a(C1282h<? super R> c1282h, R r) {
            sendMessage(obtainMessage(1, new Pair(c1282h, r)));
        }

        protected void m9692b(C1282h<? super R> c1282h, R r) {
            try {
                c1282h.m4556a(r);
            } catch (RuntimeException e) {
                wo.m5071b((C1263g) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    Pair pair = (Pair) message.obj;
                    m9692b((C1282h) pair.first, (C1263g) pair.second);
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    ((wo) message.obj).m5080d(Status.f2978d);
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.wo.b */
    private final class C2075b {
        final /* synthetic */ wo f6336a;

        private C2075b(wo woVar) {
            this.f6336a = woVar;
        }

        protected void finalize() {
            wo.m5071b(this.f6336a.f3299i);
            super.finalize();
        }
    }

    static {
        f3291c = new C20731();
    }

    @Deprecated
    wo() {
        this.f3292a = new Object();
        this.f3293b = new CountDownLatch(1);
        this.f3296f = new ArrayList();
        this.f3298h = new AtomicReference();
        this.f3306p = false;
        this.f3294d = new C2074a(Looper.getMainLooper());
        this.f3295e = new WeakReference(null);
    }

    @Deprecated
    protected wo(Looper looper) {
        this.f3292a = new Object();
        this.f3293b = new CountDownLatch(1);
        this.f3296f = new ArrayList();
        this.f3298h = new AtomicReference();
        this.f3306p = false;
        this.f3294d = new C2074a(looper);
        this.f3295e = new WeakReference(null);
    }

    protected wo(C1277c c1277c) {
        this.f3292a = new Object();
        this.f3293b = new CountDownLatch(1);
        this.f3296f = new ArrayList();
        this.f3298h = new AtomicReference();
        this.f3306p = false;
        this.f3294d = new C2074a(c1277c != null ? c1277c.m4539a() : Looper.getMainLooper());
        this.f3295e = new WeakReference(c1277c);
    }

    private void m5070b() {
        C1429b c1429b = (C1429b) this.f3298h.getAndSet(null);
        if (c1429b != null) {
            c1429b.m5104a(this);
        }
    }

    public static void m5071b(C1263g c1263g) {
        if (c1263g instanceof C1281f) {
            try {
                ((C1281f) c1263g).m4555a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c1263g);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private R m5072c() {
        R r;
        boolean z = true;
        synchronized (this.f3292a) {
            if (this.f3301k) {
                z = false;
            }
            C1314c.m4629a(z, (Object) "Result has already been consumed.");
            C1314c.m4629a(m5081d(), (Object) "Result is not ready.");
            r = this.f3299i;
            this.f3299i = null;
            this.f3297g = null;
            this.f3301k = true;
        }
        m5070b();
        return r;
    }

    private void m5073c(R r) {
        this.f3299i = r;
        this.f3304n = null;
        this.f3293b.countDown();
        Status b = this.f3299i.m4501b();
        if (this.f3302l) {
            this.f3297g = null;
        } else if (this.f3297g != null) {
            this.f3294d.m9690a();
            this.f3294d.m9691a(this.f3297g, m5072c());
        } else if (this.f3299i instanceof C1281f) {
            this.f3300j = new C2075b();
        }
        Iterator it = this.f3296f.iterator();
        while (it.hasNext()) {
            ((C1278a) it.next()).m4550a(b);
        }
        this.f3296f.clear();
    }

    public Integer m5074a() {
        return null;
    }

    public final void m5075a(C1278a c1278a) {
        boolean z = true;
        C1314c.m4629a(!this.f3301k, (Object) "Result has already been consumed.");
        if (c1278a == null) {
            z = false;
        }
        C1314c.m4633b(z, "Callback cannot be null.");
        synchronized (this.f3292a) {
            if (m5081d()) {
                c1278a.m4550a(this.f3299i.m4501b());
            } else {
                this.f3296f.add(c1278a);
            }
        }
    }

    public final void m5076a(R r) {
        boolean z = true;
        synchronized (this.f3292a) {
            if (this.f3303m || this.f3302l) {
                m5071b((C1263g) r);
                return;
            }
            if (m5081d()) {
            }
            C1314c.m4629a(!m5081d(), (Object) "Results have already been set");
            if (this.f3301k) {
                z = false;
            }
            C1314c.m4629a(z, (Object) "Result has already been consumed");
            m5073c(r);
        }
    }

    public final void m5077a(C1282h<? super R> c1282h) {
        boolean z = true;
        synchronized (this.f3292a) {
            if (c1282h == null) {
                this.f3297g = null;
                return;
            }
            C1314c.m4629a(!this.f3301k, (Object) "Result has already been consumed.");
            if (this.f3305o != null) {
                z = false;
            }
            C1314c.m4629a(z, (Object) "Cannot set callbacks if then() has been called.");
            if (m5084g()) {
                return;
            }
            if (m5081d()) {
                this.f3294d.m9691a(c1282h, m5072c());
            } else {
                this.f3297g = c1282h;
            }
            return;
        }
    }

    public void m5078a(C1429b c1429b) {
        this.f3298h.set(c1429b);
    }

    protected abstract R m5079b(Status status);

    public final void m5080d(Status status) {
        synchronized (this.f3292a) {
            if (!m5081d()) {
                m5076a(m5079b(status));
                this.f3303m = true;
            }
        }
    }

    public final boolean m5081d() {
        return this.f3293b.getCount() == 0;
    }

    public void m5082e() {
        synchronized (this.f3292a) {
            if (this.f3302l || this.f3301k) {
                return;
            }
            if (this.f3304n != null) {
                try {
                    this.f3304n.m4855a();
                } catch (RemoteException e) {
                }
            }
            m5071b(this.f3299i);
            this.f3302l = true;
            m5073c(m5079b(Status.f2979e));
        }
    }

    public boolean m5083f() {
        boolean g;
        synchronized (this.f3292a) {
            if (((C1277c) this.f3295e.get()) == null || !this.f3306p) {
                m5082e();
            }
            g = m5084g();
        }
        return g;
    }

    public boolean m5084g() {
        boolean z;
        synchronized (this.f3292a) {
            z = this.f3302l;
        }
        return z;
    }

    public void m5085h() {
        m5077a(null);
    }

    public void m5086i() {
        boolean z = this.f3306p || ((Boolean) f3291c.get()).booleanValue();
        this.f3306p = z;
    }
}
