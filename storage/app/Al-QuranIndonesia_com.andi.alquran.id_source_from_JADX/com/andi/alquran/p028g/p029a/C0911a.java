package com.andi.alquran.p028g.p029a;

import com.andi.alquran.p032j.C0939a;

/* renamed from: com.andi.alquran.g.a.a */
public class C0911a extends C0910d {
    private static final long serialVersionUID = 1;
    private Integer f1807b;
    private String f1808c;
    private String f1809d;
    private long f1810e;
    private long f1811f;

    public C0911a(String str, String str2, Integer num) {
        super(str, str2);
        this.f1810e = 0;
        this.f1811f = 0;
        this.f1807b = num;
        this.f1808c = C0939a.m3272a(str);
        this.f1809d = C0939a.m3274b(str);
    }

    public Integer m3160a() {
        return this.f1807b;
    }

    public void m3161a(String str, Integer num, long j, long j2) {
        this.a = str;
        this.f1807b = num;
        this.f1810e = j;
        this.f1811f = j2;
    }

    public long m3162b() {
        return this.f1810e;
    }

    public long m3163c() {
        return this.f1811f;
    }

    public String m3164d() {
        return this.f1808c;
    }

    public String m3165e() {
        return this.f1809d;
    }
}
