package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;

@TargetApi(16)
class ap {
    public static void m1941a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m1942a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void m1943a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m1944a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static boolean m1945a(View view) {
        return view.hasTransientState();
    }

    public static void m1946b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int m1947c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int m1948d(View view) {
        return view.getMinimumWidth();
    }

    public static int m1949e(View view) {
        return view.getMinimumHeight();
    }

    public static void m1950f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m1951g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m1952h(View view) {
        return view.hasOverlappingRendering();
    }
}
