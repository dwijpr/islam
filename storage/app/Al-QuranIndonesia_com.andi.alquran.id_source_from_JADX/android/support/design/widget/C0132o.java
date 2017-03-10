package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.o */
class C0132o {
    private static C0132o f475a;
    private final Object f476b;
    private final Handler f477c;
    private C0131b f478d;
    private C0131b f479e;

    /* renamed from: android.support.design.widget.o.1 */
    class C01291 implements Callback {
        final /* synthetic */ C0132o f472a;

        C01291(C0132o c0132o) {
            this.f472a = c0132o;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    this.f472a.m595a((C0131b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.o.a */
    interface C0130a {
        void m584a();

        void m585a(int i);
    }

    /* renamed from: android.support.design.widget.o.b */
    private static class C0131b {
        final WeakReference<C0130a> f473a;
        int f474b;

        boolean m586a(C0130a c0130a) {
            return c0130a != null && this.f473a.get() == c0130a;
        }
    }

    private C0132o() {
        this.f476b = new Object();
        this.f477c = new Handler(Looper.getMainLooper(), new C01291(this));
    }

    static C0132o m587a() {
        if (f475a == null) {
            f475a = new C0132o();
        }
        return f475a;
    }

    private boolean m588a(C0131b c0131b, int i) {
        C0130a c0130a = (C0130a) c0131b.f473a.get();
        if (c0130a == null) {
            return false;
        }
        this.f477c.removeCallbacksAndMessages(c0131b);
        c0130a.m585a(i);
        return true;
    }

    private void m589b() {
        if (this.f479e != null) {
            this.f478d = this.f479e;
            this.f479e = null;
            C0130a c0130a = (C0130a) this.f478d.f473a.get();
            if (c0130a != null) {
                c0130a.m584a();
            } else {
                this.f478d = null;
            }
        }
    }

    private void m590b(C0131b c0131b) {
        if (c0131b.f474b != -2) {
            int i = 2750;
            if (c0131b.f474b > 0) {
                i = c0131b.f474b;
            } else if (c0131b.f474b == -1) {
                i = 1500;
            }
            this.f477c.removeCallbacksAndMessages(c0131b);
            this.f477c.sendMessageDelayed(Message.obtain(this.f477c, 0, c0131b), (long) i);
        }
    }

    private boolean m591f(C0130a c0130a) {
        return this.f478d != null && this.f478d.m586a(c0130a);
    }

    private boolean m592g(C0130a c0130a) {
        return this.f479e != null && this.f479e.m586a(c0130a);
    }

    public void m593a(C0130a c0130a) {
        synchronized (this.f476b) {
            if (m591f(c0130a)) {
                this.f478d = null;
                if (this.f479e != null) {
                    m589b();
                }
            }
        }
    }

    public void m594a(C0130a c0130a, int i) {
        synchronized (this.f476b) {
            if (m591f(c0130a)) {
                m588a(this.f478d, i);
            } else if (m592g(c0130a)) {
                m588a(this.f479e, i);
            }
        }
    }

    void m595a(C0131b c0131b) {
        synchronized (this.f476b) {
            if (this.f478d == c0131b || this.f479e == c0131b) {
                m588a(c0131b, 2);
            }
        }
    }

    public void m596b(C0130a c0130a) {
        synchronized (this.f476b) {
            if (m591f(c0130a)) {
                m590b(this.f478d);
            }
        }
    }

    public void m597c(C0130a c0130a) {
        synchronized (this.f476b) {
            if (m591f(c0130a)) {
                this.f477c.removeCallbacksAndMessages(this.f478d);
            }
        }
    }

    public void m598d(C0130a c0130a) {
        synchronized (this.f476b) {
            if (m591f(c0130a)) {
                m590b(this.f478d);
            }
        }
    }

    public boolean m599e(C0130a c0130a) {
        boolean z;
        synchronized (this.f476b) {
            z = m591f(c0130a) || m592g(c0130a);
        }
        return z;
    }
}
