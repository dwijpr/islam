package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1385k;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.iu.C1657a;
import com.google.android.gms.internal.sf.C1961a;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class rq {
    public static final Handler f5755a;
    private final Object f5756b;
    private boolean f5757c;
    private String f5758d;
    private boolean f5759e;
    private ll f5760f;

    /* renamed from: com.google.android.gms.internal.rq.1 */
    class C19591 implements C1657a {
        final /* synthetic */ List f5747a;
        final /* synthetic */ iu f5748b;
        final /* synthetic */ Context f5749c;

        C19591(rq rqVar, List list, iu iuVar, Context context) {
            this.f5747a = list;
            this.f5748b = iuVar;
            this.f5749c = context;
        }
    }

    /* renamed from: com.google.android.gms.internal.rq.2 */
    class C19602 implements Runnable {
        final /* synthetic */ Context f5750a;
        final /* synthetic */ rq f5751b;

        C19602(rq rqVar, Context context) {
            this.f5751b = rqVar;
            this.f5750a = context;
        }

        public void run() {
            synchronized (this.f5751b.f5756b) {
                this.f5751b.f5758d = this.f5751b.m8539c(this.f5750a);
                this.f5751b.f5756b.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.rq.3 */
    class C19623 implements C1961a {
        final /* synthetic */ Context f5752a;
        final /* synthetic */ String f5753b;

        C19623(rq rqVar, Context context, String str) {
            this.f5752a = context;
            this.f5753b = str;
        }

        public void m8477a(String str) {
            zzv.zzcJ().m8512a(this.f5752a, this.f5753b, str);
        }
    }

    /* renamed from: com.google.android.gms.internal.rq.a */
    private final class C1963a extends BroadcastReceiver {
        final /* synthetic */ rq f5754a;

        private C1963a(rq rqVar) {
            this.f5754a = rqVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.f5754a.f5757c = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f5754a.f5757c = false;
            }
        }
    }

    static {
        f5755a = new rn(Looper.getMainLooper());
    }

    public rq() {
        this.f5756b = new Object();
        this.f5757c = true;
        this.f5759e = false;
    }

    private JSONArray m8480a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m8482a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject m8481a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m8483a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private void m8482a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m8481a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m8506a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m8480a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m8505a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void m8483a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m8481a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m8506a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m8480a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m8480a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private boolean m8484a(KeyguardManager keyguardManager) {
        return keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean m8485a(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    public static void m8487b(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            rp.m8472a(runnable);
        }
    }

    private Bitmap m8488c(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                sg.m8449e("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            sg.m8445b("Fail to capture the webview", e);
            return null;
        }
    }

    private Bitmap m8489d(View view) {
        Bitmap drawingCache;
        Throwable e;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            drawingCache = view.getDrawingCache();
            drawingCache = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                sg.m8445b("Fail to capture the web view", e);
                return drawingCache;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            drawingCache = null;
            e = th;
            sg.m8445b("Fail to capture the web view", e);
            return drawingCache;
        }
        return drawingCache;
    }

    private boolean m8490n(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    public Bitmap m8491a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public Bundle m8492a(fo foVar) {
        if (foVar == null) {
            return null;
        }
        if (!((Boolean) C1648if.ae.m6682c()).booleanValue() && !((Boolean) C1648if.ag.m6682c()).booleanValue()) {
            return null;
        }
        if (zzv.zzcN().m8405b() && zzv.zzcN().m8407c()) {
            return null;
        }
        String b;
        String c;
        String str;
        if (foVar.m6217f()) {
            foVar.m6215d();
        }
        fk c2 = foVar.m6214c();
        if (c2 != null) {
            b = c2.m6167b();
            c = c2.m6169c();
            String d = c2.m6170d();
            if (b != null) {
                zzv.zzcN().m8393a(b);
            }
            if (d != null) {
                zzv.zzcN().m8403b(d);
                str = b;
                b = c;
                c = d;
            } else {
                str = b;
                b = c;
                c = d;
            }
        } else {
            b = null;
            str = zzv.zzcN().m8416j();
            c = zzv.zzcN().m8417k();
        }
        Bundle bundle = new Bundle(1);
        if (!(c == null || !((Boolean) C1648if.ag.m6682c()).booleanValue() || zzv.zzcN().m8407c())) {
            bundle.putString("v_fp_vertical", c);
        }
        if (!(str == null || !((Boolean) C1648if.ae.m6682c()).booleanValue() || zzv.zzcN().m8405b())) {
            bundle.putString("fingerprint", str);
            if (!str.equals(b)) {
                bundle.putString("v_fp", b);
            }
        }
        return !bundle.isEmpty() ? bundle : null;
    }

    public DisplayMetrics m8493a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow m8494a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public ll m8495a(Context context, zzqa com_google_android_gms_internal_zzqa) {
        ll llVar;
        synchronized (this.f5756b) {
            if (this.f5760f == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f5760f = new ll(context, com_google_android_gms_internal_zzqa, (String) C1648if.f4364b.m6682c());
            }
            llVar = this.f5760f;
        }
        return llVar;
    }

    public String m8496a(Context context, View view, zzec com_google_android_gms_internal_zzec) {
        String str = null;
        if (((Boolean) C1648if.av.m6682c()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", com_google_android_gms_internal_zzec.f6456f);
                jSONObject2.put("height", com_google_android_gms_internal_zzec.f6453c);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", m8547f(context));
                if (!com_google_android_gms_internal_zzec.f6455e) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                sg.m8447c("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String m8497a(Context context, cg cgVar, String str, View view) {
        if (cgVar != null) {
            try {
                Uri parse = Uri.parse(str);
                if (cgVar.m5539d(parse)) {
                    parse = cgVar.m5530a(parse, context, view);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m8498a(android.content.Context r6, java.lang.String r7) {
        /*
        r5 = this;
        r1 = r5.f5756b;
        monitor-enter(r1);
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        monitor-exit(r1);	 Catch:{ all -> 0x0013 }
    L_0x000a:
        return r0;
    L_0x000b:
        if (r7 != 0) goto L_0x0016;
    L_0x000d:
        r0 = r5.m8531b();	 Catch:{ all -> 0x0013 }
        monitor-exit(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x000a;
    L_0x0013:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = com.google.android.gms.ads.internal.zzv.zzcL();	 Catch:{ Exception -> 0x00b7 }
        r0 = r0.m8563a(r6);	 Catch:{ Exception -> 0x00b7 }
        r5.f5758d = r0;	 Catch:{ Exception -> 0x00b7 }
    L_0x0020:
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0072;
    L_0x0028:
        r0 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ all -> 0x0013 }
        r0 = r0.m8704b();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x006c;
    L_0x0032:
        r0 = 0;
        r5.f5758d = r0;	 Catch:{ all -> 0x0013 }
        r0 = f5755a;	 Catch:{ all -> 0x0013 }
        r2 = new com.google.android.gms.internal.rq$2;	 Catch:{ all -> 0x0013 }
        r2.<init>(r5, r6);	 Catch:{ all -> 0x0013 }
        r0.post(r2);	 Catch:{ all -> 0x0013 }
    L_0x003f:
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0072;
    L_0x0043:
        r0 = r5.f5756b;	 Catch:{ InterruptedException -> 0x0049 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0049 }
        goto L_0x003f;
    L_0x0049:
        r0 = move-exception;
        r0 = r5.m8531b();	 Catch:{ all -> 0x0013 }
        r5.f5758d = r0;	 Catch:{ all -> 0x0013 }
        r2 = "Interrupted, use default user agent: ";
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0013 }
        r3 = r0.length();	 Catch:{ all -> 0x0013 }
        if (r3 == 0) goto L_0x0066;
    L_0x005e:
        r0 = r2.concat(r0);	 Catch:{ all -> 0x0013 }
    L_0x0062:
        com.google.android.gms.internal.sg.m8449e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x003f;
    L_0x0066:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0013 }
        r0.<init>(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0062;
    L_0x006c:
        r0 = r5.m8539c(r6);	 Catch:{ Exception -> 0x00af }
        r5.f5758d = r0;	 Catch:{ Exception -> 0x00af }
    L_0x0072:
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0013 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0013 }
        r3 = r3.length();	 Catch:{ all -> 0x0013 }
        r3 = r3 + 11;
        r4 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x0013 }
        r4 = r4.length();	 Catch:{ all -> 0x0013 }
        r3 = r3 + r4;
        r2.<init>(r3);	 Catch:{ all -> 0x0013 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0013 }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0013 }
        r0 = r0.append(r7);	 Catch:{ all -> 0x0013 }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0013 }
        r0 = r0.toString();	 Catch:{ all -> 0x0013 }
        r5.f5758d = r0;	 Catch:{ all -> 0x0013 }
        r0 = r5.f5758d;	 Catch:{ all -> 0x0013 }
        monitor-exit(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x000a;
    L_0x00af:
        r0 = move-exception;
        r0 = r5.m8531b();	 Catch:{ all -> 0x0013 }
        r5.f5758d = r0;	 Catch:{ all -> 0x0013 }
        goto L_0x0072;
    L_0x00b7:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.rq.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public String m8499a(sx sxVar, String str) {
        return m8497a(sxVar.getContext(), sxVar.m8778n(), str, sxVar.m8760b());
    }

    public String m8500a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(FragmentTransaction.TRANSIT_EXIT_MASK);
        char[] cArr = new char[ItemAnimator.FLAG_MOVED];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public String m8501a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public String m8502a(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{Uri.encode((String) map.get(str2))}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{BuildConfig.VERSION_NAME})).replaceAll("@@", "@");
    }

    public Map<String, String> m8503a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzv.zzcL().m8565a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public Map<String, Integer> m8504a(View view, WindowManager windowManager) {
        DisplayMetrics a = m8493a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        Map<String, Integer> hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        return hashMap;
    }

    JSONArray m8505a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m8482a(jSONArray, a);
        }
        return jSONArray;
    }

    public JSONObject m8506a(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                m8483a(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public void m8507a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void m8508a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m8509a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @TargetApi(18)
    public void m8510a(Context context, Uri uri) {
        try {
            Bundle bundle = new Bundle();
            if (((Boolean) C1648if.cZ.m6682c()).booleanValue() && C1387m.m4964f()) {
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(new Intent("android.intent.action.VIEW", uri).putExtras(bundle));
            String valueOf = String.valueOf(uri.toString());
            sg.m8444b(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Opening ").append(valueOf).append(" in a new browser.").toString());
        } catch (Throwable e) {
            sg.m8445b("No browser is found.", e);
        }
    }

    public void m8511a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m8498a(context, str));
    }

    public void m8512a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m8514a(context, str, arrayList);
    }

    public void m8513a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", zzv.zzcJ().m8546e());
            bundle.putString("eids", TextUtils.join(",", C1648if.m6703a()));
        }
        gr.m6416a().m8697a(context, str, str2, bundle, z, new C19623(this, context, str));
    }

    public void m8514a(Context context, String str, List<String> list) {
        for (String saVar : list) {
            new sa(context, str, saVar).zziw();
        }
    }

    public void m8515a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m8516a(context, str, z, httpURLConnection, false);
    }

    public void m8516a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m8498a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public void m8517a(Context context, List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(el.m5967a((Activity) context))) {
            return;
        }
        if (list == null) {
            rm.m8450a("Cannot ping urls: empty list.");
        } else if (iu.m6771a(context)) {
            iu iuVar = new iu();
            iuVar.m6774a(new C19591(this, list, iuVar, context));
            iuVar.m6775b((Activity) context);
        } else {
            rm.m8450a("Cannot ping url because custom tabs is not supported");
        }
    }

    public void m8518a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f5755a.post(runnable);
        }
    }

    public void m8519a(List<String> list, String str) {
        for (String saVar : list) {
            new sa(saVar, str).zziw();
        }
    }

    public boolean m8520a() {
        return this.f5757c;
    }

    boolean m8521a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @TargetApi(24)
    public boolean m8522a(Activity activity, Configuration configuration) {
        sf a = gr.m6416a();
        int a2 = a.m8690a((Context) activity, configuration.screenHeightDp);
        int a3 = a.m8690a((Context) activity, configuration.screenWidthDp);
        DisplayMetrics a4 = m8493a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = a4.heightPixels;
        int i2 = a4.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        identifier = ((Integer) C1648if.dh.m6682c()).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return m8521a(i, dimensionPixelSize + a2, identifier) && m8521a(i2, a3, identifier);
    }

    public boolean m8523a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            sg.m8449e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            sg.m8449e(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            sg.m8449e(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
            sg.m8449e(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_LOCAL_ONLY) == 0) {
            sg.m8449e(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            sg.m8449e(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            sg.m8449e(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & ItemAnimator.FLAG_MOVED) != 0) {
            return z;
        }
        sg.m8449e(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean m8524a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean m8525a(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return m8526a(view, powerManager, keyguardManager);
    }

    public boolean m8526a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = zzv.zzcJ().m8520a() || !m8484a(keyguardManager);
        return view.getVisibility() == 0 && view.isShown() && m8485a(powerManager) && z && (!((Boolean) C1648if.aW.m6682c()).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()));
    }

    public boolean m8527a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public int[] m8528a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m8548f();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public int m8529b(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public int m8530b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            sg.m8449e(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    String m8531b() {
        StringBuffer stringBuffer = new StringBuffer(NotificationCompat.FLAG_LOCAL_ONLY);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String m8532b(Context context, String str) {
        try {
            return new String(C1385k.m4957a(context.openFileInput(str), true), "UTF-8");
        } catch (Throwable e) {
            sg.m8445b("Error reading from internal storage.", e);
            return BuildConfig.VERSION_NAME;
        }
    }

    public void m8533b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m8534b(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Throwable e) {
            sg.m8445b("Error writing to file in internal storage.", e);
        }
    }

    public void m8535b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) C1648if.bb.m6682c()).booleanValue()) {
            m8513a(context, str, str2, bundle, z);
        }
    }

    public boolean m8536b(Context context) {
        if (this.f5759e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C1963a(), intentFilter);
        this.f5759e = true;
        return true;
    }

    public int[] m8537b(Activity activity) {
        int[] a = m8528a(activity);
        return new int[]{gr.m6416a().m8702b((Context) activity, a[0]), gr.m6416a().m8702b((Context) activity, a[1])};
    }

    public String m8538c() {
        return UUID.randomUUID().toString();
    }

    protected String m8539c(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public boolean m8540c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] m8541c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m8548f();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public Builder m8542d(Context context) {
        return new Builder(context);
    }

    public String m8543d() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public int[] m8544d(Activity activity) {
        int[] c = m8541c(activity);
        return new int[]{gr.m6416a().m8702b((Context) activity, c[0]), gr.m6416a().m8702b((Context) activity, c[1])};
    }

    public hx m8545e(Context context) {
        return new hx(context);
    }

    public String m8546e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    public String m8547f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    protected int[] m8548f() {
        return new int[]{0, 0};
    }

    public float m8549g() {
        zzp zzcn = zzv.zzdd().zzcn();
        return (zzcn == null || !zzcn.zzcp()) ? 1.0f : zzcn.zzco();
    }

    public boolean m8550g(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && m8490n(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap m8551h(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bitmap d;
        try {
            if (((Boolean) C1648if.bU.m6682c()).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    d = m8489d(window.getDecorView().getRootView());
                }
                d = null;
            } else {
                d = m8488c(((Activity) context).getWindow().getDecorView());
            }
        } catch (Throwable e) {
            sg.m8445b("Fail to capture screen shot", e);
        }
        return d;
    }

    public boolean m8552h() {
        zzp zzcn = zzv.zzdd().zzcn();
        return zzcn != null ? zzcn.zzcq() : false;
    }

    public AudioManager m8553i(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public Bundle m8554i() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) C1648if.f4343G.m6682c()).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) C1648if.f4344H.m6682c()).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
        } catch (Throwable e) {
            sg.m8447c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public float m8555j(Context context) {
        AudioManager i = m8553i(context);
        if (i == null) {
            return 0.0f;
        }
        int streamMaxVolume = i.getStreamMaxVolume(3);
        return streamMaxVolume != 0 ? ((float) i.getStreamVolume(3)) / ((float) streamMaxVolume) : 0.0f;
    }

    public int m8556k(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    public boolean m8557l(Context context) {
        try {
            context.getClassLoader().loadClass(ClientApi.class.getName());
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }

    public Bundle m8558m(Context context) {
        fo a = zzv.zzcN().m8387a(context);
        return a == null ? null : m8492a(a);
    }
}
