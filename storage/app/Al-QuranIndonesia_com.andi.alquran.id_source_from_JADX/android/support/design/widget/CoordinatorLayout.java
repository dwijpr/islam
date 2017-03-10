package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0035a.C0033h;
import android.support.design.C0035a.C0034i;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;
import android.support.v4.p009b.C0173a;
import android.support.v4.p014g.C0313i.C0310a;
import android.support.v4.p014g.C0313i.C0312c;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0058z;
import android.support.v4.view.C0066x;
import android.support.v4.view.C0500f;
import android.support.v4.view.C0534t;
import android.support.v4.view.C0537y;
import android.support.v4.view.aj;
import android.support.v4.view.bf;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0066x {
    static final String f232a;
    static final Class<?>[] f233b;
    static final ThreadLocal<Map<String, Constructor<C0046a>>> f234c;
    static final Comparator<View> f235d;
    private static final C0310a<Rect> f236f;
    OnHierarchyChangeListener f237e;
    private final List<View> f238g;
    private final C0112e<View> f239h;
    private final List<View> f240i;
    private final List<View> f241j;
    private final int[] f242k;
    private Paint f243l;
    private boolean f244m;
    private boolean f245n;
    private int[] f246o;
    private View f247p;
    private View f248q;
    private View f249r;
    private C0064e f250s;
    private boolean f251t;
    private bf f252u;
    private boolean f253v;
    private Drawable f254w;
    private C0058z f255x;
    private final C0537y f256y;

    /* renamed from: android.support.design.widget.CoordinatorLayout.a */
    public static abstract class C0046a<V extends View> {
        public C0046a(Context context, AttributeSet attributeSet) {
        }

        public bf m98a(CoordinatorLayout coordinatorLayout, V v, bf bfVar) {
            return bfVar;
        }

        public void m99a(C0063d c0063d) {
        }

        public void m100a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void m101a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void m102a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void m103a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean m104a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean m105a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean m106a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean m107a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean m108a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean m109a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean m110a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean m111a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public Parcelable m112b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public void m113b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean m114b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean m115b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int m116c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public void m117c() {
        }

        public boolean m118c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public float m119d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void m120d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean m121e(CoordinatorLayout coordinatorLayout, V v) {
            return m119d(coordinatorLayout, v) > 0.0f;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.1 */
    class C00591 implements C0058z {
        final /* synthetic */ CoordinatorLayout f211a;

        C00591(CoordinatorLayout coordinatorLayout) {
            this.f211a = coordinatorLayout;
        }

        public bf onApplyWindowInsets(View view, bf bfVar) {
            return this.f211a.m310a(bfVar);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        SparseArray<Parcelable> f212a;

        /* renamed from: android.support.design.widget.CoordinatorLayout.SavedState.1 */
        static class C00601 implements C0043e<SavedState> {
            C00601() {
            }

            public SavedState m261a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m262a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m261a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m262a(i);
            }
        }

        static {
            CREATOR = C0267d.m910a(new C00601());
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f212a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f212a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f212a != null ? this.f212a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f212a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f212a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout.b */
    public @interface C0061b {
        Class<? extends C0046a> m263a();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.c */
    private class C0062c implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f213a;

        C0062c(CoordinatorLayout coordinatorLayout) {
            this.f213a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f213a.f237e != null) {
                this.f213a.f237e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f213a.m312a(2);
            if (this.f213a.f237e != null) {
                this.f213a.f237e.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.d */
    public static class C0063d extends MarginLayoutParams {
        C0046a f214a;
        boolean f215b;
        public int f216c;
        public int f217d;
        public int f218e;
        int f219f;
        public int f220g;
        public int f221h;
        int f222i;
        int f223j;
        View f224k;
        View f225l;
        final Rect f226m;
        Object f227n;
        private boolean f228o;
        private boolean f229p;
        private boolean f230q;

        public C0063d(int i, int i2) {
            super(i, i2);
            this.f215b = false;
            this.f216c = 0;
            this.f217d = 0;
            this.f218e = -1;
            this.f219f = -1;
            this.f220g = 0;
            this.f221h = 0;
            this.f226m = new Rect();
        }

        C0063d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f215b = false;
            this.f216c = 0;
            this.f217d = 0;
            this.f218e = -1;
            this.f219f = -1;
            this.f220g = 0;
            this.f221h = 0;
            this.f226m = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.CoordinatorLayout_Layout);
            this.f216c = obtainStyledAttributes.getInteger(C0034i.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f219f = obtainStyledAttributes.getResourceId(C0034i.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f217d = obtainStyledAttributes.getInteger(C0034i.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f218e = obtainStyledAttributes.getInteger(C0034i.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f220g = obtainStyledAttributes.getInt(C0034i.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f221h = obtainStyledAttributes.getInt(C0034i.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f215b = obtainStyledAttributes.hasValue(C0034i.CoordinatorLayout_Layout_layout_behavior);
            if (this.f215b) {
                this.f214a = CoordinatorLayout.m285a(context, attributeSet, obtainStyledAttributes.getString(C0034i.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f214a != null) {
                this.f214a.m99a(this);
            }
        }

        public C0063d(C0063d c0063d) {
            super(c0063d);
            this.f215b = false;
            this.f216c = 0;
            this.f217d = 0;
            this.f218e = -1;
            this.f219f = -1;
            this.f220g = 0;
            this.f221h = 0;
            this.f226m = new Rect();
        }

        public C0063d(LayoutParams layoutParams) {
            super(layoutParams);
            this.f215b = false;
            this.f216c = 0;
            this.f217d = 0;
            this.f218e = -1;
            this.f219f = -1;
            this.f220g = 0;
            this.f221h = 0;
            this.f226m = new Rect();
        }

        public C0063d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f215b = false;
            this.f216c = 0;
            this.f217d = 0;
            this.f218e = -1;
            this.f219f = -1;
            this.f220g = 0;
            this.f221h = 0;
            this.f226m = new Rect();
        }

        private void m264a(View view, CoordinatorLayout coordinatorLayout) {
            this.f224k = coordinatorLayout.findViewById(this.f219f);
            if (this.f224k != null) {
                if (this.f224k != coordinatorLayout) {
                    View view2 = this.f224k;
                    View parent = this.f224k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f225l = null;
                            this.f224k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f225l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f225l = null;
                    this.f224k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f225l = null;
                this.f224k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f219f) + " to anchor view " + view);
            }
        }

        private boolean m265a(View view, int i) {
            int a = C0500f.m2143a(((C0063d) view.getLayoutParams()).f220g, i);
            return a != 0 && (C0500f.m2143a(this.f221h, i) & a) == a;
        }

        private boolean m266b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f224k.getId() != this.f219f) {
                return false;
            }
            View view2 = this.f224k;
            View parent = this.f224k.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f225l = null;
                    this.f224k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f225l = view2;
            return true;
        }

        public int m267a() {
            return this.f219f;
        }

        void m268a(Rect rect) {
            this.f226m.set(rect);
        }

        public void m269a(C0046a c0046a) {
            if (this.f214a != c0046a) {
                if (this.f214a != null) {
                    this.f214a.m117c();
                }
                this.f214a = c0046a;
                this.f227n = null;
                this.f215b = true;
                if (c0046a != null) {
                    c0046a.m99a(this);
                }
            }
        }

        void m270a(boolean z) {
            this.f229p = z;
        }

        boolean m271a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f228o) {
                return true;
            }
            boolean e = (this.f214a != null ? this.f214a.m121e(coordinatorLayout, view) : 0) | this.f228o;
            this.f228o = e;
            return e;
        }

        boolean m272a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f225l || m265a(view2, aj.m1884g(coordinatorLayout)) || (this.f214a != null && this.f214a.m115b(coordinatorLayout, view, view2));
        }

        public C0046a m273b() {
            return this.f214a;
        }

        View m274b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f219f == -1) {
                this.f225l = null;
                this.f224k = null;
                return null;
            }
            if (this.f224k == null || !m266b(view, coordinatorLayout)) {
                m264a(view, coordinatorLayout);
            }
            return this.f224k;
        }

        void m275b(boolean z) {
            this.f230q = z;
        }

        Rect m276c() {
            return this.f226m;
        }

        boolean m277d() {
            return this.f224k == null && this.f219f != -1;
        }

        boolean m278e() {
            if (this.f214a == null) {
                this.f228o = false;
            }
            return this.f228o;
        }

        void m279f() {
            this.f228o = false;
        }

        void m280g() {
            this.f229p = false;
        }

        boolean m281h() {
            return this.f229p;
        }

        boolean m282i() {
            return this.f230q;
        }

        void m283j() {
            this.f230q = false;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.e */
    class C0064e implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f231a;

        C0064e(CoordinatorLayout coordinatorLayout) {
            this.f231a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f231a.m312a(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.f */
    static class C0065f implements Comparator<View> {
        C0065f() {
        }

        public int m284a(View view, View view2) {
            float D = aj.m1847D(view);
            float D2 = aj.m1847D(view2);
            return D > D2 ? -1 : D < D2 ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m284a((View) obj, (View) obj2);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f232a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f235d = new C0065f();
        } else {
            f235d = null;
        }
        f233b = new Class[]{Context.class, AttributeSet.class};
        f234c = new ThreadLocal();
        f236f = new C0312c(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f238g = new ArrayList();
        this.f239h = new C0112e();
        this.f240i = new ArrayList();
        this.f241j = new ArrayList();
        this.f242k = new int[2];
        this.f256y = new C0537y(this);
        C0137r.m606a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.CoordinatorLayout, i, C0033h.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0034i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f246o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f246o.length;
            while (i2 < length) {
                int[] iArr = this.f246o;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f254w = obtainStyledAttributes.getDrawable(C0034i.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        m306h();
        super.setOnHierarchyChangeListener(new C0062c(this));
    }

    static C0046a m285a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f232a)) {
            str = f232a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f234c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f234c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f233b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0046a) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static void m286a(Rect rect) {
        rect.setEmpty();
        f236f.m1030a(rect);
    }

    private void m287a(C0063d c0063d, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + c0063d.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c0063d.rightMargin));
        height = Math.max(getPaddingTop() + c0063d.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c0063d.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    private void m288a(View view, int i, Rect rect, Rect rect2, C0063d c0063d, int i2, int i3) {
        int a = C0500f.m2143a(m300e(c0063d.f216c), i);
        int a2 = C0500f.m2143a(m296c(c0063d.f217d), i);
        int i4 = a & 7;
        int i5 = a & C0861R.styleable.AppCompatTheme_spinnerStyle;
        int i6 = a2 & C0861R.styleable.AppCompatTheme_spinnerStyle;
        switch (a2 & 7) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i6) {
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                a = rect.top + (rect.height() / 2);
                break;
            case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i4) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                a2 -= i2 / 2;
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                break;
            default:
                a2 -= i2;
                break;
        }
        switch (i5) {
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                a -= i3 / 2;
                break;
            case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                break;
            default:
                a -= i3;
                break;
        }
        rect2.set(a2, a, a2 + i2, a + i3);
    }

    private void m289a(View view, Rect rect, int i) {
        if (aj.m1846C(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0063d c0063d = (C0063d) view.getLayoutParams();
            C0046a b = c0063d.m273b();
            Rect e = m301e();
            Rect e2 = m301e();
            e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b == null || !b.m106a(this, view, e)) {
                e.set(e2);
            } else if (!e2.contains(e)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e.toShortString() + " | Bounds:" + e2.toShortString());
            }
            m286a(e2);
            if (e.isEmpty()) {
                m286a(e);
                return;
            }
            int i2;
            int height;
            int width;
            int a = C0500f.m2143a(c0063d.f221h, i);
            if ((a & 48) == 48) {
                i2 = (e.top - c0063d.topMargin) - c0063d.f223j;
                if (i2 < rect.top) {
                    m302e(view, rect.top - i2);
                    i2 = 1;
                    if ((a & 80) == 80) {
                        height = ((getHeight() - e.bottom) - c0063d.bottomMargin) + c0063d.f223j;
                        if (height < rect.bottom) {
                            m302e(view, height - rect.bottom);
                            i2 = 1;
                        }
                    }
                    if (i2 == 0) {
                        m302e(view, 0);
                    }
                    if ((a & 3) == 3) {
                        i2 = (e.left - c0063d.leftMargin) - c0063d.f222i;
                        if (i2 < rect.left) {
                            m299d(view, rect.left - i2);
                            i2 = 1;
                            if ((a & 5) == 5) {
                                width = c0063d.f222i + ((getWidth() - e.right) - c0063d.rightMargin);
                                if (width < rect.right) {
                                    m299d(view, width - rect.right);
                                    width = 1;
                                    if (width == 0) {
                                        m299d(view, 0);
                                    }
                                    m286a(e);
                                }
                            }
                            width = i2;
                            if (width == 0) {
                                m299d(view, 0);
                            }
                            m286a(e);
                        }
                    }
                    i2 = 0;
                    if ((a & 5) == 5) {
                        width = c0063d.f222i + ((getWidth() - e.right) - c0063d.rightMargin);
                        if (width < rect.right) {
                            m299d(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m299d(view, 0);
                            }
                            m286a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m299d(view, 0);
                    }
                    m286a(e);
                }
            }
            i2 = 0;
            if ((a & 80) == 80) {
                height = ((getHeight() - e.bottom) - c0063d.bottomMargin) + c0063d.f223j;
                if (height < rect.bottom) {
                    m302e(view, height - rect.bottom);
                    i2 = 1;
                }
            }
            if (i2 == 0) {
                m302e(view, 0);
            }
            if ((a & 3) == 3) {
                i2 = (e.left - c0063d.leftMargin) - c0063d.f222i;
                if (i2 < rect.left) {
                    m299d(view, rect.left - i2);
                    i2 = 1;
                    if ((a & 5) == 5) {
                        width = c0063d.f222i + ((getWidth() - e.right) - c0063d.rightMargin);
                        if (width < rect.right) {
                            m299d(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m299d(view, 0);
                            }
                            m286a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m299d(view, 0);
                    }
                    m286a(e);
                }
            }
            i2 = 0;
            if ((a & 5) == 5) {
                width = c0063d.f222i + ((getWidth() - e.right) - c0063d.rightMargin);
                if (width < rect.right) {
                    m299d(view, width - rect.right);
                    width = 1;
                    if (width == 0) {
                        m299d(view, 0);
                    }
                    m286a(e);
                }
            }
            width = i2;
            if (width == 0) {
                m299d(view, 0);
            }
            m286a(e);
        }
    }

    private void m290a(View view, View view2, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        Rect e = m301e();
        Rect e2 = m301e();
        try {
            m316a(view2, e);
            m315a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            m286a(e);
            m286a(e2);
        }
    }

    private void m291a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f235d != null) {
            Collections.sort(list, f235d);
        }
    }

    private boolean m292a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = C0534t.m2226a(motionEvent);
        List list = this.f240i;
        m291a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0063d c0063d = (C0063d) view.getLayoutParams();
            C0046a b = c0063d.m273b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case GoogleMap.MAP_TYPE_NONE /*0*/:
                            z2 = b.m108a(this, view, motionEvent);
                            break;
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            z2 = b.m114b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f247p = view;
                    }
                }
                z = z2;
                boolean e = c0063d.m278e();
                boolean a2 = c0063d.m271a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        b.m108a(this, view, motionEvent3);
                        break;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        b.m114b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private int m293b(int i) {
        if (this.f246o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f246o.length) {
            return this.f246o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private bf m294b(bf bfVar) {
        if (bfVar.m2117e()) {
            return bfVar;
        }
        bf a;
        int childCount = getChildCount();
        int i = 0;
        bf bfVar2 = bfVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (aj.m1899v(childAt)) {
                C0046a b = ((C0063d) childAt.getLayoutParams()).m273b();
                if (b != null) {
                    a = b.m98a(this, childAt, bfVar2);
                    if (a.m2117e()) {
                        break;
                    }
                    i++;
                    bfVar2 = a;
                }
            }
            a = bfVar2;
            i++;
            bfVar2 = a;
        }
        a = bfVar2;
        return a;
    }

    private void m295b(View view, int i, int i2) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        int a = C0500f.m2143a(m298d(c0063d.f216c), i2);
        int i3 = a & 7;
        int i4 = a & C0861R.styleable.AppCompatTheme_spinnerStyle;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = m293b(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                b += measuredWidth / 2;
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                b += measuredWidth;
                break;
        }
        switch (i4) {
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                a = 0 + (measuredHeight / 2);
                break;
            case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                a = 0 + measuredHeight;
                break;
        }
        b = Math.max(getPaddingLeft() + c0063d.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - c0063d.rightMargin));
        int max = Math.max(getPaddingTop() + c0063d.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0063d.bottomMargin));
        view.layout(b, max, b + measuredWidth, max + measuredHeight);
    }

    private static int m296c(int i) {
        return i == 0 ? 8388659 : i;
    }

    private void m297c(View view, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        Rect e = m301e();
        e.set(getPaddingLeft() + c0063d.leftMargin, getPaddingTop() + c0063d.topMargin, (getWidth() - getPaddingRight()) - c0063d.rightMargin, (getHeight() - getPaddingBottom()) - c0063d.bottomMargin);
        if (!(this.f252u == null || !aj.m1899v(this) || aj.m1899v(view))) {
            e.left += this.f252u.m2112a();
            e.top += this.f252u.m2114b();
            e.right -= this.f252u.m2115c();
            e.bottom -= this.f252u.m2116d();
        }
        Rect e2 = m301e();
        C0500f.m2144a(m296c(c0063d.f216c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        m286a(e);
        m286a(e2);
    }

    private static int m298d(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m299d(View view, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (c0063d.f222i != i) {
            aj.m1882e(view, i - c0063d.f222i);
            c0063d.f222i = i;
        }
    }

    private static int m300e(int i) {
        return i == 0 ? 17 : i;
    }

    private static Rect m301e() {
        Rect rect = (Rect) f236f.m1029a();
        return rect == null ? new Rect() : rect;
    }

    private void m302e(View view, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (c0063d.f223j != i) {
            aj.m1880d(view, i - c0063d.f223j);
            c0063d.f223j = i;
        }
    }

    private boolean m303e(View view) {
        return this.f239h.m515e(view);
    }

    private void m304f() {
        if (this.f247p != null) {
            C0046a b = ((C0063d) this.f247p.getLayoutParams()).m273b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.m114b(this, this.f247p, obtain);
                obtain.recycle();
            }
            this.f247p = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0063d) getChildAt(i).getLayoutParams()).m279f();
        }
        this.f244m = false;
    }

    private void m305g() {
        this.f238g.clear();
        this.f239h.m508a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            m308a((View) childAt).m274b(this, (View) childAt);
            this.f239h.m509a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (m308a((View) childAt2).m272a(this, childAt2, childAt)) {
                        if (!this.f239h.m512b(childAt2)) {
                            this.f239h.m509a(childAt2);
                        }
                        this.f239h.m510a(childAt, childAt2);
                    }
                }
            }
        }
        this.f238g.addAll(this.f239h.m511b());
        Collections.reverse(this.f238g);
    }

    private void m306h() {
        if (VERSION.SDK_INT >= 21) {
            if (aj.m1899v(this)) {
                if (this.f255x == null) {
                    this.f255x = new C00591(this);
                }
                aj.m1863a((View) this, this.f255x);
                setSystemUiVisibility(1280);
                return;
            }
            aj.m1863a((View) this, null);
        }
    }

    public C0063d m307a(AttributeSet attributeSet) {
        return new C0063d(getContext(), attributeSet);
    }

    C0063d m308a(View view) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (!c0063d.f215b) {
            C0061b c0061b = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0061b = (C0061b) cls.getAnnotation(C0061b.class);
                if (c0061b != null) {
                    break;
                }
            }
            C0061b c0061b2 = c0061b;
            if (c0061b2 != null) {
                try {
                    c0063d.m269a((C0046a) c0061b2.m263a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0061b2.m263a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0063d.f215b = true;
        }
        return c0063d;
    }

    protected C0063d m309a(LayoutParams layoutParams) {
        return layoutParams instanceof C0063d ? new C0063d((C0063d) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0063d((MarginLayoutParams) layoutParams) : new C0063d(layoutParams);
    }

    final bf m310a(bf bfVar) {
        boolean z = true;
        if (C0157z.m688a(this.f252u, bfVar)) {
            return bfVar;
        }
        this.f252u = bfVar;
        boolean z2 = bfVar != null && bfVar.m2114b() > 0;
        this.f253v = z2;
        if (this.f253v || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        bfVar = m294b(bfVar);
        requestLayout();
        return bfVar;
    }

    void m311a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m303e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f251t) {
            return;
        }
        if (z) {
            m319b();
        } else {
            m324c();
        }
    }

    final void m312a(int i) {
        int g = aj.m1884g(this);
        int size = this.f238g.size();
        Rect e = m301e();
        Rect e2 = m301e();
        Rect e3 = m301e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f238g.get(i2);
            C0063d c0063d = (C0063d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = 0; i3 < i2; i3++) {
                    if (c0063d.f225l == ((View) this.f238g.get(i3))) {
                        m321b(view, g);
                    }
                }
                m317a(view, true, e2);
                if (!(c0063d.f220g == 0 || e2.isEmpty())) {
                    int a = C0500f.m2143a(c0063d.f220g, g);
                    switch (a & C0861R.styleable.AppCompatTheme_spinnerStyle) {
                        case C0861R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            e.top = Math.max(e.top, e2.bottom);
                            break;
                        case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            e.bottom = Math.max(e.bottom, getHeight() - e2.top);
                            break;
                    }
                    switch (a & 7) {
                        case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            e.left = Math.max(e.left, e2.right);
                            break;
                        case C1096c.MapAttrs_cameraZoom /*5*/:
                            e.right = Math.max(e.right, getWidth() - e2.left);
                            break;
                    }
                }
                if (c0063d.f221h != 0 && view.getVisibility() == 0) {
                    m289a(view, e, g);
                }
                if (i == 0) {
                    m325c(view, e3);
                    if (!e3.equals(e2)) {
                        m322b(view, e2);
                    }
                }
                for (i3 = i2 + 1; i3 < size; i3++) {
                    View view2 = (View) this.f238g.get(i3);
                    C0063d c0063d2 = (C0063d) view2.getLayoutParams();
                    C0046a b = c0063d2.m273b();
                    if (b != null && b.m115b(this, view2, view)) {
                        if (i == 0 && c0063d2.m282i()) {
                            c0063d2.m283j();
                        } else {
                            boolean z;
                            switch (i) {
                                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                                    b.m120d(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = b.m118c(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                c0063d2.m275b(z);
                            }
                        }
                    }
                }
            }
        }
        m286a(e);
        m286a(e2);
        m286a(e3);
    }

    public void m313a(View view, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (c0063d.m277d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0063d.f224k != null) {
            m290a(view, c0063d.f224k, i);
        } else if (c0063d.f218e >= 0) {
            m295b(view, c0063d.f218e, i);
        } else {
            m297c(view, i);
        }
    }

    public void m314a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m315a(View view, int i, Rect rect, Rect rect2) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m288a(view, i, rect, rect2, c0063d, measuredWidth, measuredHeight);
        m287a(c0063d, rect2, measuredWidth, measuredHeight);
    }

    void m316a(View view, Rect rect) {
        C0153v.m678b(this, view, rect);
    }

    void m317a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m316a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean m318a(View view, int i, int i2) {
        Rect e = m301e();
        m316a(view, e);
        try {
            boolean contains = e.contains(i, i2);
            return contains;
        } finally {
            m286a(e);
        }
    }

    void m319b() {
        if (this.f245n) {
            if (this.f250s == null) {
                this.f250s = new C0064e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f250s);
        }
        this.f251t = true;
    }

    public void m320b(View view) {
        List c = this.f239h.m513c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                C0046a b = ((C0063d) view2.getLayoutParams()).m273b();
                if (b != null) {
                    b.m118c(this, view2, view);
                }
            }
        }
    }

    void m321b(View view, int i) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (c0063d.f224k != null) {
            Rect e = m301e();
            Rect e2 = m301e();
            Rect e3 = m301e();
            m316a(c0063d.f224k, e);
            m317a(view, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m288a(view, i, e, e3, c0063d, measuredWidth, measuredHeight);
            boolean z = (e3.left == e2.left && e3.top == e2.top) ? false : true;
            m287a(c0063d, e3, measuredWidth, measuredHeight);
            int i2 = e3.left - e2.left;
            int i3 = e3.top - e2.top;
            if (i2 != 0) {
                aj.m1882e(view, i2);
            }
            if (i3 != 0) {
                aj.m1880d(view, i3);
            }
            if (z) {
                C0046a b = c0063d.m273b();
                if (b != null) {
                    b.m118c(this, view, c0063d.f224k);
                }
            }
            m286a(e);
            m286a(e2);
            m286a(e3);
        }
    }

    void m322b(View view, Rect rect) {
        ((C0063d) view.getLayoutParams()).m268a(rect);
    }

    public List<View> m323c(View view) {
        Collection d = this.f239h.m514d(view);
        this.f241j.clear();
        if (d != null) {
            this.f241j.addAll(d);
        }
        return this.f241j;
    }

    void m324c() {
        if (this.f245n && this.f250s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f250s);
        }
        this.f251t = false;
    }

    void m325c(View view, Rect rect) {
        rect.set(((C0063d) view.getLayoutParams()).m276c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0063d) && super.checkLayoutParams(layoutParams);
    }

    protected C0063d m326d() {
        return new C0063d(-2, -2);
    }

    public List<View> m327d(View view) {
        Collection c = this.f239h.m513c(view);
        this.f241j.clear();
        if (c != null) {
            this.f241j.addAll(c);
        }
        return this.f241j;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0063d c0063d = (C0063d) view.getLayoutParams();
        if (c0063d.f214a != null) {
            float d = c0063d.f214a.m119d(this, view);
            if (d > 0.0f) {
                if (this.f243l == null) {
                    this.f243l = new Paint();
                }
                this.f243l.setColor(c0063d.f214a.m116c(this, view));
                this.f243l.setAlpha(C0127l.m573a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f243l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f254w;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m326d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m307a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m309a(layoutParams);
    }

    final List<View> getDependencySortedChildren() {
        m305g();
        return Collections.unmodifiableList(this.f238g);
    }

    final bf getLastWindowInsets() {
        return this.f252u;
    }

    public int getNestedScrollAxes() {
        return this.f256y.m2238a();
    }

    public Drawable getStatusBarBackground() {
        return this.f254w;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m304f();
        if (this.f251t) {
            if (this.f250s == null) {
                this.f250s = new C0064e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f250s);
        }
        if (this.f252u == null && aj.m1899v(this)) {
            aj.m1898u(this);
        }
        this.f245n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m304f();
        if (this.f251t && this.f250s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f250s);
        }
        if (this.f249r != null) {
            onStopNestedScroll(this.f249r);
        }
        this.f245n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f253v && this.f254w != null) {
            int b = this.f252u != null ? this.f252u.m2114b() : 0;
            if (b > 0) {
                this.f254w.setBounds(0, 0, getWidth(), b);
                this.f254w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = C0534t.m2226a(motionEvent);
        if (a == 0) {
            m304f();
        }
        boolean a2 = m292a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m304f();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int g = aj.m1884g(this);
        int size = this.f238g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f238g.get(i5);
            if (view.getVisibility() != 8) {
                C0046a b = ((C0063d) view.getLayoutParams()).m273b();
                if (b == null || !b.m104a(this, view, g)) {
                    m313a(view, g);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m305g();
        m311a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int g = aj.m1884g(this);
        Object obj = g == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = 0;
        Object obj2 = (this.f252u == null || !aj.m1899v(this)) ? null : 1;
        int size3 = this.f238g.size();
        int i6 = 0;
        while (i6 < size3) {
            int i7;
            View view = (View) this.f238g.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                C0063d c0063d = (C0063d) view.getLayoutParams();
                int i10 = 0;
                if (c0063d.f218e >= 0 && mode != 0) {
                    i7 = m293b(c0063d.f218e);
                    paddingTop = C0500f.m2143a(m298d(c0063d.f216c), g) & 7;
                    if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                        i10 = Math.max(0, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                        i10 = Math.max(0, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || aj.m1899v(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.f252u.m2114b() + this.f252u.m2116d();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.f252u.m2112a() + this.f252u.m2115c()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                C0046a b = c0063d.m273b();
                if (b == null || !b.m105a(this, view, i9, i10, i8, 0)) {
                    m314a(view, i9, i10, i8, 0);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + c0063d.leftMargin) + c0063d.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + c0063d.topMargin) + c0063d.bottomMargin);
                i7 = aj.m1851a(i5, aj.m1886i(view));
                paddingBottom = i9;
            }
            i6++;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(aj.m1852a(suggestedMinimumWidth, i, -16777216 & i5), aj.m1852a(suggestedMinimumHeight, i2, i5 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                C0063d c0063d = (C0063d) childAt.getLayoutParams();
                if (c0063d.m281h()) {
                    C0046a b = c0063d.m273b();
                    z3 = b != null ? b.m110a(this, childAt, view, f, f2, z) | z2 : z2;
                } else {
                    z3 = z2;
                }
            }
            i++;
            z2 = z3;
        }
        if (z2) {
            m312a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C0063d c0063d = (C0063d) childAt.getLayoutParams();
                if (c0063d.m281h()) {
                    C0046a b = c0063d.m273b();
                    z2 = b != null ? b.m109a(this, childAt, view, f, f2) | z : z;
                } else {
                    z2 = z;
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            int i6;
            int i7;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i6 = i3;
                i7 = i4;
            } else {
                C0063d c0063d = (C0063d) childAt.getLayoutParams();
                if (c0063d.m281h()) {
                    C0046a b = c0063d.m273b();
                    if (b != null) {
                        int[] iArr2 = this.f242k;
                        this.f242k[1] = 0;
                        iArr2[0] = 0;
                        b.m103a(this, childAt, view, i, i2, this.f242k);
                        i6 = i > 0 ? Math.max(i3, this.f242k[0]) : Math.min(i3, this.f242k[0]);
                        i7 = i2 > 0 ? Math.max(i4, this.f242k[1]) : Math.min(i4, this.f242k[1]);
                        int i8 = 1;
                    } else {
                        obj2 = obj;
                        i6 = i3;
                        i7 = i4;
                    }
                } else {
                    obj2 = obj;
                    i6 = i3;
                    i7 = i4;
                }
            }
            i5++;
            i4 = i7;
            i3 = i6;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m312a(1);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                C0063d c0063d = (C0063d) childAt.getLayoutParams();
                if (c0063d.m281h()) {
                    C0046a b = c0063d.m273b();
                    if (b != null) {
                        b.m102a(this, childAt, view, i, i2, i3, i4);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m312a(1);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f256y.m2240a(view, view2, i);
        this.f248q = view;
        this.f249r = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0063d c0063d = (C0063d) childAt.getLayoutParams();
            if (c0063d.m281h()) {
                C0046a b = c0063d.m273b();
                if (b != null) {
                    b.m113b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.f212a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0046a b = m308a(childAt).m273b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.m100a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0046a b = ((C0063d) childAt.getLayoutParams()).m273b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.m112b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        savedState.f212a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C0063d c0063d = (C0063d) childAt.getLayoutParams();
                C0046a b = c0063d.m273b();
                if (b != null) {
                    boolean a = b.m111a(this, childAt, view, view2, i);
                    z2 = z | a;
                    c0063d.m270a(a);
                } else {
                    c0063d.m270a(false);
                    z2 = z;
                }
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f256y.m2239a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0063d c0063d = (C0063d) childAt.getLayoutParams();
            if (c0063d.m281h()) {
                C0046a b = c0063d.m273b();
                if (b != null) {
                    b.m101a(this, childAt, view);
                }
                c0063d.m280g();
                c0063d.m283j();
            }
        }
        this.f248q = null;
        this.f249r = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent obtain;
        MotionEvent motionEvent2 = null;
        int a = C0534t.m2226a(motionEvent);
        boolean z2;
        if (this.f247p == null) {
            boolean a2 = m292a(motionEvent, 1);
            if (a2) {
                z2 = a2;
            } else {
                z2 = a2;
                z = false;
                if (this.f247p == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m304f();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m304f();
                return z;
            }
        }
        z2 = false;
        C0046a b = ((C0063d) this.f247p.getLayoutParams()).m273b();
        z = b != null ? b.m114b(this, this.f247p, motionEvent) : false;
        if (this.f247p == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m304f();
        return z;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0046a b = ((C0063d) view.getLayoutParams()).m273b();
        return (b == null || !b.m107a(this, view, rect, z)) ? super.requestChildRectangleOnScreen(view, rect, z) : true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f244m) {
            m304f();
            this.f244m = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m306h();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f237e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f254w != drawable) {
            if (this.f254w != null) {
                this.f254w.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f254w = drawable2;
            if (this.f254w != null) {
                if (this.f254w.isStateful()) {
                    this.f254w.setState(getDrawableState());
                }
                C0242a.m857b(this.f254w, aj.m1884g(this));
                this.f254w.setVisible(getVisibility() == 0, false);
                this.f254w.setCallback(this);
            }
            aj.m1874c(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0173a.getDrawable(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f254w != null && this.f254w.isVisible() != z) {
            this.f254w.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f254w;
    }
}
