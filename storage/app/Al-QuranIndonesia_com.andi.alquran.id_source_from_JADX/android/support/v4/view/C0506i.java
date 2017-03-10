package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.KeyEvent;

@TargetApi(11)
/* renamed from: android.support.v4.view.i */
class C0506i {
    public static int m2162a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2163a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2164a(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    public static boolean m2165b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
