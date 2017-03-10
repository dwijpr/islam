package android.support.v4.p008a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(12)
/* renamed from: android.support.v4.a.f */
class C0169f implements C0160c {
    private TimeInterpolator f538a;

    /* renamed from: android.support.v4.a.f.a */
    static class C0166a implements AnimatorListener {
        final C0159b f533a;
        final C0163g f534b;

        public C0166a(C0159b c0159b, C0163g c0163g) {
            this.f533a = c0159b;
            this.f534b = c0163g;
        }

        public void onAnimationCancel(Animator animator) {
            this.f533a.onAnimationCancel(this.f534b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f533a.onAnimationEnd(this.f534b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.f533a.onAnimationRepeat(this.f534b);
        }

        public void onAnimationStart(Animator animator) {
            this.f533a.onAnimationStart(this.f534b);
        }
    }

    /* renamed from: android.support.v4.a.f.b */
    static class C0168b implements C0163g {
        final Animator f537a;

        /* renamed from: android.support.v4.a.f.b.1 */
        class C01671 implements AnimatorUpdateListener {
            final /* synthetic */ C0161d f535a;
            final /* synthetic */ C0168b f536b;

            C01671(C0168b c0168b, C0161d c0161d) {
                this.f536b = c0168b;
                this.f535a = c0161d;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f535a.onAnimationUpdate(this.f536b);
            }
        }

        public C0168b(Animator animator) {
            this.f537a = animator;
        }

        public void m722a() {
            this.f537a.start();
        }

        public void m723a(long j) {
            this.f537a.setDuration(j);
        }

        public void m724a(C0159b c0159b) {
            this.f537a.addListener(new C0166a(c0159b, this));
        }

        public void m725a(C0161d c0161d) {
            if (this.f537a instanceof ValueAnimator) {
                ((ValueAnimator) this.f537a).addUpdateListener(new C01671(this, c0161d));
            }
        }

        public void m726a(View view) {
            this.f537a.setTarget(view);
        }

        public void m727b() {
            this.f537a.cancel();
        }

        public float m728c() {
            return ((ValueAnimator) this.f537a).getAnimatedFraction();
        }
    }

    C0169f() {
    }

    public C0163g m729a() {
        return new C0168b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public void m730a(View view) {
        if (this.f538a == null) {
            this.f538a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f538a);
    }
}
