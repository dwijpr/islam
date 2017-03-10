package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class ah {
    static final C0438c f874a;

    /* renamed from: android.support.v4.view.ah.c */
    interface C0438c {
        float m1640a(VelocityTracker velocityTracker, int i);

        float m1641b(VelocityTracker velocityTracker, int i);
    }

    /* renamed from: android.support.v4.view.ah.a */
    static class C0439a implements C0438c {
        C0439a() {
        }

        public float m1642a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float m1643b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.view.ah.b */
    static class C0440b implements C0438c {
        C0440b() {
        }

        public float m1644a(VelocityTracker velocityTracker, int i) {
            return ai.m1648a(velocityTracker, i);
        }

        public float m1645b(VelocityTracker velocityTracker, int i) {
            return ai.m1649b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f874a = new C0440b();
        } else {
            f874a = new C0439a();
        }
    }

    public static float m1646a(VelocityTracker velocityTracker, int i) {
        return f874a.m1640a(velocityTracker, i);
    }

    public static float m1647b(VelocityTracker velocityTracker, int i) {
        return f874a.m1641b(velocityTracker, i);
    }
}
