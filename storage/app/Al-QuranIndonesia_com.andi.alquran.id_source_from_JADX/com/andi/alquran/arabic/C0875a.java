package com.andi.alquran.arabic;

import android.graphics.Bitmap;
import android.support.v4.p014g.C0303f;
import com.google.android.gms.ads.AdRequest;

/* renamed from: com.andi.alquran.arabic.a */
public class C0875a {
    private static C0875a f1633c;
    private C0303f<String, Bitmap> f1634a;
    private C0303f<String, int[]> f1635b;

    private C0875a() {
        this.f1634a = new C0303f(AdRequest.MAX_CONTENT_URL_LENGTH);
        this.f1635b = new C0303f(1024);
    }

    public static C0875a m3035a() {
        if (f1633c == null) {
            f1633c = new C0875a();
        }
        return f1633c;
    }

    public Bitmap m3036a(String str) {
        return (Bitmap) this.f1634a.get(str);
    }

    public void m3037a(String str, Bitmap bitmap) {
        this.f1634a.put(str, bitmap);
    }

    public void m3038a(String str, int[] iArr) {
        this.f1635b.put(str, iArr);
    }

    public void m3039b() {
        this.f1634a.evictAll();
        this.f1635b.evictAll();
    }

    public int[] m3040b(String str) {
        return (int[]) this.f1635b.get(str);
    }
}
