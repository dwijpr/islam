package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.widget.C0144s.C0142d;
import android.view.View;

@TargetApi(21)
/* renamed from: android.support.design.widget.i */
class C0125i extends C0123g {
    private InsetDrawable f451q;

    C0125i(ab abVar, C0070n c0070n, C0142d c0142d) {
        super(abVar, c0070n, c0142d);
    }

    public float m563a() {
        return this.n.getElevation();
    }

    void m564a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(k, animatorSet);
            animatorSet = new AnimatorSet();
            r2 = new Animator[3];
            r2[0] = ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0);
            r2[1] = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100);
            r2[2] = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100);
            animatorSet.playSequentially(r2);
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(l, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(m, animatorSet);
            this.n.setStateListAnimator(stateListAnimator);
        } else if (this.n.isEnabled()) {
            this.n.setElevation(f);
            if (this.n.isFocused() || this.n.isPressed()) {
                this.n.setTranslationZ(f2);
            } else {
                this.n.setTranslationZ(0.0f);
            }
        } else {
            this.n.setElevation(0.0f);
            this.n.setTranslationZ(0.0f);
        }
        if (this.o.m349b()) {
            m539g();
        }
    }

    void m565a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.m548a(i);
        }
    }

    void m566a(Rect rect) {
        if (this.o.m349b()) {
            float a = this.o.m346a();
            float a2 = m563a() + this.i;
            int ceil = (int) Math.ceil((double) C0128m.m577b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C0128m.m574a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void m567a(int[] iArr) {
    }

    void m568b() {
    }

    void m569b(Rect rect) {
        if (this.o.m349b()) {
            this.f451q = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.o.m348a(this.f451q);
            return;
        }
        this.o.m348a(this.e);
    }

    void m570c() {
        m539g();
    }

    boolean m571d() {
        return false;
    }
}
