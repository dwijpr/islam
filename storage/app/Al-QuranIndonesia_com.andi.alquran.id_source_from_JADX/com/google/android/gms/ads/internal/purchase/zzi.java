package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rf;
import com.google.android.gms.internal.sg;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class zzi {

    /* renamed from: com.google.android.gms.ads.internal.purchase.zzi.1 */
    class C11521 implements ServiceConnection {
        final /* synthetic */ Context f2543a;

        C11521(zzi com_google_android_gms_ads_internal_purchase_zzi, Context context) {
            this.f2543a = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = false;
            zzb com_google_android_gms_ads_internal_purchase_zzb = new zzb(this.f2543a.getApplicationContext(), false);
            com_google_android_gms_ads_internal_purchase_zzb.zzV(iBinder);
            int zzb = com_google_android_gms_ads_internal_purchase_zzb.zzb(3, this.f2543a.getPackageName(), "inapp");
            rf zzcN = zzv.zzcN();
            if (zzb == 0) {
                z = true;
            }
            zzcN.m8411e(z);
            C1367a.m4904a().m4908a(this.f2543a, (ServiceConnection) this);
            com_google_android_gms_ads_internal_purchase_zzb.destroy();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        zzv.zzcJ().m8509a(context, intent);
    }

    public String zzaD(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                sg.m8449e("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String zzaE(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                sg.m8449e("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public int zzd(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            sg.m8449e("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public int zzd(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            sg.m8449e("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public String zze(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String zzf(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public void zzr(Context context) {
        ServiceConnection c11521 = new C11521(this, context);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        C1367a.m4904a().m4910a(context, intent, c11521, 1);
    }
}
