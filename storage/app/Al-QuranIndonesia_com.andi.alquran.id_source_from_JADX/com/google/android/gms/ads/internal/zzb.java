package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.recyclerview.BuildConfig;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzg;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.nk;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rd;
import com.google.android.gms.internal.re;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzmh.C2082a;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzqa;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@op
public abstract class zzb extends zza implements zzh, zzj, zzt, ki, lv {
    protected final md f2561j;
    protected transient boolean f2562k;
    private final Messenger f2563l;

    /* renamed from: com.google.android.gms.ads.internal.zzb.1 */
    class C11571 implements Runnable {
        final /* synthetic */ Intent f2557a;
        final /* synthetic */ zzb f2558b;

        C11571(zzb com_google_android_gms_ads_internal_zzb, Intent intent) {
            this.f2558b = com_google_android_gms_ads_internal_zzb;
            this.f2557a = intent;
        }

        public void run() {
            int zzd = zzv.zzcX().zzd(this.f2557a);
            zzv.zzcX();
            if (!(zzd != 0 || this.f2558b.f.zzvk == null || this.f2558b.f.zzvk.f5612b == null || this.f2558b.f.zzvk.f5612b.m8773i() == null)) {
                this.f2558b.f.zzvk.f5612b.m8773i().close();
            }
            this.f2558b.f.f2745u = false;
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.2 */
    class C11582 implements Runnable {
        final /* synthetic */ zzb f2559a;

        C11582(zzb com_google_android_gms_ads_internal_zzb) {
            this.f2559a = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.f2559a.e.pause();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.3 */
    class C11593 implements Runnable {
        final /* synthetic */ zzb f2560a;

        C11593(zzb com_google_android_gms_ads_internal_zzb) {
            this.f2560a = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.f2560a.e.resume();
        }
    }

    public zzb(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        this(new zzw(context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzqa), mdVar, null, com_google_android_gms_ads_internal_zzd);
    }

    protected zzb(zzw com_google_android_gms_ads_internal_zzw, md mdVar, zzs com_google_android_gms_ads_internal_zzs, zzd com_google_android_gms_ads_internal_zzd) {
        super(com_google_android_gms_ads_internal_zzw, com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzd);
        this.f2561j = mdVar;
        this.f2563l = new Messenger(new ni(this.f.zzqr));
        this.f2562k = false;
    }

    private C2082a m4042a(zzdy com_google_android_gms_internal_zzdy, Bundle bundle, re reVar) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.f.zzqr.getApplicationInfo();
        try {
            packageInfo = this.f.zzqr.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.f.zzqr.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.f.f2727c == null || this.f.f2727c.getParent() == null)) {
            int[] iArr = new int[2];
            this.f.f2727c.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.f.f2727c.getWidth();
            int height = this.f.f2727c.getHeight();
            int i3 = 0;
            if (this.f.f2727c.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String d = zzv.zzcN().m8408d();
        this.f.zzvm = new rd(d, this.f.zzvd);
        this.f.zzvm.m8371a(com_google_android_gms_internal_zzdy);
        String a = zzv.zzcJ().m8496a(this.f.zzqr, this.f.f2727c, this.f.zzvj);
        long j = 0;
        if (this.f.f2731g != null) {
            try {
                j = this.f.f2731g.m6420b();
            } catch (RemoteException e2) {
                sg.m8449e("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle a2 = zzv.zzcN().m8386a(this.f.zzqr, this, d);
        List arrayList = new ArrayList();
        for (i = 0; i < this.f.f2737m.size(); i++) {
            arrayList.add((String) this.f.f2737m.m1002b(i));
        }
        boolean z = this.f.f2732h != null;
        boolean z2 = this.f.f2733i != null && zzv.zzcN().m8427u();
        String str = BuildConfig.VERSION_NAME;
        if (((Boolean) C1648if.cR.m6682c()).booleanValue()) {
            sg.m8444b("Getting webview cookie from CookieManager.");
            CookieManager b = zzv.zzcL().m8575b(this.f.zzqr);
            if (b != null) {
                str = b.getCookie("googleads.g.doubleclick.net");
            }
        }
        String str2 = null;
        if (reVar != null) {
            str2 = reVar.m8383c();
        }
        return new C2082a(bundle2, com_google_android_gms_internal_zzdy, this.f.zzvj, this.f.zzvd, applicationInfo, packageInfo, d, zzv.zzcN().m8388a(), this.f.zzvf, a2, this.f.f2742r, arrayList, bundle, zzv.zzcN().m8414h(), this.f2563l, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, a, j, uuid, C1648if.m6703a(), this.f.f2725a, this.f.f2738n, new zzmo(z, z2, false), this.f.zzdq(), zzv.zzcJ().m8549g(), zzv.zzcJ().m8552h(), zzv.zzcJ().m8556k(this.f.zzqr), zzv.zzcJ().m8529b(this.f.f2727c), this.f.zzqr instanceof Activity, zzv.zzcN().m8419m(), str, str2, zzv.zzcN().m8422p(), zzv.zzdg().m7134a(), zzv.zzcJ().m8554i(), zzv.zzcR().m8631a());
    }

    protected void m4043a(rc rcVar, boolean z) {
        if (rcVar == null) {
            sg.m8449e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.m4038b(rcVar);
        if (!(rcVar.f5628r == null || rcVar.f5628r.f4856d == null)) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, rcVar, this.f.zzvd, z, rcVar.f5628r.f4856d);
        }
        if (rcVar.f5625o != null && rcVar.f5625o.f4843g != null) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, rcVar, this.f.zzvd, z, rcVar.f5625o.f4843g);
        }
    }

    boolean m4044a(rc rcVar) {
        zzdy com_google_android_gms_internal_zzdy;
        boolean z = false;
        if (this.g != null) {
            com_google_android_gms_internal_zzdy = this.g;
            this.g = null;
        } else {
            com_google_android_gms_internal_zzdy = rcVar.f5611a;
            if (com_google_android_gms_internal_zzdy.f6435c != null) {
                z = com_google_android_gms_internal_zzdy.f6435c.getBoolean("_noRefresh", false);
            }
        }
        return m4046a(com_google_android_gms_internal_zzdy, rcVar, z);
    }

    protected boolean m4045a(zzdy com_google_android_gms_internal_zzdy) {
        return super.m4036a(com_google_android_gms_internal_zzdy) && !this.f2562k;
    }

    protected boolean m4046a(zzdy com_google_android_gms_internal_zzdy, rc rcVar, boolean z) {
        if (!z && this.f.zzdm()) {
            if (rcVar.f5618h > 0) {
                this.e.zza(com_google_android_gms_internal_zzdy, rcVar.f5618h);
            } else if (rcVar.f5628r != null && rcVar.f5628r.f4861i > 0) {
                this.e.zza(com_google_android_gms_internal_zzdy, rcVar.f5628r.f4861i);
            } else if (!rcVar.f5624n && rcVar.f5614d == 2) {
                this.e.zzh(com_google_android_gms_internal_zzdy);
            }
        }
        return this.e.zzcv();
    }

    protected boolean m4047f() {
        return zzv.zzcJ().m8524a(this.f.zzqr.getPackageManager(), this.f.zzqr.getPackageName(), "android.permission.INTERNET") && zzv.zzcJ().m8523a(this.f.zzqr);
    }

    public String getMediationAdapterClassName() {
        return this.f.zzvk == null ? null : this.f.zzvk.f5627q;
    }

    public void onAdClicked() {
        if (this.f.zzvk == null) {
            sg.m8449e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.f.zzvk.f5628r == null || this.f.zzvk.f5628r.f4855c == null)) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk, this.f.zzvd, false, this.f.zzvk.f5628r.f4855c);
        }
        if (!(this.f.zzvk.f5625o == null || this.f.zzvk.f5625o.f4842f == null)) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk, this.f.zzvd, false, this.f.zzvk.f5625o.f4842f);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.h.m6059d(this.f.zzvk);
    }

    public void onResume() {
        this.h.m6060e(this.f.zzvk);
    }

    public void pause() {
        C1314c.m4631b("pause must be called on the main UI thread.");
        if (!(this.f.zzvk == null || this.f.zzvk.f5612b == null || !this.f.zzdm())) {
            zzv.zzcL().m8573a(this.f.zzvk.f5612b);
        }
        if (!(this.f.zzvk == null || this.f.zzvk.f5626p == null)) {
            try {
                this.f.zzvk.f5626p.m7474d();
            } catch (RemoteException e) {
                sg.m8449e("Could not pause mediation adapter.");
            }
        }
        this.h.m6059d(this.f.zzvk);
        this.e.pause();
    }

    public void recordImpression() {
        m4043a(this.f.zzvk, false);
    }

    public void resume() {
        C1314c.m4631b("resume must be called on the main UI thread.");
        sx sxVar = null;
        if (!(this.f.zzvk == null || this.f.zzvk.f5612b == null)) {
            sxVar = this.f.zzvk.f5612b;
        }
        if (sxVar != null && this.f.zzdm()) {
            zzv.zzcL().m8577b(this.f.zzvk.f5612b);
        }
        if (!(this.f.zzvk == null || this.f.zzvk.f5626p == null)) {
            try {
                this.f.zzvk.f5626p.m7475e();
            } catch (RemoteException e) {
                sg.m8449e("Could not resume mediation adapter.");
            }
        }
        if (sxVar == null || !sxVar.m8785u()) {
            this.e.resume();
        }
        this.h.m6060e(this.f.zzvk);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(nl nlVar) {
        C1314c.m4631b("setInAppPurchaseListener must be called on the main UI thread.");
        this.f.f2732h = nlVar;
    }

    public void zza(nq nqVar, String str) {
        C1314c.m4631b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f.f2743s = new zzk(str);
        this.f.f2733i = nqVar;
        if (!zzv.zzcN().m8413g() && nqVar != null) {
            new zzc(this.f.zzqr, this.f.f2733i, this.f.f2743s).zziw();
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        nk com_google_android_gms_ads_internal_purchase_zzd = new zzd(str, arrayList, this.f.zzqr, this.f.zzvf.f6636b);
        if (this.f.f2732h == null) {
            sg.m8449e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!gr.m6416a().m8705b(this.f.zzqr)) {
                sg.m8449e("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.f.f2733i == null) {
                sg.m8449e("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.f.f2743s == null) {
                sg.m8449e("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.f.f2745u) {
                sg.m8449e("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.f.f2745u = true;
                try {
                    if (this.f.f2733i.m7778a(str)) {
                        zzv.zzcX().zza(this.f.zzqr, this.f.zzvf.f6639e, new GInAppPurchaseManagerInfoParcel(this.f.zzqr, this.f.f2743s, com_google_android_gms_ads_internal_purchase_zzd, this));
                        return;
                    } else {
                        this.f.f2745u = false;
                        return;
                    }
                } catch (RemoteException e) {
                    sg.m8449e("Could not start In-App purchase.");
                    this.f.f2745u = false;
                    return;
                }
            }
        }
        try {
            this.f.f2732h.m7209a(com_google_android_gms_ads_internal_purchase_zzd);
        } catch (RemoteException e2) {
            sg.m8449e("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        try {
            if (this.f.f2733i != null) {
                this.f.f2733i.m7777a(new zzg(this.f.zzqr, str, z, i, intent, com_google_android_gms_ads_internal_purchase_zzf));
            }
        } catch (RemoteException e) {
            sg.m8449e("Fail to invoke PlayStorePurchaseListener.");
        }
        rq.f5755a.postDelayed(new C11571(this, intent), 500);
    }

    protected boolean zza(rc rcVar, rc rcVar2) {
        int i;
        int i2 = 0;
        if (!(rcVar == null || rcVar.f5629s == null)) {
            rcVar.f5629s.m7395a(null);
        }
        if (rcVar2.f5629s != null) {
            rcVar2.f5629s.m7395a((lv) this);
        }
        if (rcVar2.f5628r != null) {
            i = rcVar2.f5628r.f4867o;
            i2 = rcVar2.f5628r.f4868p;
        } else {
            i = 0;
        }
        this.f.zzvD.m8438a(i, i2);
        return true;
    }

    public boolean zza(zzdy com_google_android_gms_internal_zzdy, io ioVar) {
        if (!m4047f()) {
            return false;
        }
        Bundle m = zzv.zzcJ().m8558m(this.f.zzqr);
        this.e.cancel();
        this.f.zzvF = 0;
        re reVar = null;
        if (((Boolean) C1648if.cz.m6682c()).booleanValue()) {
            reVar = zzv.zzcN().m8423q();
            zzv.zzdf().zza(this.f.zzqr, this.f.zzvf, false, reVar, reVar.m8384d(), this.f.zzvd);
        }
        C2082a a = m4042a(com_google_android_gms_internal_zzdy, m, reVar);
        ioVar.m6744a("seq_num", a.f6504g);
        ioVar.m6744a("request_id", a.f6519v);
        ioVar.m6744a("session_id", a.f6505h);
        if (a.f6503f != null) {
            ioVar.m6744a("app_version", String.valueOf(a.f6503f.versionCode));
        }
        this.f.zzvh = zzv.zzcF().m7941a(this.f.zzqr, a, this.f.f2726b, this);
        return true;
    }

    public void zzb(rc rcVar) {
        super.zzb(rcVar);
        if (rcVar.f5625o != null) {
            sg.m8444b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.f.f2727c != null) {
                this.f.f2727c.zzdu();
            }
            sg.m8444b("Pinging network fill URLs.");
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, rcVar, this.f.zzvd, false, rcVar.f5625o.f4844h);
            if (!(rcVar.f5628r == null || rcVar.f5628r.f4858f == null || rcVar.f5628r.f4858f.size() <= 0)) {
                sg.m8444b("Pinging urls remotely");
                zzv.zzcJ().m8517a(this.f.zzqr, rcVar.f5628r.f4858f);
            }
        } else {
            sg.m8444b("Enable the debug gesture detector on the admob ad frame.");
            if (this.f.f2727c != null) {
                this.f.f2727c.zzdt();
            }
        }
        if (rcVar.f5614d == 3 && rcVar.f5628r != null && rcVar.f5628r.f4857e != null) {
            sg.m8444b("Pinging no fill URLs.");
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, rcVar, this.f.zzvd, false, rcVar.f5628r.f4857e);
        }
    }

    public void zzbN() {
        this.h.m6057b(this.f.zzvk);
        this.f2562k = false;
        m4031a();
        this.f.zzvm.m8376c();
    }

    public void zzbO() {
        this.f2562k = true;
        m4039c();
    }

    public void zzbP() {
        onAdClicked();
    }

    public void zzbQ() {
        zzbN();
    }

    public void zzbR() {
        zzbE();
    }

    public void zzbS() {
        zzbO();
    }

    public void zzbT() {
        if (this.f.zzvk != null) {
            String str = this.f.zzvk.f5627q;
            sg.m8449e(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        m4043a(this.f.zzvk, true);
        m4040d();
    }

    public void zzbU() {
        recordImpression();
    }

    public void zzbV() {
        zzv.zzcJ().m8518a(new C11582(this));
    }

    public void zzbW() {
        zzv.zzcJ().m8518a(new C11593(this));
    }
}
