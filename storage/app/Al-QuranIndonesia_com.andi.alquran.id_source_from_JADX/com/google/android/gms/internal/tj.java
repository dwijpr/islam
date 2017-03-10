package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.C1313b;
import java.net.URI;
import java.net.URISyntaxException;

@op
public class tj extends WebViewClient {
    private final String f5965a;
    private boolean f5966b;
    private final sx f5967c;
    private final nx f5968d;

    public tj(nx nxVar, sx sxVar, String str) {
        this.f5965a = m8992b(str);
        this.f5966b = false;
        this.f5967c = sxVar;
        this.f5968d = nxVar;
    }

    private String m8992b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                sg.m8446c(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m8993a(String str) {
        Object b = m8992b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            URI uri = new URI(b);
            if ("passback".equals(uri.getScheme())) {
                sg.m8444b("Passback received");
                this.f5968d.m7807b();
                return true;
            } else if (TextUtils.isEmpty(this.f5965a)) {
                return false;
            } else {
                URI uri2 = new URI(this.f5965a);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!C1313b.m4621a(host, host2) || !C1313b.m4621a(path, path2)) {
                    return false;
                }
                sg.m8444b("Passback received");
                this.f5968d.m7807b();
                return true;
            }
        } catch (URISyntaxException e) {
            sg.m8446c(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::onLoadResource: ";
        String valueOf = String.valueOf(str);
        sg.m8444b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!m8993a(str)) {
            this.f5967c.m8776l().onLoadResource(this.f5967c.m8747a(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::onPageFinished: ";
        String valueOf = String.valueOf(str);
        sg.m8444b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!this.f5966b) {
            this.f5968d.m7804a();
            this.f5966b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        sg.m8444b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!m8993a(str)) {
            return this.f5967c.m8776l().shouldOverrideUrlLoading(this.f5967c.m8747a(), str);
        }
        sg.m8444b("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
