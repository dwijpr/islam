package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.C1314c;

/* renamed from: com.google.android.gms.internal.x */
public final class C2078x<L> {
    private final C2076a f6343a;
    private volatile L f6344b;
    private final C2077b<L> f6345c;

    /* renamed from: com.google.android.gms.internal.x.c */
    public interface C1490c<L> {
        void m5421a();

        void m5422a(L l);
    }

    /* renamed from: com.google.android.gms.internal.x.a */
    private final class C2076a extends Handler {
        final /* synthetic */ C2078x f6340a;

        public C2076a(C2078x c2078x, Looper looper) {
            this.f6340a = c2078x;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            C1314c.m4632b(z);
            this.f6340a.m9701b((C1490c) message.obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.x.b */
    public static final class C2077b<L> {
        private final L f6341a;
        private final String f6342b;

        C2077b(L l, String str) {
            this.f6341a = l;
            this.f6342b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2077b)) {
                return false;
            }
            C2077b c2077b = (C2077b) obj;
            return this.f6341a == c2077b.f6341a && this.f6342b.equals(c2077b.f6342b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f6341a) * 31) + this.f6342b.hashCode();
        }
    }

    C2078x(Looper looper, L l, String str) {
        this.f6343a = new C2076a(this, looper);
        this.f6344b = C1314c.m4624a((Object) l, (Object) "Listener must not be null");
        this.f6345c = new C2077b(l, C1314c.m4625a(str));
    }

    public void m9698a() {
        this.f6344b = null;
    }

    public void m9699a(C1490c<? super L> c1490c) {
        C1314c.m4624a((Object) c1490c, (Object) "Notifier must not be null");
        this.f6343a.sendMessage(this.f6343a.obtainMessage(1, c1490c));
    }

    public C2077b<L> m9700b() {
        return this.f6345c;
    }

    void m9701b(C1490c<? super L> c1490c) {
        Object obj = this.f6344b;
        if (obj == null) {
            c1490c.m5421a();
            return;
        }
        try {
            c1490c.m5422a(obj);
        } catch (RuntimeException e) {
            c1490c.m5421a();
            throw e;
        }
    }
}
