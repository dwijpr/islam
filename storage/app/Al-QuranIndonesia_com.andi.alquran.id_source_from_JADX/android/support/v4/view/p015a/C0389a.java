package android.support.v4.view.p015a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a.a */
public final class C0389a {
    private static final C0384e f853a;

    /* renamed from: android.support.v4.view.a.a.e */
    interface C0384e {
        int m1399a(AccessibilityEvent accessibilityEvent);

        void m1400a(AccessibilityEvent accessibilityEvent, int i);
    }

    /* renamed from: android.support.v4.view.a.a.d */
    static class C0385d implements C0384e {
        C0385d() {
        }

        public int m1401a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void m1402a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    /* renamed from: android.support.v4.view.a.a.a */
    static class C0386a extends C0385d {
        C0386a() {
        }
    }

    /* renamed from: android.support.v4.view.a.a.b */
    static class C0387b extends C0386a {
        C0387b() {
        }
    }

    /* renamed from: android.support.v4.view.a.a.c */
    static class C0388c extends C0387b {
        C0388c() {
        }

        public int m1403a(AccessibilityEvent accessibilityEvent) {
            return C0390b.m1408a(accessibilityEvent);
        }

        public void m1404a(AccessibilityEvent accessibilityEvent, int i) {
            C0390b.m1409a(accessibilityEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f853a = new C0388c();
        } else if (VERSION.SDK_INT >= 16) {
            f853a = new C0387b();
        } else if (VERSION.SDK_INT >= 14) {
            f853a = new C0386a();
        } else {
            f853a = new C0385d();
        }
    }

    public static C0427k m1405a(AccessibilityEvent accessibilityEvent) {
        return new C0427k(accessibilityEvent);
    }

    public static void m1406a(AccessibilityEvent accessibilityEvent, int i) {
        f853a.m1400a(accessibilityEvent, i);
    }

    public static int m1407b(AccessibilityEvent accessibilityEvent) {
        return f853a.m1399a(accessibilityEvent);
    }
}
