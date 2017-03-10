package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rl;
import com.google.android.gms.internal.rm;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import java.util.List;

@op
public class zzc extends rl implements ServiceConnection {
    private final Object f2511a;
    private boolean f2512b;
    private Context f2513c;
    private nq f2514d;
    private zzb f2515e;
    private zzh f2516f;
    private List<zzf> f2517g;
    private zzk f2518h;

    /* renamed from: com.google.android.gms.ads.internal.purchase.zzc.1 */
    class C11481 implements Runnable {
        final /* synthetic */ zzf f2508a;
        final /* synthetic */ Intent f2509b;
        final /* synthetic */ zzc f2510c;

        C11481(zzc com_google_android_gms_ads_internal_purchase_zzc, zzf com_google_android_gms_ads_internal_purchase_zzf, Intent intent) {
            this.f2510c = com_google_android_gms_ads_internal_purchase_zzc;
            this.f2508a = com_google_android_gms_ads_internal_purchase_zzf;
            this.f2509b = intent;
        }

        public void run() {
            try {
                if (this.f2510c.f2518h.zza(this.f2508a.zzPf, -1, this.f2509b)) {
                    this.f2510c.f2514d.m7777a(new zzg(this.f2510c.f2513c, this.f2508a.zzPg, true, -1, this.f2509b, this.f2508a));
                } else {
                    this.f2510c.f2514d.m7777a(new zzg(this.f2510c.f2513c, this.f2508a.zzPg, false, -1, this.f2509b, this.f2508a));
                }
            } catch (RemoteException e) {
                sg.m8449e("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public zzc(Context context, nq nqVar, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, nqVar, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzq(context.getApplicationContext()));
    }

    zzc(Context context, nq nqVar, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.f2511a = new Object();
        this.f2512b = false;
        this.f2517g = null;
        this.f2513c = context;
        this.f2514d = nqVar;
        this.f2518h = com_google_android_gms_ads_internal_purchase_zzk;
        this.f2515e = com_google_android_gms_ads_internal_purchase_zzb;
        this.f2516f = com_google_android_gms_ads_internal_purchase_zzh;
        this.f2517g = this.f2516f.zzg(10);
    }

    private void m4015a(long j) {
        do {
            if (!m4017b(j)) {
                rm.m8450a("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f2512b);
    }

    private boolean m4017b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f2511a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            sg.m8449e("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m4019a() {
        /*
        r12 = this;
        r0 = r12.f2517g;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.f2517g;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2 = r0.zzPg;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.f2515e;
        r2 = r12.f2513c;
        r2 = r2.getPackageName();
        r0 = r1.zzm(r2, r0);
        if (r0 != 0) goto L_0x0055;
    L_0x0035:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x003d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0043:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.f2516f;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2.zza(r0);
        goto L_0x003d;
    L_0x0055:
        r1 = com.google.android.gms.ads.internal.zzv.zzcX();
        r1 = r1.zzd(r0);
        if (r1 != 0) goto L_0x0035;
    L_0x005f:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0079:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x00bb;
    L_0x007f:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x0089:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.ads.internal.purchase.zzf) r3;
        r10 = com.google.android.gms.ads.internal.zzv.zzcX();
        r10 = r10.zzaD(r1);
        r11 = r3.zzPf;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x00b7;
    L_0x00b1:
        r12.m4020a(r3, r1, r2);
        r6.remove(r0);
    L_0x00b7:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0079;
    L_0x00bb:
        if (r5 == 0) goto L_0x0035;
    L_0x00bd:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x00c3:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzc.a():void");
    }

    protected void m4020a(zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        Intent intent = new Intent();
        zzv.zzcX();
        intent.putExtra("RESPONSE_CODE", 0);
        zzv.zzcX();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzv.zzcX();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        rq.f5755a.post(new C11481(this, com_google_android_gms_ads_internal_purchase_zzf, intent));
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f2511a) {
            this.f2515e.zzV(iBinder);
            m4019a();
            this.f2512b = true;
            this.f2511a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        sg.m8448d("In-app billing service disconnected.");
        this.f2515e.destroy();
    }

    public void onStop() {
        synchronized (this.f2511a) {
            C1367a.m4904a().m4908a(this.f2513c, (ServiceConnection) this);
            this.f2515e.destroy();
        }
    }

    public void zzcm() {
        synchronized (this.f2511a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C1367a.m4904a().m4910a(this.f2513c, intent, (ServiceConnection) this, 1);
            m4015a(SystemClock.elapsedRealtime());
            C1367a.m4904a().m4908a(this.f2513c, (ServiceConnection) this);
            this.f2515e.destroy();
        }
    }
}
