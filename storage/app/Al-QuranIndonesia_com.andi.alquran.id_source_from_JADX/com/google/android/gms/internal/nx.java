package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.sy.C1137a;

@op
public class nx implements Runnable {
    protected final sx f5127a;
    protected boolean f5128b;
    protected boolean f5129c;
    private final Handler f5130d;
    private final long f5131e;
    private long f5132f;
    private C1137a f5133g;
    private final int f5134h;
    private final int f5135i;

    /* renamed from: com.google.android.gms.internal.nx.a */
    protected final class C1844a extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ nx f5124a;
        private final WebView f5125b;
        private Bitmap f5126c;

        public C1844a(nx nxVar, WebView webView) {
            this.f5124a = nxVar;
            this.f5125b = webView;
        }

        protected synchronized Boolean m7795a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f5126c.getWidth();
            int height = this.f5126c.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f5126c.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m7796a(Boolean bool) {
            nx.m7799c(this.f5124a);
            if (bool.booleanValue() || this.f5124a.m7808c() || this.f5124a.f5132f <= 0) {
                this.f5124a.f5129c = bool.booleanValue();
                this.f5124a.f5133g.m3967a(this.f5124a.f5127a, true);
            } else if (this.f5124a.f5132f > 0) {
                if (sg.m8443a(2)) {
                    sg.m8444b("Ad not detected, scheduling another run.");
                }
                this.f5124a.f5130d.postDelayed(this.f5124a, this.f5124a.f5131e);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7795a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7796a((Boolean) obj);
        }

        protected synchronized void onPreExecute() {
            this.f5126c = Bitmap.createBitmap(this.f5124a.f5135i, this.f5124a.f5134h, Config.ARGB_8888);
            this.f5125b.setVisibility(0);
            this.f5125b.measure(MeasureSpec.makeMeasureSpec(this.f5124a.f5135i, 0), MeasureSpec.makeMeasureSpec(this.f5124a.f5134h, 0));
            this.f5125b.layout(0, 0, this.f5124a.f5135i, this.f5124a.f5134h);
            this.f5125b.draw(new Canvas(this.f5126c));
            this.f5125b.invalidate();
        }
    }

    public nx(C1137a c1137a, sx sxVar, int i, int i2) {
        this(c1137a, sxVar, i, i2, 200, 50);
    }

    public nx(C1137a c1137a, sx sxVar, int i, int i2, long j, long j2) {
        this.f5131e = j;
        this.f5132f = j2;
        this.f5130d = new Handler(Looper.getMainLooper());
        this.f5127a = sxVar;
        this.f5133g = c1137a;
        this.f5128b = false;
        this.f5129c = false;
        this.f5134h = i2;
        this.f5135i = i;
    }

    static /* synthetic */ long m7799c(nx nxVar) {
        long j = nxVar.f5132f - 1;
        nxVar.f5132f = j;
        return j;
    }

    public void m7804a() {
        this.f5130d.postDelayed(this, this.f5131e);
    }

    public void m7805a(zzmk com_google_android_gms_internal_zzmk) {
        m7806a(com_google_android_gms_internal_zzmk, new tj(this, this.f5127a, com_google_android_gms_internal_zzmk.f6598q));
    }

    public void m7806a(zzmk com_google_android_gms_internal_zzmk, tj tjVar) {
        this.f5127a.setWebViewClient(tjVar);
        this.f5127a.loadDataWithBaseURL(TextUtils.isEmpty(com_google_android_gms_internal_zzmk.f6583b) ? null : zzv.zzcJ().m8501a(com_google_android_gms_internal_zzmk.f6583b), com_google_android_gms_internal_zzmk.f6584c, "text/html", "UTF-8", null);
    }

    public synchronized void m7807b() {
        this.f5128b = true;
    }

    public synchronized boolean m7808c() {
        return this.f5128b;
    }

    public boolean m7809d() {
        return this.f5129c;
    }

    public void run() {
        if (this.f5127a == null || m7808c()) {
            this.f5133g.m3967a(this.f5127a, true);
        } else {
            new C1844a(this, this.f5127a.m8747a()).execute(new Void[0]);
        }
    }
}
