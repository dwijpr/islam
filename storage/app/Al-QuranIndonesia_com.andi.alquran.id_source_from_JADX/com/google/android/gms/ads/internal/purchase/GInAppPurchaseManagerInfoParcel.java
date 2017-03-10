package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.nk;
import com.google.android.gms.internal.op;
import com.google.android.gms.p039a.C1108c.C1110a;
import com.google.android.gms.p039a.C1111d;

@op
public final class GInAppPurchaseManagerInfoParcel extends zza implements ReflectedParcelable {
    public static final Creator<GInAppPurchaseManagerInfoParcel> CREATOR;
    public final int versionCode;
    public final nk zzOL;
    public final Context zzOM;
    public final zzj zzON;
    public final zzk zzvC;

    static {
        CREATOR = new zza();
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzvC = (zzk) C1111d.m3897a(C1110a.m3895a(iBinder));
        this.zzOL = (nk) C1111d.m3897a(C1110a.m3895a(iBinder2));
        this.zzOM = (Context) C1111d.m3897a(C1110a.m3895a(iBinder3));
        this.zzON = (zzj) C1111d.m3897a(C1110a.m3895a(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk com_google_android_gms_ads_internal_purchase_zzk, nk nkVar, zzj com_google_android_gms_ads_internal_purchase_zzj) {
        this.versionCode = 2;
        this.zzOM = context;
        this.zzvC = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzOL = nkVar;
        this.zzON = com_google_android_gms_ads_internal_purchase_zzj;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder m4009a() {
        return C1111d.m3896a(this.zzON).asBinder();
    }

    IBinder m4010b() {
        return C1111d.m3896a(this.zzvC).asBinder();
    }

    IBinder m4011c() {
        return C1111d.m3896a(this.zzOL).asBinder();
    }

    IBinder m4012d() {
        return C1111d.m3896a(this.zzOM).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m4013a(this, parcel, i);
    }
}
