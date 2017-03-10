package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
@op
public class tf extends th {
    public tf(sx sxVar, boolean z) {
        super(sxVar, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return m8991a(webView, str, null);
    }
}
