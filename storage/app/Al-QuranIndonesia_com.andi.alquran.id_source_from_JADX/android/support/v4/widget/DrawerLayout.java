package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;
import android.support.v4.p009b.C0173a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0036a;
import android.support.v4.view.C0500f;
import android.support.v4.view.aj;
import android.support.v4.view.p015a.C0404c;
import android.support.v4.widget.ad.C0052a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final int[] f971a;
    static final boolean f972b;
    static final C0540b f973c;
    private static final boolean f974d;
    private float f975A;
    private Drawable f976B;
    private Drawable f977C;
    private Drawable f978D;
    private Object f979E;
    private boolean f980F;
    private Drawable f981G;
    private Drawable f982H;
    private Drawable f983I;
    private Drawable f984J;
    private final ArrayList<View> f985K;
    private final C0539a f986e;
    private float f987f;
    private int f988g;
    private int f989h;
    private float f990i;
    private Paint f991j;
    private final ad f992k;
    private final ad f993l;
    private final C0544g f994m;
    private final C0544g f995n;
    private int f996o;
    private boolean f997p;
    private boolean f998q;
    private int f999r;
    private int f1000s;
    private int f1001t;
    private int f1002u;
    private boolean f1003v;
    private boolean f1004w;
    private C0170e f1005x;
    private List<C0170e> f1006y;
    private float f1007z;

    /* renamed from: android.support.v4.widget.DrawerLayout.e */
    public interface C0170e {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        int f958a;
        int f959b;
        int f960c;
        int f961d;
        int f962e;

        /* renamed from: android.support.v4.widget.DrawerLayout.SavedState.1 */
        static class C05381 implements C0043e<SavedState> {
            C05381() {
            }

            public SavedState m2241a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m2242a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2241a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2242a(i);
            }
        }

        static {
            CREATOR = C0267d.m910a(new C05381());
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f958a = 0;
            this.f958a = parcel.readInt();
            this.f959b = parcel.readInt();
            this.f960c = parcel.readInt();
            this.f961d = parcel.readInt();
            this.f962e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f958a = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f958a);
            parcel.writeInt(this.f959b);
            parcel.writeInt(this.f960c);
            parcel.writeInt(this.f961d);
            parcel.writeInt(this.f962e);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.a */
    final class C0539a extends C0036a {
        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            if (!DrawerLayout.m2273l(view)) {
                c0404c.m1505a(null);
            }
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.b */
    interface C0540b {
        int m2243a(Object obj);

        void m2244a(View view, Object obj, int i);

        void m2245a(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.c */
    static class C0541c implements C0540b {
        C0541c() {
        }

        public int m2246a(Object obj) {
            return C0566h.m2434a(obj);
        }

        public void m2247a(View view, Object obj, int i) {
            C0566h.m2435a(view, obj, i);
        }

        public void m2248a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            C0566h.m2436a(marginLayoutParams, obj, i);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.d */
    static class C0542d implements C0540b {
        C0542d() {
        }

        public int m2249a(Object obj) {
            return 0;
        }

        public void m2250a(View view, Object obj, int i) {
        }

        public void m2251a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.f */
    public static class C0543f extends MarginLayoutParams {
        public int f963a;
        float f964b;
        boolean f965c;
        int f966d;

        public C0543f(int i, int i2) {
            super(i, i2);
            this.f963a = 0;
        }

        public C0543f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f963a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f971a);
            this.f963a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0543f(C0543f c0543f) {
            super(c0543f);
            this.f963a = 0;
            this.f963a = c0543f.f963a;
        }

        public C0543f(LayoutParams layoutParams) {
            super(layoutParams);
            this.f963a = 0;
        }

        public C0543f(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f963a = 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.g */
    private class C0544g extends C0052a {
        final /* synthetic */ DrawerLayout f967a;
        private final int f968b;
        private ad f969c;
        private final Runnable f970d;

        private void m2252b() {
            int i = 3;
            if (this.f968b == 3) {
                i = 5;
            }
            View b = this.f967a.m2286b(i);
            if (b != null) {
                this.f967a.m2305i(b);
            }
        }

        public int m2253a(View view, int i, int i2) {
            return view.getTop();
        }

        public void m2254a() {
            this.f967a.removeCallbacks(this.f970d);
        }

        public void m2255a(int i) {
            this.f967a.m2279a(this.f968b, i, this.f969c.m2410c());
        }

        public void m2256a(int i, int i2) {
            this.f967a.postDelayed(this.f970d, 160);
        }

        public void m2257a(View view, float f, float f2) {
            int i;
            float d = this.f967a.m2296d(view);
            int width = view.getWidth();
            if (this.f967a.m2285a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                i = this.f967a.getWidth();
                if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                    i -= width;
                }
            }
            this.f969c.m2400a(i, view.getTop());
            this.f967a.invalidate();
        }

        public void m2258a(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = this.f967a.m2285a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.f967a.getWidth() - i)) / ((float) width);
            this.f967a.m2291b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            this.f967a.invalidate();
        }

        public boolean m2259a(View view, int i) {
            return this.f967a.m2303g(view) && this.f967a.m2285a(view, this.f968b) && this.f967a.m2276a(view) == 0;
        }

        public int m2260b(View view) {
            return this.f967a.m2303g(view) ? view.getWidth() : 0;
        }

        public int m2261b(View view, int i, int i2) {
            if (this.f967a.m2285a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f967a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public void m2262b(int i, int i2) {
            View b = (i & 1) == 1 ? this.f967a.m2286b(3) : this.f967a.m2286b(5);
            if (b != null && this.f967a.m2276a(b) == 0) {
                this.f969c.m2398a(b, i2);
            }
        }

        public void m2263b(View view, int i) {
            ((C0543f) view.getLayoutParams()).f965c = false;
            m2252b();
        }

        public boolean m2264b(int i) {
            return false;
        }
    }

    static {
        boolean z = true;
        f971a = new int[]{16842931};
        f972b = VERSION.SDK_INT >= 19;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f974d = z;
        if (VERSION.SDK_INT >= 21) {
            f973c = new C0541c();
        } else {
            f973c = new C0542d();
        }
    }

    private boolean m2265a(Drawable drawable, int i) {
        if (drawable == null || !C0242a.m856b(drawable)) {
            return false;
        }
        C0242a.m857b(drawable, i);
        return true;
    }

    static String m2266c(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private void m2267c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m2303g(childAt)) && !(z && childAt == view)) {
                aj.m1876c(childAt, 4);
            } else {
                aj.m1876c(childAt, 1);
            }
        }
    }

    private void m2268d() {
        if (!f974d) {
            this.f977C = m2269e();
            this.f978D = m2270f();
        }
    }

    private Drawable m2269e() {
        int g = aj.m1884g(this);
        if (g == 0) {
            if (this.f981G != null) {
                m2265a(this.f981G, g);
                return this.f981G;
            }
        } else if (this.f982H != null) {
            m2265a(this.f982H, g);
            return this.f982H;
        }
        return this.f983I;
    }

    private Drawable m2270f() {
        int g = aj.m1884g(this);
        if (g == 0) {
            if (this.f982H != null) {
                m2265a(this.f982H, g);
                return this.f982H;
            }
        } else if (this.f981G != null) {
            m2265a(this.f981G, g);
            return this.f981G;
        }
        return this.f984J;
    }

    private boolean m2271g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0543f) getChildAt(i).getLayoutParams()).f965c) {
                return true;
            }
        }
        return false;
    }

    private boolean m2272h() {
        return m2293c() != null;
    }

    static boolean m2273l(View view) {
        return (aj.m1878d(view) == 4 || aj.m1878d(view) == 2) ? false : true;
    }

    private static boolean m2274m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int m2275a(int i) {
        int g = aj.m1884g(this);
        switch (i) {
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                if (this.f999r != 3) {
                    return this.f999r;
                }
                g = g == 0 ? this.f1001t : this.f1002u;
                if (g != 3) {
                    return g;
                }
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                if (this.f1000s != 3) {
                    return this.f1000s;
                }
                g = g == 0 ? this.f1002u : this.f1001t;
                if (g != 3) {
                    return g;
                }
                break;
            case 8388611:
                if (this.f1001t != 3) {
                    return this.f1001t;
                }
                g = g == 0 ? this.f999r : this.f1000s;
                if (g != 3) {
                    return g;
                }
                break;
            case 8388613:
                if (this.f1002u != 3) {
                    return this.f1002u;
                }
                g = g == 0 ? this.f1000s : this.f999r;
                if (g != 3) {
                    return g;
                }
                break;
        }
        return 0;
    }

    public int m2276a(View view) {
        if (m2303g(view)) {
            return m2275a(((C0543f) view.getLayoutParams()).f963a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    View m2277a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0543f) childAt.getLayoutParams()).f966d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void m2278a(int i, int i2) {
        int a = C0500f.m2143a(i2, aj.m1884g(this));
        switch (i2) {
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.f999r = i;
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                this.f1000s = i;
                break;
            case 8388611:
                this.f1001t = i;
                break;
            case 8388613:
                this.f1002u = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.f992k : this.f993l).m2415e();
        }
        View b;
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                b = m2286b(a);
                if (b != null) {
                    m2305i(b);
                }
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                b = m2286b(a);
                if (b != null) {
                    m2304h(b);
                }
            default:
        }
    }

    void m2279a(int i, int i2, View view) {
        int a = this.f992k.m2397a();
        int a2 = this.f993l.m2397a();
        a = (a == 1 || a2 == 1) ? 1 : (a == 2 || a2 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            C0543f c0543f = (C0543f) view.getLayoutParams();
            if (c0543f.f964b == 0.0f) {
                m2290b(view);
            } else if (c0543f.f964b == 1.0f) {
                m2294c(view);
            }
        }
        if (a != this.f996o) {
            this.f996o = a;
            if (this.f1006y != null) {
                for (int size = this.f1006y.size() - 1; size >= 0; size--) {
                    ((C0170e) this.f1006y.get(size)).onDrawerStateChanged(a);
                }
            }
        }
    }

    public void m2280a(int i, boolean z) {
        View b = m2286b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2266c(i));
        }
        m2283a(b, z);
    }

    public void m2281a(C0170e c0170e) {
        if (c0170e != null) {
            if (this.f1006y == null) {
                this.f1006y = new ArrayList();
            }
            this.f1006y.add(c0170e);
        }
    }

    void m2282a(View view, float f) {
        if (this.f1006y != null) {
            for (int size = this.f1006y.size() - 1; size >= 0; size--) {
                ((C0170e) this.f1006y.get(size)).onDrawerSlide(view, f);
            }
        }
    }

    public void m2283a(View view, boolean z) {
        if (m2303g(view)) {
            C0543f c0543f = (C0543f) view.getLayoutParams();
            if (this.f998q) {
                c0543f.f964b = 1.0f;
                c0543f.f966d = 1;
                m2267c(view, true);
            } else if (z) {
                c0543f.f966d |= 2;
                if (m2285a(view, 3)) {
                    this.f992k.m2402a(view, 0, view.getTop());
                } else {
                    this.f993l.m2402a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                m2295c(view, 1.0f);
                m2279a(c0543f.f963a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    void m2284a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0543f c0543f = (C0543f) childAt.getLayoutParams();
            if (m2303g(childAt) && (!z || c0543f.f965c)) {
                i = m2285a(childAt, 3) ? i | this.f992k.m2402a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.f993l.m2402a(childAt, getWidth(), childAt.getTop());
                c0543f.f965c = false;
            }
        }
        this.f994m.m2254a();
        this.f995n.m2254a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean m2285a(View view, int i) {
        return (m2298e(view) & i) == i;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!m2303g(childAt)) {
                    this.f985K.add(childAt);
                } else if (m2306j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.f985K.size();
                while (i3 < i4) {
                    View view = (View) this.f985K.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.f985K.clear();
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m2277a() != null || m2303g(view)) {
            aj.m1876c(view, 4);
        } else {
            aj.m1876c(view, 1);
        }
        if (!f972b) {
            aj.m1861a(view, this.f986e);
        }
    }

    View m2286b(int i) {
        int a = C0500f.m2143a(i, aj.m1884g(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m2298e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    public void m2287b() {
        m2284a(false);
    }

    public void m2288b(int i, boolean z) {
        View b = m2286b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2266c(i));
        }
        m2292b(b, z);
    }

    public void m2289b(C0170e c0170e) {
        if (c0170e != null && this.f1006y != null) {
            this.f1006y.remove(c0170e);
        }
    }

    void m2290b(View view) {
        C0543f c0543f = (C0543f) view.getLayoutParams();
        if ((c0543f.f966d & 1) == 1) {
            c0543f.f966d = 0;
            if (this.f1006y != null) {
                for (int size = this.f1006y.size() - 1; size >= 0; size--) {
                    ((C0170e) this.f1006y.get(size)).onDrawerClosed(view);
                }
            }
            m2267c(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m2291b(View view, float f) {
        C0543f c0543f = (C0543f) view.getLayoutParams();
        if (f != c0543f.f964b) {
            c0543f.f964b = f;
            m2282a(view, f);
        }
    }

    public void m2292b(View view, boolean z) {
        if (m2303g(view)) {
            C0543f c0543f = (C0543f) view.getLayoutParams();
            if (this.f998q) {
                c0543f.f964b = 0.0f;
                c0543f.f966d = 0;
            } else if (z) {
                c0543f.f966d |= 4;
                if (m2285a(view, 3)) {
                    this.f992k.m2402a(view, -view.getWidth(), view.getTop());
                } else {
                    this.f993l.m2402a(view, getWidth(), view.getTop());
                }
            } else {
                m2295c(view, 0.0f);
                m2279a(c0543f.f963a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    View m2293c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2303g(childAt) && m2307k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void m2294c(View view) {
        C0543f c0543f = (C0543f) view.getLayoutParams();
        if ((c0543f.f966d & 1) == 0) {
            c0543f.f966d = 1;
            if (this.f1006y != null) {
                for (int size = this.f1006y.size() - 1; size >= 0; size--) {
                    ((C0170e) this.f1006y.get(size)).onDrawerOpened(view);
                }
            }
            m2267c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void m2295c(View view, float f) {
        float d = m2296d(view);
        int width = view.getWidth();
        int i = ((int) (((float) width) * f)) - ((int) (d * ((float) width)));
        if (!m2285a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m2291b(view, f);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0543f) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0543f) getChildAt(i).getLayoutParams()).f964b);
        }
        this.f990i = f;
        if ((this.f992k.m2403a(true) | this.f993l.m2403a(true)) != 0) {
            aj.m1874c(this);
        }
    }

    float m2296d(View view) {
        return ((C0543f) view.getLayoutParams()).f964b;
    }

    public void m2297d(int i) {
        m2280a(i, true);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m2301f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m2274m(childAt) && m2303g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m2285a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f990i > 0.0f && f) {
            this.f991j.setColor((((int) (((float) ((this.f989h & -16777216) >>> 24)) * this.f990i)) << 24) | (this.f989h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f991j);
        } else if (this.f977C != null && m2285a(view, 3)) {
            i = this.f977C.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f992k.m2404b()), 1.0f));
            this.f977C.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f977C.setAlpha((int) (255.0f * r2));
            this.f977C.draw(canvas);
        } else if (this.f978D != null && m2285a(view, 5)) {
            i = this.f978D.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f993l.m2404b()), 1.0f));
            this.f978D.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f978D.setAlpha((int) (255.0f * r2));
            this.f978D.draw(canvas);
        }
        return drawChild;
    }

    int m2298e(View view) {
        return C0500f.m2143a(((C0543f) view.getLayoutParams()).f963a, aj.m1884g(this));
    }

    public void m2299e(int i) {
        m2288b(i, true);
    }

    public boolean m2300f(int i) {
        View b = m2286b(i);
        return b != null ? m2306j(b) : false;
    }

    boolean m2301f(View view) {
        return ((C0543f) view.getLayoutParams()).f963a == 0;
    }

    public boolean m2302g(int i) {
        View b = m2286b(i);
        return b != null ? m2307k(b) : false;
    }

    boolean m2303g(View view) {
        int a = C0500f.m2143a(((C0543f) view.getLayoutParams()).f963a, aj.m1884g(view));
        return (a & 3) != 0 ? true : (a & 5) != 0;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0543f(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0543f(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0543f ? new C0543f((C0543f) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0543f((MarginLayoutParams) layoutParams) : new C0543f(layoutParams);
    }

    public float getDrawerElevation() {
        return f974d ? this.f987f : 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f976B;
    }

    public void m2304h(View view) {
        m2283a(view, true);
    }

    public void m2305i(View view) {
        m2292b(view, true);
    }

    public boolean m2306j(View view) {
        if (m2303g(view)) {
            return (((C0543f) view.getLayoutParams()).f966d & 1) == 1;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean m2307k(View view) {
        if (m2303g(view)) {
            return ((C0543f) view.getLayoutParams()).f964b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f998q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f998q = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f980F && this.f976B != null) {
            int a = f973c.m2243a(this.f979E);
            if (a > 0) {
                this.f976B.setBounds(0, 0, getWidth(), a);
                this.f976B.draw(canvas);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.C0534t.m2226a(r8);
        r3 = r7.f992k;
        r3 = r3.m2401a(r8);
        r4 = r7.f993l;
        r4 = r4.m2401a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m2271g();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f1004w;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f1007z = r0;
        r7.f975A = r4;
        r5 = r7.f990i;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.f992k;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m2414d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.m2301f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.f1003v = r2;
        r7.f1004w = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.f992k;
        r4 = 3;
        r0 = r0.m2411c(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.f994m;
        r0.m2254a();
        r0 = r7.f995n;
        r0.m2254a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m2284a(r1);
        r7.f1003v = r2;
        r7.f1004w = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2272h()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View c = m2293c();
        if (c != null && m2276a(c) == 0) {
            m2287b();
        }
        return c != null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f997p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0543f c0543f = (C0543f) childAt.getLayoutParams();
                if (m2301f(childAt)) {
                    childAt.layout(c0543f.leftMargin, c0543f.topMargin, c0543f.leftMargin + childAt.getMeasuredWidth(), c0543f.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2285a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * c0543f.f964b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * c0543f.f964b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != c0543f.f964b ? 1 : null;
                    int i8;
                    switch (c0543f.f963a & C0861R.styleable.AppCompatTheme_spinnerStyle) {
                        case C1096c.MapAttrs_ambientEnabled /*16*/:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < c0543f.topMargin) {
                                i8 = c0543f.topMargin;
                            } else if (i8 + measuredHeight > i9 - c0543f.bottomMargin) {
                                i8 = (i9 - c0543f.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - c0543f.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - c0543f.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, c0543f.topMargin, measuredWidth + i7, measuredHeight + c0543f.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m2291b(childAt, f);
                    }
                    int i10 = c0543f.f964b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f997p = false;
        this.f998q = false;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int g;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int a;
        int e;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != RtlSpacingHelper.UNDEFINED && mode == 0) {
                    size = 300;
                }
                if (mode2 == RtlSpacingHelper.UNDEFINED) {
                    mode = size;
                    size = size2;
                } else if (mode2 == 0) {
                    mode = size;
                    size = 300;
                }
                setMeasuredDimension(mode, size);
                obj = (this.f979E == null && aj.m1899v(this)) ? 1 : null;
                g = aj.m1884g(this);
                obj2 = null;
                obj3 = null;
                childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 8) {
                        marginLayoutParams = (C0543f) childAt.getLayoutParams();
                        if (obj != null) {
                            a = C0500f.m2143a(marginLayoutParams.f963a, g);
                            if (aj.m1899v(childAt)) {
                                f973c.m2245a(marginLayoutParams, this.f979E, a);
                            } else {
                                f973c.m2244a(childAt, this.f979E, a);
                            }
                        }
                        if (m2301f(childAt)) {
                            childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                        } else if (m2303g(childAt)) {
                            throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                        } else {
                            if (f974d && aj.m1895r(childAt) != this.f987f) {
                                aj.m1879d(childAt, this.f987f);
                            }
                            e = m2298e(childAt) & 7;
                            obj4 = e != 3 ? 1 : null;
                            if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                if (obj4 == null) {
                                    obj2 = 1;
                                } else {
                                    obj3 = 1;
                                }
                                childAt.measure(getChildMeasureSpec(i, (this.f988g + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                            } else {
                                throw new IllegalStateException("Child drawer has absolute gravity " + m2266c(e) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.f979E == null) {
        }
        g = aj.m1884g(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                marginLayoutParams = (C0543f) childAt.getLayoutParams();
                if (obj != null) {
                    a = C0500f.m2143a(marginLayoutParams.f963a, g);
                    if (aj.m1899v(childAt)) {
                        f973c.m2245a(marginLayoutParams, this.f979E, a);
                    } else {
                        f973c.m2244a(childAt, this.f979E, a);
                    }
                }
                if (m2301f(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (m2303g(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    aj.m1879d(childAt, this.f987f);
                    e = m2298e(childAt) & 7;
                    if (e != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.f988g + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.f958a != 0) {
                View b = m2286b(savedState.f958a);
                if (b != null) {
                    m2304h(b);
                }
            }
            if (savedState.f959b != 3) {
                m2278a(savedState.f959b, 3);
            }
            if (savedState.f960c != 3) {
                m2278a(savedState.f960c, 5);
            }
            if (savedState.f961d != 3) {
                m2278a(savedState.f961d, 8388611);
            }
            if (savedState.f962e != 3) {
                m2278a(savedState.f962e, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        m2268d();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0543f c0543f = (C0543f) getChildAt(i).getLayoutParams();
            Object obj = c0543f.f966d == 1 ? 1 : null;
            Object obj2 = c0543f.f966d == 2 ? 1 : null;
            if (obj != null || obj2 != null) {
                savedState.f958a = c0543f.f963a;
                break;
            }
        }
        savedState.f959b = this.f999r;
        savedState.f960c = this.f1000s;
        savedState.f961d = this.f1001t;
        savedState.f962e = this.f1002u;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f992k.m2406b(motionEvent);
        this.f993l.m2406b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f1007z = x;
                this.f975A = y;
                this.f1003v = false;
                this.f1004w = false;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f992k.m2414d((int) x, (int) y);
                if (d != null && m2301f(d)) {
                    x -= this.f1007z;
                    y -= this.f975A;
                    int d2 = this.f992k.m2413d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m2277a();
                        if (a != null) {
                            z = m2276a(a) == 2;
                            m2284a(z);
                            this.f1003v = false;
                            break;
                        }
                    }
                }
                z = true;
                m2284a(z);
                this.f1003v = false;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                m2284a(true);
                this.f1003v = false;
                this.f1004w = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1003v = z;
        if (z) {
            m2284a(true);
        }
    }

    public void requestLayout() {
        if (!this.f997p) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f) {
        this.f987f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m2303g(childAt)) {
                aj.m1879d(childAt, this.f987f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(C0170e c0170e) {
        if (this.f1005x != null) {
            m2289b(this.f1005x);
        }
        if (c0170e != null) {
            m2281a(c0170e);
        }
        this.f1005x = c0170e;
    }

    public void setDrawerLockMode(int i) {
        m2278a(i, 3);
        m2278a(i, 5);
    }

    public void setScrimColor(int i) {
        this.f989h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f976B = i != 0 ? C0173a.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f976B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f976B = new ColorDrawable(i);
        invalidate();
    }
}
