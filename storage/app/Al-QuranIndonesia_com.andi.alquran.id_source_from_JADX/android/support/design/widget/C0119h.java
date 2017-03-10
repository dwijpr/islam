package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.widget.C0144s.C0142d;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.h */
abstract class C0119h {
    static final Interpolator f423b;
    static final int[] f424j;
    static final int[] f425k;
    static final int[] f426l;
    static final int[] f427m;
    private final Rect f428a;
    int f429c;
    Drawable f430d;
    Drawable f431e;
    C0111d f432f;
    Drawable f433g;
    float f434h;
    float f435i;
    final ab f436n;
    final C0070n f437o;
    final C0142d f438p;
    private OnPreDrawListener f439q;

    /* renamed from: android.support.design.widget.h.a */
    interface C0067a {
        void m328a();

        void m329b();
    }

    /* renamed from: android.support.design.widget.h.1 */
    class C01241 implements OnPreDrawListener {
        final /* synthetic */ C0119h f450a;

        C01241(C0119h c0119h) {
            this.f450a = c0119h;
        }

        public boolean onPreDraw() {
            this.f450a.m537e();
            return true;
        }
    }

    static {
        f423b = C0093a.f372c;
        f424j = new int[]{16842919, 16842910};
        f425k = new int[]{16842908, 16842910};
        f426l = new int[]{16842910};
        f427m = new int[0];
    }

    C0119h(ab abVar, C0070n c0070n, C0142d c0142d) {
        this.f429c = 0;
        this.f428a = new Rect();
        this.f436n = abVar;
        this.f437o = c0070n;
        this.f438p = c0142d;
    }

    private void m522l() {
        if (this.f439q == null) {
            this.f439q = new C01241(this);
        }
    }

    abstract float m523a();

    final void m524a(float f) {
        if (this.f434h != f) {
            this.f434h = f;
            m525a(f, this.f435i);
        }
    }

    abstract void m525a(float f, float f2);

    abstract void m526a(int i);

    abstract void m527a(ColorStateList colorStateList);

    abstract void m528a(Mode mode);

    abstract void m529a(Rect rect);

    abstract void m530a(C0067a c0067a, boolean z);

    abstract void m531a(int[] iArr);

    abstract void m532b();

    void m533b(Rect rect) {
    }

    abstract void m534b(C0067a c0067a, boolean z);

    abstract void m535c();

    boolean m536d() {
        return false;
    }

    void m537e() {
    }

    final Drawable m538f() {
        return this.f433g;
    }

    final void m539g() {
        Rect rect = this.f428a;
        m529a(rect);
        m533b(rect);
        this.f437o.m347a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m540h() {
        if (m536d()) {
            m522l();
            this.f436n.getViewTreeObserver().addOnPreDrawListener(this.f439q);
        }
    }

    void m541i() {
        if (this.f439q != null) {
            this.f436n.getViewTreeObserver().removeOnPreDrawListener(this.f439q);
            this.f439q = null;
        }
    }

    boolean m542j() {
        return this.f436n.getVisibility() != 0 ? this.f429c == 2 : this.f429c != 1;
    }

    boolean m543k() {
        return this.f436n.getVisibility() == 0 ? this.f429c == 1 : this.f429c != 2;
    }
}
