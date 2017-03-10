package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.C1294c;
import com.google.android.gms.internal.ll.C1781c;
import com.google.android.gms.internal.oq.C1156a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import com.google.android.gms.internal.zzmh.C2082a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class pd extends rl {
    static final long f5349a;
    static boolean f5350b;
    private static final Object f5351c;
    private static ll f5352d;
    private static kh f5353e;
    private static km f5354f;
    private static kg f5355g;
    private final C1156a f5356h;
    private final C2082a f5357i;
    private final Object f5358j;
    private final Context f5359k;
    private C1781c f5360l;

    /* renamed from: com.google.android.gms.internal.pd.1 */
    class C18991 implements Runnable {
        final /* synthetic */ C1938a f5341a;
        final /* synthetic */ pd f5342b;

        C18991(pd pdVar, C1938a c1938a) {
            this.f5342b = pdVar;
            this.f5341a = c1938a;
        }

        public void run() {
            this.f5342b.f5356h.zza(this.f5341a);
            if (this.f5342b.f5360l != null) {
                this.f5342b.f5360l.b_();
                this.f5342b.f5360l = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.pd.2 */
    class C19022 implements Runnable {
        final /* synthetic */ JSONObject f5345a;
        final /* synthetic */ String f5346b;
        final /* synthetic */ pd f5347c;

        /* renamed from: com.google.android.gms.internal.pd.2.1 */
        class C19001 implements C1171c<lm> {
            final /* synthetic */ C19022 f5343a;

            C19001(C19022 c19022) {
                this.f5343a = c19022;
            }

            public void m8073a(lm lmVar) {
                try {
                    lmVar.m7289a("AFMA_getAdapterLessMediationAd", this.f5343a.f5345a);
                } catch (Throwable e) {
                    sg.m8445b("Error requesting an ad url", e);
                    pd.f5354f.m7112b(this.f5343a.f5346b);
                }
            }

            public /* synthetic */ void m8074a(Object obj) {
                m8073a((lm) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.pd.2.2 */
        class C19012 implements C1553a {
            final /* synthetic */ C19022 f5344a;

            C19012(C19022 c19022) {
                this.f5344a = c19022;
            }

            public void m8075a() {
                pd.f5354f.m7112b(this.f5344a.f5346b);
            }
        }

        C19022(pd pdVar, JSONObject jSONObject, String str) {
            this.f5347c = pdVar;
            this.f5345a = jSONObject;
            this.f5346b = str;
        }

        public void run() {
            this.f5347c.f5360l = pd.f5352d.m7368a();
            this.f5347c.f5360l.m7340a(new C19001(this), new C19012(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.pd.3 */
    class C19033 implements Runnable {
        final /* synthetic */ pd f5348a;

        C19033(pd pdVar) {
            this.f5348a = pdVar;
        }

        public void run() {
            if (this.f5348a.f5360l != null) {
                this.f5348a.f5360l.b_();
                this.f5348a.f5360l = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.pd.a */
    public static class C1904a implements rv<lh> {
        public void m8076a(lh lhVar) {
            pd.m8089b(lhVar);
        }

        public /* synthetic */ void m8077a(Object obj) {
            m8076a((lh) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.pd.b */
    public static class C1905b implements rv<lh> {
        public void m8078a(lh lhVar) {
            pd.m8086a(lhVar);
        }

        public /* synthetic */ void m8079a(Object obj) {
            m8078a((lh) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.pd.c */
    public static class C1906c implements kg {
        public void m8080a(sx sxVar, Map<String, String> map) {
            String str = (String) map.get("request_id");
            String str2 = "Invalid request: ";
            String valueOf = String.valueOf((String) map.get("errors"));
            sg.m8449e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            pd.f5354f.m7112b(str);
        }
    }

    static {
        f5349a = TimeUnit.SECONDS.toMillis(10);
        f5351c = new Object();
        f5350b = false;
        f5352d = null;
        f5353e = null;
        f5354f = null;
        f5355g = null;
    }

    public pd(Context context, C2082a c2082a, C1156a c1156a) {
        super(true);
        this.f5358j = new Object();
        this.f5356h = c1156a;
        this.f5359k = context;
        this.f5357i = c2082a;
        synchronized (f5351c) {
            if (!f5350b) {
                f5354f = new km();
                f5353e = new kh(context.getApplicationContext(), c2082a.f6507j);
                f5355g = new C1906c();
                f5352d = new ll(this.f5359k.getApplicationContext(), this.f5357i.f6507j, (String) C1648if.f4364b.m6682c(), new C1905b(), new C1904a());
                f5350b = true;
            }
        }
    }

    private zzmk m8084a(zzmh com_google_android_gms_internal_zzmh) {
        String c = zzv.zzcJ().m8538c();
        JSONObject a = m8085a(com_google_android_gms_internal_zzmh, c);
        if (a == null) {
            return new zzmk(0);
        }
        long b = zzv.zzcP().m4927b();
        Future a2 = f5354f.m7109a(c);
        sf.f5831a.post(new C19022(this, a, c));
        try {
            JSONObject jSONObject = (JSONObject) a2.get(f5349a - (zzv.zzcP().m4927b() - b), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzmk(-1);
            }
            zzmk a3 = pj.m8119a(this.f5359k, com_google_android_gms_internal_zzmh, jSONObject.toString());
            return (a3.f6586e == -3 || !TextUtils.isEmpty(a3.f6584c)) ? a3 : new zzmk(3);
        } catch (CancellationException e) {
            return new zzmk(-1);
        } catch (InterruptedException e2) {
            return new zzmk(-1);
        } catch (TimeoutException e3) {
            return new zzmk(2);
        } catch (ExecutionException e4) {
            return new zzmk(0);
        }
    }

    private JSONObject m8085a(zzmh com_google_android_gms_internal_zzmh, String str) {
        Throwable e;
        Object obj;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = com_google_android_gms_internal_zzmh.f6542c.f6435c.getBundle("sdk_less_server_data");
        if (bundle != null) {
            JSONObject a = pj.m8125a(this.f5359k, new pf().m8097a(com_google_android_gms_internal_zzmh).m8095a(zzv.zzcS().m8200a(this.f5359k)));
            if (a != null) {
                Info advertisingIdInfo;
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f5359k);
                } catch (IOException e2) {
                    e = e2;
                    sg.m8447c("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().m8506a(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    sg.m8447c("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().m8506a(hashMap);
                    return jSONObject;
                } catch (C1292b e4) {
                    e = e4;
                    sg.m8447c("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().m8506a(hashMap);
                    return jSONObject;
                } catch (C1294c e5) {
                    e = e5;
                    sg.m8447c("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().m8506a(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("request_param", a);
                hashMap.put("data", bundle);
                if (advertisingIdInfo != null) {
                    hashMap.put("adid", advertisingIdInfo.getId());
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    }
                    hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                }
                try {
                    jSONObject = zzv.zzcJ().m8506a(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void m8086a(lh lhVar) {
        lhVar.m7287a("/loadAd", f5354f);
        lhVar.m7287a("/fetchHttpRequest", f5353e);
        lhVar.m7287a("/invalidRequest", f5355g);
    }

    protected static void m8089b(lh lhVar) {
        lhVar.m7290b("/loadAd", f5354f);
        lhVar.m7290b("/fetchHttpRequest", f5353e);
        lhVar.m7290b("/invalidRequest", f5355g);
    }

    public void onStop() {
        synchronized (this.f5358j) {
            sf.f5831a.post(new C19033(this));
        }
    }

    public void zzcm() {
        sg.m8444b("SdkLessAdLoaderBackgroundTask started.");
        zzmh com_google_android_gms_internal_zzmh = new zzmh(this.f5357i, null, -1);
        zzmk a = m8084a(com_google_android_gms_internal_zzmh);
        zzec com_google_android_gms_internal_zzec = null;
        sf.f5831a.post(new C18991(this, new C1938a(com_google_android_gms_internal_zzmh, a, null, com_google_android_gms_internal_zzec, a.f6586e, zzv.zzcP().m4927b(), a.f6595n, null)));
    }
}
