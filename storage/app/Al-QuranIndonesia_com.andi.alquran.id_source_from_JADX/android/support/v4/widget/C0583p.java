package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.C0500f;
import android.support.v4.view.aj;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.p */
public final class C0583p {
    static final C0578e f1102a;

    /* renamed from: android.support.v4.widget.p.e */
    interface C0578e {
        void m2488a(PopupWindow popupWindow, int i);

        void m2489a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void m2490a(PopupWindow popupWindow, boolean z);

        boolean m2491a(PopupWindow popupWindow);
    }

    /* renamed from: android.support.v4.widget.p.c */
    static class C0579c implements C0578e {
        private static Method f1100a;
        private static boolean f1101b;

        C0579c() {
        }

        public void m2492a(PopupWindow popupWindow, int i) {
            if (!f1101b) {
                try {
                    f1100a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    f1100a.setAccessible(true);
                } catch (Exception e) {
                }
                f1101b = true;
            }
            if (f1100a != null) {
                try {
                    f1100a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }

        public void m2493a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0500f.m2143a(i3, aj.m1884g(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void m2494a(PopupWindow popupWindow, boolean z) {
        }

        public boolean m2495a(PopupWindow popupWindow) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.p.d */
    static class C0580d extends C0579c {
        C0580d() {
        }

        public void m2496a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0586s.m2511a(popupWindow, view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.p.a */
    static class C0581a extends C0580d {
        C0581a() {
        }

        public void m2497a(PopupWindow popupWindow, boolean z) {
            C0584q.m2506a(popupWindow, z);
        }

        public boolean m2498a(PopupWindow popupWindow) {
            return C0584q.m2507a(popupWindow);
        }
    }

    /* renamed from: android.support.v4.widget.p.b */
    static class C0582b extends C0581a {
        C0582b() {
        }

        public void m2499a(PopupWindow popupWindow, int i) {
            C0585r.m2508a(popupWindow, i);
        }

        public void m2500a(PopupWindow popupWindow, boolean z) {
            C0585r.m2509a(popupWindow, z);
        }

        public boolean m2501a(PopupWindow popupWindow) {
            return C0585r.m2510a(popupWindow);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1102a = new C0582b();
        } else if (i >= 21) {
            f1102a = new C0581a();
        } else if (i >= 19) {
            f1102a = new C0580d();
        } else {
            f1102a = new C0579c();
        }
    }

    public static void m2502a(PopupWindow popupWindow, int i) {
        f1102a.m2488a(popupWindow, i);
    }

    public static void m2503a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1102a.m2489a(popupWindow, view, i, i2, i3);
    }

    public static void m2504a(PopupWindow popupWindow, boolean z) {
        f1102a.m2490a(popupWindow, z);
    }

    public static boolean m2505a(PopupWindow popupWindow) {
        return f1102a.m2491a(popupWindow);
    }
}
