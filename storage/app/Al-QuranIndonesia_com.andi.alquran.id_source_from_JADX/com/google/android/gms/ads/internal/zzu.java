package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.qc;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@op
public class zzu extends C1154a {
    private final zzqa f2678a;
    private final zzec f2679b;
    private final Future<et> f2680c;
    private final Context f2681d;
    private final C1196b f2682e;
    private WebView f2683f;
    private gv f2684g;
    private et f2685h;
    private AsyncTask<Void, Void, String> f2686i;

    /* renamed from: com.google.android.gms.ads.internal.zzu.1 */
    class C11921 extends WebViewClient {
        final /* synthetic */ zzu f2670a;

        C11921(zzu com_google_android_gms_ads_internal_zzu) {
            this.f2670a = com_google_android_gms_ads_internal_zzu;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (this.f2670a.f2684g != null) {
                try {
                    this.f2670a.f2684g.m6314a(0);
                } catch (Throwable e) {
                    sg.m8447c("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(this.f2670a.m4151b())) {
                return false;
            }
            if (str.startsWith((String) C1648if.cE.m6682c())) {
                if (this.f2670a.f2684g != null) {
                    try {
                        this.f2670a.f2684g.m6314a(3);
                    } catch (Throwable e) {
                        sg.m8447c("Could not call AdListener.onAdFailedToLoad().", e);
                    }
                }
                this.f2670a.m4150a(0);
                return true;
            } else if (str.startsWith((String) C1648if.cF.m6682c())) {
                if (this.f2670a.f2684g != null) {
                    try {
                        this.f2670a.f2684g.m6314a(0);
                    } catch (Throwable e2) {
                        sg.m8447c("Could not call AdListener.onAdFailedToLoad().", e2);
                    }
                }
                this.f2670a.m4150a(0);
                return true;
            } else if (str.startsWith((String) C1648if.cG.m6682c())) {
                if (this.f2670a.f2684g != null) {
                    try {
                        this.f2670a.f2684g.m6316c();
                    } catch (Throwable e22) {
                        sg.m8447c("Could not call AdListener.onAdLoaded().", e22);
                    }
                }
                this.f2670a.m4150a(this.f2670a.m4148a(str));
                return true;
            } else if (str.startsWith("gmsg://")) {
                return true;
            } else {
                if (this.f2670a.f2684g != null) {
                    try {
                        this.f2670a.f2684g.m6315b();
                    } catch (Throwable e222) {
                        sg.m8447c("Could not call AdListener.onAdLeftApplication().", e222);
                    }
                }
                this.f2670a.m4143c(this.f2670a.m4139b(str));
                return true;
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzu.2 */
    class C11932 implements OnTouchListener {
        final /* synthetic */ zzu f2671a;

        C11932(zzu com_google_android_gms_ads_internal_zzu) {
            this.f2671a = com_google_android_gms_ads_internal_zzu;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f2671a.f2685h != null) {
                try {
                    this.f2671a.f2685h.m5978a(motionEvent);
                } catch (Throwable e) {
                    sg.m8447c("Unable to process ad data", e);
                }
            }
            return false;
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzu.3 */
    class C11943 implements Callable<et> {
        final /* synthetic */ zzu f2672a;

        C11943(zzu com_google_android_gms_ads_internal_zzu) {
            this.f2672a = com_google_android_gms_ads_internal_zzu;
        }

        public et m4127a() {
            return new et(this.f2672a.f2678a.f6636b, this.f2672a.f2681d, false);
        }

        public /* synthetic */ Object call() {
            return m4127a();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzu.a */
    private class C1195a extends AsyncTask<Void, Void, String> {
        final /* synthetic */ zzu f2673a;

        private C1195a(zzu com_google_android_gms_ads_internal_zzu) {
            this.f2673a = com_google_android_gms_ads_internal_zzu;
        }

        protected String m4128a(Void... voidArr) {
            Throwable e;
            try {
                this.f2673a.f2685h = (et) this.f2673a.f2680c.get(((Long) C1648if.cJ.m6682c()).longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                sg.m8447c("Failed to load ad data", e);
            } catch (ExecutionException e3) {
                e = e3;
                sg.m8447c("Failed to load ad data", e);
            } catch (TimeoutException e4) {
                sg.m8449e("Timed out waiting for ad data");
            }
            return this.f2673a.m4149a();
        }

        protected void m4129a(String str) {
            if (this.f2673a.f2683f != null && str != null) {
                this.f2673a.f2683f.loadUrl(str);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4128a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4129a((String) obj);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzu.b */
    private static class C1196b {
        private final String f2674a;
        private final Map<String, String> f2675b;
        private String f2676c;
        private String f2677d;

        public C1196b(String str) {
            this.f2674a = str;
            this.f2675b = new TreeMap();
        }

        public String m4130a() {
            return this.f2677d;
        }

        public void m4131a(zzdy com_google_android_gms_internal_zzdy) {
            this.f2676c = com_google_android_gms_internal_zzdy.f6442j.f6476o;
            Bundle bundle = com_google_android_gms_internal_zzdy.f6445m != null ? com_google_android_gms_internal_zzdy.f6445m.getBundle(AdMobAdapter.class.getName()) : null;
            if (bundle != null) {
                String str = (String) C1648if.cI.m6682c();
                for (String str2 : bundle.keySet()) {
                    if (str.equals(str2)) {
                        this.f2677d = bundle.getString(str2);
                    } else if (str2.startsWith("csa_")) {
                        this.f2675b.put(str2.substring("csa_".length()), bundle.getString(str2));
                    }
                }
            }
        }

        public String m4132b() {
            return this.f2676c;
        }

        public String m4133c() {
            return this.f2674a;
        }

        public Map<String, String> m4134d() {
            return this.f2675b;
        }
    }

    public zzu(Context context, zzec com_google_android_gms_internal_zzec, String str, zzqa com_google_android_gms_internal_zzqa) {
        this.f2681d = context;
        this.f2678a = com_google_android_gms_internal_zzqa;
        this.f2679b = com_google_android_gms_internal_zzec;
        this.f2683f = new WebView(this.f2681d);
        this.f2680c = m4145d();
        this.f2682e = new C1196b(str);
        m4142c();
    }

    private String m4139b(String str) {
        if (this.f2685h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f2685h.m5979b(parse, this.f2681d);
        } catch (Throwable e) {
            sg.m8447c("Unable to process ad data", e);
        } catch (Throwable e2) {
            sg.m8447c("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    private void m4142c() {
        m4150a(0);
        this.f2683f.setVerticalScrollBarEnabled(false);
        this.f2683f.getSettings().setJavaScriptEnabled(true);
        this.f2683f.setWebViewClient(new C11921(this));
        this.f2683f.setOnTouchListener(new C11932(this));
    }

    private void m4143c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f2681d.startActivity(intent);
    }

    private Future<et> m4145d() {
        return rp.m8473a(new C11943(this));
    }

    int m4148a(String str) {
        int i = 0;
        Object queryParameter = Uri.parse(str).getQueryParameter("height");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                i = gr.m6416a().m8690a(this.f2681d, Integer.parseInt(queryParameter));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    String m4149a() {
        String valueOf;
        Uri a;
        Throwable e;
        String valueOf2;
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) C1648if.cH.m6682c());
        builder.appendQueryParameter("query", this.f2682e.m4132b());
        builder.appendQueryParameter("pubId", this.f2682e.m4133c());
        Map d = this.f2682e.m4134d();
        for (String valueOf3 : d.keySet()) {
            builder.appendQueryParameter(valueOf3, (String) d.get(valueOf3));
        }
        Uri build = builder.build();
        if (this.f2685h != null) {
            try {
                a = this.f2685h.m5977a(build, this.f2681d);
            } catch (eu e2) {
                e = e2;
                sg.m8447c("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m4151b());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            } catch (RemoteException e3) {
                e = e3;
                sg.m8447c("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m4151b());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            }
            valueOf2 = String.valueOf(m4151b());
            valueOf3 = String.valueOf(a.getEncodedQuery());
            return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
        }
        a = build;
        valueOf2 = String.valueOf(m4151b());
        valueOf3 = String.valueOf(a.getEncodedQuery());
        return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
    }

    void m4150a(int i) {
        if (this.f2683f != null) {
            this.f2683f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    String m4151b() {
        String str;
        CharSequence a = this.f2682e.m4130a();
        if (TextUtils.isEmpty(a)) {
            str = "www.google.com";
        } else {
            CharSequence charSequence = a;
        }
        String valueOf = String.valueOf("https://");
        String str2 = (String) C1648if.cH.m6682c();
        return new StringBuilder(((String.valueOf(valueOf).length() + 0) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(str).append(str2).toString();
    }

    public void destroy() {
        C1314c.m4631b("destroy must be called on the main UI thread.");
        this.f2686i.cancel(true);
        this.f2680c.cancel(true);
        this.f2683f.destroy();
        this.f2683f = null;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
        C1314c.m4631b("pause must be called on the main UI thread.");
    }

    public void resume() {
        C1314c.m4631b("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    public void stopLoading() {
    }

    public void zza(gu guVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(gv gvVar) {
        this.f2684g = gvVar;
    }

    public void zza(hb hbVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(hd hdVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(is isVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(nl nlVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(nq nqVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(qc qcVar) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzec com_google_android_gms_internal_zzec) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public void zza(zzfn com_google_android_gms_internal_zzfn) {
        throw new IllegalStateException("Unused method");
    }

    public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
        C1314c.m4624a(this.f2683f, (Object) "This Search Ad has already been torn down");
        this.f2682e.m4131a(com_google_android_gms_internal_zzdy);
        this.f2686i = new C1195a().execute(new Void[0]);
        return true;
    }

    public C1108c zzbC() {
        C1314c.m4631b("getAdFrame must be called on the main UI thread.");
        return C1111d.m3896a(this.f2683f);
    }

    public zzec zzbD() {
        return this.f2679b;
    }

    public void zzbF() {
        throw new IllegalStateException("Unused method");
    }

    public hg zzbG() {
        return null;
    }
}
