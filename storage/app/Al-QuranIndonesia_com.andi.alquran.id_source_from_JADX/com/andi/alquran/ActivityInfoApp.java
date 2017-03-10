package com.andi.alquran;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class ActivityInfoApp extends ActivityBase {

    /* renamed from: com.andi.alquran.ActivityInfoApp.1 */
    class C07541 implements OnClickListener {
        final /* synthetic */ ActivityInfoApp f1206a;

        C07541(ActivityInfoApp activityInfoApp) {
            this.f1206a = activityInfoApp;
        }

        public void onClick(View view) {
            this.f1206a.finish();
        }
    }

    /* renamed from: com.andi.alquran.ActivityInfoApp.2 */
    class C07552 extends WebViewClient {
        final /* synthetic */ ActivityInfoApp f1207a;

        C07552(ActivityInfoApp activityInfoApp) {
            this.f1207a = activityInfoApp;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            if (url == null) {
                return false;
            }
            String uri = url.toString();
            if (!uri.startsWith("http://") && !uri.startsWith("https://") && !uri.startsWith("market://")) {
                return false;
            }
            this.f1207a.startActivity(new Intent("android.intent.action.VIEW", url));
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("market://"))) {
                return false;
            }
            this.f1207a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    /* renamed from: com.andi.alquran.ActivityInfoApp.3 */
    class C07563 implements OnClickListener {
        final /* synthetic */ ActivityInfoApp f1208a;

        C07563(ActivityInfoApp activityInfoApp) {
            this.f1208a = activityInfoApp;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.andi.alquran.id"));
            this.f1208a.startActivity(intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_infoapp);
        Toolbar toolbar = (Toolbar) findViewById(C0861R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new C07541(this));
        }
        WebView webView = (WebView) findViewById(C0861R.id.infoView);
        webView.loadUrl("file:///android_asset/about.html");
        webView.setWebViewClient(new C07552(this));
        ((ImageButton) findViewById(C0861R.id.buttonRate)).setOnClickListener(new C07563(this));
    }
}
