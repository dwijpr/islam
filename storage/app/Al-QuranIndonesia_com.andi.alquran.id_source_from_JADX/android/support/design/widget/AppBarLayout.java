package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0035a.C0027b;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.C0144s.C0041c;
import android.support.design.widget.CoordinatorLayout.C0046a;
import android.support.design.widget.CoordinatorLayout.C0061b;
import android.support.design.widget.CoordinatorLayout.C0063d;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.aj;
import android.support.v4.view.bf;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@C0061b(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int f171a;
    private int f172b;
    private int f173c;
    private boolean f174d;
    private int f175e;
    private bf f176f;
    private List<C0051b> f177g;
    private boolean f178h;
    private boolean f179i;
    private final int[] f180j;

    public static class Behavior extends C0048j<AppBarLayout> {
        private int f156b;
        private boolean f157c;
        private boolean f158d;
        private C0144s f159e;
        private int f160f;
        private boolean f161g;
        private float f162h;
        private WeakReference<View> f163i;
        private C0045a f164j;

        /* renamed from: android.support.design.widget.AppBarLayout.Behavior.1 */
        class C00421 implements C0041c {
            final /* synthetic */ CoordinatorLayout f140a;
            final /* synthetic */ AppBarLayout f141b;
            final /* synthetic */ Behavior f142c;

            C00421(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f142c = behavior;
                this.f140a = coordinatorLayout;
                this.f141b = appBarLayout;
            }

            public void m94a(C0144s c0144s) {
                this.f142c.a_(this.f140a, this.f141b, c0144s.m637c());
            }
        }

        protected static class SavedState extends AbsSavedState {
            public static final Creator<SavedState> CREATOR;
            int f143a;
            float f144b;
            boolean f145c;

            /* renamed from: android.support.design.widget.AppBarLayout.Behavior.SavedState.1 */
            static class C00441 implements C0043e<SavedState> {
                C00441() {
                }

                public SavedState m95a(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                public SavedState[] m96a(int i) {
                    return new SavedState[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return m95a(parcel, classLoader);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m96a(i);
                }
            }

            static {
                CREATOR = C0267d.m910a(new C00441());
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f143a = parcel.readInt();
                this.f144b = parcel.readFloat();
                this.f145c = parcel.readByte() != null;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f143a);
                parcel.writeFloat(this.f144b);
                parcel.writeByte((byte) (this.f145c ? 1 : 0));
            }
        }

        /* renamed from: android.support.design.widget.AppBarLayout.Behavior.a */
        public static abstract class C0045a {
            public abstract boolean m97a(AppBarLayout appBarLayout);
        }

        public Behavior() {
            this.f160f = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f160f = -1;
        }

        private int m138a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void m139a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(m147a() - i);
            float abs2 = Math.abs(f);
            m140a(coordinatorLayout, appBarLayout, i, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f));
        }

        private void m140a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int a = m147a();
            if (a != i) {
                if (this.f159e == null) {
                    this.f159e = C0157z.m687a();
                    this.f159e.m635a(C0093a.f374e);
                    this.f159e.m634a(new C00421(this, coordinatorLayout, appBarLayout));
                } else {
                    this.f159e.m638d();
                }
                this.f159e.m632a((long) Math.min(i2, 600));
                this.f159e.m631a(a, i);
                this.f159e.m629a();
            } else if (this.f159e != null && this.f159e.m636b()) {
                this.f159e.m638d();
            }
        }

        private static boolean m141a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int m142b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0050a c0050a = (C0050a) childAt.getLayoutParams();
                Interpolator b = c0050a.m202b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0050a.m201a();
                    if ((i2 & 1) != 0) {
                        height = (c0050a.bottomMargin + (childAt.getHeight() + c0050a.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= aj.m1893p(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (aj.m1899v(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void m143b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            boolean z = true;
            boolean z2 = false;
            View c = m144c(appBarLayout, i);
            if (c != null) {
                int a = ((C0050a) c.getLayoutParams()).m201a();
                if ((a & 1) != 0) {
                    int p = aj.m1893p(c);
                    if (i2 > 0 && (a & 12) != 0) {
                        z2 = (-i) >= (c.getBottom() - p) - appBarLayout.getTopInset();
                    } else if ((a & 2) != 0) {
                        if ((-i) < (c.getBottom() - p) - appBarLayout.getTopInset()) {
                            z = false;
                        }
                        z2 = z;
                    }
                }
                if (appBarLayout.m213a(z2) && VERSION.SDK_INT >= 11 && m146d(coordinatorLayout, appBarLayout)) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private static View m144c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void m145c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = m147a();
            int a2 = m138a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0050a) childAt.getLayoutParams()).m201a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m141a(a3, 2)) {
                        i2 += aj.m1893p(childAt);
                        a2 = i;
                    } else if (m141a(a3, 5)) {
                        a2 = aj.m1893p(childAt) + i2;
                        if (a >= a2) {
                            i2 = a2;
                            a2 = i;
                        }
                    } else {
                        a2 = i;
                    }
                    if (a >= (i2 + a2) / 2) {
                        i2 = a2;
                    }
                    m139a(coordinatorLayout, appBarLayout, C0127l.m573a(i2, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private boolean m146d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List d = coordinatorLayout.m327d((View) appBarLayout);
            int size = d.size();
            int i = 0;
            while (i < size) {
                C0046a b = ((C0063d) ((View) d.get(i)).getLayoutParams()).m273b();
                if (b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b).m187d() != 0;
                } else {
                    i++;
                }
            }
            return false;
        }

        int m147a() {
            return m171b() + this.f156b;
        }

        int m148a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = m147a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f156b = 0;
                return 0;
            }
            int a2 = C0127l.m573a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m214b() ? m142b(appBarLayout, a2) : a2;
            boolean a3 = m161a(b);
            int i4 = a - a2;
            this.f156b = a2 - b;
            if (!a3 && appBarLayout.m214b()) {
                coordinatorLayout.m320b((View) appBarLayout);
            }
            appBarLayout.m211a(m171b());
            m143b(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1);
            return i4;
        }

        /* synthetic */ int m150a(View view) {
            return m176c((AppBarLayout) view);
        }

        void m151a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m145c(coordinatorLayout, appBarLayout);
        }

        public void m152a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.m100a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f160f = savedState.f143a;
                this.f162h = savedState.f144b;
                this.f161g = savedState.f145c;
                return;
            }
            super.m100a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f160f = -1;
        }

        public void m153a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f158d) {
                m145c(coordinatorLayout, appBarLayout);
            }
            this.f157c = false;
            this.f158d = false;
            this.f163i = new WeakReference(view);
        }

        public void m154a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m133b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f157c = true;
                return;
            }
            this.f157c = false;
        }

        public void m155a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f157c) {
                int i3;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                iArr[1] = m133b(coordinatorLayout, appBarLayout, i2, i3, downNestedPreScrollRange);
            }
        }

        boolean m162a(AppBarLayout appBarLayout) {
            if (this.f164j != null) {
                return this.f164j.m97a(appBarLayout);
            }
            if (this.f163i == null) {
                return true;
            }
            View view = (View) this.f163i.get();
            return (view == null || !view.isShown() || aj.m1873b(view, -1)) ? false : true;
        }

        public boolean m163a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.m123a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                int i2 = (pendingAction & 4) != 0 ? 1 : 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m139a(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (i2 != 0) {
                        m139a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f160f >= 0) {
                View childAt = appBarLayout.getChildAt(this.f160f);
                pendingAction = -childAt.getBottom();
                m161a(this.f161g ? aj.m1893p(childAt) + pendingAction : Math.round(((float) childAt.getHeight()) * this.f162h) + pendingAction);
            }
            appBarLayout.m216d();
            this.f160f = -1;
            m161a(C0127l.m573a(m171b(), -appBarLayout.getTotalScrollRange(), 0));
            appBarLayout.m211a(m171b());
            return a;
        }

        public boolean m164a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C0063d) appBarLayout.getLayoutParams()).height != -2) {
                return super.m105a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m314a(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean m165a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m131a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (m147a() < r1) {
                    m139a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (m147a() > r1) {
                    m139a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            }
            this.f158d = z2;
            return z2;
        }

        public boolean m166a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m215c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f159e != null) {
                this.f159e.m638d();
            }
            this.f163i = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int m171b() {
            return super.m124b();
        }

        int m172b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable m174b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.m112b(coordinatorLayout, appBarLayout);
            int b2 = m171b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.f143a = i;
                    if (bottom == aj.m1893p(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    savedState.f145c = z;
                    savedState.f144b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        int m176c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean m177c(View view) {
            return m162a((AppBarLayout) view);
        }
    }

    public static class ScrollingViewBehavior extends C0049k {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.ScrollingViewBehavior_Layout);
            m184b(obtainStyledAttributes.getDimensionPixelSize(C0034i.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int m188a(AppBarLayout appBarLayout) {
            C0046a b = ((C0063d) appBarLayout.getLayoutParams()).m273b();
            return b instanceof Behavior ? ((Behavior) b).m147a() : 0;
        }

        private void m189e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0046a b = ((C0063d) view2.getLayoutParams()).m273b();
            if (b instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                aj.m1880d(view, ((((Behavior) b).f156b + bottom) + m180a()) - m186c(view2));
            }
        }

        float m190a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int a = m188a(appBarLayout);
            if (downNestedPreScrollRange != 0 && totalScrollRange + a <= downNestedPreScrollRange) {
                return 0.0f;
            }
            totalScrollRange -= downNestedPreScrollRange;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        AppBarLayout m191a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean m193a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.m123a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean m194a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.m181a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public boolean m195a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = m191a(coordinatorLayout.m323c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.m212a(false, !z);
                    return true;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ int m196b() {
            return super.m124b();
        }

        int m197b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.m182b(view);
        }

        /* synthetic */ View m198b(List list) {
            return m191a(list);
        }

        public boolean m199b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean m200c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m189e(coordinatorLayout, view, view2);
            return false;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout.a */
    public static class C0050a extends LayoutParams {
        int f169a;
        Interpolator f170b;

        public C0050a(int i, int i2) {
            super(i, i2);
            this.f169a = 1;
        }

        public C0050a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f169a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.AppBarLayout_Layout);
            this.f169a = obtainStyledAttributes.getInt(C0034i.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0034i.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f170b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0034i.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0050a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f169a = 1;
        }

        public C0050a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f169a = 1;
        }

        @TargetApi(19)
        public C0050a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f169a = 1;
        }

        public int m201a() {
            return this.f169a;
        }

        public Interpolator m202b() {
            return this.f170b;
        }

        boolean m203c() {
            return (this.f169a & 1) == 1 && (this.f169a & 10) != 0;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout.b */
    public interface C0051b {
        void m204a(AppBarLayout appBarLayout, int i);
    }

    private boolean m205b(boolean z) {
        if (this.f178h == z) {
            return false;
        }
        this.f178h = z;
        refreshDrawableState();
        return true;
    }

    private void m206e() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0050a) getChildAt(i).getLayoutParams()).m203c()) {
                z = true;
                break;
            }
        }
        z = false;
        m205b(z);
    }

    private void m207f() {
        this.f171a = -1;
        this.f172b = -1;
        this.f173c = -1;
    }

    protected C0050a m208a() {
        return new C0050a(-1, -2);
    }

    public C0050a m209a(AttributeSet attributeSet) {
        return new C0050a(getContext(), attributeSet);
    }

    protected C0050a m210a(ViewGroup.LayoutParams layoutParams) {
        return (VERSION.SDK_INT < 19 || !(layoutParams instanceof LayoutParams)) ? layoutParams instanceof MarginLayoutParams ? new C0050a((MarginLayoutParams) layoutParams) : new C0050a(layoutParams) : new C0050a((LayoutParams) layoutParams);
    }

    void m211a(int i) {
        if (this.f177g != null) {
            int size = this.f177g.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0051b c0051b = (C0051b) this.f177g.get(i2);
                if (c0051b != null) {
                    c0051b.m204a(this, i);
                }
            }
        }
    }

    public void m212a(boolean z, boolean z2) {
        this.f175e = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    boolean m213a(boolean z) {
        if (this.f179i == z) {
            return false;
        }
        this.f179i = z;
        refreshDrawableState();
        return true;
    }

    boolean m214b() {
        return this.f174d;
    }

    boolean m215c() {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0050a;
    }

    void m216d() {
        this.f175e = 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m208a();
    }

    protected /* synthetic */ LayoutParams m10299generateDefaultLayoutParams() {
        return m208a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m209a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m210a(layoutParams);
    }

    public /* synthetic */ LayoutParams m10300generateLayoutParams(AttributeSet attributeSet) {
        return m209a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m10301generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m210a(layoutParams);
    }

    int getDownNestedPreScrollRange() {
        if (this.f172b != -1) {
            return this.f172b;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0050a c0050a = (C0050a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0050a.f169a;
            if ((i3 & 5) == 5) {
                i = (c0050a.bottomMargin + c0050a.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + aj.m1893p(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - aj.m1893p(childAt)) : i + measuredHeight;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.f172b = i;
        return i;
    }

    int getDownNestedScrollRange() {
        if (this.f173c != -1) {
            return this.f173c;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0050a c0050a = (C0050a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0050a.topMargin + c0050a.bottomMargin);
            i = c0050a.f169a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (aj.m1893p(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f173c = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int p = aj.m1893p(this);
        if (p != 0) {
            return (p * 2) + topInset;
        }
        p = getChildCount();
        p = p >= 1 ? aj.m1893p(getChildAt(p - 1)) : 0;
        return p != 0 ? (p * 2) + topInset : getHeight() / 3;
    }

    int getPendingAction() {
        return this.f175e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        return this.f176f != null ? this.f176f.m2114b() : 0;
    }

    public final int getTotalScrollRange() {
        if (this.f171a != -1) {
            return this.f171a;
        }
        int p;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0050a c0050a = (C0050a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0050a.f169a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0050a.bottomMargin + (measuredHeight + c0050a.topMargin);
            if ((i3 & 2) != 0) {
                p = i - aj.m1893p(childAt);
                break;
            }
        }
        p = i;
        p = Math.max(0, p - getTopInset());
        this.f171a = p;
        return p;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected int[] onCreateDrawableState(int i) {
        int[] iArr = this.f180j;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f178h ? C0027b.state_collapsible : -C0027b.state_collapsible;
        int i2 = (this.f178h && this.f179i) ? C0027b.state_collapsed : -C0027b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m207f();
        this.f174d = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0050a) getChildAt(i5).getLayoutParams()).m202b() != null) {
                this.f174d = true;
                break;
            }
        }
        m206e();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m207f();
    }

    public void setExpanded(boolean z) {
        m212a(z, aj.m1846C(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            aa.m483a(this, f);
        }
    }
}
