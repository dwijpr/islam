package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.design.widget.C0144s.C0143e;
import android.support.design.widget.C0144s.C0143e.C0138b;
import android.support.design.widget.C0144s.C0143e.C0140a;
import android.view.animation.Interpolator;

@TargetApi(12)
/* renamed from: android.support.design.widget.u */
class C0149u extends C0143e {
    private final ValueAnimator f512a;

    /* renamed from: android.support.design.widget.u.1 */
    class C01471 implements AnimatorUpdateListener {
        final /* synthetic */ C0138b f508a;
        final /* synthetic */ C0149u f509b;

        C01471(C0149u c0149u, C0138b c0138b) {
            this.f509b = c0149u;
            this.f508a = c0138b;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f508a.m607a();
        }
    }

    /* renamed from: android.support.design.widget.u.2 */
    class C01482 extends AnimatorListenerAdapter {
        final /* synthetic */ C0140a f510a;
        final /* synthetic */ C0149u f511b;

        C01482(C0149u c0149u, C0140a c0140a) {
            this.f511b = c0149u;
            this.f510a = c0140a;
        }

        public void onAnimationCancel(Animator animator) {
            this.f510a.m611c();
        }

        public void onAnimationEnd(Animator animator) {
            this.f510a.m610b();
        }

        public void onAnimationStart(Animator animator) {
            this.f510a.m609a();
        }
    }

    C0149u() {
        this.f512a = new ValueAnimator();
    }

    public void m661a() {
        this.f512a.start();
    }

    public void m662a(float f, float f2) {
        this.f512a.setFloatValues(new float[]{f, f2});
    }

    public void m663a(int i, int i2) {
        this.f512a.setIntValues(new int[]{i, i2});
    }

    public void m664a(long j) {
        this.f512a.setDuration(j);
    }

    public void m665a(C0140a c0140a) {
        this.f512a.addListener(new C01482(this, c0140a));
    }

    public void m666a(C0138b c0138b) {
        this.f512a.addUpdateListener(new C01471(this, c0138b));
    }

    public void m667a(Interpolator interpolator) {
        this.f512a.setInterpolator(interpolator);
    }

    public boolean m668b() {
        return this.f512a.isRunning();
    }

    public int m669c() {
        return ((Integer) this.f512a.getAnimatedValue()).intValue();
    }

    public void m670d() {
        this.f512a.cancel();
    }

    public float m671e() {
        return this.f512a.getAnimatedFraction();
    }

    public void m672f() {
        this.f512a.end();
    }

    public long m673g() {
        return this.f512a.getDuration();
    }
}
