package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* renamed from: android.support.v4.view.f */
public final class C0500f {
    static final C0497a f943a;

    /* renamed from: android.support.v4.view.f.a */
    interface C0497a {
        int m2137a(int i, int i2);

        void m2138a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    /* renamed from: android.support.v4.view.f.b */
    static class C0498b implements C0497a {
        C0498b() {
        }

        public int m2139a(int i, int i2) {
            return -8388609 & i;
        }

        public void m2140a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    /* renamed from: android.support.v4.view.f.c */
    static class C0499c implements C0497a {
        C0499c() {
        }

        public int m2141a(int i, int i2) {
            return C0501g.m2145a(i, i2);
        }

        public void m2142a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            C0501g.m2146a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f943a = new C0499c();
        } else {
            f943a = new C0498b();
        }
    }

    public static int m2143a(int i, int i2) {
        return f943a.m2137a(i, i2);
    }

    public static void m2144a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f943a.m2138a(i, i2, i3, rect, rect2, i4);
    }
}
