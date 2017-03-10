package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.p039a.C1111d;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@op
public class jc extends je {
    private mh f4532b;
    private mi f4533c;
    private final zzr f4534d;
    private jd f4535e;
    private boolean f4536f;
    private Object f4537g;

    private jc(Context context, zzr com_google_android_gms_ads_internal_zzr, cg cgVar, C1660a c1660a) {
        super(context, com_google_android_gms_ads_internal_zzr, null, cgVar, null, c1660a, null, null);
        this.f4536f = false;
        this.f4537g = new Object();
        this.f4534d = com_google_android_gms_ads_internal_zzr;
    }

    public jc(Context context, zzr com_google_android_gms_ads_internal_zzr, cg cgVar, mh mhVar, C1660a c1660a) {
        this(context, com_google_android_gms_ads_internal_zzr, cgVar, c1660a);
        this.f4532b = mhVar;
    }

    public jc(Context context, zzr com_google_android_gms_ads_internal_zzr, cg cgVar, mi miVar, C1660a c1660a) {
        this(context, com_google_android_gms_ads_internal_zzr, cgVar, c1660a);
        this.f4533c = miVar;
    }

    public iw m6956a(OnClickListener onClickListener) {
        return null;
    }

    public void m6957a(View view, Map<String, WeakReference<View>> map) {
        C1314c.m4631b("recordImpression must be called on the main UI thread.");
        synchronized (this.f4537g) {
            m6944a(true);
            if (this.f4535e != null) {
                this.f4535e.m6920a(view, map);
                this.f4534d.recordImpression();
            } else {
                try {
                    if (this.f4532b != null && !this.f4532b.m7526j()) {
                        this.f4532b.m7525i();
                        this.f4534d.recordImpression();
                    } else if (!(this.f4533c == null || this.f4533c.m7557h())) {
                        this.f4533c.m7556g();
                        this.f4534d.recordImpression();
                    }
                } catch (Throwable e) {
                    sg.m8447c("Failed to call recordImpression", e);
                }
            }
        }
    }

    public void m6958a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.f4537g) {
            this.f4536f = true;
            try {
                if (this.f4532b != null) {
                    this.f4532b.m7517b(C1111d.m3896a((Object) view));
                } else if (this.f4533c != null) {
                    this.f4533c.m7550b(C1111d.m3896a((Object) view));
                }
            } catch (Throwable e) {
                sg.m8447c("Failed to call prepareAd", e);
            }
            this.f4536f = false;
        }
    }

    public void m6959a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        C1314c.m4631b("performClick must be called on the main UI thread.");
        synchronized (this.f4537g) {
            if (this.f4535e != null) {
                this.f4535e.m6921a(view, map, jSONObject, view2);
                this.f4534d.onAdClicked();
            } else {
                try {
                    if (!(this.f4532b == null || this.f4532b.m7527k())) {
                        this.f4532b.m7515a(C1111d.m3896a((Object) view));
                        this.f4534d.onAdClicked();
                    }
                    if (!(this.f4533c == null || this.f4533c.m7558i())) {
                        this.f4533c.m7548a(C1111d.m3896a((Object) view));
                        this.f4534d.onAdClicked();
                    }
                } catch (Throwable e) {
                    sg.m8447c("Failed to call performClick", e);
                }
            }
        }
    }

    public void m6960a(jd jdVar) {
        synchronized (this.f4537g) {
            this.f4535e = jdVar;
        }
    }

    public boolean m6961a() {
        boolean z;
        synchronized (this.f4537g) {
            z = this.f4536f;
        }
        return z;
    }

    public jd m6962b() {
        jd jdVar;
        synchronized (this.f4537g) {
            jdVar = this.f4535e;
        }
        return jdVar;
    }

    public void m6963b(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f4537g) {
            try {
                if (this.f4532b != null) {
                    this.f4532b.m7519c(C1111d.m3896a((Object) view));
                } else if (this.f4533c != null) {
                    this.f4533c.m7552c(C1111d.m3896a((Object) view));
                }
            } catch (Throwable e) {
                sg.m8447c("Failed to call untrackView", e);
            }
        }
    }

    public sx m6964c() {
        return null;
    }
}
