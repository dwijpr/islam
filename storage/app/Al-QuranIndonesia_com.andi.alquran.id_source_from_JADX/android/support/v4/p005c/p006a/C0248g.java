package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.v4.c.a.g */
class C0248g {
    public static Drawable m879a(Drawable drawable) {
        return !(drawable instanceof C0011m) ? new C0258l(drawable) : drawable;
    }

    public static void m880a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m881a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m882a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m883a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m884a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void m885a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void m886a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean m887b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m888c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}
