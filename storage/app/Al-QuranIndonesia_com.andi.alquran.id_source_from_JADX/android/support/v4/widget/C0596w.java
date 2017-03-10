package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.w */
public final class C0596w {
    static final C0590f f1106a;

    /* renamed from: android.support.v4.widget.w.f */
    interface C0590f {
        int m2528a(TextView textView);

        void m2529a(TextView textView, int i);

        void m2530a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);
    }

    /* renamed from: android.support.v4.widget.w.b */
    static class C0591b implements C0590f {
        C0591b() {
        }

        public int m2531a(TextView textView) {
            return C0598y.m2542a(textView);
        }

        public void m2532a(TextView textView, int i) {
            C0598y.m2545a(textView, i);
        }

        public void m2533a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.w.e */
    static class C0592e extends C0591b {
        C0592e() {
        }

        public int m2534a(TextView textView) {
            return C0599z.m2546a(textView);
        }
    }

    /* renamed from: android.support.v4.widget.w.c */
    static class C0593c extends C0592e {
        C0593c() {
        }

        public void m2535a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            aa.m2374a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.w.d */
    static class C0594d extends C0593c {
        C0594d() {
        }

        public void m2536a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ab.m2375a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.w.a */
    static class C0595a extends C0594d {
        C0595a() {
        }

        public void m2537a(TextView textView, int i) {
            C0597x.m2541a(textView, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1106a = new C0595a();
        } else if (i >= 18) {
            f1106a = new C0594d();
        } else if (i >= 17) {
            f1106a = new C0593c();
        } else if (i >= 16) {
            f1106a = new C0592e();
        } else {
            f1106a = new C0591b();
        }
    }

    public static int m2538a(TextView textView) {
        return f1106a.m2528a(textView);
    }

    public static void m2539a(TextView textView, int i) {
        f1106a.m2529a(textView, i);
    }

    public static void m2540a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1106a.m2530a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
