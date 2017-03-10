package com.andi.alquran.p028g.p029a;

import java.io.Serializable;

/* renamed from: com.andi.alquran.g.a.d */
public abstract class C0910d implements Serializable {
    private static final long serialVersionUID = 1;
    String f1804a;
    private String f1805b;
    private boolean f1806c;

    public C0910d(String str, String str2) {
        this.f1806c = false;
        this.f1804a = str;
        this.f1805b = str2;
    }

    public C0910d(String str, String str2, boolean z) {
        this.f1806c = false;
        this.f1804a = str;
        this.f1805b = str2;
        this.f1806c = z;
    }

    public String m3157f() {
        return this.f1804a;
    }

    public String m3158g() {
        return this.f1805b;
    }

    public boolean m3159h() {
        return this.f1806c;
    }
}
