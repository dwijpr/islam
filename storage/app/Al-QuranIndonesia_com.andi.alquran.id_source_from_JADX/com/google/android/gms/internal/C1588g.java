package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.C1375a;

/* renamed from: com.google.android.gms.internal.g */
public class C1588g extends wn {
    private final C1375a<wj<?>> f4140e;
    private C1895p f4141f;

    public void m6297a() {
        super.m6288a();
        if (!this.f4140e.isEmpty()) {
            this.f4141f.m8058a(this);
        }
    }

    protected void m6298a(ConnectionResult connectionResult, int i) {
        this.f4141f.m8061b(connectionResult, i);
    }

    public void m6299b() {
        super.m6292b();
        this.f4141f.m8062b(this);
    }

    protected void m6300c() {
        this.f4141f.m8063c();
    }

    C1375a<wj<?>> m6301d() {
        return this.f4140e;
    }
}
