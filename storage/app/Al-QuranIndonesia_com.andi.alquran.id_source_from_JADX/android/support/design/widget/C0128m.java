package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v7.graphics.drawable.DrawableWrapper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.design.widget.m */
class C0128m extends DrawableWrapper {
    static final double f455a;
    final Paint f456b;
    final Paint f457c;
    final RectF f458d;
    float f459e;
    Path f460f;
    float f461g;
    float f462h;
    float f463i;
    float f464j;
    private boolean f465k;
    private final int f466l;
    private final int f467m;
    private final int f468n;
    private boolean f469o;
    private float f470p;
    private boolean f471q;

    static {
        f455a = Math.cos(Math.toRadians(45.0d));
    }

    public static float m574a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f455a) * ((double) f2))) : 1.5f * f;
    }

    private void m575a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f470p, this.f458d.centerX(), this.f458d.centerY());
        float f = (-this.f459e) - this.f463i;
        float f2 = this.f459e;
        Object obj = this.f458d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f458d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f464j - (this.f464j * 0.5f)) + f2);
        float f4 = f2 / ((this.f464j - (this.f464j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f464j - (this.f464j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f458d.left + f2, this.f458d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f460f, this.f456b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f458d.width() - (2.0f * f2), -this.f459e, this.f457c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f458d.right - f2, this.f458d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(BitmapDescriptorFactory.HUE_CYAN);
        canvas.drawPath(this.f460f, this.f456b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f458d.width() - (2.0f * f2), this.f463i + (-this.f459e), this.f457c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f458d.left + f2, this.f458d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
        canvas.drawPath(this.f460f, this.f456b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f458d.height() - (2.0f * f2), -this.f459e, this.f457c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f458d.right - f2, this.f458d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f460f, this.f456b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f458d.height() - (2.0f * f2), -this.f459e, this.f457c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m576a(Rect rect) {
        float f = this.f462h * 1.5f;
        this.f458d.set(((float) rect.left) + this.f462h, ((float) rect.top) + f, ((float) rect.right) - this.f462h, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.f458d.left, (int) this.f458d.top, (int) this.f458d.right, (int) this.f458d.bottom);
        m578b();
    }

    public static float m577b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f455a) * ((double) f2))) : f;
    }

    private void m578b() {
        RectF rectF = new RectF(-this.f459e, -this.f459e, this.f459e, this.f459e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f463i, -this.f463i);
        if (this.f460f == null) {
            this.f460f = new Path();
        } else {
            this.f460f.reset();
        }
        this.f460f.setFillType(FillType.EVEN_ODD);
        this.f460f.moveTo(-this.f459e, 0.0f);
        this.f460f.rLineTo(-this.f463i, 0.0f);
        this.f460f.arcTo(rectF2, BitmapDescriptorFactory.HUE_CYAN, 90.0f, false);
        this.f460f.arcTo(rectF, BitmapDescriptorFactory.HUE_VIOLET, -90.0f, false);
        this.f460f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f459e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f456b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f466l, this.f467m, this.f468n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f457c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f466l, this.f467m, this.f468n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f457c.setAntiAlias(false);
    }

    private static int m579c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public float m580a() {
        return this.f464j;
    }

    final void m581a(float f) {
        if (this.f470p != f) {
            this.f470p = f;
            invalidateSelf();
        }
    }

    void m582a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c = (float) C0128m.m579c(f);
        float c2 = (float) C0128m.m579c(f2);
        if (c > c2) {
            if (!this.f471q) {
                this.f471q = true;
            }
            c = c2;
        }
        if (this.f464j != c || this.f462h != c2) {
            this.f464j = c;
            this.f462h = c2;
            this.f463i = (float) Math.round(c * 1.5f);
            this.f461g = c2;
            this.f465k = true;
            invalidateSelf();
        }
    }

    public void m583b(float f) {
        m582a(f, this.f462h);
    }

    public void draw(Canvas canvas) {
        if (this.f465k) {
            m576a(getBounds());
            this.f465k = false;
        }
        m575a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C0128m.m574a(this.f462h, this.f459e, this.f469o));
        int ceil2 = (int) Math.ceil((double) C0128m.m577b(this.f462h, this.f459e, this.f469o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f465k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f456b.setAlpha(i);
        this.f457c.setAlpha(i);
    }
}
