package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.fh.C1563b;
import java.util.Map;
import org.json.JSONObject;

@op
public interface sx extends zzt, C1563b, lm {
    boolean m8741A();

    void m8742B();

    void m8743C();

    OnClickListener m8744D();

    jb m8745E();

    void m8746F();

    WebView m8747a();

    void m8748a(int i);

    void m8749a(Context context);

    void m8750a(Context context, zzec com_google_android_gms_internal_zzec, io ioVar);

    void m8751a(zze com_google_android_gms_ads_internal_overlay_zze);

    void m8752a(jb jbVar);

    void m8753a(tc tcVar);

    void m8754a(zzec com_google_android_gms_internal_zzec);

    void m8755a(String str);

    void m8756a(String str, String str2);

    void m8757a(String str, Map<String, ?> map);

    void m8758a(String str, JSONObject jSONObject);

    void m8759a(boolean z);

    View m8760b();

    void m8761b(int i);

    void m8762b(zze com_google_android_gms_ads_internal_overlay_zze);

    void m8763b(String str);

    void m8764b(boolean z);

    void m8765c();

    void m8766c(boolean z);

    void m8767d();

    void m8768d(boolean z);

    void destroy();

    void m8769e();

    Activity m8770f();

    Context m8771g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    zzd m8772h();

    zze m8773i();

    zze m8774j();

    zzec m8775k();

    sy m8776l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean m8777m();

    void measure(int i, int i2);

    cg m8778n();

    zzqa m8779o();

    void onPause();

    void onResume();

    boolean m8780p();

    int m8781q();

    boolean m8782r();

    void m8783s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    boolean m8784t();

    boolean m8785u();

    String m8786v();

    sw m8787w();

    im m8788x();

    in m8789y();

    tc m8790z();
}
