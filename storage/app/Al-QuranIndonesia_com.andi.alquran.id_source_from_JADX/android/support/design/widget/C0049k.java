package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0063d;
import android.support.v4.view.C0500f;
import android.support.v4.view.aj;
import android.support.v4.view.bf;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

/* renamed from: android.support.design.widget.k */
abstract class C0049k extends C0047x<View> {
    final Rect f165a;
    final Rect f166b;
    private int f167c;
    private int f168d;

    public C0049k() {
        this.f165a = new Rect();
        this.f166b = new Rect();
        this.f167c = 0;
    }

    public C0049k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f165a = new Rect();
        this.f166b = new Rect();
        this.f167c = 0;
    }

    private static int m178c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float m179a(View view) {
        return 1.0f;
    }

    final int m180a() {
        return this.f167c;
    }

    public boolean m181a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = m183b(coordinatorLayout.m323c(view));
            if (b != null) {
                if (aj.m1899v(b) && !aj.m1899v(view)) {
                    aj.m1866a(view, true);
                    if (aj.m1899v(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m314a(view, i, i2, MeasureSpec.makeMeasureSpec(m182b(b) + (size - b.getMeasuredHeight()), i5 == -1 ? 1073741824 : RtlSpacingHelper.UNDEFINED), i4);
                return true;
            }
        }
        return false;
    }

    int m182b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View m183b(List<View> list);

    public final void m184b(int i) {
        this.f168d = i;
    }

    protected void m185b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = m183b(coordinatorLayout.m323c(view));
        if (b != null) {
            C0063d c0063d = (C0063d) view.getLayoutParams();
            Rect rect = this.f165a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0063d.leftMargin, b.getBottom() + c0063d.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0063d.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0063d.bottomMargin);
            bf lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !aj.m1899v(coordinatorLayout) || aj.m1899v(view))) {
                rect.left += lastWindowInsets.m2112a();
                rect.right -= lastWindowInsets.m2115c();
            }
            Rect rect2 = this.f166b;
            C0500f.m2144a(C0049k.m178c(c0063d.f216c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m186c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f167c = rect2.top - b.getBottom();
            return;
        }
        super.m125b(coordinatorLayout, view, i);
        this.f167c = 0;
    }

    final int m186c(View view) {
        return this.f168d == 0 ? 0 : C0127l.m573a((int) (m179a(view) * ((float) this.f168d)), 0, this.f168d);
    }

    public final int m187d() {
        return this.f168d;
    }
}
