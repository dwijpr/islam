package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@op
class su extends sv implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> f5856a;

    public su(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f5856a = new WeakReference(onScrollChangedListener);
    }

    protected void m8734a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected void m8735b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f5856a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m8729b();
        }
    }
}
