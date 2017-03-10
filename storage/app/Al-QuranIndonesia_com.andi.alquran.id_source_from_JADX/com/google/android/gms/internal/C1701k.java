package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.internal.wm.C1475a;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.k */
public class C1701k implements C1639m {
    private final C1829n f4588a;

    public C1701k(C1829n c1829n) {
        this.f4588a = c1829n;
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m7057a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void m7058a() {
        this.f4588a.m7755g();
        this.f4588a.f5075g.f4687d = Collections.emptySet();
    }

    public void m7059a(int i) {
    }

    public void m7060a(Bundle bundle) {
    }

    public void m7061a(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
    }

    public boolean m7062b() {
        return true;
    }

    public void m7063c() {
        this.f4588a.m7753e();
    }
}
