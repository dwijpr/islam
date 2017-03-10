package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ll.C1777b;
import com.google.android.gms.internal.ll.C1781c;
import com.google.android.gms.internal.pa.C1897a;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@op
public final class ph extends C1897a {
    private static final Object f5399a;
    private static ph f5400b;
    private final Context f5401c;
    private final pg f5402d;
    private final hy f5403e;
    private final ll f5404f;

    /* renamed from: com.google.android.gms.internal.ph.1 */
    class C19071 implements Callable<Void> {
        final /* synthetic */ pg f5381a;
        final /* synthetic */ Context f5382b;
        final /* synthetic */ zzmh f5383c;
        final /* synthetic */ Bundle f5384d;

        C19071(pg pgVar, Context context, zzmh com_google_android_gms_internal_zzmh, Bundle bundle) {
            this.f5381a = pgVar;
            this.f5382b = context;
            this.f5383c = com_google_android_gms_internal_zzmh;
            this.f5384d = bundle;
        }

        public Void m8104a() {
            String str = this.f5383c.f6546g.packageName;
            return null;
        }

        public /* synthetic */ Object call() {
            return m8104a();
        }
    }

    /* renamed from: com.google.android.gms.internal.ph.2 */
    class C19102 implements Runnable {
        final /* synthetic */ ll f5387a;
        final /* synthetic */ pk f5388b;
        final /* synthetic */ io f5389c;
        final /* synthetic */ im f5390d;
        final /* synthetic */ String f5391e;

        /* renamed from: com.google.android.gms.internal.ph.2.1 */
        class C19081 implements C1171c<lm> {
            final /* synthetic */ im f5385a;
            final /* synthetic */ C19102 f5386b;

            C19081(C19102 c19102, im imVar) {
                this.f5386b = c19102;
                this.f5385a = imVar;
            }

            public void m8105a(lm lmVar) {
                this.f5386b.f5389c.m6746a(this.f5385a, "jsf");
                this.f5386b.f5389c.m6747b();
                lmVar.m7287a("/invalidRequest", this.f5386b.f5388b.f5410b);
                lmVar.m7287a("/loadAdURL", this.f5386b.f5388b.f5411c);
                lmVar.m7287a("/loadAd", this.f5386b.f5388b.f5412d);
                try {
                    lmVar.m7288a("AFMA_getAd", this.f5386b.f5391e);
                } catch (Throwable e) {
                    sg.m8445b("Error requesting an ad url", e);
                }
            }

            public /* synthetic */ void m8106a(Object obj) {
                m8105a((lm) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.ph.2.2 */
        class C19092 implements C1553a {
            C19092(C19102 c19102) {
            }

            public void m8107a() {
            }
        }

        C19102(ll llVar, pk pkVar, io ioVar, im imVar, String str) {
            this.f5387a = llVar;
            this.f5388b = pkVar;
            this.f5389c = ioVar;
            this.f5390d = imVar;
            this.f5391e = str;
        }

        public void run() {
            C1781c a = this.f5387a.m7368a();
            this.f5388b.m8141a(a);
            this.f5389c.m6746a(this.f5390d, "rwc");
            a.m7340a(new C19081(this, this.f5389c.m6740a()), new C19092(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.ph.3 */
    class C19113 implements Runnable {
        final /* synthetic */ pg f5392a;
        final /* synthetic */ Context f5393b;
        final /* synthetic */ pk f5394c;
        final /* synthetic */ zzmh f5395d;

        C19113(pg pgVar, Context context, pk pkVar, zzmh com_google_android_gms_internal_zzmh) {
            this.f5392a = pgVar;
            this.f5393b = context;
            this.f5394c = pkVar;
            this.f5395d = com_google_android_gms_internal_zzmh;
        }

        public void run() {
            this.f5392a.f5375e.m8201a(this.f5393b, this.f5394c, this.f5395d.f6550k);
        }
    }

    /* renamed from: com.google.android.gms.internal.ph.4 */
    class C19124 implements rv<lh> {
        C19124(ph phVar) {
        }

        public void m8108a(lh lhVar) {
            lhVar.m7287a("/log", kf.f4599i);
        }

        public /* synthetic */ void m8109a(Object obj) {
            m8108a((lh) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ph.5 */
    class C19135 implements Runnable {
        final /* synthetic */ zzmh f5396a;
        final /* synthetic */ pb f5397b;
        final /* synthetic */ ph f5398c;

        C19135(ph phVar, zzmh com_google_android_gms_internal_zzmh, pb pbVar) {
            this.f5398c = phVar;
            this.f5396a = com_google_android_gms_internal_zzmh;
            this.f5397b = pbVar;
        }

        public void run() {
            zzmk a;
            try {
                a = this.f5398c.m8116a(this.f5396a);
            } catch (Throwable e) {
                zzv.zzcN().m8399a(e, "AdRequestServiceImpl.loadAdAsync");
                sg.m8447c("Could not fetch ad response due to an Exception.", e);
                a = null;
            }
            if (a == null) {
                a = new zzmk(0);
            }
            try {
                this.f5397b.m7984a(a);
            } catch (Throwable e2) {
                sg.m8447c("Fail to forward ad response.", e2);
            }
        }
    }

    static {
        f5399a = new Object();
    }

    ph(Context context, hy hyVar, pg pgVar) {
        this.f5401c = context;
        this.f5402d = pgVar;
        this.f5403e = hyVar;
        this.f5404f = new ll(context.getApplicationContext() != null ? context.getApplicationContext() : context, zzqa.m9783a(), hyVar.m6648a(), new C19124(this), new C1777b());
    }

    private static Location m8110a(sn<Location> snVar) {
        try {
            return (Location) snVar.get(((Long) C1648if.cv.m6682c()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            sg.m8447c("Exception caught while getting location", e);
            return null;
        }
    }

    public static ph m8111a(Context context, hy hyVar, pg pgVar) {
        ph phVar;
        synchronized (f5399a) {
            if (f5400b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f5400b = new ph(context, hyVar, pgVar);
            }
            phVar = f5400b;
        }
        return phVar;
    }

    private static zzmk m8112a(Context context, ll llVar, hy hyVar, pg pgVar, zzmh com_google_android_gms_internal_zzmh) {
        Bundle bundle;
        Future future;
        Throwable e;
        sg.m8444b("Starting ad request from service using: AFMA_getAd");
        C1648if.m6704a(context);
        sn a = pgVar.f5379i.m7762a();
        io ioVar = new io(((Boolean) C1648if.f4357U.m6682c()).booleanValue(), "load_ad", com_google_android_gms_internal_zzmh.f6543d.f6452b);
        if (com_google_android_gms_internal_zzmh.f6540a > 10 && com_google_android_gms_internal_zzmh.f6525B != -1) {
            ioVar.m6746a(ioVar.m6741a(com_google_android_gms_internal_zzmh.f6525B), "cts");
        }
        im a2 = ioVar.m6740a();
        Bundle bundle2 = (com_google_android_gms_internal_zzmh.f6540a < 4 || com_google_android_gms_internal_zzmh.f6554o == null) ? null : com_google_android_gms_internal_zzmh.f6554o;
        if (!((Boolean) C1648if.al.m6682c()).booleanValue() || pgVar.f5371a == null) {
            bundle = bundle2;
            future = null;
        } else {
            if (bundle2 == null && ((Boolean) C1648if.am.m6682c()).booleanValue()) {
                rm.m8450a("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                future = rp.m8473a(new C19071(pgVar, context, com_google_android_gms_internal_zzmh, bundle2));
            } else {
                bundle = bundle2;
                future = null;
            }
        }
        sl slVar = new sl(null);
        Bundle bundle3 = com_google_android_gms_internal_zzmh.f6542c.f6435c;
        Object obj = (bundle3 == null || bundle3.getString("_ad") == null) ? null : 1;
        if (com_google_android_gms_internal_zzmh.f6532I && obj == null) {
            sn a3 = pgVar.f5376f.m7378a(com_google_android_gms_internal_zzmh.f6545f);
        } else {
            Object obj2 = slVar;
        }
        po a4 = zzv.zzcS().m8200a(context);
        if (a4.f5501m == -1) {
            sg.m8444b("Device is offline.");
            return new zzmk(2);
        }
        String string;
        String uuid = com_google_android_gms_internal_zzmh.f6540a >= 7 ? com_google_android_gms_internal_zzmh.f6562w : UUID.randomUUID().toString();
        pk pkVar = new pk(uuid, com_google_android_gms_internal_zzmh.f6545f.packageName);
        if (com_google_android_gms_internal_zzmh.f6542c.f6435c != null) {
            string = com_google_android_gms_internal_zzmh.f6542c.f6435c.getString("_ad");
            if (string != null) {
                return pj.m8119a(context, com_google_android_gms_internal_zzmh, string);
            }
        }
        List a5 = pgVar.f5374d.m6649a(com_google_android_gms_internal_zzmh);
        String a6 = pgVar.f5380j.m8361a(com_google_android_gms_internal_zzmh);
        if (future != null) {
            try {
                rm.m8450a("Waiting for app index fetching task.");
                future.get(((Long) C1648if.an.m6682c()).longValue(), TimeUnit.MILLISECONDS);
                rm.m8450a("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                sg.m8447c("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                sg.m8447c("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                sg.m8444b("Timed out waiting for app index fetching task");
            }
        }
        string = com_google_android_gms_internal_zzmh.f6546g.packageName;
        m8115b(a);
        JSONObject a7 = pj.m8125a(context, new pf().m8097a(com_google_android_gms_internal_zzmh).m8095a(a4).m8096a(null).m8093a(m8110a(a3)).m8094a(m8115b(a)).m8098a(a6).m8099a(a5).m8101b(bundle).m8102b(null).m8100a(pgVar.f5372b.m6305a(context)));
        if (a7 == null) {
            return new zzmk(0);
        }
        if (com_google_android_gms_internal_zzmh.f6540a < 7) {
            try {
                a7.put("request_id", uuid);
            } catch (JSONException e5) {
            }
        }
        try {
            a7.put("prefetch_mode", "url");
        } catch (Throwable e6) {
            sg.m8447c("Failed putting prefetch parameters to ad request.", e6);
        }
        String jSONObject = a7.toString();
        ioVar.m6746a(a2, "arc");
        rq.f5755a.post(new C19102(llVar, pkVar, ioVar, ioVar.m6740a(), jSONObject));
        zzmk com_google_android_gms_internal_zzmk;
        try {
            pn pnVar = (pn) pkVar.m8142b().get(10, TimeUnit.SECONDS);
            if (pnVar == null) {
                com_google_android_gms_internal_zzmk = new zzmk(0);
                return com_google_android_gms_internal_zzmk;
            } else if (pnVar.m8182a() != -2) {
                com_google_android_gms_internal_zzmk = new zzmk(pnVar.m8182a());
                rq.f5755a.post(new C19113(pgVar, context, pkVar, com_google_android_gms_internal_zzmh));
                return com_google_android_gms_internal_zzmk;
            } else {
                if (ioVar.m6750e() != null) {
                    ioVar.m6746a(ioVar.m6750e(), "rur");
                }
                com_google_android_gms_internal_zzmk = null;
                if (!TextUtils.isEmpty(pnVar.m8191i())) {
                    com_google_android_gms_internal_zzmk = pj.m8119a(context, com_google_android_gms_internal_zzmh, pnVar.m8191i());
                }
                if (com_google_android_gms_internal_zzmk == null && !TextUtils.isEmpty(pnVar.m8187e())) {
                    com_google_android_gms_internal_zzmk = m8113a(com_google_android_gms_internal_zzmh, context, com_google_android_gms_internal_zzmh.f6550k.f6636b, pnVar.m8187e(), null, pnVar, ioVar, pgVar);
                }
                if (com_google_android_gms_internal_zzmk == null) {
                    com_google_android_gms_internal_zzmk = new zzmk(0);
                }
                ioVar.m6746a(a2, "tts");
                com_google_android_gms_internal_zzmk.f6606y = ioVar.m6748c();
                rq.f5755a.post(new C19113(pgVar, context, pkVar, com_google_android_gms_internal_zzmh));
                return com_google_android_gms_internal_zzmk;
            }
        } catch (Exception e7) {
            com_google_android_gms_internal_zzmk = new zzmk(0);
            return com_google_android_gms_internal_zzmk;
        } finally {
            rq.f5755a.post(new C19113(pgVar, context, pkVar, com_google_android_gms_internal_zzmh));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzmk m8113a(com.google.android.gms.internal.zzmh r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.pn r18, com.google.android.gms.internal.io r19, com.google.android.gms.internal.pg r20) {
        /*
        if (r19 == 0) goto L_0x00db;
    L_0x0002:
        r2 = r19.m6740a();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.pl;	 Catch:{ IOException -> 0x00e6 }
        r2 = r18.m8185c();	 Catch:{ IOException -> 0x00e6 }
        r8.<init>(r13, r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00e6 }
        r5 = r2.length();	 Catch:{ IOException -> 0x00e6 }
        if (r5 == 0) goto L_0x00df;
    L_0x001c:
        r2 = r4.concat(r2);	 Catch:{ IOException -> 0x00e6 }
    L_0x0020:
        com.google.android.gms.internal.sg.m8444b(r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x00e6 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x00e6 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ IOException -> 0x00e6 }
        r10 = r5.m4927b();	 Catch:{ IOException -> 0x00e6 }
        r6 = r2;
        r7 = r4;
    L_0x0035:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x00e6 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x00e6 }
        r4 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4.m8515a(r14, r15, r5, r2);	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0056;
    L_0x0049:
        r4 = r18.m8189g();	 Catch:{ all -> 0x010b }
        if (r4 == 0) goto L_0x0056;
    L_0x004f:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x010b }
    L_0x0056:
        r4 = r13.f6533J;	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 != 0) goto L_0x0068;
    L_0x005e:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.sg.m8444b(r5);	 Catch:{ all -> 0x010b }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x010b }
    L_0x0068:
        if (r18 == 0) goto L_0x0094;
    L_0x006a:
        r4 = r18.m8186d();	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0094;
    L_0x0074:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x010b }
        r4 = r18.m8186d();	 Catch:{ all -> 0x010b }
        r9 = r4.getBytes();	 Catch:{ all -> 0x010b }
        r4 = r9.length;	 Catch:{ all -> 0x010b }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0105 }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x0105 }
        r4.<init>(r12);	 Catch:{ all -> 0x0105 }
        r4.write(r9);	 Catch:{ all -> 0x0197 }
        com.google.android.gms.common.util.C1385k.m4955a(r4);	 Catch:{ all -> 0x010b }
    L_0x0094:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x010b }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x010b }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0116;
    L_0x00a0:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0116;
    L_0x00a4:
        r6 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0110 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0110 }
        r4.<init>(r7);	 Catch:{ all -> 0x0110 }
        r5 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0194 }
        r5 = r5.m8500a(r4);	 Catch:{ all -> 0x0194 }
        com.google.android.gms.common.util.C1385k.m4955a(r4);	 Catch:{ all -> 0x010b }
        m8114a(r6, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r8.m8178a(r6, r12, r5);	 Catch:{ all -> 0x010b }
        if (r19 == 0) goto L_0x00d2;
    L_0x00c5:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x010b }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x010b }
        r0 = r19;
        r0.m6746a(r3, r4);	 Catch:{ all -> 0x010b }
    L_0x00d2:
        r3 = r8.m8177a(r10);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
    L_0x00da:
        return r2;
    L_0x00db:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00df:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x00e6 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00e6 }
        goto L_0x0020;
    L_0x00e6:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x018d;
    L_0x00f7:
        r2 = r3.concat(r2);
    L_0x00fb:
        com.google.android.gms.internal.sg.m8449e(r2);
        r2 = new com.google.android.gms.internal.zzmk;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00da;
    L_0x0105:
        r3 = move-exception;
        r4 = r5;
    L_0x0107:
        com.google.android.gms.common.util.C1385k.m4955a(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x010b:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        throw r3;	 Catch:{ IOException -> 0x00e6 }
    L_0x0110:
        r3 = move-exception;
        r4 = r5;
    L_0x0112:
        com.google.android.gms.common.util.C1385k.m4955a(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x0116:
        r4 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        m8114a(r4, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x015d;
    L_0x0122:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x015d;
    L_0x0126:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 == 0) goto L_0x0142;
    L_0x0132:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.internal.sg.m8449e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0142:
        r5 = new java.net.URL;	 Catch:{ all -> 0x010b }
        r5.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x0181;
    L_0x014c:
        r3 = "Too many redirects.";
        com.google.android.gms.internal.sg.m8449e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x015d:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r4 = 46;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x010b }
        r3 = r3.append(r9);	 Catch:{ all -> 0x010b }
        r3 = r3.toString();	 Catch:{ all -> 0x010b }
        com.google.android.gms.internal.sg.m8449e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0181:
        r8.m8179a(r12);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        if (r20 == 0) goto L_0x0189;
    L_0x0189:
        r6 = r4;
        r7 = r5;
        goto L_0x0035;
    L_0x018d:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x00fb;
    L_0x0194:
        r3 = move-exception;
        goto L_0x0112;
    L_0x0197:
        r3 = move-exception;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ph.a(com.google.android.gms.internal.zzmh, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.pn, com.google.android.gms.internal.io, com.google.android.gms.internal.pg):com.google.android.gms.internal.zzmk");
    }

    private static void m8114a(String str, Map<String, List<String>> map, String str2, int i) {
        if (sg.m8443a(2)) {
            rm.m8450a(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    rm.m8450a(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        rm.m8450a(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            rm.m8450a("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    rm.m8450a(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                rm.m8450a("    null");
            }
            rm.m8450a("  Response Code:\n    " + i + "\n}");
        }
    }

    private static Bundle m8115b(sn<Bundle> snVar) {
        Bundle bundle = new Bundle();
        try {
            return (Bundle) snVar.get(((Long) C1648if.cN.m6682c()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            sg.m8447c("Exception caught while getting parental controls.", e);
            return bundle;
        }
    }

    public zzmk m8116a(zzmh com_google_android_gms_internal_zzmh) {
        return m8112a(this.f5401c, this.f5404f, this.f5403e, this.f5402d, com_google_android_gms_internal_zzmh);
    }

    public void m8117a(zzmh com_google_android_gms_internal_zzmh, pb pbVar) {
        zzv.zzcN().m8394a(this.f5401c, com_google_android_gms_internal_zzmh.f6550k);
        rp.m8472a(new C19135(this, com_google_android_gms_internal_zzmh, pbVar));
    }
}
