package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.WindowInsets;

@TargetApi(20)
class bg {
    public static int m2118a(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetBottom();
    }

    public static Object m2119a(Object obj, int i, int i2, int i3, int i4) {
        return ((WindowInsets) obj).replaceSystemWindowInsets(i, i2, i3, i4);
    }

    public static int m2120b(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetLeft();
    }

    public static int m2121c(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetRight();
    }

    public static int m2122d(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetTop();
    }
}
