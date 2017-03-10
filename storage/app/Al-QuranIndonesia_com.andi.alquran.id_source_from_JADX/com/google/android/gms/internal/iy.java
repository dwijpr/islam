package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.jm.C1659a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.List;

@op
public class iy extends C1659a implements C1660a {
    private String f4452a;
    private List<ix> f4453b;
    private String f4454c;
    private jh f4455d;
    private String f4456e;
    private double f4457f;
    private String f4458g;
    private String f4459h;
    private iv f4460i;
    private Bundle f4461j;
    private hg f4462k;
    private View f4463l;
    private Object f4464m;
    private jd f4465n;

    public iy(String str, List list, String str2, jh jhVar, String str3, double d, String str4, String str5, iv ivVar, Bundle bundle, hg hgVar, View view) {
        this.f4464m = new Object();
        this.f4452a = str;
        this.f4453b = list;
        this.f4454c = str2;
        this.f4455d = jhVar;
        this.f4456e = str3;
        this.f4457f = d;
        this.f4458g = str4;
        this.f4459h = str5;
        this.f4460i = ivVar;
        this.f4461j = bundle;
        this.f4462k = hgVar;
        this.f4463l = view;
    }

    public String m6808a() {
        return this.f4452a;
    }

    public void m6809a(jd jdVar) {
        synchronized (this.f4464m) {
            this.f4465n = jdVar;
        }
    }

    public List m6810b() {
        return this.f4453b;
    }

    public String m6811c() {
        return this.f4454c;
    }

    public jh m6812d() {
        return this.f4455d;
    }

    public String m6813e() {
        return this.f4456e;
    }

    public double m6814f() {
        return this.f4457f;
    }

    public String m6815g() {
        return this.f4458g;
    }

    public String m6816h() {
        return this.f4459h;
    }

    public hg m6817i() {
        return this.f4462k;
    }

    public C1108c m6818j() {
        return C1111d.m3896a(this.f4465n);
    }

    public String m6819k() {
        return "2";
    }

    public String m6820l() {
        return BuildConfig.VERSION_NAME;
    }

    public iv m6821m() {
        return this.f4460i;
    }

    public Bundle m6822n() {
        return this.f4461j;
    }

    public View m6823o() {
        return this.f4463l;
    }

    public void m6824p() {
        this.f4452a = null;
        this.f4453b = null;
        this.f4454c = null;
        this.f4455d = null;
        this.f4456e = null;
        this.f4457f = 0.0d;
        this.f4458g = null;
        this.f4459h = null;
        this.f4460i = null;
        this.f4461j = null;
        this.f4464m = null;
        this.f4465n = null;
        this.f4462k = null;
        this.f4463l = null;
    }
}
