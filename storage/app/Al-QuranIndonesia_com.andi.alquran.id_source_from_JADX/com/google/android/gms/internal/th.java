package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@TargetApi(11)
@op
public class th extends sy {
    public th(sx sxVar, boolean z) {
        super(sxVar, z);
    }

    protected WebResourceResponse m8990a(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzv.zzcJ().m8498a(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new rx(context).m8666a(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    protected WebResourceResponse m8991a(WebView webView, String str, Map<String, String> map) {
        Exception e;
        String valueOf;
        if (webView instanceof sx) {
            sx sxVar = (sx) webView;
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (sxVar.m8776l() != null) {
                sxVar.m8776l().m8829o();
            }
            String str2 = sxVar.m8775k().f6455e ? (String) C1648if.f4356T.m6682c() : sxVar.m8780p() ? (String) C1648if.f4355S.m6682c() : (String) C1648if.f4354R.m6682c();
            try {
                return m8990a(sxVar.getContext(), sxVar.m8779o().f6636b, str2);
            } catch (IOException e2) {
                e = e2;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                sg.m8449e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                sg.m8449e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                sg.m8449e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                sg.m8449e(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
        }
        sg.m8449e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }
}
