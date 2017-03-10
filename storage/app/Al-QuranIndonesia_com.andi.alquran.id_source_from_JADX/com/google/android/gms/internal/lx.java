package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.internal.ly.C1792a;
import com.google.android.gms.internal.mg.C1790a;
import com.google.android.gms.p039a.C1111d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class lx implements C1792a {
    private final String f4875a;
    private final md f4876b;
    private final long f4877c;
    private final lu f4878d;
    private final lt f4879e;
    private zzdy f4880f;
    private final zzec f4881g;
    private final Context f4882h;
    private final Object f4883i;
    private final zzqa f4884j;
    private final boolean f4885k;
    private final zzgw f4886l;
    private final List<String> f4887m;
    private final boolean f4888n;
    private me f4889o;
    private int f4890p;
    private mg f4891q;

    /* renamed from: com.google.android.gms.internal.lx.1 */
    class C17891 implements Runnable {
        final /* synthetic */ lw f4872a;
        final /* synthetic */ lx f4873b;

        C17891(lx lxVar, lw lwVar) {
            this.f4873b = lxVar;
            this.f4872a = lwVar;
        }

        public void run() {
            synchronized (this.f4873b.f4883i) {
                if (this.f4873b.f4890p != -2) {
                    return;
                }
                this.f4873b.f4889o = this.f4873b.m7424d();
                if (this.f4873b.f4889o == null) {
                    this.f4873b.m7433a(4);
                } else if (!this.f4873b.m7426e() || this.f4873b.m7419b(1)) {
                    this.f4872a.m7396a(this.f4873b);
                    this.f4873b.m7412a(this.f4872a);
                } else {
                    String f = this.f4873b.f4875a;
                    sg.m8449e(new StringBuilder(String.valueOf(f).length() + 56).append("Ignoring adapter ").append(f).append(" as delayed impression is not supported").toString());
                    this.f4873b.m7433a(2);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.lx.2 */
    class C17912 extends C1790a {
        final /* synthetic */ int f4874a;

        C17912(int i) {
            this.f4874a = i;
        }

        public int m7405a() {
            return this.f4874a;
        }
    }

    public lx(Context context, String str, md mdVar, lu luVar, lt ltVar, zzdy com_google_android_gms_internal_zzdy, zzec com_google_android_gms_internal_zzec, zzqa com_google_android_gms_internal_zzqa, boolean z, boolean z2, zzgw com_google_android_gms_internal_zzgw, List<String> list) {
        this.f4883i = new Object();
        this.f4890p = -2;
        this.f4882h = context;
        this.f4876b = mdVar;
        this.f4879e = ltVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f4875a = m7417b();
        } else {
            this.f4875a = str;
        }
        this.f4878d = luVar;
        this.f4877c = luVar.f4854b != -1 ? luVar.f4854b : 10000;
        this.f4880f = com_google_android_gms_internal_zzdy;
        this.f4881g = com_google_android_gms_internal_zzec;
        this.f4884j = com_google_android_gms_internal_zzqa;
        this.f4885k = z;
        this.f4888n = z2;
        this.f4886l = com_google_android_gms_internal_zzgw;
        this.f4887m = list;
    }

    private long m7408a(long j, long j2, long j3, long j4) {
        while (this.f4890p == -2) {
            m7418b(j, j2, j3, j4);
        }
        return zzv.zzcP().m4927b() - j;
    }

    private String m7411a(String str) {
        if (!(str == null || !m7426e() || m7419b(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                sg.m8449e("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private void m7412a(lw lwVar) {
        String a = m7411a(this.f4879e.f4845i);
        try {
            if (this.f4884j.f6638d < 4100000) {
                if (this.f4881g.f6455e) {
                    this.f4889o.m7464a(C1111d.m3896a(this.f4882h), this.f4880f, a, lwVar);
                } else {
                    this.f4889o.m7468a(C1111d.m3896a(this.f4882h), this.f4881g, this.f4880f, a, (mf) lwVar);
                }
            } else if (this.f4885k) {
                this.f4889o.m7467a(C1111d.m3896a(this.f4882h), this.f4880f, a, this.f4879e.f4837a, lwVar, this.f4886l, this.f4887m);
            } else if (this.f4881g.f6455e) {
                this.f4889o.m7466a(C1111d.m3896a(this.f4882h), this.f4880f, a, this.f4879e.f4837a, (mf) lwVar);
            } else if (!this.f4888n) {
                this.f4889o.m7469a(C1111d.m3896a(this.f4882h), this.f4881g, this.f4880f, a, this.f4879e.f4837a, lwVar);
            } else if (this.f4879e.f4848l != null) {
                this.f4889o.m7467a(C1111d.m3896a(this.f4882h), this.f4880f, a, this.f4879e.f4837a, lwVar, new zzgw(m7416b(this.f4879e.f4852p)), this.f4879e.f4851o);
            } else {
                this.f4889o.m7469a(C1111d.m3896a(this.f4882h), this.f4881g, this.f4880f, a, this.f4879e.f4837a, lwVar);
            }
        } catch (Throwable e) {
            sg.m8447c("Could not request ad from mediation adapter.", e);
            m7433a(5);
        }
    }

    private static NativeAdOptions m7416b(String str) {
        Builder builder = new Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(m7420c(jSONObject.optString("native_image_orientation", "any")));
        } catch (Throwable e) {
            sg.m8447c("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private String m7417b() {
        try {
            if (!TextUtils.isEmpty(this.f4879e.f4841e)) {
                return this.f4876b.m7453b(this.f4879e.f4841e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            sg.m8449e("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m7418b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            sg.m8448d("Timed out waiting for adapter.");
            this.f4890p = 3;
            return;
        }
        try {
            this.f4883i.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.f4890p = -1;
        }
    }

    private boolean m7419b(int i) {
        try {
            Bundle l = this.f4885k ? this.f4889o.m7482l() : this.f4881g.f6455e ? this.f4889o.m7481k() : this.f4889o.m7480j();
            if (l == null) {
                return false;
            }
            return (l.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            sg.m8449e("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static int m7420c(String str) {
        return "landscape".equals(str) ? 2 : "portrait".equals(str) ? 1 : 0;
    }

    private mg m7422c() {
        if (this.f4890p != 0 || !m7426e()) {
            return null;
        }
        try {
            if (!(!m7419b(4) || this.f4891q == null || this.f4891q.m7403a() == 0)) {
                return this.f4891q;
            }
        } catch (RemoteException e) {
            sg.m8449e("Could not get cpm value from MediationResponseMetadata");
        }
        return m7423c(m7428f());
    }

    private static mg m7423c(int i) {
        return new C17912(i);
    }

    private me m7424d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.f4875a);
        sg.m8448d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!this.f4885k) {
            if (((Boolean) C1648if.bl.m6682c()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f4875a)) {
                return m7431a(new AdMobAdapter());
            }
            if (((Boolean) C1648if.bm.m6682c()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f4875a)) {
                return m7431a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f4875a)) {
                return new mk(new mt());
            }
        }
        try {
            return this.f4876b.m7452a(this.f4875a);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Could not instantiate mediation adapter: ";
            valueOf = String.valueOf(this.f4875a);
            sg.m8442a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    private boolean m7426e() {
        return this.f4878d.f4864l != -1;
    }

    private int m7428f() {
        if (this.f4879e.f4845i == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f4879e.f4845i);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f4875a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = m7419b(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            sg.m8449e("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public ly m7430a(long j, long j2) {
        ly lyVar;
        synchronized (this.f4883i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            lw lwVar = new lw();
            rq.f5755a.post(new C17891(this, lwVar));
            lw lwVar2 = lwVar;
            lyVar = new ly(this.f4879e, this.f4889o, this.f4875a, lwVar2, this.f4890p, m7422c(), m7408a(elapsedRealtime, this.f4877c, j, j2));
        }
        return lyVar;
    }

    protected me m7431a(MediationAdapter mediationAdapter) {
        return new mk(mediationAdapter);
    }

    public void m7432a() {
        synchronized (this.f4883i) {
            try {
                if (this.f4889o != null) {
                    this.f4889o.m7473c();
                }
            } catch (Throwable e) {
                sg.m8447c("Could not destroy mediation adapter.", e);
            }
            this.f4890p = -1;
            this.f4883i.notify();
        }
    }

    public void m7433a(int i) {
        synchronized (this.f4883i) {
            this.f4890p = i;
            this.f4883i.notify();
        }
    }

    public void m7434a(int i, mg mgVar) {
        synchronized (this.f4883i) {
            this.f4890p = i;
            this.f4891q = mgVar;
            this.f4883i.notify();
        }
    }
}
