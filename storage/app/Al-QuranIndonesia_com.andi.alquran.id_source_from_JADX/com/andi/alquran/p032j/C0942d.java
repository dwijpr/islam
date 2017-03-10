package com.andi.alquran.p032j;

/* renamed from: com.andi.alquran.j.d */
public class C0942d {
    private String f1891a;
    private char f1892b;
    private char f1893c;

    public C0942d(String str, char c, char c2) {
        this.f1891a = str;
        this.f1892b = c;
        this.f1893c = c2;
    }

    public String m3278a() {
        return this.f1891a.substring(this.f1891a.lastIndexOf(this.f1892b) + 1, this.f1891a.lastIndexOf(this.f1893c));
    }
}
