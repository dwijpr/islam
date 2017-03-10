package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.C0144s.C0143e;
import android.support.design.widget.C0144s.C0143e.C0138b;
import android.support.design.widget.C0144s.C0143e.C0140a;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.t */
class C0146t extends C0143e {
    private static final Handler f497a;
    private long f498b;
    private boolean f499c;
    private float f500d;
    private final int[] f501e;
    private final float[] f502f;
    private long f503g;
    private Interpolator f504h;
    private ArrayList<C0140a> f505i;
    private ArrayList<C0138b> f506j;
    private final Runnable f507k;

    /* renamed from: android.support.design.widget.t.1 */
    class C01451 implements Runnable {
        final /* synthetic */ C0146t f496a;

        C01451(C0146t c0146t) {
            this.f496a = c0146t;
        }

        public void run() {
            this.f496a.m660i();
        }
    }

    static {
        f497a = new Handler(Looper.getMainLooper());
    }

    C0146t() {
        this.f501e = new int[2];
        this.f502f = new float[2];
        this.f503g = 200;
        this.f507k = new C01451(this);
    }

    private void m642j() {
        if (this.f506j != null) {
            int size = this.f506j.size();
            for (int i = 0; i < size; i++) {
                ((C0138b) this.f506j.get(i)).m607a();
            }
        }
    }

    private void m643k() {
        if (this.f505i != null) {
            int size = this.f505i.size();
            for (int i = 0; i < size; i++) {
                ((C0140a) this.f505i.get(i)).m609a();
            }
        }
    }

    private void m644l() {
        if (this.f505i != null) {
            int size = this.f505i.size();
            for (int i = 0; i < size; i++) {
                ((C0140a) this.f505i.get(i)).m611c();
            }
        }
    }

    private void m645m() {
        if (this.f505i != null) {
            int size = this.f505i.size();
            for (int i = 0; i < size; i++) {
                ((C0140a) this.f505i.get(i)).m610b();
            }
        }
    }

    public void m646a() {
        if (!this.f499c) {
            if (this.f504h == null) {
                this.f504h = new AccelerateDecelerateInterpolator();
            }
            this.f499c = true;
            this.f500d = 0.0f;
            m659h();
        }
    }

    public void m647a(float f, float f2) {
        this.f502f[0] = f;
        this.f502f[1] = f2;
    }

    public void m648a(int i, int i2) {
        this.f501e[0] = i;
        this.f501e[1] = i2;
    }

    public void m649a(long j) {
        this.f503g = j;
    }

    public void m650a(C0140a c0140a) {
        if (this.f505i == null) {
            this.f505i = new ArrayList();
        }
        this.f505i.add(c0140a);
    }

    public void m651a(C0138b c0138b) {
        if (this.f506j == null) {
            this.f506j = new ArrayList();
        }
        this.f506j.add(c0138b);
    }

    public void m652a(Interpolator interpolator) {
        this.f504h = interpolator;
    }

    public boolean m653b() {
        return this.f499c;
    }

    public int m654c() {
        return C0093a.m482a(this.f501e[0], this.f501e[1], m656e());
    }

    public void m655d() {
        this.f499c = false;
        f497a.removeCallbacks(this.f507k);
        m644l();
        m645m();
    }

    public float m656e() {
        return this.f500d;
    }

    public void m657f() {
        if (this.f499c) {
            this.f499c = false;
            f497a.removeCallbacks(this.f507k);
            this.f500d = 1.0f;
            m642j();
            m645m();
        }
    }

    public long m658g() {
        return this.f503g;
    }

    final void m659h() {
        this.f498b = SystemClock.uptimeMillis();
        m642j();
        m643k();
        f497a.postDelayed(this.f507k, 10);
    }

    final void m660i() {
        if (this.f499c) {
            float a = C0127l.m572a(((float) (SystemClock.uptimeMillis() - this.f498b)) / ((float) this.f503g), 0.0f, 1.0f);
            if (this.f504h != null) {
                a = this.f504h.getInterpolation(a);
            }
            this.f500d = a;
            m642j();
            if (SystemClock.uptimeMillis() >= this.f498b + this.f503g) {
                this.f499c = false;
                m645m();
            }
        }
        if (this.f499c) {
            f497a.postDelayed(this.f507k, 10);
        }
    }
}
