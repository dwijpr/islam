package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vp;

public class CampaignTrackingService extends Service {
    private static Boolean f2816b;
    private Handler f2817a;

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.1 */
    class C12031 implements Runnable {
        final /* synthetic */ vg f2805a;
        final /* synthetic */ Handler f2806b;
        final /* synthetic */ int f2807c;
        final /* synthetic */ CampaignTrackingService f2808d;

        C12031(CampaignTrackingService campaignTrackingService, vg vgVar, Handler handler, int i) {
            this.f2808d = campaignTrackingService;
            this.f2805a = vgVar;
            this.f2806b = handler;
            this.f2807c = i;
        }

        public void run() {
            this.f2808d.m4190a(this.f2805a, this.f2806b, this.f2807c);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.2 */
    class C12042 implements Runnable {
        final /* synthetic */ vg f2809a;
        final /* synthetic */ Handler f2810b;
        final /* synthetic */ int f2811c;
        final /* synthetic */ CampaignTrackingService f2812d;

        C12042(CampaignTrackingService campaignTrackingService, vg vgVar, Handler handler, int i) {
            this.f2812d = campaignTrackingService;
            this.f2809a = vgVar;
            this.f2810b = handler;
            this.f2811c = i;
        }

        public void run() {
            this.f2812d.m4190a(this.f2809a, this.f2810b, this.f2811c);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.3 */
    class C12053 implements Runnable {
        final /* synthetic */ int f2813a;
        final /* synthetic */ vg f2814b;
        final /* synthetic */ CampaignTrackingService f2815c;

        C12053(CampaignTrackingService campaignTrackingService, int i, vg vgVar) {
            this.f2815c = campaignTrackingService;
            this.f2813a = i;
            this.f2814b = vgVar;
        }

        public void run() {
            boolean stopSelfResult = this.f2815c.stopSelfResult(this.f2813a);
            if (stopSelfResult) {
                this.f2814b.m4247a("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
            }
        }
    }

    private void m4187a() {
        try {
            synchronized (CampaignTrackingReceiver.f2802a) {
                cx cxVar = CampaignTrackingReceiver.f2803b;
                if (cxVar != null && cxVar.m5667b()) {
                    cxVar.m5663a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean m4188a(Context context) {
        C1314c.m4623a((Object) context);
        if (f2816b != null) {
            return f2816b.booleanValue();
        }
        boolean a = vp.m9515a(context, "com.google.android.gms.analytics.CampaignTrackingService");
        f2816b = Boolean.valueOf(a);
        return a;
    }

    private Handler m4189b() {
        Handler handler = this.f2817a;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.f2817a = handler;
        return handler;
    }

    protected void m4190a(vg vgVar, Handler handler, int i) {
        handler.post(new C12053(this, i, vgVar));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        uf.m9151a((Context) this).m9158f().m4250b("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        uf.m9151a((Context) this).m9158f().m4250b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m4187a();
        uf a = uf.m9151a((Context) this);
        vg f = a.m9158f();
        String stringExtra = intent.getStringExtra("referrer");
        Handler b = m4189b();
        if (TextUtils.isEmpty(stringExtra)) {
            f.m4260e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            a.m9160h().m4371a(new C12031(this, f, b, i2));
        } else {
            int d = a.m9157e().m9335d();
            if (stringExtra.length() > d) {
                f.m4256c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(d));
                stringExtra = stringExtra.substring(0, d);
            }
            f.m4248a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), stringExtra);
            a.m9161i().m9142a(stringExtra, new C12042(this, f, b, i2));
        }
        return 2;
    }
}
