package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.b */
public final class C0557b {
    private static final C0553c f1090a;

    /* renamed from: android.support.v4.widget.b.c */
    interface C0553c {
        Drawable m2416a(CompoundButton compoundButton);

        void m2417a(CompoundButton compoundButton, ColorStateList colorStateList);

        void m2418a(CompoundButton compoundButton, Mode mode);
    }

    /* renamed from: android.support.v4.widget.b.b */
    static class C0554b implements C0553c {
        C0554b() {
        }

        public Drawable m2419a(CompoundButton compoundButton) {
            return C0559d.m2429a(compoundButton);
        }

        public void m2420a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0559d.m2430a(compoundButton, colorStateList);
        }

        public void m2421a(CompoundButton compoundButton, Mode mode) {
            C0559d.m2431a(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.b.d */
    static class C0555d extends C0554b {
        C0555d() {
        }

        public void m2422a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0560e.m2432a(compoundButton, colorStateList);
        }

        public void m2423a(CompoundButton compoundButton, Mode mode) {
            C0560e.m2433a(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.b.a */
    static class C0556a extends C0555d {
        C0556a() {
        }

        public Drawable m2424a(CompoundButton compoundButton) {
            return C0558c.m2428a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1090a = new C0556a();
        } else if (i >= 21) {
            f1090a = new C0555d();
        } else {
            f1090a = new C0554b();
        }
    }

    public static Drawable m2425a(CompoundButton compoundButton) {
        return f1090a.m2416a(compoundButton);
    }

    public static void m2426a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1090a.m2417a(compoundButton, colorStateList);
    }

    public static void m2427a(CompoundButton compoundButton, Mode mode) {
        f1090a.m2418a(compoundButton, mode);
    }
}
