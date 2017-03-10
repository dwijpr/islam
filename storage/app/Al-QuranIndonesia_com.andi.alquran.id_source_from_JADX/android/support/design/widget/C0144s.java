package android.support.design.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.s */
class C0144s {
    private final C0143e f495a;

    /* renamed from: android.support.design.widget.s.c */
    interface C0041c {
        void m93a(C0144s c0144s);
    }

    /* renamed from: android.support.design.widget.s.a */
    interface C0083a {
        void m403b(C0144s c0144s);

        void m404c(C0144s c0144s);

        void m405d(C0144s c0144s);
    }

    /* renamed from: android.support.design.widget.s.b */
    static class C0084b implements C0083a {
        C0084b() {
        }

        public void m406b(C0144s c0144s) {
        }

        public void m407c(C0144s c0144s) {
        }

        public void m408d(C0144s c0144s) {
        }
    }

    /* renamed from: android.support.design.widget.s.1 */
    class C01391 implements C0138b {
        final /* synthetic */ C0041c f491a;
        final /* synthetic */ C0144s f492b;

        C01391(C0144s c0144s, C0041c c0041c) {
            this.f492b = c0144s;
            this.f491a = c0041c;
        }

        public void m608a() {
            this.f491a.m93a(this.f492b);
        }
    }

    /* renamed from: android.support.design.widget.s.2 */
    class C01412 implements C0140a {
        final /* synthetic */ C0083a f493a;
        final /* synthetic */ C0144s f494b;

        C01412(C0144s c0144s, C0083a c0083a) {
            this.f494b = c0144s;
            this.f493a = c0083a;
        }

        public void m612a() {
            this.f493a.m404c(this.f494b);
        }

        public void m613b() {
            this.f493a.m403b(this.f494b);
        }

        public void m614c() {
            this.f493a.m405d(this.f494b);
        }
    }

    /* renamed from: android.support.design.widget.s.d */
    interface C0142d {
        C0144s m615a();
    }

    /* renamed from: android.support.design.widget.s.e */
    static abstract class C0143e {

        /* renamed from: android.support.design.widget.s.e.b */
        interface C0138b {
            void m607a();
        }

        /* renamed from: android.support.design.widget.s.e.a */
        interface C0140a {
            void m609a();

            void m610b();

            void m611c();
        }

        C0143e() {
        }

        abstract void m616a();

        abstract void m617a(float f, float f2);

        abstract void m618a(int i, int i2);

        abstract void m619a(long j);

        abstract void m620a(C0140a c0140a);

        abstract void m621a(C0138b c0138b);

        abstract void m622a(Interpolator interpolator);

        abstract boolean m623b();

        abstract int m624c();

        abstract void m625d();

        abstract float m626e();

        abstract void m627f();

        abstract long m628g();
    }

    C0144s(C0143e c0143e) {
        this.f495a = c0143e;
    }

    public void m629a() {
        this.f495a.m616a();
    }

    public void m630a(float f, float f2) {
        this.f495a.m617a(f, f2);
    }

    public void m631a(int i, int i2) {
        this.f495a.m618a(i, i2);
    }

    public void m632a(long j) {
        this.f495a.m619a(j);
    }

    public void m633a(C0083a c0083a) {
        if (c0083a != null) {
            this.f495a.m620a(new C01412(this, c0083a));
        } else {
            this.f495a.m620a(null);
        }
    }

    public void m634a(C0041c c0041c) {
        if (c0041c != null) {
            this.f495a.m621a(new C01391(this, c0041c));
        } else {
            this.f495a.m621a(null);
        }
    }

    public void m635a(Interpolator interpolator) {
        this.f495a.m622a(interpolator);
    }

    public boolean m636b() {
        return this.f495a.m623b();
    }

    public int m637c() {
        return this.f495a.m624c();
    }

    public void m638d() {
        this.f495a.m625d();
    }

    public float m639e() {
        return this.f495a.m626e();
    }

    public void m640f() {
        this.f495a.m627f();
    }

    public long m641g() {
        return this.f495a.m628g();
    }
}
