package android.support.design.widget;

import android.support.v4.view.aj;
import android.view.View;

/* renamed from: android.support.design.widget.y */
class C0155y {
    private final View f516a;
    private int f517b;
    private int f518c;
    private int f519d;
    private int f520e;

    public C0155y(View view) {
        this.f516a = view;
    }

    private void m681c() {
        aj.m1880d(this.f516a, this.f519d - (this.f516a.getTop() - this.f517b));
        aj.m1882e(this.f516a, this.f520e - (this.f516a.getLeft() - this.f518c));
    }

    public void m682a() {
        this.f517b = this.f516a.getTop();
        this.f518c = this.f516a.getLeft();
        m681c();
    }

    public boolean m683a(int i) {
        if (this.f519d == i) {
            return false;
        }
        this.f519d = i;
        m681c();
        return true;
    }

    public int m684b() {
        return this.f519d;
    }

    public boolean m685b(int i) {
        if (this.f520e == i) {
            return false;
        }
        this.f520e = i;
        m681c();
        return true;
    }
}
