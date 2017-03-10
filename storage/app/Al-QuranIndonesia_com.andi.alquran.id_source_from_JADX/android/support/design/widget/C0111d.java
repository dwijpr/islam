package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.C0259a;

/* renamed from: android.support.design.widget.d */
class C0111d extends Drawable {
    final Paint f395a;
    final Rect f396b;
    final RectF f397c;
    float f398d;
    private int f399e;
    private int f400f;
    private int f401g;
    private int f402h;
    private ColorStateList f403i;
    private int f404j;
    private boolean f405k;
    private float f406l;

    private Shader m502a() {
        Rect rect = this.f396b;
        copyBounds(rect);
        float height = this.f398d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0259a.m903a(this.f399e, this.f404j), C0259a.m903a(this.f400f, this.f404j), C0259a.m903a(C0259a.m905b(this.f400f, 0), this.f404j), C0259a.m903a(C0259a.m905b(this.f402h, 0), this.f404j), C0259a.m903a(this.f402h, this.f404j), C0259a.m903a(this.f401g, this.f404j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    final void m503a(float f) {
        if (f != this.f406l) {
            this.f406l = f;
            invalidateSelf();
        }
    }

    void m504a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f404j = colorStateList.getColorForState(getState(), this.f404j);
        }
        this.f403i = colorStateList;
        this.f405k = true;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.f405k) {
            this.f395a.setShader(m502a());
            this.f405k = false;
        }
        float strokeWidth = this.f395a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f397c;
        copyBounds(this.f396b);
        rectF.set(this.f396b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f406l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f395a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f398d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f398d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f403i != null && this.f403i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f405k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f403i != null) {
            int colorForState = this.f403i.getColorForState(iArr, this.f404j);
            if (colorForState != this.f404j) {
                this.f405k = true;
                this.f404j = colorForState;
            }
        }
        if (this.f405k) {
            invalidateSelf();
        }
        return this.f405k;
    }

    public void setAlpha(int i) {
        this.f395a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f395a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
