package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: android.support.v4.widget.u */
public final class C0588u {
    OverScroller f1104a;
    private final boolean f1105b;

    C0588u(boolean z, Context context, Interpolator interpolator) {
        this.f1105b = z;
        this.f1104a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static C0588u m2512a(Context context) {
        return C0588u.m2513a(context, null);
    }

    public static C0588u m2513a(Context context, Interpolator interpolator) {
        return new C0588u(VERSION.SDK_INT >= 14, context, interpolator);
    }

    public void m2514a(int i, int i2, int i3, int i4) {
        this.f1104a.startScroll(i, i2, i3, i4);
    }

    public void m2515a(int i, int i2, int i3, int i4, int i5) {
        this.f1104a.startScroll(i, i2, i3, i4, i5);
    }

    public void m2516a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1104a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2517a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1104a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2518a() {
        return this.f1104a.isFinished();
    }

    public boolean m2519a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1104a.springBack(i, i2, i3, i4, i5, i6);
    }

    public int m2520b() {
        return this.f1104a.getCurrX();
    }

    public int m2521c() {
        return this.f1104a.getCurrY();
    }

    public int m2522d() {
        return this.f1104a.getFinalX();
    }

    public int m2523e() {
        return this.f1104a.getFinalY();
    }

    public float m2524f() {
        return this.f1105b ? C0589v.m2527a(this.f1104a) : 0.0f;
    }

    public boolean m2525g() {
        return this.f1104a.computeScrollOffset();
    }

    public void m2526h() {
        this.f1104a.abortAnimation();
    }
}
