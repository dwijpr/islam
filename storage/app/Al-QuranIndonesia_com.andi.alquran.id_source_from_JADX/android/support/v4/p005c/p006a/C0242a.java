package android.support.v4.p005c.p006a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.c.a.a */
public final class C0242a {
    static final C0235b f562a;

    /* renamed from: android.support.v4.c.a.a.b */
    interface C0235b {
        void m794a(Drawable drawable);

        void m795a(Drawable drawable, float f, float f2);

        void m796a(Drawable drawable, int i);

        void m797a(Drawable drawable, int i, int i2, int i3, int i4);

        void m798a(Drawable drawable, ColorStateList colorStateList);

        void m799a(Drawable drawable, Theme theme);

        void m800a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void m801a(Drawable drawable, Mode mode);

        void m802a(Drawable drawable, boolean z);

        boolean m803b(Drawable drawable);

        boolean m804b(Drawable drawable, int i);

        Drawable m805c(Drawable drawable);

        int m806d(Drawable drawable);

        int m807e(Drawable drawable);

        boolean m808f(Drawable drawable);

        ColorFilter m809g(Drawable drawable);
    }

    /* renamed from: android.support.v4.c.a.a.a */
    static class C0236a implements C0235b {
        C0236a() {
        }

        public void m810a(Drawable drawable) {
        }

        public void m811a(Drawable drawable, float f, float f2) {
        }

        public void m812a(Drawable drawable, int i) {
            C0244c.m867a(drawable, i);
        }

        public void m813a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void m814a(Drawable drawable, ColorStateList colorStateList) {
            C0244c.m868a(drawable, colorStateList);
        }

        public void m815a(Drawable drawable, Theme theme) {
        }

        public void m816a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0244c.m869a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void m817a(Drawable drawable, Mode mode) {
            C0244c.m870a(drawable, mode);
        }

        public void m818a(Drawable drawable, boolean z) {
        }

        public boolean m819b(Drawable drawable) {
            return false;
        }

        public boolean m820b(Drawable drawable, int i) {
            return false;
        }

        public Drawable m821c(Drawable drawable) {
            return C0244c.m866a(drawable);
        }

        public int m822d(Drawable drawable) {
            return 0;
        }

        public int m823e(Drawable drawable) {
            return 0;
        }

        public boolean m824f(Drawable drawable) {
            return false;
        }

        public ColorFilter m825g(Drawable drawable) {
            return null;
        }
    }

    /* renamed from: android.support.v4.c.a.a.c */
    static class C0237c extends C0236a {
        C0237c() {
        }

        public void m826a(Drawable drawable) {
            C0245d.m871a(drawable);
        }

        public Drawable m827c(Drawable drawable) {
            return C0245d.m872b(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a.d */
    static class C0238d extends C0237c {
        C0238d() {
        }

        public boolean m828b(Drawable drawable, int i) {
            return C0246e.m874a(drawable, i);
        }

        public int m829d(Drawable drawable) {
            int a = C0246e.m873a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    /* renamed from: android.support.v4.c.a.a.e */
    static class C0239e extends C0238d {
        C0239e() {
        }

        public void m830a(Drawable drawable, boolean z) {
            C0247f.m875a(drawable, z);
        }

        public boolean m831b(Drawable drawable) {
            return C0247f.m876a(drawable);
        }

        public Drawable m832c(Drawable drawable) {
            return C0247f.m877b(drawable);
        }

        public int m833e(Drawable drawable) {
            return C0247f.m878c(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a.f */
    static class C0240f extends C0239e {
        C0240f() {
        }

        public void m834a(Drawable drawable, float f, float f2) {
            C0248g.m880a(drawable, f, f2);
        }

        public void m835a(Drawable drawable, int i) {
            C0248g.m881a(drawable, i);
        }

        public void m836a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0248g.m882a(drawable, i, i2, i3, i4);
        }

        public void m837a(Drawable drawable, ColorStateList colorStateList) {
            C0248g.m883a(drawable, colorStateList);
        }

        public void m838a(Drawable drawable, Theme theme) {
            C0248g.m884a(drawable, theme);
        }

        public void m839a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0248g.m885a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void m840a(Drawable drawable, Mode mode) {
            C0248g.m886a(drawable, mode);
        }

        public Drawable m841c(Drawable drawable) {
            return C0248g.m879a(drawable);
        }

        public boolean m842f(Drawable drawable) {
            return C0248g.m887b(drawable);
        }

        public ColorFilter m843g(Drawable drawable) {
            return C0248g.m888c(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a.g */
    static class C0241g extends C0240f {
        C0241g() {
        }

        public boolean m844b(Drawable drawable, int i) {
            return C0243b.m865a(drawable, i);
        }

        public Drawable m845c(Drawable drawable) {
            return drawable;
        }

        public int m846d(Drawable drawable) {
            return C0243b.m864a(drawable);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f562a = new C0241g();
        } else if (i >= 21) {
            f562a = new C0240f();
        } else if (i >= 19) {
            f562a = new C0239e();
        } else if (i >= 17) {
            f562a = new C0238d();
        } else if (i >= 11) {
            f562a = new C0237c();
        } else {
            f562a = new C0236a();
        }
    }

    public static void m847a(Drawable drawable) {
        f562a.m794a(drawable);
    }

    public static void m848a(Drawable drawable, float f, float f2) {
        f562a.m795a(drawable, f, f2);
    }

    public static void m849a(Drawable drawable, int i) {
        f562a.m796a(drawable, i);
    }

    public static void m850a(Drawable drawable, int i, int i2, int i3, int i4) {
        f562a.m797a(drawable, i, i2, i3, i4);
    }

    public static void m851a(Drawable drawable, ColorStateList colorStateList) {
        f562a.m798a(drawable, colorStateList);
    }

    public static void m852a(Drawable drawable, Theme theme) {
        f562a.m799a(drawable, theme);
    }

    public static void m853a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f562a.m800a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void m854a(Drawable drawable, Mode mode) {
        f562a.m801a(drawable, mode);
    }

    public static void m855a(Drawable drawable, boolean z) {
        f562a.m802a(drawable, z);
    }

    public static boolean m856b(Drawable drawable) {
        return f562a.m803b(drawable);
    }

    public static boolean m857b(Drawable drawable, int i) {
        return f562a.m804b(drawable, i);
    }

    public static int m858c(Drawable drawable) {
        return f562a.m807e(drawable);
    }

    public static boolean m859d(Drawable drawable) {
        return f562a.m808f(drawable);
    }

    public static ColorFilter m860e(Drawable drawable) {
        return f562a.m809g(drawable);
    }

    public static Drawable m861f(Drawable drawable) {
        return f562a.m805c(drawable);
    }

    public static <T extends Drawable> T m862g(Drawable drawable) {
        return drawable instanceof C0249h ? ((C0249h) drawable).m889a() : drawable;
    }

    public static int m863h(Drawable drawable) {
        return f562a.m806d(drawable);
    }
}
