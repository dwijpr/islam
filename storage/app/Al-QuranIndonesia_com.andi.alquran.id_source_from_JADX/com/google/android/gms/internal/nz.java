package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;

@op
public abstract class nz extends rl {
    protected final C1155a f5141a;
    protected final Context f5142b;
    protected final Object f5143c;
    protected final Object f5144d;
    protected final C1938a f5145e;
    protected zzmk f5146f;

    /* renamed from: com.google.android.gms.internal.nz.1 */
    class C18451 implements Runnable {
        final /* synthetic */ nz f5137a;

        C18451(nz nzVar) {
            this.f5137a = nzVar;
        }

        public void run() {
            this.f5137a.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.nz.2 */
    class C18462 implements Runnable {
        final /* synthetic */ rc f5138a;
        final /* synthetic */ nz f5139b;

        C18462(nz nzVar, rc rcVar) {
            this.f5139b = nzVar;
            this.f5138a = rcVar;
        }

        public void run() {
            synchronized (this.f5139b.f5143c) {
                this.f5139b.m7815a(this.f5138a);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.nz.a */
    protected static final class C1847a extends Exception {
        private final int f5140a;

        public C1847a(String str, int i) {
            super(str);
            this.f5140a = i;
        }

        public int m7812a() {
            return this.f5140a;
        }
    }

    protected nz(Context context, C1938a c1938a, C1155a c1155a) {
        super(true);
        this.f5143c = new Object();
        this.f5144d = new Object();
        this.f5142b = context;
        this.f5145e = c1938a;
        this.f5146f = c1938a.f5595b;
        this.f5141a = c1155a;
    }

    protected abstract rc m7813a(int i);

    protected abstract void m7814a(long j);

    protected void m7815a(rc rcVar) {
        this.f5141a.zzb(rcVar);
    }

    public void onStop() {
    }

    public void zzcm() {
        int a;
        synchronized (this.f5143c) {
            sg.m8444b("AdRendererBackgroundTask started.");
            int i = this.f5145e.f5598e;
            try {
                m7814a(SystemClock.elapsedRealtime());
            } catch (C1847a e) {
                a = e.m7812a();
                if (a == 3 || a == -1) {
                    sg.m8448d(e.getMessage());
                } else {
                    sg.m8449e(e.getMessage());
                }
                if (this.f5146f == null) {
                    this.f5146f = new zzmk(a);
                } else {
                    this.f5146f = new zzmk(a, this.f5146f.f6592k);
                }
                rq.f5755a.post(new C18451(this));
                i = a;
            }
            rq.f5755a.post(new C18462(this, m7813a(i)));
        }
    }
}
