package android.support.v4.p009b.p010a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.a.d */
public final class C0212d {
    public static Drawable m749a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? C0213e.m750a(resources, i, theme) : resources.getDrawable(i);
    }
}
