package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0035a.C0028c;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.CoordinatorLayout.C0046a;
import android.support.design.widget.CoordinatorLayout.C0063d;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0039v;
import android.support.v4.view.C0534t;
import android.support.v4.view.ah;
import android.support.v4.view.aj;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0052a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0046a<V> {
    int f186a;
    int f187b;
    boolean f188c;
    int f189d;
    ad f190e;
    int f191f;
    WeakReference<V> f192g;
    WeakReference<View> f193h;
    int f194i;
    boolean f195j;
    private float f196k;
    private int f197l;
    private boolean f198m;
    private int f199n;
    private boolean f200o;
    private boolean f201p;
    private int f202q;
    private boolean f203r;
    private C0055a f204s;
    private VelocityTracker f205t;
    private int f206u;
    private final C0052a f207v;

    /* renamed from: android.support.design.widget.BottomSheetBehavior.1 */
    class C00531 extends C0052a {
        final /* synthetic */ BottomSheetBehavior f181a;

        C00531(BottomSheetBehavior bottomSheetBehavior) {
            this.f181a = bottomSheetBehavior;
        }

        public int m230a(View view) {
            return this.f181a.f188c ? this.f181a.f191f - this.f181a.f186a : this.f181a.f187b - this.f181a.f186a;
        }

        public int m231a(View view, int i, int i2) {
            return C0127l.m573a(i, this.f181a.f186a, this.f181a.f188c ? this.f181a.f191f : this.f181a.f187b);
        }

        public void m232a(int i) {
            if (i == 1) {
                this.f181a.m257b(1);
            }
        }

        public void m233a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.f181a.f186a;
            } else if (this.f181a.f188c && this.f181a.m255a(view, f2)) {
                i = this.f181a.f191f;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.f181a.f186a) < Math.abs(top - this.f181a.f187b)) {
                    i = this.f181a.f186a;
                } else {
                    i = this.f181a.f187b;
                    i2 = 4;
                }
            } else {
                i = this.f181a.f187b;
                i2 = 4;
            }
            if (this.f181a.f190e.m2400a(view.getLeft(), i)) {
                this.f181a.m257b(2);
                aj.m1864a(view, new C0056b(this.f181a, view, i2));
                return;
            }
            this.f181a.m257b(i2);
        }

        public void m234a(View view, int i, int i2, int i3, int i4) {
            this.f181a.m260c(i2);
        }

        public boolean m235a(View view, int i) {
            if (this.f181a.f189d == 1 || this.f181a.f195j) {
                return false;
            }
            if (this.f181a.f189d == 3 && this.f181a.f194i == i) {
                View view2 = (View) this.f181a.f193h.get();
                if (view2 != null && aj.m1873b(view2, -1)) {
                    return false;
                }
            }
            boolean z = this.f181a.f192g != null && this.f181a.f192g.get() == view;
            return z;
        }

        public int m236b(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        final int f182a;

        /* renamed from: android.support.design.widget.BottomSheetBehavior.SavedState.1 */
        static class C00541 implements C0043e<SavedState> {
            C00541() {
            }

            public SavedState m237a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m238a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m237a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m238a(i);
            }
        }

        static {
            CREATOR = C0267d.m910a(new C00541());
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f182a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f182a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f182a);
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior.a */
    public static abstract class C0055a {
        public abstract void m239a(View view, float f);

        public abstract void m240a(View view, int i);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior.b */
    private class C0056b implements Runnable {
        final /* synthetic */ BottomSheetBehavior f183a;
        private final View f184b;
        private final int f185c;

        C0056b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f183a = bottomSheetBehavior;
            this.f184b = view;
            this.f185c = i;
        }

        public void run() {
            if (this.f183a.f190e == null || !this.f183a.f190e.m2403a(true)) {
                this.f183a.m257b(this.f185c);
            } else {
                aj.m1864a(this.f184b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f189d = 4;
        this.f207v = new C00531(this);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f189d = 4;
        this.f207v = new C00531(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C0034i.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            m245a(obtainStyledAttributes.getDimensionPixelSize(C0034i.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            m245a(peekValue.data);
        }
        m250a(obtainStyledAttributes.getBoolean(C0034i.BottomSheetBehavior_Layout_behavior_hideable, false));
        m258b(obtainStyledAttributes.getBoolean(C0034i.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f196k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static <V extends View> BottomSheetBehavior<V> m241a(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof C0063d) {
            C0046a b = ((C0063d) layoutParams).m273b();
            if (b instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void m242a() {
        this.f194i = -1;
        if (this.f205t != null) {
            this.f205t.recycle();
            this.f205t = null;
        }
    }

    private float m243b() {
        this.f205t.computeCurrentVelocity(1000, this.f196k);
        return ah.m1647b(this.f205t, this.f194i);
    }

    private View m244b(View view) {
        if (view instanceof C0039v) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View b = m244b(viewGroup.getChildAt(i));
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    public final void m245a(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.f198m) {
                this.f198m = true;
            }
            z = false;
        } else {
            if (this.f198m || this.f197l != i) {
                this.f198m = false;
                this.f197l = Math.max(0, i);
                this.f187b = this.f191f - i;
            }
            z = false;
        }
        if (z && this.f189d == 4 && this.f192g != null) {
            View view = (View) this.f192g.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void m246a(C0055a c0055a) {
        this.f204s = c0055a;
    }

    public void m247a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.m100a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.f182a == 1 || savedState.f182a == 2) {
            this.f189d = 4;
        } else {
            this.f189d = savedState.f182a;
        }
    }

    public void m248a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f186a) {
            m257b(3);
        } else if (view == this.f193h.get() && this.f203r) {
            int i2;
            if (this.f202q > 0) {
                i2 = this.f186a;
            } else if (this.f188c && m255a(v, m243b())) {
                i2 = this.f191f;
                i = 5;
            } else if (this.f202q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f186a) < Math.abs(top - this.f187b)) {
                    i2 = this.f186a;
                } else {
                    i2 = this.f187b;
                    i = 4;
                }
            } else {
                i2 = this.f187b;
                i = 4;
            }
            if (this.f190e.m2402a((View) v, v.getLeft(), i2)) {
                m257b(2);
                aj.m1864a((View) v, new C0056b(this, v, i));
            } else {
                m257b(i);
            }
            this.f203r = false;
        }
    }

    public void m249a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f193h.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f186a) {
                    iArr[1] = top - this.f186a;
                    aj.m1880d((View) v, -iArr[1]);
                    m257b(3);
                } else {
                    iArr[1] = i2;
                    aj.m1880d((View) v, -i2);
                    m257b(1);
                }
            } else if (i2 < 0 && !aj.m1873b(view, -1)) {
                if (i3 <= this.f187b || this.f188c) {
                    iArr[1] = i2;
                    aj.m1880d((View) v, -i2);
                    m257b(1);
                } else {
                    iArr[1] = top - this.f187b;
                    aj.m1880d((View) v, -iArr[1]);
                    m257b(4);
                }
            }
            m260c(v.getTop());
            this.f202q = i2;
            this.f203r = true;
        }
    }

    public void m250a(boolean z) {
        this.f188c = z;
    }

    public boolean m251a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (aj.m1899v(coordinatorLayout) && !aj.m1899v(v)) {
            aj.m1866a((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m313a((View) v, i);
        this.f191f = coordinatorLayout.getHeight();
        if (this.f198m) {
            if (this.f199n == 0) {
                this.f199n = coordinatorLayout.getResources().getDimensionPixelSize(C0028c.design_bottom_sheet_peek_height_min);
            }
            max = Math.max(this.f199n, this.f191f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.f197l;
        }
        this.f186a = Math.max(0, this.f191f - v.getHeight());
        this.f187b = Math.max(this.f191f - max, this.f186a);
        if (this.f189d == 3) {
            aj.m1880d((View) v, this.f186a);
        } else if (this.f188c && this.f189d == 5) {
            aj.m1880d((View) v, this.f191f);
        } else if (this.f189d == 4) {
            aj.m1880d((View) v, this.f187b);
        } else if (this.f189d == 1 || this.f189d == 2) {
            aj.m1880d((View) v, top - v.getTop());
        }
        if (this.f190e == null) {
            this.f190e = ad.m2381a((ViewGroup) coordinatorLayout, this.f207v);
        }
        this.f192g = new WeakReference(v);
        this.f193h = new WeakReference(m244b((View) v));
        return true;
    }

    public boolean m252a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (v.isShown()) {
            View view;
            int a = C0534t.m2226a(motionEvent);
            if (a == 0) {
                m242a();
            }
            if (this.f205t == null) {
                this.f205t = VelocityTracker.obtain();
            }
            this.f205t.addMovement(motionEvent);
            switch (a) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    int x = (int) motionEvent.getX();
                    this.f206u = (int) motionEvent.getY();
                    view = (View) this.f193h.get();
                    if (view != null && coordinatorLayout.m318a(view, x, this.f206u)) {
                        this.f194i = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f195j = true;
                    }
                    boolean z2 = this.f194i == -1 && !coordinatorLayout.m318a((View) v, x, this.f206u);
                    this.f201p = z2;
                    break;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    this.f195j = false;
                    this.f194i = -1;
                    if (this.f201p) {
                        this.f201p = false;
                        return false;
                    }
                    break;
            }
            if (!this.f201p && this.f190e.m2401a(motionEvent)) {
                return true;
            }
            view = (View) this.f193h.get();
            if (a != 2 || view == null || this.f201p || this.f189d == 1 || coordinatorLayout.m318a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f206u) - motionEvent.getY()) <= ((float) this.f190e.m2413d())) {
                z = false;
            }
            return z;
        }
        this.f201p = true;
        return false;
    }

    public boolean m253a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f193h.get() && (this.f189d != 3 || super.m109a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean m254a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f202q = 0;
        this.f203r = false;
        return (i & 2) != 0;
    }

    boolean m255a(View view, float f) {
        return this.f200o ? true : view.getTop() < this.f187b ? false : Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f187b)) / ((float) this.f197l) > 0.5f;
    }

    public Parcelable m256b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.m112b(coordinatorLayout, v), this.f189d);
    }

    void m257b(int i) {
        if (this.f189d != i) {
            this.f189d = i;
            View view = (View) this.f192g.get();
            if (view != null && this.f204s != null) {
                this.f204s.m240a(view, i);
            }
        }
    }

    public void m258b(boolean z) {
        this.f200o = z;
    }

    public boolean m259b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = C0534t.m2226a(motionEvent);
        if (this.f189d == 1 && a == 0) {
            return true;
        }
        this.f190e.m2406b(motionEvent);
        if (a == 0) {
            m242a();
        }
        if (this.f205t == null) {
            this.f205t = VelocityTracker.obtain();
        }
        this.f205t.addMovement(motionEvent);
        if (a == 2 && !this.f201p && Math.abs(((float) this.f206u) - motionEvent.getY()) > ((float) this.f190e.m2413d())) {
            this.f190e.m2398a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f201p;
    }

    void m260c(int i) {
        View view = (View) this.f192g.get();
        if (view != null && this.f204s != null) {
            if (i > this.f187b) {
                this.f204s.m239a(view, ((float) (this.f187b - i)) / ((float) (this.f191f - this.f187b)));
            } else {
                this.f204s.m239a(view, ((float) (this.f187b - i)) / ((float) (this.f187b - this.f186a)));
            }
        }
    }
}
