package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.re;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1998b;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.zzqa;
import java.util.Map;
import org.json.JSONObject;

@op
public class zzg {
    private final Object f2591a;
    private Context f2592b;
    public final kg zzsX;

    /* renamed from: com.google.android.gms.ads.internal.zzg.1 */
    class C11701 implements kg {
        final /* synthetic */ zzg f2583a;

        C11701(zzg com_google_android_gms_ads_internal_zzg) {
            this.f2583a = com_google_android_gms_ads_internal_zzg;
        }

        public void m4064a(sx sxVar, Map<String, String> map) {
            sxVar.m7290b("/appSettingsFetched", (kg) this);
            synchronized (this.f2583a.f2591a) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        zzv.zzcN().m8391a(this.f2583a.f2592b, (String) map.get("appSettingsJson"));
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzg.2 */
    class C11732 implements Runnable {
        final /* synthetic */ ll f2585a;
        final /* synthetic */ String f2586b;
        final /* synthetic */ String f2587c;
        final /* synthetic */ boolean f2588d;
        final /* synthetic */ Context f2589e;
        final /* synthetic */ zzg f2590f;

        /* renamed from: com.google.android.gms.ads.internal.zzg.2.1 */
        class C11721 implements C1171c<lm> {
            final /* synthetic */ C11732 f2584a;

            C11721(C11732 c11732) {
                this.f2584a = c11732;
            }

            public void m4066a(lm lmVar) {
                lmVar.m7287a("/appSettingsFetched", this.f2584a.f2590f.zzsX);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(this.f2584a.f2586b)) {
                        jSONObject.put("app_id", this.f2584a.f2586b);
                    } else if (!TextUtils.isEmpty(this.f2584a.f2587c)) {
                        jSONObject.put("ad_unit_id", this.f2584a.f2587c);
                    }
                    jSONObject.put("is_init", this.f2584a.f2588d);
                    jSONObject.put("pn", this.f2584a.f2589e.getPackageName());
                    lmVar.m7289a("AFMA_fetchAppSettings", jSONObject);
                } catch (Throwable e) {
                    lmVar.m7290b("/appSettingsFetched", this.f2584a.f2590f.zzsX);
                    sg.m8445b("Error requesting application settings", e);
                }
            }

            public /* synthetic */ void m4067a(Object obj) {
                m4066a((lm) obj);
            }
        }

        C11732(zzg com_google_android_gms_ads_internal_zzg, ll llVar, String str, String str2, boolean z, Context context) {
            this.f2590f = com_google_android_gms_ads_internal_zzg;
            this.f2585a = llVar;
            this.f2586b = str;
            this.f2587c = str2;
            this.f2588d = z;
            this.f2589e = context;
        }

        public void run() {
            this.f2585a.m7368a().m7340a(new C11721(this), new C1998b());
        }
    }

    public zzg() {
        this.f2591a = new Object();
        this.zzsX = new C11701(this);
    }

    private static boolean m4069a(re reVar) {
        if (reVar == null) {
            return true;
        }
        boolean z = (((zzv.zzcP().m4926a() - reVar.m8381a()) > ((Long) C1648if.cB.m6682c()).longValue() ? 1 : ((zzv.zzcP().m4926a() - reVar.m8381a()) == ((Long) C1648if.cB.m6682c()).longValue() ? 0 : -1)) > 0) || !reVar.m8382b();
        return z;
    }

    public void zza(Context context, zzqa com_google_android_gms_internal_zzqa, boolean z, re reVar, String str, String str2) {
        if (!m4069a(reVar)) {
            return;
        }
        if (context == null) {
            sg.m8449e("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sg.m8449e("App settings could not be fetched. Required parameters missing");
        } else {
            this.f2592b = context;
            rq.f5755a.post(new C11732(this, zzv.zzcJ().m8495a(context, com_google_android_gms_internal_zzqa), str, str2, z, context));
        }
    }
}
