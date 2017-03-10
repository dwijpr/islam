package android.support.v4.widget;

import android.annotation.TargetApi;
import android.widget.PopupWindow;

@TargetApi(23)
/* renamed from: android.support.v4.widget.r */
class C0585r {
    static void m2508a(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }

    static void m2509a(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    static boolean m2510a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }
}
