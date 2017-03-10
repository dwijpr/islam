package android.support.p003a.p004a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0011m;
import android.support.v4.p005c.p006a.C0242a;
import android.util.AttributeSet;

/* renamed from: android.support.a.a.e */
abstract class C0012e extends Drawable implements C0011m {
    Drawable f40b;

    C0012e() {
    }

    protected static TypedArray m20a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void applyTheme(Theme theme) {
        if (this.f40b != null) {
            C0242a.m852a(this.f40b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f40b != null) {
            this.f40b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f40b != null ? C0242a.m860e(this.f40b) : null;
    }

    public Drawable getCurrent() {
        return this.f40b != null ? this.f40b.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        return this.f40b != null ? this.f40b.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f40b != null ? this.f40b.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f40b != null ? this.f40b.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f40b != null ? this.f40b.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f40b != null ? this.f40b.getTransparentRegion() : super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        if (this.f40b != null) {
            C0242a.m847a(this.f40b);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f40b != null) {
            this.f40b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f40b != null ? this.f40b.setLevel(i) : super.onLevelChange(i);
    }

    public void setChangingConfigurations(int i) {
        if (this.f40b != null) {
            this.f40b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f40b != null) {
            this.f40b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f40b != null) {
            this.f40b.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f40b != null) {
            C0242a.m848a(this.f40b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f40b != null) {
            C0242a.m850a(this.f40b, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f40b != null ? this.f40b.setState(iArr) : super.setState(iArr);
    }
}
