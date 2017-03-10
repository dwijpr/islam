package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(16)
class ba {

    /* renamed from: android.support.v4.view.ba.1 */
    static class C04811 extends AnimatorListenerAdapter {
        final /* synthetic */ bc f909a;
        final /* synthetic */ View f910b;

        C04811(bc bcVar, View view) {
            this.f909a = bcVar;
            this.f910b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f909a.onAnimationCancel(this.f910b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f909a.onAnimationEnd(this.f910b);
        }

        public void onAnimationStart(Animator animator) {
            this.f909a.onAnimationStart(this.f910b);
        }
    }

    public static void m2090a(View view, bc bcVar) {
        if (bcVar != null) {
            view.animate().setListener(new C04811(bcVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
