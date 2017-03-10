package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@op
public class nj implements nh {
    final Set<WebView> f5092a;
    private final Context f5093b;

    /* renamed from: com.google.android.gms.internal.nj.1 */
    class C18341 implements Runnable {
        final /* synthetic */ String f5089a;
        final /* synthetic */ String f5090b;
        final /* synthetic */ nj f5091c;

        /* renamed from: com.google.android.gms.internal.nj.1.1 */
        class C18331 extends WebViewClient {
            final /* synthetic */ WebView f5087a;
            final /* synthetic */ C18341 f5088b;

            C18331(C18341 c18341, WebView webView) {
                this.f5088b = c18341;
                this.f5087a = webView;
            }

            public void onPageFinished(WebView webView, String str) {
                sg.m8444b("Loading assets have finished");
                this.f5088b.f5091c.f5092a.remove(this.f5087a);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                sg.m8449e("Loading assets have failed.");
                this.f5088b.f5091c.f5092a.remove(this.f5087a);
            }
        }

        C18341(nj njVar, String str, String str2) {
            this.f5091c = njVar;
            this.f5089a = str;
            this.f5090b = str2;
        }

        public void run() {
            WebView a = this.f5091c.m7766a();
            a.setWebViewClient(new C18331(this, a));
            this.f5091c.f5092a.add(a);
            a.loadDataWithBaseURL(this.f5089a, this.f5090b, "text/html", "UTF-8", null);
            sg.m8444b("Fetching assets finished.");
        }
    }

    public nj(Context context) {
        this.f5092a = Collections.synchronizedSet(new HashSet());
        this.f5093b = context;
    }

    public WebView m7766a() {
        WebView webView = new WebView(this.f5093b);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }

    public void m7767a(String str, String str2, String str3) {
        sg.m8444b("Fetching assets for the given html");
        rq.f5755a.post(new C18341(this, str2, str3));
    }
}
