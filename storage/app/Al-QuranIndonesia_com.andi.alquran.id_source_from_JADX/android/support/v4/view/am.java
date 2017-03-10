package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

@TargetApi(11)
class am {
    public static float m1916a(View view) {
        return view.getAlpha();
    }

    public static int m1917a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m1918a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long m1919a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m1920a(View view, float f) {
        view.setTranslationX(f);
    }

    static void m1921a(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m1935i(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m1935i((View) parent);
            }
        }
    }

    public static void m1922a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m1923a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int m1924b(View view) {
        return view.getLayerType();
    }

    public static void m1925b(View view, float f) {
        view.setTranslationY(f);
    }

    static void m1926b(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m1935i(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m1935i((View) parent);
            }
        }
    }

    public static void m1927b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m1928c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void m1929c(View view, float f) {
        view.setAlpha(f);
    }

    public static int m1930d(View view) {
        return view.getMeasuredState();
    }

    public static float m1931e(View view) {
        return view.getTranslationX();
    }

    public static float m1932f(View view) {
        return view.getTranslationY();
    }

    public static Matrix m1933g(View view) {
        return view.getMatrix();
    }

    public static void m1934h(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void m1935i(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
