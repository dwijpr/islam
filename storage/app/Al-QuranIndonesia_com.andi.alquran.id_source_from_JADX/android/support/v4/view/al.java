package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;

@TargetApi(9)
class al {
    private static Field f881a;
    private static boolean f882b;
    private static Field f883c;
    private static boolean f884d;

    static ColorStateList m1905a(View view) {
        return view instanceof ag ? ((ag) view).getSupportBackgroundTintList() : null;
    }

    static void m1906a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m1907a(View view, ColorStateList colorStateList) {
        if (view instanceof ag) {
            ((ag) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void m1908a(View view, Mode mode) {
        if (view instanceof ag) {
            ((ag) view).setSupportBackgroundTintMode(mode);
        }
    }

    static Mode m1909b(View view) {
        return view instanceof ag ? ((ag) view).getSupportBackgroundTintMode() : null;
    }

    static void m1910b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    static boolean m1911c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m1912d(View view) {
        if (!f882b) {
            try {
                f881a = View.class.getDeclaredField("mMinWidth");
                f881a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f882b = true;
        }
        if (f881a != null) {
            try {
                return ((Integer) f881a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m1913e(View view) {
        if (!f884d) {
            try {
                f883c = View.class.getDeclaredField("mMinHeight");
                f883c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f884d = true;
        }
        if (f883c != null) {
            try {
                return ((Integer) f883c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m1914f(View view) {
        return view.getWindowToken() != null;
    }

    static Display m1915g(View view) {
        return m1914f(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
    }
}
