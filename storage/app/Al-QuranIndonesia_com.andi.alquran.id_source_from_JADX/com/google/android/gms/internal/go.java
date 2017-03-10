package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.hb.C1595a;

@op
public final class go extends C1595a {
    private final AppEventListener f4168a;

    public go(AppEventListener appEventListener) {
        this.f4168a = appEventListener;
    }

    public void m6349a(String str, String str2) {
        this.f4168a.onAppEvent(str, str2);
    }
}
