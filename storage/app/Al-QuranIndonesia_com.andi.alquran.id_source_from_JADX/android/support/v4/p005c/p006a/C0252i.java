package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

@TargetApi(9)
/* renamed from: android.support.v4.c.a.i */
class C0252i extends Drawable implements Callback, C0249h, C0011m {
    static final Mode f571a;
    C0250a f572b;
    Drawable f573c;
    private int f574d;
    private Mode f575e;
    private boolean f576f;
    private boolean f577g;

    /* renamed from: android.support.v4.c.a.i.a */
    protected static abstract class C0250a extends ConstantState {
        int f567a;
        ConstantState f568b;
        ColorStateList f569c;
        Mode f570d;

        C0250a(C0250a c0250a, Resources resources) {
            this.f569c = null;
            this.f570d = C0252i.f571a;
            if (c0250a != null) {
                this.f567a = c0250a.f567a;
                this.f568b = c0250a.f568b;
                this.f569c = c0250a.f569c;
                this.f570d = c0250a.f570d;
            }
        }

        boolean m891a() {
            return this.f568b != null;
        }

        public int getChangingConfigurations() {
            return (this.f568b != null ? this.f568b.getChangingConfigurations() : 0) | this.f567a;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    /* renamed from: android.support.v4.c.a.i.b */
    private static class C0251b extends C0250a {
        C0251b(C0250a c0250a, Resources resources) {
            super(c0250a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0252i(this, resources);
        }
    }

    static {
        f571a = Mode.SRC_IN;
    }

    C0252i(Drawable drawable) {
        this.f572b = m897b();
        m896a(drawable);
    }

    C0252i(C0250a c0250a, Resources resources) {
        this.f572b = c0250a;
        m892a(resources);
    }

    private void m892a(Resources resources) {
        if (this.f572b != null && this.f572b.f568b != null) {
            m896a(m895a(this.f572b.f568b, resources));
        }
    }

    private boolean m893a(int[] iArr) {
        if (!m898c()) {
            return false;
        }
        ColorStateList colorStateList = this.f572b.f569c;
        Mode mode = this.f572b.f570d;
        if (colorStateList == null || mode == null) {
            this.f576f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f576f && colorForState == this.f574d && mode == this.f575e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f574d = colorForState;
        this.f575e = mode;
        this.f576f = true;
        return true;
    }

    public final Drawable m894a() {
        return this.f573c;
    }

    protected Drawable m895a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    public final void m896a(Drawable drawable) {
        if (this.f573c != null) {
            this.f573c.setCallback(null);
        }
        this.f573c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f572b != null) {
                this.f572b.f568b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    C0250a m897b() {
        return new C0251b(this.f572b, null);
    }

    protected boolean m898c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f573c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.f572b != null ? this.f572b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f573c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.f572b == null || !this.f572b.m891a()) {
            return null;
        }
        this.f572b.f567a = getChangingConfigurations();
        return this.f572b;
    }

    public Drawable getCurrent() {
        return this.f573c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f573c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f573c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f573c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f573c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f573c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f573c.getPadding(rect);
    }

    public int[] getState() {
        return this.f573c.getState();
    }

    public Region getTransparentRegion() {
        return this.f573c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!m898c() || this.f572b == null) ? null : this.f572b.f569c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f573c.isStateful();
    }

    public Drawable mutate() {
        if (!this.f577g && super.mutate() == this) {
            this.f572b = m897b();
            if (this.f573c != null) {
                this.f573c.mutate();
            }
            if (this.f572b != null) {
                this.f572b.f568b = this.f573c != null ? this.f573c.getConstantState() : null;
            }
            this.f577g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f573c != null) {
            this.f573c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f573c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f573c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f573c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f573c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f573c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f573c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m893a(iArr) || this.f573c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f572b.f569c = colorStateList;
        m893a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f572b.f570d = mode;
        m893a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f573c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
