package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.q */
public abstract class C1347q {
    private static final Object f3118a;
    private static C1347q f3119b;

    static {
        f3118a = new Object();
    }

    public static C1347q m4768a(Context context) {
        synchronized (f3118a) {
            if (f3119b == null) {
                f3119b = new C1351r(context.getApplicationContext());
            }
        }
        return f3119b;
    }

    public abstract boolean m4769a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void m4770b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
