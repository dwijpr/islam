package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.nd.C1144a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rl;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.rt;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.sy;
import com.google.android.gms.internal.sy.C1137a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.Collections;
import java.util.Map;

@op
public class zze extends C1144a implements zzv {
    static final int f2414a;
    AdOverlayInfoParcel f2415b;
    sx f2416c;
    zzc f2417d;
    zzp f2418e;
    boolean f2419f;
    FrameLayout f2420g;
    CustomViewCallback f2421h;
    boolean f2422i;
    boolean f2423j;
    C1141b f2424k;
    boolean f2425l;
    int f2426m;
    zzm f2427n;
    private final Activity f2428o;
    private final Object f2429p;
    private Runnable f2430q;
    private boolean f2431r;
    private boolean f2432s;
    private boolean f2433t;
    private boolean f2434u;
    private boolean f2435v;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zze.1 */
    class C11381 implements C1137a {
        C11381(zze com_google_android_gms_ads_internal_overlay_zze) {
        }

        public void m3968a(sx sxVar, boolean z) {
            sxVar.m8767d();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zze.2 */
    class C11392 implements Runnable {
        final /* synthetic */ zze f2405a;

        C11392(zze com_google_android_gms_ads_internal_overlay_zze) {
            this.f2405a = com_google_android_gms_ads_internal_overlay_zze;
        }

        public void run() {
            this.f2405a.m3975b();
        }
    }

    @op
    /* renamed from: com.google.android.gms.ads.internal.overlay.zze.a */
    private static final class C1140a extends Exception {
        public C1140a(String str) {
            super(str);
        }
    }

    @op
    /* renamed from: com.google.android.gms.ads.internal.overlay.zze.b */
    static class C1141b extends RelativeLayout {
        rt f2406a;
        boolean f2407b;

        public C1141b(Context context, String str) {
            super(context);
            this.f2406a = new rt(context, str);
        }

        void m3969a() {
            this.f2407b = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!this.f2407b) {
                this.f2406a.m8622a(motionEvent);
            }
            return false;
        }
    }

    @op
    /* renamed from: com.google.android.gms.ads.internal.overlay.zze.c */
    private class C1143c extends rl {
        final /* synthetic */ zze f2413a;

        /* renamed from: com.google.android.gms.ads.internal.overlay.zze.c.1 */
        class C11421 implements Runnable {
            final /* synthetic */ Drawable f2408a;
            final /* synthetic */ C1143c f2409b;

            C11421(C1143c c1143c, Drawable drawable) {
                this.f2409b = c1143c;
                this.f2408a = drawable;
            }

            public void run() {
                this.f2409b.f2413a.f2428o.getWindow().setBackgroundDrawable(this.f2408a);
            }
        }

        private C1143c(zze com_google_android_gms_ads_internal_overlay_zze) {
            this.f2413a = com_google_android_gms_ads_internal_overlay_zze;
        }

        public void onStop() {
        }

        public void zzcm() {
            Bitmap a = zzv.zzde().m8672a(Integer.valueOf(this.f2413a.f2415b.zzNi.zztM));
            if (a != null) {
                rq.f5755a.post(new C11421(this, zzv.zzcL().m8561a(this.f2413a.f2428o, a, this.f2413a.f2415b.zzNi.zztK, this.f2413a.f2415b.zzNi.zztL)));
            }
        }
    }

    @op
    public static class zzc {
        public final int index;
        public final ViewGroup parent;
        public final LayoutParams zzMT;
        public final Context zzqr;

        public zzc(sx sxVar) {
            this.zzMT = sxVar.getLayoutParams();
            ViewParent parent = sxVar.getParent();
            this.zzqr = sxVar.m8771g();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new C1140a("Could not get the parent of the WebView for an overlay.");
            }
            this.parent = (ViewGroup) parent;
            this.index = this.parent.indexOfChild(sxVar.m8760b());
            this.parent.removeView(sxVar.m8760b());
            sxVar.m8759a(true);
        }
    }

    static {
        f2414a = Color.argb(0, 0, 0, 0);
    }

    public zze(Activity activity) {
        this.f2419f = false;
        this.f2422i = false;
        this.f2423j = false;
        this.f2425l = false;
        this.f2426m = 0;
        this.f2429p = new Object();
        this.f2433t = false;
        this.f2434u = false;
        this.f2435v = true;
        this.f2428o = activity;
        this.f2427n = new zzt();
    }

    protected void m3972a() {
        if (this.f2428o.isFinishing() && !this.f2433t) {
            this.f2433t = true;
            if (this.f2416c != null) {
                m3973a(this.f2426m);
                synchronized (this.f2429p) {
                    if (this.f2431r || !this.f2416c.m8741A()) {
                    } else {
                        this.f2430q = new C11392(this);
                        rq.f5755a.postDelayed(this.f2430q, ((Long) C1648if.aJ.m6682c()).longValue());
                        return;
                    }
                }
            }
            m3975b();
        }
    }

    protected void m3973a(int i) {
        this.f2416c.m8748a(i);
    }

    protected void m3974a(boolean z) {
        if (!this.f2432s) {
            this.f2428o.requestWindowFeature(1);
        }
        Window window = this.f2428o.getWindow();
        if (window == null) {
            throw new C1140a("Invalid activity, no window available.");
        }
        boolean a = (C1387m.m4970l() && ((Boolean) C1648if.di.m6682c()).booleanValue()) ? zzv.zzcJ().m8522a(this.f2428o, this.f2428o.getResources().getConfiguration()) : true;
        Object obj = (this.f2415b.zzNi == null || !this.f2415b.zzNi.zztI) ? null : 1;
        if (!(this.f2423j && obj == null) && a) {
            window.setFlags(1024, 1024);
        }
        sy l = this.f2415b.zzMZ.m8776l();
        boolean b = l != null ? l.m8816b() : false;
        this.f2425l = false;
        if (b) {
            if (this.f2415b.orientation == zzv.zzcL().m8560a()) {
                this.f2425l = this.f2428o.getResources().getConfiguration().orientation == 1;
            } else if (this.f2415b.orientation == zzv.zzcL().m8574b()) {
                this.f2425l = this.f2428o.getResources().getConfiguration().orientation == 2;
            }
        }
        sg.m8444b("Delay onShow to next orientation change: " + this.f2425l);
        setRequestedOrientation(this.f2415b.orientation);
        if (zzv.zzcL().m8572a(window)) {
            sg.m8444b("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.f2423j) {
            this.f2424k.setBackgroundColor(f2414a);
        } else {
            this.f2424k.setBackgroundColor(-16777216);
        }
        this.f2428o.setContentView(this.f2424k);
        zzbp();
        if (z) {
            this.f2416c = zzv.zzcK().m8831a(this.f2428o, this.f2415b.zzMZ.m8775k(), true, b, null, this.f2415b.zzvf, null, null, this.f2415b.zzMZ.m8772h());
            this.f2416c.m8776l().m8804a(null, null, this.f2415b.zzNa, this.f2415b.zzNe, true, this.f2415b.zzNg, null, this.f2415b.zzMZ.m8776l().m8797a(), null, null);
            this.f2416c.m8776l().m8806a(new C11381(this));
            if (this.f2415b.url != null) {
                this.f2416c.loadUrl(this.f2415b.url);
            } else if (this.f2415b.zzNd != null) {
                this.f2416c.loadDataWithBaseURL(this.f2415b.zzNb, this.f2415b.zzNd, "text/html", "UTF-8", null);
            } else {
                throw new C1140a("No URL or HTML to display in ad overlay.");
            }
            if (this.f2415b.zzMZ != null) {
                this.f2415b.zzMZ.m8762b(this);
            }
        } else {
            this.f2416c = this.f2415b.zzMZ;
            this.f2416c.m8749a(this.f2428o);
        }
        this.f2416c.m8751a(this);
        ViewParent parent = this.f2416c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f2416c.m8760b());
        }
        if (this.f2423j) {
            this.f2416c.m8746F();
        }
        this.f2424k.addView(this.f2416c.m8760b(), -1, -1);
        if (!(z || this.f2425l)) {
            m3976c();
        }
        zzz(b);
        if (this.f2416c.m8777m()) {
            zza(b, true);
        }
        zzd h = this.f2416c.m8772h();
        zzn com_google_android_gms_ads_internal_overlay_zzn = h != null ? h.zzsO : null;
        if (com_google_android_gms_ads_internal_overlay_zzn != null) {
            this.f2427n = com_google_android_gms_ads_internal_overlay_zzn.zza(this.f2428o, this.f2416c, this.f2424k);
        } else {
            sg.m8449e("Appstreaming controller is null.");
        }
    }

    void m3975b() {
        if (!this.f2434u) {
            this.f2434u = true;
            if (this.f2416c != null) {
                this.f2424k.removeView(this.f2416c.m8760b());
                if (this.f2417d != null) {
                    this.f2416c.m8749a(this.f2417d.zzqr);
                    this.f2416c.m8759a(false);
                    this.f2417d.parent.addView(this.f2416c.m8760b(), this.f2417d.index, this.f2417d.zzMT);
                    this.f2417d = null;
                } else if (this.f2428o.getApplicationContext() != null) {
                    this.f2416c.m8749a(this.f2428o.getApplicationContext());
                }
                this.f2416c = null;
            }
            if (this.f2415b != null && this.f2415b.zzMY != null) {
                this.f2415b.zzMY.zzbN();
            }
        }
    }

    protected void m3976c() {
        this.f2416c.m8767d();
    }

    public void close() {
        this.f2426m = 2;
        this.f2428o.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onBackPressed() {
        this.f2426m = 0;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        this.f2428o.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f2422i = z;
        try {
            this.f2415b = AdOverlayInfoParcel.zzb(this.f2428o.getIntent());
            if (this.f2415b == null) {
                throw new C1140a("Could not get info for ad overlay.");
            }
            if (this.f2415b.zzvf.f6638d > 7500000) {
                this.f2426m = 3;
            }
            if (this.f2428o.getIntent() != null) {
                this.f2435v = this.f2428o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f2415b.zzNi != null) {
                this.f2423j = this.f2415b.zzNi.zztH;
            } else {
                this.f2423j = false;
            }
            if (((Boolean) C1648if.bT.m6682c()).booleanValue() && this.f2423j && this.f2415b.zzNi.zztM != -1) {
                new C1143c().zziw();
            }
            if (bundle == null) {
                if (this.f2415b.zzMY != null && this.f2435v) {
                    this.f2415b.zzMY.zzbO();
                }
                if (!(this.f2415b.zzNf == 1 || this.f2415b.zzMX == null)) {
                    this.f2415b.zzMX.onAdClicked();
                }
            }
            this.f2424k = new C1141b(this.f2428o, this.f2415b.zzNh);
            this.f2424k.setId(1000);
            switch (this.f2415b.zzNf) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    m3974a(false);
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    this.f2417d = new zzc(this.f2415b.zzMZ);
                    m3974a(false);
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    m3974a(true);
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    if (this.f2422i) {
                        this.f2426m = 3;
                        this.f2428o.finish();
                    } else if (!zzv.zzcG().zza(this.f2428o, this.f2415b.zzMW, this.f2415b.zzNe)) {
                        this.f2426m = 3;
                        this.f2428o.finish();
                    }
                default:
                    throw new C1140a("Could not determine ad overlay type.");
            }
        } catch (C1140a e) {
            sg.m8449e(e.getMessage());
            this.f2426m = 3;
            this.f2428o.finish();
        }
    }

    public void onDestroy() {
        if (this.f2416c != null) {
            this.f2424k.removeView(this.f2416c.m8760b());
        }
        m3972a();
    }

    public void onPause() {
        zzhi();
        if (this.f2415b.zzMY != null) {
            this.f2415b.zzMY.onPause();
        }
        if (!(((Boolean) C1648if.dj.m6682c()).booleanValue() || this.f2416c == null || (this.f2428o.isFinishing() && this.f2417d != null))) {
            zzv.zzcL().m8573a(this.f2416c);
        }
        m3972a();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f2415b != null && this.f2415b.zzNf == 4) {
            if (this.f2422i) {
                this.f2426m = 3;
                this.f2428o.finish();
            } else {
                this.f2422i = true;
            }
        }
        if (this.f2415b.zzMY != null) {
            this.f2415b.zzMY.onResume();
        }
        if (!((Boolean) C1648if.dj.m6682c()).booleanValue()) {
            if (this.f2416c == null || this.f2416c.m8782r()) {
                sg.m8449e("The webview does not exist. Ignoring action.");
            } else {
                zzv.zzcL().m8577b(this.f2416c);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f2422i);
    }

    public void onStart() {
        if (!((Boolean) C1648if.dj.m6682c()).booleanValue()) {
            return;
        }
        if (this.f2416c == null || this.f2416c.m8782r()) {
            sg.m8449e("The webview does not exist. Ignoring action.");
        } else {
            zzv.zzcL().m8577b(this.f2416c);
        }
    }

    public void onStop() {
        if (((Boolean) C1648if.dj.m6682c()).booleanValue() && this.f2416c != null && (!this.f2428o.isFinishing() || this.f2417d == null)) {
            zzv.zzcL().m8573a(this.f2416c);
        }
        m3972a();
    }

    public void setRequestedOrientation(int i) {
        this.f2428o.setRequestedOrientation(i);
    }

    public void zza(View view, CustomViewCallback customViewCallback) {
        this.f2420g = new FrameLayout(this.f2428o);
        this.f2420g.setBackgroundColor(-16777216);
        this.f2420g.addView(view, -1, -1);
        this.f2428o.setContentView(this.f2420g);
        zzbp();
        this.f2421h = customViewCallback;
        this.f2419f = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.f2418e != null) {
            this.f2418e.zza(z, z2);
        }
    }

    public void zzbp() {
        this.f2432s = true;
    }

    public void zzg(sx sxVar, Map<String, String> map) {
    }

    public void zzhi() {
        if (this.f2415b != null && this.f2419f) {
            setRequestedOrientation(this.f2415b.orientation);
        }
        if (this.f2420g != null) {
            this.f2428o.setContentView(this.f2424k);
            zzbp();
            this.f2420g.removeAllViews();
            this.f2420g = null;
        }
        if (this.f2421h != null) {
            this.f2421h.onCustomViewHidden();
            this.f2421h = null;
        }
        this.f2419f = false;
    }

    public void zzhj() {
        this.f2426m = 1;
        this.f2428o.finish();
    }

    public boolean zzhk() {
        boolean z = true;
        this.f2426m = 0;
        if (this.f2416c != null) {
            if (!this.f2416c.m8784t()) {
                z = false;
            }
            if (!z) {
                this.f2416c.m8757a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void zzhl() {
        this.f2424k.removeView(this.f2418e);
        zzz(true);
    }

    public void zzho() {
        if (this.f2425l) {
            this.f2425l = false;
            m3976c();
        }
    }

    public void zzhq() {
        this.f2424k.m3969a();
    }

    public void zzhr() {
        synchronized (this.f2429p) {
            this.f2431r = true;
            if (this.f2430q != null) {
                rq.f5755a.removeCallbacks(this.f2430q);
                rq.f5755a.post(this.f2430q);
            }
        }
    }

    public void zzn(C1108c c1108c) {
        if (((Boolean) C1648if.di.m6682c()).booleanValue() && C1387m.m4970l()) {
            if (zzv.zzcJ().m8522a(this.f2428o, (Configuration) C1111d.m3897a(c1108c))) {
                this.f2428o.getWindow().addFlags(1024);
                this.f2428o.getWindow().clearFlags(ItemAnimator.FLAG_MOVED);
                return;
            }
            this.f2428o.getWindow().addFlags(ItemAnimator.FLAG_MOVED);
            this.f2428o.getWindow().clearFlags(1024);
        }
    }

    public void zzz(boolean z) {
        this.f2418e = new zzp(this.f2428o, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f2418e.zza(z, this.f2415b.zzNc);
        this.f2424k.addView(this.f2418e, layoutParams);
    }
}
