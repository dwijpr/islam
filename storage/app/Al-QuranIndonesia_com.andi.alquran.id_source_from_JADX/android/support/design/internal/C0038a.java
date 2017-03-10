package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0035a.C0034i;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.andi.alquran.C0861R;

/* renamed from: android.support.design.internal.a */
public class C0038a extends LinearLayoutCompat {
    protected boolean f119a;
    boolean f120b;
    private Drawable f121c;
    private final Rect f122d;
    private final Rect f123e;
    private int f124f;

    public C0038a(Context context) {
        this(context, null);
    }

    public C0038a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0038a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f122d = new Rect();
        this.f123e = new Rect();
        this.f124f = 119;
        this.f119a = true;
        this.f120b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.ForegroundLinearLayout, i, 0);
        this.f124f = obtainStyledAttributes.getInt(C0034i.ForegroundLinearLayout_android_foregroundGravity, this.f124f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0034i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f119a = obtainStyledAttributes.getBoolean(C0034i.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f121c != null) {
            Drawable drawable = this.f121c;
            if (this.f120b) {
                this.f120b = false;
                Rect rect = this.f122d;
                Rect rect2 = this.f123e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f119a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f124f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f121c != null) {
            this.f121c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f121c != null && this.f121c.isStateful()) {
            this.f121c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f121c;
    }

    public int getForegroundGravity() {
        return this.f124f;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f121c != null) {
            this.f121c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f120b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f120b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f121c != drawable) {
            if (this.f121c != null) {
                this.f121c.setCallback(null);
                unscheduleDrawable(this.f121c);
            }
            this.f121c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f124f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f124f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & C0861R.styleable.AppCompatTheme_spinnerStyle) == 0) {
                i2 |= 48;
            }
            this.f124f = i2;
            if (this.f124f == 119 && this.f121c != null) {
                this.f121c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f121c;
    }
}
