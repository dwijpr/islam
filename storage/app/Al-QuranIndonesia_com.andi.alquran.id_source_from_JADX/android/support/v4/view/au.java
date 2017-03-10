package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class au {
    static final C0456d f887a;

    /* renamed from: android.support.v4.view.au.d */
    interface C0456d {
        boolean m1982a(ViewConfiguration viewConfiguration);
    }

    /* renamed from: android.support.v4.view.au.a */
    static class C0457a implements C0456d {
        C0457a() {
        }

        public boolean m1983a(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* renamed from: android.support.v4.view.au.b */
    static class C0458b extends C0457a {
        C0458b() {
        }

        public boolean m1984a(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.au.c */
    static class C0459c extends C0458b {
        C0459c() {
        }

        public boolean m1985a(ViewConfiguration viewConfiguration) {
            return av.m1987a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f887a = new C0459c();
        } else if (VERSION.SDK_INT >= 11) {
            f887a = new C0458b();
        } else {
            f887a = new C0457a();
        }
    }

    public static boolean m1986a(ViewConfiguration viewConfiguration) {
        return f887a.m1982a(viewConfiguration);
    }
}
