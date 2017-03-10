package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.C0078e;
import android.support.v4.view.ViewPager.C0088f;
import android.support.v4.view.ViewPager.C0369a;
import android.support.v4.widget.C0596w;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.lang.ref.WeakReference;

@C0369a
public class ab extends ViewGroup {
    private static final int[] f748n;
    private static final int[] f749o;
    private static final C0431b f750q;
    ViewPager f751a;
    TextView f752b;
    TextView f753c;
    TextView f754d;
    float f755e;
    int f756f;
    private int f757g;
    private int f758h;
    private int f759i;
    private boolean f760j;
    private boolean f761k;
    private final C0430a f762l;
    private WeakReference<aa> f763m;
    private int f764p;

    /* renamed from: android.support.v4.view.ab.a */
    private class C0430a extends DataSetObserver implements C0078e, C0088f {
        final /* synthetic */ ab f869a;
        private int f870b;

        C0430a(ab abVar) {
            this.f869a = abVar;
        }

        public void m1626a(int i) {
            this.f870b = i;
        }

        public void m1627a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.f869a.m1278a(i, f, false);
        }

        public void m1628a(ViewPager viewPager, aa aaVar, aa aaVar2) {
            this.f869a.m1280a(aaVar, aaVar2);
        }

        public void m1629b(int i) {
            float f = 0.0f;
            if (this.f870b == 0) {
                this.f869a.m1279a(this.f869a.f751a.getCurrentItem(), this.f869a.f751a.getAdapter());
                if (this.f869a.f755e >= 0.0f) {
                    f = this.f869a.f755e;
                }
                this.f869a.m1278a(this.f869a.f751a.getCurrentItem(), f, true);
            }
        }

        public void onChanged() {
            float f = 0.0f;
            this.f869a.m1279a(this.f869a.f751a.getCurrentItem(), this.f869a.f751a.getAdapter());
            if (this.f869a.f755e >= 0.0f) {
                f = this.f869a.f755e;
            }
            this.f869a.m1278a(this.f869a.f751a.getCurrentItem(), f, true);
        }
    }

    /* renamed from: android.support.v4.view.ab.b */
    interface C0431b {
        void m1630a(TextView textView);
    }

    /* renamed from: android.support.v4.view.ab.c */
    static class C0432c implements C0431b {
        C0432c() {
        }

        public void m1631a(TextView textView) {
            textView.setSingleLine();
        }
    }

    /* renamed from: android.support.v4.view.ab.d */
    static class C0433d implements C0431b {
        C0433d() {
        }

        public void m1632a(TextView textView) {
            ac.m1633a(textView);
        }
    }

    static {
        f748n = new int[]{16842804, 16842901, 16842904, 16842927};
        f749o = new int[]{16843660};
        if (VERSION.SDK_INT >= 14) {
            f750q = new C0433d();
        } else {
            f750q = new C0432c();
        }
    }

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.f757g = -1;
        this.f755e = GroundOverlayOptions.NO_DIMENSION;
        this.f762l = new C0430a(this);
        View textView = new TextView(context);
        this.f752b = textView;
        addView(textView);
        textView = new TextView(context);
        this.f753c = textView;
        addView(textView);
        textView = new TextView(context);
        this.f754d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f748n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            C0596w.m2539a(this.f752b, resourceId);
            C0596w.m2539a(this.f753c, resourceId);
            C0596w.m2539a(this.f754d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            m1277a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.f752b.setTextColor(dimensionPixelSize);
            this.f753c.setTextColor(dimensionPixelSize);
            this.f754d.setTextColor(dimensionPixelSize);
        }
        this.f759i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f756f = this.f753c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f752b.setEllipsize(TruncateAt.END);
        this.f753c.setEllipsize(TruncateAt.END);
        this.f754d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, f749o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f752b);
            setSingleLineAllCaps(this.f753c);
            setSingleLineAllCaps(this.f754d);
        } else {
            this.f752b.setSingleLine();
            this.f753c.setSingleLine();
            this.f754d.setSingleLine();
        }
        this.f758h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        f750q.m1630a(textView);
    }

    public void m1277a(int i, float f) {
        this.f752b.setTextSize(i, f);
        this.f753c.setTextSize(i, f);
        this.f754d.setTextSize(i, f);
    }

    void m1278a(int i, float f, boolean z) {
        if (i != this.f757g) {
            m1279a(i, this.f751a.getAdapter());
        } else if (!z && f == this.f755e) {
            return;
        }
        this.f761k = true;
        int measuredWidth = this.f752b.getMeasuredWidth();
        int measuredWidth2 = this.f753c.getMeasuredWidth();
        int measuredWidth3 = this.f754d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.f752b.getBaseline();
        measuredWidth2 = this.f753c.getBaseline();
        int baseline = this.f754d.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        max = this.f752b.getMeasuredHeight() + i2;
        int measuredHeight = this.f753c.getMeasuredHeight() + measuredWidth2;
        max = Math.max(Math.max(max, measuredHeight), this.f754d.getMeasuredHeight() + baseline);
        switch (this.f759i & C0861R.styleable.AppCompatTheme_spinnerStyle) {
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.f753c.layout(i4, measuredWidth2, i3, this.f753c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.f758h) - measuredWidth);
        this.f752b.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.f752b.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.f758h + i3);
        this.f754d.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.f754d.getMeasuredHeight() + i2);
        this.f755e = f;
        this.f761k = false;
    }

    void m1279a(int i, aa aaVar) {
        CharSequence charSequence = null;
        int count = aaVar != null ? aaVar.getCount() : 0;
        this.f760j = true;
        CharSequence pageTitle = (i < 1 || aaVar == null) ? null : aaVar.getPageTitle(i - 1);
        this.f752b.setText(pageTitle);
        TextView textView = this.f753c;
        pageTitle = (aaVar == null || i >= count) ? null : aaVar.getPageTitle(i);
        textView.setText(pageTitle);
        if (i + 1 < count && aaVar != null) {
            charSequence = aaVar.getPageTitle(i + 1);
        }
        this.f754d.setText(charSequence);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), RtlSpacingHelper.UNDEFINED);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), RtlSpacingHelper.UNDEFINED);
        this.f752b.measure(count, makeMeasureSpec);
        this.f753c.measure(count, makeMeasureSpec);
        this.f754d.measure(count, makeMeasureSpec);
        this.f757g = i;
        if (!this.f761k) {
            m1278a(i, this.f755e, false);
        }
        this.f760j = false;
    }

    void m1280a(aa aaVar, aa aaVar2) {
        if (aaVar != null) {
            aaVar.unregisterDataSetObserver(this.f762l);
            this.f763m = null;
        }
        if (aaVar2 != null) {
            aaVar2.registerDataSetObserver(this.f762l);
            this.f763m = new WeakReference(aaVar2);
        }
        if (this.f751a != null) {
            this.f757g = -1;
            this.f755e = GroundOverlayOptions.NO_DIMENSION;
            m1279a(this.f751a.getCurrentItem(), aaVar2);
            requestLayout();
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        return background != null ? background.getIntrinsicHeight() : 0;
    }

    public int getTextSpacing() {
        return this.f758h;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            aa adapter = viewPager.getAdapter();
            viewPager.m1328c(this.f762l);
            viewPager.m1319a(this.f762l);
            this.f751a = viewPager;
            m1280a(this.f763m != null ? (aa) this.f763m.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f751a != null) {
            m1280a(this.f751a.getAdapter(), null);
            this.f751a.m1328c(null);
            this.f751a.m1326b(this.f762l);
            this.f751a = null;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.f751a != null) {
            if (this.f755e >= 0.0f) {
                f = this.f755e;
            }
            m1278a(this.f757g, f, true);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.f752b.measure(childMeasureSpec2, childMeasureSpec);
        this.f753c.measure(childMeasureSpec2, childMeasureSpec);
        this.f754d.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.f753c.getMeasuredHeight());
        }
        setMeasuredDimension(size, aj.m1852a(paddingTop, i2, aj.m1886i(this.f753c) << 16));
    }

    public void requestLayout() {
        if (!this.f760j) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.f759i = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        this.f764p = ((int) (255.0f * f)) & 255;
        int i = (this.f764p << 24) | (this.f756f & 16777215);
        this.f752b.setTextColor(i);
        this.f754d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f756f = i;
        this.f753c.setTextColor(i);
        int i2 = (this.f764p << 24) | (this.f756f & 16777215);
        this.f752b.setTextColor(i2);
        this.f754d.setTextColor(i2);
    }

    public void setTextSpacing(int i) {
        this.f758h = i;
        requestLayout();
    }
}
