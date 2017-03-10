package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.t */
public final class C0534t {
    static final C0530d f951a;

    /* renamed from: android.support.v4.view.t.d */
    interface C0530d {
        float m2222a(MotionEvent motionEvent, int i);
    }

    /* renamed from: android.support.v4.view.t.a */
    static class C0531a implements C0530d {
        C0531a() {
        }

        public float m2223a(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    /* renamed from: android.support.v4.view.t.b */
    static class C0532b extends C0531a {
        C0532b() {
        }

        public float m2224a(MotionEvent motionEvent, int i) {
            return C0535u.m2228a(motionEvent, i);
        }
    }

    /* renamed from: android.support.v4.view.t.c */
    private static class C0533c extends C0532b {
        C0533c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f951a = new C0533c();
        } else if (VERSION.SDK_INT >= 12) {
            f951a = new C0532b();
        } else {
            f951a = new C0531a();
        }
    }

    public static float m2225a(MotionEvent motionEvent, int i) {
        return f951a.m2222a(motionEvent, i);
    }

    public static int m2226a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2227b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }
}
