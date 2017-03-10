package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: com.google.android.gms.internal.r */
public final class C1937r extends BroadcastReceiver {
    protected Context f5592a;
    private final C1725a f5593b;

    /* renamed from: com.google.android.gms.internal.r.a */
    public static abstract class C1725a {
        public abstract void m7163a();
    }

    public C1937r(C1725a c1725a) {
        this.f5593b = c1725a;
    }

    public synchronized void m8359a() {
        if (this.f5592a != null) {
            this.f5592a.unregisterReceiver(this);
        }
        this.f5592a = null;
    }

    public void m8360a(Context context) {
        this.f5592a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f5593b.m7163a();
            m8359a();
        }
    }
}
