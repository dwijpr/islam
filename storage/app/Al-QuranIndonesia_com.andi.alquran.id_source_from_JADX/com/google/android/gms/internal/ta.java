package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.internal.fh.C1562a;
import java.util.Map;
import org.json.JSONObject;

@op
class ta extends FrameLayout implements sx {
    private static final int f5895a;
    private final sx f5896b;
    private final sw f5897c;

    static {
        f5895a = Color.argb(0, 0, 0, 0);
    }

    public ta(sx sxVar) {
        super(sxVar.getContext());
        this.f5896b = sxVar;
        this.f5897c = new sw(sxVar.m8771g(), this, this);
        sy l = this.f5896b.m8776l();
        if (l != null) {
            l.m8805a((sx) this);
        }
        addView(this.f5896b.m8760b());
    }

    public boolean m8832A() {
        return this.f5896b.m8741A();
    }

    public void m8833B() {
        this.f5896b.m8742B();
    }

    public void m8834C() {
        this.f5896b.m8743C();
    }

    public OnClickListener m8835D() {
        return this.f5896b.m8744D();
    }

    public jb m8836E() {
        return this.f5896b.m8745E();
    }

    public void m8837F() {
        setBackgroundColor(f5895a);
        this.f5896b.setBackgroundColor(f5895a);
    }

    public WebView m8838a() {
        return this.f5896b.m8747a();
    }

    public void m8839a(int i) {
        this.f5896b.m8748a(i);
    }

    public void m8840a(Context context) {
        this.f5896b.m8749a(context);
    }

    public void m8841a(Context context, zzec com_google_android_gms_internal_zzec, io ioVar) {
        this.f5897c.m8740c();
        this.f5896b.m8750a(context, com_google_android_gms_internal_zzec, ioVar);
    }

    public void m8842a(zze com_google_android_gms_ads_internal_overlay_zze) {
        this.f5896b.m8751a(com_google_android_gms_ads_internal_overlay_zze);
    }

    public void m8843a(C1562a c1562a) {
        this.f5896b.m6139a(c1562a);
    }

    public void m8844a(jb jbVar) {
        this.f5896b.m8752a(jbVar);
    }

    public void m8845a(tc tcVar) {
        this.f5896b.m8753a(tcVar);
    }

    public void m8846a(zzec com_google_android_gms_internal_zzec) {
        this.f5896b.m8754a(com_google_android_gms_internal_zzec);
    }

    public void m8847a(String str) {
        this.f5896b.m8755a(str);
    }

    public void m8848a(String str, kg kgVar) {
        this.f5896b.m7287a(str, kgVar);
    }

    public void m8849a(String str, String str2) {
        this.f5896b.m8756a(str, str2);
    }

    public void m8850a(String str, Map<String, ?> map) {
        this.f5896b.m8757a(str, (Map) map);
    }

    public void m8851a(String str, JSONObject jSONObject) {
        this.f5896b.m8758a(str, jSONObject);
    }

    public void m8852a(boolean z) {
        this.f5896b.m8759a(z);
    }

    public View m8853b() {
        return this;
    }

    public void m8854b(int i) {
        this.f5896b.m8761b(i);
    }

    public void m8855b(zze com_google_android_gms_ads_internal_overlay_zze) {
        this.f5896b.m8762b(com_google_android_gms_ads_internal_overlay_zze);
    }

    public void m8856b(String str) {
        this.f5896b.m8763b(str);
    }

    public void m8857b(String str, kg kgVar) {
        this.f5896b.m7290b(str, kgVar);
    }

    public void m8858b(String str, JSONObject jSONObject) {
        this.f5896b.m7291b(str, jSONObject);
    }

    public void m8859b(boolean z) {
        this.f5896b.m8764b(z);
    }

    public void m8860c() {
        this.f5896b.m8765c();
    }

    public void m8861c(boolean z) {
        this.f5896b.m8766c(z);
    }

    public void m8862d() {
        this.f5896b.m8767d();
    }

    public void m8863d(boolean z) {
        this.f5896b.m8768d(z);
    }

    public void destroy() {
        this.f5896b.destroy();
    }

    public void m8864e() {
        this.f5896b.m8769e();
    }

    public Activity m8865f() {
        return this.f5896b.m8770f();
    }

    public Context m8866g() {
        return this.f5896b.m8771g();
    }

    public zzd m8867h() {
        return this.f5896b.m8772h();
    }

    public zze m8868i() {
        return this.f5896b.m8773i();
    }

    public zze m8869j() {
        return this.f5896b.m8774j();
    }

    public zzec m8870k() {
        return this.f5896b.m8775k();
    }

    public sy m8871l() {
        return this.f5896b.m8776l();
    }

    public void loadData(String str, String str2, String str3) {
        this.f5896b.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f5896b.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f5896b.loadUrl(str);
    }

    public boolean m8872m() {
        return this.f5896b.m8777m();
    }

    public cg m8873n() {
        return this.f5896b.m8778n();
    }

    public zzqa m8874o() {
        return this.f5896b.m8779o();
    }

    public void onPause() {
        this.f5897c.m8739b();
        this.f5896b.onPause();
    }

    public void onResume() {
        this.f5896b.onResume();
    }

    public boolean m8875p() {
        return this.f5896b.m8780p();
    }

    public int m8876q() {
        return this.f5896b.m8781q();
    }

    public boolean m8877r() {
        return this.f5896b.m8782r();
    }

    public void m8878s() {
        this.f5897c.m8740c();
        this.f5896b.m8783s();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5896b.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f5896b.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f5896b.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f5896b.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        this.f5896b.stopLoading();
    }

    public boolean m8879t() {
        return this.f5896b.m8784t();
    }

    public boolean m8880u() {
        return this.f5896b.m8785u();
    }

    public String m8881v() {
        return this.f5896b.m8786v();
    }

    public sw m8882w() {
        return this.f5897c;
    }

    public im m8883x() {
        return this.f5896b.m8788x();
    }

    public in m8884y() {
        return this.f5896b.m8789y();
    }

    public tc m8885z() {
        return this.f5896b.m8790z();
    }

    public void zzbV() {
        this.f5896b.zzbV();
    }

    public void zzbW() {
        this.f5896b.zzbW();
    }
}
