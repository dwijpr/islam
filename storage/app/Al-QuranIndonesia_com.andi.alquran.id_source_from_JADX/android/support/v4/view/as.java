package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

@TargetApi(21)
class as {
    private static ThreadLocal<Rect> f886a;

    /* renamed from: android.support.v4.view.as.a */
    public interface C0453a {
        Object m1842a(View view, Object obj);
    }

    /* renamed from: android.support.v4.view.as.1 */
    static class C04551 implements OnApplyWindowInsetsListener {
        final /* synthetic */ C0453a f885a;

        C04551(C0453a c0453a) {
            this.f885a = c0453a;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) this.f885a.m1842a(view, windowInsets);
        }
    }

    private static Rect m1962a() {
        if (f886a == null) {
            f886a = new ThreadLocal();
        }
        Rect rect = (Rect) f886a.get();
        if (rect == null) {
            rect = new Rect();
            f886a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static Object m1963a(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets != windowInsets ? new WindowInsets(onApplyWindowInsets) : obj;
    }

    public static String m1964a(View view) {
        return view.getTransitionName();
    }

    public static void m1965a(View view, float f) {
        view.setElevation(f);
    }

    static void m1966a(View view, int i) {
        Object obj;
        Rect a = m1962a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        am.m1921a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m1967a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static void m1968a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static void m1969a(View view, C0453a c0453a) {
        if (c0453a == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new C04551(c0453a));
        }
    }

    public static Object m1970b(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        return dispatchApplyWindowInsets != windowInsets ? new WindowInsets(dispatchApplyWindowInsets) : obj;
    }

    public static void m1971b(View view) {
        view.requestApplyInsets();
    }

    static void m1972b(View view, int i) {
        Object obj;
        Rect a = m1962a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        am.m1926b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public static float m1973c(View view) {
        return view.getElevation();
    }

    public static float m1974d(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList m1975e(View view) {
        return view.getBackgroundTintList();
    }

    static Mode m1976f(View view) {
        return view.getBackgroundTintMode();
    }

    public static void m1977g(View view) {
        view.stopNestedScroll();
    }

    public static float m1978h(View view) {
        return view.getZ();
    }
}
