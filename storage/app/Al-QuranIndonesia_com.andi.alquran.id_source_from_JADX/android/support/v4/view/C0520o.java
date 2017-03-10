package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.view.o */
public final class C0520o {
    static final C0517a f949a;

    /* renamed from: android.support.v4.view.o.a */
    interface C0517a {
        int m2179a(MarginLayoutParams marginLayoutParams);

        int m2180b(MarginLayoutParams marginLayoutParams);
    }

    /* renamed from: android.support.v4.view.o.b */
    static class C0518b implements C0517a {
        C0518b() {
        }

        public int m2181a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int m2182b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    /* renamed from: android.support.v4.view.o.c */
    static class C0519c implements C0517a {
        C0519c() {
        }

        public int m2183a(MarginLayoutParams marginLayoutParams) {
            return C0521p.m2187a(marginLayoutParams);
        }

        public int m2184b(MarginLayoutParams marginLayoutParams) {
            return C0521p.m2188b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f949a = new C0519c();
        } else {
            f949a = new C0518b();
        }
    }

    public static int m2185a(MarginLayoutParams marginLayoutParams) {
        return f949a.m2179a(marginLayoutParams);
    }

    public static int m2186b(MarginLayoutParams marginLayoutParams) {
        return f949a.m2180b(marginLayoutParams);
    }
}
