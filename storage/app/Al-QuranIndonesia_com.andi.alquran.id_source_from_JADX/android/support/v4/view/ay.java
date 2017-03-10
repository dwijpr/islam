package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ay {
    static final C0466g f896d;
    Runnable f897a;
    Runnable f898b;
    int f899c;
    private WeakReference<View> f900e;

    /* renamed from: android.support.v4.view.ay.g */
    interface C0466g {
        long m2023a(ay ayVar, View view);

        void m2024a(ay ayVar, View view, float f);

        void m2025a(ay ayVar, View view, long j);

        void m2026a(ay ayVar, View view, bc bcVar);

        void m2027a(ay ayVar, View view, be beVar);

        void m2028a(ay ayVar, View view, Interpolator interpolator);

        void m2029b(ay ayVar, View view);

        void m2030b(ay ayVar, View view, float f);

        void m2031b(ay ayVar, View view, long j);

        void m2032c(ay ayVar, View view);

        void m2033c(ay ayVar, View view, float f);
    }

    /* renamed from: android.support.v4.view.ay.a */
    static class C0467a implements C0466g {
        WeakHashMap<View, Runnable> f892a;

        /* renamed from: android.support.v4.view.ay.a.a */
        class C0465a implements Runnable {
            WeakReference<View> f889a;
            ay f890b;
            final /* synthetic */ C0467a f891c;

            C0465a(C0467a c0467a, ay ayVar, View view) {
                this.f891c = c0467a;
                this.f889a = new WeakReference(view);
                this.f890b = ayVar;
            }

            public void run() {
                View view = (View) this.f889a.get();
                if (view != null) {
                    this.f891c.m2047d(this.f890b, view);
                }
            }
        }

        C0467a() {
            this.f892a = null;
        }

        private void m2034a(View view) {
            if (this.f892a != null) {
                Runnable runnable = (Runnable) this.f892a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m2035e(ay ayVar, View view) {
            Runnable runnable = null;
            if (this.f892a != null) {
                runnable = (Runnable) this.f892a.get(view);
            }
            if (runnable == null) {
                runnable = new C0465a(this, ayVar, view);
                if (this.f892a == null) {
                    this.f892a = new WeakHashMap();
                }
                this.f892a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        public long m2036a(ay ayVar, View view) {
            return 0;
        }

        public void m2037a(ay ayVar, View view, float f) {
            m2035e(ayVar, view);
        }

        public void m2038a(ay ayVar, View view, long j) {
        }

        public void m2039a(ay ayVar, View view, bc bcVar) {
            view.setTag(2113929216, bcVar);
        }

        public void m2040a(ay ayVar, View view, be beVar) {
        }

        public void m2041a(ay ayVar, View view, Interpolator interpolator) {
        }

        public void m2042b(ay ayVar, View view) {
            m2035e(ayVar, view);
        }

        public void m2043b(ay ayVar, View view, float f) {
            m2035e(ayVar, view);
        }

        public void m2044b(ay ayVar, View view, long j) {
        }

        public void m2045c(ay ayVar, View view) {
            m2034a(view);
            m2047d(ayVar, view);
        }

        public void m2046c(ay ayVar, View view, float f) {
            m2035e(ayVar, view);
        }

        void m2047d(ay ayVar, View view) {
            Object tag = view.getTag(2113929216);
            bc bcVar = tag instanceof bc ? (bc) tag : null;
            Runnable runnable = ayVar.f897a;
            Runnable runnable2 = ayVar.f898b;
            ayVar.f897a = null;
            ayVar.f898b = null;
            if (runnable != null) {
                runnable.run();
            }
            if (bcVar != null) {
                bcVar.onAnimationStart(view);
                bcVar.onAnimationEnd(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.f892a != null) {
                this.f892a.remove(view);
            }
        }
    }

    /* renamed from: android.support.v4.view.ay.b */
    static class C0469b extends C0467a {
        WeakHashMap<View, Integer> f895b;

        /* renamed from: android.support.v4.view.ay.b.a */
        static class C0468a implements bc {
            ay f893a;
            boolean f894b;

            C0468a(ay ayVar) {
                this.f893a = ayVar;
            }

            public void onAnimationCancel(View view) {
                Object tag = view.getTag(2113929216);
                bc bcVar = tag instanceof bc ? (bc) tag : null;
                if (bcVar != null) {
                    bcVar.onAnimationCancel(view);
                }
            }

            public void onAnimationEnd(View view) {
                if (this.f893a.f899c >= 0) {
                    aj.m1857a(view, this.f893a.f899c, null);
                    this.f893a.f899c = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f894b) {
                    if (this.f893a.f898b != null) {
                        Runnable runnable = this.f893a.f898b;
                        this.f893a.f898b = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    bc bcVar = tag instanceof bc ? (bc) tag : null;
                    if (bcVar != null) {
                        bcVar.onAnimationEnd(view);
                    }
                    this.f894b = true;
                }
            }

            public void onAnimationStart(View view) {
                this.f894b = false;
                if (this.f893a.f899c >= 0) {
                    aj.m1857a(view, 2, null);
                }
                if (this.f893a.f897a != null) {
                    Runnable runnable = this.f893a.f897a;
                    this.f893a.f897a = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                bc bcVar = tag instanceof bc ? (bc) tag : null;
                if (bcVar != null) {
                    bcVar.onAnimationStart(view);
                }
            }
        }

        C0469b() {
            this.f895b = null;
        }

        public long m2048a(ay ayVar, View view) {
            return az.m2071a(view);
        }

        public void m2049a(ay ayVar, View view, float f) {
            az.m2072a(view, f);
        }

        public void m2050a(ay ayVar, View view, long j) {
            az.m2073a(view, j);
        }

        public void m2051a(ay ayVar, View view, bc bcVar) {
            view.setTag(2113929216, bcVar);
            az.m2074a(view, new C0468a(ayVar));
        }

        public void m2052a(ay ayVar, View view, Interpolator interpolator) {
            az.m2075a(view, interpolator);
        }

        public void m2053b(ay ayVar, View view) {
            az.m2076b(view);
        }

        public void m2054b(ay ayVar, View view, float f) {
            az.m2077b(view, f);
        }

        public void m2055b(ay ayVar, View view, long j) {
            az.m2078b(view, j);
        }

        public void m2056c(ay ayVar, View view) {
            az.m2079c(view);
        }

        public void m2057c(ay ayVar, View view, float f) {
            az.m2080c(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ay.d */
    static class C0470d extends C0469b {
        C0470d() {
        }

        public void m2058a(ay ayVar, View view, bc bcVar) {
            ba.m2090a(view, bcVar);
        }
    }

    /* renamed from: android.support.v4.view.ay.c */
    static class C0471c extends C0470d {
        C0471c() {
        }
    }

    /* renamed from: android.support.v4.view.ay.e */
    static class C0472e extends C0471c {
        C0472e() {
        }

        public void m2059a(ay ayVar, View view, be beVar) {
            bb.m2091a(view, beVar);
        }
    }

    /* renamed from: android.support.v4.view.ay.f */
    static class C0473f extends C0472e {
        C0473f() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f896d = new C0473f();
        } else if (i >= 19) {
            f896d = new C0472e();
        } else if (i >= 18) {
            f896d = new C0471c();
        } else if (i >= 16) {
            f896d = new C0470d();
        } else if (i >= 14) {
            f896d = new C0469b();
        } else {
            f896d = new C0467a();
        }
    }

    ay(View view) {
        this.f897a = null;
        this.f898b = null;
        this.f899c = -1;
        this.f900e = new WeakReference(view);
    }

    public long m2060a() {
        View view = (View) this.f900e.get();
        return view != null ? f896d.m2023a(this, view) : 0;
    }

    public ay m2061a(float f) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2024a(this, view, f);
        }
        return this;
    }

    public ay m2062a(long j) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2025a(this, view, j);
        }
        return this;
    }

    public ay m2063a(bc bcVar) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2026a(this, view, bcVar);
        }
        return this;
    }

    public ay m2064a(be beVar) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2027a(this, view, beVar);
        }
        return this;
    }

    public ay m2065a(Interpolator interpolator) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2028a(this, view, interpolator);
        }
        return this;
    }

    public ay m2066b(float f) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2030b(this, view, f);
        }
        return this;
    }

    public ay m2067b(long j) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2031b(this, view, j);
        }
        return this;
    }

    public void m2068b() {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2029b(this, view);
        }
    }

    public ay m2069c(float f) {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2033c(this, view, f);
        }
        return this;
    }

    public void m2070c() {
        View view = (View) this.f900e.get();
        if (view != null) {
            f896d.m2032c(this, view);
        }
    }
}
