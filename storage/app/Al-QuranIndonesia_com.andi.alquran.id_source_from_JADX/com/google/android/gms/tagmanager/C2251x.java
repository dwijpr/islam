package com.google.android.gms.tagmanager;

import android.net.Uri;
import android.support.v7.recyclerview.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.google.android.gms.tagmanager.x */
class C2251x {
    private static C2251x f7135a;
    private volatile C2250a f7136b;
    private volatile String f7137c;
    private volatile String f7138d;
    private volatile String f7139e;

    /* renamed from: com.google.android.gms.tagmanager.x.a */
    enum C2250a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    C2251x() {
        m10298e();
    }

    static C2251x m10291a() {
        C2251x c2251x;
        synchronized (C2251x.class) {
            if (f7135a == null) {
                f7135a = new C2251x();
            }
            c2251x = f7135a;
        }
        return c2251x;
    }

    private String m10292a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m10293b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", BuildConfig.VERSION_NAME);
    }

    synchronized boolean m10294a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                String str;
                String valueOf;
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    str = "Container preview url: ";
                    valueOf = String.valueOf(decode);
                    C2238n.m10269d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f7136b = C2250a.CONTAINER_DEBUG;
                    } else {
                        this.f7136b = C2250a.CONTAINER;
                    }
                    this.f7139e = m10293b(uri);
                    if (this.f7136b == C2250a.CONTAINER || this.f7136b == C2250a.CONTAINER_DEBUG) {
                        decode = String.valueOf("/r?");
                        valueOf = String.valueOf(this.f7139e);
                        this.f7138d = valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode);
                    }
                    this.f7137c = m10292a(this.f7139e);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    str = "Invalid preview uri: ";
                    String valueOf2 = String.valueOf(decode);
                    C2238n.m10266b(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    z = false;
                } else if (m10292a(uri.getQuery()).equals(this.f7137c)) {
                    decode = "Exit preview mode for container: ";
                    valueOf = String.valueOf(this.f7137c);
                    C2238n.m10269d(valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode));
                    this.f7136b = C2250a.NONE;
                    this.f7138d = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    C2250a m10295b() {
        return this.f7136b;
    }

    String m10296c() {
        return this.f7138d;
    }

    String m10297d() {
        return this.f7137c;
    }

    void m10298e() {
        this.f7136b = C2250a.NONE;
        this.f7138d = null;
        this.f7137c = null;
        this.f7139e = null;
    }
}
