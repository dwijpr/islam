package android.support.v4.p009b.p010a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@TargetApi(9)
/* renamed from: android.support.v4.b.a.b */
class C0210b {
    static int m743a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int m744b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int m745c(Resources resources) {
        return Math.min(C0210b.m744b(resources), C0210b.m743a(resources));
    }
}
