package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;

@op
class st extends sv implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> f5855a;

    public st(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f5855a = new WeakReference(onGlobalLayoutListener);
    }

    protected void m8732a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void m8733b(ViewTreeObserver viewTreeObserver) {
        zzv.zzcL().m8568a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f5855a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m8729b();
        }
    }
}
