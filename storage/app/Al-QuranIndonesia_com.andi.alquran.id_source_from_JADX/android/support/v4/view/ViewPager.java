package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;
import android.support.v4.p009b.C0173a;
import android.support.v4.view.p015a.C0389a;
import android.support.v4.view.p015a.C0404c;
import android.support.v4.view.p015a.C0427k;
import android.support.v4.widget.C0571i;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    static final int[] f800a;
    private static final C0375i aj;
    private static final Comparator<C0370b> f801e;
    private static final Interpolator f802f;
    private int f803A;
    private boolean f804B;
    private boolean f805C;
    private int f806D;
    private int f807E;
    private int f808F;
    private float f809G;
    private float f810H;
    private float f811I;
    private float f812J;
    private int f813K;
    private VelocityTracker f814L;
    private int f815M;
    private int f816N;
    private int f817O;
    private int f818P;
    private boolean f819Q;
    private C0571i f820R;
    private C0571i f821S;
    private boolean f822T;
    private boolean f823U;
    private boolean f824V;
    private int f825W;
    private List<C0088f> aa;
    private C0088f ab;
    private C0088f ac;
    private List<C0078e> ad;
    private C0373g ae;
    private int af;
    private Method ag;
    private int ah;
    private ArrayList<View> ai;
    private final Runnable ak;
    private int al;
    aa f826b;
    int f827c;
    private int f828d;
    private final ArrayList<C0370b> f829g;
    private final C0370b f830h;
    private final Rect f831i;
    private int f832j;
    private Parcelable f833k;
    private ClassLoader f834l;
    private Scroller f835m;
    private boolean f836n;
    private C0374h f837o;
    private int f838p;
    private Drawable f839q;
    private int f840r;
    private int f841s;
    private float f842t;
    private float f843u;
    private int f844v;
    private int f845w;
    private boolean f846x;
    private boolean f847y;
    private boolean f848z;

    /* renamed from: android.support.v4.view.ViewPager.e */
    public interface C0078e {
        void m396a(ViewPager viewPager, aa aaVar, aa aaVar2);
    }

    /* renamed from: android.support.v4.view.ViewPager.f */
    public interface C0088f {
        void m433a(int i);

        void m434a(int i, float f, int i2);

        void m435b(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager.1 */
    static class C03641 implements Comparator<C0370b> {
        C03641() {
        }

        public int m1282a(C0370b c0370b, C0370b c0370b2) {
            return c0370b.f788b - c0370b2.f788b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1282a((C0370b) obj, (C0370b) obj2);
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.2 */
    static class C03652 implements Interpolator {
        C03652() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.3 */
    class C03663 implements Runnable {
        final /* synthetic */ ViewPager f781a;

        C03663(ViewPager viewPager) {
            this.f781a = viewPager;
        }

        public void run() {
            this.f781a.setScrollState(0);
            this.f781a.m1329c();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.4 */
    class C03674 implements C0058z {
        final /* synthetic */ ViewPager f782a;
        private final Rect f783b;

        C03674(ViewPager viewPager) {
            this.f782a = viewPager;
            this.f783b = new Rect();
        }

        public bf onApplyWindowInsets(View view, bf bfVar) {
            bf a = aj.m1853a(view, bfVar);
            if (a.m2117e()) {
                return a;
            }
            Rect rect = this.f783b;
            rect.left = a.m2112a();
            rect.top = a.m2114b();
            rect.right = a.m2115c();
            rect.bottom = a.m2116d();
            int childCount = this.f782a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                bf b = aj.m1869b(this.f782a.getChildAt(i), a);
                rect.left = Math.min(b.m2112a(), rect.left);
                rect.top = Math.min(b.m2114b(), rect.top);
                rect.right = Math.min(b.m2115c(), rect.right);
                rect.bottom = Math.min(b.m2116d(), rect.bottom);
            }
            return a.m2113a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        int f784a;
        Parcelable f785b;
        ClassLoader f786c;

        /* renamed from: android.support.v4.view.ViewPager.SavedState.1 */
        static class C03681 implements C0043e<SavedState> {
            C03681() {
            }

            public SavedState m1283a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m1284a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1283a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1284a(i);
            }
        }

        static {
            CREATOR = C0267d.m910a(new C03681());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f784a = parcel.readInt();
            this.f785b = parcel.readParcelable(classLoader);
            this.f786c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f784a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f784a);
            parcel.writeParcelable(this.f785b, i);
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.v4.view.ViewPager.a */
    public @interface C0369a {
    }

    /* renamed from: android.support.v4.view.ViewPager.b */
    static class C0370b {
        Object f787a;
        int f788b;
        boolean f789c;
        float f790d;
        float f791e;

        C0370b() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.c */
    public static class C0371c extends LayoutParams {
        public boolean f792a;
        public int f793b;
        float f794c;
        boolean f795d;
        int f796e;
        int f797f;

        public C0371c() {
            super(-1, -1);
            this.f794c = 0.0f;
        }

        public C0371c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f794c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f800a);
            this.f793b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.d */
    class C0372d extends C0036a {
        final /* synthetic */ ViewPager f798a;

        C0372d(ViewPager viewPager) {
            this.f798a = viewPager;
        }

        private boolean m1285a() {
            return this.f798a.f826b != null && this.f798a.f826b.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0427k a = C0389a.m1405a(accessibilityEvent);
            a.m1611a(m1285a());
            if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT && this.f798a.f826b != null) {
                a.m1610a(this.f798a.f826b.getCount());
                a.m1612b(this.f798a.f827c);
                a.m1613c(this.f798a.f827c);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            c0404c.m1506a(ViewPager.class.getName());
            c0404c.m1513c(m1285a());
            if (this.f798a.canScrollHorizontally(1)) {
                c0404c.m1503a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            }
            if (this.f798a.canScrollHorizontally(-1)) {
                c0404c.m1503a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                    if (!this.f798a.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f798a.setCurrentItem(this.f798a.f827c + 1);
                    return true;
                case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                    if (!this.f798a.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f798a.setCurrentItem(this.f798a.f827c - 1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.g */
    public interface C0373g {
        void m1286a(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager.h */
    private class C0374h extends DataSetObserver {
        final /* synthetic */ ViewPager f799a;

        C0374h(ViewPager viewPager) {
            this.f799a = viewPager;
        }

        public void onChanged() {
            this.f799a.m1325b();
        }

        public void onInvalidated() {
            this.f799a.m1325b();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.i */
    static class C0375i implements Comparator<View> {
        C0375i() {
        }

        public int m1287a(View view, View view2) {
            C0371c c0371c = (C0371c) view.getLayoutParams();
            C0371c c0371c2 = (C0371c) view2.getLayoutParams();
            return c0371c.f792a != c0371c2.f792a ? c0371c.f792a ? 1 : -1 : c0371c.f796e - c0371c2.f796e;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1287a((View) obj, (View) obj2);
        }
    }

    static {
        f800a = new int[]{16842931};
        f801e = new C03641();
        f802f = new C03652();
        aj = new C0375i();
    }

    public ViewPager(Context context) {
        super(context);
        this.f829g = new ArrayList();
        this.f830h = new C0370b();
        this.f831i = new Rect();
        this.f832j = -1;
        this.f833k = null;
        this.f834l = null;
        this.f842t = -3.4028235E38f;
        this.f843u = Float.MAX_VALUE;
        this.f803A = 1;
        this.f813K = -1;
        this.f822T = true;
        this.f823U = false;
        this.ak = new C03663(this);
        this.al = 0;
        m1312a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f829g = new ArrayList();
        this.f830h = new C0370b();
        this.f831i = new Rect();
        this.f832j = -1;
        this.f833k = null;
        this.f834l = null;
        this.f842t = -3.4028235E38f;
        this.f843u = Float.MAX_VALUE;
        this.f803A = 1;
        this.f813K = -1;
        this.f822T = true;
        this.f823U = false;
        this.ak = new C03663(this);
        this.al = 0;
        m1312a();
    }

    private int m1288a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f817O || Math.abs(i2) <= this.f815M) {
            i += (int) ((i >= this.f827c ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f829g.size() <= 0) {
            return i;
        }
        return Math.max(((C0370b) this.f829g.get(0)).f788b, Math.min(i, ((C0370b) this.f829g.get(this.f829g.size() - 1)).f788b));
    }

    private Rect m1289a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m1290a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f829g.isEmpty()) {
            C0370b b = m1323b(this.f827c);
            int min = (int) ((b != null ? Math.min(b.f791e, this.f843u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1294a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f835m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f835m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void m1291a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0370b b = m1323b(i);
        if (b != null) {
            max = (int) (Math.max(this.f842t, Math.min(b.f791e, this.f843u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1315a(max, 0, i2);
            if (z2) {
                m1302e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1302e(i);
        }
        m1294a(false);
        scrollTo(max, 0);
        m1301d(max);
    }

    private void m1292a(C0370b c0370b, int i, C0370b c0370b2) {
        float f;
        int i2;
        C0370b c0370b3;
        int i3;
        int count = this.f826b.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f838p) / ((float) clientWidth) : 0.0f;
        if (c0370b2 != null) {
            clientWidth = c0370b2.f788b;
            int i4;
            if (clientWidth < c0370b.f788b) {
                f = (c0370b2.f791e + c0370b2.f790d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0370b.f788b && i2 < this.f829g.size()) {
                    c0370b3 = (C0370b) this.f829g.get(i2);
                    while (i4 > c0370b3.f788b && i2 < this.f829g.size() - 1) {
                        i2++;
                        c0370b3 = (C0370b) this.f829g.get(i2);
                    }
                    while (i4 < c0370b3.f788b) {
                        f += this.f826b.getPageWidth(i4) + f2;
                        i4++;
                    }
                    c0370b3.f791e = f;
                    f += c0370b3.f790d + f2;
                    i4++;
                }
            } else if (clientWidth > c0370b.f788b) {
                i2 = this.f829g.size() - 1;
                f = c0370b2.f791e;
                i4 = clientWidth - 1;
                while (i4 >= c0370b.f788b && i2 >= 0) {
                    c0370b3 = (C0370b) this.f829g.get(i2);
                    while (i4 < c0370b3.f788b && i2 > 0) {
                        i2--;
                        c0370b3 = (C0370b) this.f829g.get(i2);
                    }
                    while (i4 > c0370b3.f788b) {
                        f -= this.f826b.getPageWidth(i4) + f2;
                        i4--;
                    }
                    f -= c0370b3.f790d + f2;
                    c0370b3.f791e = f;
                    i4--;
                }
            }
        }
        int size = this.f829g.size();
        float f3 = c0370b.f791e;
        i2 = c0370b.f788b - 1;
        this.f842t = c0370b.f788b == 0 ? c0370b.f791e : -3.4028235E38f;
        this.f843u = c0370b.f788b == count + -1 ? (c0370b.f791e + c0370b.f790d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c0370b3 = (C0370b) this.f829g.get(i3);
            f = f3;
            while (i2 > c0370b3.f788b) {
                f -= this.f826b.getPageWidth(i2) + f2;
                i2--;
            }
            f3 = f - (c0370b3.f790d + f2);
            c0370b3.f791e = f3;
            if (c0370b3.f788b == 0) {
                this.f842t = f3;
            }
            i2--;
        }
        f3 = (c0370b.f791e + c0370b.f790d) + f2;
        i2 = c0370b.f788b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0370b3 = (C0370b) this.f829g.get(i3);
            f = f3;
            while (i2 < c0370b3.f788b) {
                f = (this.f826b.getPageWidth(i2) + f2) + f;
                i2++;
            }
            if (c0370b3.f788b == count - 1) {
                this.f843u = (c0370b3.f790d + f) - 1.0f;
            }
            c0370b3.f791e = f;
            f3 = f + (c0370b3.f790d + f2);
            i2++;
        }
        this.f823U = false;
    }

    private void m1293a(MotionEvent motionEvent) {
        int b = C0534t.m2227b(motionEvent);
        if (motionEvent.getPointerId(b) == this.f813K) {
            b = b == 0 ? 1 : 0;
            this.f809G = motionEvent.getX(b);
            this.f813K = motionEvent.getPointerId(b);
            if (this.f814L != null) {
                this.f814L.clear();
            }
        }
    }

    private void m1294a(boolean z) {
        int scrollX;
        boolean z2 = this.al == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f835m.isFinished()) {
                this.f835m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f835m.getCurrX();
                int currY = this.f835m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1301d(currX);
                    }
                }
            }
        }
        this.f848z = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f829g.size(); scrollX++) {
            C0370b c0370b = (C0370b) this.f829g.get(scrollX);
            if (c0370b.f789c) {
                c0370b.f789c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            aj.m1864a((View) this, this.ak);
        } else {
            this.ak.run();
        }
    }

    private boolean m1295a(float f, float f2) {
        return (f < ((float) this.f807E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f807E)) && f2 < 0.0f);
    }

    private void m1296b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.m434a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0088f c0088f = (C0088f) this.aa.get(i3);
                if (c0088f != null) {
                    c0088f.m434a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.m434a(i, f, i2);
        }
    }

    private void m1297b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            aj.m1857a(getChildAt(i), z ? this.af : 0, null);
        }
    }

    private boolean m1298b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f809G - f;
        this.f809G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f842t;
        float f5 = ((float) clientWidth) * this.f843u;
        C0370b c0370b = (C0370b) this.f829g.get(0);
        C0370b c0370b2 = (C0370b) this.f829g.get(this.f829g.size() - 1);
        if (c0370b.f788b != 0) {
            f4 = c0370b.f791e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0370b2.f788b != this.f826b.getCount() - 1) {
            f2 = c0370b2.f791e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f820R.m2467a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f821S.m2467a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f809G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1301d((int) f4);
        return z3;
    }

    private void m1299c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private static boolean m1300c(View view) {
        return view.getClass().getAnnotation(C0369a.class) != null;
    }

    private boolean m1301d(int i) {
        if (this.f829g.size() != 0) {
            C0370b i2 = m1307i();
            int clientWidth = getClientWidth();
            int i3 = this.f838p + clientWidth;
            float f = ((float) this.f838p) / ((float) clientWidth);
            int i4 = i2.f788b;
            float f2 = ((((float) i) / ((float) clientWidth)) - i2.f791e) / (i2.f790d + f);
            clientWidth = (int) (((float) i3) * f2);
            this.f824V = false;
            m1314a(i4, f2, clientWidth);
            if (this.f824V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f822T) {
            return false;
        } else {
            this.f824V = false;
            m1314a(0, 0.0f, 0);
            if (this.f824V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void m1302e(int i) {
        if (this.ab != null) {
            this.ab.m435b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0088f c0088f = (C0088f) this.aa.get(i2);
                if (c0088f != null) {
                    c0088f.m435b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.m435b(i);
        }
    }

    private void m1303f() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0371c) getChildAt(i).getLayoutParams()).f792a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void m1304f(int i) {
        if (this.ab != null) {
            this.ab.m433a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0088f c0088f = (C0088f) this.aa.get(i2);
                if (c0088f != null) {
                    c0088f.m433a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.m433a(i);
        }
    }

    private void m1305g() {
        if (this.ah != 0) {
            if (this.ai == null) {
                this.ai = new ArrayList();
            } else {
                this.ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ai.add(getChildAt(i));
            }
            Collections.sort(this.ai, aj);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean m1306h() {
        this.f813K = -1;
        m1308j();
        return this.f820R.m2472c() | this.f821S.m2472c();
    }

    private C0370b m1307i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f838p) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C0370b c0370b = null;
        while (i2 < this.f829g.size()) {
            int i3;
            C0370b c0370b2;
            C0370b c0370b3 = (C0370b) this.f829g.get(i2);
            C0370b c0370b4;
            if (obj != null || c0370b3.f788b == i + 1) {
                c0370b4 = c0370b3;
                i3 = i2;
                c0370b2 = c0370b4;
            } else {
                c0370b3 = this.f830h;
                c0370b3.f791e = (f2 + f3) + f;
                c0370b3.f788b = i + 1;
                c0370b3.f790d = this.f826b.getPageWidth(c0370b3.f788b);
                c0370b4 = c0370b3;
                i3 = i2 - 1;
                c0370b2 = c0370b4;
            }
            f2 = c0370b2.f791e;
            f3 = (c0370b2.f790d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0370b;
            }
            if (scrollX < f3 || i3 == this.f829g.size() - 1) {
                return c0370b2;
            }
            f3 = f2;
            i = c0370b2.f788b;
            obj = null;
            f2 = c0370b2.f790d;
            c0370b = c0370b2;
            i2 = i3 + 1;
        }
        return c0370b;
    }

    private void m1308j() {
        this.f804B = false;
        this.f805C = false;
        if (this.f814L != null) {
            this.f814L.recycle();
            this.f814L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f847y != z) {
            this.f847y = z;
        }
    }

    float m1309a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    C0370b m1310a(int i, int i2) {
        C0370b c0370b = new C0370b();
        c0370b.f788b = i;
        c0370b.f787a = this.f826b.instantiateItem((ViewGroup) this, i);
        c0370b.f790d = this.f826b.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f829g.size()) {
            this.f829g.add(c0370b);
        } else {
            this.f829g.add(i2, c0370b);
        }
        return c0370b;
    }

    C0370b m1311a(View view) {
        for (int i = 0; i < this.f829g.size(); i++) {
            C0370b c0370b = (C0370b) this.f829g.get(i);
            if (this.f826b.isViewFromObject(view, c0370b.f787a)) {
                return c0370b;
            }
        }
        return null;
    }

    void m1312a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f835m = new Scroller(context, f802f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f808F = viewConfiguration.getScaledPagingTouchSlop();
        this.f815M = (int) (400.0f * f);
        this.f816N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f820R = new C0571i(context);
        this.f821S = new C0571i(context);
        this.f817O = (int) (25.0f * f);
        this.f818P = (int) (2.0f * f);
        this.f806D = (int) (16.0f * f);
        aj.m1861a((View) this, new C0372d(this));
        if (aj.m1878d(this) == 0) {
            aj.m1876c((View) this, 1);
        }
        aj.m1863a((View) this, new C03674(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1313a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f827c;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f827c;
        r0 = r17;
        r2 = r0.m1323b(r2);
        r0 = r18;
        r1 = r17;
        r1.f827c = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f826b;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m1305g();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f848z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m1305g();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f826b;
        r0 = r17;
        r2.startUpdate(r0);
        r0 = r17;
        r2 = r0.f803A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f827c;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f826b;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f827c;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f828d;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f828d;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f826b;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
        r6 = r2.f788b;
        r0 = r17;
        r7 = r0.f827c;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f788b;
        r0 = r17;
        r7 = r0.f827c;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f827c;
        r0 = r17;
        r2 = r0.m1310a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f827c;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f790d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f827c;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m1292a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f826b;
        r0 = r17;
        r4 = r0.f827c;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f787a;
    L_0x0179:
        r0 = r17;
        r3.setPrimaryItem(r0, r4, r2);
        r0 = r17;
        r2 = r0.f826b;
        r0 = r17;
        r2.finishUpdate(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0371c) r2;
        r2.f797f = r3;
        r6 = r2.f792a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f794c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m1311a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f790d;
        r2.f794c = r6;
        r5 = r5.f788b;
        r2.f796e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f790d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f788b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f789c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f829g;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f826b;
        r2 = r2.f787a;
        r0 = r17;
        r14.destroyItem(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f788b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f790d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m1310a(r8, r2);
        r2 = r2.f790d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f788b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f789c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f829g;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f826b;
        r2 = r2.f787a;
        r0 = r17;
        r10.destroyItem(r0, r8, r2);
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f788b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f790d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m1310a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f790d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f829g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0370b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m1305g();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m1324b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f788b;
        r0 = r17;
        r3 = r0.f827c;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m1311a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f788b;
        r0 = r17;
        r5 = r0.f827c;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    protected void m1314a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f825W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0371c c0371c = (C0371c) childAt.getLayoutParams();
                if (c0371c.f792a) {
                    int max;
                    switch (c0371c.f793b & 7) {
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case C1096c.MapAttrs_cameraZoom /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1296b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0371c) childAt2.getLayoutParams()).f792a) {
                    this.ae.m1286a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f824V = true;
    }

    void m1315a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f835m == null || this.f835m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f836n ? this.f835m.getCurrX() : this.f835m.getStartX();
            this.f835m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m1294a(false);
            m1329c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m1309a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f826b.getPageWidth(this.f827c)) + ((float) this.f838p))) + 1.0f) * 100.0f), 600);
        this.f836n = false;
        this.f835m.startScroll(i4, scrollY, i5, i6, i7);
        aj.m1874c(this);
    }

    public void m1316a(int i, boolean z) {
        this.f848z = false;
        m1317a(i, z, false);
    }

    void m1317a(int i, boolean z, boolean z2) {
        m1318a(i, z, z2, 0);
    }

    void m1318a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f826b == null || this.f826b.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f827c != i || this.f829g.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f826b.getCount()) {
                i = this.f826b.getCount() - 1;
            }
            int i3 = this.f803A;
            if (i > this.f827c + i3 || i < this.f827c - i3) {
                for (int i4 = 0; i4 < this.f829g.size(); i4++) {
                    ((C0370b) this.f829g.get(i4)).f789c = true;
                }
            }
            if (this.f827c != i) {
                z3 = true;
            }
            if (this.f822T) {
                this.f827c = i;
                if (z3) {
                    m1302e(i);
                }
                requestLayout();
                return;
            }
            m1313a(i);
            m1291a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void m1319a(C0078e c0078e) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(c0078e);
    }

    public void m1320a(C0088f c0088f) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(c0088f);
    }

    public boolean m1321a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return m1330c(17);
            case C1096c.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return m1330c(66);
            case C0861R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? C0505h.m2159a(keyEvent) ? m1330c(2) : C0505h.m2160a(keyEvent, 1) ? m1330c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m1322a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1322a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && aj.m1868a(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0370b a = m1311a(childAt);
                    if (a != null && a.f788b == this.f827c) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0370b a = m1311a(childAt);
                if (a != null && a.f788b == this.f827c) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C0371c c0371c = (C0371c) generateLayoutParams;
        c0371c.f792a |= m1300c(view);
        if (!this.f846x) {
            super.addView(view, i, generateLayoutParams);
        } else if (c0371c == null || !c0371c.f792a) {
            c0371c.f795d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    C0370b m1323b(int i) {
        for (int i2 = 0; i2 < this.f829g.size(); i2++) {
            C0370b c0370b = (C0370b) this.f829g.get(i2);
            if (c0370b.f788b == i) {
                return c0370b;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.ViewPager.C0370b m1324b(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = (android.view.View) r0;
        r3 = r0;
        goto L_0x0000;
    L_0x0012:
        r0 = r2.m1311a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(android.view.View):android.support.v4.view.ViewPager$b");
    }

    void m1325b() {
        int count = this.f826b.getCount();
        this.f828d = count;
        boolean z = this.f829g.size() < (this.f803A * 2) + 1 && this.f829g.size() < count;
        boolean z2 = false;
        int i = this.f827c;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f829g.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0370b c0370b = (C0370b) this.f829g.get(i2);
            int itemPosition = this.f826b.getItemPosition(c0370b.f787a);
            if (itemPosition == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (itemPosition == -2) {
                this.f829g.remove(i2);
                i2--;
                if (!z2) {
                    this.f826b.startUpdate((ViewGroup) this);
                    z2 = true;
                }
                this.f826b.destroyItem((ViewGroup) this, c0370b.f788b, c0370b.f787a);
                if (this.f827c == c0370b.f788b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f827c, count - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0370b.f788b != itemPosition) {
                if (c0370b.f788b == this.f827c) {
                    i = itemPosition;
                }
                c0370b.f788b = itemPosition;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f826b.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f829g, f801e);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C0371c c0371c = (C0371c) getChildAt(i2).getLayoutParams();
                if (!c0371c.f792a) {
                    c0371c.f794c = 0.0f;
                }
            }
            m1317a(i, false, true);
            requestLayout();
        }
    }

    public void m1326b(C0078e c0078e) {
        if (this.ad != null) {
            this.ad.remove(c0078e);
        }
    }

    public void m1327b(C0088f c0088f) {
        if (this.aa != null) {
            this.aa.remove(c0088f);
        }
    }

    C0088f m1328c(C0088f c0088f) {
        C0088f c0088f2 = this.ac;
        this.ac = c0088f;
        return c0088f2;
    }

    void m1329c() {
        m1313a(this.f827c);
    }

    public boolean m1330c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m1331d();
            } else {
                if (i == 66 || i == 2) {
                    d = m1332e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1289a(this.f831i, findNextFocus).left < m1289a(this.f831i, view).left) ? findNextFocus.requestFocus() : m1331d();
        } else {
            if (i == 66) {
                d = (view == null || m1289a(this.f831i, findNextFocus).left > m1289a(this.f831i, view).left) ? findNextFocus.requestFocus() : m1332e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f826b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f842t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f843u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0371c) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f836n = true;
        if (this.f835m.isFinished() || !this.f835m.computeScrollOffset()) {
            m1294a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f835m.getCurrX();
        int currY = this.f835m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1301d(currX)) {
                this.f835m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        aj.m1874c(this);
    }

    boolean m1331d() {
        if (this.f827c <= 0) {
            return false;
        }
        m1316a(this.f827c - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1321a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0370b a = m1311a(childAt);
                if (a != null && a.f788b == this.f827c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f826b != null && this.f826b.getCount() > 1)) {
            int height;
            int width;
            if (!this.f820R.m2466a()) {
                overScrollMode = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f842t * ((float) width));
                this.f820R.m2465a(height, width);
                i = 0 | this.f820R.m2470a(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.f821S.m2466a()) {
                overScrollMode = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f843u + 1.0f)) * ((float) height));
                this.f821S.m2465a(width, height);
                i |= this.f821S.m2470a(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.f820R.m2471b();
            this.f821S.m2471b();
        }
        if (i != 0) {
            aj.m1874c(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f839q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m1332e() {
        if (this.f826b == null || this.f827c >= this.f826b.getCount() - 1) {
            return false;
        }
        m1316a(this.f827c + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0371c();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0371c(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public aa getAdapter() {
        return this.f826b;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0371c) ((View) this.ai.get(i2)).getLayoutParams()).f797f;
    }

    public int getCurrentItem() {
        return this.f827c;
    }

    public int getOffscreenPageLimit() {
        return this.f803A;
    }

    public int getPageMargin() {
        return this.f838p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f822T = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.f835m == null || this.f835m.isFinished())) {
            this.f835m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f838p > 0 && this.f839q != null && this.f829g.size() > 0 && this.f826b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f838p) / ((float) width);
            C0370b c0370b = (C0370b) this.f829g.get(0);
            float f2 = c0370b.f791e;
            int size = this.f829g.size();
            int i = c0370b.f788b;
            int i2 = ((C0370b) this.f829g.get(size - 1)).f788b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0370b.f788b && i3 < size) {
                    i3++;
                    c0370b = (C0370b) this.f829g.get(i3);
                }
                if (i4 == c0370b.f788b) {
                    f3 = (c0370b.f791e + c0370b.f790d) * ((float) width);
                    f2 = (c0370b.f791e + c0370b.f790d) + f;
                } else {
                    float pageWidth = this.f826b.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.f838p) + f3 > ((float) scrollX)) {
                    this.f839q.setBounds(Math.round(f3), this.f840r, Math.round(((float) this.f838p) + f3), this.f841s);
                    this.f839q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1306h();
            return false;
        }
        if (action != 0) {
            if (this.f804B) {
                return true;
            }
            if (this.f805C) {
                return false;
            }
        }
        switch (action) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                float x = motionEvent.getX();
                this.f811I = x;
                this.f809G = x;
                x = motionEvent.getY();
                this.f812J = x;
                this.f810H = x;
                this.f813K = motionEvent.getPointerId(0);
                this.f805C = false;
                this.f836n = true;
                this.f835m.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.f835m.getFinalX() - this.f835m.getCurrX()) > this.f818P) {
                    this.f835m.abortAnimation();
                    this.f848z = false;
                    m1329c();
                    this.f804B = true;
                    m1299c(true);
                    setScrollState(1);
                    break;
                }
                m1294a(false);
                this.f804B = false;
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                action = this.f813K;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.f809G;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.f812J);
                    if (f == 0.0f || m1295a(this.f809G, f) || !m1322a(this, false, (int) f, (int) x2, (int) y)) {
                        if (abs > ((float) this.f808F) && 0.5f * abs > abs2) {
                            this.f804B = true;
                            m1299c(true);
                            setScrollState(1);
                            this.f809G = f > 0.0f ? this.f811I + ((float) this.f808F) : this.f811I - ((float) this.f808F);
                            this.f810H = y;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f808F)) {
                            this.f805C = true;
                        }
                        if (this.f804B && m1298b(x2)) {
                            aj.m1874c(this);
                            break;
                        }
                    }
                    this.f809G = x2;
                    this.f810H = y;
                    this.f805C = true;
                    return false;
                }
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                m1293a(motionEvent);
                break;
        }
        if (this.f814L == null) {
            this.f814L = VelocityTracker.obtain();
        }
        this.f814L.addMovement(motionEvent);
        return this.f804B;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0371c c0371c;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0371c = (C0371c) childAt.getLayoutParams();
                if (c0371c.f792a) {
                    int i9 = c0371c.f793b & C0861R.styleable.AppCompatTheme_spinnerStyle;
                    switch (c0371c.f793b & 7) {
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case C1096c.MapAttrs_cameraZoom /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case C1096c.MapAttrs_ambientEnabled /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case C0861R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0371c = (C0371c) childAt2.getLayoutParams();
                if (!c0371c.f792a) {
                    C0370b a = m1311a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f791e * ((float) max))) + paddingLeft;
                        if (c0371c.f795d) {
                            c0371c.f795d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0371c.f794c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f840r = paddingTop;
        this.f841s = i6 - paddingBottom;
        this.f825W = i7;
        if (this.f822T) {
            m1291a(this.f827c, false, 0, false);
        }
        this.f822T = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f807E = Math.min(measuredWidth / 10, this.f806D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            C0371c c0371c;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0371c = (C0371c) childAt.getLayoutParams();
                if (c0371c != null && c0371c.f792a) {
                    int i6 = c0371c.f793b & 7;
                    int i7 = c0371c.f793b & C0861R.styleable.AppCompatTheme_spinnerStyle;
                    i3 = RtlSpacingHelper.UNDEFINED;
                    i5 = RtlSpacingHelper.UNDEFINED;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0371c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0371c.width != -1 ? c0371c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0371c.height != -2) {
                        i5 = 1073741824;
                        if (c0371c.height != -1) {
                            measuredWidth = c0371c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f844v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f845w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f846x = true;
        m1329c();
        this.f846x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0371c = (C0371c) childAt2.getLayoutParams();
                if (c0371c == null || !c0371c.f792a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0371c.f794c * ((float) paddingLeft)), 1073741824), this.f845w);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0370b a = m1311a(childAt);
                if (a != null && a.f788b == this.f827c && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f826b != null) {
                this.f826b.restoreState(savedState.f785b, savedState.f786c);
                m1317a(savedState.f784a, false, true);
                return;
            }
            this.f832j = savedState.f784a;
            this.f833k = savedState.f785b;
            this.f834l = savedState.f786c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f784a = this.f827c;
        if (this.f826b != null) {
            savedState.f785b = this.f826b.saveState();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1290a(i, i3, this.f838p, this.f838p);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f819Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f826b == null || this.f826b.getCount() == 0) {
            return false;
        }
        if (this.f814L == null) {
            this.f814L = VelocityTracker.obtain();
        }
        this.f814L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f835m.abortAnimation();
                this.f848z = false;
                m1329c();
                x = motionEvent.getX();
                this.f811I = x;
                this.f809G = x;
                x = motionEvent.getY();
                this.f812J = x;
                this.f810H = x;
                this.f813K = motionEvent.getPointerId(0);
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (this.f804B) {
                    VelocityTracker velocityTracker = this.f814L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f816N);
                    a = (int) ah.m1646a(velocityTracker, this.f813K);
                    this.f848z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0370b i = m1307i();
                    m1318a(m1288a(i.f788b, ((((float) scrollX) / ((float) clientWidth)) - i.f791e) / (i.f790d + (((float) this.f838p) / ((float) clientWidth))), a, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f813K)) - this.f811I)), true, true, a);
                    z = m1306h();
                    break;
                }
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                if (!this.f804B) {
                    a = motionEvent.findPointerIndex(this.f813K);
                    if (a == -1) {
                        z = m1306h();
                        break;
                    }
                    float x2 = motionEvent.getX(a);
                    float abs = Math.abs(x2 - this.f809G);
                    float y = motionEvent.getY(a);
                    x = Math.abs(y - this.f810H);
                    if (abs > ((float) this.f808F) && abs > x) {
                        this.f804B = true;
                        m1299c(true);
                        this.f809G = x2 - this.f811I > 0.0f ? this.f811I + ((float) this.f808F) : this.f811I - ((float) this.f808F);
                        this.f810H = y;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f804B) {
                    z = false | m1298b(motionEvent.getX(motionEvent.findPointerIndex(this.f813K)));
                    break;
                }
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                if (this.f804B) {
                    m1291a(this.f827c, true, 0, false);
                    z = m1306h();
                    break;
                }
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                a = C0534t.m2227b(motionEvent);
                this.f809G = motionEvent.getX(a);
                this.f813K = motionEvent.getPointerId(a);
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                m1293a(motionEvent);
                this.f809G = motionEvent.getX(motionEvent.findPointerIndex(this.f813K));
                break;
        }
        if (z) {
            aj.m1874c(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f846x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(aa aaVar) {
        int i = false;
        if (this.f826b != null) {
            this.f826b.setViewPagerObserver(null);
            this.f826b.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f829g.size(); i2++) {
                C0370b c0370b = (C0370b) this.f829g.get(i2);
                this.f826b.destroyItem((ViewGroup) this, c0370b.f788b, c0370b.f787a);
            }
            this.f826b.finishUpdate((ViewGroup) this);
            this.f829g.clear();
            m1303f();
            this.f827c = 0;
            scrollTo(0, 0);
        }
        aa aaVar2 = this.f826b;
        this.f826b = aaVar;
        this.f828d = 0;
        if (this.f826b != null) {
            if (this.f837o == null) {
                this.f837o = new C0374h(this);
            }
            this.f826b.setViewPagerObserver(this.f837o);
            this.f848z = false;
            boolean z = this.f822T;
            this.f822T = true;
            this.f828d = this.f826b.getCount();
            if (this.f832j >= 0) {
                this.f826b.restoreState(this.f833k, this.f834l);
                m1317a(this.f832j, false, true);
                this.f832j = -1;
                this.f833k = null;
                this.f834l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1329c();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int size = this.ad.size();
            while (i < size) {
                ((C0078e) this.ad.get(i)).m396a(this, aaVar2, aaVar);
                i++;
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ag == null) {
                try {
                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f848z = false;
        m1317a(i, !this.f822T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f803A) {
            this.f803A = i;
            m1329c();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(C0088f c0088f) {
        this.ab = c0088f;
    }

    public void setPageMargin(int i) {
        int i2 = this.f838p;
        this.f838p = i;
        int width = getWidth();
        m1290a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(C0173a.getDrawable(getContext(), i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f839q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i) {
        if (this.al != i) {
            this.al = i;
            if (this.ae != null) {
                m1297b(i != 0);
            }
            m1304f(i);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f839q;
    }
}
