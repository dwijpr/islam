package android.support.v4.p008a;

import android.annotation.TargetApi;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
/* renamed from: android.support.v4.a.e */
class C0165e implements C0160c {

    /* renamed from: android.support.v4.a.e.a */
    private static class C0164a implements C0163g {
        List<C0159b> f524a;
        List<C0161d> f525b;
        View f526c;
        private long f527d;
        private long f528e;
        private float f529f;
        private boolean f530g;
        private boolean f531h;
        private Runnable f532i;

        /* renamed from: android.support.v4.a.e.a.1 */
        class C01621 implements Runnable {
            final /* synthetic */ C0164a f523a;

            C01621(C0164a c0164a) {
                this.f523a = c0164a;
            }

            public void run() {
                float a = (((float) (this.f523a.m707e() - this.f523a.f527d)) * 1.0f) / ((float) this.f523a.f528e);
                if (a > 1.0f || this.f523a.f526c.getParent() == null) {
                    a = 1.0f;
                }
                this.f523a.f529f = a;
                this.f523a.m704d();
                if (this.f523a.f529f >= 1.0f) {
                    this.f523a.m711g();
                } else {
                    this.f523a.f526c.postDelayed(this.f523a.f532i, 16);
                }
            }
        }

        public C0164a() {
            this.f524a = new ArrayList();
            this.f525b = new ArrayList();
            this.f528e = 200;
            this.f529f = 0.0f;
            this.f530g = false;
            this.f531h = false;
            this.f532i = new C01621(this);
        }

        private void m704d() {
            for (int size = this.f525b.size() - 1; size >= 0; size--) {
                ((C0161d) this.f525b.get(size)).onAnimationUpdate(this);
            }
        }

        private long m707e() {
            return this.f526c.getDrawingTime();
        }

        private void m708f() {
            for (int size = this.f524a.size() - 1; size >= 0; size--) {
                ((C0159b) this.f524a.get(size)).onAnimationStart(this);
            }
        }

        private void m711g() {
            for (int size = this.f524a.size() - 1; size >= 0; size--) {
                ((C0159b) this.f524a.get(size)).onAnimationEnd(this);
            }
        }

        private void m712h() {
            for (int size = this.f524a.size() - 1; size >= 0; size--) {
                ((C0159b) this.f524a.get(size)).onAnimationCancel(this);
            }
        }

        public void m713a() {
            if (!this.f530g) {
                this.f530g = true;
                m708f();
                this.f529f = 0.0f;
                this.f527d = m707e();
                this.f526c.postDelayed(this.f532i, 16);
            }
        }

        public void m714a(long j) {
            if (!this.f530g) {
                this.f528e = j;
            }
        }

        public void m715a(C0159b c0159b) {
            this.f524a.add(c0159b);
        }

        public void m716a(C0161d c0161d) {
            this.f525b.add(c0161d);
        }

        public void m717a(View view) {
            this.f526c = view;
        }

        public void m718b() {
            if (!this.f531h) {
                this.f531h = true;
                if (this.f530g) {
                    m712h();
                }
                m711g();
            }
        }

        public float m719c() {
            return this.f529f;
        }
    }

    C0165e() {
    }

    public C0163g m720a() {
        return new C0164a();
    }

    public void m721a(View view) {
    }
}
