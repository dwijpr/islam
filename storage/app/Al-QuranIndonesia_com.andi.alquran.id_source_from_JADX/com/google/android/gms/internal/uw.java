package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.C1314c;

public class uw extends ud {
    private boolean f6136a;
    private boolean f6137b;
    private AlarmManager f6138c;

    protected uw(uf ufVar) {
        super(ufVar);
        this.f6138c = (AlarmManager) m4266l().getSystemService(NotificationCompatApi24.CATEGORY_ALARM);
    }

    private PendingIntent m9365f() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(m4266l(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(m4266l(), 0, intent, 0);
    }

    protected void m9366a() {
        try {
            this.f6138c.cancel(m9365f());
            if (m4268n().m9340i() > 0) {
                ActivityInfo receiverInfo = m4266l().getPackageManager().getReceiverInfo(new ComponentName(m4266l(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    m4250b("Receiver registered. Using alarm for local dispatch.");
                    this.f6136a = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public boolean m9367b() {
        return this.f6136a;
    }

    public boolean m9368c() {
        return this.f6137b;
    }

    public void m9369d() {
        m4280A();
        C1314c.m4629a(m9367b(), (Object) "Receiver not registered");
        long i = m4268n().m9340i();
        if (i > 0) {
            m9370e();
            long b = m4265k().m4927b() + i;
            this.f6137b = true;
            this.f6138c.setInexactRepeating(2, b, 0, m9365f());
        }
    }

    public void m9370e() {
        m4280A();
        this.f6137b = false;
        this.f6138c.cancel(m9365f());
    }
}
