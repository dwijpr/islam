package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Interpolator;

@TargetApi(14)
class az {

    /* renamed from: android.support.v4.view.az.1 */
    static class C04741 extends AnimatorListenerAdapter {
        final /* synthetic */ bc f901a;
        final /* synthetic */ View f902b;

        C04741(bc bcVar, View view) {
            this.f901a = bcVar;
            this.f902b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f901a.onAnimationCancel(this.f902b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f901a.onAnimationEnd(this.f902b);
        }

        public void onAnimationStart(Animator animator) {
            this.f901a.onAnimationStart(this.f902b);
        }
    }

    public static long m2071a(View view) {
        return view.animate().getDuration();
    }

    public static void m2072a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2073a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2074a(View view, bc bcVar) {
        if (bcVar != null) {
            view.animate().setListener(new C04741(bcVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void m2075a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2076b(View view) {
        view.animate().cancel();
    }

    public static void m2077b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2078b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2079c(View view) {
        view.animate().start();
    }

    public static void m2080c(View view, float f) {
        view.animate().translationY(f);
    }
}
