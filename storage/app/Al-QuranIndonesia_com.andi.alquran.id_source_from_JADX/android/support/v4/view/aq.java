package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.Display;
import android.view.View;

@TargetApi(17)
class aq {
    public static int m1953a(View view) {
        return view.getLayoutDirection();
    }

    public static void m1954a(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static int m1955b(View view) {
        return view.getPaddingStart();
    }

    public static int m1956c(View view) {
        return view.getPaddingEnd();
    }

    public static int m1957d(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean m1958e(View view) {
        return view.isPaddingRelative();
    }

    public static Display m1959f(View view) {
        return view.getDisplay();
    }
}
