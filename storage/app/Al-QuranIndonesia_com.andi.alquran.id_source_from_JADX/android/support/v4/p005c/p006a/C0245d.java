package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;

@TargetApi(11)
/* renamed from: android.support.v4.c.a.d */
class C0245d {
    public static void m871a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m872b(Drawable drawable) {
        return !(drawable instanceof C0011m) ? new C0254j(drawable) : drawable;
    }
}
