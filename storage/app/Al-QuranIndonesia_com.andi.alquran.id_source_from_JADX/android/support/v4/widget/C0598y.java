package android.support.v4.widget;

import android.annotation.TargetApi;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

@TargetApi(9)
/* renamed from: android.support.v4.widget.y */
class C0598y {
    private static Field f1107a;
    private static boolean f1108b;
    private static Field f1109c;
    private static boolean f1110d;

    static int m2542a(TextView textView) {
        if (!f1110d) {
            f1109c = C0598y.m2544a("mMaxMode");
            f1110d = true;
        }
        if (f1109c != null && C0598y.m2543a(f1109c, textView) == 1) {
            if (!f1108b) {
                f1107a = C0598y.m2544a("mMaximum");
                f1108b = true;
            }
            if (f1107a != null) {
                return C0598y.m2543a(f1107a, textView);
            }
        }
        return -1;
    }

    private static int m2543a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatGingerbread", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    private static Field m2544a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatGingerbread", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    static void m2545a(TextView textView, int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }
}
