package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1322h;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rm;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import java.util.HashMap;
import java.util.Map;

@op
public class zzl extends FrameLayout implements zzi {
    private final sx f2438a;
    private final FrameLayout f2439b;
    private final io f2440c;
    private final C1124a f2441d;
    private final long f2442e;
    private zzj f2443f;
    private boolean f2444g;
    private boolean f2445h;
    private boolean f2446i;
    private boolean f2447j;
    private long f2448k;
    private long f2449l;
    private String f2450m;
    private Bitmap f2451n;
    private ImageView f2452o;
    private boolean f2453p;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzl.1 */
    class C11451 implements Runnable {
        final /* synthetic */ zzl f2436a;

        C11451(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.f2436a = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.f2436a.m3982a("surfaceCreated", new String[0]);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzl.2 */
    class C11462 implements Runnable {
        final /* synthetic */ zzl f2437a;

        C11462(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.f2437a = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.f2437a.m3982a("surfaceDestroyed", new String[0]);
        }
    }

    public zzl(Context context, sx sxVar, int i, boolean z, io ioVar) {
        super(context);
        this.f2438a = sxVar;
        this.f2440c = ioVar;
        this.f2439b = new FrameLayout(context);
        addView(this.f2439b, new LayoutParams(-1, -1));
        C1322h.m4701a(sxVar.m8772h());
        this.f2443f = sxVar.m8772h().zzsN.zza(context, sxVar, i, z, ioVar);
        if (this.f2443f != null) {
            this.f2439b.addView(this.f2443f, new LayoutParams(-1, -1, 17));
            if (((Boolean) C1648if.f4338B.m6682c()).booleanValue()) {
                zzhG();
            }
        }
        this.f2452o = new ImageView(context);
        this.f2442e = ((Long) C1648if.f4342F.m6682c()).longValue();
        this.f2447j = ((Boolean) C1648if.f4340D.m6682c()).booleanValue();
        if (this.f2440c != null) {
            this.f2440c.m6744a("spinner_used", this.f2447j ? "1" : "0");
        }
        this.f2441d = new C1124a(this);
        this.f2441d.m3947b();
        if (this.f2443f != null) {
            this.f2443f.zza(this);
        }
        if (this.f2443f == null) {
            zzk("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void m3980a(int i, int i2) {
        if (this.f2447j) {
            int max = Math.max(i / ((Integer) C1648if.f4341E.m6682c()).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) C1648if.f4341E.m6682c()).intValue(), 1);
            if (this.f2451n == null || this.f2451n.getWidth() != max || this.f2451n.getHeight() != max2) {
                this.f2451n = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.f2453p = false;
            }
        }
    }

    private void m3982a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.f2438a.m8757a("onVideoEvent", hashMap);
    }

    @TargetApi(14)
    private void m3983b() {
        if (this.f2451n != null) {
            long b = zzv.zzcP().m4927b();
            if (this.f2443f.getBitmap(this.f2451n) != null) {
                this.f2453p = true;
            }
            b = zzv.zzcP().m4927b() - b;
            if (rm.m8452b()) {
                rm.m8450a("Spinner frame grab took " + b + "ms");
            }
            if (b > this.f2442e) {
                sg.m8449e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f2447j = false;
                this.f2451n = null;
                if (this.f2440c != null) {
                    this.f2440c.m6744a("spinner_jank", Long.toString(b));
                }
            }
        }
    }

    private void m3984c() {
        if (this.f2453p && this.f2451n != null && !m3986e()) {
            this.f2452o.setImageBitmap(this.f2451n);
            this.f2452o.invalidate();
            this.f2439b.addView(this.f2452o, new LayoutParams(-1, -1));
            this.f2439b.bringChildToFront(this.f2452o);
        }
    }

    private void m3985d() {
        if (m3986e()) {
            this.f2439b.removeView(this.f2452o);
        }
    }

    private boolean m3986e() {
        return this.f2452o.getParent() != null;
    }

    private void m3987f() {
        if (this.f2438a.m8770f() != null && !this.f2445h) {
            this.f2446i = (this.f2438a.m8770f().getWindow().getAttributes().flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
            if (!this.f2446i) {
                this.f2438a.m8770f().getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
                this.f2445h = true;
            }
        }
    }

    private void m3988g() {
        if (this.f2438a.m8770f() != null && this.f2445h && !this.f2446i) {
            this.f2438a.m8770f().getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            this.f2445h = false;
        }
    }

    public static void zzi(sx sxVar) {
        Map hashMap = new HashMap();
        hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "no_video_view");
        sxVar.m8757a("onVideoEvent", hashMap);
    }

    void m3989a() {
        if (this.f2443f != null) {
            long currentPosition = (long) this.f2443f.getCurrentPosition();
            if (this.f2448k != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                m3982a("timeupdate", "time", String.valueOf(f));
                this.f2448k = currentPosition;
            }
        }
    }

    public void destroy() {
        this.f2441d.m3946a();
        if (this.f2443f != null) {
            this.f2443f.stop();
        }
        m3988g();
    }

    public void onPaused() {
        m3982a("pause", new String[0]);
        m3988g();
        this.f2444g = false;
    }

    public void pause() {
        if (this.f2443f != null) {
            this.f2443f.pause();
        }
    }

    public void play() {
        if (this.f2443f != null) {
            this.f2443f.play();
        }
    }

    public void seekTo(int i) {
        if (this.f2443f != null) {
            this.f2443f.seekTo(i);
        }
    }

    public void zza(float f, float f2) {
        if (this.f2443f != null) {
            this.f2443f.zza(f, f2);
        }
    }

    public void zzaB(String str) {
        this.f2450m = str;
    }

    public void zzb(float f) {
        if (this.f2443f != null) {
            this.f2443f.zzb(f);
        }
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f2439b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void zzf(int i, int i2) {
        m3980a(i, i2);
    }

    @TargetApi(14)
    public void zzf(MotionEvent motionEvent) {
        if (this.f2443f != null) {
            this.f2443f.dispatchTouchEvent(motionEvent);
        }
    }

    public void zzgq() {
        if (this.f2443f != null) {
            if (TextUtils.isEmpty(this.f2450m)) {
                m3982a("no_src", new String[0]);
            } else {
                this.f2443f.setVideoPath(this.f2450m);
            }
        }
    }

    public void zzhA() {
        m3987f();
        this.f2444g = true;
    }

    public void zzhB() {
        m3982a("ended", new String[0]);
        m3988g();
    }

    public void zzhC() {
        m3984c();
        this.f2449l = this.f2448k;
        rq.f5755a.post(new C11462(this));
    }

    public void zzhD() {
        if (this.f2444g) {
            m3985d();
        }
        m3983b();
    }

    public void zzhE() {
        if (this.f2443f != null) {
            this.f2443f.zzhE();
        }
    }

    public void zzhF() {
        if (this.f2443f != null) {
            this.f2443f.zzhF();
        }
    }

    @TargetApi(14)
    public void zzhG() {
        if (this.f2443f != null) {
            View textView = new TextView(this.f2443f.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f2443f.zzhd());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f2439b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f2439b.bringChildToFront(textView);
        }
    }

    public void zzhy() {
        rq.f5755a.post(new C11451(this));
    }

    public void zzhz() {
        if (this.f2443f != null && this.f2449l == 0) {
            float duration = ((float) this.f2443f.getDuration()) / 1000.0f;
            int videoWidth = this.f2443f.getVideoWidth();
            int videoHeight = this.f2443f.getVideoHeight();
            m3982a("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void zzk(String str, String str2) {
        m3982a("error", "what", str, "extra", str2);
    }
}
