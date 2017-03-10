package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.design.widget.v */
class C0153v {
    private static final C0150a f513a;

    /* renamed from: android.support.design.widget.v.a */
    private interface C0150a {
        void m674a(ViewGroup viewGroup, View view, Rect rect);
    }

    /* renamed from: android.support.design.widget.v.b */
    private static class C0151b implements C0150a {
        C0151b() {
        }

        public void m675a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    /* renamed from: android.support.design.widget.v.c */
    private static class C0152c implements C0150a {
        C0152c() {
        }

        public void m676a(ViewGroup viewGroup, View view, Rect rect) {
            C0154w.m679a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f513a = new C0152c();
        } else {
            f513a = new C0151b();
        }
    }

    static void m677a(ViewGroup viewGroup, View view, Rect rect) {
        f513a.m674a(viewGroup, view, rect);
    }

    static void m678b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C0153v.m677a(viewGroup, view, rect);
    }
}
