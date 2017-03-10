package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.w */
public class C0536w {
    private final View f952a;
    private ViewParent f953b;
    private boolean f954c;
    private int[] f955d;

    public C0536w(View view) {
        this.f952a = view;
    }

    public void m2229a(boolean z) {
        if (this.f954c) {
            aj.m1845B(this.f952a);
        }
        this.f954c = z;
    }

    public boolean m2230a() {
        return this.f954c;
    }

    public boolean m2231a(float f, float f2) {
        return (!m2230a() || this.f953b == null) ? false : aw.m2012a(this.f953b, this.f952a, f, f2);
    }

    public boolean m2232a(float f, float f2, boolean z) {
        return (!m2230a() || this.f953b == null) ? false : aw.m2013a(this.f953b, this.f952a, f, f2, z);
    }

    public boolean m2233a(int i) {
        if (m2236b()) {
            return true;
        }
        if (m2230a()) {
            View view = this.f952a;
            for (ViewParent parent = this.f952a.getParent(); parent != null; parent = parent.getParent()) {
                if (aw.m2014a(parent, view, this.f952a, i)) {
                    this.f953b = parent;
                    aw.m2015b(parent, view, this.f952a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m2234a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2230a() || this.f953b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f952a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            aw.m2010a(this.f953b, this.f952a, i, i2, i3, i4);
            if (iArr != null) {
                this.f952a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2235a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2230a() || this.f953b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f952a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f955d == null) {
                    this.f955d = new int[2];
                }
                iArr = this.f955d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            aw.m2011a(this.f953b, this.f952a, i, i2, iArr);
            if (iArr2 != null) {
                this.f952a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2236b() {
        return this.f953b != null;
    }

    public void m2237c() {
        if (this.f953b != null) {
            aw.m2009a(this.f953b, this.f952a);
            this.f953b = null;
        }
    }
}
