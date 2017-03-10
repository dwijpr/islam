package android.support.design.widget;

import android.support.v4.view.p016b.C0477a;
import android.support.v4.view.p016b.C0478b;
import android.support.v4.view.p016b.C0479c;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
class C0093a {
    static final Interpolator f370a;
    static final Interpolator f371b;
    static final Interpolator f372c;
    static final Interpolator f373d;
    static final Interpolator f374e;

    /* renamed from: android.support.design.widget.a.a */
    static class C0092a implements AnimationListener {
        C0092a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static {
        f370a = new LinearInterpolator();
        f371b = new C0478b();
        f372c = new C0477a();
        f373d = new C0479c();
        f374e = new DecelerateInterpolator();
    }

    static int m482a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
