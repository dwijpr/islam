package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(19)
class bb {

    /* renamed from: android.support.v4.view.bb.1 */
    static class C04821 implements AnimatorUpdateListener {
        final /* synthetic */ be f911a;
        final /* synthetic */ View f912b;

        C04821(be beVar, View view) {
            this.f911a = beVar;
            this.f912b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f911a.onAnimationUpdate(this.f912b);
        }
    }

    public static void m2091a(View view, be beVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (beVar != null) {
            animatorUpdateListener = new C04821(beVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
