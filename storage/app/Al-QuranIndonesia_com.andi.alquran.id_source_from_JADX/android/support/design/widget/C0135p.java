package android.support.design.widget;

import android.support.design.widget.C0144s.C0083a;
import android.support.design.widget.C0144s.C0084b;
import android.util.StateSet;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.p */
final class C0135p {
    C0144s f483a;
    private final ArrayList<C0134a> f484b;
    private C0134a f485c;
    private final C0083a f486d;

    /* renamed from: android.support.design.widget.p.1 */
    class C01331 extends C0084b {
        final /* synthetic */ C0135p f480a;

        C01331(C0135p c0135p) {
            this.f480a = c0135p;
        }

        public void m600b(C0144s c0144s) {
            if (this.f480a.f483a == c0144s) {
                this.f480a.f483a = null;
            }
        }
    }

    /* renamed from: android.support.design.widget.p.a */
    static class C0134a {
        final int[] f481a;
        final C0144s f482b;

        C0134a(int[] iArr, C0144s c0144s) {
            this.f481a = iArr;
            this.f482b = c0144s;
        }
    }

    C0135p() {
        this.f484b = new ArrayList();
        this.f485c = null;
        this.f483a = null;
        this.f486d = new C01331(this);
    }

    private void m601a(C0134a c0134a) {
        this.f483a = c0134a.f482b;
        this.f483a.m629a();
    }

    private void m602b() {
        if (this.f483a != null) {
            this.f483a.m638d();
            this.f483a = null;
        }
    }

    public void m603a() {
        if (this.f483a != null) {
            this.f483a.m640f();
            this.f483a = null;
        }
    }

    void m604a(int[] iArr) {
        C0134a c0134a;
        int size = this.f484b.size();
        for (int i = 0; i < size; i++) {
            c0134a = (C0134a) this.f484b.get(i);
            if (StateSet.stateSetMatches(c0134a.f481a, iArr)) {
                break;
            }
        }
        c0134a = null;
        if (c0134a != this.f485c) {
            if (this.f485c != null) {
                m602b();
            }
            this.f485c = c0134a;
            if (c0134a != null) {
                m601a(c0134a);
            }
        }
    }

    public void m605a(int[] iArr, C0144s c0144s) {
        C0134a c0134a = new C0134a(iArr, c0144s);
        c0144s.m633a(this.f486d);
        this.f484b.add(c0134a);
    }
}
