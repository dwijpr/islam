package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sy.C1137a;
import com.google.android.gms.internal.sy.C1866b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@op
public class oi {
    private final Object f5237a;
    private final Context f5238b;
    private final cg f5239c;
    private final C1938a f5240d;
    private final io f5241e;
    private final zzr f5242f;
    private OnGlobalLayoutListener f5243g;
    private OnScrollChangedListener f5244h;
    private sb f5245i;
    private int f5246j;
    private int f5247k;

    /* renamed from: com.google.android.gms.internal.oi.1 */
    class C18691 implements Runnable {
        final /* synthetic */ JSONObject f5229a;
        final /* synthetic */ sk f5230b;
        final /* synthetic */ oi f5231c;

        /* renamed from: com.google.android.gms.internal.oi.1.1 */
        class C18671 implements C1866b {
            final /* synthetic */ sx f5226a;
            final /* synthetic */ C18691 f5227b;

            C18671(C18691 c18691, sx sxVar) {
                this.f5227b = c18691;
                this.f5226a = sxVar;
            }

            public void m7897a(sx sxVar) {
                this.f5226a.m8758a("google.afma.nativeAds.renderVideo", this.f5227b.f5229a);
            }
        }

        /* renamed from: com.google.android.gms.internal.oi.1.2 */
        class C18682 implements C1137a {
            final /* synthetic */ C18691 f5228a;

            C18682(C18691 c18691) {
                this.f5228a = c18691;
            }

            public void m7898a(sx sxVar, boolean z) {
                this.f5228a.f5231c.f5242f.zzcu();
                this.f5228a.f5230b.m7304b((Object) sxVar);
            }
        }

        C18691(oi oiVar, JSONObject jSONObject, sk skVar) {
            this.f5231c = oiVar;
            this.f5229a = jSONObject;
            this.f5230b = skVar;
        }

        public void run() {
            try {
                sx a = this.f5231c.m7911a();
                this.f5231c.f5242f.zzc(a);
                WeakReference weakReference = new WeakReference(a);
                a.m8776l().m8801a(this.f5231c.m7901a(weakReference), this.f5231c.m7908b(weakReference));
                this.f5231c.m7905a(a);
                a.m8776l().m8807a(new C18671(this, a));
                a.m8776l().m8806a(new C18682(this));
                a.loadUrl(og.m7843a(this.f5231c.f5240d, (String) C1648if.cc.m6682c()));
            } catch (Throwable e) {
                sg.m8447c("Exception occurred while getting video view", e);
                this.f5230b.m7304b(null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.oi.2 */
    class C18702 implements kg {
        final /* synthetic */ oi f5232a;

        C18702(oi oiVar) {
            this.f5232a = oiVar;
        }

        public void m7899a(sx sxVar, Map<String, String> map) {
            this.f5232a.f5242f.zzcr();
        }
    }

    /* renamed from: com.google.android.gms.internal.oi.3 */
    class C18713 implements OnGlobalLayoutListener {
        final /* synthetic */ WeakReference f5233a;
        final /* synthetic */ oi f5234b;

        C18713(oi oiVar, WeakReference weakReference) {
            this.f5234b = oiVar;
            this.f5233a = weakReference;
        }

        public void onGlobalLayout() {
            this.f5234b.m7906a(this.f5233a, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.oi.4 */
    class C18724 implements OnScrollChangedListener {
        final /* synthetic */ WeakReference f5235a;
        final /* synthetic */ oi f5236b;

        C18724(oi oiVar, WeakReference weakReference) {
            this.f5236b = oiVar;
            this.f5235a = weakReference;
        }

        public void onScrollChanged() {
            this.f5236b.m7906a(this.f5235a, true);
        }
    }

    public oi(Context context, cg cgVar, C1938a c1938a, io ioVar, zzr com_google_android_gms_ads_internal_zzr) {
        this.f5237a = new Object();
        this.f5246j = -1;
        this.f5247k = -1;
        this.f5238b = context;
        this.f5239c = cgVar;
        this.f5240d = c1938a;
        this.f5241e = ioVar;
        this.f5242f = com_google_android_gms_ads_internal_zzr;
        this.f5245i = new sb(200);
    }

    private OnGlobalLayoutListener m7901a(WeakReference<sx> weakReference) {
        if (this.f5243g == null) {
            this.f5243g = new C18713(this, weakReference);
        }
        return this.f5243g;
    }

    private void m7905a(sx sxVar) {
        sy l = sxVar.m8776l();
        l.m8810a("/video", kf.f4604n);
        l.m8810a("/videoMeta", kf.f4605o);
        l.m8810a("/precache", kf.f4606p);
        l.m8810a("/delayPageLoaded", kf.f4609s);
        l.m8810a("/instrument", kf.f4607q);
        l.m8810a("/log", kf.f4599i);
        l.m8810a("/videoClicked", kf.f4600j);
        l.m8810a("/trackActiveViewUnit", new C18702(this));
    }

    private void m7906a(WeakReference<sx> weakReference, boolean z) {
        if (weakReference != null) {
            sx sxVar = (sx) weakReference.get();
            if (sxVar != null && sxVar.m8760b() != null) {
                if (!z || this.f5245i.m8677a()) {
                    int[] iArr = new int[2];
                    sxVar.m8760b().getLocationOnScreen(iArr);
                    int b = gr.m6416a().m8702b(this.f5238b, iArr[0]);
                    int b2 = gr.m6416a().m8702b(this.f5238b, iArr[1]);
                    synchronized (this.f5237a) {
                        if (!(this.f5246j == b && this.f5247k == b2)) {
                            this.f5246j = b;
                            this.f5247k = b2;
                            sxVar.m8776l().m8799a(this.f5246j, this.f5247k, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener m7908b(WeakReference<sx> weakReference) {
        if (this.f5244h == null) {
            this.f5244h = new C18724(this, weakReference);
        }
        return this.f5244h;
    }

    public sn<sx> m7910a(JSONObject jSONObject) {
        sn skVar = new sk();
        zzv.zzcJ().m8518a(new C18691(this, jSONObject, skVar));
        return skVar;
    }

    sx m7911a() {
        return zzv.zzcK().m8831a(this.f5238b, zzec.m9769a(this.f5238b), false, false, this.f5239c, this.f5240d.f5594a.f6550k, this.f5241e, null, this.f5242f.zzbz());
    }
}
