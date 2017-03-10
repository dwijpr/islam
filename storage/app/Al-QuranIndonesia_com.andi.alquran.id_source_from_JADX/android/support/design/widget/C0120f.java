package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.design.C0035a.C0026a;
import android.support.design.widget.C0093a.C0092a;
import android.support.design.widget.C0119h.C0067a;
import android.support.design.widget.C0144s.C0041c;
import android.support.design.widget.C0144s.C0083a;
import android.support.design.widget.C0144s.C0084b;
import android.support.design.widget.C0144s.C0142d;
import android.support.v4.p005c.p006a.C0242a;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* renamed from: android.support.design.widget.f */
class C0120f extends C0119h {
    C0128m f440a;
    private final C0135p f441q;

    /* renamed from: android.support.design.widget.f.1 */
    class C01131 extends C0092a {
        final /* synthetic */ boolean f411a;
        final /* synthetic */ C0067a f412b;
        final /* synthetic */ C0120f f413c;

        C01131(C0120f c0120f, boolean z, C0067a c0067a) {
            this.f413c = c0120f;
            this.f411a = z;
            this.f412b = c0067a;
        }

        public void onAnimationEnd(Animation animation) {
            this.f413c.c = 0;
            this.f413c.n.m354a(this.f411a ? 8 : 4, this.f411a);
            if (this.f412b != null) {
                this.f412b.m329b();
            }
        }
    }

    /* renamed from: android.support.design.widget.f.2 */
    class C01142 extends C0092a {
        final /* synthetic */ C0067a f414a;
        final /* synthetic */ C0120f f415b;

        C01142(C0120f c0120f, C0067a c0067a) {
            this.f415b = c0120f;
            this.f414a = c0067a;
        }

        public void onAnimationEnd(Animation animation) {
            this.f415b.c = 0;
            if (this.f414a != null) {
                this.f414a.m328a();
            }
        }
    }

    /* renamed from: android.support.design.widget.f.d */
    private abstract class C0115d extends C0084b implements C0041c {
        private boolean f416a;
        final /* synthetic */ C0120f f417b;
        private float f418c;
        private float f419d;

        private C0115d(C0120f c0120f) {
            this.f417b = c0120f;
        }

        protected abstract float m516a();

        public void m517a(C0144s c0144s) {
            if (!this.f416a) {
                this.f418c = this.f417b.f440a.m580a();
                this.f419d = m516a();
                this.f416a = true;
            }
            this.f417b.f440a.m583b(this.f418c + ((this.f419d - this.f418c) * c0144s.m639e()));
        }

        public void m518b(C0144s c0144s) {
            this.f417b.f440a.m583b(this.f419d);
            this.f416a = false;
        }
    }

    /* renamed from: android.support.design.widget.f.a */
    private class C0116a extends C0115d {
        final /* synthetic */ C0120f f420a;

        C0116a(C0120f c0120f) {
            this.f420a = c0120f;
            super(null);
        }

        protected float m519a() {
            return 0.0f;
        }
    }

    /* renamed from: android.support.design.widget.f.b */
    private class C0117b extends C0115d {
        final /* synthetic */ C0120f f421a;

        C0117b(C0120f c0120f) {
            this.f421a = c0120f;
            super(null);
        }

        protected float m520a() {
            return this.f421a.h + this.f421a.i;
        }
    }

    /* renamed from: android.support.design.widget.f.c */
    private class C0118c extends C0115d {
        final /* synthetic */ C0120f f422a;

        C0118c(C0120f c0120f) {
            this.f422a = c0120f;
            super(null);
        }

        protected float m521a() {
            return this.f422a.h;
        }
    }

    C0120f(ab abVar, C0070n c0070n, C0142d c0142d) {
        super(abVar, c0070n, c0142d);
        this.f441q = new C0135p();
        this.f441q.m605a(j, m544a(new C0117b(this)));
        this.f441q.m605a(k, m544a(new C0117b(this)));
        this.f441q.m605a(l, m544a(new C0118c(this)));
        this.f441q.m605a(m, m544a(new C0116a(this)));
    }

    private C0144s m544a(C0115d c0115d) {
        C0144s a = this.p.m615a();
        a.m635a(b);
        a.m632a(100);
        a.m633a((C0083a) c0115d);
        a.m634a((C0041c) c0115d);
        a.m630a(0.0f, 1.0f);
        return a;
    }

    private static ColorStateList m545b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{k, i, j};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    float m546a() {
        return this.h;
    }

    void m547a(float f, float f2) {
        if (this.f440a != null) {
            this.f440a.m582a(f, this.i + f);
            m539g();
        }
    }

    void m548a(int i) {
        if (this.e != null) {
            C0242a.m851a(this.e, C0120f.m545b(i));
        }
    }

    void m549a(ColorStateList colorStateList) {
        if (this.d != null) {
            C0242a.m851a(this.d, colorStateList);
        }
        if (this.f != null) {
            this.f.m504a(colorStateList);
        }
    }

    void m550a(Mode mode) {
        if (this.d != null) {
            C0242a.m854a(this.d, mode);
        }
    }

    void m551a(Rect rect) {
        this.f440a.getPadding(rect);
    }

    void m552a(C0067a c0067a, boolean z) {
        if (!m543k()) {
            this.c = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.n.getContext(), C0026a.design_fab_out);
            loadAnimation.setInterpolator(C0093a.f372c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C01131(this, z, c0067a));
            this.n.startAnimation(loadAnimation);
        }
    }

    void m553a(int[] iArr) {
        this.f441q.m604a(iArr);
    }

    void m554b() {
        this.f441q.m603a();
    }

    void m555b(C0067a c0067a, boolean z) {
        if (!m542j()) {
            this.c = 2;
            this.n.m354a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.n.getContext(), C0026a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0093a.f373d);
            loadAnimation.setAnimationListener(new C01142(this, c0067a));
            this.n.startAnimation(loadAnimation);
        }
    }

    void m556c() {
    }
}
