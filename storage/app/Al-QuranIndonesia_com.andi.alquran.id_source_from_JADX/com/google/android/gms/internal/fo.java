package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1387m;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@op
public class fo extends Thread {
    private boolean f4082a;
    private boolean f4083b;
    private boolean f4084c;
    private final Object f4085d;
    private final fl f4086e;
    private final oo f4087f;
    private final int f4088g;
    private final int f4089h;
    private final int f4090i;
    private final int f4091j;
    private final int f4092k;
    private final int f4093l;
    private final int f4094m;
    private final int f4095n;
    private final String f4096o;

    /* renamed from: com.google.android.gms.internal.fo.1 */
    class C15751 implements Runnable {
        final /* synthetic */ View f4072a;
        final /* synthetic */ fo f4073b;

        C15751(fo foVar, View view) {
            this.f4073b = foVar;
            this.f4072a = view;
        }

        public void run() {
            this.f4073b.m6212b(this.f4072a);
        }
    }

    /* renamed from: com.google.android.gms.internal.fo.2 */
    class C15772 implements Runnable {
        ValueCallback<String> f4075a;
        final /* synthetic */ fk f4076b;
        final /* synthetic */ WebView f4077c;
        final /* synthetic */ boolean f4078d;
        final /* synthetic */ fo f4079e;

        /* renamed from: com.google.android.gms.internal.fo.2.1 */
        class C15761 implements ValueCallback<String> {
            final /* synthetic */ C15772 f4074a;

            C15761(C15772 c15772) {
                this.f4074a = c15772;
            }

            public void m6203a(String str) {
                this.f4074a.f4079e.m6207a(this.f4074a.f4076b, this.f4074a.f4077c, str, this.f4074a.f4078d);
            }

            public /* synthetic */ void onReceiveValue(Object obj) {
                m6203a((String) obj);
            }
        }

        C15772(fo foVar, fk fkVar, WebView webView, boolean z) {
            this.f4079e = foVar;
            this.f4076b = fkVar;
            this.f4077c = webView;
            this.f4078d = z;
            this.f4075a = new C15761(this);
        }

        public void run() {
            if (this.f4077c.getSettings().getJavaScriptEnabled()) {
                try {
                    this.f4077c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f4075a);
                } catch (Throwable th) {
                    this.f4075a.onReceiveValue(BuildConfig.VERSION_NAME);
                }
            }
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.fo.a */
    class C1578a {
        final int f4080a;
        final int f4081b;

        C1578a(fo foVar, int i, int i2) {
            this.f4080a = i;
            this.f4081b = i2;
        }
    }

    public fo(fl flVar, oo ooVar) {
        this.f4082a = false;
        this.f4083b = false;
        this.f4084c = false;
        this.f4086e = flVar;
        this.f4087f = ooVar;
        this.f4085d = new Object();
        this.f4089h = ((Integer) C1648if.f4362Z.m6682c()).intValue();
        this.f4090i = ((Integer) C1648if.aa.m6682c()).intValue();
        this.f4091j = ((Integer) C1648if.ab.m6682c()).intValue();
        this.f4092k = ((Integer) C1648if.ac.m6682c()).intValue();
        this.f4093l = ((Integer) C1648if.af.m6682c()).intValue();
        this.f4094m = ((Integer) C1648if.ah.m6682c()).intValue();
        this.f4095n = ((Integer) C1648if.ai.m6682c()).intValue();
        this.f4088g = ((Integer) C1648if.ad.m6682c()).intValue();
        this.f4096o = (String) C1648if.ak.m6682c();
        setName("ContentFetchTask");
    }

    C1578a m6204a(View view, fk fkVar) {
        int i = 0;
        if (view == null) {
            return new C1578a(this, 0, 0);
        }
        Context b = zzv.zzcM().m6202b();
        if (b != null) {
            String str = (String) view.getTag(b.getResources().getIdentifier((String) C1648if.aj.m6682c(), "id", b.getPackageName()));
            if (!(TextUtils.isEmpty(this.f4096o) || str == null || !str.equals(this.f4096o))) {
                return new C1578a(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C1578a(this, 0, 0);
            }
            fkVar.m6168b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new C1578a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof sx)) {
            fkVar.m6173g();
            return m6211a((WebView) view, fkVar, globalVisibleRect) ? new C1578a(this, 0, 1) : new C1578a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C1578a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                C1578a a = m6204a(viewGroup.getChildAt(i3), fkVar);
                i2 += a.f4080a;
                i += a.f4081b;
            }
            return new C1578a(this, i2, i);
        }
    }

    public void m6205a() {
        synchronized (this.f4085d) {
            if (this.f4082a) {
                sg.m8444b("Content hash thread already started, quiting...");
                return;
            }
            this.f4082a = true;
            start();
        }
    }

    void m6206a(Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                sg.m8444b("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                m6210a(view);
            }
        }
    }

    void m6207a(fk fkVar, WebView webView, String str, boolean z) {
        fkVar.m6172f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    fkVar.m6165a(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    fkVar.m6165a(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (fkVar.m6166a()) {
                this.f4086e.m6179b(fkVar);
            }
        } catch (JSONException e) {
            sg.m8444b("Json string may be malformed.");
        } catch (Throwable th) {
            sg.m8442a("Failed to get webview content.", th);
            this.f4087f.m7922a(th, "ContentFetchTask.processWebViewContent");
        }
    }

    boolean m6208a(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean m6209a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean m6210a(View view) {
        if (view == null) {
            return false;
        }
        view.post(new C15751(this, view));
        return true;
    }

    @TargetApi(19)
    boolean m6211a(WebView webView, fk fkVar, boolean z) {
        if (!C1387m.m4965g()) {
            return false;
        }
        fkVar.m6173g();
        webView.post(new C15772(this, fkVar, webView, z));
        return true;
    }

    void m6212b(View view) {
        try {
            fk fkVar = new fk(this.f4089h, this.f4090i, this.f4091j, this.f4092k, this.f4093l, this.f4094m, this.f4095n);
            C1578a a = m6204a(view, fkVar);
            fkVar.m6174h();
            if (a.f4080a != 0 || a.f4081b != 0) {
                if (a.f4081b != 0 || fkVar.m6176j() != 0) {
                    if (a.f4081b != 0 || !this.f4086e.m6178a(fkVar)) {
                        this.f4086e.m6180c(fkVar);
                    }
                }
            }
        } catch (Throwable e) {
            sg.m8445b("Exception in fetchContentOnUIThread", e);
            this.f4087f.m7922a(e, "ContentFetchTask.fetchContent");
        }
    }

    boolean m6213b() {
        try {
            Context b = zzv.zzcM().m6202b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (m6208a(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && m6209a(b)) {
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

    public fk m6214c() {
        return this.f4086e.m6177a();
    }

    public void m6215d() {
        synchronized (this.f4085d) {
            this.f4083b = false;
            this.f4085d.notifyAll();
            sg.m8444b("ContentFetchThread: wakeup");
        }
    }

    public void m6216e() {
        synchronized (this.f4085d) {
            this.f4083b = true;
            sg.m8444b("ContentFetchThread: paused, mPause = " + this.f4083b);
        }
    }

    public boolean m6217f() {
        return this.f4083b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.m6213b();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 == 0) goto L_0x003f;
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.zzv.zzcM();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0.m6199a();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 != 0) goto L_0x0034;
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";
        com.google.android.gms.internal.sg.m8444b(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.m6216e();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0018:
        r0 = r3.f4088g;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0020:
        r1 = r3.f4085d;
        monitor-enter(r1);
    L_0x0023:
        r0 = r3.f4083b;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0056;
    L_0x0027:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.internal.sg.m8444b(r0);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r3.f4085d;	 Catch:{ InterruptedException -> 0x0032 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0032 }
        goto L_0x0023;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0023;
    L_0x0034:
        r3.m6206a(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0038:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.sg.m8445b(r1, r0);
        goto L_0x0020;
    L_0x003f:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.internal.sg.m8444b(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.m6216e();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0048:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.sg.m8445b(r1, r0);
        r1 = r3.f4087f;
        r2 = "ContentFetchTask.run";
        r1.m7922a(r0, r2);
        goto L_0x0020;
    L_0x0056:
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        goto L_0x0000;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fo.run():void");
    }
}
