package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1385k;
import com.google.android.gms.internal.rx.C1862a;
import java.io.InputStream;

@op
public class ru {
    private final Object f5780a;
    private String f5781b;
    private String f5782c;
    private boolean f5783d;

    /* renamed from: com.google.android.gms.internal.ru.1 */
    class C19791 implements C1862a<String> {
        final /* synthetic */ String f5779a;

        C19791(ru ruVar, String str) {
            this.f5779a = str;
        }

        public String m8625a() {
            String str = "Error getting a response from: ";
            String valueOf = String.valueOf(this.f5779a);
            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return null;
        }

        public String m8626a(InputStream inputStream) {
            String str;
            try {
                str = new String(C1385k.m4957a(inputStream, true), "UTF-8");
                String str2 = this.f5779a;
                sg.m8444b(new StringBuilder((String.valueOf(str2).length() + 49) + String.valueOf(str).length()).append("Response received from server. \nURL: ").append(str2).append("\n Response: ").append(str).toString());
                return str;
            } catch (Throwable e) {
                Throwable th = e;
                String str3 = "Error connecting to url: ";
                str = String.valueOf(this.f5779a);
                sg.m8447c(str.length() != 0 ? str3.concat(str) : new String(str3), th);
                return null;
            }
        }

        public /* synthetic */ Object m8627b() {
            return m8625a();
        }

        public /* synthetic */ Object m8628b(InputStream inputStream) {
            return m8626a(inputStream);
        }
    }

    public ru() {
        this.f5780a = new Object();
        this.f5781b = BuildConfig.VERSION_NAME;
        this.f5782c = BuildConfig.VERSION_NAME;
        this.f5783d = false;
    }

    private Uri m8629a(Context context, String str, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", m8632a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        return buildUpon.build();
    }

    private void m8630f(Context context, String str) {
        zzv.zzcJ().m8510a(context, m8629a(context, (String) C1648if.dc.m6682c(), str));
    }

    public String m8631a() {
        String str;
        synchronized (this.f5780a) {
            str = this.f5782c;
        }
        return str;
    }

    public String m8632a(Context context) {
        String str;
        synchronized (this.f5780a) {
            if (TextUtils.isEmpty(this.f5781b)) {
                this.f5781b = zzv.zzcJ().m8532b(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f5781b)) {
                    this.f5781b = zzv.zzcJ().m8538c();
                    zzv.zzcJ().m8534b(context, "debug_signals_id.txt", this.f5781b);
                }
            }
            str = this.f5781b;
        }
        return str;
    }

    public void m8633a(Context context, String str) {
        if (m8639c(context, str)) {
            sg.m8444b("Device is linked for in app preview.");
        } else {
            m8630f(context, str);
        }
    }

    public void m8634a(Context context, String str, String str2, String str3) {
        Builder buildUpon = m8629a(context, (String) C1648if.df.m6682c(), str3).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzv.zzcJ().m8512a(context, str, buildUpon.build().toString());
    }

    public void m8635a(String str) {
        synchronized (this.f5780a) {
            this.f5782c = str;
        }
    }

    public void m8636a(boolean z) {
        synchronized (this.f5780a) {
            this.f5783d = z;
        }
    }

    public void m8637b(Context context, String str) {
        if (m8640d(context, str)) {
            sg.m8444b("Device is linked for debug signals.");
        } else {
            m8630f(context, str);
        }
    }

    public boolean m8638b() {
        boolean z;
        synchronized (this.f5780a) {
            z = this.f5783d;
        }
        return z;
    }

    boolean m8639c(Context context, String str) {
        Object e = m8641e(context, m8629a(context, (String) C1648if.dd.m6682c(), str).toString());
        if (TextUtils.isEmpty(e)) {
            sg.m8444b("Not linked for in app preview.");
            return false;
        }
        m8635a(e.trim());
        return true;
    }

    boolean m8640d(Context context, String str) {
        Object e = m8641e(context, m8629a(context, (String) C1648if.de.m6682c(), str).toString());
        if (TextUtils.isEmpty(e)) {
            sg.m8444b("Not linked for debug signals.");
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(e.trim());
        m8636a(parseBoolean);
        return parseBoolean;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String m8641e(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = this;
        r5 = 1;
        r0 = new com.google.android.gms.internal.rx;
        r0.<init>(r7);
        r1 = new com.google.android.gms.internal.ru$1;
        r1.<init>(r6, r8);
        r2 = r0.m8665a(r8, r1);
        r0 = com.google.android.gms.internal.C1648if.dg;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r0.m6682c();	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (java.lang.Integer) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r0.intValue();	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (long) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r2.get(r0, r3);	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (java.lang.String) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = move-exception;
        r1 = r0;
        r3 = "Timeout while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x003f;
    L_0x0033:
        r0 = r3.concat(r0);
    L_0x0037:
        com.google.android.gms.internal.sg.m8445b(r0, r1);
        r2.cancel(r5);
    L_0x003d:
        r0 = 0;
        goto L_0x0024;
    L_0x003f:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0037;
    L_0x0045:
        r0 = move-exception;
        r1 = r0;
        r3 = "Interrupted while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x005e;
    L_0x0053:
        r0 = r3.concat(r0);
    L_0x0057:
        com.google.android.gms.internal.sg.m8445b(r0, r1);
        r2.cancel(r5);
        goto L_0x003d;
    L_0x005e:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0057;
    L_0x0064:
        r0 = move-exception;
        r1 = r0;
        r2 = "Error retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r3 = r0.length();
        if (r3 == 0) goto L_0x007a;
    L_0x0072:
        r0 = r2.concat(r0);
    L_0x0076:
        com.google.android.gms.internal.sg.m8445b(r0, r1);
        goto L_0x003d;
    L_0x007a:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ru.e(android.content.Context, java.lang.String):java.lang.String");
    }
}
