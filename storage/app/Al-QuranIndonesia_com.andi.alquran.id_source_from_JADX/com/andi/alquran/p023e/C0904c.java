package com.andi.alquran.p023e;

/* renamed from: com.andi.alquran.e.c */
public class C0904c {
    int f1780a;
    String f1781b;

    public C0904c(int i, String str) {
        this.f1780a = i;
        if (str == null || str.trim().length() == 0) {
            this.f1781b = C0903b.m3116a(i);
        } else {
            this.f1781b = str + " (response: " + C0903b.m3116a(i) + ")";
        }
    }

    public String m3138a() {
        return this.f1781b;
    }

    public boolean m3139b() {
        return this.f1780a == 0;
    }

    public boolean m3140c() {
        return !m3139b();
    }

    public String toString() {
        return "IabResult: " + m3138a();
    }
}
