package android.support.v4.p013f;

import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: android.support.v4.f.b */
public final class C0280b {
    private static final C0276a f598a;

    /* renamed from: android.support.v4.f.b.a */
    interface C0276a {
        String m941a(Locale locale);
    }

    /* renamed from: android.support.v4.f.b.b */
    static class C0277b implements C0276a {
        C0277b() {
        }

        public String m942a(Locale locale) {
            return null;
        }
    }

    /* renamed from: android.support.v4.f.b.c */
    static class C0278c implements C0276a {
        C0278c() {
        }

        public String m943a(Locale locale) {
            return C0282d.m948a(locale);
        }
    }

    /* renamed from: android.support.v4.f.b.d */
    static class C0279d implements C0276a {
        C0279d() {
        }

        public String m944a(Locale locale) {
            return C0281c.m946a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f598a = new C0279d();
        } else if (i >= 14) {
            f598a = new C0278c();
        } else {
            f598a = new C0277b();
        }
    }

    public static String m945a(Locale locale) {
        return f598a.m941a(locale);
    }
}
