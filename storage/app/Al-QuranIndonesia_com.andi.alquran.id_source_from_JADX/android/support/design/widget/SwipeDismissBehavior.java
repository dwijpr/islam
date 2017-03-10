package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0046a;
import android.support.v4.view.C0534t;
import android.support.v4.view.aj;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0052a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.maps.GoogleMap;

public class SwipeDismissBehavior<V extends View> extends C0046a<V> {
    private boolean f290a;
    ad f291b;
    C0075a f292c;
    int f293d;
    float f294e;
    float f295f;
    float f296g;
    private float f297h;
    private boolean f298i;
    private final C0052a f299j;

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.1 */
    class C00741 extends C0052a {
        final /* synthetic */ SwipeDismissBehavior f284a;
        private int f285b;
        private int f286c;

        C00741(SwipeDismissBehavior swipeDismissBehavior) {
            this.f284a = swipeDismissBehavior;
            this.f286c = -1;
        }

        private boolean m373a(View view, float f) {
            if (f != 0.0f) {
                boolean z = aj.m1884g(view) == 1;
                return this.f284a.f293d == 2 ? true : this.f284a.f293d == 0 ? z ? f < 0.0f : f > 0.0f : this.f284a.f293d == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.f285b) >= Math.round(((float) view.getWidth()) * this.f284a.f294e);
            }
        }

        public int m374a(View view, int i, int i2) {
            return view.getTop();
        }

        public void m375a(int i) {
            if (this.f284a.f292c != null) {
                this.f284a.f292c.m382a(i);
            }
        }

        public void m376a(View view, float f, float f2) {
            this.f286c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m373a(view, f)) {
                width = view.getLeft() < this.f285b ? this.f285b - width : this.f285b + width;
                z = true;
            } else {
                width = this.f285b;
            }
            if (this.f284a.f291b.m2400a(width, view.getTop())) {
                aj.m1864a(view, new C0076b(this.f284a, view, z));
            } else if (z && this.f284a.f292c != null) {
                this.f284a.f292c.m383a(view);
            }
        }

        public void m377a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f285b) + (((float) view.getWidth()) * this.f284a.f295f);
            float width2 = ((float) this.f285b) + (((float) view.getWidth()) * this.f284a.f296g);
            if (((float) i) <= width) {
                aj.m1875c(view, 1.0f);
            } else if (((float) i) >= width2) {
                aj.m1875c(view, 0.0f);
            } else {
                aj.m1875c(view, SwipeDismissBehavior.m384a(0.0f, 1.0f - SwipeDismissBehavior.m387b(width, width2, (float) i), 1.0f));
            }
        }

        public boolean m378a(View view, int i) {
            return this.f286c == -1 && this.f284a.m392a(view);
        }

        public int m379b(View view) {
            return view.getWidth();
        }

        public int m380b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = aj.m1884g(view) == 1 ? 1 : null;
            if (this.f284a.f293d == 0) {
                if (obj != null) {
                    width = this.f285b - view.getWidth();
                    i3 = this.f285b;
                } else {
                    width = this.f285b;
                    i3 = this.f285b + view.getWidth();
                }
            } else if (this.f284a.f293d != 1) {
                width = this.f285b - view.getWidth();
                i3 = this.f285b + view.getWidth();
            } else if (obj != null) {
                width = this.f285b;
                i3 = this.f285b + view.getWidth();
            } else {
                width = this.f285b - view.getWidth();
                i3 = this.f285b;
            }
            return SwipeDismissBehavior.m385a(width, i, i3);
        }

        public void m381b(View view, int i) {
            this.f286c = i;
            this.f285b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.a */
    public interface C0075a {
        void m382a(int i);

        void m383a(View view);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.b */
    private class C0076b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f287a;
        private final View f288b;
        private final boolean f289c;

        C0076b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f287a = swipeDismissBehavior;
            this.f288b = view;
            this.f289c = z;
        }

        public void run() {
            if (this.f287a.f291b != null && this.f287a.f291b.m2403a(true)) {
                aj.m1864a(this.f288b, (Runnable) this);
            } else if (this.f289c && this.f287a.f292c != null) {
                this.f287a.f292c.m383a(this.f288b);
            }
        }
    }

    public SwipeDismissBehavior() {
        this.f297h = 0.0f;
        this.f293d = 2;
        this.f294e = 0.5f;
        this.f295f = 0.0f;
        this.f296g = 0.5f;
        this.f299j = new C00741(this);
    }

    static float m384a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int m385a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void m386a(ViewGroup viewGroup) {
        if (this.f291b == null) {
            this.f291b = this.f298i ? ad.m2380a(viewGroup, this.f297h, this.f299j) : ad.m2381a(viewGroup, this.f299j);
        }
    }

    static float m387b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void m388a(float f) {
        this.f295f = m384a(0.0f, f, 1.0f);
    }

    public void m389a(int i) {
        this.f293d = i;
    }

    public void m390a(C0075a c0075a) {
        this.f292c = c0075a;
    }

    public boolean m391a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f290a;
        switch (C0534t.m2226a(motionEvent)) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f290a = coordinatorLayout.m318a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.f290a;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.f290a = false;
                break;
        }
        if (!z) {
            return false;
        }
        m386a((ViewGroup) coordinatorLayout);
        return this.f291b.m2401a(motionEvent);
    }

    public boolean m392a(View view) {
        return true;
    }

    public void m393b(float f) {
        this.f296g = m384a(0.0f, f, 1.0f);
    }

    public boolean m394b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f291b == null) {
            return false;
        }
        this.f291b.m2406b(motionEvent);
        return true;
    }
}
