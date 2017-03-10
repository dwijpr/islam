package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0035a.C0028c;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.C0119h.C0067a;
import android.support.design.widget.CoordinatorLayout.C0046a;
import android.support.design.widget.CoordinatorLayout.C0061b;
import android.support.design.widget.CoordinatorLayout.C0063d;
import android.support.v4.p009b.p010a.C0209a;
import android.support.v4.view.aj;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

@C0061b(a = Behavior.class)
public class FloatingActionButton extends ab {
    int f264a;
    boolean f265b;
    final Rect f266c;
    private ColorStateList f267d;
    private Mode f268e;
    private int f269f;
    private int f270g;
    private int f271h;
    private final Rect f272i;
    private AppCompatImageHelper f273j;
    private C0119h f274k;

    /* renamed from: android.support.design.widget.FloatingActionButton.1 */
    class C00681 implements C0067a {
        final /* synthetic */ C0069a f257a;
        final /* synthetic */ FloatingActionButton f258b;

        C00681(FloatingActionButton floatingActionButton, C0069a c0069a) {
            this.f258b = floatingActionButton;
            this.f257a = c0069a;
        }

        public void m330a() {
            this.f257a.m344a(this.f258b);
        }

        public void m331b() {
            this.f257a.m345b(this.f258b);
        }
    }

    public static class Behavior extends C0046a<FloatingActionButton> {
        private Rect f259a;
        private C0069a f260b;
        private boolean f261c;

        public Behavior() {
            this.f261c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.FloatingActionButton_Behavior_Layout);
            this.f261c = obtainStyledAttributes.getBoolean(C0034i.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void m332a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect rect = floatingActionButton.f266c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                C0063d c0063d = (C0063d) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0063d.rightMargin ? rect.right : floatingActionButton.getLeft() <= c0063d.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c0063d.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= c0063d.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    aj.m1880d((View) floatingActionButton, i);
                }
                if (i2 != 0) {
                    aj.m1882e(floatingActionButton, i2);
                }
            }
        }

        private boolean m333a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m335a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f259a == null) {
                this.f259a = new Rect();
            }
            Rect rect = this.f259a;
            C0153v.m678b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m362b(this.f260b, false);
            } else {
                floatingActionButton.m360a(this.f260b, false);
            }
            return true;
        }

        private static boolean m334a(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams instanceof C0063d ? ((C0063d) layoutParams).m273b() instanceof BottomSheetBehavior : false;
        }

        private boolean m335a(View view, FloatingActionButton floatingActionButton) {
            return !this.f261c ? false : ((C0063d) floatingActionButton.getLayoutParams()).m267a() != view.getId() ? false : floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean m336b(View view, FloatingActionButton floatingActionButton) {
            if (!m335a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((C0063d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.m362b(this.f260b, false);
            } else {
                floatingActionButton.m360a(this.f260b, false);
            }
            return true;
        }

        public void m337a(C0063d c0063d) {
            if (c0063d.f221h == 0) {
                c0063d.f221h = 80;
            }
        }

        public boolean m338a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.m323c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m334a(view) && m336b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m333a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m313a((View) floatingActionButton, i);
            m332a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m339a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f266c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean m340a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m333a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (m334a(view)) {
                m336b(view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean m343c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m340a(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton.a */
    public static abstract class C0069a {
        public void m344a(FloatingActionButton floatingActionButton) {
        }

        public void m345b(FloatingActionButton floatingActionButton) {
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton.b */
    private class C0071b implements C0070n {
        final /* synthetic */ FloatingActionButton f262a;

        C0071b(FloatingActionButton floatingActionButton) {
            this.f262a = floatingActionButton;
        }

        public float m350a() {
            return ((float) this.f262a.getSizeDimension()) / 2.0f;
        }

        public void m351a(int i, int i2, int i3, int i4) {
            this.f262a.f266c.set(i, i2, i3, i4);
            this.f262a.setPadding(this.f262a.f264a + i, this.f262a.f264a + i2, this.f262a.f264a + i3, this.f262a.f264a + i4);
        }

        public void m352a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean m353b() {
            return this.f262a.f265b;
        }
    }

    private int m355a(int i) {
        Resources resources = getResources();
        switch (i) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                return Math.max(C0209a.m741b(resources), C0209a.m740a(resources)) < 470 ? m355a(1) : m355a(0);
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return resources.getDimensionPixelSize(C0028c.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(C0028c.design_fab_size_normal);
        }
    }

    private static int m356a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private C0067a m357a(C0069a c0069a) {
        return c0069a == null ? null : new C00681(this, c0069a);
    }

    private C0119h m358a() {
        int i = VERSION.SDK_INT;
        return i >= 21 ? new C0125i(this, new C0071b(this), C0157z.f521a) : i >= 14 ? new C0123g(this, new C0071b(this), C0157z.f521a) : new C0120f(this, new C0071b(this), C0157z.f521a);
    }

    private C0119h getImpl() {
        if (this.f274k == null) {
            this.f274k = m358a();
        }
        return this.f274k;
    }

    void m360a(C0069a c0069a, boolean z) {
        getImpl().m534b(m357a(c0069a), z);
    }

    public boolean m361a(Rect rect) {
        if (!aj.m1846C(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f266c.left;
        rect.top += this.f266c.top;
        rect.right -= this.f266c.right;
        rect.bottom -= this.f266c.bottom;
        return true;
    }

    void m362b(C0069a c0069a, boolean z) {
        getImpl().m530a(m357a(c0069a), z);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().m531a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f267d;
    }

    public Mode getBackgroundTintMode() {
        return this.f268e;
    }

    public float getCompatElevation() {
        return getImpl().m523a();
    }

    public Drawable getContentBackground() {
        return getImpl().m538f();
    }

    public int getRippleColor() {
        return this.f269f;
    }

    public int getSize() {
        return this.f270g;
    }

    int getSizeDimension() {
        return m355a(this.f270g);
    }

    public boolean getUseCompatPadding() {
        return this.f265b;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().m532b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m540h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m541i();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f264a = (sizeDimension - this.f271h) / 2;
        getImpl().m539g();
        sizeDimension = Math.min(m356a(sizeDimension, i), m356a(sizeDimension, i2));
        setMeasuredDimension((this.f266c.left + sizeDimension) + this.f266c.right, (sizeDimension + this.f266c.top) + this.f266c.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                if (m361a(this.f272i) && !this.f272i.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f267d != colorStateList) {
            this.f267d = colorStateList;
            getImpl().m527a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f268e != mode) {
            this.f268e = mode;
            getImpl().m528a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m524a(f);
    }

    public void setImageResource(int i) {
        this.f273j.setImageResource(i);
    }

    public void setRippleColor(int i) {
        if (this.f269f != i) {
            this.f269f = i;
            getImpl().m526a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.f270g) {
            this.f270g = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f265b != z) {
            this.f265b = z;
            getImpl().m535c();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
