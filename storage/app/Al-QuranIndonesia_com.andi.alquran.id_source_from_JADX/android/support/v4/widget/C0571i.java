package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.i */
public final class C0571i {
    private static final C0567c f1097b;
    private Object f1098a;

    /* renamed from: android.support.v4.widget.i.c */
    interface C0567c {
        Object m2437a(Context context);

        void m2438a(Object obj, int i, int i2);

        boolean m2439a(Object obj);

        boolean m2440a(Object obj, float f);

        boolean m2441a(Object obj, float f, float f2);

        boolean m2442a(Object obj, int i);

        boolean m2443a(Object obj, Canvas canvas);

        void m2444b(Object obj);

        boolean m2445c(Object obj);
    }

    /* renamed from: android.support.v4.widget.i.a */
    static class C0568a implements C0567c {
        C0568a() {
        }

        public Object m2446a(Context context) {
            return null;
        }

        public void m2447a(Object obj, int i, int i2) {
        }

        public boolean m2448a(Object obj) {
            return true;
        }

        public boolean m2449a(Object obj, float f) {
            return false;
        }

        public boolean m2450a(Object obj, float f, float f2) {
            return false;
        }

        public boolean m2451a(Object obj, int i) {
            return false;
        }

        public boolean m2452a(Object obj, Canvas canvas) {
            return false;
        }

        public void m2453b(Object obj) {
        }

        public boolean m2454c(Object obj) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.i.b */
    static class C0569b implements C0567c {
        C0569b() {
        }

        public Object m2455a(Context context) {
            return C0572j.m2473a(context);
        }

        public void m2456a(Object obj, int i, int i2) {
            C0572j.m2474a(obj, i, i2);
        }

        public boolean m2457a(Object obj) {
            return C0572j.m2475a(obj);
        }

        public boolean m2458a(Object obj, float f) {
            return C0572j.m2476a(obj, f);
        }

        public boolean m2459a(Object obj, float f, float f2) {
            return C0572j.m2476a(obj, f);
        }

        public boolean m2460a(Object obj, int i) {
            return C0572j.m2477a(obj, i);
        }

        public boolean m2461a(Object obj, Canvas canvas) {
            return C0572j.m2478a(obj, canvas);
        }

        public void m2462b(Object obj) {
            C0572j.m2479b(obj);
        }

        public boolean m2463c(Object obj) {
            return C0572j.m2480c(obj);
        }
    }

    /* renamed from: android.support.v4.widget.i.d */
    static class C0570d extends C0569b {
        C0570d() {
        }

        public boolean m2464a(Object obj, float f, float f2) {
            return C0573k.m2481a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1097b = new C0570d();
        } else if (VERSION.SDK_INT >= 14) {
            f1097b = new C0569b();
        } else {
            f1097b = new C0568a();
        }
    }

    public C0571i(Context context) {
        this.f1098a = f1097b.m2437a(context);
    }

    public void m2465a(int i, int i2) {
        f1097b.m2438a(this.f1098a, i, i2);
    }

    public boolean m2466a() {
        return f1097b.m2439a(this.f1098a);
    }

    @Deprecated
    public boolean m2467a(float f) {
        return f1097b.m2440a(this.f1098a, f);
    }

    public boolean m2468a(float f, float f2) {
        return f1097b.m2441a(this.f1098a, f, f2);
    }

    public boolean m2469a(int i) {
        return f1097b.m2442a(this.f1098a, i);
    }

    public boolean m2470a(Canvas canvas) {
        return f1097b.m2443a(this.f1098a, canvas);
    }

    public void m2471b() {
        f1097b.m2444b(this.f1098a);
    }

    public boolean m2472c() {
        return f1097b.m2445c(this.f1098a);
    }
}
