package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzv;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@TargetApi(8)
@op
public class rr {

    @TargetApi(9)
    /* renamed from: com.google.android.gms.internal.rr.a */
    public static class C1965a extends rr {
        public C1965a() {
            super();
        }

        public int m8582a() {
            return 6;
        }

        public boolean m8583a(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int m8584b() {
            return 7;
        }
    }

    @TargetApi(11)
    /* renamed from: com.google.android.gms.internal.rr.b */
    public static class C1967b extends C1965a {

        /* renamed from: com.google.android.gms.internal.rr.b.1 */
        class C19661 implements Callable<Boolean> {
            final /* synthetic */ Context f5761a;
            final /* synthetic */ WebSettings f5762b;

            C19661(C1967b c1967b, Context context, WebSettings webSettings) {
                this.f5761a = context;
                this.f5762b = webSettings;
            }

            public Boolean m8585a() {
                if (this.f5761a.getCacheDir() != null) {
                    this.f5762b.setAppCachePath(this.f5761a.getCacheDir().getAbsolutePath());
                    this.f5762b.setAppCacheMaxSize(0);
                    this.f5762b.setAppCacheEnabled(true);
                }
                this.f5762b.setDatabasePath(this.f5761a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                this.f5762b.setDatabaseEnabled(true);
                this.f5762b.setDomStorageEnabled(true);
                this.f5762b.setDisplayZoomControls(false);
                this.f5762b.setBuiltInZoomControls(true);
                this.f5762b.setSupportZoom(true);
                this.f5762b.setAllowContentAccess(false);
                return Boolean.valueOf(true);
            }

            public /* synthetic */ Object call() {
                return m8585a();
            }
        }

        public sy m8586a(sx sxVar, boolean z) {
            return new tf(sxVar, z);
        }

        public Set<String> m8587a(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean m8588a(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean m8589a(Context context, WebSettings webSettings) {
            super.m8570a(context, webSettings);
            return ((Boolean) sd.m8680a(new C19661(this, context, webSettings))).booleanValue();
        }

        public boolean m8590a(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        public boolean m8591b(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public WebChromeClient m8592c(sx sxVar) {
            return new te(sxVar);
        }

        public boolean m8593c(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    /* renamed from: com.google.android.gms.internal.rr.c */
    public static class C1968c extends C1967b {
        public String m8594a(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient m8595c(sx sxVar) {
            return new tg(sxVar);
        }
    }

    @TargetApi(16)
    /* renamed from: com.google.android.gms.internal.rr.f */
    public static class C1969f extends C1968c {
        public void m8596a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                m8598a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }

        public void m8597a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void m8598a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean m8599a(Context context, WebSettings webSettings) {
            super.m8589a(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }
    }

    @TargetApi(17)
    /* renamed from: com.google.android.gms.internal.rr.d */
    public static class C1970d extends C1969f {
        public Drawable m8600a(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public String m8601a(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public boolean m8602a(Context context, WebSettings webSettings) {
            super.m8599a(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    /* renamed from: com.google.android.gms.internal.rr.e */
    public static class C1971e extends C1970d {
        public boolean m8603a(View view) {
            return super.m8571a(view) || view.getWindowId() != null;
        }

        public int m8604c() {
            return 14;
        }
    }

    @TargetApi(19)
    /* renamed from: com.google.android.gms.internal.rr.g */
    public static class C1972g extends C1971e {
        public boolean m8605a(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams m8606d() {
            return new LayoutParams(-1, -1);
        }
    }

    @TargetApi(21)
    /* renamed from: com.google.android.gms.internal.rr.h */
    public static class C1973h extends C1972g {
        public sy m8607a(sx sxVar, boolean z) {
            return new tk(sxVar, z);
        }

        public CookieManager m8608b(Context context) {
            return CookieManager.getInstance();
        }
    }

    private rr() {
    }

    public static rr m8559a(int i) {
        return i >= 21 ? new C1973h() : i >= 19 ? new C1972g() : i >= 18 ? new C1971e() : i >= 17 ? new C1970d() : i >= 16 ? new C1969f() : i >= 14 ? new C1968c() : i >= 11 ? new C1967b() : i >= 9 ? new C1965a() : new rr();
    }

    public int m8560a() {
        return 0;
    }

    public Drawable m8561a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public sy m8562a(sx sxVar, boolean z) {
        return new sy(sxVar, z);
    }

    public String m8563a(Context context) {
        return BuildConfig.VERSION_NAME;
    }

    public String m8564a(SslError sslError) {
        return BuildConfig.VERSION_NAME;
    }

    public Set<String> m8565a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void m8566a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            m8568a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void m8567a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void m8568a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean m8569a(Request request) {
        return false;
    }

    public boolean m8570a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean m8571a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean m8572a(Window window) {
        return false;
    }

    public boolean m8573a(sx sxVar) {
        if (sxVar == null) {
            return false;
        }
        sxVar.onPause();
        return true;
    }

    public int m8574b() {
        return 1;
    }

    public CookieManager m8575b(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable e) {
            sg.m8445b("Failed to obtain CookieManager.", e);
            zzv.zzcN().m8399a(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public boolean m8576b(View view) {
        return false;
    }

    public boolean m8577b(sx sxVar) {
        if (sxVar == null) {
            return false;
        }
        sxVar.onResume();
        return true;
    }

    public int m8578c() {
        return 5;
    }

    public WebChromeClient m8579c(sx sxVar) {
        return null;
    }

    public boolean m8580c(View view) {
        return false;
    }

    public LayoutParams m8581d() {
        return new LayoutParams(-2, -2);
    }
}
