package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(17)
/* renamed from: android.support.v4.c.a.e */
class C0246e {
    private static Method f563a;
    private static boolean f564b;
    private static Method f565c;
    private static boolean f566d;

    public static int m873a(Drawable drawable) {
        if (!f566d) {
            try {
                f565c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f565c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f566d = true;
        }
        if (f565c != null) {
            try {
                return ((Integer) f565c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f565c = null;
            }
        }
        return -1;
    }

    public static boolean m874a(Drawable drawable, int i) {
        if (!f564b) {
            try {
                f563a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f563a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f564b = true;
        }
        if (f563a != null) {
            try {
                f563a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f563a = null;
            }
        }
        return false;
    }
}
