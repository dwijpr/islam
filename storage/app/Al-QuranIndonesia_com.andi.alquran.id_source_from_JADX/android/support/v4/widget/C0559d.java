package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

@TargetApi(9)
/* renamed from: android.support.v4.widget.d */
class C0559d {
    private static Field f1091a;
    private static boolean f1092b;

    static Drawable m2429a(CompoundButton compoundButton) {
        if (!f1092b) {
            try {
                f1091a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1091a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to retrieve mButtonDrawable field", e);
            }
            f1092b = true;
        }
        if (f1091a != null) {
            try {
                return (Drawable) f1091a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to get button drawable via reflection", e2);
                f1091a = null;
            }
        }
        return null;
    }

    static void m2430a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m2431a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
