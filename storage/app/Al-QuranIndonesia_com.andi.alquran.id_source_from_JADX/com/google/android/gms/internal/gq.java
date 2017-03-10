package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.FrameLayout;
import com.google.android.gms.internal.hc.C1122a;
import com.google.android.gms.p039a.C1111d;

@op
public class gq {
    private hc f4203a;
    private final Object f4204b;
    private final gi f4205c;
    private final gh f4206d;
    private final ho f4207e;
    private final jw f4208f;
    private final qe f4209g;
    private final ns f4210h;
    private final nc f4211i;

    /* renamed from: com.google.android.gms.internal.gq.a */
    abstract class C1596a<T> {
        final /* synthetic */ gq f4171f;

        C1596a(gq gqVar) {
            this.f4171f = gqVar;
        }

        protected abstract T m6353b();

        protected abstract T m6354b(hc hcVar);

        protected final T m6355c() {
            T t = null;
            hc a = this.f4171f.m6399b();
            if (a == null) {
                sg.m8449e("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = m6354b(a);
                } catch (Throwable e) {
                    sg.m8447c("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }

        protected final T m6356d() {
            try {
                return m6353b();
            } catch (Throwable e) {
                sg.m8447c("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.1 */
    class C15971 extends C1596a<gz> {
        final /* synthetic */ Context f4172a;
        final /* synthetic */ zzec f4173b;
        final /* synthetic */ String f4174c;
        final /* synthetic */ md f4175d;
        final /* synthetic */ gq f4176e;

        C15971(gq gqVar, Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar) {
            this.f4176e = gqVar;
            this.f4172a = context;
            this.f4173b = com_google_android_gms_internal_zzec;
            this.f4174c = str;
            this.f4175d = mdVar;
            super(gqVar);
        }

        public gz m6357a() {
            gz a = this.f4176e.f4205c.m6327a(this.f4172a, this.f4173b, this.f4174c, this.f4175d, 1);
            if (a != null) {
                return a;
            }
            this.f4176e.m6395a(this.f4172a, "banner");
            return new hq();
        }

        public gz m6358a(hc hcVar) {
            return hcVar.createBannerAdManager(C1111d.m3896a(this.f4172a), this.f4173b, this.f4174c, this.f4175d, 10084000);
        }

        public /* synthetic */ Object m6359b() {
            return m6357a();
        }

        public /* synthetic */ Object m6360b(hc hcVar) {
            return m6358a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.2 */
    class C15982 extends C1596a<gz> {
        final /* synthetic */ Context f4177a;
        final /* synthetic */ zzec f4178b;
        final /* synthetic */ String f4179c;
        final /* synthetic */ gq f4180d;

        C15982(gq gqVar, Context context, zzec com_google_android_gms_internal_zzec, String str) {
            this.f4180d = gqVar;
            this.f4177a = context;
            this.f4178b = com_google_android_gms_internal_zzec;
            this.f4179c = str;
            super(gqVar);
        }

        public gz m6361a() {
            gz a = this.f4180d.f4205c.m6327a(this.f4177a, this.f4178b, this.f4179c, null, 3);
            if (a != null) {
                return a;
            }
            this.f4180d.m6395a(this.f4177a, "search");
            return new hq();
        }

        public gz m6362a(hc hcVar) {
            return hcVar.createSearchAdManager(C1111d.m3896a(this.f4177a), this.f4178b, this.f4179c, 10084000);
        }

        public /* synthetic */ Object m6363b() {
            return m6361a();
        }

        public /* synthetic */ Object m6364b(hc hcVar) {
            return m6362a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.3 */
    class C15993 extends C1596a<gz> {
        final /* synthetic */ Context f4181a;
        final /* synthetic */ zzec f4182b;
        final /* synthetic */ String f4183c;
        final /* synthetic */ md f4184d;
        final /* synthetic */ gq f4185e;

        C15993(gq gqVar, Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar) {
            this.f4185e = gqVar;
            this.f4181a = context;
            this.f4182b = com_google_android_gms_internal_zzec;
            this.f4183c = str;
            this.f4184d = mdVar;
            super(gqVar);
        }

        public gz m6365a() {
            gz a = this.f4185e.f4205c.m6327a(this.f4181a, this.f4182b, this.f4183c, this.f4184d, 2);
            if (a != null) {
                return a;
            }
            this.f4185e.m6395a(this.f4181a, "interstitial");
            return new hq();
        }

        public gz m6366a(hc hcVar) {
            return hcVar.createInterstitialAdManager(C1111d.m3896a(this.f4181a), this.f4182b, this.f4183c, this.f4184d, 10084000);
        }

        public /* synthetic */ Object m6367b() {
            return m6365a();
        }

        public /* synthetic */ Object m6368b(hc hcVar) {
            return m6366a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.4 */
    class C16004 extends C1596a<gx> {
        final /* synthetic */ Context f4186a;
        final /* synthetic */ String f4187b;
        final /* synthetic */ md f4188c;
        final /* synthetic */ gq f4189d;

        C16004(gq gqVar, Context context, String str, md mdVar) {
            this.f4189d = gqVar;
            this.f4186a = context;
            this.f4187b = str;
            this.f4188c = mdVar;
            super(gqVar);
        }

        public gx m6369a() {
            gx a = this.f4189d.f4206d.m6324a(this.f4186a, this.f4187b, this.f4188c);
            if (a != null) {
                return a;
            }
            this.f4189d.m6395a(this.f4186a, "native_ad");
            return new hp();
        }

        public gx m6370a(hc hcVar) {
            return hcVar.createAdLoaderBuilder(C1111d.m3896a(this.f4186a), this.f4187b, this.f4188c, 10084000);
        }

        public /* synthetic */ Object m6371b() {
            return m6369a();
        }

        public /* synthetic */ Object m6372b(hc hcVar) {
            return m6370a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.5 */
    class C16015 extends C1596a<he> {
        final /* synthetic */ Context f4190a;
        final /* synthetic */ gq f4191b;

        C16015(gq gqVar, Context context) {
            this.f4191b = gqVar;
            this.f4190a = context;
            super(gqVar);
        }

        public he m6373a() {
            he b = this.f4191b.f4207e.m6595b(this.f4190a);
            if (b != null) {
                return b;
            }
            this.f4191b.m6395a(this.f4190a, "mobile_ads_settings");
            return new hr();
        }

        public he m6374a(hc hcVar) {
            return hcVar.getMobileAdsSettingsManagerWithClientJarVersion(C1111d.m3896a(this.f4190a), 10084000);
        }

        public /* synthetic */ Object m6375b() {
            return m6373a();
        }

        public /* synthetic */ Object m6376b(hc hcVar) {
            return m6374a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.6 */
    class C16026 extends C1596a<jk> {
        final /* synthetic */ FrameLayout f4192a;
        final /* synthetic */ FrameLayout f4193b;
        final /* synthetic */ Context f4194c;
        final /* synthetic */ gq f4195d;

        C16026(gq gqVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
            this.f4195d = gqVar;
            this.f4192a = frameLayout;
            this.f4193b = frameLayout2;
            this.f4194c = context;
            super(gqVar);
        }

        public jk m6377a() {
            jk a = this.f4195d.f4208f.m7049a(this.f4194c, this.f4192a, this.f4193b);
            if (a != null) {
                return a;
            }
            this.f4195d.m6395a(this.f4194c, "native_ad_view_delegate");
            return new hs();
        }

        public jk m6378a(hc hcVar) {
            return hcVar.createNativeAdViewDelegate(C1111d.m3896a(this.f4192a), C1111d.m3896a(this.f4193b));
        }

        public /* synthetic */ Object m6379b() {
            return m6377a();
        }

        public /* synthetic */ Object m6380b(hc hcVar) {
            return m6378a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.7 */
    class C16037 extends C1596a<qa> {
        final /* synthetic */ Context f4196a;
        final /* synthetic */ md f4197b;
        final /* synthetic */ gq f4198c;

        C16037(gq gqVar, Context context, md mdVar) {
            this.f4198c = gqVar;
            this.f4196a = context;
            this.f4197b = mdVar;
            super(gqVar);
        }

        public qa m6381a() {
            qa a = this.f4198c.f4209g.m8268a(this.f4196a, this.f4197b);
            if (a != null) {
                return a;
            }
            this.f4198c.m6395a(this.f4196a, "rewarded_video");
            return new ht();
        }

        public qa m6382a(hc hcVar) {
            return hcVar.createRewardedVideoAd(C1111d.m3896a(this.f4196a), this.f4197b, 10084000);
        }

        public /* synthetic */ Object m6383b() {
            return m6381a();
        }

        public /* synthetic */ Object m6384b(hc hcVar) {
            return m6382a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.8 */
    class C16048 extends C1596a<nn> {
        final /* synthetic */ Activity f4199a;
        final /* synthetic */ gq f4200b;

        C16048(gq gqVar, Activity activity) {
            this.f4200b = gqVar;
            this.f4199a = activity;
            super(gqVar);
        }

        public nn m6385a() {
            nn a = this.f4200b.f4210h.m7783a(this.f4199a);
            if (a != null) {
                return a;
            }
            this.f4200b.m6395a(this.f4199a, "iap");
            return null;
        }

        public nn m6386a(hc hcVar) {
            return hcVar.createInAppPurchaseManager(C1111d.m3896a(this.f4199a));
        }

        public /* synthetic */ Object m6387b() {
            return m6385a();
        }

        public /* synthetic */ Object m6388b(hc hcVar) {
            return m6386a(hcVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.gq.9 */
    class C16059 extends C1596a<nd> {
        final /* synthetic */ Activity f4201a;
        final /* synthetic */ gq f4202b;

        C16059(gq gqVar, Activity activity) {
            this.f4202b = gqVar;
            this.f4201a = activity;
            super(gqVar);
        }

        public nd m6389a() {
            nd a = this.f4202b.f4211i.m7756a(this.f4201a);
            if (a != null) {
                return a;
            }
            this.f4202b.m6395a(this.f4201a, "ad_overlay");
            return null;
        }

        public nd m6390a(hc hcVar) {
            return hcVar.createAdOverlay(C1111d.m3896a(this.f4201a));
        }

        public /* synthetic */ Object m6391b() {
            return m6389a();
        }

        public /* synthetic */ Object m6392b(hc hcVar) {
            return m6390a(hcVar);
        }
    }

    public gq(gi giVar, gh ghVar, ho hoVar, jw jwVar, qe qeVar, ns nsVar, nc ncVar) {
        this.f4204b = new Object();
        this.f4205c = giVar;
        this.f4206d = ghVar;
        this.f4207e = hoVar;
        this.f4208f = jwVar;
        this.f4209g = qeVar;
        this.f4210h = nsVar;
        this.f4211i = ncVar;
    }

    private static hc m6393a() {
        try {
            Object newInstance = gq.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return C1122a.asInterface((IBinder) newInstance);
            }
            sg.m8449e("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            sg.m8447c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    private void m6395a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        gr.m6416a().m8696a(context, null, "gmob-apps", bundle, true);
    }

    private static boolean m6397a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        sg.m8446c("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private hc m6399b() {
        hc hcVar;
        synchronized (this.f4204b) {
            if (this.f4203a == null) {
                this.f4203a = m6393a();
            }
            hcVar = this.f4203a;
        }
        return hcVar;
    }

    public gx m6406a(Context context, String str, md mdVar) {
        return (gx) m6413a(context, false, new C16004(this, context, str, mdVar));
    }

    public gz m6407a(Context context, zzec com_google_android_gms_internal_zzec, String str) {
        return (gz) m6413a(context, false, new C15982(this, context, com_google_android_gms_internal_zzec, str));
    }

    public gz m6408a(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar) {
        return (gz) m6413a(context, false, new C15971(this, context, com_google_android_gms_internal_zzec, str, mdVar));
    }

    public he m6409a(Context context) {
        return (he) m6413a(context, false, new C16015(this, context));
    }

    public jk m6410a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (jk) m6413a(context, false, new C16026(this, frameLayout, frameLayout2, context));
    }

    public nn m6411a(Activity activity) {
        return (nn) m6413a((Context) activity, m6397a(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new C16048(this, activity));
    }

    public qa m6412a(Context context, md mdVar) {
        return (qa) m6413a(context, false, new C16037(this, context, mdVar));
    }

    <T> T m6413a(Context context, boolean z, C1596a<T> c1596a) {
        if (!(z || gr.m6416a().m8705b(context))) {
            sg.m8444b("Google Play Services is not available");
            z = true;
        }
        T c;
        if (z) {
            c = c1596a.m6355c();
            return c == null ? c1596a.m6356d() : c;
        } else {
            c = c1596a.m6356d();
            return c == null ? c1596a.m6355c() : c;
        }
    }

    public gz m6414b(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar) {
        return (gz) m6413a(context, false, new C15993(this, context, com_google_android_gms_internal_zzec, str, mdVar));
    }

    public nd m6415b(Activity activity) {
        return (nd) m6413a((Context) activity, m6397a(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new C16059(this, activity));
    }
}
