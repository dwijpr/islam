package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.p039a.C1111d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@op
public class py extends zzb implements qm {
    private static final mc f5530l;
    private final Map<String, qq> f5531m;
    private boolean f5532n;

    /* renamed from: com.google.android.gms.internal.py.1 */
    class C19211 implements Runnable {
        final /* synthetic */ py f5527a;

        C19211(py pyVar) {
            this.f5527a = pyVar;
        }

        public void run() {
            this.f5527a.m4032a(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.py.2 */
    class C19222 implements Runnable {
        final /* synthetic */ C1938a f5528a;
        final /* synthetic */ py f5529b;

        C19222(py pyVar, C1938a c1938a) {
            this.f5529b = pyVar;
            this.f5528a = c1938a;
        }

        public void run() {
            this.f5529b.zzb(new rc(this.f5528a, null, null, null, null, null, null, null));
        }
    }

    static {
        f5530l = new mc();
    }

    public py(Context context, zzd com_google_android_gms_ads_internal_zzd, zzec com_google_android_gms_internal_zzec, md mdVar, zzqa com_google_android_gms_internal_zzqa) {
        super(context, com_google_android_gms_internal_zzec, null, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
        this.f5531m = new HashMap();
    }

    private C1938a m8226a(C1938a c1938a) {
        rm.m8450a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = pj.m8126a(c1938a.f5595b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, c1938a.f5594a.f6544e);
            lt ltVar = new lt(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new C1938a(c1938a.f5594a, c1938a.f5595b, new lu(Arrays.asList(new lt[]{ltVar}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, BuildConfig.VERSION_NAME, -1, 0, 1, null, 0, -1, -1, false), c1938a.f5597d, c1938a.f5598e, c1938a.f5599f, c1938a.f5600g, c1938a.f5601h);
        } catch (Throwable e) {
            sg.m8445b("Unable to generate ad state for non-mediated rewarded video.", e);
            return m8228b(c1938a);
        }
    }

    private C1938a m8228b(C1938a c1938a) {
        return new C1938a(c1938a.f5594a, c1938a.f5595b, null, c1938a.f5597d, 0, c1938a.f5599f, c1938a.f5600g, c1938a.f5601h);
    }

    public void m8229a(Context context) {
        for (qq a : this.f5531m.values()) {
            try {
                a.m8341a().m7463a(C1111d.m3896a((Object) context));
            } catch (Throwable e) {
                sg.m8445b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void m8230a(zznx com_google_android_gms_internal_zznx) {
        C1314c.m4631b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(com_google_android_gms_internal_zznx.f6625c)) {
            sg.m8449e("Invalid ad unit id. Aborting.");
            rq.f5755a.post(new C19211(this));
            return;
        }
        this.f5532n = false;
        this.f.zzvd = com_google_android_gms_internal_zznx.f6625c;
        super.zzb(com_google_android_gms_internal_zznx.f6624b);
    }

    protected boolean m8231a(zzdy com_google_android_gms_internal_zzdy, rc rcVar, boolean z) {
        return false;
    }

    public qq m8232b(String str) {
        qq qqVar;
        Throwable th;
        String str2;
        String valueOf;
        qq qqVar2 = (qq) this.f5531m.get(str);
        if (qqVar2 != null) {
            return qqVar2;
        }
        try {
            qqVar = new qq(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? f5530l : this.j).m7452a(str), this);
            try {
                this.f5531m.put(str, qqVar);
                return qqVar;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                sg.m8447c(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return qqVar;
            }
        } catch (Throwable e2) {
            th = e2;
            qqVar = qqVar2;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            sg.m8447c(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return qqVar;
        }
    }

    public void m8233b(zzok com_google_android_gms_internal_zzok) {
        if (!(this.f.zzvk == null || this.f.zzvk.f5625o == null)) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk, this.f.zzvd, false, this.f.zzvk.f5625o.f4847k);
        }
        if (!(this.f.zzvk == null || this.f.zzvk.f5628r == null || TextUtils.isEmpty(this.f.zzvk.f5628r.f4862j))) {
            com_google_android_gms_internal_zzok = new zzok(this.f.zzvk.f5628r.f4862j, this.f.zzvk.f5628r.f4863k);
        }
        m4034a(com_google_android_gms_internal_zzok);
    }

    public void destroy() {
        C1314c.m4631b("destroy must be called on the main UI thread.");
        for (String str : this.f5531m.keySet()) {
            String str2;
            try {
                qq qqVar = (qq) this.f5531m.get(str2);
                if (!(qqVar == null || qqVar.m8341a() == null)) {
                    qqVar.m8341a().m7473c();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to destroy adapter: ";
                str2 = String.valueOf(str2);
                sg.m8449e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void m8234g() {
        C1314c.m4631b("showAd must be called on the main UI thread.");
        if (m8235h()) {
            this.f5532n = true;
            qq b = m8232b(this.f.zzvk.f5627q);
            if (b != null && b.m8341a() != null) {
                try {
                    b.m8341a().m7476f();
                    return;
                } catch (Throwable e) {
                    sg.m8447c("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        sg.m8449e("The reward video has not loaded.");
    }

    public boolean m8235h() {
        C1314c.m4631b("isLoaded must be called on the main UI thread.");
        return this.f.zzvh == null && this.f.zzvi == null && this.f.zzvk != null && !this.f5532n;
    }

    public void m8236i() {
        m4043a(this.f.zzvk, false);
        m4039c();
    }

    public void m8237j() {
        if (!(this.f.zzvk == null || this.f.zzvk.f5625o == null)) {
            zzv.zzdc().m7436a(this.f.zzqr, this.f.zzvf.f6636b, this.f.zzvk, this.f.zzvd, false, this.f.zzvk.f5625o.f4846j);
        }
        m4041e();
    }

    public void m8238k() {
        m4031a();
    }

    public void m8239l() {
        onAdClicked();
    }

    public void m8240m() {
        m4037b();
    }

    public void pause() {
        C1314c.m4631b("pause must be called on the main UI thread.");
        for (String str : this.f5531m.keySet()) {
            String str2;
            try {
                qq qqVar = (qq) this.f5531m.get(str2);
                if (!(qqVar == null || qqVar.m8341a() == null)) {
                    qqVar.m8341a().m7474d();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to pause adapter: ";
                str2 = String.valueOf(str2);
                sg.m8449e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void resume() {
        C1314c.m4631b("resume must be called on the main UI thread.");
        for (String str : this.f5531m.keySet()) {
            String str2;
            try {
                qq qqVar = (qq) this.f5531m.get(str2);
                if (!(qqVar == null || qqVar.m8341a() == null)) {
                    qqVar.m8341a().m7475e();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to resume adapter: ";
                str2 = String.valueOf(str2);
                sg.m8449e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void zza(C1938a c1938a, io ioVar) {
        if (c1938a.f5598e != -2) {
            rq.f5755a.post(new C19222(this, c1938a));
            return;
        }
        this.f.zzvl = c1938a;
        if (c1938a.f5596c == null) {
            this.f.zzvl = m8226a(c1938a);
        }
        this.f.zzvF = 0;
        this.f.zzvi = zzv.zzcI().m7818a(this.f.zzqr, this.f.zzvl, this);
    }

    public boolean zza(rc rcVar, rc rcVar2) {
        return true;
    }
}
