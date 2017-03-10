package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

@TargetApi(14)
class an {
    public static void m1936a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m1937a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m1938a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m1939b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
