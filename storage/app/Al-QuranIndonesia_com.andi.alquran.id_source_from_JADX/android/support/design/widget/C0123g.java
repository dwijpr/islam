package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.design.widget.C0119h.C0067a;
import android.support.design.widget.C0144s.C0142d;
import android.support.v4.view.aj;

@TargetApi(14)
/* renamed from: android.support.design.widget.g */
class C0123g extends C0120f {
    private float f449q;

    /* renamed from: android.support.design.widget.g.1 */
    class C01211 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f442a;
        final /* synthetic */ C0067a f443b;
        final /* synthetic */ C0123g f444c;
        private boolean f445d;

        C01211(C0123g c0123g, boolean z, C0067a c0067a) {
            this.f444c = c0123g;
            this.f442a = z;
            this.f443b = c0067a;
        }

        public void onAnimationCancel(Animator animator) {
            this.f445d = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f444c.c = 0;
            if (!this.f445d) {
                this.f444c.n.m354a(this.f442a ? 8 : 4, this.f442a);
                if (this.f443b != null) {
                    this.f443b.m329b();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f444c.n.m354a(0, this.f442a);
            this.f445d = false;
        }
    }

    /* renamed from: android.support.design.widget.g.2 */
    class C01222 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f446a;
        final /* synthetic */ C0067a f447b;
        final /* synthetic */ C0123g f448c;

        C01222(C0123g c0123g, boolean z, C0067a c0067a) {
            this.f448c = c0123g;
            this.f446a = z;
            this.f447b = c0067a;
        }

        public void onAnimationEnd(Animator animator) {
            this.f448c.c = 0;
            if (this.f447b != null) {
                this.f447b.m328a();
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f448c.n.m354a(0, this.f446a);
        }
    }

    C0123g(ab abVar, C0070n c0070n, C0142d c0142d) {
        super(abVar, c0070n, c0142d);
        this.f449q = this.n.getRotation();
    }

    private boolean m557l() {
        return aj.m1846C(this.n) && !this.n.isInEditMode();
    }

    private void m558m() {
        if (VERSION.SDK_INT == 19) {
            if (this.f449q % 90.0f != 0.0f) {
                if (this.n.getLayerType() != 1) {
                    this.n.setLayerType(1, null);
                }
            } else if (this.n.getLayerType() != 0) {
                this.n.setLayerType(0, null);
            }
        }
        if (this.a != null) {
            this.a.m581a(-this.f449q);
        }
        if (this.f != null) {
            this.f.m503a(-this.f449q);
        }
    }

    void m559a(C0067a c0067a, boolean z) {
        if (!m543k()) {
            this.n.animate().cancel();
            if (m557l()) {
                this.c = 1;
                this.n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0093a.f372c).setListener(new C01211(this, z, c0067a));
                return;
            }
            this.n.m354a(z ? 8 : 4, z);
            if (c0067a != null) {
                c0067a.m329b();
            }
        }
    }

    void m560b(C0067a c0067a, boolean z) {
        if (!m542j()) {
            this.n.animate().cancel();
            if (m557l()) {
                this.c = 2;
                if (this.n.getVisibility() != 0) {
                    this.n.setAlpha(0.0f);
                    this.n.setScaleY(0.0f);
                    this.n.setScaleX(0.0f);
                }
                this.n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0093a.f373d).setListener(new C01222(this, z, c0067a));
                return;
            }
            this.n.m354a(0, z);
            this.n.setAlpha(1.0f);
            this.n.setScaleY(1.0f);
            this.n.setScaleX(1.0f);
            if (c0067a != null) {
                c0067a.m328a();
            }
        }
    }

    boolean m561d() {
        return true;
    }

    void m562e() {
        float rotation = this.n.getRotation();
        if (this.f449q != rotation) {
            this.f449q = rotation;
            m558m();
        }
    }
}
