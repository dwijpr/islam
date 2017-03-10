package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0035a.C0028c;
import android.support.design.C0035a.C0030e;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.C0073b.C0040c;
import android.support.v4.view.aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements C0040c {
    private TextView f136a;
    private Button f137b;
    private int f138c;
    private int f139d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.SnackbarLayout);
        this.f138c = obtainStyledAttributes.getDimensionPixelSize(C0034i.SnackbarLayout_android_maxWidth, -1);
        this.f139d = obtainStyledAttributes.getDimensionPixelSize(C0034i.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void m89a(View view, int i, int i2) {
        if (aj.m1902y(view)) {
            aj.m1856a(view, aj.m1887j(view), i, aj.m1888k(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean m90a(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.f136a.getPaddingTop() == i2 && this.f136a.getPaddingBottom() == i3) {
            return z;
        }
        m89a(this.f136a, i2, i3);
        return true;
    }

    public void m91a(int i, int i2) {
        aj.m1875c(this.f136a, 0.0f);
        aj.m1894q(this.f136a).m2061a(1.0f).m2062a((long) i2).m2067b((long) i).m2070c();
        if (this.f137b.getVisibility() == 0) {
            aj.m1875c(this.f137b, 0.0f);
            aj.m1894q(this.f137b).m2061a(1.0f).m2062a((long) i2).m2067b((long) i).m2070c();
        }
    }

    public void m92b(int i, int i2) {
        aj.m1875c(this.f136a, 1.0f);
        aj.m1894q(this.f136a).m2061a(0.0f).m2062a((long) i2).m2067b((long) i).m2070c();
        if (this.f137b.getVisibility() == 0) {
            aj.m1875c(this.f137b, 1.0f);
            aj.m1894q(this.f137b).m2061a(0.0f).m2062a((long) i2).m2067b((long) i).m2070c();
        }
    }

    public Button getActionView() {
        return this.f137b;
    }

    public TextView getMessageView() {
        return this.f136a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f136a = (TextView) findViewById(C0030e.snackbar_text);
        this.f137b = (Button) findViewById(C0030e.snackbar_action);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f138c > 0 && getMeasuredWidth() > this.f138c) {
            i = MeasureSpec.makeMeasureSpec(this.f138c, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0028c.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0028c.design_snackbar_padding_vertical);
        int i3 = this.f136a.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.f139d <= 0 || this.f137b.getMeasuredWidth() <= this.f139d) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m90a(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (m90a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }
}
