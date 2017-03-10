package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(9)
/* renamed from: android.support.v4.c.a.c */
class C0244c {
    public static Drawable m866a(Drawable drawable) {
        return !(drawable instanceof C0011m) ? new C0252i(drawable) : drawable;
    }

    public static void m867a(Drawable drawable, int i) {
        if (drawable instanceof C0011m) {
            ((C0011m) drawable).setTint(i);
        }
    }

    public static void m868a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0011m) {
            ((C0011m) drawable).setTintList(colorStateList);
        }
    }

    public static void m869a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void m870a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0011m) {
            ((C0011m) drawable).setTintMode(mode);
        }
    }
}
