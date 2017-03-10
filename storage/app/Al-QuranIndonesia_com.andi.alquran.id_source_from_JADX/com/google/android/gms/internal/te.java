package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.maps.GoogleMap;

@TargetApi(11)
@op
public class te extends WebChromeClient {
    private final sx f5964a;

    /* renamed from: com.google.android.gms.internal.te.1 */
    class C20081 implements OnCancelListener {
        final /* synthetic */ JsResult f5956a;

        C20081(JsResult jsResult) {
            this.f5956a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5956a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.te.2 */
    class C20092 implements OnClickListener {
        final /* synthetic */ JsResult f5957a;

        C20092(JsResult jsResult) {
            this.f5957a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5957a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.te.3 */
    class C20103 implements OnClickListener {
        final /* synthetic */ JsResult f5958a;

        C20103(JsResult jsResult) {
            this.f5958a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5958a.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.te.4 */
    class C20114 implements OnCancelListener {
        final /* synthetic */ JsPromptResult f5959a;

        C20114(JsPromptResult jsPromptResult) {
            this.f5959a = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5959a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.te.5 */
    class C20125 implements OnClickListener {
        final /* synthetic */ JsPromptResult f5960a;

        C20125(JsPromptResult jsPromptResult) {
            this.f5960a = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5960a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.te.6 */
    class C20136 implements OnClickListener {
        final /* synthetic */ JsPromptResult f5961a;
        final /* synthetic */ EditText f5962b;

        C20136(JsPromptResult jsPromptResult, EditText editText) {
            this.f5961a = jsPromptResult;
            this.f5962b = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5961a.confirm(this.f5962b.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.te.7 */
    static /* synthetic */ class C20147 {
        static final /* synthetic */ int[] f5963a;

        static {
            f5963a = new int[MessageLevel.values().length];
            try {
                f5963a[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5963a[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5963a[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5963a[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5963a[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public te(sx sxVar) {
        this.f5964a = sxVar;
    }

    private final Context m8984a(WebView webView) {
        if (!(webView instanceof sx)) {
            return webView.getContext();
        }
        sx sxVar = (sx) webView;
        Context f = sxVar.m8770f();
        return f == null ? sxVar.getContext() : f;
    }

    private static void m8985a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C20103(jsResult)).setNegativeButton(17039360, new C20092(jsResult)).setOnCancelListener(new C20081(jsResult)).create().show();
    }

    private static void m8986a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C20136(jsPromptResult, editText)).setNegativeButton(17039360, new C20125(jsPromptResult)).setOnCancelListener(new C20114(jsPromptResult)).create().show();
    }

    private final boolean m8987a() {
        return zzv.zzcJ().m8524a(this.f5964a.getContext().getPackageManager(), this.f5964a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzv.zzcJ().m8524a(this.f5964a.getContext().getPackageManager(), this.f5964a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void m8988a(View view, int i, CustomViewCallback customViewCallback) {
        zze i2 = this.f5964a.m8773i();
        if (i2 == null) {
            sg.m8449e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        i2.zza(view, customViewCallback);
        i2.setRequestedOrientation(i);
    }

    protected boolean m8989a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                m8986a(context, builder, str2, str3, jsPromptResult);
            } else {
                m8985a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            sg.m8447c("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof sx) {
            zze i = ((sx) webView).m8773i();
            if (i == null) {
                sg.m8449e("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                i.close();
                return;
            }
        }
        sg.m8449e("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String valueOf = String.valueOf(consoleMessage.message());
        String valueOf2 = String.valueOf(consoleMessage.sourceId());
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("JS: ").append(valueOf).append(" (").append(valueOf2).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (valueOf.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C20147.f5963a[consoleMessage.messageLevel().ordinal()]) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                sg.m8446c(valueOf);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                sg.m8449e(valueOf);
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                sg.m8448d(valueOf);
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                sg.m8444b(valueOf);
                break;
            default:
                sg.m8448d(valueOf);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f5964a.m8776l());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, m8987a(), true);
        }
    }

    public final void onHideCustomView() {
        zze i = this.f5964a.m8773i();
        if (i == null) {
            sg.m8449e("Could not get ad overlay when hiding custom view.");
        } else {
            i.zzhi();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m8989a(m8984a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m8989a(m8984a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m8989a(m8984a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m8989a(m8984a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m8988a(view, -1, customViewCallback);
    }
}
