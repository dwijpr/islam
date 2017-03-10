package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.oq.C1156a;
import com.google.android.gms.internal.os.C1881a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.zzmh.C2082a;
import org.json.JSONObject;

@op
public class or extends rl implements C1881a {
    rs f5271a;
    zzmk f5272b;
    lu f5273c;
    private final C1156a f5274d;
    private final C2082a f5275e;
    private final Object f5276f;
    private final Context f5277g;
    private final cg f5278h;
    private zzmh f5279i;
    private Runnable f5280j;

    /* renamed from: com.google.android.gms.internal.or.1 */
    class C18781 implements Runnable {
        final /* synthetic */ or f5267a;

        C18781(or orVar) {
            this.f5267a = orVar;
        }

        public void run() {
            synchronized (this.f5267a.f5276f) {
                if (this.f5267a.f5271a == null) {
                    return;
                }
                this.f5267a.onStop();
                this.f5267a.m7945a(2, "Timed out waiting for ad response.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.or.2 */
    class C18792 implements Runnable {
        final /* synthetic */ sq f5268a;
        final /* synthetic */ or f5269b;

        C18792(or orVar, sq sqVar) {
            this.f5269b = orVar;
            this.f5268a = sqVar;
        }

        public void run() {
            synchronized (this.f5269b.f5276f) {
                this.f5269b.f5271a = this.f5269b.m7949a(this.f5269b.f5275e.f6507j, this.f5268a);
                if (this.f5269b.f5271a == null) {
                    this.f5269b.m7945a(0, "Could not start the ad request service.");
                    rq.f5755a.removeCallbacks(this.f5269b.f5280j);
                }
            }
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.or.a */
    static final class C1880a extends Exception {
        private final int f5270a;

        public C1880a(String str, int i) {
            super(str);
            this.f5270a = i;
        }

        public int m7942a() {
            return this.f5270a;
        }
    }

    public or(Context context, C2082a c2082a, cg cgVar, C1156a c1156a) {
        this.f5276f = new Object();
        this.f5274d = c1156a;
        this.f5277g = context;
        this.f5275e = c2082a;
        this.f5278h = cgVar;
    }

    private void m7945a(int i, String str) {
        if (i == 3 || i == -1) {
            sg.m8448d(str);
        } else {
            sg.m8449e(str);
        }
        if (this.f5272b == null) {
            this.f5272b = new zzmk(i);
        } else {
            this.f5272b = new zzmk(i, this.f5272b.f6592k);
        }
        this.f5274d.zza(new C1938a(this.f5279i != null ? this.f5279i : new zzmh(this.f5275e, null, -1), this.f5272b, this.f5273c, null, i, -1, this.f5272b.f6595n, null));
    }

    rs m7949a(zzqa com_google_android_gms_internal_zzqa, sq<zzmh> sqVar) {
        return os.m7956a(this.f5277g, com_google_android_gms_internal_zzqa, sqVar, this);
    }

    protected zzec m7950a(zzmh com_google_android_gms_internal_zzmh) {
        int i;
        if (this.f5272b.f6566A) {
            for (zzec com_google_android_gms_internal_zzec : com_google_android_gms_internal_zzmh.f6543d.f6458h) {
                if (com_google_android_gms_internal_zzec.f6460j) {
                    return new zzec(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzmh.f6543d.f6458h);
                }
            }
        }
        if (this.f5272b.f6594m == null) {
            throw new C1880a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f5272b.f6594m.split("x");
        if (split.length != 2) {
            String str = "Invalid ad size format from the ad response: ";
            String valueOf = String.valueOf(this.f5272b.f6594m);
            throw new C1880a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzec com_google_android_gms_internal_zzec2 : com_google_android_gms_internal_zzmh.f6543d.f6458h) {
                float f = this.f5277g.getResources().getDisplayMetrics().density;
                i = com_google_android_gms_internal_zzec2.f6456f == -1 ? (int) (((float) com_google_android_gms_internal_zzec2.f6457g) / f) : com_google_android_gms_internal_zzec2.f6456f;
                int i2 = com_google_android_gms_internal_zzec2.f6453c == -2 ? (int) (((float) com_google_android_gms_internal_zzec2.f6454d) / f) : com_google_android_gms_internal_zzec2.f6453c;
                if (parseInt == i && parseInt2 == i2 && !com_google_android_gms_internal_zzec2.f6460j) {
                    return new zzec(com_google_android_gms_internal_zzec2, com_google_android_gms_internal_zzmh.f6543d.f6458h);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.f5272b.f6594m);
            throw new C1880a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.f5272b.f6594m);
            throw new C1880a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    protected void m7951a() {
        if (this.f5272b.f6586e != -3) {
            if (TextUtils.isEmpty(this.f5272b.f6584c)) {
                throw new C1880a("No fill from ad server.", 3);
            }
            zzv.zzcN().m8392a(this.f5277g, this.f5272b.f6602u);
            if (this.f5272b.f6589h) {
                try {
                    this.f5273c = new lu(this.f5272b.f6584c);
                    zzv.zzcN().m8409d(this.f5273c.f4859g);
                } catch (Throwable e) {
                    sg.m8445b("Could not parse mediation config.", e);
                    String str = "Could not parse mediation config: ";
                    String valueOf = String.valueOf(this.f5272b.f6584c);
                    throw new C1880a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
                }
            }
            zzv.zzcN().m8409d(this.f5272b.f6576K);
            if (!TextUtils.isEmpty(this.f5272b.f6574I) && ((Boolean) C1648if.cR.m6682c()).booleanValue()) {
                sg.m8444b("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager b = zzv.zzcL().m8575b(this.f5277g);
                if (b != null) {
                    b.setCookie("googleads.g.doubleclick.net", this.f5272b.f6574I);
                }
            }
        }
    }

    public void m7952a(zzmk com_google_android_gms_internal_zzmk) {
        sg.m8444b("Received ad response.");
        this.f5272b = com_google_android_gms_internal_zzmk;
        long b = zzv.zzcP().m4927b();
        synchronized (this.f5276f) {
            this.f5271a = null;
        }
        zzv.zzcN().m8402b(this.f5277g, this.f5272b.f6573H);
        try {
            if (this.f5272b.f6586e == -2 || this.f5272b.f6586e == -3) {
                JSONObject jSONObject;
                m7951a();
                zzec a = this.f5279i.f6543d.f6458h != null ? m7950a(this.f5279i) : null;
                zzv.zzcN().m8404b(this.f5272b.f6603v);
                zzv.zzcN().m8406c(this.f5272b.f6580O);
                if (!TextUtils.isEmpty(this.f5272b.f6599r)) {
                    try {
                        jSONObject = new JSONObject(this.f5272b.f6599r);
                    } catch (Throwable e) {
                        sg.m8445b("Error parsing the JSON for Active View.", e);
                    }
                    this.f5274d.zza(new C1938a(this.f5279i, this.f5272b, this.f5273c, a, -2, b, this.f5272b.f6595n, jSONObject));
                    rq.f5755a.removeCallbacks(this.f5280j);
                    return;
                }
                jSONObject = null;
                this.f5274d.zza(new C1938a(this.f5279i, this.f5272b, this.f5273c, a, -2, b, this.f5272b.f6595n, jSONObject));
                rq.f5755a.removeCallbacks(this.f5280j);
                return;
            }
            throw new C1880a("There was a problem getting an ad response. ErrorCode: " + this.f5272b.f6586e, this.f5272b.f6586e);
        } catch (C1880a e2) {
            m7945a(e2.m7942a(), e2.getMessage());
            rq.f5755a.removeCallbacks(this.f5280j);
        }
    }

    public void onStop() {
        synchronized (this.f5276f) {
            if (this.f5271a != null) {
                this.f5271a.cancel();
            }
        }
    }

    public void zzcm() {
        sg.m8444b("AdLoaderBackgroundTask started.");
        this.f5280j = new C18781(this);
        rq.f5755a.postDelayed(this.f5280j, ((Long) C1648if.bn.m6682c()).longValue());
        sq srVar = new sr();
        long b = zzv.zzcP().m4927b();
        rp.m8472a(new C18792(this, srVar));
        this.f5279i = new zzmh(this.f5275e, this.f5278h.m5531a().m3926a(this.f5277g), b);
        srVar.m7338a(this.f5279i);
    }
}
