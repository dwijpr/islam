package android.support.v4.view.p016b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.b.d */
abstract class C0476d implements Interpolator {
    private final float[] f904a;
    private final float f905b;

    public C0476d(float[] fArr) {
        this.f904a = fArr;
        this.f905b = 1.0f / ((float) (this.f904a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f904a.length - 1)) * f), this.f904a.length - 2);
        float f2 = (f - (((float) min) * this.f905b)) / this.f905b;
        return ((this.f904a[min + 1] - this.f904a[min]) * f2) + this.f904a[min];
    }
}
