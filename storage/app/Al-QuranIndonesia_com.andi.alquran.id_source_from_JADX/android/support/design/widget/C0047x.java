package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0046a;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.design.widget.x */
class C0047x<V extends View> extends C0046a<V> {
    private C0155y f146a;
    private int f147b;
    private int f148c;

    public C0047x() {
        this.f147b = 0;
        this.f148c = 0;
    }

    public C0047x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f147b = 0;
        this.f148c = 0;
    }

    public boolean m122a(int i) {
        if (this.f146a != null) {
            return this.f146a.m683a(i);
        }
        this.f147b = i;
        return false;
    }

    public boolean m123a(CoordinatorLayout coordinatorLayout, V v, int i) {
        m125b(coordinatorLayout, v, i);
        if (this.f146a == null) {
            this.f146a = new C0155y(v);
        }
        this.f146a.m682a();
        if (this.f147b != 0) {
            this.f146a.m683a(this.f147b);
            this.f147b = 0;
        }
        if (this.f148c != 0) {
            this.f146a.m685b(this.f148c);
            this.f148c = 0;
        }
        return true;
    }

    public int m124b() {
        return this.f146a != null ? this.f146a.m684b() : 0;
    }

    protected void m125b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m313a((View) v, i);
    }
}
