package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.util.C1387m;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@op
public class sf {
    public static final Handler f5831a;
    private static final String f5832b;
    private static final String f5833c;
    private static final String f5834d;
    private static final String f5835e;
    private static final String f5836f;
    private static final String f5837g;

    /* renamed from: com.google.android.gms.internal.sf.a */
    public interface C1961a {
        void m8476a(String str);
    }

    /* renamed from: com.google.android.gms.internal.sf.1 */
    class C19951 implements C1961a {

        /* renamed from: com.google.android.gms.internal.sf.1.1 */
        class C19941 extends Thread {
            final /* synthetic */ String f5830a;

            C19941(C19951 c19951, String str) {
                this.f5830a = str;
            }

            public void run() {
                new sh().m8709a(this.f5830a);
            }
        }

        C19951(sf sfVar) {
        }

        public void m8688a(String str) {
            new C19941(this, str).start();
        }
    }

    static {
        f5831a = new Handler(Looper.getMainLooper());
        f5832b = AdView.class.getName();
        f5833c = InterstitialAd.class.getName();
        f5834d = PublisherAdView.class.getName();
        f5835e = PublisherInterstitialAd.class.getName();
        f5836f = SearchAdView.class.getName();
        f5837g = AdLoader.class.getName();
    }

    private void m8689a(ViewGroup viewGroup, zzec com_google_android_gms_internal_zzec, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m8690a(context, 3);
            frameLayout.addView(textView, new LayoutParams(com_google_android_gms_internal_zzec.f6457g - a, com_google_android_gms_internal_zzec.f6454d - a, 17));
            viewGroup.addView(frameLayout, com_google_android_gms_internal_zzec.f6457g, com_google_android_gms_internal_zzec.f6454d);
        }
    }

    public int m8690a(Context context, int i) {
        return m8691a(context.getResources().getDisplayMetrics(), i);
    }

    public int m8691a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public String m8692a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m8701a()) {
            string = "emulator";
        }
        return m8693a(string);
    }

    public String m8693a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.lang.String m8694a(java.lang.String r6, java.lang.String r7, int r8) {
        /*
        r5 = this;
        r2 = new java.util.StringTokenizer;
        r2.<init>(r6, r7);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r8 + -1;
        if (r8 <= 0) goto L_0x0038;
    L_0x000e:
        r1 = r2.hasMoreElements();
        if (r1 == 0) goto L_0x0038;
    L_0x0014:
        r1 = r2.nextToken();
        r3.append(r1);
    L_0x001b:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x0034;
    L_0x001f:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = ".";
        r0 = r3.append(r0);
        r4 = r2.nextToken();
        r0.append(r4);
        r0 = r1;
        goto L_0x001b;
    L_0x0034:
        r6 = r3.toString();
    L_0x0038:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.sf.a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public String m8695a(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f5832b.equalsIgnoreCase(className2) || f5833c.equalsIgnoreCase(className2) || f5834d.equalsIgnoreCase(className2) || f5835e.equalsIgnoreCase(className2) || f5836f.equalsIgnoreCase(className2) || f5837g.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence a = m8694a(str, ".", 3);
            if (!(className == null || className.contains(a))) {
                return className;
            }
        }
        return null;
    }

    public void m8696a(Context context, String str, String str2, Bundle bundle, boolean z) {
        m8697a(context, str, str2, bundle, z, new C19951(this));
    }

    public void m8697a(Context context, String str, String str2, Bundle bundle, boolean z, C1961a c1961a) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                str = C1261h.m4458b().m4465b(context) + "." + 10084000;
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        c1961a.m8476a(appendQueryParameter.toString());
    }

    public void m8698a(ViewGroup viewGroup, zzec com_google_android_gms_internal_zzec, String str) {
        m8689a(viewGroup, com_google_android_gms_internal_zzec, str, -16777216, -1);
    }

    public void m8699a(ViewGroup viewGroup, zzec com_google_android_gms_internal_zzec, String str, String str2) {
        sg.m8449e(str2);
        m8689a(viewGroup, com_google_android_gms_internal_zzec, str, -65536, -16777216);
    }

    public void m8700a(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public boolean m8701a() {
        return Build.DEVICE.startsWith("generic");
    }

    public int m8702b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m8703b(displayMetrics, i);
    }

    public int m8703b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public boolean m8704b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m8705b(Context context) {
        return C1261h.m4458b().m4460a(context) == 0;
    }

    public boolean m8706c(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public boolean m8707d(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (C1387m.m4963e()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int m8708e(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
