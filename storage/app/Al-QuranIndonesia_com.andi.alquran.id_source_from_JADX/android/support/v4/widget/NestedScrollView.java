package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.C0036a;
import android.support.v4.view.C0039v;
import android.support.v4.view.C0066x;
import android.support.v4.view.C0534t;
import android.support.v4.view.C0536w;
import android.support.v4.view.C0537y;
import android.support.v4.view.af;
import android.support.v4.view.ah;
import android.support.v4.view.aj;
import android.support.v4.view.p015a.C0389a;
import android.support.v4.view.p015a.C0404c;
import android.support.v4.view.p015a.C0427k;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class NestedScrollView extends FrameLayout implements af, C0039v, C0066x {
    private static final C0546a f1009v;
    private static final int[] f1010w;
    private C0547b f1011A;
    private long f1012a;
    private final Rect f1013b;
    private C0588u f1014c;
    private C0571i f1015d;
    private C0571i f1016e;
    private int f1017f;
    private boolean f1018g;
    private boolean f1019h;
    private View f1020i;
    private boolean f1021j;
    private VelocityTracker f1022k;
    private boolean f1023l;
    private boolean f1024m;
    private int f1025n;
    private int f1026o;
    private int f1027p;
    private int f1028q;
    private final int[] f1029r;
    private final int[] f1030s;
    private int f1031t;
    private SavedState f1032u;
    private final C0537y f1033x;
    private final C0536w f1034y;
    private float f1035z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public int f1008a;

        /* renamed from: android.support.v4.widget.NestedScrollView.SavedState.1 */
        static class C05451 implements Creator<SavedState> {
            C05451() {
            }

            public SavedState m2308a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2309a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2308a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2309a(i);
            }
        }

        static {
            CREATOR = new C05451();
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1008a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1008a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1008a);
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView.a */
    static class C0546a extends C0036a {
        C0546a() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0427k a = C0389a.m1405a(accessibilityEvent);
            a.m1611a(nestedScrollView.getScrollRange() > 0);
            a.m1614d(nestedScrollView.getScrollX());
            a.m1615e(nestedScrollView.getScrollY());
            a.m1616f(nestedScrollView.getScrollX());
            a.m1617g(nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0404c.m1506a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    c0404c.m1513c(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0404c.m1503a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c0404c.m1503a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
                    }
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2334b(0, min);
                    return true;
                case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2334b(0, min);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView.b */
    public interface C0547b {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static {
        f1009v = new C0546a();
        f1010w = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1013b = new Rect();
        this.f1018g = true;
        this.f1019h = false;
        this.f1020i = null;
        this.f1021j = false;
        this.f1024m = true;
        this.f1028q = -1;
        this.f1029r = new int[2];
        this.f1030s = new int[2];
        m2311a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1010w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1033x = new C0537y(this);
        this.f1034y = new C0536w(this);
        setNestedScrollingEnabled(true);
        aj.m1861a((View) this, f1009v);
    }

    private View m2310a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2311a() {
        this.f1014c = C0588u.m2513a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1025n = viewConfiguration.getScaledTouchSlop();
        this.f1026o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1027p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2312a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f1028q) {
            action = action == 0 ? 1 : 0;
            this.f1017f = (int) motionEvent.getY(action);
            this.f1028q = motionEvent.getPointerId(action);
            if (this.f1022k != null) {
                this.f1022k.clear();
            }
        }
    }

    private boolean m2313a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2310a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2325e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2314a(Rect rect, boolean z) {
        int a = m2329a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2330a(0, a);
            }
        }
        return z2;
    }

    private boolean m2315a(View view) {
        return !m2316a(view, 0, getHeight());
    }

    private boolean m2316a(View view, int i, int i2) {
        view.getDrawingRect(this.f1013b);
        offsetDescendantRectToMyCoords(view, this.f1013b);
        return this.f1013b.bottom + i >= getScrollY() && this.f1013b.top - i <= getScrollY() + i2;
    }

    private static boolean m2317a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2317a((View) parent, view2);
        return z;
    }

    private static int m2318b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m2319b(View view) {
        view.getDrawingRect(this.f1013b);
        offsetDescendantRectToMyCoords(view, this.f1013b);
        int a = m2329a(this.f1013b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2320b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m2321c() {
        if (this.f1022k == null) {
            this.f1022k = VelocityTracker.obtain();
        } else {
            this.f1022k.clear();
        }
    }

    private boolean m2322c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m2323d() {
        if (this.f1022k == null) {
            this.f1022k = VelocityTracker.obtain();
        }
    }

    private void m2324e() {
        if (this.f1022k != null) {
            this.f1022k.recycle();
            this.f1022k = null;
        }
    }

    private void m2325e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1024m) {
            m2330a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m2326f() {
        this.f1021j = false;
        m2324e();
        stopNestedScroll();
        if (this.f1015d != null) {
            this.f1015d.m2472c();
            this.f1016e.m2472c();
        }
    }

    private void m2327f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2337d(i);
            }
        }
    }

    private void m2328g() {
        if (getOverScrollMode() == 2) {
            this.f1015d = null;
            this.f1016e = null;
        } else if (this.f1015d == null) {
            Context context = getContext();
            this.f1015d = new C0571i(context);
            this.f1016e = new C0571i(context);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1035z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1035z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1035z;
    }

    protected int m2329a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public final void m2330a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1012a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1014c.m2514a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                aj.m1874c(this);
            } else {
                if (!this.f1014c.m2518a()) {
                    this.f1014c.m2526h();
                }
                scrollBy(i, i2);
            }
            this.f1012a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m2331a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1013b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1013b.top + height > childAt.getBottom()) {
                    this.f1013b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1013b.top = getScrollY() - height;
            if (this.f1013b.top < 0) {
                this.f1013b.top = 0;
            }
        }
        this.f1013b.bottom = this.f1013b.top + height;
        return m2313a(i, this.f1013b.top, this.f1013b.bottom);
    }

    boolean m2332a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (overScrollMode == 0 || (overScrollMode == 1 && obj != null)) ? 1 : null;
        obj = (overScrollMode == 0 || (overScrollMode == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        overScrollMode = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < overScrollMode) {
            z3 = true;
            i13 = overScrollMode;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1014c.m2519a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m2333a(KeyEvent keyEvent) {
        int i = 33;
        this.f1013b.setEmpty();
        if (m2320b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                    return !keyEvent.isAltPressed() ? m2336c(33) : m2335b(33);
                case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                    return !keyEvent.isAltPressed() ? m2336c(130) : m2335b(130);
                case C0861R.styleable.AppCompatTheme_popupWindowStyle /*62*/:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2331a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m2334b(int i, int i2) {
        m2330a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m2335b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1013b.top = 0;
        this.f1013b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1013b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1013b.top = this.f1013b.bottom - height;
            }
        }
        return m2313a(i, this.f1013b.top, this.f1013b.bottom);
    }

    public boolean m2336c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2316a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2325e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1013b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1013b);
            m2325e(m2329a(this.f1013b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2315a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f1014c.m2525g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1014c.m2520b();
            int c = this.f1014c.m2521c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int overScrollMode = getOverScrollMode();
                int i = (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) ? 1 : 0;
                m2332a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2328g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1015d.m2469a((int) this.f1014c.m2524f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1016e.m2469a((int) this.f1014c.m2524f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public void m2337d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1014c.m2517a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            aj.m1874c(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2333a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1034y.m2232a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1034y.m2231a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1034y.m2235a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1034y.m2234a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1015d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1015d.m2466a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1015d.m2465a(width, getHeight());
                if (this.f1015d.m2470a(canvas)) {
                    aj.m1874c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1016e.m2466a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(BitmapDescriptorFactory.HUE_CYAN, (float) width, 0.0f);
                this.f1016e.m2465a(width, height);
                if (this.f1016e.m2470a(canvas)) {
                    aj.m1874c(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f1033x.m2238a();
    }

    int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1034y.m2236b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1034y.m2230a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1019h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                if (this.f1021j) {
                    return false;
                }
                float a = C0534t.m2225a(motionEvent, 9);
                if (a == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (a * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1021j) {
            return true;
        }
        switch (action & 255) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                action = (int) motionEvent.getY();
                if (!m2322c((int) motionEvent.getX(), action)) {
                    this.f1021j = false;
                    m2324e();
                    break;
                }
                this.f1017f = action;
                this.f1028q = motionEvent.getPointerId(0);
                m2321c();
                this.f1022k.addMovement(motionEvent);
                this.f1014c.m2525g();
                if (!this.f1014c.m2518a()) {
                    z = true;
                }
                this.f1021j = z;
                startNestedScroll(2);
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.f1021j = false;
                this.f1028q = -1;
                m2324e();
                if (this.f1014c.m2519a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    aj.m1874c(this);
                }
                stopNestedScroll();
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                action = this.f1028q;
                if (action != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(action);
                    if (findPointerIndex != -1) {
                        action = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(action - this.f1017f) > this.f1025n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1021j = true;
                            this.f1017f = action;
                            m2323d();
                            this.f1022k.addMovement(motionEvent);
                            this.f1031t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                m2312a(motionEvent);
                break;
        }
        return this.f1021j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1018g = false;
        if (this.f1020i != null && m2317a(this.f1020i, (View) this)) {
            m2319b(this.f1020i);
        }
        this.f1020i = null;
        if (!this.f1019h) {
            if (this.f1032u != null) {
                scrollTo(getScrollX(), this.f1032u.f1008a);
                this.f1032u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1019h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1023l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2327f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1033x.m2240a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m2315a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f1032u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1008a = getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1011A != null) {
            this.f1011A.onScrollChange(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2316a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1013b);
            offsetDescendantRectToMyCoords(findFocus, this.f1013b);
            m2325e(m2329a(this.f1013b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f1033x.m2239a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2323d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0534t.m2226a(motionEvent);
        if (a == 0) {
            this.f1031t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1031t);
        switch (a) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.f1014c.m2518a();
                    this.f1021j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1014c.m2518a()) {
                        this.f1014c.m2526h();
                    }
                    this.f1017f = (int) motionEvent.getY();
                    this.f1028q = motionEvent.getPointerId(0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (this.f1021j) {
                    VelocityTracker velocityTracker = this.f1022k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1027p);
                    a = (int) ah.m1647b(velocityTracker, this.f1028q);
                    if (Math.abs(a) > this.f1026o) {
                        m2327f(-a);
                    } else if (this.f1014c.m2519a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        aj.m1874c(this);
                    }
                }
                this.f1028q = -1;
                m2326f();
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1028q);
                if (findPointerIndex != -1) {
                    int i;
                    int y = (int) motionEvent.getY(findPointerIndex);
                    a = this.f1017f - y;
                    if (dispatchNestedPreScroll(0, a, this.f1030s, this.f1029r)) {
                        a -= this.f1030s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1029r[1]);
                        this.f1031t += this.f1029r[1];
                    }
                    if (this.f1021j || Math.abs(a) <= this.f1025n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1021j = true;
                        i = a > 0 ? a - this.f1025n : a + this.f1025n;
                    }
                    if (this.f1021j) {
                        this.f1017f = y - this.f1029r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = getOverScrollMode();
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (m2332a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1022k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1029r)) {
                            if (obj != null) {
                                m2328g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1015d.m2468a(((float) i) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.f1016e.m2466a()) {
                                        this.f1016e.m2472c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1016e.m2468a(((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.f1015d.m2466a()) {
                                        this.f1015d.m2472c();
                                    }
                                }
                                if (!(this.f1015d == null || (this.f1015d.m2466a() && this.f1016e.m2466a()))) {
                                    aj.m1874c(this);
                                    break;
                                }
                            }
                        }
                        this.f1017f -= this.f1029r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1029r[1]);
                        this.f1031t += this.f1029r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1028q + " in onTouchEvent");
                break;
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                if (this.f1021j && getChildCount() > 0 && this.f1014c.m2519a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    aj.m1874c(this);
                }
                this.f1028q = -1;
                m2326f();
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                a = C0534t.m2227b(motionEvent);
                this.f1017f = (int) motionEvent.getY(a);
                this.f1028q = motionEvent.getPointerId(a);
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                m2312a(motionEvent);
                this.f1017f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1028q));
                break;
        }
        if (this.f1022k != null) {
            this.f1022k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1018g) {
            this.f1020i = view2;
        } else {
            m2319b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2314a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2324e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1018g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2318b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2318b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1023l) {
            this.f1023l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1034y.m2229a(z);
    }

    public void setOnScrollChangeListener(C0547b c0547b) {
        this.f1011A = c0547b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1024m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f1034y.m2233a(i);
    }

    public void stopNestedScroll() {
        this.f1034y.m2237c();
    }
}
