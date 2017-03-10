package com.andi.alquran.p028g.p029a;

import com.andi.alquran.App;
import com.andi.alquran.p032j.C0939a;
import java.io.Serializable;

/* renamed from: com.andi.alquran.g.a.b */
public class C0912b implements Serializable {
    private static final long serialVersionUID = 1;
    public String f1812a;
    public String f1813b;
    public boolean f1814c;
    private int f1815d;
    private String f1816e;
    private int f1817f;
    private long f1818g;
    private long f1819h;
    private String f1820i;
    private String f1821j;
    private boolean f1822k;
    private boolean f1823l;

    public C0912b(String str, int i, String str2, boolean z) {
        this.f1817f = 0;
        this.f1818g = 0;
        this.f1819h = 0;
        this.f1820i = null;
        this.f1821j = null;
        this.f1822k = false;
        this.f1823l = false;
        this.f1814c = false;
        this.f1812a = str;
        this.f1815d = i;
        this.f1816e = App.m2879e(i);
        this.f1813b = str2 + this.f1816e + ".zip";
        this.f1820i = C0939a.m3272a(this.f1816e);
        this.f1821j = C0939a.m3274b(this.f1816e);
        this.f1814c = z;
    }

    public void m3166a(int i) {
        this.f1817f = i;
    }

    public void m3167a(long j) {
        this.f1818g = j;
    }

    public void m3168a(String str) {
        this.f1813b = str;
    }

    public void m3169a(boolean z) {
        this.f1814c = z;
    }

    public boolean m3170a() {
        return this.f1814c;
    }

    public String m3171b() {
        return this.f1812a;
    }

    public void m3172b(long j) {
        this.f1819h = j;
    }

    public void m3173b(boolean z) {
        this.f1822k = z;
    }

    public int m3174c() {
        return this.f1815d;
    }

    public void m3175c(boolean z) {
        this.f1823l = z;
    }

    public String m3176d() {
        return this.f1816e;
    }

    public int m3177e() {
        return this.f1817f;
    }

    public long m3178f() {
        return this.f1819h;
    }

    public String m3179g() {
        return this.f1813b;
    }

    public String m3180h() {
        return this.f1820i;
    }

    public boolean m3181i() {
        return this.f1822k;
    }

    public boolean m3182j() {
        return this.f1823l;
    }
}
