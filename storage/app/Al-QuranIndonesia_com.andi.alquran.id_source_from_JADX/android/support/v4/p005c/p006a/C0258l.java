package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0252i.C0250a;

@TargetApi(21)
/* renamed from: android.support.v4.c.a.l */
class C0258l extends C0256k {

    /* renamed from: android.support.v4.c.a.l.a */
    private static class C0257a extends C0250a {
        C0257a(C0250a c0250a, Resources resources) {
            super(c0250a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0258l(this, resources);
        }
    }

    C0258l(Drawable drawable) {
        super(drawable);
    }

    C0258l(C0250a c0250a, Resources resources) {
        super(c0250a, resources);
    }

    C0250a m901b() {
        return new C0257a(this.b, null);
    }

    protected boolean m902c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (m902c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (m902c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (m902c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }
}
