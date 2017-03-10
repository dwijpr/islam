package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@op
public class sy extends WebViewClient {
    private static final String[] f5865c;
    private static final String[] f5866d;
    private boolean f5867A;
    private boolean f5868B;
    private boolean f5869C;
    private int f5870D;
    protected sx f5871a;
    protected qw f5872b;
    private final HashMap<String, List<kg>> f5873e;
    private final Object f5874f;
    private ge f5875g;
    private zzh f5876h;
    private C1137a f5877i;
    private C1866b f5878j;
    private kc f5879k;
    private C1168c f5880l;
    private boolean f5881m;
    private ki f5882n;
    private kl f5883o;
    private boolean f5884p;
    private boolean f5885q;
    private OnGlobalLayoutListener f5886r;
    private OnScrollChangedListener f5887s;
    private boolean f5888t;
    private zzq f5889u;
    private final mz f5890v;
    private zze f5891w;
    private mv f5892x;
    private nb f5893y;
    private C1166e f5894z;

    /* renamed from: com.google.android.gms.internal.sy.a */
    public interface C1137a {
        void m3967a(sx sxVar, boolean z);
    }

    /* renamed from: com.google.android.gms.internal.sy.e */
    public interface C1166e {
        void m4052a();
    }

    /* renamed from: com.google.android.gms.internal.sy.c */
    public interface C1168c {
        void m4054a();
    }

    /* renamed from: com.google.android.gms.internal.sy.b */
    public interface C1866b {
        void m7896a(sx sxVar);
    }

    /* renamed from: com.google.android.gms.internal.sy.1 */
    class C20001 implements Runnable {
        final /* synthetic */ sy f5861a;

        C20001(sy syVar) {
            this.f5861a = syVar;
        }

        public void run() {
            if (this.f5861a.f5872b != null) {
                qw qwVar = this.f5861a.f5872b;
                sx sxVar = this.f5861a.f5871a;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.sy.2 */
    class C20012 implements Runnable {
        final /* synthetic */ sy f5862a;

        C20012(sy syVar) {
            this.f5862a = syVar;
        }

        public void run() {
            this.f5862a.f5871a.m8742B();
            com.google.android.gms.ads.internal.overlay.zze i = this.f5862a.f5871a.m8773i();
            if (i != null) {
                i.zzhl();
            }
            if (this.f5862a.f5880l != null) {
                this.f5862a.f5880l.m4054a();
                this.f5862a.f5880l = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.sy.d */
    private static class C2002d implements zzh {
        private sx f5863a;
        private zzh f5864b;

        public C2002d(sx sxVar, zzh com_google_android_gms_ads_internal_overlay_zzh) {
            this.f5863a = sxVar;
            this.f5864b = com_google_android_gms_ads_internal_overlay_zzh;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzbN() {
            this.f5864b.zzbN();
            this.f5863a.m8765c();
        }

        public void zzbO() {
            this.f5864b.zzbO();
            this.f5863a.m8767d();
        }
    }

    static {
        f5865c = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        f5866d = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public sy(sx sxVar, boolean z) {
        this(sxVar, z, new mz(sxVar, sxVar.m8771g(), new hx(sxVar.getContext())), null);
    }

    sy(sx sxVar, boolean z, mz mzVar, mv mvVar) {
        this.f5873e = new HashMap();
        this.f5874f = new Object();
        this.f5881m = false;
        this.f5871a = sxVar;
        this.f5884p = z;
        this.f5890v = mzVar;
        this.f5892x = mvVar;
    }

    private String m8793a(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.VERSION_NAME;
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : BuildConfig.VERSION_NAME;
    }

    private void m8794a(Context context, String str, String str2, String str3) {
        if (((Boolean) C1648if.bc.m6682c()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompatApi24.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            bundle.putString("host", m8793a(str3));
            zzv.zzcJ().m8513a(context, this.f5871a.m8779o().f6636b, "gmob-apps", bundle, true);
        }
    }

    private static boolean m8795b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m8796p() {
        if (this.f5878j != null) {
            this.f5878j.m7896a(this.f5871a);
            this.f5878j = null;
        }
    }

    public zze m8797a() {
        return this.f5891w;
    }

    public void m8798a(int i, int i2) {
        if (this.f5892x != null) {
            this.f5892x.m7708c(i, i2);
        }
    }

    public void m8799a(int i, int i2, boolean z) {
        this.f5890v.m7731a(i, i2);
        if (this.f5892x != null) {
            this.f5892x.m7702a(i, i2, z);
        }
    }

    public void m8800a(Uri uri) {
        String path = uri.getPath();
        List<kg> list = (List) this.f5873e.get(path);
        if (list != null) {
            Map a = zzv.zzcJ().m8503a(uri);
            if (sg.m8443a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                rm.m8450a(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : a.keySet()) {
                    str = (String) a.get(path2);
                    rm.m8450a(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (kg a2 : list) {
                a2.m4048a(this.f5871a, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        rm.m8450a(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public final void m8801a(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f5874f) {
            this.f5885q = true;
            this.f5871a.m8742B();
            this.f5886r = onGlobalLayoutListener;
            this.f5887s = onScrollChangedListener;
        }
    }

    public void m8802a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f5892x != null ? this.f5892x.m7707b() : false;
        zzf zzcH = zzv.zzcH();
        Context context = this.f5871a.getContext();
        if (!b) {
            z = true;
        }
        zzcH.zza(context, adOverlayInfoParcel, z);
        if (this.f5872b != null && adOverlayInfoParcel.url == null && adOverlayInfoParcel.zzMW != null) {
            String str = adOverlayInfoParcel.zzMW.url;
        }
    }

    public final void m8803a(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean p = this.f5871a.m8780p();
        ge geVar = (!p || this.f5871a.m8775k().f6455e) ? this.f5875g : null;
        if (!p) {
            com_google_android_gms_ads_internal_overlay_zzh = this.f5876h;
        }
        m8802a(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, geVar, com_google_android_gms_ads_internal_overlay_zzh, this.f5889u, this.f5871a.m8779o()));
    }

    public void m8804a(ge geVar, zzh com_google_android_gms_ads_internal_overlay_zzh, kc kcVar, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, ki kiVar, kl klVar, zze com_google_android_gms_ads_internal_zze, nb nbVar, qw qwVar) {
        if (com_google_android_gms_ads_internal_zze == null) {
            com_google_android_gms_ads_internal_zze = new zze(this.f5871a.getContext());
        }
        this.f5892x = new mv(this.f5871a, nbVar);
        this.f5872b = qwVar;
        m8810a("/appEvent", new kb(kcVar));
        m8810a("/backButton", kf.f4602l);
        m8810a("/refresh", kf.f4603m);
        m8810a("/canOpenURLs", kf.f4592b);
        m8810a("/canOpenIntents", kf.f4593c);
        m8810a("/click", kf.f4594d);
        m8810a("/close", kf.f4595e);
        m8810a("/customClose", kf.f4597g);
        m8810a("/instrument", kf.f4607q);
        m8810a("/delayPageLoaded", kf.f4609s);
        m8810a("/delayPageClosed", kf.f4610t);
        m8810a("/getLocationInfo", kf.f4611u);
        m8810a("/httpTrack", kf.f4598h);
        m8810a("/log", kf.f4599i);
        m8810a("/mraid", new kn(com_google_android_gms_ads_internal_zze, this.f5892x));
        m8810a("/mraidLoaded", this.f5890v);
        m8810a("/open", new ko(kiVar, com_google_android_gms_ads_internal_zze, this.f5892x));
        m8810a("/precache", kf.f4606p);
        m8810a("/touch", kf.f4601k);
        m8810a("/video", kf.f4604n);
        m8810a("/videoMeta", kf.f4605o);
        m8810a("/appStreaming", kf.f4596f);
        if (klVar != null) {
            m8810a("/setInterstitialProperties", new kk(klVar));
        }
        this.f5875g = geVar;
        this.f5876h = com_google_android_gms_ads_internal_overlay_zzh;
        this.f5879k = kcVar;
        this.f5882n = kiVar;
        this.f5889u = com_google_android_gms_ads_internal_overlay_zzq;
        this.f5891w = com_google_android_gms_ads_internal_zze;
        this.f5893y = nbVar;
        this.f5883o = klVar;
        m8811a(z);
    }

    public void m8805a(sx sxVar) {
        this.f5871a = sxVar;
    }

    public void m8806a(C1137a c1137a) {
        this.f5877i = c1137a;
    }

    public void m8807a(C1866b c1866b) {
        this.f5878j = c1866b;
    }

    public void m8808a(C1168c c1168c) {
        this.f5880l = c1168c;
    }

    public void m8809a(C1166e c1166e) {
        this.f5894z = c1166e;
    }

    public void m8810a(String str, kg kgVar) {
        synchronized (this.f5874f) {
            List list = (List) this.f5873e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f5873e.put(str, list);
            }
            list.add(kgVar);
        }
    }

    public void m8811a(boolean z) {
        this.f5881m = z;
    }

    public final void m8812a(boolean z, int i) {
        ge geVar = (!this.f5871a.m8780p() || this.f5871a.m8775k().f6455e) ? this.f5875g : null;
        m8802a(new AdOverlayInfoParcel(geVar, this.f5876h, this.f5889u, this.f5871a, z, i, this.f5871a.m8779o()));
    }

    public final void m8813a(boolean z, int i, String str) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean p = this.f5871a.m8780p();
        ge geVar = (!p || this.f5871a.m8775k().f6455e) ? this.f5875g : null;
        if (!p) {
            com_google_android_gms_ads_internal_overlay_zzh = new C2002d(this.f5871a, this.f5876h);
        }
        m8802a(new AdOverlayInfoParcel(geVar, com_google_android_gms_ads_internal_overlay_zzh, this.f5879k, this.f5889u, this.f5871a, z, i, str, this.f5871a.m8779o(), this.f5882n));
    }

    public final void m8814a(boolean z, int i, String str, String str2) {
        boolean p = this.f5871a.m8780p();
        ge geVar = (!p || this.f5871a.m8775k().f6455e) ? this.f5875g : null;
        m8802a(new AdOverlayInfoParcel(geVar, p ? null : new C2002d(this.f5871a, this.f5876h), this.f5879k, this.f5889u, this.f5871a, z, i, str, str2, this.f5871a.m8779o(), this.f5882n));
    }

    public void m8815b(String str, kg kgVar) {
        synchronized (this.f5874f) {
            List list = (List) this.f5873e.get(str);
            if (list == null) {
                return;
            }
            list.remove(kgVar);
        }
    }

    public boolean m8816b() {
        boolean z;
        synchronized (this.f5874f) {
            z = this.f5884p;
        }
        return z;
    }

    public boolean m8817c() {
        boolean z;
        synchronized (this.f5874f) {
            z = this.f5885q;
        }
        return z;
    }

    public OnGlobalLayoutListener m8818d() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f5874f) {
            onGlobalLayoutListener = this.f5886r;
        }
        return onGlobalLayoutListener;
    }

    public OnScrollChangedListener m8819e() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f5874f) {
            onScrollChangedListener = this.f5887s;
        }
        return onScrollChangedListener;
    }

    public boolean m8820f() {
        boolean z;
        synchronized (this.f5874f) {
            z = this.f5888t;
        }
        return z;
    }

    public void m8821g() {
        synchronized (this.f5874f) {
            rm.m8450a("Loading blank page in WebView, 2...");
            this.f5867A = true;
            this.f5871a.m8755a("about:blank");
        }
    }

    public void m8822h() {
        if (this.f5872b != null) {
            rq.f5755a.post(new C20001(this));
        }
    }

    public void m8823i() {
        synchronized (this.f5874f) {
            this.f5888t = true;
        }
        this.f5870D++;
        m8826l();
    }

    public void m8824j() {
        this.f5870D--;
        m8826l();
    }

    public void m8825k() {
        this.f5869C = true;
        m8826l();
    }

    public final void m8826l() {
        if (this.f5877i != null && ((this.f5868B && this.f5870D <= 0) || this.f5869C)) {
            this.f5877i.m3967a(this.f5871a, !this.f5869C);
            this.f5877i = null;
        }
        this.f5871a.m8743C();
    }

    public final void m8827m() {
        if (this.f5872b != null) {
            this.f5872b = null;
        }
        synchronized (this.f5874f) {
            this.f5873e.clear();
            this.f5875g = null;
            this.f5876h = null;
            this.f5877i = null;
            this.f5878j = null;
            this.f5879k = null;
            this.f5881m = false;
            this.f5884p = false;
            this.f5885q = false;
            this.f5888t = false;
            this.f5882n = null;
            this.f5889u = null;
            this.f5880l = null;
            if (this.f5892x != null) {
                this.f5892x.m7704a(true);
                this.f5892x = null;
            }
        }
    }

    public C1166e m8828n() {
        return this.f5894z;
    }

    public final void m8829o() {
        synchronized (this.f5874f) {
            this.f5881m = false;
            this.f5884p = true;
            zzv.zzcJ().m8518a(new C20012(this));
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        rm.m8450a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8800a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f5874f) {
            if (this.f5867A) {
                rm.m8450a("Blank page loaded, 1...");
                this.f5871a.m8783s();
                return;
            }
            this.f5868B = true;
            m8796p();
            m8826l();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= f5865c.length) ? String.valueOf(i) : f5865c[(-i) - 1];
        m8794a(this.f5871a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f5866d.length) ? String.valueOf(primaryError) : f5866d[primaryError];
            m8794a(this.f5871a.getContext(), "ssl_err", valueOf, zzv.zzcL().m8564a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            zzdo a = zzdo.m9765a(str);
            if (a == null) {
                return null;
            }
            zzdl a2 = zzv.zzcO().m6265a(a);
            return (a2 == null || !a2.m9761a()) ? null : new WebResourceResponse(BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, a2.m9762b());
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case C0861R.styleable.AppCompatTheme_panelBackground /*79*/:
            case C0861R.styleable.AppCompatTheme_colorAccent /*85*/:
            case C0861R.styleable.AppCompatTheme_colorControlNormal /*86*/:
            case C0861R.styleable.AppCompatTheme_colorControlActivated /*87*/:
            case C0861R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
            case C0861R.styleable.AppCompatTheme_colorButtonNormal /*89*/:
            case AdSize.LARGE_AD_HEIGHT /*90*/:
            case C0861R.styleable.AppCompatTheme_controlBackground /*91*/:
            case 126:
            case 127:
            case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        rm.m8450a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8800a(parse);
        } else if (this.f5881m && webView == this.f5871a.m8747a() && m8795b(parse)) {
            if (this.f5875g != null && ((Boolean) C1648if.as.m6682c()).booleanValue()) {
                this.f5875g.onAdClicked();
                this.f5875g = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.f5871a.m8747a().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            sg.m8449e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                cg n = this.f5871a.m8778n();
                if (n != null && n.m5538c(parse)) {
                    parse = n.m5530a(parse, this.f5871a.getContext(), this.f5871a.m8760b());
                }
                uri = parse;
            } catch (ch e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                sg.m8449e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.f5891w == null || this.f5891w.zzcb()) {
                m8803a(new zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.f5891w.zzx(str);
            }
        }
        return true;
    }
}
