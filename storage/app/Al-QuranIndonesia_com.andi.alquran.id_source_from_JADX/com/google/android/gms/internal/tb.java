package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.andi.alquran.C0861R;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.fh.C1562a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@op
class tb extends WebView implements OnGlobalLayoutListener, DownloadListener, sx {
    private im f5903A;
    private in f5904B;
    private WeakReference<OnClickListener> f5905C;
    private zze f5906D;
    private se f5907E;
    private int f5908F;
    private int f5909G;
    private int f5910H;
    private int f5911I;
    private Map<String, kv> f5912J;
    private final WindowManager f5913K;
    boolean f5914a;
    private final C2005a f5915b;
    private final Object f5916c;
    private final cg f5917d;
    private final zzqa f5918e;
    private final zzt f5919f;
    private final zzd f5920g;
    private sy f5921h;
    private zze f5922i;
    private zzec f5923j;
    private boolean f5924k;
    private boolean f5925l;
    private boolean f5926m;
    private boolean f5927n;
    private Boolean f5928o;
    private int f5929p;
    private boolean f5930q;
    private String f5931r;
    private tc f5932s;
    private boolean f5933t;
    private boolean f5934u;
    private jb f5935v;
    private int f5936w;
    private int f5937x;
    private im f5938y;
    private im f5939z;

    /* renamed from: com.google.android.gms.internal.tb.1 */
    class C20031 implements kg {
        final /* synthetic */ tb f5898a;

        C20031(tb tbVar) {
            this.f5898a = tbVar;
        }

        public void m8886a(sx sxVar, Map<String, String> map) {
            if (map != null) {
                String str = (String) map.get("height");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        synchronized (this.f5898a.f5916c) {
                            if (this.f5898a.f5937x != parseInt) {
                                this.f5898a.f5937x = parseInt;
                                this.f5898a.requestLayout();
                            }
                        }
                    } catch (Throwable e) {
                        sg.m8447c("Exception occurred while getting webview content height", e);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.tb.2 */
    class C20042 implements Runnable {
        final /* synthetic */ tb f5899a;

        C20042(tb tbVar) {
            this.f5899a = tbVar;
        }

        public void run() {
            super.destroy();
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.tb.a */
    public static class C2005a extends MutableContextWrapper {
        private Activity f5900a;
        private Context f5901b;
        private Context f5902c;

        public C2005a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Activity m8887a() {
            return this.f5900a;
        }

        public Context m8888b() {
            return this.f5902c;
        }

        public Object getSystemService(String str) {
            return this.f5902c.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.f5901b = context.getApplicationContext();
            this.f5900a = context instanceof Activity ? (Activity) context : null;
            this.f5902c = context;
            super.setBaseContext(this.f5901b);
        }

        public void startActivity(Intent intent) {
            if (this.f5900a != null) {
                this.f5900a.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f5901b.startActivity(intent);
        }
    }

    protected tb(C2005a c2005a, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, cg cgVar, zzqa com_google_android_gms_internal_zzqa, io ioVar, zzt com_google_android_gms_ads_internal_zzt, zzd com_google_android_gms_ads_internal_zzd) {
        super(c2005a);
        this.f5916c = new Object();
        this.f5930q = true;
        this.f5914a = false;
        this.f5931r = BuildConfig.VERSION_NAME;
        this.f5908F = -1;
        this.f5909G = -1;
        this.f5910H = -1;
        this.f5911I = -1;
        this.f5915b = c2005a;
        this.f5923j = com_google_android_gms_internal_zzec;
        this.f5926m = z;
        this.f5929p = -1;
        this.f5917d = cgVar;
        this.f5918e = com_google_android_gms_internal_zzqa;
        this.f5919f = com_google_android_gms_ads_internal_zzt;
        this.f5920g = com_google_android_gms_ads_internal_zzd;
        this.f5913K = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzv.zzcJ().m8511a((Context) c2005a, com_google_android_gms_internal_zzqa.f6636b, settings);
        zzv.zzcL().m8570a(getContext(), settings);
        setDownloadListener(this);
        m8892M();
        if (C1387m.m4963e()) {
            addJavascriptInterface(new td(this), "googleAdsJsInterface");
        }
        if (C1387m.m4959a()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.f5907E = new se(this.f5915b.m8887a(), this, this, null);
        m8900a(ioVar);
    }

    private void m8889J() {
        synchronized (this.f5916c) {
            this.f5928o = zzv.zzcN().m8418l();
            if (this.f5928o == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    m8922a(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    m8922a(Boolean.valueOf(false));
                }
            }
        }
    }

    private void m8890K() {
        ik.m6727a(this.f5904B.m6737a(), this.f5939z, "aeh2");
    }

    private void m8891L() {
        ik.m6727a(this.f5904B.m6737a(), this.f5939z, "aebb2");
    }

    private void m8892M() {
        synchronized (this.f5916c) {
            if (this.f5926m || this.f5923j.f6455e) {
                if (VERSION.SDK_INT < 14) {
                    sg.m8444b("Disabling hardware acceleration on an overlay.");
                    m8893N();
                } else {
                    sg.m8444b("Enabling hardware acceleration on an overlay.");
                    m8894O();
                }
            } else if (VERSION.SDK_INT < 18) {
                sg.m8444b("Disabling hardware acceleration on an AdView.");
                m8893N();
            } else {
                sg.m8444b("Enabling hardware acceleration on an AdView.");
                m8894O();
            }
        }
    }

    private void m8893N() {
        synchronized (this.f5916c) {
            if (!this.f5927n) {
                zzv.zzcL().m8580c((View) this);
            }
            this.f5927n = true;
        }
    }

    private void m8894O() {
        synchronized (this.f5916c) {
            if (this.f5927n) {
                zzv.zzcL().m8576b((View) this);
            }
            this.f5927n = false;
        }
    }

    private void m8895P() {
        synchronized (this.f5916c) {
            this.f5912J = null;
        }
    }

    private void m8896Q() {
        if (this.f5904B != null) {
            io a = this.f5904B.m6737a();
            if (a != null && zzv.zzcN().m8412f() != null) {
                zzv.zzcN().m8412f().m6719a(a);
            }
        }
    }

    static tb m8898a(Context context, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, cg cgVar, zzqa com_google_android_gms_internal_zzqa, io ioVar, zzt com_google_android_gms_ads_internal_zzt, zzd com_google_android_gms_ads_internal_zzd) {
        return new tb(new C2005a(context), com_google_android_gms_internal_zzec, z, z2, cgVar, com_google_android_gms_internal_zzqa, ioVar, com_google_android_gms_ads_internal_zzt, com_google_android_gms_ads_internal_zzd);
    }

    private void m8900a(io ioVar) {
        m8896Q();
        this.f5904B = new in(new io(true, "make_wv", this.f5923j.f6452b));
        this.f5904B.m6737a().m6742a(ioVar);
        this.f5939z = ik.m6724a(this.f5904B.m6737a());
        this.f5904B.m6738a("native:view_create", this.f5939z);
        this.f5903A = null;
        this.f5938y = null;
    }

    private void m8903e(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        m8927a("onAdVisibilityChanged", hashMap);
    }

    public boolean m8904A() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5936w > 0;
        }
        return z;
    }

    public void m8905B() {
        this.f5907E.m8683a();
    }

    public void m8906C() {
        if (this.f5903A == null) {
            this.f5903A = ik.m6724a(this.f5904B.m6737a());
            this.f5904B.m6738a("native:view_load", this.f5903A);
        }
    }

    public OnClickListener m8907D() {
        return (OnClickListener) this.f5905C.get();
    }

    public jb m8908E() {
        jb jbVar;
        synchronized (this.f5916c) {
            jbVar = this.f5935v;
        }
        return jbVar;
    }

    public void m8909F() {
        setBackgroundColor(0);
    }

    public boolean m8910G() {
        if (!m8950l().m8816b() && !m8950l().m8817c()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics a = zzv.zzcJ().m8493a(this.f5913K);
        int b = gr.m6416a().m8703b(a, a.widthPixels);
        int b2 = gr.m6416a().m8703b(a, a.heightPixels);
        Activity f = m8944f();
        if (f == null || f.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] a2 = zzv.zzcJ().m8528a(f);
            i2 = gr.m6416a().m8703b(a, a2[0]);
            i = gr.m6416a().m8703b(a, a2[1]);
        }
        if (this.f5909G == b && this.f5908F == b2 && this.f5910H == i2 && this.f5911I == i) {
            return false;
        }
        boolean z = (this.f5909G == b && this.f5908F == b2) ? false : true;
        this.f5909G = b;
        this.f5908F = b2;
        this.f5910H = i2;
        this.f5911I = i;
        new na(this).m7688a(b, b2, i2, i, a.density, this.f5913K.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean m8911H() {
        Boolean bool;
        synchronized (this.f5916c) {
            bool = this.f5928o;
        }
        return bool;
    }

    kg m8912I() {
        return new C20031(this);
    }

    public WebView m8913a() {
        return this;
    }

    public void m8914a(int i) {
        if (i == 0) {
            m8891L();
        }
        m8890K();
        if (this.f5904B.m6737a() != null) {
            this.f5904B.m6737a().m6744a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f5918e.f6636b);
        m8927a("onhide", hashMap);
    }

    public void m8915a(Context context) {
        this.f5915b.setBaseContext(context);
        this.f5907E.m8684a(this.f5915b.m8887a());
    }

    public void m8916a(Context context, zzec com_google_android_gms_internal_zzec, io ioVar) {
        synchronized (this.f5916c) {
            this.f5907E.m8685b();
            m8915a(context);
            this.f5922i = null;
            this.f5923j = com_google_android_gms_internal_zzec;
            this.f5926m = false;
            this.f5924k = false;
            this.f5931r = BuildConfig.VERSION_NAME;
            this.f5929p = -1;
            zzv.zzcL().m8577b((sx) this);
            loadUrl("about:blank");
            this.f5921h.m8827m();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.f5930q = true;
            this.f5914a = false;
            this.f5932s = null;
            m8900a(ioVar);
            this.f5933t = false;
            this.f5936w = 0;
            zzv.zzdg().m7136a((sx) this);
            m8895P();
        }
    }

    public void m8917a(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.f5916c) {
            this.f5922i = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void m8918a(C1562a c1562a) {
        synchronized (this.f5916c) {
            this.f5933t = c1562a.f4009m;
        }
        m8903e(c1562a.f4009m);
    }

    public void m8919a(jb jbVar) {
        synchronized (this.f5916c) {
            this.f5935v = jbVar;
        }
    }

    public void m8920a(tc tcVar) {
        synchronized (this.f5916c) {
            if (this.f5932s != null) {
                sg.m8446c("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.f5932s = tcVar;
        }
    }

    public void m8921a(zzec com_google_android_gms_internal_zzec) {
        synchronized (this.f5916c) {
            this.f5923j = com_google_android_gms_internal_zzec;
            requestLayout();
        }
    }

    void m8922a(Boolean bool) {
        synchronized (this.f5916c) {
            this.f5928o = bool;
        }
        zzv.zzcN().m8397a(bool);
    }

    public void m8923a(String str) {
        synchronized (this.f5916c) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                sg.m8449e(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    @TargetApi(19)
    protected void m8924a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void m8925a(String str, kg kgVar) {
        if (this.f5921h != null) {
            this.f5921h.m8810a(str, kgVar);
        }
    }

    public void m8926a(String str, String str2) {
        m8941d(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    public void m8927a(String str, Map<String, ?> map) {
        try {
            m8935b(str, zzv.zzcJ().m8506a((Map) map));
        } catch (JSONException e) {
            sg.m8449e("Could not convert parameters to JSON.");
        }
    }

    public void m8928a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m8926a(str, jSONObject.toString());
    }

    public void m8929a(boolean z) {
        synchronized (this.f5916c) {
            this.f5926m = z;
            m8892M();
        }
    }

    public View m8930b() {
        return this;
    }

    public void m8931b(int i) {
        synchronized (this.f5916c) {
            this.f5929p = i;
            if (this.f5922i != null) {
                this.f5922i.setRequestedOrientation(this.f5929p);
            }
        }
    }

    public void m8932b(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.f5916c) {
            this.f5906D = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void m8933b(String str) {
        synchronized (this.f5916c) {
            if (str == null) {
                str = BuildConfig.VERSION_NAME;
            }
            this.f5931r = str;
        }
    }

    public void m8934b(String str, kg kgVar) {
        if (this.f5921h != null) {
            this.f5921h.m8815b(str, kgVar);
        }
    }

    public void m8935b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        sg.m8444b(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        m8941d(stringBuilder.toString());
    }

    public void m8936b(boolean z) {
        synchronized (this.f5916c) {
            if (this.f5922i != null) {
                this.f5922i.zza(this.f5921h.m8816b(), z);
            } else {
                this.f5924k = z;
            }
        }
    }

    public void m8937c() {
        m8890K();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f5918e.f6636b);
        m8927a("onhide", hashMap);
    }

    protected void m8938c(String str) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void m8939c(boolean z) {
        synchronized (this.f5916c) {
            this.f5930q = z;
        }
    }

    public void m8940d() {
        if (this.f5938y == null) {
            ik.m6727a(this.f5904B.m6737a(), this.f5939z, "aes2");
            this.f5938y = ik.m6724a(this.f5904B.m6737a());
            this.f5904B.m6738a("native:view_show", this.f5938y);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f5918e.f6636b);
        m8927a("onshow", hashMap);
    }

    protected void m8941d(String str) {
        if (C1387m.m4965g()) {
            if (m8911H() == null) {
                m8889J();
            }
            if (m8911H().booleanValue()) {
                m8924a(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            m8938c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        m8938c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public void m8942d(boolean z) {
        synchronized (this.f5916c) {
            this.f5936w = (z ? 1 : -1) + this.f5936w;
            if (this.f5936w <= 0 && this.f5922i != null) {
                this.f5922i.zzhr();
            }
        }
    }

    public void destroy() {
        synchronized (this.f5916c) {
            m8896Q();
            this.f5907E.m8685b();
            if (this.f5922i != null) {
                this.f5922i.close();
                this.f5922i.onDestroy();
                this.f5922i = null;
            }
            this.f5921h.m8827m();
            if (this.f5925l) {
                return;
            }
            zzv.zzdg().m7136a((sx) this);
            m8895P();
            this.f5925l = true;
            rm.m8450a("Initiating WebView self destruct sequence in 3...");
            this.f5921h.m8821g();
        }
    }

    public void m8943e() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzv.zzcJ().m8552h()));
        hashMap.put("app_volume", String.valueOf(zzv.zzcJ().m8549g()));
        hashMap.put("device_volume", String.valueOf(zzv.zzcJ().m8555j(getContext())));
        m8927a("volume", hashMap);
    }

    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    public Activity m8944f() {
        return this.f5915b.m8887a();
    }

    protected void finalize() {
        synchronized (this.f5916c) {
            if (!this.f5925l) {
                this.f5921h.m8827m();
                zzv.zzdg().m7136a((sx) this);
                m8895P();
            }
        }
        super.finalize();
    }

    public Context m8945g() {
        return this.f5915b.m8888b();
    }

    public zzd m8946h() {
        return this.f5920g;
    }

    public zze m8947i() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.f5916c) {
            com_google_android_gms_ads_internal_overlay_zze = this.f5922i;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zze m8948j() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.f5916c) {
            com_google_android_gms_ads_internal_overlay_zze = this.f5906D;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zzec m8949k() {
        zzec com_google_android_gms_internal_zzec;
        synchronized (this.f5916c) {
            com_google_android_gms_internal_zzec = this.f5923j;
        }
        return com_google_android_gms_internal_zzec;
    }

    public sy m8950l() {
        return this.f5921h;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f5916c) {
            if (m8956r()) {
                sg.m8449e("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    sg.m8449e(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            }
        }
    }

    public boolean m8951m() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5924k;
        }
        return z;
    }

    public cg m8952n() {
        return this.f5917d;
    }

    public zzqa m8953o() {
        return this.f5918e;
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.f5916c) {
            super.onAttachedToWindow();
            if (!m8956r()) {
                this.f5907E.m8686c();
            }
            boolean z2 = this.f5933t;
            if (m8950l() == null || !m8950l().m8817c()) {
                z = z2;
            } else if (!this.f5934u) {
                OnGlobalLayoutListener d = m8950l().m8818d();
                if (d != null) {
                    zzv.zzdh().m8725a(m8930b(), d);
                }
                OnScrollChangedListener e = m8950l().m8819e();
                if (e != null) {
                    zzv.zzdh().m8726a(m8930b(), e);
                }
                this.f5934u = true;
            }
            m8903e(z);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f5916c) {
            if (!m8956r()) {
                this.f5907E.m8687d();
            }
            super.onDetachedFromWindow();
            if (this.f5934u && m8950l() != null && m8950l().m8817c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener d = m8950l().m8818d();
                if (d != null) {
                    zzv.zzcL().m8568a(getViewTreeObserver(), d);
                }
                OnScrollChangedListener e = m8950l().m8819e();
                if (e != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(e);
                }
                this.f5934u = false;
            }
        }
        m8903e(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzv.zzcJ().m8509a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            sg.m8444b(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!m8956r()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (m8950l() != null && m8950l().m8828n() != null) {
                    m8950l().m8828n().m4052a();
                }
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) C1648if.az.m6682c()).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if ((motionEvent.getActionMasked() == 8 ? 1 : 0) != 0 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onGlobalLayout() {
        boolean G = m8910G();
        zze i = m8947i();
        if (i != null && G) {
            i.zzho();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this.f5916c) {
            if (m8956r()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.f5926m || this.f5923j.f6459i) {
                super.onMeasure(i, i2);
            } else if (this.f5923j.f6460j) {
                if (((Boolean) C1648if.co.m6682c()).booleanValue() || !C1387m.m4963e()) {
                    super.onMeasure(i, i2);
                    return;
                }
                m8925a("/contentHeight", m8912I());
                m8941d("(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();");
                r0 = this.f5915b.getResources().getDisplayMetrics().density;
                r1 = MeasureSpec.getSize(i);
                switch (this.f5937x) {
                    case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                        i3 = MeasureSpec.getSize(i2);
                        break;
                    default:
                        i3 = (int) (r0 * ((float) this.f5937x));
                        break;
                }
                setMeasuredDimension(r1, i3);
            } else if (this.f5923j.f6455e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.f5913K.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                r1 = MeasureSpec.getSize(i2);
                mode = (mode == RtlSpacingHelper.UNDEFINED || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == RtlSpacingHelper.UNDEFINED || mode2 == 1073741824) {
                    i3 = r1;
                }
                if (this.f5923j.f6457g > mode || this.f5923j.f6454d > r0) {
                    r0 = this.f5915b.getResources().getDisplayMetrics().density;
                    mode2 = (int) (((float) this.f5923j.f6454d) / r0);
                    size = (int) (((float) size) / r0);
                    sg.m8449e(new StringBuilder(C0861R.styleable.AppCompatTheme_buttonStyleSmall).append("Not enough space to show ad. Needs ").append((int) (((float) this.f5923j.f6457g) / r0)).append("x").append(mode2).append(" dp, but only has ").append(size).append("x").append((int) (((float) r1) / r0)).append(" dp.").toString());
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.f5923j.f6457g, this.f5923j.f6454d);
                }
            }
        }
    }

    public void onPause() {
        if (!m8956r()) {
            try {
                if (C1387m.m4959a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                sg.m8445b("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!m8956r()) {
            try {
                if (C1387m.m4959a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                sg.m8445b("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m8950l().m8817c()) {
            synchronized (this.f5916c) {
                if (this.f5935v != null) {
                    this.f5935v.m6916a(motionEvent);
                }
            }
        } else if (this.f5917d != null) {
            this.f5917d.m5532a(motionEvent);
        }
        return m8956r() ? false : super.onTouchEvent(motionEvent);
    }

    public boolean m8954p() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5926m;
        }
        return z;
    }

    public int m8955q() {
        int i;
        synchronized (this.f5916c) {
            i = this.f5929p;
        }
        return i;
    }

    public boolean m8956r() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5925l;
        }
        return z;
    }

    public void m8957s() {
        synchronized (this.f5916c) {
            rm.m8450a("Destroying WebView!");
            rq.f5755a.post(new C20042(this));
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5905C = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof sy) {
            this.f5921h = (sy) webViewClient;
        }
    }

    public void stopLoading() {
        if (!m8956r()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                sg.m8445b("Could not stop loading webview.", e);
            }
        }
    }

    public boolean m8958t() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5930q;
        }
        return z;
    }

    public boolean m8959u() {
        boolean z;
        synchronized (this.f5916c) {
            z = this.f5914a;
        }
        return z;
    }

    public String m8960v() {
        String str;
        synchronized (this.f5916c) {
            str = this.f5931r;
        }
        return str;
    }

    public sw m8961w() {
        return null;
    }

    public im m8962x() {
        return this.f5939z;
    }

    public in m8963y() {
        return this.f5904B;
    }

    public tc m8964z() {
        tc tcVar;
        synchronized (this.f5916c) {
            tcVar = this.f5932s;
        }
        return tcVar;
    }

    public void zzbV() {
        synchronized (this.f5916c) {
            this.f5914a = true;
            if (this.f5919f != null) {
                this.f5919f.zzbV();
            }
        }
    }

    public void zzbW() {
        synchronized (this.f5916c) {
            this.f5914a = false;
            if (this.f5919f != null) {
                this.f5919f.zzbW();
            }
        }
    }
}
