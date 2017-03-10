package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.internal.nk;
import com.google.android.gms.internal.nn.C1150a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;

@op
public class zze extends C1150a implements ServiceConnection {
    zzh f2523a;
    private final Activity f2524b;
    private Context f2525c;
    private nk f2526d;
    private zzb f2527e;
    private zzf f2528f;
    private zzj f2529g;
    private zzk f2530h;
    private String f2531i;

    public zze(Activity activity) {
        this.f2531i = null;
        this.f2524b = activity;
        this.f2523a = zzh.zzq(this.f2524b.getApplicationContext());
    }

    protected void m4024a(String str, boolean z, int i, Intent intent) {
        if (this.f2529g != null) {
            this.f2529g.zza(str, z, i, intent, this.f2528f);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int zzd = zzv.zzcX().zzd(intent);
                if (i2 == -1) {
                    zzv.zzcX();
                    if (zzd == 0) {
                        if (this.f2530h.zza(this.f2531i, i2, intent)) {
                            z = true;
                        }
                        this.f2526d.recordPlayBillingResolution(zzd);
                        this.f2524b.finish();
                        m4024a(this.f2526d.getProductId(), z, i2, intent);
                    }
                }
                this.f2523a.zza(this.f2528f);
                this.f2526d.recordPlayBillingResolution(zzd);
                this.f2524b.finish();
                m4024a(this.f2526d.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                sg.m8449e("Fail to process purchase result.");
                this.f2524b.finish();
            } finally {
                this.f2531i = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.f2524b.getIntent());
        this.f2529g = zzc.zzON;
        this.f2530h = zzc.zzvC;
        this.f2526d = zzc.zzOL;
        this.f2527e = new zzb(this.f2524b.getApplicationContext());
        this.f2525c = zzc.zzOM;
        if (this.f2524b.getResources().getConfiguration().orientation == 2) {
            this.f2524b.setRequestedOrientation(zzv.zzcL().m8560a());
        } else {
            this.f2524b.setRequestedOrientation(zzv.zzcL().m8574b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        C1367a.m4904a().m4910a(this.f2524b, intent, (ServiceConnection) this, 1);
    }

    public void onDestroy() {
        C1367a.m4904a().m4908a(this.f2524b, (ServiceConnection) this);
        this.f2527e.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f2527e.zzV(iBinder);
        try {
            this.f2531i = this.f2530h.zzis();
            Bundle zzb = this.f2527e.zzb(this.f2524b.getPackageName(), this.f2526d.getProductId(), this.f2531i);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzv.zzcX().zzd(zzb);
                this.f2526d.recordPlayBillingResolution(zzd);
                m4024a(this.f2526d.getProductId(), false, zzd, null);
                this.f2524b.finish();
                return;
            }
            this.f2528f = new zzf(this.f2526d.getProductId(), this.f2531i);
            this.f2523a.zzb(this.f2528f);
            this.f2524b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            sg.m8447c("Error when connecting in-app billing service", e);
            this.f2524b.finish();
        } catch (SendIntentException e3) {
            e = e3;
            sg.m8447c("Error when connecting in-app billing service", e);
            this.f2524b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        sg.m8448d("In-app billing service disconnected.");
        this.f2527e.destroy();
    }
}
