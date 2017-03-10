package android.support.v4.widget;

import android.annotation.TargetApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@TargetApi(21)
/* renamed from: android.support.v4.widget.q */
class C0584q {
    private static Field f1103a;

    static {
        try {
            f1103a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1103a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m2506a(PopupWindow popupWindow, boolean z) {
        if (f1103a != null) {
            try {
                f1103a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    static boolean m2507a(PopupWindow popupWindow) {
        if (f1103a != null) {
            try {
                return ((Boolean) f1103a.get(popupWindow)).booleanValue();
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }
}
