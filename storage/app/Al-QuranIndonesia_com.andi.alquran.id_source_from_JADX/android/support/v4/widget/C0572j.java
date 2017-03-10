package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

@TargetApi(14)
/* renamed from: android.support.v4.widget.j */
class C0572j {
    public static Object m2473a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m2474a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m2475a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static boolean m2476a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m2477a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m2478a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }

    public static void m2479b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m2480c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
