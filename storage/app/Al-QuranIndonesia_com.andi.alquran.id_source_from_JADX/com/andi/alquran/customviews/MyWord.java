package com.andi.alquran.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.andi.alquran.C0861R;

public class MyWord extends ViewGroup {
    private int f1738a;
    private int f1739b;
    private int f1740c;
    private boolean f1741d;

    /* renamed from: com.andi.alquran.customviews.MyWord.a */
    public static class C0892a extends LayoutParams {
        private static int f1732a;
        private int f1733b;
        private int f1734c;
        private int f1735d;
        private int f1736e;
        private boolean f1737f;

        static {
            f1732a = -1;
        }

        public C0892a(int i, int i2) {
            super(i, i2);
            this.f1735d = f1732a;
            this.f1736e = f1732a;
            this.f1737f = false;
        }

        public C0892a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1735d = f1732a;
            this.f1736e = f1732a;
            this.f1737f = false;
            m3091a(context, attributeSet);
        }

        public C0892a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1735d = f1732a;
            this.f1736e = f1732a;
            this.f1737f = false;
        }

        private void m3091a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0861R.styleable.MyWord_Layout);
            try {
                this.f1735d = obtainStyledAttributes.getDimensionPixelSize(1, f1732a);
                this.f1736e = obtainStyledAttributes.getDimensionPixelSize(2, f1732a);
                this.f1737f = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public void m3096a(int i, int i2) {
            this.f1733b = i;
            this.f1734c = i2;
        }

        public boolean m3097a() {
            return this.f1735d != f1732a;
        }

        public boolean m3098b() {
            return this.f1736e != f1732a;
        }
    }

    public MyWord(Context context) {
        super(context);
        this.f1738a = 0;
        this.f1739b = 0;
        this.f1740c = 0;
        this.f1741d = true;
        m3101a(context, null);
    }

    public MyWord(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1738a = 0;
        this.f1739b = 0;
        this.f1740c = 0;
        this.f1741d = true;
        m3101a(context, attributeSet);
    }

    public MyWord(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1738a = 0;
        this.f1739b = 0;
        this.f1740c = 0;
        this.f1741d = true;
        m3101a(context, attributeSet);
    }

    private int m3099a(C0892a c0892a) {
        return c0892a.m3098b() ? c0892a.f1736e : this.f1739b;
    }

    private void m3100a(int i, int i2, int i3) {
        while (i < i2) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0892a c0892a = (C0892a) childAt.getLayoutParams();
                c0892a.f1734c = (i3 - childAt.getMeasuredHeight()) + c0892a.f1734c;
            }
            i++;
        }
    }

    private void m3101a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0861R.styleable.MyWord);
        try {
            this.f1738a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f1739b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f1740c = obtainStyledAttributes.getInteger(2, 0);
            this.f1741d = obtainStyledAttributes.getBoolean(3, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private int m3102b(C0892a c0892a) {
        return c0892a.m3097a() ? c0892a.f1735d : this.f1738a;
    }

    protected C0892a m3103a() {
        return new C0892a(-2, -2);
    }

    public C0892a m3104a(AttributeSet attributeSet) {
        return new C0892a(getContext(), attributeSet);
    }

    protected C0892a m3105a(LayoutParams layoutParams) {
        return new C0892a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0892a;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3103a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3104a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3105a(layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0892a c0892a = (C0892a) childAt.getLayoutParams();
            childAt.layout(c0892a.f1733b, c0892a.f1734c, c0892a.f1733b + childAt.getMeasuredWidth(), c0892a.f1734c + childAt.getMeasuredHeight());
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = (MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (this.f1740c == 0) {
            i3 = mode;
            i4 = size;
        } else {
            i3 = mode2;
            i4 = size2;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (i12 < childCount) {
            int i13;
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                i13 = i9;
            } else {
                int i14;
                childAt.measure(MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? RtlSpacingHelper.UNDEFINED : mode), MeasureSpec.makeMeasureSpec(size2, mode2 == 1073741824 ? RtlSpacingHelper.UNDEFINED : mode2));
                C0892a c0892a = (C0892a) childAt.getLayoutParams();
                int b = m3102b(c0892a);
                i13 = m3099a(c0892a);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.f1740c == 0) {
                    i14 = measuredWidth;
                    measuredWidth = measuredHeight;
                } else {
                    i14 = measuredHeight;
                    int i15 = i13;
                    i13 = b;
                    b = i15;
                }
                i7 += i14;
                int i16 = i7 + b;
                Object obj = (c0892a.f1737f || (i3 != 0 && i7 > i4)) ? 1 : null;
                if (obj != null) {
                    if (this.f1740c == 0) {
                        m3100a(i11, i12, i6);
                        i11 = i12;
                    }
                    i16 = measuredWidth;
                    i6 = measuredWidth + i13;
                    i7 = b + i14;
                    b = i8 + i5;
                    i8 = i14;
                } else {
                    b = i8;
                    i8 = i7;
                    i7 = i16;
                    i16 = i6;
                    i6 = i5;
                }
                i5 = Math.max(i6, i13 + measuredWidth);
                i6 = Math.max(i16, measuredWidth);
                if (this.f1740c == 0) {
                    measuredWidth = this.f1741d ? (i4 - getPaddingRight()) - i8 : (getPaddingLeft() + i8) - i14;
                    i13 = getPaddingTop() + b;
                } else {
                    measuredWidth = getPaddingLeft() + b;
                    i13 = (getPaddingTop() + i8) - measuredHeight;
                }
                c0892a.m3096a(measuredWidth, i13);
                i13 = Math.max(i9, i8);
                i10 = b + i6;
                i8 = b;
            }
            i12++;
            i9 = i13;
        }
        if (this.f1740c == 0) {
            m3100a(i11, childCount, i6);
            setMeasuredDimension(resolveSize(i9, i), resolveSize(i10, i2));
            return;
        }
        setMeasuredDimension(resolveSize(i10, i), resolveSize(i9, i2));
    }
}
