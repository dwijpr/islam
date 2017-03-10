package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0534t;
import android.support.v4.view.aj;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* renamed from: android.support.v4.widget.a */
public abstract class C0550a implements OnTouchListener {
    private static final int f1048r;
    final C0548a f1049a;
    final View f1050b;
    boolean f1051c;
    boolean f1052d;
    boolean f1053e;
    private final Interpolator f1054f;
    private Runnable f1055g;
    private float[] f1056h;
    private float[] f1057i;
    private int f1058j;
    private int f1059k;
    private float[] f1060l;
    private float[] f1061m;
    private float[] f1062n;
    private boolean f1063o;
    private boolean f1064p;
    private boolean f1065q;

    /* renamed from: android.support.v4.widget.a.a */
    private static class C0548a {
        private int f1036a;
        private int f1037b;
        private float f1038c;
        private float f1039d;
        private long f1040e;
        private long f1041f;
        private int f1042g;
        private int f1043h;
        private long f1044i;
        private float f1045j;
        private int f1046k;

        C0548a() {
            this.f1040e = Long.MIN_VALUE;
            this.f1044i = -1;
            this.f1041f = 0;
            this.f1042g = 0;
            this.f1043h = 0;
        }

        private float m2339a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        private float m2340a(long j) {
            if (j < this.f1040e) {
                return 0.0f;
            }
            if (this.f1044i < 0 || j < this.f1044i) {
                return C0550a.m2352a(((float) (j - this.f1040e)) / ((float) this.f1036a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f1044i;
            return (C0550a.m2352a(((float) j2) / ((float) this.f1046k), 0.0f, 1.0f) * this.f1045j) + (1.0f - this.f1045j);
        }

        public void m2341a() {
            this.f1040e = AnimationUtils.currentAnimationTimeMillis();
            this.f1044i = -1;
            this.f1041f = this.f1040e;
            this.f1045j = 0.5f;
            this.f1042g = 0;
            this.f1043h = 0;
        }

        public void m2342a(float f, float f2) {
            this.f1038c = f;
            this.f1039d = f2;
        }

        public void m2343a(int i) {
            this.f1036a = i;
        }

        public void m2344b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1046k = C0550a.m2355a((int) (currentAnimationTimeMillis - this.f1040e), 0, this.f1037b);
            this.f1045j = m2340a(currentAnimationTimeMillis);
            this.f1044i = currentAnimationTimeMillis;
        }

        public void m2345b(int i) {
            this.f1037b = i;
        }

        public boolean m2346c() {
            return this.f1044i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1044i + ((long) this.f1046k);
        }

        public void m2347d() {
            if (this.f1041f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2339a(m2340a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1041f;
            this.f1041f = currentAnimationTimeMillis;
            this.f1042g = (int) ((((float) j) * a) * this.f1038c);
            this.f1043h = (int) ((((float) j) * a) * this.f1039d);
        }

        public int m2348e() {
            return (int) (this.f1038c / Math.abs(this.f1038c));
        }

        public int m2349f() {
            return (int) (this.f1039d / Math.abs(this.f1039d));
        }

        public int m2350g() {
            return this.f1042g;
        }

        public int m2351h() {
            return this.f1043h;
        }
    }

    /* renamed from: android.support.v4.widget.a.b */
    private class C0549b implements Runnable {
        final /* synthetic */ C0550a f1047a;

        C0549b(C0550a c0550a) {
            this.f1047a = c0550a;
        }

        public void run() {
            if (this.f1047a.f1053e) {
                if (this.f1047a.f1051c) {
                    this.f1047a.f1051c = false;
                    this.f1047a.f1049a.m2341a();
                }
                C0548a c0548a = this.f1047a.f1049a;
                if (c0548a.m2346c() || !this.f1047a.m2363a()) {
                    this.f1047a.f1053e = false;
                    return;
                }
                if (this.f1047a.f1052d) {
                    this.f1047a.f1052d = false;
                    this.f1047a.m2366b();
                }
                c0548a.m2347d();
                this.f1047a.m2362a(c0548a.m2350g(), c0548a.m2351h());
                aj.m1864a(this.f1047a.f1050b, (Runnable) this);
            }
        }
    }

    static {
        f1048r = ViewConfiguration.getTapTimeout();
    }

    public C0550a(View view) {
        this.f1049a = new C0548a();
        this.f1054f = new AccelerateInterpolator();
        this.f1056h = new float[]{0.0f, 0.0f};
        this.f1057i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1060l = new float[]{0.0f, 0.0f};
        this.f1061m = new float[]{0.0f, 0.0f};
        this.f1062n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1050b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2359a((float) i, (float) i);
        m2364b((float) i2, (float) i2);
        m2360a(1);
        m2371e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2369d(0.2f, 0.2f);
        m2367c(1.0f, 1.0f);
        m2365b(f1048r);
        m2368c(500);
        m2370d(500);
    }

    static float m2352a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float m2353a(float f, float f2, float f3, float f4) {
        float f5;
        float a = C0550a.m2352a(f * f2, 0.0f, f3);
        a = m2358f(f2 - f4, a) - m2358f(f4, a);
        if (a < 0.0f) {
            f5 = -this.f1054f.getInterpolation(-a);
        } else if (a <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1054f.getInterpolation(a);
        }
        return C0550a.m2352a(f5, (float) GroundOverlayOptions.NO_DIMENSION, 1.0f);
    }

    private float m2354a(int i, float f, float f2, float f3) {
        float a = m2353a(this.f1056h[i], f2, this.f1057i[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1060l[i];
        float f5 = this.f1061m[i];
        float f6 = this.f1062n[i];
        f4 *= f3;
        return a > 0.0f ? C0550a.m2352a(a * f4, f5, f6) : -C0550a.m2352a((-a) * f4, f5, f6);
    }

    static int m2355a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m2356c() {
        if (this.f1055g == null) {
            this.f1055g = new C0549b(this);
        }
        this.f1053e = true;
        this.f1051c = true;
        if (this.f1063o || this.f1059k <= 0) {
            this.f1055g.run();
        } else {
            aj.m1865a(this.f1050b, this.f1055g, (long) this.f1059k);
        }
        this.f1063o = true;
    }

    private void m2357d() {
        if (this.f1051c) {
            this.f1053e = false;
        } else {
            this.f1049a.m2344b();
        }
    }

    private float m2358f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1058j) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f1053e && this.f1058j == 1) ? 1.0f : 0.0f : 0.0f;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0550a m2359a(float f, float f2) {
        this.f1062n[0] = f / 1000.0f;
        this.f1062n[1] = f2 / 1000.0f;
        return this;
    }

    public C0550a m2360a(int i) {
        this.f1058j = i;
        return this;
    }

    public C0550a m2361a(boolean z) {
        if (this.f1064p && !z) {
            m2357d();
        }
        this.f1064p = z;
        return this;
    }

    public abstract void m2362a(int i, int i2);

    boolean m2363a() {
        C0548a c0548a = this.f1049a;
        int f = c0548a.m2349f();
        int e = c0548a.m2348e();
        return (f != 0 && m2373f(f)) || (e != 0 && m2372e(e));
    }

    public C0550a m2364b(float f, float f2) {
        this.f1061m[0] = f / 1000.0f;
        this.f1061m[1] = f2 / 1000.0f;
        return this;
    }

    public C0550a m2365b(int i) {
        this.f1059k = i;
        return this;
    }

    void m2366b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1050b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public C0550a m2367c(float f, float f2) {
        this.f1060l[0] = f / 1000.0f;
        this.f1060l[1] = f2 / 1000.0f;
        return this;
    }

    public C0550a m2368c(int i) {
        this.f1049a.m2343a(i);
        return this;
    }

    public C0550a m2369d(float f, float f2) {
        this.f1056h[0] = f;
        this.f1056h[1] = f2;
        return this;
    }

    public C0550a m2370d(int i) {
        this.f1049a.m2345b(i);
        return this;
    }

    public C0550a m2371e(float f, float f2) {
        this.f1057i[0] = f;
        this.f1057i[1] = f2;
        return this;
    }

    public abstract boolean m2372e(int i);

    public abstract boolean m2373f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1064p) {
            return false;
        }
        switch (C0534t.m2226a(motionEvent)) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f1052d = true;
                this.f1063o = false;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                m2357d();
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                break;
        }
        this.f1049a.m2342a(m2354a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1050b.getWidth()), m2354a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1050b.getHeight()));
        if (!this.f1053e && m2363a()) {
            m2356c();
        }
        if (!(this.f1065q && this.f1053e)) {
            z = false;
        }
        return z;
    }
}
