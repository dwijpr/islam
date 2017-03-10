package com.google.android.gms.internal;

import com.google.android.gms.internal.os.C1881a;
import com.google.android.gms.internal.pb.C1888a;
import java.lang.ref.WeakReference;

@op
public final class ow extends C1888a {
    private final WeakReference<C1881a> f5297a;

    public ow(C1881a c1881a) {
        this.f5297a = new WeakReference(c1881a);
    }

    public void m7986a(zzmk com_google_android_gms_internal_zzmk) {
        C1881a c1881a = (C1881a) this.f5297a.get();
        if (c1881a != null) {
            c1881a.m7943a(com_google_android_gms_internal_zzmk);
        }
    }
}
