package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C1314c;

public final class vl {
    static Object f6232a;
    static cx f6233b;
    static Boolean f6234c;

    static {
        f6232a = new Object();
    }

    public static boolean m9491a(Context context) {
        C1314c.m4623a((Object) context);
        if (f6234c != null) {
            return f6234c.booleanValue();
        }
        boolean a = vp.m9516a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f6234c = Boolean.valueOf(a);
        return a;
    }

    public void m9492a(Context context, Intent intent) {
        vg f = uf.m9151a(context).m9158f();
        if (intent == null) {
            f.m4260e("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        f.m4247a("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean a = vm.m9495a(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f6232a) {
                context.startService(intent2);
                if (a) {
                    try {
                        if (f6233b == null) {
                            f6233b = new cx(context, 1, "Analytics WakeLock");
                            f6233b.m5666a(false);
                        }
                        f6233b.m5664a(1000);
                    } catch (SecurityException e) {
                        f.m4260e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
