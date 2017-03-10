package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;

@TargetApi(19)
/* renamed from: android.support.v4.c.a.f */
class C0247f {
    public static void m875a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m876a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m877b(Drawable drawable) {
        return !(drawable instanceof C0011m) ? new C0256k(drawable) : drawable;
    }

    public static int m878c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
