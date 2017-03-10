package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.j */
public final class C0511j {
    static final C0507a f945a;

    /* renamed from: android.support.v4.view.j.a */
    interface C0507a {
        C0183n m2166a(LayoutInflater layoutInflater);

        void m2167a(LayoutInflater layoutInflater, C0183n c0183n);
    }

    /* renamed from: android.support.v4.view.j.b */
    static class C0508b implements C0507a {
        C0508b() {
        }

        public C0183n m2168a(LayoutInflater layoutInflater) {
            return C0513k.m2174a(layoutInflater);
        }

        public void m2169a(LayoutInflater layoutInflater, C0183n c0183n) {
            C0513k.m2175a(layoutInflater, c0183n);
        }
    }

    /* renamed from: android.support.v4.view.j.c */
    static class C0509c extends C0508b {
        C0509c() {
        }

        public void m2170a(LayoutInflater layoutInflater, C0183n c0183n) {
            C0515l.m2176a(layoutInflater, c0183n);
        }
    }

    /* renamed from: android.support.v4.view.j.d */
    static class C0510d extends C0509c {
        C0510d() {
        }

        public void m2171a(LayoutInflater layoutInflater, C0183n c0183n) {
            C0516m.m2178a(layoutInflater, c0183n);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f945a = new C0510d();
        } else if (i >= 11) {
            f945a = new C0509c();
        } else {
            f945a = new C0508b();
        }
    }

    public static C0183n m2172a(LayoutInflater layoutInflater) {
        return f945a.m2166a(layoutInflater);
    }

    public static void m2173a(LayoutInflater layoutInflater, C0183n c0183n) {
        f945a.m2167a(layoutInflater, c0183n);
    }
}
