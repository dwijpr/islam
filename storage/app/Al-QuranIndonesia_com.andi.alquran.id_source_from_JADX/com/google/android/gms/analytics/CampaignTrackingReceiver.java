package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vp;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object f2802a;
    static cx f2803b;
    static Boolean f2804c;

    static {
        f2802a = new Object();
    }

    public static boolean m4184a(Context context) {
        C1314c.m4623a((Object) context);
        if (f2804c != null) {
            return f2804c.booleanValue();
        }
        boolean a = vp.m9516a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f2804c = Boolean.valueOf(a);
        return a;
    }

    protected Class<? extends CampaignTrackingService> m4185a() {
        return CampaignTrackingService.class;
    }

    protected void m4186a(Context context, String str) {
    }

    public void onReceive(Context context, Intent intent) {
        vg f = uf.m9151a(context).m9158f();
        if (intent == null) {
            f.m4260e("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        f.m4247a("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            f.m4260e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean a = CampaignTrackingService.m4188a(context);
        if (!a) {
            f.m4260e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        m4186a(context, stringExtra);
        Object a2 = m4185a();
        C1314c.m4623a(a2);
        Intent intent2 = new Intent(context, a2);
        intent2.putExtra("referrer", stringExtra);
        synchronized (f2802a) {
            context.startService(intent2);
            if (a) {
                try {
                    if (f2803b == null) {
                        f2803b = new cx(context, 1, "Analytics campaign WakeLock");
                        f2803b.m5666a(false);
                    }
                    f2803b.m5664a(1000);
                } catch (SecurityException e) {
                    f.m4260e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }
}
