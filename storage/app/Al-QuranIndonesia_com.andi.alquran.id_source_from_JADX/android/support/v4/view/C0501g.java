package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.Gravity;

@TargetApi(17)
/* renamed from: android.support.v4.view.g */
class C0501g {
    public static int m2145a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void m2146a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
