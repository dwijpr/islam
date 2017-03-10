package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.internal.np.C1151a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;

@op
public final class zzg extends C1151a implements ServiceConnection {
    zzb f2532a;
    private boolean f2533b;
    private Context f2534c;
    private int f2535d;
    private Intent f2536e;
    private zzf f2537f;
    private String f2538g;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        this.f2533b = false;
        this.f2538g = str;
        this.f2535d = i;
        this.f2536e = intent;
        this.f2533b = z;
        this.f2534c = context;
        this.f2537f = com_google_android_gms_ads_internal_purchase_zzf;
    }

    public void finishPurchase() {
        int zzd = zzv.zzcX().zzd(this.f2536e);
        if (this.f2535d == -1 && zzd == 0) {
            this.f2532a = new zzb(this.f2534c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C1367a.m4904a().m4910a(this.f2534c, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.f2538g;
    }

    public Intent getPurchaseData() {
        return this.f2536e;
    }

    public int getResultCode() {
        return this.f2535d;
    }

    public boolean isVerified() {
        return this.f2533b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        sg.m8448d("In-app billing service connected.");
        this.f2532a.zzV(iBinder);
        String zzaE = zzv.zzcX().zzaE(zzv.zzcX().zze(this.f2536e));
        if (zzaE != null) {
            if (this.f2532a.zzl(this.f2534c.getPackageName(), zzaE) == 0) {
                zzh.zzq(this.f2534c).zza(this.f2537f);
            }
            C1367a.m4904a().m4908a(this.f2534c, (ServiceConnection) this);
            this.f2532a.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        sg.m8448d("In-app billing service disconnected.");
        this.f2532a.destroy();
    }
}
