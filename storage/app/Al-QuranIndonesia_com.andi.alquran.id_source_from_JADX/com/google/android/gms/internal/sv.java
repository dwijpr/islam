package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@op
abstract class sv {
    private final WeakReference<View> f5854a;

    public sv(View view) {
        this.f5854a = new WeakReference(view);
    }

    public final void m8727a() {
        ViewTreeObserver c = m8731c();
        if (c != null) {
            m8728a(c);
        }
    }

    protected abstract void m8728a(ViewTreeObserver viewTreeObserver);

    public final void m8729b() {
        ViewTreeObserver c = m8731c();
        if (c != null) {
            m8730b(c);
        }
    }

    protected abstract void m8730b(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver m8731c() {
        View view = (View) this.f5854a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }
}
