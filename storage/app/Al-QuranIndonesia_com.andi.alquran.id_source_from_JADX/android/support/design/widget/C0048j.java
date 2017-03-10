package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.C0534t;
import android.support.v4.view.ah;
import android.support.v4.view.aj;
import android.support.v4.widget.C0588u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: android.support.design.widget.j */
abstract class C0048j<V extends View> extends C0047x<V> {
    C0588u f149a;
    private Runnable f150b;
    private boolean f151c;
    private int f152d;
    private int f153e;
    private int f154f;
    private VelocityTracker f155g;

    /* renamed from: android.support.design.widget.j.a */
    private class C0126a implements Runnable {
        final /* synthetic */ C0048j f452a;
        private final CoordinatorLayout f453b;
        private final V f454c;

        C0126a(C0048j c0048j, CoordinatorLayout coordinatorLayout, V v) {
            this.f452a = c0048j;
            this.f453b = coordinatorLayout;
            this.f454c = v;
        }

        public void run() {
            if (this.f454c != null && this.f452a.f149a != null) {
                if (this.f452a.f149a.m2525g()) {
                    this.f452a.a_(this.f453b, this.f454c, this.f452a.f149a.m2521c());
                    aj.m1864a(this.f454c, (Runnable) this);
                    return;
                }
                this.f452a.m130a(this.f453b, this.f454c);
            }
        }
    }

    public C0048j() {
        this.f152d = -1;
        this.f154f = -1;
    }

    public C0048j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152d = -1;
        this.f154f = -1;
    }

    private void m126d() {
        if (this.f155g == null) {
            this.f155g = VelocityTracker.obtain();
        }
    }

    int m127a() {
        return m124b();
    }

    int m128a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = m124b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = C0127l.m573a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        m122a(a);
        return b - a;
    }

    int m129a(V v) {
        return v.getHeight();
    }

    void m130a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean m131a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f150b != null) {
            v.removeCallbacks(this.f150b);
            this.f150b = null;
        }
        if (this.f149a == null) {
            this.f149a = C0588u.m2512a(v.getContext());
        }
        this.f149a.m2516a(0, m124b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f149a.m2525g()) {
            this.f150b = new C0126a(this, coordinatorLayout, v);
            aj.m1864a((View) v, this.f150b);
            return true;
        }
        m130a(coordinatorLayout, v);
        return false;
    }

    public boolean m132a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f154f < 0) {
            this.f154f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f151c) {
            return true;
        }
        int y;
        switch (C0534t.m2226a(motionEvent)) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f151c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (m136c(v) && coordinatorLayout.m318a((View) v, x, y)) {
                    this.f153e = y;
                    this.f152d = motionEvent.getPointerId(0);
                    m126d();
                    break;
                }
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.f151c = false;
                this.f152d = -1;
                if (this.f155g != null) {
                    this.f155g.recycle();
                    this.f155g = null;
                    break;
                }
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                y = this.f152d;
                if (y != -1) {
                    y = motionEvent.findPointerIndex(y);
                    if (y != -1) {
                        y = (int) motionEvent.getY(y);
                        if (Math.abs(y - this.f153e) > this.f154f) {
                            this.f151c = true;
                            this.f153e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f155g != null) {
            this.f155g.addMovement(motionEvent);
        }
        return this.f151c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return m128a(coordinatorLayout, (View) v, i, (int) RtlSpacingHelper.UNDEFINED, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    final int m133b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return m128a(coordinatorLayout, (View) v, m127a() - i, i2, i3);
    }

    int m134b(V v) {
        return -v.getHeight();
    }

    public boolean m135b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f154f < 0) {
            this.f154f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (C0534t.m2226a(motionEvent)) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m318a((View) v, (int) motionEvent.getX(), y) && m136c(v)) {
                    this.f153e = y;
                    this.f152d = motionEvent.getPointerId(0);
                    m126d();
                    break;
                }
                return false;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (this.f155g != null) {
                    this.f155g.addMovement(motionEvent);
                    this.f155g.computeCurrentVelocity(1000);
                    m131a(coordinatorLayout, (View) v, -m129a(v), 0, ah.m1647b(this.f155g, this.f152d));
                    break;
                }
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.f152d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f153e - findPointerIndex;
                    if (!this.f151c && Math.abs(i) > this.f154f) {
                        this.f151c = true;
                        i = i > 0 ? i - this.f154f : i + this.f154f;
                    }
                    if (this.f151c) {
                        this.f153e = findPointerIndex;
                        m133b(coordinatorLayout, v, i, m134b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                break;
        }
        this.f151c = false;
        this.f152d = -1;
        if (this.f155g != null) {
            this.f155g.recycle();
            this.f155g = null;
        }
        if (this.f155g != null) {
            this.f155g.addMovement(motionEvent);
        }
        return true;
    }

    boolean m136c(V v) {
        return false;
    }
}
